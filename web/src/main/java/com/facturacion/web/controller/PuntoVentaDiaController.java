package com.facturacion.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.facturacion.web.model.Producto;
import com.facturacion.web.model.Rol;
import com.facturacion.web.model.SubProducto;
import com.facturacion.web.model.Usuario;
import com.facturacion.web.service.ActivacionService;
import com.facturacion.web.service.ClienteService;
import com.facturacion.web.service.DocumentoDetalleService;
import com.facturacion.web.service.DocumentoService;
import com.facturacion.web.service.ProductoService;
import com.facturacion.web.service.RolService;
import com.facturacion.web.service.UsuarioService;
import com.facturacion.web.service.impl.UsuarioServiceImpl;
import com.facturacion.web.utils.Calculos;
import com.facturacion.web.utils.RestResponse;
import com.facturacion.web.vo.DocumentoDetalleVo;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	protected ObjectMapper objectMapper;
	
	@RequestMapping(value="/saveOrUpdateDocumento", method=RequestMethod.POST )
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
		Long server = 1l;//configuracion.getServer();
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
			//TODO completar productoService.update(proCantidad2, 2l);
		}
		Documento documento = documentoService.getById(docDetalle.getDocumentoId());
		List<DocumentoDetalle> list = documentoDetalleService.getByDocumentoId(docDetalle.getDocumentoId());
		List<DocumentoDetalleVo> listVo =new  ArrayList<>();
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

}
