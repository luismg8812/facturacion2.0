package com.invoice.electonic.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invoice.electonic.model.Documento;
import com.invoice.electonic.model.Empresa;
import com.invoice.electonic.service.DocumentoService;
import com.invoice.electonic.service.EmpresaService;
import com.invoice.electonic.utils.Calculos;
import com.invoice.electonic.utils.DefaultNamespacePrefixMapper;

import co.gov.dian.contratos.facturaelectronica.v1.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UBLVersionIDType;

@Controller
public class Invoice2Controller {

	private static Logger log = Logger.getLogger(Invoice2Controller.class);
	private static final  String  RUTA_FACTURAS_XML = "C:\\effectiveSoftware\\facturacion\\facturas\\facturacionElectronica\\invoice";

	@Autowired
	protected DocumentoService documentoService;

	@Autowired
	protected EmpresaService empresaService;
	

	private Empresa empresa;

	@RequestMapping("/createInvoice2")
	public String getIndexPage() {
		log.info("construllendo xml");
		try {
			// se traen las facturas sin procesar
			List<Documento> documentos = documentoService.getByEstado(1l);
			log.info("se encuentran : " + documentos.size() + " para procesar");
			JAXBContext contexto = JAXBContext.newInstance("co.gov.dian.contratos.facturaelectronica.v1");
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DefaultNamespacePrefixMapper());
			marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
			marshaller.setProperty("com.sun.xml.bind.xmlHeaders","<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
			for (Documento d : documentos) {
				String nombreFactura = nombrarFacturaXML(d);
				log.info("se crea documento: " + nombreFactura);				
				InvoiceType invoice = createInvoice(d, marshaller);
				marshaller.marshal(invoice, System.out);
				File folder = new File(RUTA_FACTURAS_XML);
				folder.mkdirs();
				OutputStream os = new FileOutputStream(RUTA_FACTURAS_XML+nombreFactura);
				marshaller.marshal( invoice, os );
				envioSWDIAN2(RUTA_FACTURAS_XML+nombreFactura);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	private InvoiceType createInvoice(Documento documento, Marshaller marshaller) {

		InvoiceType invoice = new InvoiceType();
		log.info("se asignan tag a la factura");
		invoice.setUBLVersionID(ublVersionIDType());
		invoice.setCustomizationID(customizationIDType());
		//invoice.setProfileID(profileIDType());
		// invoice.setID(idType(documento));
		// invoice.setUUID(cufe(documento));
		// invoice.setIssueDate(issueDateType(documento));
		// invoice.setIssueTime(issueTimeType(documento));
		// invoice.setInvoiceTypeCode(invoiceTypeCodeType());
		// invoice.setDocumentCurrencyCode(documentCurrencyCodeType());
		// invoice.setAccountingSupplierParty(accountingSupplierParty(documento));
		// invoice.setAccountingCustomerParty(customerPartyType());
		// invoice.getTaxTotal().add(taxTotalTypes(documento));
		// invoice.setLegalMonetaryTotal(monetaryTotalType(documento));
		// invoice.getInvoiceLine().add(invoiceLineType(documento));
		//
		// //se arman de ultimo los extencion
		// invoice.setUBLExtensions(ublExtensions(documento,marshaller));
		return invoice;
	}

	private UBLVersionIDType ublVersionIDType() {
		UBLVersionIDType ublVersionIDType = new UBLVersionIDType();
		ublVersionIDType.setValue("UBL 2.0");
		return ublVersionIDType;
	}
	
	private CustomizationIDType customizationIDType() {
		CustomizationIDType customizationIDType = new CustomizationIDType();
		customizationIDType.setSchemeDataURI("http://www.dian.gov.co/micrositios/fac_electronica/documentos/");
		customizationIDType.setSchemeID("XSD/r1/DIAN_UBL.xsd");
		customizationIDType.setSchemeName("xsd aplicado a este documento-e. - xsi:schemaLocation. - cambios en la cardinalidad de algunos elementos");
		customizationIDType.setSchemeURI("http://www.dian.gov.co/");
		customizationIDType.setValue("CustomizationID");
		return customizationIDType;
	}

	private String nombrarFacturaXML(Documento d) {
		String face = "face_f";
		String nit = Calculos.completarDescripcion(getEmpresa().getNit(), 10);
		String numeroHex = Calculos.completarDescripcion(Long.toHexString(new Long(d.getNumeroDocumento())), 10);
		return face + nit + numeroHex+".xml";
	}
	
	
	 

	
	private String envioSWDIAN2(String ruta) throws DatatypeConfigurationException, JAXBException {
		
		

		return "";
	}
	

	public Empresa getEmpresa() {
		if (empresa == null) {
			empresa = empresaService.getById(1l);
		}
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
