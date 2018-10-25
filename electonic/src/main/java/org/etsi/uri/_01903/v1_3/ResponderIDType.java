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
 * <p>Clase Java para ResponderIDType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ResponderIDType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="ByName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ByKey" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponderIDType", propOrder = {
    "byName",
    "byKey"
})
public class ResponderIDType {

    @XmlElement(name = "ByName")
    protected String byName;
    @XmlElement(name = "ByKey")
    protected byte[] byKey;

    /**
     * Obtiene el valor de la propiedad byName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getByName() {
        return byName;
    }

    /**
     * Define el valor de la propiedad byName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setByName(String value) {
        this.byName = value;
    }

    /**
     * Obtiene el valor de la propiedad byKey.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getByKey() {
        return byKey;
    }

    /**
     * Define el valor de la propiedad byKey.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setByKey(byte[] value) {
        this.byKey = value;
    }

}
