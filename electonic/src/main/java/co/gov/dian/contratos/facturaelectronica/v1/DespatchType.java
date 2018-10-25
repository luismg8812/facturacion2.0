//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.10.08 a las 09:39:43 AM COT 
//


package co.gov.dian.contratos.facturaelectronica.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ContactType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDespatchDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDespatchTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedDespatchDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedDespatchTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedDespatchDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedDespatchTimeType;


/**
 * <p>Clase Java para DespatchType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DespatchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RequestedDespatchDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RequestedDespatchTime" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EstimatedDespatchDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EstimatedDespatchTime" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ActualDespatchDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ActualDespatchTime" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}DespatchAddress" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}DespatchParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Contact" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DespatchType", propOrder = {
    "id",
    "requestedDespatchDate",
    "requestedDespatchTime",
    "estimatedDespatchDate",
    "estimatedDespatchTime",
    "actualDespatchDate",
    "actualDespatchTime",
    "despatchAddress",
    "despatchParty",
    "contact"
})
public class DespatchType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "RequestedDespatchDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RequestedDespatchDateType requestedDespatchDate;
    @XmlElement(name = "RequestedDespatchTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RequestedDespatchTimeType requestedDespatchTime;
    @XmlElement(name = "EstimatedDespatchDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EstimatedDespatchDateType estimatedDespatchDate;
    @XmlElement(name = "EstimatedDespatchTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EstimatedDespatchTimeType estimatedDespatchTime;
    @XmlElement(name = "ActualDespatchDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ActualDespatchDateType actualDespatchDate;
    @XmlElement(name = "ActualDespatchTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ActualDespatchTimeType actualDespatchTime;
    @XmlElement(name = "DespatchAddress")
    protected AddressType despatchAddress;
    @XmlElement(name = "DespatchParty")
    protected PartyType despatchParty;
    @XmlElement(name = "Contact", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected ContactType contact;

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
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
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link RequestedDespatchDateType }
     *     
     */
    public RequestedDespatchDateType getRequestedDespatchDate() {
        return requestedDespatchDate;
    }

    /**
     * Define el valor de la propiedad requestedDespatchDate.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedDespatchDateType }
     *     
     */
    public void setRequestedDespatchDate(RequestedDespatchDateType value) {
        this.requestedDespatchDate = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link RequestedDespatchTimeType }
     *     
     */
    public RequestedDespatchTimeType getRequestedDespatchTime() {
        return requestedDespatchTime;
    }

    /**
     * Define el valor de la propiedad requestedDespatchTime.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedDespatchTimeType }
     *     
     */
    public void setRequestedDespatchTime(RequestedDespatchTimeType value) {
        this.requestedDespatchTime = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link EstimatedDespatchDateType }
     *     
     */
    public EstimatedDespatchDateType getEstimatedDespatchDate() {
        return estimatedDespatchDate;
    }

    /**
     * Define el valor de la propiedad estimatedDespatchDate.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimatedDespatchDateType }
     *     
     */
    public void setEstimatedDespatchDate(EstimatedDespatchDateType value) {
        this.estimatedDespatchDate = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link EstimatedDespatchTimeType }
     *     
     */
    public EstimatedDespatchTimeType getEstimatedDespatchTime() {
        return estimatedDespatchTime;
    }

    /**
     * Define el valor de la propiedad estimatedDespatchTime.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimatedDespatchTimeType }
     *     
     */
    public void setEstimatedDespatchTime(EstimatedDespatchTimeType value) {
        this.estimatedDespatchTime = value;
    }

    /**
     * 
     * 						10.3 - Fecha/Hora de Expedici�n o despacho
     * 						(fecha)
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ActualDespatchDateType }
     *     
     */
    public ActualDespatchDateType getActualDespatchDate() {
        return actualDespatchDate;
    }

    /**
     * Define el valor de la propiedad actualDespatchDate.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualDespatchDateType }
     *     
     */
    public void setActualDespatchDate(ActualDespatchDateType value) {
        this.actualDespatchDate = value;
    }

    /**
     * 
     * 						10.3 - Fecha/Hora de Expedici�n o despacho
     * 						(hora)
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ActualDespatchTimeType }
     *     
     */
    public ActualDespatchTimeType getActualDespatchTime() {
        return actualDespatchTime;
    }

    /**
     * Define el valor de la propiedad actualDespatchTime.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualDespatchTimeType }
     *     
     */
    public void setActualDespatchTime(ActualDespatchTimeType value) {
        this.actualDespatchTime = value;
    }

    /**
     * 
     * 						10.6 - Origen de la expedici�n o Despacho (SHIP
     * 						FROM party)
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getDespatchAddress() {
        return despatchAddress;
    }

    /**
     * Define el valor de la propiedad despatchAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setDespatchAddress(AddressType value) {
        this.despatchAddress = value;
    }

    /**
     *  10.8 - Consignador
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getDespatchParty() {
        return despatchParty;
    }

    /**
     * Define el valor de la propiedad despatchParty.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setDespatchParty(PartyType value) {
        this.despatchParty = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getContact() {
        return contact;
    }

    /**
     * Define el valor de la propiedad contact.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setContact(ContactType value) {
        this.contact = value;
    }

}
