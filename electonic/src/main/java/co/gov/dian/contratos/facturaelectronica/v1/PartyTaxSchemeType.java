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
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExemptionReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExemptionReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxLevelCodeType;


/**
 * <p>Clase Java para PartyTaxSchemeType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PartyTaxSchemeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationName" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CompanyID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxLevelCode"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExemptionReasonCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExemptionReason" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RegistrationAddress" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxScheme"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyTaxSchemeType", propOrder = {
    "registrationName",
    "companyID",
    "taxLevelCode",
    "exemptionReasonCode",
    "exemptionReason",
    "registrationAddress",
    "taxScheme"
})
public class PartyTaxSchemeType {

    @XmlElement(name = "RegistrationName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegistrationNameType registrationName;
    @XmlElement(name = "CompanyID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CompanyIDType companyID;
    @XmlElement(name = "TaxLevelCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TaxLevelCodeType taxLevelCode;
    @XmlElement(name = "ExemptionReasonCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExemptionReasonCodeType exemptionReasonCode;
    @XmlElement(name = "ExemptionReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExemptionReasonType exemptionReason;
    @XmlElement(name = "RegistrationAddress", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected AddressType registrationAddress;
    @XmlElement(name = "TaxScheme", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2", required = true)
    protected TaxSchemeType taxScheme;

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link RegistrationNameType }
     *     
     */
    public RegistrationNameType getRegistrationName() {
        return registrationName;
    }

    /**
     * Define el valor de la propiedad registrationName.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationNameType }
     *     
     */
    public void setRegistrationName(RegistrationNameType value) {
        this.registrationName = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link CompanyIDType }
     *     
     */
    public CompanyIDType getCompanyID() {
        return companyID;
    }

    /**
     * Define el valor de la propiedad companyID.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyIDType }
     *     
     */
    public void setCompanyID(CompanyIDType value) {
        this.companyID = value;
    }

    /**
     * 
     * 						2.2.3.8 - R�gimen: R�gimen al que pertenece.
     * 						Debe referenciar a una lista de c�digos con los
     * 						valores correspondientes, por ejemplo: � Com�n �
     * 						Simplificado � No aplica
     * 					
     * 
     * @return
     *     possible object is
     *     {@link TaxLevelCodeType }
     *     
     */
    public TaxLevelCodeType getTaxLevelCode() {
        return taxLevelCode;
    }

    /**
     * Define el valor de la propiedad taxLevelCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxLevelCodeType }
     *     
     */
    public void setTaxLevelCode(TaxLevelCodeType value) {
        this.taxLevelCode = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ExemptionReasonCodeType }
     *     
     */
    public ExemptionReasonCodeType getExemptionReasonCode() {
        return exemptionReasonCode;
    }

    /**
     * Define el valor de la propiedad exemptionReasonCode.
     * 
     * @param value
     *     allowed object is
     *     {@link ExemptionReasonCodeType }
     *     
     */
    public void setExemptionReasonCode(ExemptionReasonCodeType value) {
        this.exemptionReasonCode = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ExemptionReasonType }
     *     
     */
    public ExemptionReasonType getExemptionReason() {
        return exemptionReason;
    }

    /**
     * Define el valor de la propiedad exemptionReason.
     * 
     * @param value
     *     allowed object is
     *     {@link ExemptionReasonType }
     *     
     */
    public void setExemptionReason(ExemptionReasonType value) {
        this.exemptionReason = value;
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
    public AddressType getRegistrationAddress() {
        return registrationAddress;
    }

    /**
     * Define el valor de la propiedad registrationAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setRegistrationAddress(AddressType value) {
        this.registrationAddress = value;
    }

    /**
     * 
     * 						No usado por la DIAN, las partes pueden definir
     * 						un significado o simplemente poner un elemento
     * 						vac�o ya que es obligatorio en UBL
     * 					
     * 
     * @return
     *     possible object is
     *     {@link TaxSchemeType }
     *     
     */
    public TaxSchemeType getTaxScheme() {
        return taxScheme;
    }

    /**
     * Define el valor de la propiedad taxScheme.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxSchemeType }
     *     
     */
    public void setTaxScheme(TaxSchemeType value) {
        this.taxScheme = value;
    }

}
