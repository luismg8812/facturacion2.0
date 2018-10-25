package co.gov.dian.contratos.facturaelectronica.v1;

//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.10.08 a las 09:39:43 AM COT 
//




import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LocationCoordinateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdditionalStreetNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AddressFormatCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AddressTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BlockNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuildingNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuildingNumberType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CityNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CitySubdivisionNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CountrySubentityCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CountrySubentityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DepartmentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DistrictType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FloorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InhouseMailType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MarkAttentionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MarkCareType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PlotIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PostalZoneType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PostboxType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RoomType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StreetNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TimezoneOffsetType;


/**
 * <p>Clase Java para AddressType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AddressTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AddressFormatCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Postbox" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Floor" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Room" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}StreetName" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AdditionalStreetName" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BlockName" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BuildingName" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BuildingNumber" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InhouseMail" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Department" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MarkAttention" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MarkCare" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PlotIdentification" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CitySubdivisionName" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CityName" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PostalZone" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CountrySubentity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CountrySubentityCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Region" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}District" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TimezoneOffset" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AddressLine" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Country" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LocationCoordinate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = {
    "id",
    "addressTypeCode",
    "addressFormatCode",
    "postbox",
    "floor",
    "room",
    "streetName",
    "additionalStreetName",
    "blockName",
    "buildingName",
    "buildingNumber",
    "inhouseMail",
    "department",
    "markAttention",
    "markCare",
    "plotIdentification",
    "citySubdivisionName",
    "cityName",
    "postalZone",
    "countrySubentity",
    "countrySubentityCode",
    "region",
    "district",
    "timezoneOffset",
    "addressLine",
    "country",
    "locationCoordinate"
})
public class AddressType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "AddressTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AddressTypeCodeType addressTypeCode;
    @XmlElement(name = "AddressFormatCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AddressFormatCodeType addressFormatCode;
    @XmlElement(name = "Postbox", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PostboxType postbox;
    @XmlElement(name = "Floor", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FloorType floor;
    @XmlElement(name = "Room", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RoomType room;
    @XmlElement(name = "StreetName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected StreetNameType streetName;
    @XmlElement(name = "AdditionalStreetName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AdditionalStreetNameType additionalStreetName;
    @XmlElement(name = "BlockName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BlockNameType blockName;
    @XmlElement(name = "BuildingName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BuildingNameType buildingName;
    @XmlElement(name = "BuildingNumber", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BuildingNumberType buildingNumber;
    @XmlElement(name = "InhouseMail", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InhouseMailType inhouseMail;
    @XmlElement(name = "Department", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DepartmentType department;
    @XmlElement(name = "MarkAttention", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MarkAttentionType markAttention;
    @XmlElement(name = "MarkCare", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MarkCareType markCare;
    @XmlElement(name = "PlotIdentification", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PlotIdentificationType plotIdentification;
    @XmlElement(name = "CitySubdivisionName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CitySubdivisionNameType citySubdivisionName;
    @XmlElement(name = "CityName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CityNameType cityName;
    @XmlElement(name = "PostalZone", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PostalZoneType postalZone;
    @XmlElement(name = "CountrySubentity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CountrySubentityType countrySubentity;
    @XmlElement(name = "CountrySubentityCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CountrySubentityCodeType countrySubentityCode;
    @XmlElement(name = "Region", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegionType region;
    @XmlElement(name = "District", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DistrictType district;
    @XmlElement(name = "TimezoneOffset", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TimezoneOffsetType timezoneOffset;
    @XmlElement(name = "AddressLine", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<AddressLineType> addressLine;
    @XmlElement(name = "Country", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected CountryType country;
    @XmlElement(name = "LocationCoordinate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected LocationCoordinateType locationCoordinate;

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
     *     {@link AddressTypeCodeType }
     *     
     */
    public AddressTypeCodeType getAddressTypeCode() {
        return addressTypeCode;
    }

    /**
     * Define el valor de la propiedad addressTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressTypeCodeType }
     *     
     */
    public void setAddressTypeCode(AddressTypeCodeType value) {
        this.addressTypeCode = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AddressFormatCodeType }
     *     
     */
    public AddressFormatCodeType getAddressFormatCode() {
        return addressFormatCode;
    }

    /**
     * Define el valor de la propiedad addressFormatCode.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressFormatCodeType }
     *     
     */
    public void setAddressFormatCode(AddressFormatCodeType value) {
        this.addressFormatCode = value;
    }

    /**
     * 
     * 						2.2.6.2 - Identificador postal: Identificador
     * 						Postal, Apartado postal o a�reo, PO Box
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PostboxType }
     *     
     */
    public PostboxType getPostbox() {
        return postbox;
    }

    /**
     * Define el valor de la propiedad postbox.
     * 
     * @param value
     *     allowed object is
     *     {@link PostboxType }
     *     
     */
    public void setPostbox(PostboxType value) {
        this.postbox = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link FloorType }
     *     
     */
    public FloorType getFloor() {
        return floor;
    }

    /**
     * Define el valor de la propiedad floor.
     * 
     * @param value
     *     allowed object is
     *     {@link FloorType }
     *     
     */
    public void setFloor(FloorType value) {
        this.floor = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link RoomType }
     *     
     */
    public RoomType getRoom() {
        return room;
    }

    /**
     * Define el valor de la propiedad room.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomType }
     *     
     */
    public void setRoom(RoomType value) {
        this.room = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link StreetNameType }
     *     
     */
    public StreetNameType getStreetName() {
        return streetName;
    }

    /**
     * Define el valor de la propiedad streetName.
     * 
     * @param value
     *     allowed object is
     *     {@link StreetNameType }
     *     
     */
    public void setStreetName(StreetNameType value) {
        this.streetName = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AdditionalStreetNameType }
     *     
     */
    public AdditionalStreetNameType getAdditionalStreetName() {
        return additionalStreetName;
    }

    /**
     * Define el valor de la propiedad additionalStreetName.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalStreetNameType }
     *     
     */
    public void setAdditionalStreetName(AdditionalStreetNameType value) {
        this.additionalStreetName = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link BlockNameType }
     *     
     */
    public BlockNameType getBlockName() {
        return blockName;
    }

    /**
     * Define el valor de la propiedad blockName.
     * 
     * @param value
     *     allowed object is
     *     {@link BlockNameType }
     *     
     */
    public void setBlockName(BlockNameType value) {
        this.blockName = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link BuildingNameType }
     *     
     */
    public BuildingNameType getBuildingName() {
        return buildingName;
    }

    /**
     * Define el valor de la propiedad buildingName.
     * 
     * @param value
     *     allowed object is
     *     {@link BuildingNameType }
     *     
     */
    public void setBuildingName(BuildingNameType value) {
        this.buildingName = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link BuildingNumberType }
     *     
     */
    public BuildingNumberType getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * Define el valor de la propiedad buildingNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BuildingNumberType }
     *     
     */
    public void setBuildingNumber(BuildingNumberType value) {
        this.buildingNumber = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link InhouseMailType }
     *     
     */
    public InhouseMailType getInhouseMail() {
        return inhouseMail;
    }

    /**
     * Define el valor de la propiedad inhouseMail.
     * 
     * @param value
     *     allowed object is
     *     {@link InhouseMailType }
     *     
     */
    public void setInhouseMail(InhouseMailType value) {
        this.inhouseMail = value;
    }

    /**
     * 
     * 						2.2.6.8 - Sub-Divisi�n del Pa�s: Nombre de la
     * 						Subdivisi�n territorial de un pa�s Estado,
     * 						Departamento.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link DepartmentType }
     *     
     */
    public DepartmentType getDepartment() {
        return department;
    }

    /**
     * Define el valor de la propiedad department.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartmentType }
     *     
     */
    public void setDepartment(DepartmentType value) {
        this.department = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link MarkAttentionType }
     *     
     */
    public MarkAttentionType getMarkAttention() {
        return markAttention;
    }

    /**
     * Define el valor de la propiedad markAttention.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkAttentionType }
     *     
     */
    public void setMarkAttention(MarkAttentionType value) {
        this.markAttention = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link MarkCareType }
     *     
     */
    public MarkCareType getMarkCare() {
        return markCare;
    }

    /**
     * Define el valor de la propiedad markCare.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkCareType }
     *     
     */
    public void setMarkCare(MarkCareType value) {
        this.markCare = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PlotIdentificationType }
     *     
     */
    public PlotIdentificationType getPlotIdentification() {
        return plotIdentification;
    }

    /**
     * Define el valor de la propiedad plotIdentification.
     * 
     * @param value
     *     allowed object is
     *     {@link PlotIdentificationType }
     *     
     */
    public void setPlotIdentification(PlotIdentificationType value) {
        this.plotIdentification = value;
    }

    /**
     * 
     * 						2.2.6.11 - Sub-Divisi�n Municipio: Subdivisi�n
     * 						de una ciudad, municipio, etc., por ejemplo un
     * 						distrito administrativo o similar.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link CitySubdivisionNameType }
     *     
     */
    public CitySubdivisionNameType getCitySubdivisionName() {
        return citySubdivisionName;
    }

    /**
     * Define el valor de la propiedad citySubdivisionName.
     * 
     * @param value
     *     allowed object is
     *     {@link CitySubdivisionNameType }
     *     
     */
    public void setCitySubdivisionName(CitySubdivisionNameType value) {
        this.citySubdivisionName = value;
    }

    /**
     * 
     * 						2.2.6.10 - Municipio: Nombre de la ciudad,
     * 						municipio, etc.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link CityNameType }
     *     
     */
    public CityNameType getCityName() {
        return cityName;
    }

    /**
     * Define el valor de la propiedad cityName.
     * 
     * @param value
     *     allowed object is
     *     {@link CityNameType }
     *     
     */
    public void setCityName(CityNameType value) {
        this.cityName = value;
    }

    /**
     * 
     * 						2.2.6.12 - C�digo Postal: C�digo Postal
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PostalZoneType }
     *     
     */
    public PostalZoneType getPostalZone() {
        return postalZone;
    }

    /**
     * Define el valor de la propiedad postalZone.
     * 
     * @param value
     *     allowed object is
     *     {@link PostalZoneType }
     *     
     */
    public void setPostalZone(PostalZoneType value) {
        this.postalZone = value;
    }

    /**
     * 
     * 						6.2.2.8 - Sub-Divisi�n del Pa�s: Nombre de la
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
     * 						6.2.2.8 - Sub-Divisi�n del Pa�s (c�digo): Nombre
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
     * 					
     * 
     * @return
     *     possible object is
     *     {@link RegionType }
     *     
     */
    public RegionType getRegion() {
        return region;
    }

    /**
     * Define el valor de la propiedad region.
     * 
     * @param value
     *     allowed object is
     *     {@link RegionType }
     *     
     */
    public void setRegion(RegionType value) {
        this.region = value;
    }

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
     *     {@link DistrictType }
     *     
     */
    public DistrictType getDistrict() {
        return district;
    }

    /**
     * Define el valor de la propiedad district.
     * 
     * @param value
     *     allowed object is
     *     {@link DistrictType }
     *     
     */
    public void setDistrict(DistrictType value) {
        this.district = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link TimezoneOffsetType }
     *     
     */
    public TimezoneOffsetType getTimezoneOffset() {
        return timezoneOffset;
    }

    /**
     * Define el valor de la propiedad timezoneOffset.
     * 
     * @param value
     *     allowed object is
     *     {@link TimezoneOffsetType }
     *     
     */
    public void setTimezoneOffset(TimezoneOffsetType value) {
        this.timezoneOffset = value;
    }

    /**
     * 
     * 						2.2.6.3 - Direcci�n: Texto Libre para establecer
     * 						una direcci�n. No se recomienda detallar en
     * 						otros campos m�s detallados conceptos como
     * 						n�mero de edificio, letra, escalera, etc. Mejor
     * 						en una l�nea libre porque la diversidad de datos
     * 						es muy grande. / 2.2.6.4 - Direcci�n 2: Texto
     * 						Libre para establecer una direcci�n (extensi�n)
     * 						/ 2.2.6.5 - Direcci�n 3: Texto Libre para
     * 						establecer una direcci�n (extensi�n)
     * 					Gets the value of the addressLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressLineType }
     * 
     * 
     */
    public List<AddressLineType> getAddressLine() {
        if (addressLine == null) {
            addressLine = new ArrayList<AddressLineType>();
        }
        return this.addressLine;
    }

    /**
     * 
     * 						2.2.6.6 - C�digo Pa�s: C�digo del Pa�s relativo
     * 						a la direcci�n, se recomienda establecer como
     * 						Obligatorio si es distinto del nacional
     * 						(Colombia). Utilizar una lista de c�digos
     * 						externa y estandarizada, como la iso ISO 3166-1
     * 						alfa2 o alfa3. / 2.2.6.7 - Nombre del Pa�s:
     * 						Nombre del pa�s relativo a la direcci�n.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getCountry() {
        return country;
    }

    /**
     * Define el valor de la propiedad country.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setCountry(CountryType value) {
        this.country = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link LocationCoordinateType }
     *     
     */
    public LocationCoordinateType getLocationCoordinate() {
        return locationCoordinate;
    }

    /**
     * Define el valor de la propiedad locationCoordinate.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationCoordinateType }
     *     
     */
    public void setLocationCoordinate(LocationCoordinateType value) {
        this.locationCoordinate = value;
    }

}
