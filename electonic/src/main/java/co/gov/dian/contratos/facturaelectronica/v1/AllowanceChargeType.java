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
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AllowanceChargeReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AllowanceChargeReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MultiplierFactorNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrepaidIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SequenceNumericType;


/**
 * <p>Clase Java para AllowanceChargeType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AllowanceChargeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ChargeIndicator"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AllowanceChargeReasonCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AllowanceChargeReason" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MultiplierFactorNumeric"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrepaidIndicator" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SequenceNumeric" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Amount"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BaseAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AccountingCostCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AccountingCost" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxCategory" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TaxTotal" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentMeans" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllowanceChargeType", propOrder = {
    "id",
    "chargeIndicator",
    "allowanceChargeReasonCode",
    "allowanceChargeReason",
    "multiplierFactorNumeric",
    "prepaidIndicator",
    "sequenceNumeric",
    "amount",
    "baseAmount",
    "accountingCostCode",
    "accountingCost",
    "taxCategory",
    "taxTotal",
    "paymentMeans"
})
public class AllowanceChargeType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "ChargeIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ChargeIndicatorType chargeIndicator;
    @XmlElement(name = "AllowanceChargeReasonCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AllowanceChargeReasonCodeType allowanceChargeReasonCode;
    @XmlElement(name = "AllowanceChargeReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AllowanceChargeReasonType allowanceChargeReason;
    @XmlElement(name = "MultiplierFactorNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected MultiplierFactorNumericType multiplierFactorNumeric;
    @XmlElement(name = "PrepaidIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PrepaidIndicatorType prepaidIndicator;
    @XmlElement(name = "SequenceNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SequenceNumericType sequenceNumeric;
    @XmlElement(name = "Amount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected AmountType amount;
    @XmlElement(name = "BaseAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BaseAmountType baseAmount;
    @XmlElement(name = "AccountingCostCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AccountingCostCodeType accountingCostCode;
    @XmlElement(name = "AccountingCost", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AccountingCostType accountingCost;
    @XmlElement(name = "TaxCategory", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<TaxCategoryType> taxCategory;
    @XmlElement(name = "TaxTotal", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected TaxTotalType taxTotal;
    @XmlElement(name = "PaymentMeans", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<PaymentMeansType> paymentMeans;

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
     * 						Indica que el elemento es un Cargo (5.1.1) y no
     * 						un descuento (4.1.1)
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ChargeIndicatorType }
     *     
     */
    public ChargeIndicatorType getChargeIndicator() {
        return chargeIndicator;
    }

    /**
     * Define el valor de la propiedad chargeIndicator.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeIndicatorType }
     *     
     */
    public void setChargeIndicator(ChargeIndicatorType value) {
        this.chargeIndicator = value;
    }

    /**
     * 
     * 						4.1.1.1 / 5.1.1.1 - Raz�n (c�digo): Obligatorio
     * 						si es factura internacional. Texto libre para
     * 						informar de la raz�n del descuento. Se puede
     * 						sustituir por una referencia a una lista de
     * 						c�digos
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AllowanceChargeReasonCodeType }
     *     
     */
    public AllowanceChargeReasonCodeType getAllowanceChargeReasonCode() {
        return allowanceChargeReasonCode;
    }

    /**
     * Define el valor de la propiedad allowanceChargeReasonCode.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowanceChargeReasonCodeType }
     *     
     */
    public void setAllowanceChargeReasonCode(AllowanceChargeReasonCodeType value) {
        this.allowanceChargeReasonCode = value;
    }

    /**
     * 
     * 						4.1.1.1 / 5.1.1.1 - Raz�n (texto): Obligatorio
     * 						si es factura internacional. Texto libre para
     * 						informar de la raz�n del descuento. Se puede
     * 						sustituir por una referencia a una lista de
     * 						c�digos
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AllowanceChargeReasonType }
     *     
     */
    public AllowanceChargeReasonType getAllowanceChargeReason() {
        return allowanceChargeReason;
    }

    /**
     * Define el valor de la propiedad allowanceChargeReason.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowanceChargeReasonType }
     *     
     */
    public void setAllowanceChargeReason(AllowanceChargeReasonType value) {
        this.allowanceChargeReason = value;
    }

    /**
     * 
     * 						4.1.1.2 / 5.1.1.2 - Porcentaje: Porcentaje a
     * 						aplicar.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link MultiplierFactorNumericType }
     *     
     */
    public MultiplierFactorNumericType getMultiplierFactorNumeric() {
        return multiplierFactorNumeric;
    }

    /**
     * Define el valor de la propiedad multiplierFactorNumeric.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiplierFactorNumericType }
     *     
     */
    public void setMultiplierFactorNumeric(MultiplierFactorNumericType value) {
        this.multiplierFactorNumeric = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PrepaidIndicatorType }
     *     
     */
    public PrepaidIndicatorType getPrepaidIndicator() {
        return prepaidIndicator;
    }

    /**
     * Define el valor de la propiedad prepaidIndicator.
     * 
     * @param value
     *     allowed object is
     *     {@link PrepaidIndicatorType }
     *     
     */
    public void setPrepaidIndicator(PrepaidIndicatorType value) {
        this.prepaidIndicator = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link SequenceNumericType }
     *     
     */
    public SequenceNumericType getSequenceNumeric() {
        return sequenceNumeric;
    }

    /**
     * Define el valor de la propiedad sequenceNumeric.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceNumericType }
     *     
     */
    public void setSequenceNumeric(SequenceNumericType value) {
        this.sequenceNumeric = value;
    }

    /**
     * 
     * 						4.1.1.3 / 5.1.1.3 - Valor Descuento: Importe
     * 						total a descontar.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAmount() {
        return amount;
    }

    /**
     * Define el valor de la propiedad amount.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAmount(AmountType value) {
        this.amount = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link BaseAmountType }
     *     
     */
    public BaseAmountType getBaseAmount() {
        return baseAmount;
    }

    /**
     * Define el valor de la propiedad baseAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseAmountType }
     *     
     */
    public void setBaseAmount(BaseAmountType value) {
        this.baseAmount = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AccountingCostCodeType }
     *     
     */
    public AccountingCostCodeType getAccountingCostCode() {
        return accountingCostCode;
    }

    /**
     * Define el valor de la propiedad accountingCostCode.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingCostCodeType }
     *     
     */
    public void setAccountingCostCode(AccountingCostCodeType value) {
        this.accountingCostCode = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link AccountingCostType }
     *     
     */
    public AccountingCostType getAccountingCost() {
        return accountingCost;
    }

    /**
     * Define el valor de la propiedad accountingCost.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountingCostType }
     *     
     */
    public void setAccountingCost(AccountingCostType value) {
        this.accountingCost = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					Gets the value of the taxCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxCategoryType }
     * 
     * 
     */
    public List<TaxCategoryType> getTaxCategory() {
        if (taxCategory == null) {
            taxCategory = new ArrayList<TaxCategoryType>();
        }
        return this.taxCategory;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link TaxTotalType }
     *     
     */
    public TaxTotalType getTaxTotal() {
        return taxTotal;
    }

    /**
     * Define el valor de la propiedad taxTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxTotalType }
     *     
     */
    public void setTaxTotal(TaxTotalType value) {
        this.taxTotal = value;
    }

    /**
     * 
     * 						4.1.1.4 / 5.1.1.4 - Informaci�n adicional: Texto
     * 						libre para la a�adir informaci�n adicional
     * 					Gets the value of the paymentMeans property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentMeans property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentMeans().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentMeansType }
     * 
     * 
     */
    public List<PaymentMeansType> getPaymentMeans() {
        if (paymentMeans == null) {
            paymentMeans = new ArrayList<PaymentMeansType>();
        }
        return this.paymentMeans;
    }

}
