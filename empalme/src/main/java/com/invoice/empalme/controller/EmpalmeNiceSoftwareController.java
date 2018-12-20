package com.invoice.empalme.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invoice.empalme.model.invoice.Receptor;
import com.invoice.empalme.model.nicesoftware.Documento;
import com.invoice.empalme.service.invoice.DocumentoInvoiceService;
import com.invoice.empalme.service.invoice.ReceptorService;
import com.invoice.empalme.service.nicesoftware.DocumentoOracleService;




@Controller
public class EmpalmeNiceSoftwareController {
	
	private static Logger log = Logger.getLogger(EmpalmeNiceSoftwareController.class);
	
	@Autowired
	protected DocumentoOracleService documentoService;
	
	@Autowired
	protected DocumentoInvoiceService documentoInvoiceService;
	
	@Autowired
	protected  ReceptorService receptorService;

	@RequestMapping("/empalmeNicesoftware")
	public String invoiceQuesera() {
		log.info("inicia facturacion electronica para documentos.");
		List<Documento> documentos=documentoService.getByinvoice();
		List<Documento> invoicesError = new ArrayList<>();
		log.info("se encontraron:"+ documentos.size()+" documentos.");
		for(Documento documento: documentos) {
			try {
				com.invoice.empalme.model.invoice.Documento invoice = new com.invoice.empalme.model.invoice.Documento();
				//se consulta si el receptor ya existe else if se crea
				String clienteIdentificacion = documento.getClienteId()==null?"0":documento.getClienteId().getDocumento(); 			
				String clienteNombre = documento.getClienteId()==null?"0":documento.getClienteId().getNombre();
				Receptor receptor = receptorService.getByIdentificacion(clienteIdentificacion);
				if(receptor==null ) {
					Receptor receptor2 = new Receptor();
					receptor2.setNombre(clienteNombre);
					receptor2.setIdentificacion(clienteIdentificacion);
					receptorService.save(receptor2);
					receptor=receptor2;
				}
				invoice.setReceptorId(receptor);
				invoice.setBase19(documento.getBase19());
				invoice.setBase5(documento.getBase5());
				invoice.setExento(documento.getExcento());
				invoice.setFechaRegistro(documento.getFechaRegistro());
				invoice.setFechaActualiza(new Date());
				invoice.setGravado(documento.getGravado());
				invoice.setIva(documento.getInteres());
				invoice.setIva19(documento.getIva19());
				invoice.setIva5(documento.getIva5());
				invoice.setNumeroDocumento(documento.getConsecutivoDian());
				invoice.setPrefijo("");
				invoice.setTipoDocumentoId(1l);
				invoice.setTotal(documento.getTotal());
				documentoInvoiceService.saveOrUpdate(invoice);
				documento.setInvoice(1l);
				documentoService.saveOrUpdate(documento);
			} catch (Exception e) {
				log.error("error ingresando el documento nicesoft id: "+documento.getDocumentoId());
				invoicesError.add(documento);
			}		
		}	
		log.info("se agregaron documentos a facturacion , erroneos: "+invoicesError.size()+" de: "+documentos.size());
		return "index";
	}
}