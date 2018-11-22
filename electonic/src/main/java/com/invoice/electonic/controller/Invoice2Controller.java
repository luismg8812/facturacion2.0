package com.invoice.electonic.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.activation.DataHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

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
import com.invoice.electonic.ws.dian.AcuseRecibo;
import com.invoice.electonic.ws.dian.EnvioFacturaElectronica;
import com.invoice.electonic.ws.dian.ObjectFactory;
import com.invoice.electonic.ws.dian.config.SOAPConnector;

import co.gov.dian.contratos.facturaelectronica.v1.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UBLVersionIDType;

@Controller
public class Invoice2Controller {

	private static Logger log = Logger.getLogger(Invoice2Controller.class);
	private static final  String  RUTA_FACTURAS_XML = "C:\\effectiveSoftware\\facturacion\\facturas\\facturacionElectronica\\invoice";

	@Autowired
	protected DocumentoService documentoService;

	@Autowired
	protected EmpresaService empresaService;
	
	@Autowired
	SOAPConnector soapConnector;

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
		// invoice.setCustomizationID(customizationIDType(documento));
		// invoice.setProfileID(profileIDType());
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

	private String nombrarFacturaXML(Documento d) {
		String face = "face_f";
		String nit = Calculos.completarDescripcion(getEmpresa().getNit(), 10);
		String numeroHex = Calculos.completarDescripcion(Long.toHexString(new Long(d.getNumeroDocumento())), 10);
		return face + nit + numeroHex+".xml";
	}
	
	@SuppressWarnings("unchecked")
	private String envioSWDIAN2(String ruta) throws DatatypeConfigurationException, JAXBException {
		ObjectFactory objectFactory = new ObjectFactory();		
		EnvioFacturaElectronica envioFacturaElectronica = objectFactory.createEnvioFacturaElectronica();
		envioFacturaElectronica.setInvoiceNumber("123");
		 DataHandler dataHandler = null;
		 envioFacturaElectronica.setNIT("76305531");
		 envioFacturaElectronica.setDocument(dataHandler);
		envioFacturaElectronica.setIssueDate(DatatypeFactory.newInstance().newXMLGregorianCalendar());
		JAXBElement<EnvioFacturaElectronica> recuest = objectFactory.createEnvioFacturaElectronicaPeticion(envioFacturaElectronica);
		JAXBContext contexto = JAXBContext.newInstance("com.invoice.electonic.ws.dian");
		Marshaller marshaller = contexto.createMarshaller();
		marshaller.marshal(recuest, System.out);
		AcuseRecibo response =   soapConnector.callWebService("https://facturaelectronica.dian.gov.co/habilitacion/B2BIntegrationEngine/FacturaElectronica/", recuest);
		log.info(response.getComments());
		return "";
	}
	
	//kevin
	private String envioSWDIAN(String ruta) {
//		 FacturaElectronicaPortNameService ss = new FacturaElectronicaPortNameService();
//	        FacturaElectronicaPortName port = ss.getFacturaElectronicaPortNameSoap11();
//	        
//	        Client client = ClientProxy.getClient(port);
//	        
//	        Map<String, List<String>> headers = new HashMap<String, List<String>>();	       
//	        headers.put("Content-Length", Arrays.asList("3342"));
//	         headers.put("Content-Type", Arrays.asList("text/xml;charset=UTF-8"));  
//	         headers.put("SOAPAction", Arrays.asList(""));
//	         headers.put("soapAction", Arrays.asList(""));
//	         headers.put("Host", Arrays.asList("192.168.250.65:9080"));
//	         headers.put("Accept-Encoding", Arrays.asList("gzip,deflate"));
//	         
//	        client.getRequestContext().put(Message.PROTOCOL_HEADERS, headers);
//	        
//	        
//	        Endpoint cxfEndpoint = client.getEndpoint();
//	        
//	               
//	        Map<String, Object> outProps = new HashMap<String, Object>();
//	        outProps.put(WSHandlerConstants.ACTION,WSHandlerConstants.USERNAME_TOKEN);
//	        // Specify our username
//	        outProps.put(WSHandlerConstants.USER, "54a7fd82-9ea1-498d-9d03-35fc75097a3d");
//	        // Password type : plain text
//	        outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
//	        // Callback used to retrieve password for given user.
//	        outProps.put(WSHandlerConstants.ADD_USERNAMETOKEN_NONCE, "true");
//	        outProps.put(WSHandlerConstants.ADD_USERNAMETOKEN_CREATED, "true");
//	        outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,ClientePasswordCallback.class.getName());
//	             
//	     // 
//	        
//	        
//	        WSS4JOutInterceptor wsOut = new WSS4JOutInterceptor(outProps);
//	        cxfEndpoint.getOutInterceptors().add(wsOut);
//	        	
//	        
//   
//	        System.out.println("Invoking envioFacturaElectronica...");
//	        EnvioFacturaElectronica envioFacturaElectronica = new co.gov.dian.servicios.facturaelectronica.reportarfactura.EnvioFacturaElectronica();
//	        envioFacturaElectronica.setNIT("76305531");
//	        envioFacturaElectronica.setInvoiceNumber("123");
//	        try {
//	        	envioFacturaElectronica.setIssueDate(DatatypeFactory.newInstance().newXMLGregorianCalendar());
//			} catch (DatatypeConfigurationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        DataHandler dataHandler = null;
//	        envioFacturaElectronica.setDocument(dataHandler);
//	        AcuseRecibo acuseRecibo = port.envioFacturaElectronica(envioFacturaElectronica);
//	        System.out.println("envioFacturaElectronica.result=" + acuseRecibo);
//
//		
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
