//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.10.08 a las 09:39:43 AM COT 
//


package co.gov.dian.contratos.facturaelectronica.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.BillingReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ExchangeRateType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentTermsType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoiceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineCountNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProfileIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UBLVersionIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UUIDType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionsType;


/**
 * <p>Clase Java para InvoiceType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InvoiceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2}UBLExtensions"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UBLVersionID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CustomizationID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ProfileID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UUID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}IssueDate"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}IssueTime"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InvoiceTypeCode"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DocumentCurrencyCode"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AccountingCostCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AccountingCost" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LineCountNumeric" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}InvoicePeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OrderReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}BillingReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DespatchDocumentReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ReceiptDocumentReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginatorDocumentReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractDocumentReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AdditionalDocumentReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}AccountingSupplierParty"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}AccountingCustomerParty"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PayeeParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}BuyerCustomerParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SellerSupplierParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxRepresentativeParty" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}Delivery" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}DeliveryTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentMeans" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentTerms" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}PrepaidPayment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}AllowanceCharge" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentExchangeRate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentAlternativeExchangeRate" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}TaxTotal" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}LegalMonetaryTotal"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}InvoiceLine" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Invoice")
@XmlType(name = "InvoiceType", propOrder = {
    "ublExtensions",
    "ublVersionID",
    "customizationID",
    "profileID",
    "id",
    "uuid",
    "issueDate",
    "issueTime",
    "invoiceTypeCode",
    "note",
    "documentCurrencyCode",
    "accountingCostCode",
    "accountingCost",
    "lineCountNumeric",
    "invoicePeriod",
    "orderReference",
    "billingReference",
    "despatchDocumentReference",
    "receiptDocumentReference",
    "originatorDocumentReference",
    "contractDocumentReference",
    "additionalDocumentReference",
    "accountingSupplierParty",
    "accountingCustomerParty",
    "payeeParty",
    "buyerCustomerParty",
    "sellerSupplierParty",
    "taxRepresentativeParty",
    "delivery",
    "deliveryTerms",
    "paymentMeans",
    "paymentTerms",
    "prepaidPayment",
    "allowanceCharge",
    "paymentExchangeRate",
    "paymentAlternativeExchangeRate",
    "taxTotal",
    "legalMonetaryTotal",
    "invoiceLine"
})
public class InvoiceType {

    @XmlElement(name = "UBLExtensions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2", required = true)
    protected UBLExtensionsType ublExtensions;
    @XmlElement(name = "UBLVersionID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected UBLVersionIDType ublVersionID;
    @XmlElement(name = "CustomizationID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CustomizationIDType customizationID;
    @XmlElement(name = "ProfileID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ProfileIDType profileID;
    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "UUID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected UUIDType uuid;
    @XmlElement(name = "IssueDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IssueDateType issueDate;
    @XmlElement(name = "IssueTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IssueTimeType issueTime;
    @XmlElement(name = "InvoiceTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected InvoiceTypeCodeType invoiceTypeCode;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "DocumentCurrencyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected DocumentCurrencyCodeType documentCurrencyCode;
    @XmlElement(name = "AccountingCostCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AccountingCostCodeType accountingCostCode;
    @XmlElement(name = "AccountingCost", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AccountingCostType accountingCost;
    @XmlElement(name = "LineCountNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LineCountNumericType lineCountNumeric;
    @XmlElement(name = "InvoicePeriod", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected PeriodType invoicePeriod;
    @XmlElement(name = "OrderReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<OrderReferenceType> orderReference;
    @XmlElement(name = "BillingReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<BillingReferenceType> billingReference;
    @XmlElement(name = "DespatchDocumentReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<DocumentReferenceType> despatchDocumentReference;
    @XmlElement(name = "ReceiptDocumentReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<DocumentReferenceType> receiptDocumentReference;
    @XmlElement(name = "OriginatorDocumentReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<DocumentReferenceType> originatorDocumentReference;
    @XmlElement(name = "ContractDocumentReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<DocumentReferenceType> contractDocumentReference;
    @XmlElement(name = "AdditionalDocumentReference", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<DocumentReferenceType> additionalDocumentReference;
    @XmlElement(name = "AccountingSupplierParty", required = true)
    protected co.gov.dian.contratos.facturaelectronica.v1.SupplierPartyType accountingSupplierParty;
    @XmlElement(name = "AccountingCustomerParty", required = true)
    protected co.gov.dian.contratos.facturaelectronica.v1.CustomerPartyType accountingCustomerParty;
    @XmlElement(name = "PayeeParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected PartyType payeeParty;
    @XmlElement(name = "BuyerCustomerParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType buyerCustomerParty;
    @XmlElement(name = "SellerSupplierParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType sellerSupplierParty;
    @XmlElement(name = "TaxRepresentativeParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected PartyType taxRepresentativeParty;
    @XmlElement(name = "Delivery")
    protected List<DeliveryType> delivery;
    @XmlElement(name = "DeliveryTerms")
    protected DeliveryTermsType deliveryTerms;
    @XmlElement(name = "PaymentMeans", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<PaymentMeansType> paymentMeans;
    @XmlElement(name = "PaymentTerms", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<PaymentTermsType> paymentTerms;
    @XmlElement(name = "PrepaidPayment")
    protected List<PaymentType> prepaidPayment;
    @XmlElement(name = "AllowanceCharge")
    protected List<AllowanceChargeType> allowanceCharge;
    @XmlElement(name = "PaymentExchangeRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected ExchangeRateType paymentExchangeRate;
    @XmlElement(name = "PaymentAlternativeExchangeRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected ExchangeRateType paymentAlternativeExchangeRate;
    @XmlElement(name = "TaxTotal")
    protected List<TaxTotalType> taxTotal;
    @XmlElement(name = "LegalMonetaryTotal", required = true)
    protected MonetaryTotalType legalMonetaryTotal;
    @XmlElement(name = "InvoiceLine", required = true)
    protected List<InvoiceLineType> invoiceLine;

    /**
     * 
     * 						Debe usar como m�nimo extensiones definidas por
     * 						DIAN para toda factura electr�nica
     * 					
     * 
     * @return
     *     possible object is
     *     {@link UBLExtensionsType }
     *     
     */
    public UBLExtensionsType getUBLExtensions() {
        return ublExtensions;
    }

    /**
     * Define el valor de la propiedad ublExtensions.
     * 
     * @param value
     *     allowed object is
     *     {@link UBLExtensionsType }
     *     
     */
    public void setUBLExtensions(UBLExtensionsType value) {
        this.ublExtensions = value;
    }

    /**
     * 
     * 						Debe marcar UBL 2.0 (versi�n base de UBL usada
     * 						para crear este perfil)
     * 					
     * 
     * @return
     *     possible object is
     *     {@link UBLVersionIDType }
     *     
     */
    public UBLVersionIDType getUBLVersionID() {
        return ublVersionID;
    }

    /**
     * Define el valor de la propiedad ublVersionID.
     * 
     * @param value
     *     allowed object is
     *     {@link UBLVersionIDType }
     *     
     */
    public void setUBLVersionID(UBLVersionIDType value) {
        this.ublVersionID = value;
    }

    /**
     * 
     * 						2017-oct-20: Precisando la descripci�n del Invoice que se utiliz� para conformar el XML; la precisi�n se hace a trav�s de los atributos
     * 					
     * 
     * @return
     *     possible object is
     *     {@link CustomizationIDType }
     *     
     */
    public CustomizationIDType getCustomizationID() {
        return customizationID;
    }

    /**
     * Define el valor de la propiedad customizationID.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationIDType }
     *     
     */
    public void setCustomizationID(CustomizationIDType value) {
        this.customizationID = value;
    }

    /**
     * 
     * 						1.5 - Versi�n del Formato: Indicar versi�n del
     * 						documento. Debe usarse "DIAN 1.0"
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ProfileIDType }
     *     
     */
    public ProfileIDType getProfileID() {
        return profileID;
    }

    /**
     * Define el valor de la propiedad profileID.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileIDType }
     *     
     */
    public void setProfileID(ProfileIDType value) {
        this.profileID = value;
    }

    /**
     * 
     * 						1.1 N�mero de documento: N�mero de factura o factura cambiaria. 
     * 						Incluye prefijo + consecutivo de factura. 
     * 						No se permiten caracteres adicionales como espacios o guiones.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getID() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setID(IDType value) {
        this.id = value;
    }

    /**
     * 
     * 						1.10 - CUFE: Obligatorio si es factura nacional.
     * 						Codigo Unico de Facturacion Electronica. Campo
     * 						que verifica la integridad de la informaci�n
     * 						recibida, es un campo generado por el sistema
     * 						Numeraci�n de facturaci�n, est� pendiente
     * 						definir su contenido. Esta Encriptado. La
     * 						factura electr�nica tiene una firma electr�nica
     * 						basada en firma digital seg�n la pol�tica de
     * 						firma propuesta. La integridad de la factura ya
     * 						viene asegurada por la firma digital, no es
     * 						necesaria ninguna medida m�s para asegurar que
     * 						ning�n campo ha sido alterado
     * 					
     * 
     * @return
     *     possible object is
     *     {@link UUIDType }
     *     
     */
    public UUIDType getUUID() {
        return uuid;
    }

    /**
     * Define el valor de la propiedad uuid.
     * 
     * @param value
     *     allowed object is
     *     {@link UUIDType }
     *     
     */
    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    /**
     * 
     * 						1.7 Fecha de emisi�n: Fecha de emisi�n de la
     * 						factura a efectos fiscales
     * 					
     * 
     * @return
     *     possible object is
     *     {@link IssueDateType }
     *     
     */
    public IssueDateType getIssueDate() {
        return issueDate;
    }

    /**
     * Define el valor de la propiedad issueDate.
     * 
     * @param value
     *     allowed object is
     *     {@link IssueDateType }
     *     
     */
    public void setIssueDate(IssueDateType value) {
        this.issueDate = value;
    }

    /**
     * 
     * 						1.7 (Hora) de emisi�n
     * 					
     * 
     * @return
     *     possible object is
     *     {@link IssueTimeType }
     *     
     */
    public IssueTimeType getIssueTime() {
        return issueTime;
    }

    /**
     * Define el valor de la propiedad issueTime.
     * 
     * @param value
     *     allowed object is
     *     {@link IssueTimeType }
     *     
     */
    public void setIssueTime(IssueTimeType value) {
        this.issueTime = value;
    }

    /**
     * 
     * 						2017-oct-20: Tipo de Factura, c�digo: facturas de venta, y transcripciones; tipo = 1 para factura de venta; tipo = 2 para factura de venta de bienes o servicios exportados; tipo = 3 para la transcripci�n de datos al formato UBL-Invoice-DIAN desde la factura de venta expedida por talonario en ocasi�n de una contingencia del sistema de factura electr�nica del OFE (i.e. obligado a facturar electr�nicamente). V�ase el Art�culo 8 de la Resoluci�n 0055-2016 que modific� el Numeral 1 del Art�culo 11 de la Resoluci�n 0019-2016. - Se hab�a anunciado de manera informal que ser�a utilizado en tipo = 4 para informar a la autoridad TAC (i.e. tributaria, aduanera y cambiaria), por transcripci�n de datos, las facturas de los bienes y servicios adquiridos en el exterior e importados al territorio aduanero nacional. Este tipo de factura de importaci�n no entrar� por ahora en operaci�n.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link InvoiceTypeCodeType }
     *     
     */
    public InvoiceTypeCodeType getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    /**
     * Define el valor de la propiedad invoiceTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceTypeCodeType }
     *     
     */
    public void setInvoiceTypeCode(InvoiceTypeCodeType value) {
        this.invoiceTypeCode = value;
    }

    /**
     * 
     * 						1.11 Informaci�n adicional: Texto libre,
     * 						relativo al documento
     * 					Gets the value of the note property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the note property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoteType }
     * 
     * 
     */
    public List<NoteType> getNote() {
        if (note == null) {
            note = new ArrayList<NoteType>();
        }
        return this.note;
    }

    /**
     * 
     * 						9.10 Divisa de la Factura: Divisa consolidada
     * 						aplicable a toda la factura
     * 					
     * 
     * @return
     *     possible object is
     *     {@link DocumentCurrencyCodeType }
     *     
     */
    public DocumentCurrencyCodeType getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    /**
     * Define el valor de la propiedad documentCurrencyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentCurrencyCodeType }
     *     
     */
    public void setDocumentCurrencyCode(DocumentCurrencyCodeType value) {
        this.documentCurrencyCode = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AccountingCostCodeType }
     *     
     */
    public AccountingCostCodeType getAccountingCostCode() {
        return accountingCostCode;
    }

    /**
     * Define el valor de la propiedad accountingCostCode.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingCostCodeType }
     *     
     */
    public void setAccountingCostCode(AccountingCostCodeType value) {
        this.accountingCostCode = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AccountingCostType }
     *     
     */
    public AccountingCostType getAccountingCost() {
        return accountingCost;
    }

    /**
     * Define el valor de la propiedad accountingCost.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingCostType }
     *     
     */
    public void setAccountingCost(AccountingCostType value) {
        this.accountingCost = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link LineCountNumericType }
     *     
     */
    public LineCountNumericType getLineCountNumeric() {
        return lineCountNumeric;
    }

    /**
     * Define el valor de la propiedad lineCountNumeric.
     * 
     * @param value
     *     allowed object is
     *     {@link LineCountNumericType }
     *     
     */
    public void setLineCountNumeric(LineCountNumericType value) {
        this.lineCountNumeric = value;
    }

    /**
     * 
     * 						1.8 Periodo de Facturaci�n: Intervalo de fechas
     * 						a las que referencia la factura
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getInvoicePeriod() {
        return invoicePeriod;
    }

    /**
     * Define el valor de la propiedad invoicePeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setInvoicePeriod(PeriodType value) {
        this.invoicePeriod = value;
    }

    /**
     * 
     * 						3.1.1 Referencia Documento (orden): Referencia a
     * 						un documento
     * 					Gets the value of the orderReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderReferenceType }
     * 
     * 
     */
    public List<OrderReferenceType> getOrderReference() {
        if (orderReference == null) {
            orderReference = new ArrayList<OrderReferenceType>();
        }
        return this.orderReference;
    }

    /**
     * 
     * 						3.1.1 Referencia Documento (orden): Referencia a
     * 						un documento
     * 					Gets the value of the billingReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billingReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillingReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BillingReferenceType }
     * 
     * 
     */
    public List<BillingReferenceType> getBillingReference() {
        if (billingReference == null) {
            billingReference = new ArrayList<BillingReferenceType>();
        }
        return this.billingReference;
    }

    /**
     * 
     * 						3.1.1 Referencia Documento (despacho):
     * 						Referencia a un documento
     * 					Gets the value of the despatchDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the despatchDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDespatchDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getDespatchDocumentReference() {
        if (despatchDocumentReference == null) {
            despatchDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.despatchDocumentReference;
    }

    /**
     * 
     * 						3.1.1 Referencia Documento (recepci�n):
     * 						Referencia a un documento
     * 					Gets the value of the receiptDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the receiptDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReceiptDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getReceiptDocumentReference() {
        if (receiptDocumentReference == null) {
            receiptDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.receiptDocumentReference;
    }

    /**
     * 
     * 						3.1.1 Referencia Documento (origen): Referencia
     * 						a un documento
     * 					Gets the value of the originatorDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the originatorDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOriginatorDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getOriginatorDocumentReference() {
        if (originatorDocumentReference == null) {
            originatorDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.originatorDocumentReference;
    }

    /**
     * 
     * 						3.1.1 Referencia Documento (contrato):
     * 						Referencia a un documento
     * 					Gets the value of the contractDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getContractDocumentReference() {
        if (contractDocumentReference == null) {
            contractDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.contractDocumentReference;
    }

    /**
     * 
     * 						3.1.1 Referencia Documento: Referencia a un
     * 						documento
     * 					Gets the value of the additionalDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getAdditionalDocumentReference() {
        if (additionalDocumentReference == null) {
            additionalDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.additionalDocumentReference;
    }

    /**
     * 
     * 						2.1 - Obligado a Facturar:
     * 					
     * 
     * @return
     *     possible object is
     *     {@link co.gov.dian.contratos.facturaelectronica.v1.SupplierPartyType }
     *     
     */
    public co.gov.dian.contratos.facturaelectronica.v1.SupplierPartyType getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    /**
     * Define el valor de la propiedad accountingSupplierParty.
     * 
     * @param value
     *     allowed object is
     *     {@link co.gov.dian.contratos.facturaelectronica.v1.SupplierPartyType }
     *     
     */
    public void setAccountingSupplierParty(co.gov.dian.contratos.facturaelectronica.v1.SupplierPartyType value) {
        this.accountingSupplierParty = value;
    }

    /**
     * 
     * 						2.2 - Adquirente:
     * 					
     * 
     * @return
     *     possible object is
     *     {@link co.gov.dian.contratos.facturaelectronica.v1.CustomerPartyType }
     *     
     */
    public co.gov.dian.contratos.facturaelectronica.v1.CustomerPartyType getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    /**
     * Define el valor de la propiedad accountingCustomerParty.
     * 
     * @param value
     *     allowed object is
     *     {@link co.gov.dian.contratos.facturaelectronica.v1.CustomerPartyType }
     *     
     */
    public void setAccountingCustomerParty(co.gov.dian.contratos.facturaelectronica.v1.CustomerPartyType value) {
        this.accountingCustomerParty = value;
    }

    /**
     * 
     * 						11.5 - Receptor del Pago: Participante, Entidad,
     * 						Departamento, Unidad, destinatario de la
     * 						factura. Suele coincidir con el obligado a
     * 						facturar Ver composici�n en la estructura com�n
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getPayeeParty() {
        return payeeParty;
    }

    /**
     * Define el valor de la propiedad payeeParty.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setPayeeParty(PartyType value) {
        this.payeeParty = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType }
     *     
     */
    public oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType getBuyerCustomerParty() {
        return buyerCustomerParty;
    }

    /**
     * Define el valor de la propiedad buyerCustomerParty.
     * 
     * @param value
     *     allowed object is
     *     {@link oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType }
     *     
     */
    public void setBuyerCustomerParty(oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType value) {
        this.buyerCustomerParty = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType }
     *     
     */
    public oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType getSellerSupplierParty() {
        return sellerSupplierParty;
    }

    /**
     * Define el valor de la propiedad sellerSupplierParty.
     * 
     * @param value
     *     allowed object is
     *     {@link oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType }
     *     
     */
    public void setSellerSupplierParty(oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType value) {
        this.sellerSupplierParty = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getTaxRepresentativeParty() {
        return taxRepresentativeParty;
    }

    /**
     * Define el valor de la propiedad taxRepresentativeParty.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setTaxRepresentativeParty(PartyType value) {
        this.taxRepresentativeParty = value;
    }

    /**
     * 
     * 						10 - 2.1.10 Datos T�rminos de Entrega:
     * 						Agrupaci�n de campos relativos al transporte o
     * 						entrega de los bienes. Se presenta nuevos
     * 						participantes relativos a la entrega, como el
     * 						transportista
     * 					Gets the value of the delivery property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the delivery property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDelivery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeliveryType }
     * 
     * 
     */
    public List<DeliveryType> getDelivery() {
        if (delivery == null) {
            delivery = new ArrayList<DeliveryType>();
        }
        return this.delivery;
    }

    /**
     * 
     * 						2.2.10 - Medios de Transporte
     * 					
     * 
     * @return
     *     possible object is
     *     {@link DeliveryTermsType }
     *     
     */
    public DeliveryTermsType getDeliveryTerms() {
        return deliveryTerms;
    }

    /**
     * Define el valor de la propiedad deliveryTerms.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryTermsType }
     *     
     */
    public void setDeliveryTerms(DeliveryTermsType value) {
        this.deliveryTerms = value;
    }

    /**
     * 
     * 						12.1 - Datos del Pago: Informaci�n relativa al
     * 						pago de la factura.
     * 					Gets the value of the paymentMeans property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentMeans property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentMeans().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentMeansType }
     * 
     * 
     */
    public List<PaymentMeansType> getPaymentMeans() {
        if (paymentMeans == null) {
            paymentMeans = new ArrayList<PaymentMeansType>();
        }
        return this.paymentMeans;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					Gets the value of the paymentTerms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentTerms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentTerms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTermsType }
     * 
     * 
     */
    public List<PaymentTermsType> getPaymentTerms() {
        if (paymentTerms == null) {
            paymentTerms = new ArrayList<PaymentTermsType>();
        }
        return this.paymentTerms;
    }

    /**
     * 
     * 						6.1.1 - Anticipo: Elemento ra�z compuesto
     * 						utilizado para informar de un anticipo.
     * 					Gets the value of the prepaidPayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prepaidPayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrepaidPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentType }
     * 
     * 
     */
    public List<PaymentType> getPrepaidPayment() {
        if (prepaidPayment == null) {
            prepaidPayment = new ArrayList<PaymentType>();
        }
        return this.prepaidPayment;
    }

    /**
     * 
     * 						5.1.1 Cargo - Elemento ra�z compuesto utilizado
     * 						para informar de un cargo. / 4.1.1 Descuento:
     * 						Elemento ra�z compuesto utilizado para informar
     * 						de un descuento
     * 					Gets the value of the allowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.allowanceCharge;
    }

    /**
     * 
     * 						9.11 Tasa Cambio Peso Colombiano: Tasa de cambio
     * 						de moneda extranjera a peso colombiano (COP).
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ExchangeRateType }
     *     
     */
    public ExchangeRateType getPaymentExchangeRate() {
        return paymentExchangeRate;
    }

    /**
     * Define el valor de la propiedad paymentExchangeRate.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeRateType }
     *     
     */
    public void setPaymentExchangeRate(ExchangeRateType value) {
        this.paymentExchangeRate = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ExchangeRateType }
     *     
     */
    public ExchangeRateType getPaymentAlternativeExchangeRate() {
        return paymentAlternativeExchangeRate;
    }

    /**
     * Define el valor de la propiedad paymentAlternativeExchangeRate.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeRateType }
     *     
     */
    public void setPaymentAlternativeExchangeRate(ExchangeRateType value) {
        this.paymentAlternativeExchangeRate = value;
    }

    /**
     * 
     * 						7.1.1 - Impuesto Retenido: Elemento ra�z
     * 						compuesto utilizado para informar de un impuesto
     * 						retenido. / 8.1.1 - Impuesto: Elemento ra�z
     * 						compuesto utilizado para informar de un
     * 						impuesto.
     * 					Gets the value of the taxTotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxTotal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxTotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxTotalType }
     * 
     * 
     */
    public List<TaxTotalType> getTaxTotal() {
        if (taxTotal == null) {
            taxTotal = new ArrayList<TaxTotalType>();
        }
        return this.taxTotal;
    }

    /**
     * 
     * 						9 - Datos Importes Totales: Agrupaci�n de campos
     * 						relativos a los importes totales aplicables a la
     * 						factura. Estos importes son calculados teniendo
     * 						en cuenta las l�neas de factura y elementos a
     * 						nivel de factura, como descuentos, cargos,
     * 						impuestos, etc
     * 					
     * 
     * @return
     *     possible object is
     *     {@link MonetaryTotalType }
     *     
     */
    public MonetaryTotalType getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    /**
     * Define el valor de la propiedad legalMonetaryTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link MonetaryTotalType }
     *     
     */
    public void setLegalMonetaryTotal(MonetaryTotalType value) {
        this.legalMonetaryTotal = value;
    }

    /**
     * 
     * 						13.1.1 - L�nea de Factura: Elemento que agrupa
     * 						todos los campos de una l�nea de factura
     * 					Gets the value of the invoiceLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invoiceLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvoiceLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InvoiceLineType }
     * 
     * 
     */
    public List<InvoiceLineType> getInvoiceLine() {
        if (invoiceLine == null) {
            invoiceLine = new ArrayList<InvoiceLineType>();
        }
        return this.invoiceLine;
    }

}
