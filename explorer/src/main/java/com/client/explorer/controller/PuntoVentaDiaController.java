package com.client.explorer.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.client.explorer.model.Cliente;
import com.client.explorer.model.Documento;
import com.client.explorer.model.DocumentoDetalle;
import com.client.explorer.model.Producto;
import com.client.explorer.utils.BasicConfiguration;
import com.client.explorer.utils.ImpresionFull;
import com.client.explorer.utils.RestResponse;
import com.client.explorer.vo.DocumentoDetalleVo;
import com.client.explorer.vo.ImpresionFacturaVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.text.DocumentException;


@RestController
public class PuntoVentaDiaController {

	private static Logger log = Logger.getLogger(PuntoVentaDiaController.class);
	private static final String HTTP = "http://";

	protected ObjectMapper objectMapper;
	
	@Autowired
	private BasicConfiguration configuration;

	@RequestMapping(value = "/saveOrUpdateDocumento", method = RequestMethod.POST)
	@CrossOrigin
	public Documento saveOrUpdateDocumento(@RequestBody String document) throws IOException {
		objectMapper = new ObjectMapper();
		Documento documento = this.objectMapper.readValue(document, Documento.class);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Documento> requestBody = new HttpEntity<>(documento);
		documento= restTemplate.postForObject(HTTP+ configuration.getServerHost()+":"+configuration.getServerPort()+ "/saveOrUpdateDocumento",requestBody, Documento.class);
		log.info("documento creado: "+ documento.getDocumentoId());
		return documento;
	}

	@RequestMapping(value = "/getClientesAll", method = RequestMethod.GET)
	@CrossOrigin
	public List<Cliente> getClientesAll() {		
		RestTemplate restTemplate = new RestTemplate();
		String list= restTemplate.getForObject(
				HTTP + configuration.getServerHost() + ":" + configuration.getServerPort() + "/getClientesAll", String.class);	
		Gson gson = new Gson();         
        Type type = new TypeToken<List<Cliente>>() {}.getType();
        return gson.fromJson(list, type);
	}

	@RequestMapping(value = "/getProductosAll", method = RequestMethod.GET)
	@CrossOrigin
	public List<Producto> getProductosAll() {
		RestTemplate restTemplate = new RestTemplate();
		String list= restTemplate.getForObject(
				HTTP + configuration.getServerHost() + ":" + configuration.getServerPort() + "/getProductosAll", String.class);	
		Gson gson = new Gson();         
        Type type = new TypeToken<List<Producto>>() {}.getType();
        return gson.fromJson(list, type);
	}

	@RequestMapping(value = "/getDocumentoById", method = RequestMethod.GET)
	@CrossOrigin
	public Documento getDocumentoById(@RequestParam("documentoId") String documentoId) {
		RestTemplate restTemplate = new RestTemplate();
		Documento temp= restTemplate.getForObject(HTTP+ configuration.getServerHost()+":"+configuration.getServerPort()+ "/getDocumentoById?documentoId="+documentoId, Documento.class); 
		log.info("Documento:"+temp.getDocumentoId());
		return temp;
	}

	@RequestMapping(value = "/getProductoById", method = RequestMethod.GET)
	@CrossOrigin
	public Producto getProductoById(@RequestParam("productoId") String productoId) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(HTTP+ configuration.getServerHost()+":"+configuration.getServerPort()+ "/getProductoById?productoId="+productoId, Producto.class);
	}

	@RequestMapping(value = "/agregarDocumentoDetalle", method = RequestMethod.POST)
	@CrossOrigin
	public DocumentoDetalleVo agregarDocumentoDetalle(@RequestBody String documentoDe) throws IOException {
		objectMapper = new ObjectMapper();
		DocumentoDetalle documentoDetalle = this.objectMapper.readValue(documentoDe, DocumentoDetalle.class);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<DocumentoDetalle> requestBody = new HttpEntity<>(documentoDetalle);
		return restTemplate.postForObject(HTTP+ configuration.getServerHost()+":"+configuration.getServerPort()+ "/agregarDocumentoDetalle",requestBody, DocumentoDetalleVo.class);
	}
	
	@RequestMapping(value = "/agregarx01", method = RequestMethod.POST)
	@CrossOrigin
	public DocumentoDetalleVo agregarx01(@RequestBody String documentoDe) throws IOException {
		objectMapper = new ObjectMapper();
		DocumentoDetalle documentoDetalle = this.objectMapper.readValue(documentoDe, DocumentoDetalle.class);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<DocumentoDetalle> requestBody = new HttpEntity<>(documentoDetalle);
		return restTemplate.postForObject(HTTP+ configuration.getServerHost()+":"+configuration.getServerPort()+ "/agregarx01",requestBody, DocumentoDetalleVo.class);
	}

	

	@RequestMapping(value = "/imprimirFactura", method = RequestMethod.POST)
	@CrossOrigin
	public RestResponse imprimirFactura(@RequestBody String document) throws IOException {
		RestResponse response = new RestResponse(200, "");
		objectMapper = new ObjectMapper();
		Documento documento= this.objectMapper.readValue(document, Documento.class);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Documento> requestBody = new HttpEntity<>(documento);
		ImpresionFacturaVo impresionFacturaVo= restTemplate.postForObject(HTTP+ configuration.getServerHost()+":"+configuration.getServerPort()+ "/imprimirFactura",requestBody, ImpresionFacturaVo.class);
		response.setMessage(impresionFacturaVo.getMensaje()==null?"":impresionFacturaVo.getMensaje());
		log.info("IMPRESION response:"+impresionFacturaVo.getDocumentoId().getDocumentoId()+": "+response.getMessage());
		String imp = impresionFacturaVo.getEmpresa().getImpresion().toUpperCase();
		ImpresionFull impresionFull = new ImpresionFull();
		try {
			for (int i = 0; i < impresionFacturaVo.getNumeroImpresioes(); i++) { // si la factura fue a credito se imprime dos veces
				switch (imp) {
				case "TXT":
					//TODO hacer la impresion en txt				
					break;
				case "BIG":
					//TODO hacer la impresion grande
					break;
				case "PDF":					
					impresionFull.imprimirPDF(impresionFacturaVo);
					break;
				case "BIG_PDF":
					//TODO hacer la impresion pdf big
					break;
				case "SMALL_PDF":
					//hacer la impresosion pdf small
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

	

}
