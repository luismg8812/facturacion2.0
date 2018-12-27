
package com.invoice.electonic.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.List;

import javax.activation.DataHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invoice.electonic.client.InvoiceWSClient;
import com.invoice.electonic.model.Documento;
import com.invoice.electonic.model.DocumentoDetalle;
import com.invoice.electonic.model.Empresa;
import com.invoice.electonic.model.Receptor;
import com.invoice.electonic.service.DocumentoDetalleService;
import com.invoice.electonic.service.DocumentoService;
import com.invoice.electonic.service.EmpresaService;
import com.invoice.electonic.service.ReceptorService;
import com.invoice.electonic.utils.DefaultNamespacePrefixMapper;
import com.invoice.electonic.utils.InvoiceGeneratorUtils;
import com.invoice.electonic.utils.ZipManager;

import co.gov.dian.contratos.facturaelectronica.v1.InvoiceType;

@Controller
public class Invoice2Controller {

	private static Logger log = Logger.getLogger(Invoice2Controller.class);
	private static final  String  RUTA_FACTURAS_XML = "C:\\effectiveSoftware\\facturacion\\facturas\\facturacionElectronica\\invoice\\";

	@Autowired
	protected DocumentoService documentoService;

	@Autowired
	protected EmpresaService empresaService;

	@Autowired
	protected ReceptorService receptorService;
	
	@Autowired
	protected DocumentoDetalleService documentoDetalleService;

	@RequestMapping("/createInvoice2")
	public String getIndexPage() {
		System.out.println("construyendo xml");
		try {
			Empresa empresa = empresaService.getById(1l);
			
			// se traen las facturas sin procesar
			List<Documento> documentos = documentoService.getByEstado(1l);
			log.info("se encuentran : " + documentos.size() + " para procesar");
			JAXBContext contexto = JAXBContext.newInstance("co.gov.dian.contratos.facturaelectronica.v1");
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DefaultNamespacePrefixMapper());
			marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
			marshaller.setProperty("com.sun.xml.bind.xmlHeaders","<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
			for (Documento documento : documentos) {
				String nombreFactura = InvoiceGeneratorUtils.nombrarFacturaXML(documento, empresa);
				log.info("se crea documento: " + nombreFactura);				
				InvoiceType invoice = createInvoice(documento, empresa, marshaller);
				marshaller.marshal(invoice, System.out);
				
				//creacion del archivo fisico xml
				File folder = new File(RUTA_FACTURAS_XML);
				folder.mkdirs();
				OutputStream facturaFisica = new FileOutputStream(RUTA_FACTURAS_XML + nombreFactura);
				
				//se escribe el XML DIAN
				marshaller.marshal(invoice, facturaFisica);
				
				//creacion del ZIP para enviar a la DIAN
				//ZipManager.ZipFileTradicional(RUTA_FACTURAS_XML, nombreFactura);
				ZipManager.ZipFileZip4j(RUTA_FACTURAS_XML + nombreFactura);
				nombreFactura = nombreFactura.replaceAll(".xml", ".zip");

				InvoiceWSClient.envioSWDIAN2(RUTA_FACTURAS_XML + nombreFactura, empresa.getNit(), invoice.getID().getValue());	//envio factura DIAN
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	private InvoiceType createInvoice(Documento documento, Empresa empresa, Marshaller marshaller) 
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, UnrecoverableEntryException, JAXBException, ParserConfigurationException, javax.security.cert.CertificateException, IOException {
		Receptor receptor = receptorService.getById(documento.getReceptorId());

		List<DocumentoDetalle> ListaDocumentoDetalle = documentoDetalleService.getByDocumentId(documento.getDocumentoId());
				
		InvoiceType invoice = new InvoiceType();
		log.info("se asignan tag a la factura");
		invoice.setUBLVersionID(InvoiceGeneratorUtils.ublVersionIDType());
		invoice.setCustomizationID(InvoiceGeneratorUtils.customizationIDType());
		invoice.setProfileID(InvoiceGeneratorUtils.profileIDType());
		invoice.setID(InvoiceGeneratorUtils.idType(documento));
		invoice.setIssueDate(InvoiceGeneratorUtils.issueDateType(documento));
		invoice.setIssueTime(InvoiceGeneratorUtils.issueTimeType(documento));
		invoice.setInvoiceTypeCode(InvoiceGeneratorUtils.invoiceTypeCodeType());
		invoice.setDocumentCurrencyCode(InvoiceGeneratorUtils.documentCurrencyCodeType());
		
		//Revisar estos 2 metodos a ver como se pueden escribir mejor
		invoice.setAccountingSupplierParty(InvoiceGeneratorUtils.accountingSupplierParty(documento, empresa));
		invoice.setAccountingCustomerParty(InvoiceGeneratorUtils.customerPartyType(receptor));
		
		invoice = InvoiceGeneratorUtils.OrderingTaxesAndLegalMonetaryTotal(documento, invoice, ListaDocumentoDetalle);
		
		//Elemento InvoiceLine, el ultimito que se crea
		invoice.getInvoiceLine().add(InvoiceGeneratorUtils.invoiceLineType(invoice.getTaxTotal(), invoice.getLegalMonetaryTotal().getLineExtensionAmount().getValue()));

		invoice.setUUID(InvoiceGeneratorUtils.cufe(documento, invoice));
		
		//se arman de ultimo los extension
		invoice.setUBLExtensions(InvoiceGeneratorUtils.ublExtensions(documento, empresa, marshaller));
		return invoice;
	}
}
