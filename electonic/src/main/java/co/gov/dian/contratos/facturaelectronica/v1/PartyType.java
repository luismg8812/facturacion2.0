//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.10.08 a las 09:39:43 AM COT 
//


package co.gov.dian.contratos.facturaelectronica.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ContactType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LanguageType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndpointIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LogoReferenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MarkAttentionIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MarkCareIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WebsiteURIType;


/**
 * <p>Clase Java para PartyType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PartyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MarkCareIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MarkAttentionIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WebsiteURI" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LogoReferenceID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EndpointID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PartyIdentification" maxOccurs="unbounded"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PartyName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Language" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PostalAddress" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}PhysicalLocation"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}PartyTaxScheme" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}PartyLegalEntity" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Contact" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}Person" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AgentParty" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyType", propOrder = {
    "markCareIndicator",
    "markAttentionIndicator",
    "websiteURI",
    "logoReferenceID",
    "endpointID",
    "partyIdentification",
    "partyName",
    "language",
    "postalAddress",
    "physicalLocation",
    "partyTaxScheme",
    "partyLegalEntity",
    "contact",
    "person",
    "agentParty"
})
public class PartyType {

    @XmlElement(name = "MarkCareIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MarkCareIndicatorType markCareIndicator;
    @XmlElement(name = "MarkAttentionIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MarkAttentionIndicatorType markAttentionIndicator;
    @XmlElement(name = "WebsiteURI", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected WebsiteURIType websiteURI;
    @XmlElement(name = "LogoReferenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LogoReferenceIDType logoReferenceID;
    @XmlElement(name = "EndpointID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EndpointIDType endpointID;
    @XmlElement(name = "PartyIdentification", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2", required = true)
    protected List<PartyIdentificationType> partyIdentification;
    @XmlElement(name = "PartyName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<PartyNameType> partyName;
    @XmlElement(name = "Language", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected LanguageType language;
    @XmlElement(name = "PostalAddress", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected AddressType postalAddress;
    @XmlElement(name = "PhysicalLocation", required = true)
    protected LocationType physicalLocation;
    @XmlElement(name = "PartyTaxScheme", required = true)
    protected List<PartyTaxSchemeType> partyTaxScheme;
    @XmlElement(name = "PartyLegalEntity")
    protected List<PartyLegalEntityType> partyLegalEntity;
    @XmlElement(name = "Contact", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected ContactType contact;
    @XmlElement(name = "Person")
    protected List<PersonType> person;
    @XmlElement(name = "AgentParty", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType agentParty;

    /**
     * 
     * 						
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;documentation xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:ext="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2" xmlns:sts="http://www.dian.gov.co/contratos/facturaelectronica/v1/Structures" xmlns:tns="http://www.dian.gov.co/contratos/facturaelectronica/v1" xml:lang="es"&gt;
     * 							Opcional no usado por la DIAN, las partes
     * 							pueden definir un significado o simplemente
     * 							omitirlo
     * 						&lt;/documentation&gt;
     * </pre>
     * 
     * 					
     * 
     * @return
     *     possible object is
     *     {@link MarkCareIndicatorType }
     *     
     */
    public MarkCareIndicatorType getMarkCareIndicator() {
        return markCareIndicator;
    }

    /**
     * Define el valor de la propiedad markCareIndicator.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkCareIndicatorType }
     *     
     */
    public void setMarkCareIndicator(MarkCareIndicatorType value) {
        this.markCareIndicator = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link MarkAttentionIndicatorType }
     *     
     */
    public MarkAttentionIndicatorType getMarkAttentionIndicator() {
        return markAttentionIndicator;
    }

    /**
     * Define el valor de la propiedad markAttentionIndicator.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkAttentionIndicatorType }
     *     
     */
    public void setMarkAttentionIndicator(MarkAttentionIndicatorType value) {
        this.markAttentionIndicator = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link WebsiteURIType }
     *     
     */
    public WebsiteURIType getWebsiteURI() {
        return websiteURI;
    }

    /**
     * Define el valor de la propiedad websiteURI.
     * 
     * @param value
     *     allowed object is
     *     {@link WebsiteURIType }
     *     
     */
    public void setWebsiteURI(WebsiteURIType value) {
        this.websiteURI = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link LogoReferenceIDType }
     *     
     */
    public LogoReferenceIDType getLogoReferenceID() {
        return logoReferenceID;
    }

    /**
     * Define el valor de la propiedad logoReferenceID.
     * 
     * @param value
     *     allowed object is
     *     {@link LogoReferenceIDType }
     *     
     */
    public void setLogoReferenceID(LogoReferenceIDType value) {
        this.logoReferenceID = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link EndpointIDType }
     *     
     */
    public EndpointIDType getEndpointID() {
        return endpointID;
    }

    /**
     * Define el valor de la propiedad endpointID.
     * 
     * @param value
     *     allowed object is
     *     {@link EndpointIDType }
     *     
     */
    public void setEndpointID(EndpointIDType value) {
        this.endpointID = value;
    }

    /**
     * 
     * 						2.2.3.1 - Identificador fiscal: N�mero completo
     * 						de Identificaci�n Tributaria o similar. En
     * 						Colombia, el NIT
     * 					Gets the value of the partyIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partyIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartyIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyIdentificationType }
     * 
     * 
     */
    public List<PartyIdentificationType> getPartyIdentification() {
        if (partyIdentification == null) {
            partyIdentification = new ArrayList<PartyIdentificationType>();
        }
        return this.partyIdentification;
    }

    /**
     * 
     * 						2.1.10 / 2.2.10 - Nombre Comercial: Nombre
     * 						comercial, por ejemplo, si es una persona f�sica
     * 						el nombre de su establecimiento, debe incluir la
     * 						referencia completa
     * 					Gets the value of the partyName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partyName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartyName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyNameType }
     * 
     * 
     */
    public List<PartyNameType> getPartyName() {
        if (partyName == null) {
            partyName = new ArrayList<PartyNameType>();
        }
        return this.partyName;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link LanguageType }
     *     
     */
    public LanguageType getLanguage() {
        return language;
    }

    /**
     * Define el valor de la propiedad language.
     * 
     * @param value
     *     allowed object is
     *     {@link LanguageType }
     *     
     */
    public void setLanguage(LanguageType value) {
        this.language = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getPostalAddress() {
        return postalAddress;
    }

    /**
     * Define el valor de la propiedad postalAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setPostalAddress(AddressType value) {
        this.postalAddress = value;
    }

    /**
     * 
     * 						2.1.16 / 2.2.16 - Direcci�n:
     * 					
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getPhysicalLocation() {
        return physicalLocation;
    }

    /**
     * Define el valor de la propiedad physicalLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setPhysicalLocation(LocationType value) {
        this.physicalLocation = value;
    }

    /**
     * 
     * 						Estructura necesaria para describir el r�gimen
     * 					Gets the value of the partyTaxScheme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partyTaxScheme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartyTaxScheme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyTaxSchemeType }
     * 
     * 
     */
    public List<PartyTaxSchemeType> getPartyTaxScheme() {
        if (partyTaxScheme == null) {
            partyTaxScheme = new ArrayList<PartyTaxSchemeType>();
        }
        return this.partyTaxScheme;
    }

    /**
     * 
     * 						Estructura necesaria para describir la
     * 						informaci�n legal de la empresa
     * 					Gets the value of the partyLegalEntity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partyLegalEntity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartyLegalEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyLegalEntityType }
     * 
     * 
     */
    public List<PartyLegalEntityType> getPartyLegalEntity() {
        if (partyLegalEntity == null) {
            partyLegalEntity = new ArrayList<PartyLegalEntityType>();
        }
        return this.partyLegalEntity;
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

    /**
     *  2017-ago-10: cambi� la cardinalidad del atributo @maxOccurs de "1" a "unbounded"Gets the value of the person property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the person property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonType }
     * 
     * 
     */
    public List<PersonType> getPerson() {
        if (person == null) {
            person = new ArrayList<PersonType>();
        }
        return this.person;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType }
     *     
     */
    public oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType getAgentParty() {
        return agentParty;
    }

    /**
     * Define el valor de la propiedad agentParty.
     * 
     * @param value
     *     allowed object is
     *     {@link oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType }
     *     
     */
    public void setAgentParty(oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType value) {
        this.agentParty = value;
    }

}
