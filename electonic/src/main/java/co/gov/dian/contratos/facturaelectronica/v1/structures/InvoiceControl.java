//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.10.08 a las 09:39:43 AM COT 
//


package co.gov.dian.contratos.facturaelectronica.v1.structures;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;


/**
 *  1.3 - Datos Resoluci�n de
 * 				Numeraci�n de Facturas
 * 			
 * 
 * <p>Clase Java para InvoiceControl complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InvoiceControl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InvoiceAuthorization" type="{urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2}NumericType"/>
 *         &lt;element name="AuthorizationPeriod" type="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PeriodType"/>
 *         &lt;element name="AuthorizedInvoices" type="{http://www.dian.gov.co/contratos/facturaelectronica/v1/Structures}AuthrorizedInvoices"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvoiceControl", propOrder = {
    "invoiceAuthorization",
    "authorizationPeriod",
    "authorizedInvoices"
})
public class InvoiceControl {

    @XmlElement(name = "InvoiceAuthorization", required = true)
    protected BigDecimal invoiceAuthorization;
    @XmlElement(name = "AuthorizationPeriod", required = true)
    protected PeriodType authorizationPeriod;
    @XmlElement(name = "AuthorizedInvoices", required = true)
    protected AuthrorizedInvoices authorizedInvoices;

    /**
     * Obtiene el valor de la propiedad invoiceAuthorization.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInvoiceAuthorization() {
        return invoiceAuthorization;
    }

    /**
     * Define el valor de la propiedad invoiceAuthorization.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInvoiceAuthorization(BigDecimal value) {
        this.invoiceAuthorization = value;
    }

    /**
     * Obtiene el valor de la propiedad authorizationPeriod.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getAuthorizationPeriod() {
        return authorizationPeriod;
    }

    /**
     * Define el valor de la propiedad authorizationPeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setAuthorizationPeriod(PeriodType value) {
        this.authorizationPeriod = value;
    }

    /**
     * Obtiene el valor de la propiedad authorizedInvoices.
     * 
     * @return
     *     possible object is
     *     {@link AuthrorizedInvoices }
     *     
     */
    public AuthrorizedInvoices getAuthorizedInvoices() {
        return authorizedInvoices;
    }

    /**
     * Define el valor de la propiedad authorizedInvoices.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthrorizedInvoices }
     *     
     */
    public void setAuthorizedInvoices(AuthrorizedInvoices value) {
        this.authorizedInvoices = value;
    }

}
