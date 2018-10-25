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
 * <p>Clase Java para SignedPropertiesType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SignedPropertiesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SignedSignatureProperties" type="{http://uri.etsi.org/01903/v1.3.2#}SignedSignaturePropertiesType" minOccurs="0"/>
 *         &lt;element name="SignedDataObjectProperties" type="{http://uri.etsi.org/01903/v1.3.2#}SignedDataObjectPropertiesType" minOccurs="0"/>
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
@XmlType(name = "SignedPropertiesType", propOrder = {
    "signedSignatureProperties",
    "signedDataObjectProperties"
})
public class SignedPropertiesType {

    @XmlElement(name = "SignedSignatureProperties")
    protected SignedSignaturePropertiesType signedSignatureProperties;
    @XmlElement(name = "SignedDataObjectProperties")
    protected SignedDataObjectPropertiesType signedDataObjectProperties;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Obtiene el valor de la propiedad signedSignatureProperties.
     * 
     * @return
     *     possible object is
     *     {@link SignedSignaturePropertiesType }
     *     
     */
    public SignedSignaturePropertiesType getSignedSignatureProperties() {
        return signedSignatureProperties;
    }

    /**
     * Define el valor de la propiedad signedSignatureProperties.
     * 
     * @param value
     *     allowed object is
     *     {@link SignedSignaturePropertiesType }
     *     
     */
    public void setSignedSignatureProperties(SignedSignaturePropertiesType value) {
        this.signedSignatureProperties = value;
    }

    /**
     * Obtiene el valor de la propiedad signedDataObjectProperties.
     * 
     * @return
     *     possible object is
     *     {@link SignedDataObjectPropertiesType }
     *     
     */
    public SignedDataObjectPropertiesType getSignedDataObjectProperties() {
        return signedDataObjectProperties;
    }

    /**
     * Define el valor de la propiedad signedDataObjectProperties.
     * 
     * @param value
     *     allowed object is
     *     {@link SignedDataObjectPropertiesType }
     *     
     */
    public void setSignedDataObjectProperties(SignedDataObjectPropertiesType value) {
        this.signedDataObjectProperties = value;
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
