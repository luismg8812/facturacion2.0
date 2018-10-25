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
import org.w3._2000._09.xmldsig_.TransformsType;


/**
 * <p>Clase Java para SignaturePolicyIdType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SignaturePolicyIdType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SigPolicyId" type="{http://uri.etsi.org/01903/v1.3.2#}ObjectIdentifierType"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Transforms" minOccurs="0"/>
 *         &lt;element name="SigPolicyHash" type="{http://uri.etsi.org/01903/v1.3.2#}DigestAlgAndValueType"/>
 *         &lt;element name="SigPolicyQualifiers" type="{http://uri.etsi.org/01903/v1.3.2#}SigPolicyQualifiersListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignaturePolicyIdType", propOrder = {
    "sigPolicyId",
    "transforms",
    "sigPolicyHash",
    "sigPolicyQualifiers"
})
public class SignaturePolicyIdType {

    @XmlElement(name = "SigPolicyId", required = true)
    protected ObjectIdentifierType sigPolicyId;
    @XmlElement(name = "Transforms", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected TransformsType transforms;
    @XmlElement(name = "SigPolicyHash", required = true)
    protected DigestAlgAndValueType sigPolicyHash;
    @XmlElement(name = "SigPolicyQualifiers")
    protected SigPolicyQualifiersListType sigPolicyQualifiers;

    /**
     * Obtiene el valor de la propiedad sigPolicyId.
     * 
     * @return
     *     possible object is
     *     {@link ObjectIdentifierType }
     *     
     */
    public ObjectIdentifierType getSigPolicyId() {
        return sigPolicyId;
    }

    /**
     * Define el valor de la propiedad sigPolicyId.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectIdentifierType }
     *     
     */
    public void setSigPolicyId(ObjectIdentifierType value) {
        this.sigPolicyId = value;
    }

    /**
     * Obtiene el valor de la propiedad transforms.
     * 
     * @return
     *     possible object is
     *     {@link TransformsType }
     *     
     */
    public TransformsType getTransforms() {
        return transforms;
    }

    /**
     * Define el valor de la propiedad transforms.
     * 
     * @param value
     *     allowed object is
     *     {@link TransformsType }
     *     
     */
    public void setTransforms(TransformsType value) {
        this.transforms = value;
    }

    /**
     * Obtiene el valor de la propiedad sigPolicyHash.
     * 
     * @return
     *     possible object is
     *     {@link DigestAlgAndValueType }
     *     
     */
    public DigestAlgAndValueType getSigPolicyHash() {
        return sigPolicyHash;
    }

    /**
     * Define el valor de la propiedad sigPolicyHash.
     * 
     * @param value
     *     allowed object is
     *     {@link DigestAlgAndValueType }
     *     
     */
    public void setSigPolicyHash(DigestAlgAndValueType value) {
        this.sigPolicyHash = value;
    }

    /**
     * Obtiene el valor de la propiedad sigPolicyQualifiers.
     * 
     * @return
     *     possible object is
     *     {@link SigPolicyQualifiersListType }
     *     
     */
    public SigPolicyQualifiersListType getSigPolicyQualifiers() {
        return sigPolicyQualifiers;
    }

    /**
     * Define el valor de la propiedad sigPolicyQualifiers.
     * 
     * @param value
     *     allowed object is
     *     {@link SigPolicyQualifiersListType }
     *     
     */
    public void setSigPolicyQualifiers(SigPolicyQualifiersListType value) {
        this.sigPolicyQualifiers = value;
    }

}
