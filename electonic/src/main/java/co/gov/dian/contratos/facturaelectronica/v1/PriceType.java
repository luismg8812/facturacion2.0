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
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PriceListType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OrderableUnitFactorRateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceChangeReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceTypeType;


/**
 * <p>Clase Java para PriceType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PriceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceAmount"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BaseQuantity" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceChangeReason" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceTypeCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceType" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OrderableUnitFactorRate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ValidityPeriod" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PriceList" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceType", propOrder = {
    "priceAmount",
    "baseQuantity",
    "priceChangeReason",
    "priceTypeCode",
    "priceType",
    "orderableUnitFactorRate",
    "validityPeriod",
    "priceList",
    "allowanceCharge"
})
public class PriceType {

    @XmlElement(name = "PriceAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PriceAmountType priceAmount;
    @XmlElement(name = "BaseQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BaseQuantityType baseQuantity;
    @XmlElement(name = "PriceChangeReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PriceChangeReasonType> priceChangeReason;
    @XmlElement(name = "PriceTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PriceTypeCodeType priceTypeCode;
    @XmlElement(name = "PriceType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PriceTypeType priceType;
    @XmlElement(name = "OrderableUnitFactorRate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected OrderableUnitFactorRateType orderableUnitFactorRate;
    @XmlElement(name = "ValidityPeriod", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<PeriodType> validityPeriod;
    @XmlElement(name = "PriceList", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected PriceListType priceList;
    @XmlElement(name = "AllowanceCharge", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<AllowanceChargeType> allowanceCharge;

    /**
     * 
     * 						13.1.1.11 - Precio Unitario: Precio unitario de
     * 						la unidad de bien o servicio servido/prestado,
     * 						en la moneda indicada en la Cabecera de la
     * 						Factura. Siempre sin Impuestos
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PriceAmountType }
     *     
     */
    public PriceAmountType getPriceAmount() {
        return priceAmount;
    }

    /**
     * Define el valor de la propiedad priceAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceAmountType }
     *     
     */
    public void setPriceAmount(PriceAmountType value) {
        this.priceAmount = value;
    }

    /**
     * 
     * 						13.1.1.10 - Unidad de Medida: Unidad en la que
     * 						est� referida la Cantidad. Debe referenciar a
     * 						una lista de c�digos. Recomendaciones 20 y 21 de
     * 						UN/CEFACT
     * 						(http://www.unece.org/cefact/recommendations/rec_index.html)
     * 					
     * 
     * @return
     *     possible object is
     *     {@link BaseQuantityType }
     *     
     */
    public BaseQuantityType getBaseQuantity() {
        return baseQuantity;
    }

    /**
     * Define el valor de la propiedad baseQuantity.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseQuantityType }
     *     
     */
    public void setBaseQuantity(BaseQuantityType value) {
        this.baseQuantity = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					Gets the value of the priceChangeReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the priceChangeReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPriceChangeReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PriceChangeReasonType }
     * 
     * 
     */
    public List<PriceChangeReasonType> getPriceChangeReason() {
        if (priceChangeReason == null) {
            priceChangeReason = new ArrayList<PriceChangeReasonType>();
        }
        return this.priceChangeReason;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PriceTypeCodeType }
     *     
     */
    public PriceTypeCodeType getPriceTypeCode() {
        return priceTypeCode;
    }

    /**
     * Define el valor de la propiedad priceTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceTypeCodeType }
     *     
     */
    public void setPriceTypeCode(PriceTypeCodeType value) {
        this.priceTypeCode = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PriceTypeType }
     *     
     */
    public PriceTypeType getPriceType() {
        return priceType;
    }

    /**
     * Define el valor de la propiedad priceType.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceTypeType }
     *     
     */
    public void setPriceType(PriceTypeType value) {
        this.priceType = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link OrderableUnitFactorRateType }
     *     
     */
    public OrderableUnitFactorRateType getOrderableUnitFactorRate() {
        return orderableUnitFactorRate;
    }

    /**
     * Define el valor de la propiedad orderableUnitFactorRate.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderableUnitFactorRateType }
     *     
     */
    public void setOrderableUnitFactorRate(OrderableUnitFactorRateType value) {
        this.orderableUnitFactorRate = value;
    }

    /**
     * 
     * 						13.1.1.14 - Periodo Servicio: Informaci�n sobre
     * 						el periodo de prestaci�n de un servicio
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
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PriceListType }
     *     
     */
    public PriceListType getPriceList() {
        return priceList;
    }

    /**
     * Define el valor de la propiedad priceList.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceListType }
     *     
     */
    public void setPriceList(PriceListType value) {
        this.priceList = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					Gets the value of the allowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllowanceChargeType }
     * 
     * 
     */
    public List<AllowanceChargeType> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<AllowanceChargeType>();
        }
        return this.allowanceCharge;
    }

}
