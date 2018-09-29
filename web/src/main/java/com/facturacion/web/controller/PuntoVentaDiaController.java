package com.facturacion.web.controller;

import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.PrintException;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.web.model.Activacion;
import com.facturacion.web.model.Cliente;
import com.facturacion.web.model.Configuracion;
import com.facturacion.web.model.Documento;
import com.facturacion.web.model.DocumentoDetalle;
import com.facturacion.web.model.Empresa;
import com.facturacion.web.model.InfoDiario;
import com.facturacion.web.model.Producto;
import com.facturacion.web.model.Rol;
import com.facturacion.web.model.SubProducto;
import com.facturacion.web.model.Usuario;
import com.facturacion.web.service.ActivacionService;
import com.facturacion.web.service.ClienteService;
import com.facturacion.web.service.ConfiguracionService;
import com.facturacion.web.service.ConsecutivoDianService;
import com.facturacion.web.service.DocumentoDetalleService;
import com.facturacion.web.service.DocumentoService;
import com.facturacion.web.service.EmpresaService;
import com.facturacion.web.service.InformeDiarioService;
import com.facturacion.web.service.ProductoService;
import com.facturacion.web.service.RolService;
import com.facturacion.web.service.UsuarioService;
import com.facturacion.web.service.impl.UsuarioServiceImpl;
import com.facturacion.web.utils.Calculos;
import com.facturacion.web.utils.Impresion;
import com.facturacion.web.utils.ImpresionFull;
import com.facturacion.web.utils.RestResponse;
import com.facturacion.web.vo.DocumentoDetalleVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.DocumentException;

@RestController
public class PuntoVentaDiaController {

	private static Logger log = Logger.getLogger(PuntoVentaDiaController.class);

	@Autowired
	protected ClienteService clienteService;

	@Autowired
	protected ProductoService productoService;

	@Autowired
	protected DocumentoDetalleService documentoDetalleService;

	@Autowired
	protected DocumentoService documentoService;

	@Autowired
	protected InformeDiarioService informeDiarioService;

	@Autowired
	protected ConfiguracionService configuracionService;

	@Autowired
	protected UsuarioService usuarioService;

	@Autowired
	protected EmpresaService empresaService;
	
	@Autowired
	protected ConsecutivoDianService consecutivoDianService;
	
	
	

	protected ObjectMapper objectMapper;

	@RequestMapping(value = "/saveOrUpdateDocumento", method = RequestMethod.POST)
	@CrossOrigin
	public Documento saveOrUpdateDocumento(@RequestBody String documento) throws IOException {
		objectMapper = new ObjectMapper();
		Documento document = this.objectMapper.readValue(documento, Documento.class);
		documentoService.saveOrUpdate(document);
		return document;
	}

	@RequestMapping(value = "/getClientesAll", method = RequestMethod.GET)
	@CrossOrigin
	public List<Cliente> getClientesAll() {
		log.info("todos los clientes");
		return clienteService.getByAll();
	}

	@RequestMapping(value = "/getProductosAll", method = RequestMethod.GET)
	@CrossOrigin
	public List<Producto> getProductosAll() {
		log.info("todos los productos");
		return productoService.getByAll();
	}

	@RequestMapping(value = "/getDocumentoById", method = RequestMethod.GET)
	@CrossOrigin
	public Documento getDocumentoById(@RequestParam("documentoId") String documentoId) {
		return documentoService.getById(Long.valueOf(documentoId));
	}

	@RequestMapping(value = "/getProductoById", method = RequestMethod.GET)
	@CrossOrigin
	public Producto getProductoById(@RequestParam("productoId") String productoId) {
		return productoService.getProductoById(productoId);
	}

	@RequestMapping(value = "/agregarDocumentoDetalle", method = RequestMethod.POST)
	@CrossOrigin
	public DocumentoDetalleVo agregarDocumentoDetalle(@RequestBody String documentoDe, HttpSession session)
			throws IOException {
		objectMapper = new ObjectMapper();
		Producto productoSelect2 = new Producto();
		Configuracion configuracion = (Configuracion) session.getAttribute("configuracion");
		DocumentoDetalle docDetalle = this.objectMapper.readValue(documentoDe, DocumentoDetalle.class);

		Producto productoSelect = productoService.getProductoById("" + docDetalle.getProductoId());
		Long server = 1l;// configuracion.getServer();
		Boolean promo = Calculos.validarPromo(productoSelect, docDetalle.getCantidad());
		// TODO aqui va la parte para determinar server2
		if (promo) {
			Double precioPromo = productoSelect.getPubPromo();
			Double cantidadPromo = productoSelect.getkGPromo();
			Double unitarioPromo = precioPromo / cantidadPromo;
			docDetalle.setUnitario(unitarioPromo);
			docDetalle.setParcial(docDetalle.getCantidad() * unitarioPromo);
		} else {
			if (docDetalle.getCantidad() != null && productoSelect.getCostoPublico() != null) {
				docDetalle.setParcial(docDetalle.getCantidad() * productoSelect.getCostoPublico());
				docDetalle.setUnitario(productoSelect.getCostoPublico());
			} else {
				docDetalle.setParcial(0.0);
			}
		}
		// logica de calcular cantidades del server2
		// logica de cantidades del server2
		Double newCantidad2 = 0.0;
		if (productoSelect2 != null) {
			newCantidad2 = productoSelect2.getCantidad() == null ? 0.0 : productoSelect2.getCantidad();
		}

		Double newCantidad = productoSelect.getCantidad();

		docDetalle.setS1(1l);
		docDetalle.setS2(0l);
		docDetalle.setCantidad2(0.0);
		docDetalle.setCantidad1(docDetalle.getCantidad());

		Producto proCantidad = productoSelect;
		Producto proCantidad2 = productoSelect2;
		proCantidad.setCantidad(newCantidad - docDetalle.getCantidad1());
		restarCantidadesSubProducto(docDetalle, server);
		documentoDetalleService.saveOrUpdate(docDetalle);
		productoService.update(proCantidad);
		if (server == 2l && proCantidad2 != null) {
			proCantidad2.setCantidad(newCantidad2 - docDetalle.getCantidad2());
			// TODO completar productoService.update(proCantidad2, 2l);
		}
		Documento documento = documentoService.getById(docDetalle.getDocumentoId());
		List<DocumentoDetalle> list = documentoDetalleService.getByDocumentoId(docDetalle.getDocumentoId());
		List<DocumentoDetalleVo> listVo = new ArrayList<>();
		DocumentoDetalleVo docDetalleReturn = new DocumentoDetalleVo();
		docDetalleReturn.setCantidad1(docDetalle.getCantidad());
		docDetalleReturn.setCantidad2(0.0);
		docDetalleReturn.setCantidad(docDetalle.getCantidad());
		docDetalleReturn.setProductoId(productoSelect.getProductoId());
		docDetalleReturn.setNombreProducto(productoSelect.getNombre());
		docDetalleReturn.setDocumentoId(docDetalle.getDocumentoId());
		docDetalleReturn.setFechaRegistro(new Date());
		docDetalleReturn.setDocumentoDetalleId(docDetalle.getDocumentoDetalleId());
		docDetalleReturn.setUnitario(docDetalle.getUnitario());
		docDetalleReturn.setParcial(docDetalle.getParcial());
		for (DocumentoDetalle l : list) {
			DocumentoDetalleVo docDetalleVo = new DocumentoDetalleVo();
			docDetalleVo.setIva(productoSelect.getIva());
			docDetalleVo.setCantidad1(l.getCantidad());
			docDetalleVo.setCantidad2(0.0);
			docDetalleVo.setCantidad(l.getCantidad());
			docDetalleVo.setProductoId(productoSelect.getProductoId());
			docDetalleVo.setNombreProducto(productoSelect.getNombre());
			docDetalleVo.setDocumentoId(l.getDocumentoId());
			docDetalleVo.setFechaRegistro(new Date());
			docDetalleVo.setDocumentoDetalleId(l.getDocumentoDetalleId());
			docDetalleVo.setUnitario(l.getUnitario());
			docDetalleVo.setParcial(l.getParcial());
			listVo.add(docDetalleVo);
		}
		documento = Calculos.calcularExcento(documento, listVo);
		documentoService.saveOrUpdate(documento);
		return docDetalleReturn;
	}

	/**
	 * Metodo que actualiza y resta las cantidades de inventario de los subproductos
	 * 
	 * @param productoSelect3
	 */
	private void restarCantidadesSubProducto(DocumentoDetalle productoSelect3, Long server) {
		// TODO hacer los metoos de service de subproducto y agregarlos lo de
		// subproducto
		// List<SubProducto> subProductos = productoService
		// .subProductoByProducto(productoSelect3.getProductoId());
		// for (SubProducto s : subProductos) {
		// Double cantidadAnterior = s.getProductoHijo().getCantidad();
		// Double cantidadNueva = cantidadAnterior - (s.getCantidad() *
		// productoSelect3.getCantidad());
		// s.getProductoHijo().setCantidad(cantidadNueva);
		// DocumentoDetalle docDetalle = new DocumentoDetalle();
		// docDetalle.setCantidad1(s.getCantidad() * productoSelect3.getCantidad());
		// docDetalle.setCantidad(s.getCantidad() * productoSelect3.getCantidad());
		// docDetalle.setDocumentoId(getDocumento());
		// docDetalle.setEstado(1l);
		// docDetalle.setFechaRegistro(new Date());
		// docDetalle.setProductoId(s.getProductoHijo());
		// documentoDetalleService.save(docDetalle, server);
		// productoService.update(s.getProductoHijo(), 1l);
		// }
	}

	@RequestMapping(value = "/imprimirFactura", method = RequestMethod.POST)
	@CrossOrigin
	public RestResponse imprimirFactura(@RequestBody String document) throws IOException {
		objectMapper = new ObjectMapper();
		ImpresionFull impresionFull = new ImpresionFull();
		Documento documento = this.objectMapper.readValue(document, Documento.class);
		RestResponse response = new RestResponse(200,"");
		Configuracion configuracion = configuracionService.getById(1l);
		Long numeroImpresiones = configuracion.getNumImpresion() == null ? 1l : configuracion.getNumImpresion();
		Empresa empresa = empresaService.getById(1l);
		Long server = configuracion.getServer();
		// TODO sacar la impresora del equipo;
		String impresora = "";
		String tituloFactura = "";
		documento.setImpreso(1l);
		documento.setEntregado(0l);
		if (documento.getTipoDocumentoId() == null) {
			documento.setTipoDocumentoId(10l);// si tipodoc es null se asiga factura por defecto
		}
		switch (documento.getTipoDocumentoId().toString()) {
		case "9":
			documento.setConsecutivoDian("" + documento.getDocumentoId());
			log.info("consecutivo documentoId: " + documento.getDocumentoId());
			tituloFactura = "No. DE GUIA";
			documento.setReduccion(1l);
			break;
		case "10":
			Long con = consecutivoDianService.getconsecutivoDian().getConsecutivoDianId();
			// dentro de try se valida si faltan 500 facturas para
			// llegar hasta el tope
			try {
				Long topeConsecutivo = Long.valueOf(empresa.getAutorizacionHasta()==null?"999999":empresa.getAutorizacionHasta());
				Long consegutivo = con;
				if (consegutivo + 500 > topeConsecutivo) {
					log.info("Se esta agotando el consegutivo DIAN");
					response.setMessage("Se esta agotando el consegutivo DIAN");
				}

			} catch (Exception e2) {
				log.error("Error asignando el consecutivo Dian: " + e2);
			}
			String consecutivoDian = (empresa.getLetraConsecutivo()==null?"":empresa.getLetraConsecutivo()) + con;
			log.info("consecutivo Dian: " + consecutivoDian);
			documento.setConsecutivoDian(consecutivoDian);
			tituloFactura = "FACTURA DE VENTA";
			documento.setReduccion(0l);
			server = 1l;
			break;
		case "4":
			documento.setConsecutivoDian("" + documento.getDocumentoId());
			log.info("consecutivo Cotizacion: " + documento.getDocumentoId());
			tituloFactura = "No. DE COTIZACIÓN";
			server = 1l;
			break;
		default:
			log.error("tipo documento invalido en impresion factura");
			break;
		}
		// tipo de pago
		if (documento.getTipoPagoId() == 2l) {
			numeroImpresiones = 2l;
		}
		// se manda a que se agregue el documento a la suma del informe diario parcial
		calcularInfoDiario(empresa, documento, configuracion);
		String imp = empresa.getImpresion().toUpperCase();

		List<DocumentoDetalle> list = documentoDetalleService.getByDocumentoId(documento.getDocumentoId());
		Usuario usuario = usuarioService.getById("" + documento.getUsuarioId());
		List<DocumentoDetalleVo> listVo = listVo(list);
		listVo = Calculos.ordenar(listVo);
		try {
			for (int i = 0; i < numeroImpresiones; i++) { // si la factura fue a credito se imprime dos veces
				switch (imp) {
				case "TXT":
					// Impresion.imprimirTxt(documento, listVo, usuario, configuracion,
					// impresora,empresa);
					break;
				case "BIG":
					// quitar la dependencia del ireport
					// imprimirTemporal(tituloFactura);
					// pdf = imprimirBig(tituloFactura);
					break;
				case "PDF":
					// se i
					impresionFull.imprimirPDF(documento, listVo, usuario, configuracion, impresora, empresa, "false");
					//Impresion.imprimirPDF(documento, listVo, usuario, configuracion, impresora, empresa, "false");
					break;
				case "BIG_PDF":
					// Impresion.imprimirBig(getDocumento(), getProductos(), usuario(),
					// configuracion, descuentoEnFactura,
					// impresora);
					break;
				case "SMALL_PDF":
					// Impresion.imprimirPDFSmall(getDocumento(), getProductos(), usuario(),
					// configuracion, impresora);
					break;
				default:
					break;

				}

			}
		} catch (DocumentException e) {
			log.error("Error imprimiendo: "+e.getMessage());
			RestResponse r = new  RestResponse(500);
			r.setMessage("Error imprimiendo: "+e.getStackTrace());
			return r;
		}
		return response;
	}

	private List<DocumentoDetalleVo> listVo(List<DocumentoDetalle> list) {

		List<DocumentoDetalleVo> listVo = new ArrayList<>();
		for (DocumentoDetalle l : list) {
			DocumentoDetalleVo docDetalleVo = new DocumentoDetalleVo();
			docDetalleVo.setIva(0.0);
			docDetalleVo.setCantidad1(l.getCantidad());
			docDetalleVo.setCantidad2(0.0);
			docDetalleVo.setCantidad(l.getCantidad());
			docDetalleVo.setProductoId(l.getProductoId());
			docDetalleVo.setNombreProducto("");
			docDetalleVo.setDocumentoId(l.getDocumentoId());
			docDetalleVo.setFechaRegistro(new Date());
			docDetalleVo.setDocumentoDetalleId(l.getDocumentoDetalleId());
			docDetalleVo.setUnitario(l.getUnitario());
			docDetalleVo.setParcial(l.getParcial());
			listVo.add(docDetalleVo);
		}
		return listVo;
	}

	private void calcularInfoDiario(Empresa e, Documento documento, Configuracion configuracion) {
		Date fechaDocumento = documento.getFechaRegistro();
		Date fechaInicio = Calculos.fechaInicial(fechaDocumento, configuracion);
		Date fechaFinal = Calculos.fechaFinal(fechaDocumento, configuracion);
		List<InfoDiario> infoList = informeDiarioService.buscarInfodiarioByFecha(fechaInicio, fechaFinal);
		try {
			log.info("inicio actualizacion info diario");
			InfoDiario infoDiario = Calculos.calcularInfoDiario(documento, infoList, e);
			informeDiarioService.saveOrUpdate(infoDiario);
			log.info("fin actualizacion info diario");
		} catch (Exception e1) {
			log.error("Error calculando registro de informe diario" + e1.getStackTrace().toString());
		}
	}

}
