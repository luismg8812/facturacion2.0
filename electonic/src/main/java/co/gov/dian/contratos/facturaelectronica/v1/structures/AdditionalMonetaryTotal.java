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
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.AmountType;


/**
 * <p>Clase Java para AdditionalMonetaryTotal complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AdditionalMonetaryTotal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RepercussionsTotalTaxAmount" type="{urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2}AmountType" minOccurs="0"/>
 *         &lt;element name="RetainTotalTaxAmount" type="{urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2}AmountType" minOccurs="0"/>
 *         &lt;element name="InvoiceTotalLocalCurrencyAmount" type="{urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2}AmountType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdditionalMonetaryTotal", propOrder = {
    "repercussionsTotalTaxAmount",
    "retainTotalTaxAmount",
    "invoiceTotalLocalCurrencyAmount"
})
public class AdditionalMonetaryTotal {

    @XmlElement(name = "RepercussionsTotalTaxAmount")
    protected AmountType repercussionsTotalTaxAmount;
    @XmlElement(name = "RetainTotalTaxAmount")
    protected AmountType retainTotalTaxAmount;
    @XmlElement(name = "InvoiceTotalLocalCurrencyAmount")
    protected AmountType invoiceTotalLocalCurrencyAmount;

    /**
     * Obtiene el valor de la propiedad repercussionsTotalTaxAmount.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getRepercussionsTotalTaxAmount() {
        return repercussionsTotalTaxAmount;
    }

    /**
     * Define el valor de la propiedad repercussionsTotalTaxAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setRepercussionsTotalTaxAmount(AmountType value) {
        this.repercussionsTotalTaxAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad retainTotalTaxAmount.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getRetainTotalTaxAmount() {
        return retainTotalTaxAmount;
    }

    /**
     * Define el valor de la propiedad retainTotalTaxAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setRetainTotalTaxAmount(AmountType value) {
        this.retainTotalTaxAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad invoiceTotalLocalCurrencyAmount.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getInvoiceTotalLocalCurrencyAmount() {
        return invoiceTotalLocalCurrencyAmount;
    }

    /**
     * Define el valor de la propiedad invoiceTotalLocalCurrencyAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setInvoiceTotalLocalCurrencyAmount(AmountType value) {
        this.invoiceTotalLocalCurrencyAmount = value;
    }

}
