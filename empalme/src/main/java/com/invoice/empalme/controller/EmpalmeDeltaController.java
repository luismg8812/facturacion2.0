package com.invoice.empalme.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.invoice.empalme.model.invoice.Documento;
import com.invoice.empalme.model.invoice.DocumentoDetalle;
import com.invoice.empalme.model.invoice.Producto;
import com.invoice.empalme.model.invoice.Receptor;
import com.invoice.empalme.service.invoice.DocumentoDetalleService;
import com.invoice.empalme.service.invoice.DocumentoInvoiceService;
import com.invoice.empalme.service.invoice.ProductoService;
import com.invoice.empalme.service.invoice.ReceptorService;
import com.invoice.empalme.utils.RestResponse;
import com.invoice.empalme.vo.DocumentoDeltaVo;

@Controller
public class EmpalmeDeltaController {
	
	private static Logger log = Logger.getLogger(EmpalmeNiceSoftwareController.class);
	protected ObjectMapper objectMapper;
	
	@Autowired
	protected DocumentoInvoiceService documentoInvoiceService;
	
	@Autowired
	protected  ReceptorService receptorService;
	
	@Autowired
	protected  DocumentoDetalleService documentoDetalleService;
	
	@Autowired
	protected  ProductoService productoService;
	
	
	@RequestMapping(value = "/empalmeDelta", method = RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<?> saveOrUpdateDocumento(@RequestBody String document) throws IOException {
		objectMapper = new ObjectMapper();
		RestResponse restResponse = new RestResponse(200, "");
		Documento documento=new Documento();
		try {
			DocumentoDeltaVo documentovo = this.objectMapper.readValue(document, DocumentoDeltaVo.class);
			if(documentovo.getDocumentoId().getNumeroDocumento()==null ||documentovo.getDocumentoId().getNumeroDocumento().isEmpty()) {
				restResponse.setMessage("el numero de documento es obligatorio");
				restResponse.setResponseCode(500);
				return new ResponseEntity<RestResponse>(restResponse, HttpStatus.BAD_REQUEST);
			}else {
				List<Documento>number=documentoInvoiceService.getByNumber(documentovo.getDocumentoId().getNumeroDocumento());
				if( !number.isEmpty()) {
					restResponse.setMessage("ya existe un documento para el numero de documento enviado");
					restResponse.setResponseCode(500);
					return new ResponseEntity<RestResponse>(restResponse, HttpStatus.BAD_REQUEST);
				}
				
			}
			String receptorId= documentovo.getDocumentoId().getReceptorId().getIdentificacion();
			if(receptorId==null) {
				restResponse.setMessage("el receptor es obligatorio");
				restResponse.setResponseCode(500);
				return new ResponseEntity<RestResponse>(restResponse, HttpStatus.BAD_REQUEST);
			}			
			Receptor receptor = receptorService.getByIdentificacion(""+receptorId);
			if(receptor==null ) {
				Receptor receptor2 = new Receptor();
				receptor2.setNombre(documentovo.getDocumentoId().getReceptorId().getNombre());
				receptor2.setIdentificacion(""+receptorId);
				receptorService.save(receptor2);
				receptor=receptor2;
			}
		    documento = documentovo.getDocumentoId();
			documento.setReceptorId(receptor);
			List<DocumentoDetalle> documentoDetalles= documentovo.getDocumentoDetalleId();
			
			documentoInvoiceService.saveOrUpdate(documento);
			for(DocumentoDetalle dd: documentoDetalles) {
				String productoId = dd.getProductoId().getCodigoInterno();
				if(productoId==null ||productoId.isEmpty()) {
					restResponse.setMessage("el código interno del producto es obligatorio");
					restResponse.setResponseCode(500);
					documentoInvoiceService.delete(documento);
					return new ResponseEntity<RestResponse>(restResponse, HttpStatus.BAD_REQUEST);
				}	
				Producto producto = productoService.getByCodigoInterno(productoId);
				if(producto==null ) {
					Producto producto2 = new Producto();
					producto2.setNombre(dd.getProductoId().getNombre());
					producto2.setCodigoInterno(productoId);
					productoService.update(producto2);
					producto=producto2;
				}
				dd.setDocumentoId( documento);
				dd.setProductoId(producto);
				dd.setFechaRegistro(new Date());
				documentoDetalleService.saveOrUpdate(dd);
				log.info("detalle creado: "+ dd.getDocumentoDetalleId());
			}
			log.info("documento creado: "+ documento.getDocumentoId());	
			restResponse.setMessage("documento "+documento.getDocumentoId()+" agregado correctamente");
			return new ResponseEntity<RestResponse>(restResponse, HttpStatus.OK);
		} catch (Exception e) {
			restResponse.setMessage("Error en la estructura del body");
			restResponse.setResponseCode(500);
			if(documento.getDocumentoId()!=null) {
				documentoInvoiceService.delete(documento);
			}
			new ResponseEntity<RestResponse>(restResponse, HttpStatus.BAD_REQUEST);
			return new ResponseEntity<RestResponse>(restResponse, HttpStatus.BAD_REQUEST);
		}	
	}

}
