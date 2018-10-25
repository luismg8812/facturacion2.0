//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.10.08 a las 09:39:43 AM COT 
//


package co.gov.dian.contratos.facturaelectronica.v1.structures;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CountryType;
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.IdentifierType;


/**
 * <p>Clase Java para DianExtensionsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DianExtensionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InvoiceControl" type="{http://www.dian.gov.co/contratos/facturaelectronica/v1/Structures}InvoiceControl" minOccurs="0"/>
 *         &lt;element name="InvoiceSource" type="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CountryType"/>
 *         &lt;element name="SoftwareProvider" type="{http://www.dian.gov.co/contratos/facturaelectronica/v1/Structures}SoftwareProvider"/>
 *         &lt;element name="SoftwareSecurityCode" type="{urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2}IdentifierType"/>
 *         &lt;element name="AdditionalMonetaryTotal" type="{http://www.dian.gov.co/contratos/facturaelectronica/v1/Structures}AdditionalMonetaryTotal" minOccurs="0"/>
 *         &lt;element name="FinancialInformation" type="{http://www.dian.gov.co/contratos/facturaelectronica/v1/Structures}FinancialInformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DianExtensions")
@XmlType(name = "DianExtensionsType", propOrder = {
    "invoiceControl",
    "invoiceSource",
    "softwareProvider",
    "softwareSecurityCode",
    "additionalMonetaryTotal",
    "financialInformation"
})
public class DianExtensionsType {

    @XmlElement(name = "InvoiceControl")
    protected InvoiceControl invoiceControl;
    @XmlElement(name = "InvoiceSource", required = true)
    protected CountryType invoiceSource;
    @XmlElement(name = "SoftwareProvider", required = true)
    protected SoftwareProvider softwareProvider;
    @XmlElement(name = "SoftwareSecurityCode", required = true)
    protected IdentifierType softwareSecurityCode;
    @XmlElement(name = "AdditionalMonetaryTotal")
    protected AdditionalMonetaryTotal additionalMonetaryTotal;
    @XmlElement(name = "FinancialInformation")
    protected FinancialInformation financialInformation;

    /**
     * Obtiene el valor de la propiedad invoiceControl.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceControl }
     *     
     */
    public InvoiceControl getInvoiceControl() {
        return invoiceControl;
    }

    /**
     * Define el valor de la propiedad invoiceControl.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceControl }
     *     
     */
    public void setInvoiceControl(InvoiceControl value) {
        this.invoiceControl = value;
    }

    /**
     * Obtiene el valor de la propiedad invoiceSource.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getInvoiceSource() {
        return invoiceSource;
    }

    /**
     * Define el valor de la propiedad invoiceSource.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setInvoiceSource(CountryType value) {
        this.invoiceSource = value;
    }

    /**
     * Obtiene el valor de la propiedad softwareProvider.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareProvider }
     *     
     */
    public SoftwareProvider getSoftwareProvider() {
        return softwareProvider;
    }

    /**
     * Define el valor de la propiedad softwareProvider.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareProvider }
     *     
     */
    public void setSoftwareProvider(SoftwareProvider value) {
        this.softwareProvider = value;
    }

    /**
     * Obtiene el valor de la propiedad softwareSecurityCode.
     * 
     * @return
     *     possible object is
     *     {@link IdentifierType }
     *     
     */
    public IdentifierType getSoftwareSecurityCode() {
        return softwareSecurityCode;
    }

    /**
     * Define el valor de la propiedad softwareSecurityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifierType }
     *     
     */
    public void setSoftwareSecurityCode(IdentifierType value) {
        this.softwareSecurityCode = value;
    }

    /**
     * Obtiene el valor de la propiedad additionalMonetaryTotal.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalMonetaryTotal }
     *     
     */
    public AdditionalMonetaryTotal getAdditionalMonetaryTotal() {
        return additionalMonetaryTotal;
    }

    /**
     * Define el valor de la propiedad additionalMonetaryTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalMonetaryTotal }
     *     
     */
    public void setAdditionalMonetaryTotal(AdditionalMonetaryTotal value) {
        this.additionalMonetaryTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad financialInformation.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInformation }
     *     
     */
    public FinancialInformation getFinancialInformation() {
        return financialInformation;
    }

    /**
     * Define el valor de la propiedad financialInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInformation }
     *     
     */
    public void setFinancialInformation(FinancialInformation value) {
        this.financialInformation = value;
    }

}
