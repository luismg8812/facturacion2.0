package com.invoice.electonic.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.cert.CertificateException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.codec.digest.DigestUtils;
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

import com.invoice.electonic.controller.InvoiceController;
import com.invoice.electonic.model.Documento;
import com.invoice.electonic.model.DocumentoDetalle;
import com.invoice.electonic.model.Empresa;
import com.invoice.electonic.model.Receptor;

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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DepartmentType;
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

public class InvoiceGeneratorUtils {

	private static Logger log = Logger.getLogger(InvoiceController.class);
		
	public static UBLVersionIDType ublVersionIDType() {
		UBLVersionIDType ublVersionIDType = new UBLVersionIDType();
		ublVersionIDType.setValue("UBL 2.0");
		return ublVersionIDType;
	}
	
	public static InvoiceLineType invoiceLineType(List<TaxTotalType> ListTaxTotalType, BigDecimal lineValue) {
		//instancias
		InvoiceLineType invoiceLineType = new InvoiceLineType();	//principal
		
		IDType idType = new IDType();
		InvoicedQuantityType invoicedQuantityType = new InvoicedQuantityType(); 
		LineExtensionAmountType lineExtensionAmountType = new LineExtensionAmountType();
		FreeOfChargeIndicatorType freeOfChargeIndicatorType = new FreeOfChargeIndicatorType(); 
		
		//seteos
		freeOfChargeIndicatorType.setValue(false);
		invoicedQuantityType.setUnitCode("S8");
		invoicedQuantityType.setValue(new BigDecimal("234"));
		lineExtensionAmountType.setCurrencyID(CurrencyCodeContentType.COP);
		lineExtensionAmountType.setValue(lineValue);
		idType.setValue("1");
		
		invoiceLineType.setID(idType);
		invoiceLineType.setInvoicedQuantity(invoicedQuantityType);
		invoiceLineType.setLineExtensionAmount(lineExtensionAmountType);
		invoiceLineType.setFreeOfChargeIndicator(freeOfChargeIndicatorType);
		invoiceLineType.setPricingReference(new PricingReferenceType());
		for(TaxTotalType tax : ListTaxTotalType) {
			invoiceLineType.getTaxTotal().add(taxTotalType(tax));
		}
		invoiceLineType.setItem(new ItemType());
		
		return invoiceLineType;
	}
	
	//funcion para ordenar los detalles del documento y sacar los impuestos 
	public static InvoiceType OrderingTaxesAndLegalMonetaryTotal(Documento documento, InvoiceType invoice, List<DocumentoDetalle> ListaDocumentoDetalle) {
		
		HashMap<Long, List<DocumentoDetalle>> ListaOrdenadaDocumentoDetalle = new HashMap<>();
		
		//ordeno todos los detalles por codigo de impuesto y porcentaje
		for(DocumentoDetalle documentoDetalle : ListaDocumentoDetalle) {
			if (!ListaOrdenadaDocumentoDetalle.containsKey(documentoDetalle.getCodigoImpuesto())) {	//si no existe
			    List<DocumentoDetalle> list = new ArrayList<DocumentoDetalle>();
			    list.add(documentoDetalle);

			    ListaOrdenadaDocumentoDetalle.put(documentoDetalle.getCodigoImpuesto(), list);
			} else {	//si existe
				ListaOrdenadaDocumentoDetalle.get(documentoDetalle.getCodigoImpuesto()).add(documentoDetalle);
			}
		}
		
		float TotalTaxAmoung = 0;
		float TotalTaxableAmoung = 0;
		
		//for para crear cada uno de los impuestos de la factura
		for(Map.Entry<Long, List<DocumentoDetalle>> entry : ListaOrdenadaDocumentoDetalle.entrySet()) {
			List<DocumentoDetalle> ListaDetalle = entry.getValue();
			
			float taxAmoung = 0;
			float taxableAmoung = 0;
			
			float AcumTaxTotal = 0;
			float AcumTaxableTotal = 0;
			
			List<TaxSubtotalType> listSubtotal = new ArrayList<TaxSubtotalType>();
			
			for(DocumentoDetalle documentoDetalle : ListaDetalle) {
				taxAmoung = ((float)documentoDetalle.getProducto().getIva() / 100) * (float)documentoDetalle.getProducto().getCostoPublico() * documentoDetalle.getCantidad();
				taxableAmoung = ((100 - (float)documentoDetalle.getProducto().getIva()) / 100) * (float)documentoDetalle.getProducto().getCostoPublico() * documentoDetalle.getCantidad();
				
				AcumTaxTotal += taxAmoung;
				AcumTaxableTotal += taxableAmoung;
				
				boolean flag = false;
				int i = 0;
				for (TaxSubtotalType tax : listSubtotal) {
					if(tax.getPercent().getValue().longValue() == documentoDetalle.getProducto().getIva()) {
						flag = true;
						break;
					}
					i++;
				}
				
				if (flag) {
					TaxSubtotalType tax = listSubtotal.get(i);
					tax.getTaxAmount().setValue(tax.getTaxAmount().getValue().add(new BigDecimal(taxAmoung)));
					tax.getTaxableAmount().setValue(tax.getTaxableAmount().getValue().add(new BigDecimal(taxableAmoung)));
					listSubtotal.set(i, tax);
				}else {
					listSubtotal.add(taxSubtotalType((long)taxAmoung, (long)taxableAmoung, documentoDetalle.getProducto().getIva(), documentoDetalle.getCodigoImpuesto()));
				}
			}
			
			TotalTaxAmoung += AcumTaxTotal;
			TotalTaxableAmoung += AcumTaxableTotal;
			
			invoice.getTaxTotal().add(InvoiceGeneratorUtils.taxTotalTypes((long)AcumTaxTotal, listSubtotal));
		}
		
		invoice.setLegalMonetaryTotal(InvoiceGeneratorUtils.monetaryTotalType(documento, TotalTaxAmoung, TotalTaxableAmoung));
		
		return invoice;
	}
	
	public static CustomizationIDType customizationIDType() {
		CustomizationIDType customizationIDType = new CustomizationIDType();
		customizationIDType.setSchemeDataURI("http://www.dian.gov.co/micrositios/fac_electronica/documentos/");
		customizationIDType.setSchemeID("XSD/r1/DIAN_UBL.xsd");
		customizationIDType.setSchemeName("xsd aplicado a este documento-e. - xsi:schemaLocation. - cambios en la cardinalidad de algunos elementos");
		customizationIDType.setSchemeURI("http://www.dian.gov.co/");
		customizationIDType.setValue("CustomizationID");	//averiguar como se llena esta shit
		return customizationIDType;
	}
	
	public static ProfileIDType profileIDType() {
		ProfileIDType profileIDType = new ProfileIDType();
		profileIDType.setSchemeDataURI("micrositios/fac_electronica/documentos/");
		profileIDType.setSchemeID("XPATH/v0/fox-abc.sch, XPATH/v3/fox-abc.xsl");
		profileIDType.setSchemeName("Lista de perfiles UBL de la DIAN");
		profileIDType.setSchemeURI("http://www.dian.gov.co/");
		profileIDType.setValue("DIAN 1.0");
		return profileIDType;
	}


	public static String nombrarFacturaXML(Documento d, Empresa empresa) {
		String face = "face_f";
		String nit = Calculos.completarDescripcion(empresa.getNit(), 10);
		String numeroHex = Calculos.completarDescripcion(Long.toHexString(new Long(d.getNumeroDocumento())), 10);
		return face + nit + numeroHex+".xml";
	}
	
	public static IDType idType(Documento documento) {
		IDType idType = new IDType();
		idType.setValue(documento.getPrefijo() + documento.getNumeroDocumento());	//numero y prefijo
		return idType ;
	}
		
	//revisar calculo de cufe, parece estar malo
	public static UUIDType cufe(Documento documento, InvoiceType invoice) {
        UUIDType uuidType = new UUIDType();	
        uuidType.setSchemeName("CUFE");        	         
		String CUFEValue = "";
		
		CUFEValue += documento.getPrefijo();
		CUFEValue += documento.getNumeroDocumento() + ";";	//nuemro factura
		CUFEValue += new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ";";	//fecha factura
		CUFEValue += invoice.getLegalMonetaryTotal().getLineExtensionAmount().getValue() + ".00" + ";";	//gravado

		BigDecimal tax1 = new BigDecimal("0");
		BigDecimal tax2 = new BigDecimal("0");
		BigDecimal tax3 = new BigDecimal("0");
		
		for(TaxTotalType tax : invoice.getTaxTotal()) {
			switch (tax.getTaxSubtotal().get(0).getTaxCategory().getTaxScheme().getID().getValue()) {
				case "01":
					tax1 = tax.getTaxAmount().getValue();
					break;
				case "02":
					tax2 = tax.getTaxAmount().getValue();
					break;
				case "03":
					tax3 = tax.getTaxAmount().getValue();
					break;
			}
		}
		
		CUFEValue += "01;" + tax1.toString() + ".00" + ";";		//tax1
		CUFEValue += "02;" + tax2.toString() + ".00" + ";";		//tax2
		CUFEValue += "03;" + tax3.toString() + ".00" + ";";		//tax3
		
		CUFEValue += invoice.getLegalMonetaryTotal().getPayableAmount().getValue().toString() + ";";	//total
		
		CUFEValue += invoice.getAccountingSupplierParty().getParty().getPartyIdentification().get(0).getID().getValue() + ";";	//emisor
		CUFEValue += invoice.getAccountingCustomerParty().getParty().getPartyIdentification().get(0).getID().getSchemeID() + ";";	//tipo emisor
		CUFEValue += invoice.getAccountingCustomerParty().getParty().getPartyIdentification().get(0).getID().getValue() + ";";	//receptor
		
		CUFEValue += "Luismg8812";	//llave tecnica
		
		System.out.println(CUFEValue);
		
		uuidType.setValue(Calculos.byteArrayToHexString(DigestUtils.sha1(CUFEValue)));        
		return uuidType;
	}	
	
	public static IssueDateType issueDateType(Documento documento) {
		IssueDateType issueDateType = new IssueDateType();
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		issueDateType.setValue(date2);
		return issueDateType;
	}

	public static IssueTimeType issueTimeType(Documento documento) {
		IssueTimeType issueTimeType = new IssueTimeType();
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		issueTimeType.setValue(date2);
		return issueTimeType;
	}
	
	public static InvoiceTypeCodeType invoiceTypeCodeType() {
		InvoiceTypeCodeType invoiceTypeCodeType = new InvoiceTypeCodeType();
		invoiceTypeCodeType.setListAgencyID("195");		//averiguar de donde sale este 195
		invoiceTypeCodeType.setListAgencyName("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)");
		invoiceTypeCodeType.setListSchemeURI("http://www.dian.gov.co/contratos/facturaelectronica/v1/InvoiceType");
		invoiceTypeCodeType.setListURI("http://www.dian.gov.co");
		invoiceTypeCodeType.setValue("1");		//averiguar de donde sale el 1
		return invoiceTypeCodeType;
	}
	
	public static DocumentCurrencyCodeType documentCurrencyCodeType() {
		DocumentCurrencyCodeType documentCurrencyCodeType = new DocumentCurrencyCodeType();
		documentCurrencyCodeType.setValue("COP");
		return documentCurrencyCodeType;
	}
	
	public static co.gov.dian.contratos.facturaelectronica.v1.SupplierPartyType accountingSupplierParty(Documento documento, Empresa empresa){
		co.gov.dian.contratos.facturaelectronica.v1.SupplierPartyType partyType = new SupplierPartyType();
		partyType.setAdditionalAccountID(additionalAccountIDTypeASParty(documento));
		partyType.setParty(partyTypeASParty(documento, empresa));
		partyType.setAccountingContact(contactTypeASParty(empresa));
		return partyType;
	}
	
	public static CustomerPartyType customerPartyType(Receptor receptor) {
		CustomerPartyType customerPartyType = new CustomerPartyType();
		customerPartyType.setAdditionalAccountID(additionalAccountIDTypeCustomerParty());
		customerPartyType.setParty(partyTypeCustomerParty(receptor));
		return customerPartyType;
	}

	public static oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType taxTotalType(TaxTotalType tax){
		//instancias
		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType taxTotalType = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType();	//principal
		
		//seteos
		taxTotalType.setTaxAmount(tax.getTaxAmount());		
		taxTotalType.setTaxEvidenceIndicator(tax.getTaxEvidenceIndicator());	
		
		return taxTotalType;
	}
	
	public static TaxTotalType taxTotalTypes(Long taxAmoung, List<TaxSubtotalType> ListaTaxSubtotal){		
		TaxTotalType taxTotalTypes = new TaxTotalType();
		TaxAmountType amountType = new TaxAmountType();
		
		TaxEvidenceIndicatorType evidenceIndicatorType = new TaxEvidenceIndicatorType();
		
		evidenceIndicatorType.setValue(false);
		
		amountType.setCurrencyID(CurrencyCodeContentType.COP); //tipo de moneda -ok
		amountType.setValue(new BigDecimal(taxAmoung));
		
		taxTotalTypes.setTaxAmount(amountType);		
		taxTotalTypes.setTaxEvidenceIndicator(evidenceIndicatorType);
		
		for (TaxSubtotalType SubTax : ListaTaxSubtotal) {
			taxTotalTypes.getTaxSubtotal().add(SubTax);
		}
		
		return taxTotalTypes;
	}
	
	public static MonetaryTotalType monetaryTotalType(Documento documento, float TotalTaxAmoung, float TotalTaxableAmoung) {
		//instancias
		MonetaryTotalType monetaryTotalType = new MonetaryTotalType();
		LineExtensionAmountType lineExtensionAmountType = new LineExtensionAmountType();
		TaxExclusiveAmountType exclusiveAmountType = new TaxExclusiveAmountType();
		TaxInclusiveAmountType inclusiveAmountType = new TaxInclusiveAmountType();
		AllowanceTotalAmountType allowanceTotalAmountType = new AllowanceTotalAmountType();
		PayableAmountType payableAmountType = new PayableAmountType();
		
		//seteos
		payableAmountType.setCurrencyID(CurrencyCodeContentType.COP);
		payableAmountType.setValue(new BigDecimal(TotalTaxableAmoung + TotalTaxAmoung - documento.getExcento()));	//revisar estos valores
		
		allowanceTotalAmountType.setCurrencyID(CurrencyCodeContentType.COP);
		allowanceTotalAmountType.setValue(new BigDecimal("0.000"));		//no aplica
		
		inclusiveAmountType.setCurrencyID(CurrencyCodeContentType.COP);
		inclusiveAmountType.setValue(new BigDecimal(TotalTaxableAmoung + TotalTaxAmoung));	//revisar estos valores
		
		exclusiveAmountType.setCurrencyID(CurrencyCodeContentType.COP);
		exclusiveAmountType.setValue(new BigDecimal(TotalTaxAmoung));	//revisar estos valores
		
		lineExtensionAmountType.setCurrencyID(CurrencyCodeContentType.COP);
		lineExtensionAmountType.setValue(new BigDecimal(TotalTaxableAmoung));	//revisar estos valores
		
		monetaryTotalType.setLineExtensionAmount(lineExtensionAmountType);
		monetaryTotalType.setTaxExclusiveAmount(exclusiveAmountType);
		monetaryTotalType.setTaxInclusiveAmount(inclusiveAmountType);
		monetaryTotalType.setAllowanceTotalAmount(allowanceTotalAmountType);
		monetaryTotalType.setPayableAmount(payableAmountType);
		
		return monetaryTotalType;
	}
	
	private static AdditionalAccountIDType additionalAccountIDTypeCustomerParty() {
		AdditionalAccountIDType additionalAccountIDType = new AdditionalAccountIDType();
		additionalAccountIDType.setSchemeDataURI("http://www.dian.gov.co");
		additionalAccountIDType.setSchemeName("tipos de organización jurídica; adquiriente: una persona jurídica. Solo use el valor '1'");
		additionalAccountIDType.setValue("1");	//revisar porque se escribe este 1 y como hacer para recortar el mensaje SchemeName
		return additionalAccountIDType;
	}
	
	private static AdditionalAccountIDType additionalAccountIDTypeASParty(Documento documento) {
		AdditionalAccountIDType additionalAccountIDType = new AdditionalAccountIDType();
		additionalAccountIDType.setSchemeURI("http://www.dian.gov.co");		
		additionalAccountIDType.setSchemeName("tipos de organización jurídica; vendedor: una persona jurídica. Solo use el valor '1'");
		additionalAccountIDType.setValue("1");	//revisar porque se escribe este 1 y como hacer para recortar el mensaje SchemeName
		return additionalAccountIDType;
	}
	
	//diferenciar ambos metodos con un nombre mas cognitivo por cuestiones de soporte
	private static PartyType partyTypeCustomerParty(Receptor receptor) {
		PartyType partyType = new PartyType();
		partyType.getPartyIdentification().add(partyIdentificationTypeCustomerParty(receptor));
		partyType.setPhysicalLocation(locationTypeCustomerParty(receptor));
		partyType.getPartyTaxScheme().add(partyTaxSchemeTypeCustomerParty());
		partyType.getPartyLegalEntity().add(partyLegalEntityTypeCustomerParty(receptor));
		partyType.setContact(contactTypeCustomerParty(receptor));
		return partyType;
	}
	
	private static PartyType partyTypeASParty(Documento documento, Empresa empresa) {
		PartyType partyType = new PartyType();
		partyType.getPartyIdentification().add(partyIdentificationTypeASParty(documento, empresa));
		partyType.setPhysicalLocation(locationTypeASParty(empresa));
		partyType.getPartyTaxScheme().add(partyTaxSchemeTypeASParty());		//esta funcion que?
		partyType.getPartyLegalEntity().add(partyLegalEntityTypeASParty(empresa));	//esta funcion que?
		partyType.getPerson().add(personType(empresa));		//esta funcion que?
		return partyType;
	}
	
	private static PartyIdentificationType partyIdentificationTypeCustomerParty(Receptor receptor) {	//revisar como saber configurar estos valores
		 PartyIdentificationType partyIdentificationType = new PartyIdentificationType();
		 IDType idType = new IDType();
		 idType.setSchemeAgencyID("195");
		 idType.setSchemeAgencyName("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)");
		 idType.setSchemeID("31");
		 idType.setValue(receptor.getIdentificacion());
		 partyIdentificationType.setID(idType);
		 return partyIdentificationType;
	}
	
	private static PartyIdentificationType partyIdentificationTypeASParty(Documento documento, Empresa empresa) {
		PartyIdentificationType partyIdentificationType = new PartyIdentificationType();
		IDType idType = new IDType();
		idType.setSchemeAgencyID("195");
		idType.setSchemeAgencyName("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)");
		idType.setSchemeDataURI("http://www.dian.gov.co/micrositios/fac_electronica/documentos/Anexo_Tecnico_001_Formatos_de_los_Documentos_XML_de_Facturacion_Electron.pdf 'Tipos de documentos de identidad'");
		idType.setSchemeID("31");
		idType.setSchemeName("NIT");
		idType.setValue(empresa.getNit());
		partyIdentificationType.setID(idType);
		return partyIdentificationType;
	}
	
	private static ContactType contactTypeCustomerParty(Receptor receptor) {
		ContactType contactType = new ContactType();	
		NameType nameType = new NameType();
		TelephoneType  telephoneType = new TelephoneType(); 
		ElectronicMailType electronicMailType = new ElectronicMailType();
		electronicMailType.setValue(receptor.getEmail());
		telephoneType.setValue(receptor.getTelefono());
		nameType.setValue(receptor.getRazonSocial());
		contactType.setName(nameType);
		contactType.setTelephone(telephoneType);	
		contactType.setElectronicMail(electronicMailType);
		return contactType;
	}
	
	private static ContactType contactTypeASParty(Empresa empresa) {		
		ContactType contactType = new ContactType();
		NameType nameType = new NameType();
		TelephoneType  telephoneType = new TelephoneType(); 
		ElectronicMailType electronicMailType = new ElectronicMailType();
		electronicMailType.setValue(empresa.getEmail());
		telephoneType.setValue(empresa.getTelefonoFijo());
		nameType.setValue(empresa.getRepresentante());	
		contactType.setName(nameType);
		contactType.setTelephone(telephoneType);
		contactType.setElectronicMail(electronicMailType);
		return contactType;
	}
	
	private static TaxSubtotalType taxSubtotalType(Long taxAmoung, Long taxableAmoung, Long percent, Long codigoImpuesto) {
		//instancias
		TaxSubtotalType taxSubtotalType = new TaxSubtotalType();		//principal
		TaxableAmountType taxableAmountType = new TaxableAmountType();	//atributos de taxSubtotalType
		TaxAmountType amountType = new TaxAmountType();
		PercentType percentType = new PercentType();
		TaxCategoryType categoryType = new TaxCategoryType();
		TaxSchemeType taxSchemeType = new TaxSchemeType();	//atributos de categoryType
		IDType idType = new IDType();
		TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
		
		//seteos
		taxTypeCodeType.setValue("0" + codigoImpuesto.toString()); 
		idType.setSchemeDataURI("http://www.dian.gov.co");
		idType.setSchemeName("VALOR TOTAL DE IVA");
		idType.setValue("0" + codigoImpuesto.toString());
		
		taxSchemeType.setID(idType);
		taxSchemeType.setTaxTypeCode(taxTypeCodeType);
		
		categoryType.setTaxScheme(taxSchemeType);
		
		percentType.setValue(new BigDecimal(percent)); 
		
		//PROVISIONAL MIENTRAS SE DECIDE QUE HACER CON LOS IMPUESTOS
		amountType.setCurrencyID(CurrencyCodeContentType.COP); 
		amountType.setValue(new BigDecimal(taxAmoung));	
		
		taxableAmountType.setCurrencyID(CurrencyCodeContentType.COP); 
		taxableAmountType.setValue(new BigDecimal(taxableAmoung)); 
		
		taxSubtotalType.setTaxableAmount(taxableAmountType);
		taxSubtotalType.setTaxAmount(amountType);
		taxSubtotalType.setPercent(percentType);
		taxSubtotalType.setTaxCategory(categoryType);
		return taxSubtotalType;
	}
	
	private static PartyTaxSchemeType partyTaxSchemeTypeCustomerParty() {
		PartyTaxSchemeType partyTaxSchemeType =new PartyTaxSchemeType();
		TaxLevelCodeType taxLevelCodeType = new TaxLevelCodeType();
		taxLevelCodeType.setListName("TIPOS OBLIGACIONES-RESPONSABILIDADES:2016");
		taxLevelCodeType.setListSchemeURI("http://www.dian.gov.co/");
		taxLevelCodeType.setName("Otro tipo de obligado");
		taxLevelCodeType.setValue("0-99");
		partyTaxSchemeType.setTaxLevelCode(taxLevelCodeType);
		return partyTaxSchemeType;
	}
	
	private static PartyTaxSchemeType partyTaxSchemeTypeASParty() {
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
	
	private static PartyLegalEntityType partyLegalEntityTypeCustomerParty(Receptor receptor) {
		 PartyLegalEntityType partyLegalEntityType = new PartyLegalEntityType();
		 RegistrationNameType registrationNameType = new RegistrationNameType();
		 CompanyIDType companyIDType = new CompanyIDType();
		 companyIDType.setSchemeDataURI("http://www.rues.org.co/RUES_Web/");
		 companyIDType.setSchemeName("matrícula mercantil: persona natural o jurídica");
		 registrationNameType.setValue(receptor.getRazonSocial());
		 partyLegalEntityType.setRegistrationName(registrationNameType);
		 partyLegalEntityType.setCompanyID(companyIDType);
		 partyLegalEntityType.setRegistrationAddress(addressTypeCustomerParty2(receptor));
		 return partyLegalEntityType;
	}
	
	private static PartyLegalEntityType partyLegalEntityTypeASParty(Empresa empresa) {
		PartyLegalEntityType partyLegalEntityType = new PartyLegalEntityType();
		RegistrationNameType registrationNameType = new RegistrationNameType();
		CompanyIDType companyIDType = new CompanyIDType();
		companyIDType.setSchemeDataURI("http://www.rues.org.co/RUES_Web/");
		companyIDType.setSchemeName("matrícula mercantil: persona natural o jurídica");
		registrationNameType.setValue(empresa.getNombre());
		partyLegalEntityType.setRegistrationName(registrationNameType);
		partyLegalEntityType.setCompanyID(companyIDType);
		partyLegalEntityType.setRegistrationAddress(addressTypeASParty(empresa));	
		return partyLegalEntityType;
	}
	
	private static AddressType addressTypeCustomerParty() {
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
	
	private static oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType addressTypeCustomerParty2(Receptor receptor) {
		//instancias
		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType addressType = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType();	//principal
		
		CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();	//elementos de addressType
		CityNameType cityNameType = new CityNameType();
		PostalZoneType postalZoneType = new PostalZoneType();
		CountrySubentityType countrySubentityType = new CountrySubentityType();
		AddressLineType addressLineType = new AddressLineType();
		LineType lineType = new LineType();		//elemento de addressLineType
		CountryType countryType = new CountryType();
		IdentificationCodeType identificationCodeType = new IdentificationCodeType();	//elemento de countryType
		
		//seteos
		identificationCodeType.setListID("ISO 3166-1");
		identificationCodeType.setListName("");
		countryType.setIdentificationCode(identificationCodeType);
		
		NameType nameType = new NameType();
		countryType.setName(nameType);
		
		lineType.setValue(receptor.getDireccion());
		addressLineType.setLine(lineType);
		
		addressType.setCitySubdivisionName(citySubdivisionNameType);
		addressType.setCityName(cityNameType);
		addressType.setPostalZone(postalZoneType);
		addressType.setCountrySubentity(countrySubentityType);
		
		addressType.getAddressLine().add(addressLineType);
		addressType.setCountry(countryType);
		
		return addressType;
	}
	
	private static oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType addressTypeASParty(Empresa empresa){
		//instancias
		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType addressType = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType();	//principal
		
		CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();	//elementos de addressType
		CityNameType cityNameType = new CityNameType();
		PostalZoneType postalZoneType = new PostalZoneType();
		CountrySubentityType countrySubentityType = new CountrySubentityType();
		AddressLineType addressLineType  = new AddressLineType();	
		LineType lineType = new LineType();		//elemento de addressLineType
		CountryType countryType = new CountryType();	
		IdentificationCodeType identificationCodeType = new IdentificationCodeType();	//elemento de countryType
		
		//seteos
		identificationCodeType.setListID("ISO 3166-1");
		identificationCodeType.setListName("");
		countryType.setIdentificationCode(identificationCodeType);
		
		lineType.setValue(empresa.getDireccion());
		addressLineType.setLine(lineType);
		
		citySubdivisionNameType.setValue(empresa.getBarrio());
		addressType.setCitySubdivisionName(citySubdivisionNameType);
		
		cityNameType.setValue(empresa.getCiudad());
		addressType.setCityName(cityNameType);
		
		postalZoneType.setValue(empresa.getCiudad());
		addressType.setPostalZone(postalZoneType);
		
		countrySubentityType.setValue(empresa.getDepartamento());
		addressType.setCountrySubentity(countrySubentityType);
		
		addressType.getAddressLine().add(addressLineType);
		addressType.setCountry(countryType);
		
		return addressType;
	}

	private static LocationType locationTypeCustomerParty(Receptor receptor) {
		//instancias
		LocationType PhysicalLocationType = new LocationType();		//principal
		
		DescriptionType descriptionType = new DescriptionType();	//elementos de PhysicalLocationType
		AddressType addressType = new AddressType(); 
		
		DepartmentType departmentType = new DepartmentType();	//elementos de addressType
		CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();
		CityNameType cityNameType = new CityNameType();
		AddressLineType addressLineType = new AddressLineType();
		CountryType countryType = new CountryType();
		
		LineType LineType = new LineType();		//elemento de addressLineType
		
		IdentificationCodeType identificationCodeType = new IdentificationCodeType();	//elementos de countryType
		NameType nameType = new NameType();
		
		//seteos
		
		nameType.setValue("COLOMBIA");
		
		identificationCodeType.setValue("CO");
		identificationCodeType.setListURI("http://www.dian.gov.co");
		
		countryType.setIdentificationCode(identificationCodeType);
		countryType.setName(nameType);
		
		LineType.setValue(receptor.getDireccion());
		
		addressLineType.setLine(LineType);
		
		addressType.setCitySubdivisionName(citySubdivisionNameType);
		addressType.setCityName(cityNameType);
		addressType.setDepartment(departmentType);
		
		addressType.getAddressLine().add(addressLineType);
		addressType.setCountry(countryType);

		descriptionType.setValue(receptor.getDireccion());
		
		PhysicalLocationType.setDescription(descriptionType);
		PhysicalLocationType.setAddress(addressType);
		return PhysicalLocationType; 
	}
	
	private static LocationType locationTypeASParty(Empresa empresa) {
		//instancias
		LocationType PhysicalLocationType = new LocationType();		//principal
		
		DescriptionType descriptionType = new DescriptionType();	//elementos de PhysicalLocationType
		AddressType addressType = new AddressType(); 
		
		DepartmentType departmentType = new DepartmentType();	//elementos de addressType
		CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();
		CityNameType cityNameType = new CityNameType();
		AddressLineType addressLineType = new AddressLineType();
		CountryType countryType = new CountryType();
		
		LineType LineType = new LineType();		//elemento de addressLineType
		
		IdentificationCodeType identificationCodeType = new IdentificationCodeType();	//elementos de countryType
		NameType nameType = new NameType();
		
		//seteos
		
		nameType.setValue("COLOMBIA");
		
		identificationCodeType.setValue("CO");
		identificationCodeType.setListURI("http://www.dian.gov.co");
		
		countryType.setIdentificationCode(identificationCodeType);
		countryType.setName(nameType);
		
		LineType.setValue(empresa.getDireccion());
		
		addressLineType.setLine(LineType);
		
		citySubdivisionNameType.setValue(empresa.getBarrio());
		addressType.setCitySubdivisionName(citySubdivisionNameType);
		
		cityNameType.setValue(empresa.getCiudad());
		addressType.setCityName(cityNameType);
		
		departmentType.setValue(empresa.getDepartamento());
		addressType.setDepartment(departmentType);
		
		addressType.getAddressLine().add(addressLineType);
		addressType.setCountry(countryType);

		descriptionType.setValue(empresa.getDireccion());
		
		PhysicalLocationType.setDescription(descriptionType);
		PhysicalLocationType.setAddress(addressType);
		return PhysicalLocationType; 
	}
	
	private static PersonType personType(Empresa empresa) {
		PersonType personType = new PersonType();
		FirstNameType firstNameType = new FirstNameType();
		FamilyNameType familyNameType = new FamilyNameType();
		familyNameType.setValue("-");
		firstNameType.setValue(empresa.getNombre());
		personType.setFirstName(firstNameType);
		personType.setFamilyName(familyNameType);
		return personType;
	}

	// UBLExtensions
	
	public static UBLExtensionsType ublExtensions(Documento documento, Empresa empresa, Marshaller marshaller) 
			throws JAXBException, ParserConfigurationException, KeyStoreException, NoSuchAlgorithmException, java.security.cert.CertificateException, FileNotFoundException, UnrecoverableEntryException, CertificateException, IOException {
		UBLExtensionsType ublExtensionsType = new UBLExtensionsType();
		
		UBLExtensionType extensionTypeDian = new UBLExtensionType();
		UBLExtensionType extensionTypeSignature = new UBLExtensionType();

		extensionTypeDian.setExtensionContent(new ExtensionContentType());
		extensionTypeSignature.setExtensionContent(new ExtensionContentType());
		
		extensionTypeDian.getExtensionContent().setAny(dianExtension(documento, empresa));
		extensionTypeSignature.getExtensionContent().setAny(signature(empresa));
		
		ublExtensionsType.getUBLExtension().add(extensionTypeDian);
		ublExtensionsType.getUBLExtension().add(extensionTypeSignature);
		
		return ublExtensionsType;
	}
	
	// FUNCIONES INVOLUCRADAS EN UBLExtensions
	//-------------------------------------------------------------
	
	private static Element dianExtension(Documento documento, Empresa empresa) throws JAXBException, ParserConfigurationException {		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.newDocument();		
		JAXBContext contexto = JAXBContext.newInstance("co.gov.dian.contratos.facturaelectronica.v1.structures");
		Marshaller marshaller = contexto.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DefaultNamespacePrefixMapper());
		DianExtensionsType dianExtensionsType = dianExtensionsType(documento, empresa);
		marshaller.marshal( dianExtensionsType, doc );
		Node invoice= doc.getFirstChild();
		//marshaller.marshal(dianExtensionsType, System.out);
		log.info(invoice.getNodeName());
		return (Element)invoice;
	}
	
	private static Element signature(Empresa empresa) 
			throws ParserConfigurationException, JAXBException, CertificateException, KeyStoreException, NoSuchAlgorithmException, java.security.cert.CertificateException, FileNotFoundException, UnrecoverableEntryException, IOException  {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.newDocument();
        JAXBContext contexto = JAXBContext.newInstance("org.w3._2000._09.xmldsig_");
		Marshaller marshaller = contexto.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DefaultNamespacePrefixMapper());
		SignatureType signatureType = signatureType(empresa);
		marshaller.marshal( signatureType, doc );
		Node invoice= doc.getFirstChild();
		//marshaller.marshal(signatureType, System.out);
		log.info(invoice.getNodeName());
		return (Element)invoice;
	}
	
	private static SignatureType signatureType(Empresa empresa) throws CertificateException, KeyStoreException, NoSuchAlgorithmException, java.security.cert.CertificateException, UnrecoverableEntryException, IOException, ParserConfigurationException, JAXBException {
		SignatureType signatureType= new SignatureType();
		signatureType.setId("xmldsig-1c324973-9df9-412b-bc75-46e0669e1254");
		signatureType.setSignedInfo(signedInfoType());
		signatureType.setSignatureValue(signatureValueType());
		signatureType.setKeyInfo(keyInfoType(Calculos.byteArrayToHexString(empresa.getCertificado())));
		signatureType.getObject().add(objectType());
		return signatureType;
		
	}
	
	private static ObjectType objectType() throws ParserConfigurationException, JAXBException {			
		ObjectType objectType= new ObjectType();
		objectType.getContent().add(qualifyingPropertiesType());
		return objectType;
	}
	
	private static Element qualifyingPropertiesType() throws JAXBException, ParserConfigurationException {
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
	
	private static SignedSignaturePropertiesType signedSignaturePropertiesType() {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		SignedSignaturePropertiesType signedSignaturePropertiesType = new SignedSignaturePropertiesType();
		signedSignaturePropertiesType.setSigningTime(date2);
		signedSignaturePropertiesType.setSigningCertificate(certIDListType());
		signedSignaturePropertiesType.setSignaturePolicyIdentifier(signaturePolicyIdentifierType());
		signedSignaturePropertiesType.setSignerRole(signerRoleType());
		return signedSignaturePropertiesType;
	}
	
	private static SignerRoleType signerRoleType() {
		SignerRoleType signerRoleType= new SignerRoleType(); 
		ClaimedRolesListType claimedRolesListType = new ClaimedRolesListType();
		AnyType anyType = new AnyType();
		anyType.getContent().add("supplier");	
		claimedRolesListType.getClaimedRole().add(anyType);
		signerRoleType.setClaimedRoles(claimedRolesListType);
		return signerRoleType;
	}
	
	private static SignaturePolicyIdentifierType signaturePolicyIdentifierType() {
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
	
	private static CertIDListType certIDListType() {
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
	
	private static SignedInfoType signedInfoType() {
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
	
	private static SignatureValueType signatureValueType() {
		SignatureValueType signatureValueType = new SignatureValueType();
		signatureValueType.setId("xmldsig-9ba23b0d-66d0-41de-94b8-d4403c002553-sigvalue");
		signatureValueType.setValue(new byte[30 / 2]);
		return signatureValueType;
	}
	
	private static KeyInfoType keyInfoType(String StringCertificado) throws CertificateException, KeyStoreException, NoSuchAlgorithmException, java.security.cert.CertificateException, FileNotFoundException, IOException, UnrecoverableEntryException {
		KeyInfoType keyInfoType = new KeyInfoType();
		X509DataType x509DataType = new X509DataType() ;
		X509IssuerSerialType x509IssuerSerialType = new X509IssuerSerialType();
		x509IssuerSerialType.setX509IssuerName(StringCertificado);
			 x509DataType.getX509IssuerSerialOrX509SKIOrX509SubjectName().add(x509IssuerSerialType);
			 
		keyInfoType.setId("xmldsig-9ba23b0d-66d0-41de-94b8-d4403c002553-keyinfo");
		keyInfoType.getContent().add(x509DataType);
		return keyInfoType;
	}
	
	private static DigestMethodType reDigestMethodType() {
		DigestMethodType digestMethodType = new DigestMethodType();
		digestMethodType.setAlgorithm("http://www.w3.org/2001/04/xmlenc#sha256");
		return digestMethodType;
	}
	
	private static TransformsType transformsType() {
		TransformsType transformsType = new TransformsType();
		TransformType transformType = new TransformType();
		transformType.setAlgorithm("http://www.w3.org/2000/09/xmldsig#enveloped-signature");
		transformsType.getTransform().add(transformType);
		return transformsType;
	}
	
	private static CanonicalizationMethodType canonicalizationMethodType () {
		CanonicalizationMethodType canonicalizationMethodType = new CanonicalizationMethodType();
		canonicalizationMethodType.setAlgorithm("http://www.w3.org/TR/2001/REC-xml-c14n-20010315");
		return canonicalizationMethodType;
	}
	
	private static SignatureMethodType signatureMethodType() {
		SignatureMethodType signatureMethodType = new SignatureMethodType();
		signatureMethodType.setAlgorithm("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256");
		return signatureMethodType; 
	}
	
	private static CustomizationIDType customizationIDType(Documento documento) {
		CustomizationIDType customizationIDType = new CustomizationIDType();
		customizationIDType.setSchemeDataURI("http://www.dian.gov.co/micrositios/fac_electronica/documentos/");
		customizationIDType.setSchemeID("XSD/r1/DIAN_UBL.xsd");
		customizationIDType.setSchemeName("xsd aplicado a este documento-e. - xsi:schemaLocation. - cambios en la cardinalidad de algunos elementos");
		customizationIDType.setSchemeURI("http://www.dian.gov.co/");
		customizationIDType.setValue("CustomizationID");
		return customizationIDType;
	}
		
	private static ExtensionContentType extensionContentType(Documento documento,Marshaller marshaller) throws ParserConfigurationException, JAXBException {
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
	
	private static DianExtensionsType dianExtensionsType(Documento documento, Empresa empresa) {
		DianExtensionsType dianExtensionsType = new DianExtensionsType();
		dianExtensionsType.setInvoiceControl(invoiceControl(documento, empresa));
		dianExtensionsType.setInvoiceSource(countryType());
		dianExtensionsType.setSoftwareProvider(softwareProvider(empresa));
		dianExtensionsType.setSoftwareSecurityCode(softwareSecurityCode(empresa.getSoftwareSecurityCode()));
		return dianExtensionsType;
	}
	
	private static InvoiceControl invoiceControl(Documento documento, Empresa empresa) {
		//Fecha registro
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(documento.getFechaRegistro());
		XMLGregorianCalendar date2 = null;
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		//instancias
		PeriodType periodType = new PeriodType();
		StartDateType startDateType = new StartDateType();
		EndDateType endDateType = new EndDateType();
		InvoiceControl invoiceControl = new InvoiceControl();
		AuthrorizedInvoices authrorizedInvoices = new AuthrorizedInvoices();
		TextType textType = new TextType(); 
		
		//seteos
		startDateType.setValue(date2);
		endDateType.setValue(date2);		
		periodType.setStartDate(startDateType);
		periodType.setEndDate(endDateType);
		textType.setValue(documento.getPrefijo());
		authrorizedInvoices.setPrefix(documento.getPrefijo());
		authrorizedInvoices.setFrom(Long.parseLong(empresa.getAutorizacionDesde()));	//FECHA DESDE Y HASTA QUE ESTA EN TABLA EMPRESA
		authrorizedInvoices.setTo(Integer.parseInt(empresa.getAutorizacionHasta()));
		invoiceControl.setInvoiceAuthorization(new  BigDecimal("1234567890"));			//NI IDEA ESTE REGISTRO
		invoiceControl.setAuthorizationPeriod(periodType);
		invoiceControl.setAuthorizedInvoices(authrorizedInvoices);	
		return invoiceControl;
	}

	private static CountryType countryType() {
		IdentificationCodeType identificationCodeType = new IdentificationCodeType();
		identificationCodeType.setListAgencyID("6");
		identificationCodeType.setListAgencyName("United Nations Economic Commission for Europe");
		identificationCodeType.setListSchemeURI("urn:oasis:names:specification:ubl:codelist:gc:CountryIdentificationCode-2.0");
		identificationCodeType.setValue("CO");
		CountryType countryType = new CountryType();
		countryType.setIdentificationCode(identificationCodeType);
		return countryType;
	}
	
	private static SoftwareProvider softwareProvider(Empresa empresa) {
		SoftwareProvider softwareProvider = new SoftwareProvider();
		IdentifierType identifierTypeProviderID = new IdentifierType();
		identifierTypeProviderID.setSchemeID("195");
		identifierTypeProviderID.setSchemeAgencyName("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)");
		identifierTypeProviderID.setValue(empresa.getNit());
		IdentifierType identifierTypeSoftwareID = new IdentifierType();
		identifierTypeSoftwareID.setSchemeID("195");
		identifierTypeSoftwareID.setSchemeAgencyName("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)");
		identifierTypeSoftwareID.setValue(empresa.getSoftwareID());
		softwareProvider.setProviderID(identifierTypeProviderID);
		softwareProvider.setSoftwareID(identifierTypeSoftwareID);
		return softwareProvider;
	}
	
	private static IdentifierType softwareSecurityCode(String SoftwareSecutityCode) {
		IdentifierType identifierType = new IdentifierType();
		identifierType.setSchemeID("195");
		identifierType.setSchemeAgencyName("CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)");
		identifierType.setValue(SoftwareSecutityCode);
		return identifierType;
	}
}
