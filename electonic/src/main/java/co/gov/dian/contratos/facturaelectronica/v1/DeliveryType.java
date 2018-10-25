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
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDeliveryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDeliveryTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestDeliveryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestDeliveryTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.QuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TrackingIDType;


/**
 * <p>Clase Java para DeliveryType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DeliveryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Quantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ActualDeliveryDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ActualDeliveryTime" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestDeliveryDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestDeliveryTime" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TrackingID" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}DeliveryAddress" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}DeliveryLocation" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequestedDeliveryPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PromisedDeliveryPeriod" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EstimatedDeliveryPeriod" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}DeliveryParty" minOccurs="0"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}Despatch" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryType", propOrder = {
    "id",
    "quantity",
    "minimumQuantity",
    "maximumQuantity",
    "actualDeliveryDate",
    "actualDeliveryTime",
    "latestDeliveryDate",
    "latestDeliveryTime",
    "trackingID",
    "deliveryAddress",
    "deliveryLocation",
    "requestedDeliveryPeriod",
    "promisedDeliveryPeriod",
    "estimatedDeliveryPeriod",
    "deliveryParty",
    "despatch"
})
public class DeliveryType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "Quantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected QuantityType quantity;
    @XmlElement(name = "MinimumQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumQuantityType minimumQuantity;
    @XmlElement(name = "MaximumQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumQuantityType maximumQuantity;
    @XmlElement(name = "ActualDeliveryDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ActualDeliveryDateType actualDeliveryDate;
    @XmlElement(name = "ActualDeliveryTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ActualDeliveryTimeType actualDeliveryTime;
    @XmlElement(name = "LatestDeliveryDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LatestDeliveryDateType latestDeliveryDate;
    @XmlElement(name = "LatestDeliveryTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LatestDeliveryTimeType latestDeliveryTime;
    @XmlElement(name = "TrackingID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TrackingIDType trackingID;
    @XmlElement(name = "DeliveryAddress")
    protected AddressType deliveryAddress;
    @XmlElement(name = "DeliveryLocation")
    protected LocationType deliveryLocation;
    @XmlElement(name = "RequestedDeliveryPeriod", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected PeriodType requestedDeliveryPeriod;
    @XmlElement(name = "PromisedDeliveryPeriod", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected PeriodType promisedDeliveryPeriod;
    @XmlElement(name = "EstimatedDeliveryPeriod", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected PeriodType estimatedDeliveryPeriod;
    @XmlElement(name = "DeliveryParty")
    protected PartyType deliveryParty;
    @XmlElement(name = "Despatch")
    protected DespatchType despatch;

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
     *     {@link QuantityType }
     *     
     */
    public QuantityType getQuantity() {
        return quantity;
    }

    /**
     * Define el valor de la propiedad quantity.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setQuantity(QuantityType value) {
        this.quantity = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link MinimumQuantityType }
     *     
     */
    public MinimumQuantityType getMinimumQuantity() {
        return minimumQuantity;
    }

    /**
     * Define el valor de la propiedad minimumQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumQuantityType }
     *     
     */
    public void setMinimumQuantity(MinimumQuantityType value) {
        this.minimumQuantity = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link MaximumQuantityType }
     *     
     */
    public MaximumQuantityType getMaximumQuantity() {
        return maximumQuantity;
    }

    /**
     * Define el valor de la propiedad maximumQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumQuantityType }
     *     
     */
    public void setMaximumQuantity(MaximumQuantityType value) {
        this.maximumQuantity = value;
    }

    /**
     * 
     * 						10.1 - Fecha/Hora de Entrega (fecha)
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ActualDeliveryDateType }
     *     
     */
    public ActualDeliveryDateType getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    /**
     * Define el valor de la propiedad actualDeliveryDate.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualDeliveryDateType }
     *     
     */
    public void setActualDeliveryDate(ActualDeliveryDateType value) {
        this.actualDeliveryDate = value;
    }

    /**
     * 
     * 						10.1 - Fecha/Hora de Entrega (hora)
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ActualDeliveryTimeType }
     *     
     */
    public ActualDeliveryTimeType getActualDeliveryTime() {
        return actualDeliveryTime;
    }

    /**
     * Define el valor de la propiedad actualDeliveryTime.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualDeliveryTimeType }
     *     
     */
    public void setActualDeliveryTime(ActualDeliveryTimeType value) {
        this.actualDeliveryTime = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link LatestDeliveryDateType }
     *     
     */
    public LatestDeliveryDateType getLatestDeliveryDate() {
        return latestDeliveryDate;
    }

    /**
     * Define el valor de la propiedad latestDeliveryDate.
     * 
     * @param value
     *     allowed object is
     *     {@link LatestDeliveryDateType }
     *     
     */
    public void setLatestDeliveryDate(LatestDeliveryDateType value) {
        this.latestDeliveryDate = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link LatestDeliveryTimeType }
     *     
     */
    public LatestDeliveryTimeType getLatestDeliveryTime() {
        return latestDeliveryTime;
    }

    /**
     * Define el valor de la propiedad latestDeliveryTime.
     * 
     * @param value
     *     allowed object is
     *     {@link LatestDeliveryTimeType }
     *     
     */
    public void setLatestDeliveryTime(LatestDeliveryTimeType value) {
        this.latestDeliveryTime = value;
    }

    /**
     * 
     * 						2.2.10.1 - Identificaci�n del Transporte:
     * 						Matr�cula del cami�n, n�mero del vag�n, nombre
     * 						del barco�.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link TrackingIDType }
     *     
     */
    public TrackingIDType getTrackingID() {
        return trackingID;
    }

    /**
     * Define el valor de la propiedad trackingID.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackingIDType }
     *     
     */
    public void setTrackingID(TrackingIDType value) {
        this.trackingID = value;
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
    public AddressType getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Define el valor de la propiedad deliveryAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setDeliveryAddress(AddressType value) {
        this.deliveryAddress = value;
    }

    /**
     * 
     * 						10.8 - Consignador: Ver composici�n en la
     * 						estructura com�n Informaci�n de un participante
     * 						secundario (REF-PART-SEC) / 10.9 -
     * 						Consignatario: Ver composici�n en la estructura
     * 						com�n Informaci�n de un participante secundario
     * 						(REF-PART-SEC)
     * 					
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getDeliveryLocation() {
        return deliveryLocation;
    }

    /**
     * Define el valor de la propiedad deliveryLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setDeliveryLocation(LocationType value) {
        this.deliveryLocation = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getRequestedDeliveryPeriod() {
        return requestedDeliveryPeriod;
    }

    /**
     * Define el valor de la propiedad requestedDeliveryPeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setRequestedDeliveryPeriod(PeriodType value) {
        this.requestedDeliveryPeriod = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getPromisedDeliveryPeriod() {
        return promisedDeliveryPeriod;
    }

    /**
     * Define el valor de la propiedad promisedDeliveryPeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setPromisedDeliveryPeriod(PeriodType value) {
        this.promisedDeliveryPeriod = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getEstimatedDeliveryPeriod() {
        return estimatedDeliveryPeriod;
    }

    /**
     * Define el valor de la propiedad estimatedDeliveryPeriod.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setEstimatedDeliveryPeriod(PeriodType value) {
        this.estimatedDeliveryPeriod = value;
    }

    /**
     * 
     * 						10.7 - Transportista
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getDeliveryParty() {
        return deliveryParty;
    }

    /**
     * Define el valor de la propiedad deliveryParty.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setDeliveryParty(PartyType value) {
        this.deliveryParty = value;
    }

    /**
     * 
     * 						Estructura requerida para la informaci�n del
     * 						despacho
     * 					
     * 
     * @return
     *     possible object is
     *     {@link DespatchType }
     *     
     */
    public DespatchType getDespatch() {
        return despatch;
    }

    /**
     * Define el valor de la propiedad despatch.
     * 
     * @param value
     *     allowed object is
     *     {@link DespatchType }
     *     
     */
    public void setDespatch(DespatchType value) {
        this.despatch = value;
    }

}
