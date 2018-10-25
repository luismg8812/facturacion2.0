//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.10.22 a las 11:46:16 AM COT 
//


package org.etsi.uri._01903.v1_3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Clase Java para CompleteRevocationRefsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CompleteRevocationRefsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CRLRefs" type="{http://uri.etsi.org/01903/v1.3.2#}CRLRefsType" minOccurs="0"/>
 *         &lt;element name="OCSPRefs" type="{http://uri.etsi.org/01903/v1.3.2#}OCSPRefsType" minOccurs="0"/>
 *         &lt;element name="OtherRefs" type="{http://uri.etsi.org/01903/v1.3.2#}OtherCertStatusRefsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompleteRevocationRefsType", propOrder = {
    "crlRefs",
    "ocspRefs",
    "otherRefs"
})
public class CompleteRevocationRefsType {

    @XmlElement(name = "CRLRefs")
    protected CRLRefsType crlRefs;
    @XmlElement(name = "OCSPRefs")
    protected OCSPRefsType ocspRefs;
    @XmlElement(name = "OtherRefs")
    protected OtherCertStatusRefsType otherRefs;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Obtiene el valor de la propiedad crlRefs.
     * 
     * @return
     *     possible object is
     *     {@link CRLRefsType }
     *     
     */
    public CRLRefsType getCRLRefs() {
        return crlRefs;
    }

    /**
     * Define el valor de la propiedad crlRefs.
     * 
     * @param value
     *     allowed object is
     *     {@link CRLRefsType }
     *     
     */
    public void setCRLRefs(CRLRefsType value) {
        this.crlRefs = value;
    }

    /**
     * Obtiene el valor de la propiedad ocspRefs.
     * 
     * @return
     *     possible object is
     *     {@link OCSPRefsType }
     *     
     */
    public OCSPRefsType getOCSPRefs() {
        return ocspRefs;
    }

    /**
     * Define el valor de la propiedad ocspRefs.
     * 
     * @param value
     *     allowed object is
     *     {@link OCSPRefsType }
     *     
     */
    public void setOCSPRefs(OCSPRefsType value) {
        this.ocspRefs = value;
    }

    /**
     * Obtiene el valor de la propiedad otherRefs.
     * 
     * @return
     *     possible object is
     *     {@link OtherCertStatusRefsType }
     *     
     */
    public OtherCertStatusRefsType getOtherRefs() {
        return otherRefs;
    }

    /**
     * Define el valor de la propiedad otherRefs.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherCertStatusRefsType }
     *     
     */
    public void setOtherRefs(OtherCertStatusRefsType value) {
        this.otherRefs = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
