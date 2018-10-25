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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdditionalAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomerAssignedAccountIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SupplierAssignedAccountIDType;


/**
 * <p>Clase Java para CustomerPartyType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CustomerPartyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CustomerAssignedAccountID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SupplierAssignedAccountID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AdditionalAccountID"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}Party"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryContact" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AccountingContact" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}BuyerContact" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerPartyType", propOrder = {
    "customerAssignedAccountID",
    "supplierAssignedAccountID",
    "additionalAccountID",
    "party",
    "deliveryContact",
    "accountingContact",
    "buyerContact"
})
public class CustomerPartyType {

    @XmlElement(name = "CustomerAssignedAccountID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CustomerAssignedAccountIDType customerAssignedAccountID;
    @XmlElement(name = "SupplierAssignedAccountID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SupplierAssignedAccountIDType supplierAssignedAccountID;
    @XmlElement(name = "AdditionalAccountID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected AdditionalAccountIDType additionalAccountID;
    @XmlElement(name = "Party", required = true)
    protected PartyType party;
    @XmlElement(name = "DeliveryContact", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected ContactType deliveryContact;
    @XmlElement(name = "AccountingContact", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected ContactType accountingContact;
    @XmlElement(name = "BuyerContact", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected ContactType buyerContact;

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link CustomerAssignedAccountIDType }
     *     
     */
    public CustomerAssignedAccountIDType getCustomerAssignedAccountID() {
        return customerAssignedAccountID;
    }

    /**
     * Define el valor de la propiedad customerAssignedAccountID.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAssignedAccountIDType }
     *     
     */
    public void setCustomerAssignedAccountID(CustomerAssignedAccountIDType value) {
        this.customerAssignedAccountID = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link SupplierAssignedAccountIDType }
     *     
     */
    public SupplierAssignedAccountIDType getSupplierAssignedAccountID() {
        return supplierAssignedAccountID;
    }

    /**
     * Define el valor de la propiedad supplierAssignedAccountID.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierAssignedAccountIDType }
     *     
     */
    public void setSupplierAssignedAccountID(SupplierAssignedAccountIDType value) {
        this.supplierAssignedAccountID = value;
    }

    /**
     * 
     * 						2017-ago-10: los valores v�lidos son "1" y "2" para el concepto de "tipo de organizaci�n jur�dica"
     * 						que utiliza el C�digo de Comercio: "persona jur�dica" y "persona natural o f�sica"
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AdditionalAccountIDType }
     *     
     */
    public AdditionalAccountIDType getAdditionalAccountID() {
        return additionalAccountID;
    }

    /**
     * Define el valor de la propiedad additionalAccountID.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalAccountIDType }
     *     
     */
    public void setAdditionalAccountID(AdditionalAccountIDType value) {
        this.additionalAccountID = value;
    }

    /**
     * 
     * 						Estructura requerida para describir al
     * 						adquiriente
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getParty() {
        return party;
    }

    /**
     * Define el valor de la propiedad party.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setParty(PartyType value) {
        this.party = value;
    }

    /**
     * 
     * 						17 - Personas de Contacto: Personas de contacto
     * 						asociadas al participante.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getDeliveryContact() {
        return deliveryContact;
    }

    /**
     * Define el valor de la propiedad deliveryContact.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setDeliveryContact(ContactType value) {
        this.deliveryContact = value;
    }

    /**
     * 
     * 						17 - Personas de Contacto: Personas de contacto
     * 						asociadas al participante.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getAccountingContact() {
        return accountingContact;
    }

    /**
     * Define el valor de la propiedad accountingContact.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setAccountingContact(ContactType value) {
        this.accountingContact = value;
    }

    /**
     * 
     * 						17 - Personas de Contacto: Personas de contacto
     * 						asociadas al participante.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getBuyerContact() {
        return buyerContact;
    }

    /**
     * Define el valor de la propiedad buyerContact.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setBuyerContact(ContactType value) {
        this.buyerContact = value;
    }

}
