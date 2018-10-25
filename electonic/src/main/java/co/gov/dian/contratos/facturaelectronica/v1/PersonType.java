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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FamilyNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FirstNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.JobTitleType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MiddleNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameSuffixType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OrganizationDepartmentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TitleType;


/**
 * <p>Clase Java para PersonType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PersonType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FirstName"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FamilyName"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Title" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MiddleName" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NameSuffix" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}JobTitle" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OrganizationDepartment" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonType", propOrder = {
    "firstName",
    "familyName",
    "title",
    "middleName",
    "nameSuffix",
    "jobTitle",
    "organizationDepartment"
})
public class PersonType {

    @XmlElement(name = "FirstName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected FirstNameType firstName;
    @XmlElement(name = "FamilyName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected FamilyNameType familyName;
    @XmlElement(name = "Title", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TitleType title;
    @XmlElement(name = "MiddleName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MiddleNameType middleName;
    @XmlElement(name = "NameSuffix", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NameSuffixType nameSuffix;
    @XmlElement(name = "JobTitle", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected JobTitleType jobTitle;
    @XmlElement(name = "OrganizationDepartment", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OrganizationDepartmentType organizationDepartment;

    /**
     * 
     * 						2.2.3.5 - Nombre: Obligatorio si es una persona
     * 						natural. Nombre completo del participante
     * 					
     * 
     * @return
     *     possible object is
     *     {@link FirstNameType }
     *     
     */
    public FirstNameType getFirstName() {
        return firstName;
    }

    /**
     * Define el valor de la propiedad firstName.
     * 
     * @param value
     *     allowed object is
     *     {@link FirstNameType }
     *     
     */
    public void setFirstName(FirstNameType value) {
        this.firstName = value;
    }

    /**
     * 
     * 						2.2.3.6 - Primer Apellido: Obligatorio si es una
     * 						persona natural. Primer apellido completo del
     * 						participante, en caso de ser persona natural y
     * 						2.2.3.7 - Segundo Apellido: Segundo apellido
     * 						completo del participante, en caso de ser
     * 						persona natural
     * 					
     * 
     * @return
     *     possible object is
     *     {@link FamilyNameType }
     *     
     */
    public FamilyNameType getFamilyName() {
        return familyName;
    }

    /**
     * Define el valor de la propiedad familyName.
     * 
     * @param value
     *     allowed object is
     *     {@link FamilyNameType }
     *     
     */
    public void setFamilyName(FamilyNameType value) {
        this.familyName = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link TitleType }
     *     
     */
    public TitleType getTitle() {
        return title;
    }

    /**
     * Define el valor de la propiedad title.
     * 
     * @param value
     *     allowed object is
     *     {@link TitleType }
     *     
     */
    public void setTitle(TitleType value) {
        this.title = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link MiddleNameType }
     *     
     */
    public MiddleNameType getMiddleName() {
        return middleName;
    }

    /**
     * Define el valor de la propiedad middleName.
     * 
     * @param value
     *     allowed object is
     *     {@link MiddleNameType }
     *     
     */
    public void setMiddleName(MiddleNameType value) {
        this.middleName = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link NameSuffixType }
     *     
     */
    public NameSuffixType getNameSuffix() {
        return nameSuffix;
    }

    /**
     * Define el valor de la propiedad nameSuffix.
     * 
     * @param value
     *     allowed object is
     *     {@link NameSuffixType }
     *     
     */
    public void setNameSuffix(NameSuffixType value) {
        this.nameSuffix = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link JobTitleType }
     *     
     */
    public JobTitleType getJobTitle() {
        return jobTitle;
    }

    /**
     * Define el valor de la propiedad jobTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link JobTitleType }
     *     
     */
    public void setJobTitle(JobTitleType value) {
        this.jobTitle = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link OrganizationDepartmentType }
     *     
     */
    public OrganizationDepartmentType getOrganizationDepartment() {
        return organizationDepartment;
    }

    /**
     * Define el valor de la propiedad organizationDepartment.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationDepartmentType }
     *     
     */
    public void setOrganizationDepartment(OrganizationDepartmentType value) {
        this.organizationDepartment = value;
    }

}
