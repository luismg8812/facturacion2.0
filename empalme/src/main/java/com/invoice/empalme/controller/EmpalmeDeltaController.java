package com.invoice.empalme.controller;

import java.io.IOException;

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
import com.invoice.empalme.service.invoice.DocumentoInvoiceService;
import com.invoice.empalme.utils.RestResponse;
import com.invoice.empalme.vo.DocumentoDeltaVo;

@Controller
public class EmpalmeDeltaController {
	
	private static Logger log = Logger.getLogger(EmpalmeNiceSoftwareController.class);
	protected ObjectMapper objectMapper;
	
	@Autowired
	protected DocumentoInvoiceService documentoInvoiceService;
	
	
	@RequestMapping(value = "/empalmeDelta", method = RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<?> saveOrUpdateDocumento(@RequestBody String document) throws IOException {
		objectMapper = new ObjectMapper();
		RestResponse restResponse = new RestResponse(200, "");
		DocumentoDeltaVo documentovo = this.objectMapper.readValue(document, DocumentoDeltaVo.class);
		log.info("documento creado: "+ documentovo.getDocumentoId());
		Documento documento = documentovo.getDocumentoId();
		//documentoInvoiceService.
		return new ResponseEntity<RestResponse>(restResponse, HttpStatus.OK);
	}

}
