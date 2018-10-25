//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.10.22 a las 11:46:16 AM COT 
//


package org.etsi.uri._01903.v1_3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CRLRefType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CRLRefType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DigestAlgAndValue" type="{http://uri.etsi.org/01903/v1.3.2#}DigestAlgAndValueType"/>
 *         &lt;element name="CRLIdentifier" type="{http://uri.etsi.org/01903/v1.3.2#}CRLIdentifierType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRLRefType", propOrder = {
    "digestAlgAndValue",
    "crlIdentifier"
})
public class CRLRefType {

    @XmlElement(name = "DigestAlgAndValue", required = true)
    protected DigestAlgAndValueType digestAlgAndValue;
    @XmlElement(name = "CRLIdentifier")
    protected CRLIdentifierType crlIdentifier;

    /**
     * Obtiene el valor de la propiedad digestAlgAndValue.
     * 
     * @return
     *     possible object is
     *     {@link DigestAlgAndValueType }
     *     
     */
    public DigestAlgAndValueType getDigestAlgAndValue() {
        return digestAlgAndValue;
    }

    /**
     * Define el valor de la propiedad digestAlgAndValue.
     * 
     * @param value
     *     allowed object is
     *     {@link DigestAlgAndValueType }
     *     
     */
    public void setDigestAlgAndValue(DigestAlgAndValueType value) {
        this.digestAlgAndValue = value;
    }

    /**
     * Obtiene el valor de la propiedad crlIdentifier.
     * 
     * @return
     *     possible object is
     *     {@link CRLIdentifierType }
     *     
     */
    public CRLIdentifierType getCRLIdentifier() {
        return crlIdentifier;
    }

    /**
     * Define el valor de la propiedad crlIdentifier.
     * 
     * @param value
     *     allowed object is
     *     {@link CRLIdentifierType }
     *     
     */
    public void setCRLIdentifier(CRLIdentifierType value) {
        this.crlIdentifier = value;
    }

}
