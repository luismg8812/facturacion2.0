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
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.TextType;


/**
 * <p>Clase Java para AuthrorizedInvoices complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AuthrorizedInvoices">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Prefix" type="{urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2}TextType" minOccurs="0"/>
 *         &lt;element name="From" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="To" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthrorizedInvoices", propOrder = {
    "prefix",
    "from",
    "to"
})
public class AuthrorizedInvoices {

    @XmlElement(name = "Prefix")
    protected String prefix;
    @XmlElement(name = "From")
    protected long from;
    @XmlElement(name = "To")
    protected int to;

    /**
     * Obtiene el valor de la propiedad prefix.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Define el valor de la propiedad prefix.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPrefix(String value) {
        this.prefix = value;
    }

    /**
     * Obtiene el valor de la propiedad from.
     * 
     */
    public long getFrom() {
        return from;
    }

    /**
     * Define el valor de la propiedad from.
     * 
     */
    public void setFrom(long value) {
        this.from = value;
    }

    /**
     * Obtiene el valor de la propiedad to.
     * 
     */
    public int getTo() {
        return to;
    }

    /**
     * Define el valor de la propiedad to.
     * 
     */
    public void setTo(int value) {
        this.to = value;
    }

}
