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
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConditionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CountrySubentityCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CountrySubentityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;


/**
 * <p>Clase Java para LocationType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Conditions" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CountrySubentity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CountrySubentityCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ValidityPeriod" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}Address" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationType", propOrder = {
    "id",
    "description",
    "conditions",
    "countrySubentity",
    "countrySubentityCode",
    "validityPeriod",
    "address"
})
public class LocationType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DescriptionType description;
    @XmlElement(name = "Conditions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConditionsType conditions;
    @XmlElement(name = "CountrySubentity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CountrySubentityType countrySubentity;
    @XmlElement(name = "CountrySubentityCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CountrySubentityCodeType countrySubentityCode;
    @XmlElement(name = "ValidityPeriod", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<PeriodType> validityPeriod;
    @XmlElement(name = "Address")
    protected AddressType address;

    /**
     * 
     * 						2.2.6.1 - Identificador �nico DUNS:
     * 						Identificador �nico de una direcci�n basado en
     * 						DUNS (Duns & Bradstreet).
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
     * 						2.2.6.3 - Direcci�n: Texto Libre para establecer
     * 						una direcci�n. No se recomienda detallar en
     * 						otros campos m�s detallados conceptos como
     * 						n�mero de edificio, letra, escalera, etc. Mejor
     * 						en una l�nea libre porque la diversidad de datos
     * 						es muy grande.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link DescriptionType }
     *     
     */
    public DescriptionType getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionType }
     *     
     */
    public void setDescription(DescriptionType value) {
        this.description = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ConditionsType }
     *     
     */
    public ConditionsType getConditions() {
        return conditions;
    }

    /**
     * Define el valor de la propiedad conditions.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionsType }
     *     
     */
    public void setConditions(ConditionsType value) {
        this.conditions = value;
    }

    /**
     * 
     * 						2.2.6.8 - Sub-Divisi�n del Pa�s: Nombre de la
     * 						Subdivisi�n territorial de un pa�s Estado,
     * 						Departamento
     * 					
     * 
     * @return
     *     possible object is
     *     {@link CountrySubentityType }
     *     
     */
    public CountrySubentityType getCountrySubentity() {
        return countrySubentity;
    }

    /**
     * Define el valor de la propiedad countrySubentity.
     * 
     * @param value
     *     allowed object is
     *     {@link CountrySubentityType }
     *     
     */
    public void setCountrySubentity(CountrySubentityType value) {
        this.countrySubentity = value;
    }

    /**
     * 
     * 						2.2.6.8 - Sub-Divisi�n del Pa�s (c�digo): Nombre
     * 						de la Subdivisi�n territorial de un pa�s Estado,
     * 						Departamento
     * 					
     * 
     * @return
     *     possible object is
     *     {@link CountrySubentityCodeType }
     *     
     */
    public CountrySubentityCodeType getCountrySubentityCode() {
        return countrySubentityCode;
    }

    /**
     * Define el valor de la propiedad countrySubentityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link CountrySubentityCodeType }
     *     
     */
    public void setCountrySubentityCode(CountrySubentityCodeType value) {
        this.countrySubentityCode = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					Gets the value of the validityPeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validityPeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidityPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeriodType }
     * 
     * 
     */
    public List<PeriodType> getValidityPeriod() {
        if (validityPeriod == null) {
            validityPeriod = new ArrayList<PeriodType>();
        }
        return this.validityPeriod;
    }

    /**
     * 
     * 						Estructura requerida para adicionar detalles a
     * 						la direcci�n
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Define el valor de la propiedad address.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

}
