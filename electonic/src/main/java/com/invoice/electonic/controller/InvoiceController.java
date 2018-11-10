package com.invoice.electonic.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.security.cert.CertificateException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.etsi.uri._01903.v1_3.AnyType;
import org.etsi.uri._01903.v1_3.CertIDListType;
import org.etsi.uri._01903.v1_3.CertIDType;
import org.etsi.uri._01903.v1_3.ClaimedRolesListType;
import org.etsi.uri._01903.v1_3.DigestAlgAndValueType;
import org.etsi.uri._01903.v1_3.ObjectIdentifierType;
import org.etsi.uri._01903.v1_3.QualifyingPropertiesType;
import org.etsi.uri._01903.v1_3.SignaturePolicyIdType;
import org.etsi.uri._01903.v1_3.SignaturePolicyIdentifierType;
import org.etsi.uri._01903.v1_3.SignedPropertiesType;
import org.etsi.uri._01903.v1_3.SignedSignaturePropertiesType;
import org.etsi.uri._01903.v1_3.SignerRoleType;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3._2000._09.xmldsig_.CanonicalizationMethodType;
import org.w3._2000._09.xmldsig_.DigestMethodType;
import org.w3._2000._09.xmldsig_.KeyInfoType;
import org.w3._2000._09.xmldsig_.ObjectType;
import org.w3._2000._09.xmldsig_.ReferenceType;
import org.w3._2000._09.xmldsig_.SignatureMethodType;
import org.w3._2000._09.xmldsig_.SignatureType;
import org.w3._2000._09.xmldsig_.SignatureValueType;
import org.w3._2000._09.xmldsig_.SignedInfoType;
import org.w3._2000._09.xmldsig_.TransformType;
import org.w3._2000._09.xmldsig_.TransformsType;
import org.w3._2000._09.xmldsig_.X509DataType;
import org.w3._2000._09.xmldsig_.X509IssuerSerialType;
import org.w3._2000._09.xmldsig_.X509IssuerSerialType1;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.invoice.electonic.model.Documento;
import com.invoice.electonic.service.DocumentoService;
import com.invoice.electonic.utils.DefaultNamespacePrefixMapper;

import co.gov.dian.contratos.facturaelectronica.v1.AddressType;
import co.gov.dian.contratos.facturaelectronica.v1.CustomerPartyType;
import co.gov.dian.contratos.facturaelectronica.v1.InvoiceLineType;
import co.gov.dian.contratos.facturaelectronica.v1.InvoiceType;
import co.gov.dian.contratos.facturaelectronica.v1.ItemType;
import co.gov.dian.contratos.facturaelectronica.v1.LocationType;
import co.gov.dian.contratos.facturaelectronica.v1.MonetaryTotalType;
import co.gov.dian.contratos.facturaelectronica.v1.PartyLegalEntityType;
import co.gov.dian.contratos.facturaelectronica.v1.PartyTaxSchemeType;
import co.gov.dian.contratos.facturaelectronica.v1.PartyType;
import co.gov.dian.contratos.facturaelectronica.v1.PersonType;
import co.gov.dian.contratos.facturaelectronica.v1.SupplierPartyType;
import co.gov.dian.contratos.facturaelectronica.v1.TaxSubtotalType;
import co.gov.dian.contratos.facturaelectronica.v1.TaxTotalType;
import co.gov.dian.contratos.facturaelectronica.v1.structures.AuthrorizedInvoices;
import co.gov.dian.contratos.facturaelectronica.v1.structures.DianExtensionsType;
import co.gov.dian.contratos.facturaelectronica.v1.structures.InvoiceControl;
import co.gov.dian.contratos.facturaelectronica.v1.structures.SoftwareProvider;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ContactType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PricingReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdditionalAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AllowanceTotalAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CityNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CitySubdivisionNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CountrySubentityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ElectronicMailType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FamilyNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FirstNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FreeOfChargeIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IdentificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoiceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PostalZoneType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProfileIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEvidenceIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxInclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxLevelCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TelephoneType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TextType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UBLVersionIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UUIDType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionsType;
import un.unece.uncefact.codelist.specification._54217._2001.CurrencyCodeContentType;
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.IdentifierType;

@Controller
public class InvoiceController {

	private static Logger log = Logger.getLogger(InvoiceController.class);
	
	@Autowired
	protected DocumentoService documentoService;


	@RequestMapping("/createInvoice")
	public String getIndexPage() throws KeyStoreException, NoSuchAlgorithmException, java.security.cert.CertificateException, FileNotFoundException, UnrecoverableEntryException, IOException {
		log.info("construllendo xml");
		try {
			Documento documento = documentoService.getById(161L);
			log.info("se crea la factura: "+documento.getDocumentoId());			
			JAXBContext contexto = JAXBContext.newInstance("co.gov.dian.contratos.facturaelectronica.v1");
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DefaultNamespacePrefixMapper());
			InvoiceType invoice = createInvoice(documento,marshaller);
			invoice.getUBLExtensions().getUBLExtension().get(0).getExtensionContent().setAny(dianExtension());
			invoice.getUBLExtensions().getUBLExtension().get(1).getExtensionContent().setAny(signature());
			log.info("inicio factura completa");
			marshaller.marshal(invoice, System.out);
			log.info("fin factura completa");
		} catch (PropertyException|ParserConfigurationException|CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}

	private InvoiceType createInvoice(Documento documento,Marshaller marshaller) {
		
		InvoiceType invoice = new InvoiceType();
		log.info("se asignan tag a la factura");		
		invoice.setUBLVersionID(ublVersionIDType());
		//invoice.setCustomizationID(customizationIDType(documento));
		invoice.setProfileID(profileIDType());
		invoice.setID(idType(documento));		
		invoice.setUUID(cufe(documento));
		invoice.setIssueDate(issueDateType(documento));
		invoice.setIssueTime(issueTimeType(documento));
		invoice.setInvoiceTypeCode(invoiceTypeCodeType());
		invoice.setDocumentCurrencyCode(documentCurrencyCodeType());
		invoice.setAccountingSupplierParty(accountingSupplierParty(documento));
		invoice.setAccountingCustomerParty(customerPartyType());
		invoice.getTaxTotal().add(taxTotalTypes(documento));
		invoice.setLegalMonetaryTotal(monetaryTotalType(documento));
		invoice.getInvoiceLine().add(invoiceLineType(documento));
		
		//se arman de ultimo los extencion
		invoice.setUBLExtensions(ublExtensions(documento,marshaller));
		return invoice;
	}
	
	private InvoiceLineType invoiceLineType(Documento documento) {
		InvoiceLineType invoiceLineType = new InvoiceLineType();
		IDType idType = new IDType();
		InvoicedQuantityType invoicedQuantityType = new InvoicedQuantityType(); 
		LineExtensionAmountType lineExtensionAmountType = new LineExtensionAmountType();
		FreeOfChargeIndicatorType freeOfChargeIndicatorType = new FreeOfChargeIndicatorType(); 
		freeOfChargeIndicatorType.setValue(false);
		invoicedQuantityType.setUnitCode("S8");
		invoicedQuantityType.setValue(new BigDecimal("234"));
		lineExtensionAmountType.setCurrencyID(CurrencyCodeContentType.COP);
		lineExtensionAmountType.setValue(new BigDecimal("100000.000"));
		idType.setValue("1");
		invoiceLineType.setID(idType);
		invoiceLineType.setInvoicedQuantity(invoicedQuantityType);
		invoiceLineType.setLineExtensionAmount(lineExtensionAmountType);
		invoiceLineType.setFreeOfChargeIndicator(freeOfChargeIndicatorType);
		invoiceLineType.setPricingReference(new PricingReferenceType());
		invoiceLineType.getTaxTotal().add(taxTotalType(documento));
		invoiceLineType.setItem(new ItemType());
		return invoiceLineType;
	}
	
	private oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType taxTotalType(Documento documento){
		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType taxTotalType = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType();
		TaxAmountType amountType = new TaxAmountType();
		TaxEvidenceIndicatorType evidenceIndicatorType = new TaxEvidenceIndicatorType();
		evidenceIndicatorType.setValue(false);
		amountType.setCurrencyID(CurrencyCodeContentType.COP); //tipo de moneda -ok
		amountType.setValue(new BigDecimal("19000.000"));
		taxTotalType.setTaxAmount(amountType);		
		taxTotalType.setTaxEvidenceIndicator(evidenceIndicatorType);		
		return taxTotalType;
	}
	
	private MonetaryTotalType monetaryTotalType(Documento documento ) {
		MonetaryTotalType monetaryTotalType = new MonetaryTotalType();
		LineExtensionAmountType lineExtensionAmountType = new LineExtensionAmountType();
		TaxExclusiveAmountType exclusiveAmountType = new TaxExclusiveAmountType();
		TaxInclusiveAmountType inclusiveAmountType = new TaxInclusiveAmountType();
		AllowanceTotalAmountType allowanceTotalAmountType = new AllowanceTotalAmountType();
		PayableAmountType payableAmountType = new PayableAmountType();
		payableAmountType.setCurrencyID(CurrencyCodeContentType.COP);
		payableAmountType.setValue(new BigDecimal("113000.000"));
		allowanceTotalAmountType.setCurrencyID(CurrencyCodeContentType.COP);
		allowanceTotalAmountType.setValue(new BigDecimal("0.000"));
		inclusiveAmountType.setCurrencyID(CurrencyCodeContentType.COP);
		inclusiveAmountType.setValue(new BigDecimal("100000.000"));
		exclusiveAmountType.setCurrencyID(CurrencyCodeContentType.COP);
		exclusiveAmountType.setValue(new BigDecimal("119000.000"));
		lineExtensionAmountType.setCurrencyID(CurrencyCodeContentType.COP);
		lineExtensionAmountType.setValue(new BigDecimal("100000.000"));
		monetaryTotalType.setLineExtensionAmount(lineExtensionAmountType);
		monetaryTotalType.setTaxExclusiveAmount(exclusiveAmountType);
		monetaryTotalType.setTaxInclusiveAmount(inclusiveAmountType);
		monetaryTotalType.setAllowanceTotalAmount(allowanceTotalAmountType);
		monetaryTotalType.setPayableAmount(payableAmountType);
		return monetaryTotalType;
	}
	
	private TaxTotalType taxTotalTypes(Documento documento){		
		TaxTotalType taxTotalTypes = new TaxTotalType();
		TaxAmountType amountType = new TaxAmountType();
		TaxEvidenceIndicatorType evidenceIndicatorType = new TaxEvidenceIndicatorType();
		evidenceIndicatorType.setValue(false);
		amountType.setCurrencyID(CurrencyCodeContentType.COP); //tipo de moneda -ok
		amountType.setValue(new BigDecimal("19000.000"));
		taxTotalTypes.setTaxAmount(amountType);		
		taxTotalTypes.setTaxEvidenceIndicator(evidenceIndicatorType);
		taxTotalTypes.getTaxSubtotal().add(taxSubtotalType());
		return taxTotalTypes;
	}
	
	private TaxSubtotalType taxSubtotalType() {
		TaxSubtotalType taxSubtotalType = new TaxSubtotalType();
		TaxableAmountType taxableAmountType = new TaxableAmountType();
		TaxAmountType amountType = new TaxAmountType();
		PercentType percentType = new PercentType();
		TaxCategoryType categoryType = new TaxCategoryType();
		TaxSchemeType taxSchemeType = new TaxSchemeType();
		IDType idType = new IDType();
		TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
		taxTypeCodeType.setValue("01"); //valor quedamo creo que siempre es 01 por el iva 
		idType.setSchemeDataURI("http://www.dian.gov.co"); // valor quemado -ok
		idType.setSchemeName("VALOR TOTAL DE IVA"); // valor quedamo -ok
		idType.setValue("01");  //valor quedado para iva -ok
		taxSchemeType.setID(idType);
		taxSchemeType.setTaxTypeCode(taxTypeCodeType);
		categoryType.setTaxScheme(taxSchemeType);
		percentType.setValue(new BigDecimal("19")); // porcentaje de impuesto cobrado
		amountType.setCurrencyID(CurrencyCodeContentType.COP); //tipo de moneda -ok
		amountType.setValue(new BigDecimal("19000.000"));
		taxableAmountType.setCurrencyID(CurrencyCodeContentType.COP); // tipo de moneda -ok
		taxableAmountType.setValue(new BigDecimal("100000.000")); // base del impuesto esto esta en el documento
		taxSubtotalType.setTaxableAmount(taxableAmountType);
		taxSubtotalType.setTaxAmount(amountType);
		taxSubtotalType.setPercent(percentType);
		taxSubtotalType.setTaxCategory(categoryType);
		return taxSubtotalType;
	}
	
	private Element dianExtension() throws JAXBException, ParserConfigurationException {		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.newDocument();		
		JAXBContext contexto = JAXBContext.newInstance("co.gov.dian.contratos.facturaelectronica.v1.structures");
		Marshaller marshaller = contexto.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DefaultNamespacePrefixMapper());
		DianExtensionsType dianExtensionsType = dianExtensionsType(null);
		marshaller.marshal( dianExtensionsType, doc );
		Node invoce= doc.getFirstChild();
		//marshaller.marshal(dianExtensionsType, System.out);
		//log.info(invoce.getNodeName());
		return (Element)invoce;
	}
	
	private Element signature() throws ParserConfigurationException, JAXBException, CertificateException, KeyStoreException, NoSuchAlgorithmException, java.security.cert.CertificateException, FileNotFoundException, UnrecoverableEntryException, IOException  {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.newDocument();
        JAXBContext contexto = JAXBContext.newInstance("org.w3._2000._09.xmldsig_");
		Marshaller marshaller = contexto.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DefaultNamespacePrefixMapper());
		SignatureType signatureType = signatureType();
		marshaller.marshal( signatureType, doc );
		Node invoce= doc.getFirstChild();
		//marshaller.marshal(signatureType, System.out);
		log.info(invoce.getNodeName());
		return (Element)invoce;
	}
	
	private SignatureType signatureType() throws CertificateException, KeyStoreException, NoSuchAlgorithmException, java.security.cert.CertificateException, UnrecoverableEntryException, IOException, ParserConfigurationException, JAXBException {
		SignatureType signatureType= new SignatureType();
		signatureType.setId("xmldsig-1c324973-9df9-412b-bc75-46e0669e1254");
		signatureType.setSignedInfo(signedInfoType());
		signatureType.setSignatureValue(signatureValueType());
		signatureType.setKeyInfo(keyInfoType());
		signatureType.getObject().add(objectType());
		return signatureType;
		
	}
	
	private ObjectType objectType() throws ParserConfigurationException, JAXBException {			
		ObjectType objectType= new ObjectType();
		objectType.getContent().add(qualifyingPropertiesType());
		return objectType;
	}
	
	private Element qualifyingPropertiesType() throws JAXBException, ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.newDocument();
        JAXBContext contexto = JAXBContext.newInstance("org.etsi.uri._01903.v1_3");
		Marshaller marshaller = contexto.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DefaultNamespacePrefixMapper());
		
		
		SignedPropertiesType signedPropertiesType = new SignedPropertiesType();
		signedPropertiesType.setId("xmldsig-9ba23b0d-66d0-41de-94b8-d4403c002553-signedprops");
		signedPropertiesType.setSignedSignatureProperties(signedSignaturePropertiesType());
		QualifyingPropertiesType qualifyingPropertiesType =  new QualifyingPropertiesType();
		qualifyingPropertiesType.setSignedProperties(signedPropertiesType);
		qualifyingPropertiesType.setTarget("#xmldsig-9ba23b0d-66d0-41de-94b8-d4403c002553");
		marshaller.marshal( qualifyingPropertiesType, doc );
		Node invoce= doc.getFirstChild();
		return  (Element) invoce;
	}
	
	private SignedSignaturePropertiesType signedSignaturePropertiesType() {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SignedSignaturePropertiesType signedSignaturePropertiesType = new SignedSignaturePropertiesType();
		signedSignaturePropertiesType.setSigningTime(date2);
		signedSignaturePropertiesType.setSigningCertificate(certIDListType());
		signedSignaturePropertiesType.setSignaturePolicyIdentifier(signaturePolicyIdentifierType());
		signedSignaturePropertiesType.setSignerRole(signerRoleType());
		return signedSignaturePropertiesType;
	}
	
	private SignerRoleType signerRoleType() {
		SignerRoleType signerRoleType= new SignerRoleType(); 
		ClaimedRolesListType claimedRolesListType = new ClaimedRolesListType();
		AnyType anyType = new AnyType();
		anyType.getContent().add("supplier");	
		claimedRolesListType.getClaimedRole().add(anyType);
		signerRoleType.setClaimedRoles(claimedRolesListType);
		return signerRoleType;
	}
	
	private SignaturePolicyIdentifierType signaturePolicyIdentifierType() {
		org.etsi.uri._01903.v1_3.IdentifierType identifierType = new org.etsi.uri._01903.v1_3.IdentifierType();
		SignaturePolicyIdentifierType signaturePolicyIdentifierType= new SignaturePolicyIdentifierType();
		SignaturePolicyIdType signaturePolicyIdType = new SignaturePolicyIdType();
		ObjectIdentifierType objectIdentifierType = new  ObjectIdentifierType();
		DigestAlgAndValueType digestAlgAndValueType = new  DigestAlgAndValueType();
		DigestMethodType digestMethodType = new DigestMethodType();
		digestMethodType.setAlgorithm("http://www.w3.org/2001/04/xmlenc#sha256");
		digestAlgAndValueType.setDigestMethod(digestMethodType);
		digestAlgAndValueType.setDigestValue(new byte[30 / 2]);
		identifierType.setValue("https://facturaelectronica.dian.gov.co/politicadefirma/v1/politicadefirmav1.pdf");
		objectIdentifierType.setIdentifier(identifierType);
		signaturePolicyIdType.setSigPolicyId(objectIdentifierType);
		signaturePolicyIdType.setSigPolicyHash(digestAlgAndValueType);
		signaturePolicyIdentifierType.setSignaturePolicyId(signaturePolicyIdType);		
		return signaturePolicyIdentifierType ;
	}
	
	private CertIDListType certIDListType() {
		DigestAlgAndValueType digestAlgAndValueType = new DigestAlgAndValueType();
		CertIDListType certIDListType = new CertIDListType();
		CertIDType certIDType = new CertIDType();
		X509IssuerSerialType1 issuerSerialType1 = new X509IssuerSerialType1();
		DigestMethodType digestMethodType = new DigestMethodType();
		issuerSerialType1.setX509IssuerName("CN=carvajal.com,C=CO,ST=Valle del Cauca,L=Cali,1.2.840.113549.1.9.1=#161b64616e6e792e7a616d6f72616e6f4063617276616a616c2e636f6d,OU=EBusiness,O=Carvajal Test");
		issuerSerialType1.setX509SerialNumber(new BigInteger("10823412393224411129"));
		digestMethodType.setAlgorithm("http://www.w3.org/2001/04/xmlenc#sha256");
		digestAlgAndValueType.setDigestValue(new byte[30 / 2]);
		digestAlgAndValueType.setDigestMethod(digestMethodType);
		certIDType.setCertDigest(digestAlgAndValueType);
		certIDType.setIssuerSerial(issuerSerialType1);
		certIDListType.getCert().add(certIDType);
		return certIDListType;
	}
	
	private SignedInfoType signedInfoType() {
		byte[] dato =  new byte[30 / 2]; 
		SignedInfoType infoType = new SignedInfoType();
		ReferenceType referenceType1= new ReferenceType();
		ReferenceType referenceType2= new ReferenceType();
		ReferenceType referenceType3= new ReferenceType();
		referenceType1.setTransforms(transformsType());
		referenceType1.setId("xmldsig-9ba23b0d-66d0-41de-94b8-d4403c002553-ref0");
		referenceType1.setURI("");
		referenceType1.setDigestMethod(reDigestMethodType());
		referenceType1.setDigestValue(dato);
		infoType.getReference().add(referenceType1);
		infoType.setCanonicalizationMethod(canonicalizationMethodType());
		infoType.setSignatureMethod(signatureMethodType());
		referenceType2.setURI("#xmldsig-87d128b5-aa31-4f0b-8e45-3d9cfa0eec26-keyinfo");
		referenceType2.setDigestMethod(reDigestMethodType());
		referenceType2.setDigestValue(dato);
		infoType.getReference().add(referenceType2);
		
		referenceType3.setType("http://uri.etsi.org/01903#SignedProperties");
		referenceType3.setURI("#xmldsig-9ba23b0d-66d0-41de-94b8-d4403c002553-signedprops");
		referenceType3.setDigestMethod(reDigestMethodType());
		referenceType3.setDigestValue(dato);
		infoType.getReference().add(referenceType3);
		return infoType;
	}
	
	private SignatureValueType signatureValueType() {
		SignatureValueType signatureValueType = new SignatureValueType();
		signatureValueType.setId("xmldsig-9ba23b0d-66d0-41de-94b8-d4403c002553-sigvalue");
		signatureValueType.setValue(new byte[30 / 2]);
		return signatureValueType;
	}
	
	private KeyInfoType keyInfoType() throws CertificateException, KeyStoreException, NoSuchAlgorithmException, java.security.cert.CertificateException, FileNotFoundException, IOException, UnrecoverableEntryException {
		KeyInfoType keyInfoType = new KeyInfoType();
		X509DataType x509DataType = new X509DataType() ;
		X509IssuerSerialType x509IssuerSerialType = new X509IssuerSerialType();
		x509IssuerSerialType.setX509IssuerName("werewe");
			 x509DataType.getX509IssuerSerialOrX509SKIOrX509SubjectName().add(x509IssuerSerialType);
			 
			 
		 
		
		
		keyInfoType.setId("xmldsig-9ba23b0d-66d0-41de-94b8-d4403c002553-keyinfo");
		keyInfoType.getContent().add(x509DataType);
		return keyInfoType;
	}
	
	private DigestMethodType reDigestMethodType() {
		DigestMethodType digestMethodType = new DigestMethodType();
		digestMethodType.setAlgorithm("http://www.w3.org/2001/04/xmlenc#sha256");
		return digestMethodType;
	}
	
	private TransformsType transformsType() {
		TransformsType transformsType = new TransformsType();
		TransformType transformType = new TransformType();
		transformType.setAlgorithm("http://www.w3.org/2000/09/xmldsig#enveloped-signature");
		transformsType.getTransform().add(transformType);
		return transformsType;
	}
	
	private CanonicalizationMethodType canonicalizationMethodType () {
		CanonicalizationMethodType canonicalizationMethodType = new CanonicalizationMethodType();
		canonicalizationMethodType.setAlgorithm("http://www.w3.org/TR/2001/REC-xml-c14n-20010315");
		return canonicalizationMethodType;
	}
	
	private SignatureMethodType signatureMethodType() {
		SignatureMethodType signatureMethodType = new SignatureMethodType();
		signatureMethodType.setAlgorithm("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256");
		return signatureMethodType; 
	}
	
	private UBLVersionIDType ublVersionIDType() {
		UBLVersionIDType ublVersionIDType = new UBLVersionIDType();
		ublVersionIDType.setValue("UBL 2.0");
		return ublVersionIDType;
	}
	
	private CustomizationIDType customizationIDType(Documento documento) {
		CustomizationIDType customizationIDType = new CustomizationIDType();
		customizationIDType.setSchemeDataURI("http://www.dian.gov.co/micrositios/fac_electronica/documentos/");
		customizationIDType.setSchemeID("XSD/r1/DIAN_UBL.xsd");
		customizationIDType.setSchemeName("xsd aplicado a este documento-e. - xsi:schemaLocation. - cambios en la cardinalidad de algunos elementos");
		customizationIDType.setSchemeURI("http://www.dian.gov.co/");
		customizationIDType.setValue("CustomizationID");
		return customizationIDType;
	}
	
	private ProfileIDType profileIDType() {
		ProfileIDType profileIDType = new ProfileIDType();
		profileIDType.setSchemeDataURI("micrositios/fac_electronica/documentos/");
		profileIDType.setSchemeID("XPATH/v0/fox-abc.sch, XPATH/v3/fox-abc.xsl");
		profileIDType.setSchemeName("Lista de perfiles UBL de la DIAN");
		profileIDType.setSchemeURI("http://www.dian.gov.co/");
		profileIDType.setValue("DIAN 1.0");
		return profileIDType;
	}
	
	private IDType idType(Documento documento) {
		IDType idType = new IDType();
		idType.setValue(documento.getNumeroDocumento());
		return idType ;
	}
	
	private UUIDType cufe(Documento documento) {
		UUIDType uuidType = new UUIDType();
		uuidType.setSchemeName("CUFE");		
		uuidType.setValue("123456789");
		return uuidType;
	}
	
	private IssueDateType issueDateType(Documento documento) {
		IssueDateType issueDateType = new IssueDateType();
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		issueDateType.setValue(date2);
		return issueDateType;
	}

	private IssueTimeType issueTimeType(Documento documento) {
		IssueTimeType issueTimeType = new IssueTimeType();
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		issueTimeType.setValue(date2);
		return issueTimeType;
	}
	
	private InvoiceTypeCodeType invoiceTypeCodeType() {
		InvoiceTypeCodeType invoiceTypeCodeType = new InvoiceTypeCodeType();
		invoiceTypeCodeType.setListAgencyID("195");
		invoiceTypeCodeType.setListAgencyName("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)");
		invoiceTypeCodeType.setListSchemeURI("http://www.dian.gov.co/contratos/facturaelectronica/v1/InvoiceType");
		invoiceTypeCodeType.setListURI("http://www.dian.gov.co");
		invoiceTypeCodeType.setValue("1");
		return invoiceTypeCodeType;
	}
	
	private DocumentCurrencyCodeType documentCurrencyCodeType() {
		DocumentCurrencyCodeType documentCurrencyCodeType = new DocumentCurrencyCodeType();
		documentCurrencyCodeType.setValue("COP");
		return documentCurrencyCodeType;
	}
	
	private co.gov.dian.contratos.facturaelectronica.v1.SupplierPartyType accountingSupplierParty(Documento documento){
		co.gov.dian.contratos.facturaelectronica.v1.SupplierPartyType partyType = new SupplierPartyType();
		partyType.setAdditionalAccountID(additionalAccountIDType(documento));
		partyType.setParty(partyType(documento));
		partyType.setAccountingContact(contactType());
		return partyType;
	}
	
	private CustomerPartyType customerPartyType() {
		CustomerPartyType customerPartyType = new CustomerPartyType();
		customerPartyType.setAdditionalAccountID(additionalAccountIDType());
		customerPartyType.setParty(partyType());
		return customerPartyType;
	}
	
	private PartyType partyType() {
		PartyType partyType = new PartyType();
		partyType.getPartyIdentification().add(partyIdentificationType());
		partyType.setPhysicalLocation(locationTypeCustomer());
		partyType.getPartyTaxScheme().add(partyTaxSchemeType2());
		partyType.getPartyLegalEntity().add(partyLegalEntityType2());
		partyType.setContact(contactType2());
		return partyType;
	}
	
	private ContactType contactType2() {
		ContactType contactType = new ContactType();
		NameType nameType = new NameType();
		TelephoneType  telephoneType = new TelephoneType(); 
		ElectronicMailType electronicMailType = new ElectronicMailType();
		electronicMailType.setValue("effectivesoftware1@gmail.com");
		telephoneType.setValue("1234534");
		nameType.setValue("Empresa DEMO");
		contactType.setName(nameType);
		contactType.setTelephone(telephoneType);
		contactType.setElectronicMail(electronicMailType);
		return contactType;
	}
	
	private PartyLegalEntityType partyLegalEntityType2() {
		 PartyLegalEntityType partyLegalEntityType = new PartyLegalEntityType();
		 RegistrationNameType registrationNameType = new RegistrationNameType();
		 CompanyIDType companyIDType = new CompanyIDType();
		 companyIDType.setSchemeDataURI("http://www.rues.org.co/RUES_Web/");
		 companyIDType.setSchemeName("matrícula mercantil: persona natural o jurídica");
		 registrationNameType.setValue("Empresa DEMO");
		 partyLegalEntityType.setRegistrationName(registrationNameType);
		 partyLegalEntityType.setCompanyID(companyIDType);
		 partyLegalEntityType.setRegistrationAddress(addressType3());
		 return partyLegalEntityType;
	}
	
	private oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType addressType3() {
		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType addressType = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType();
		CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();
		CityNameType cityNameType = new CityNameType();
		PostalZoneType postalZoneType = new PostalZoneType();
		CountrySubentityType countrySubentityType = new CountrySubentityType();
		AddressLineType addressLineType = new AddressLineType();
		LineType lineType = new LineType();
		CountryType countryType = new CountryType();
		IdentificationCodeType identificationCodeType = new IdentificationCodeType();
		identificationCodeType.setListID("ISO 3166-1");
		identificationCodeType.setListName("");
		NameType nameType = new NameType();
		countryType.setName(nameType);
		countryType.setIdentificationCode(identificationCodeType);
		addressLineType.setLine(lineType);
		addressType.setCitySubdivisionName(citySubdivisionNameType);
		addressType.setCityName(cityNameType);
		addressType.setPostalZone(postalZoneType);
		addressType.setCountrySubentity(countrySubentityType);
		addressType.getAddressLine().add(addressLineType);
		addressType.setCountry(countryType);
		return addressType;
	}
	
	private PartyTaxSchemeType partyTaxSchemeType2() {
		PartyTaxSchemeType partyTaxSchemeType =new PartyTaxSchemeType();
		TaxLevelCodeType taxLevelCodeType = new TaxLevelCodeType();
		taxLevelCodeType.setListName("TIPOS OBLIGACIONES-RESPONSABILIDADES:2016");
		taxLevelCodeType.setListSchemeURI("http://www.dian.gov.co/");
		taxLevelCodeType.setName("Otro tipo de obligado");
		taxLevelCodeType.setValue("0-99");
		partyTaxSchemeType.setTaxLevelCode(taxLevelCodeType);
		return partyTaxSchemeType;
	}
	
	private LocationType locationTypeCustomer() {
		LocationType locationType = new LocationType();
		DescriptionType descriptionType = new DescriptionType();
		
		descriptionType.setValue("Av Dorado No 90 10");
		locationType.setDescription(descriptionType);
		locationType().setAddress(addressType2());
		return locationType;
	}
	
	private AddressType addressType2() {
		AddressType addressType = new AddressType();
		CityNameType cityNameType = new CityNameType();
		AddressLineType addressLineType = new AddressLineType();
		LineType lineType = new LineType();
		CountryType countryType = new CountryType();
		IdentificationCodeType identificationCodeType = new IdentificationCodeType();
		identificationCodeType.setListName("COLOMBIA");
		identificationCodeType.setListURI("http://www.dian.gov.co");
		identificationCodeType.setValue("CO");
		countryType.setIdentificationCode(identificationCodeType);
		addressLineType.setLine(lineType);
		cityNameType.setValue("Bogota");
		addressType.setCityName(cityNameType);
		addressType.getAddressLine().add(addressLineType);
		addressType.setCountry(countryType);
		return addressType;
		
	}
	
	
	private PartyIdentificationType partyIdentificationType() {
		 PartyIdentificationType partyIdentificationType = new PartyIdentificationType();
		 IDType idType = new IDType();
		 idType.setSchemeAgencyID("195");
		 idType.setSchemeAgencyName("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)");
		 idType.setSchemeID("31");
		 idType.setValue("20505779292");
		 partyIdentificationType.setID(idType);
		 return partyIdentificationType;
	}
	
	private AdditionalAccountIDType additionalAccountIDType() {
		AdditionalAccountIDType additionalAccountIDType = new AdditionalAccountIDType();
		additionalAccountIDType.setSchemeDataURI("http://www.dian.gov.co");
		additionalAccountIDType.setSchemeName("tipos de organización jurídica; adquiriente: una persona jurídica. Solo use el valor '1'");
		additionalAccountIDType.setValue("1");
		return additionalAccountIDType;
	}
	
	private ContactType contactType() {
		ContactType contactType = new ContactType();
		NameType nameType = new NameType();
		ElectronicMailType electronicMailType = new ElectronicMailType();
		electronicMailType.setValue("effectivesoftware1@gmail.com");
		nameType.setValue("Gabriel motnenegro");
		contactType.setName(nameType);
		contactType.setElectronicMail(electronicMailType);
		return contactType;
	}
	
	private PartyType partyType(Documento documento) {
		PartyType partyType = new PartyType();
		partyType.getPartyIdentification().add(partyIdentificationType(documento));
		partyType.setPhysicalLocation(locationType());
		partyType.getPartyTaxScheme().add(partyTaxSchemeType());
		partyType.getPartyLegalEntity().add(partyLegalEntityType());
		partyType.getPerson().add(personType());
		return partyType;
	}
	
	private PersonType personType() {
		PersonType personType = new PersonType();
		FirstNameType firstNameType = new FirstNameType();
		FamilyNameType familyNameType = new FamilyNameType();
		familyNameType.setValue("-");
		firstNameType.setValue("GLAXOSMITHKLINE COLOMBIA SA");
		personType.setFirstName(firstNameType);
		personType.setFamilyName(familyNameType);
		return personType;
	}
	
	private PartyLegalEntityType partyLegalEntityType() {
		PartyLegalEntityType partyLegalEntityType = new PartyLegalEntityType();
		RegistrationNameType registrationNameType = new RegistrationNameType();
		CompanyIDType companyIDType = new CompanyIDType();
		companyIDType.setSchemeDataURI("http://www.rues.org.co/RUES_Web/");
		companyIDType.setSchemeName("matrícula mercantil: persona natural o jurídica");
		registrationNameType.setValue("GLAXOSMITHKLINE COLOMBIA SA");
		partyLegalEntityType.setRegistrationName(registrationNameType);
		partyLegalEntityType.setCompanyID(companyIDType);
		partyLegalEntityType.setRegistrationAddress(addressType());	
		return partyLegalEntityType;
	}
	
	oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType addressType(){
		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType addressType = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType();
		CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();
		CityNameType cityNameType = new CityNameType();
		PostalZoneType postalZoneType = new PostalZoneType();
		CountrySubentityType countrySubentityType = new CountrySubentityType();
		AddressLineType addressLineType  = new AddressLineType();
		LineType lineType = new LineType();
		CountryType countryType = new CountryType();
		IdentificationCodeType identificationCodeType = new IdentificationCodeType();
		identificationCodeType.setListID("ISO 3166-1");
		identificationCodeType.setListName("");
		countryType.setIdentificationCode(identificationCodeType);
		addressLineType.setLine(lineType);
		addressType.setCitySubdivisionName(citySubdivisionNameType);
		addressType.setCityName(cityNameType);
		addressType.setPostalZone(postalZoneType);
		addressType.setCountrySubentity(countrySubentityType);
		addressType.getAddressLine().add(addressLineType);
		addressType.setCountry(countryType);
		
		return addressType;
	}
	
	private PartyTaxSchemeType partyTaxSchemeType() {
		PartyTaxSchemeType partyTaxSchemeType = new PartyTaxSchemeType();
		TaxLevelCodeType taxLevelCodeType = new TaxLevelCodeType();
		TaxSchemeType taxSchemeType = new TaxSchemeType();
		taxLevelCodeType.setListName("TIPOS OBLIGACIONES-RESPONSABILIDADES:2016");
		taxLevelCodeType.setListSchemeURI("http://www.dian.gov.co/");
		taxLevelCodeType.setName("Otro tipo de obligado");
		taxLevelCodeType.setValue("0-99");
		partyTaxSchemeType.setTaxLevelCode(taxLevelCodeType);
		partyTaxSchemeType.setTaxScheme(taxSchemeType);
		return partyTaxSchemeType;
	}
	
	private LocationType locationType() {
		LocationType locationType = new LocationType();
		DescriptionType descriptionType = new DescriptionType();
		AddressType addressType = new AddressType(); 
		CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();
		AddressLineType addressLineType = new AddressLineType();
		CityNameType cityNameType = new CityNameType();
		LineType lineType = new LineType(); 
		CountryType countryType = new CountryType();
		IdentificationCodeType identificationCodeType = new IdentificationCodeType();
		NameType nameType = new NameType();
		nameType.setValue("COLOMBIA");
		identificationCodeType.setValue("CO");
		identificationCodeType.setListURI("http://www.dian.gov.co");
		countryType.setIdentificationCode(identificationCodeType);
		countryType.setName(nameType);
		lineType.setValue("carrera 8 Nº 6C - 60");
		addressLineType.setLine(lineType);
		addressType.setCitySubdivisionName(citySubdivisionNameType);
		addressType.setCityName(cityNameType);
		addressType.getAddressLine().add(addressLineType);
		addressType.setCountry(countryType);
		descriptionType.setValue("Av Dorado No 69B 45 P 9");
		locationType.setDescription(descriptionType);
		locationType.setAddress(addressType);
		return locationType; 
	}
	
	private PartyIdentificationType partyIdentificationType(Documento documento) {
		PartyIdentificationType partyIdentificationType = new PartyIdentificationType();
		IDType idType = new IDType();
		idType.setSchemeAgencyID("195");
		idType.setSchemeAgencyName("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)");
		idType.setSchemeDataURI("\"http://www.dian.gov.co/micrositios/fac_electronica/documentos/Anexo_Tecnico_001_Formatos_de_los_Documentos_XML_de_Facturacion_Electron.pdf 'Tipos de documentos de identidad'");
		idType.setSchemeID("31");
		idType.setSchemeName("NIT");
		idType.setValue("700085371");
		partyIdentificationType.setID(idType);
		return partyIdentificationType;
	}
	
	private AdditionalAccountIDType additionalAccountIDType(Documento documento) {
		AdditionalAccountIDType additionalAccountIDType = new AdditionalAccountIDType();
		additionalAccountIDType.setSchemeURI("http://www.dian.gov.co");
		additionalAccountIDType.setSchemeName("tipos de organización jurídica; vendedor: una persona jurídica. Solo use el valor '1'");
		additionalAccountIDType.setValue("1");
		return additionalAccountIDType;
	}
	
	private UBLExtensionsType ublExtensions(Documento documento, Marshaller marshaller) {
		List<UBLExtensionType> extensionType = extensionType(documento,marshaller);
		UBLExtensionsType ublExtensionsType = new UBLExtensionsType();
		for(UBLExtensionType type : extensionType) {
			ublExtensionsType.getUBLExtension().add(type);
		}		
		return ublExtensionsType;
	}
	
	private List<UBLExtensionType> extensionType(Documento documento, Marshaller marshaller){
		List<UBLExtensionType> extensionTypes = new ArrayList<>();		
		UBLExtensionType extensionTypeDian = new UBLExtensionType();
		UBLExtensionType extensionTypeSignature = new UBLExtensionType();
		extensionTypeDian.setExtensionContent(new ExtensionContentType());
		extensionTypeSignature.setExtensionContent(new ExtensionContentType());
		extensionTypes.add(extensionTypeDian);
		extensionTypes.add(extensionTypeSignature);
		return extensionTypes;
	}
		
	
	private ExtensionContentType extensionContentType(Documento documento,Marshaller marshaller) throws ParserConfigurationException, JAXBException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				dbf.setNamespaceAware(true);
		        DocumentBuilder builder = dbf.newDocumentBuilder();
		        Document doc = builder.newDocument();
		       
		        Element dianExtensionsType = doc.createElement("DianExtensions");
		        //dianExtensionsType.set
		        //dianExtensionsType.setPrefix(STS_PREFIX);
		        //dianExtensionsType.setNodeValue("valar node");
		        //Element dianExtensionsType = (Element) dianExtensionsType(documento);
		        //dianExtensionsType.setNodeValue("value node");
		        ExtensionContentType extensionContentType= new ExtensionContentType();
		        //DianExtensionsType dianExtensionsType = dianExtensionsType(documento);
		      //  extensionContentType.setAny( dianExtensionsType);
		        //extensionContentType.getAny().setPrefix(CAC_PREFIX);
		        //extensionContentType.getAny().setNodeValue("node value");
		        marshaller.marshal( extensionContentType, doc );
		        Node extensionContentTypeElement = doc.getLastChild();
		        log.info(extensionContentTypeElement.getNodeType());
		        return extensionContentType;
	}
	
	private DianExtensionsType dianExtensionsType(Documento documento) {
		DianExtensionsType dianExtensionsType = new DianExtensionsType();
		dianExtensionsType.setInvoiceControl(invoiceControl( documento));
		dianExtensionsType.setInvoiceSource(countryType());
		dianExtensionsType.setSoftwareProvider(softwareProvider());
		dianExtensionsType.setSoftwareSecurityCode(softwareSecurityCode());
		return dianExtensionsType;
	}
	
	private InvoiceControl invoiceControl(Documento documento) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PeriodType periodType = new PeriodType();
		StartDateType startDateType = new StartDateType();
		EndDateType endDateType = new EndDateType();
		InvoiceControl invoiceControl = new InvoiceControl();
		AuthrorizedInvoices authrorizedInvoices = new AuthrorizedInvoices();
		TextType textType = new TextType(); 
		startDateType.setValue(date2);
		endDateType.setValue(date2);		
		periodType.setStartDate(startDateType);
		periodType.setEndDate(endDateType);
		textType.setValue("LMG");
		authrorizedInvoices.setPrefix("LMG");
		authrorizedInvoices.setFrom(1l);
		authrorizedInvoices.setTo(999);
		invoiceControl.setInvoiceAuthorization(new  BigDecimal("1234567890"));
		invoiceControl.setAuthorizationPeriod(periodType);
		invoiceControl.setAuthorizedInvoices(authrorizedInvoices);	
		return invoiceControl;
	}

	private CountryType countryType() {
		IdentificationCodeType identificationCodeType = new IdentificationCodeType();
		identificationCodeType.setListAgencyID("6");
		identificationCodeType.setListAgencyName("United Nations Economic Commission for Europe");
		identificationCodeType.setListSchemeURI("urn:oasis:names:specification:ubl:codelist:gc:CountryIdentificationCode-2.0");
		identificationCodeType.setValue("CO");
		CountryType countryType = new CountryType();
		countryType.setIdentificationCode(identificationCodeType);
		return countryType;
	}
	
	private SoftwareProvider softwareProvider() {
		SoftwareProvider softwareProvider = new SoftwareProvider();
		IdentifierType identifierTypeProviderID = new IdentifierType();
		identifierTypeProviderID.setSchemeID("195");
		identifierTypeProviderID.setSchemeAgencyName("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)");
		identifierTypeProviderID.setValue("890321151");
		IdentifierType identifierTypeSoftwareID = new IdentifierType();
		identifierTypeSoftwareID.setSchemeID("195");
		identifierTypeSoftwareID.setSchemeAgencyName("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)");
		identifierTypeSoftwareID.setValue("13210d13-1207-48fb-9f94-22a9fe27948a");	
		softwareProvider.setProviderID(identifierTypeProviderID);
		softwareProvider.setSoftwareID(identifierTypeSoftwareID);
		return softwareProvider;
	}
	
	private IdentifierType softwareSecurityCode() {
		IdentifierType identifierType = new IdentifierType();
		identifierType.setSchemeID("195");
		identifierType.setSchemeAgencyName("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)");
		identifierType.setValue("890321151");
		return identifierType;
	}

}