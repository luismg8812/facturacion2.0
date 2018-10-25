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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RoundingAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxEvidenceIndicatorType;


/**
 * <p>Clase Java para TaxTotalType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TaxTotalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxAmount"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RoundingAmount" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TaxEvidenceIndicator"/>
 *         &lt;element ref="{http://www.dian.gov.co/contratos/facturaelectronica/v1}TaxSubtotal" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxTotalType", propOrder = {
    "taxAmount",
    "roundingAmount",
    "taxEvidenceIndicator",
    "taxSubtotal"
})
public class TaxTotalType {

    @XmlElement(name = "TaxAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TaxAmountType taxAmount;
    @XmlElement(name = "RoundingAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RoundingAmountType roundingAmount;
    @XmlElement(name = "TaxEvidenceIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TaxEvidenceIndicatorType taxEvidenceIndicator;
    @XmlElement(name = "TaxSubtotal", required = true)
    protected List<TaxSubtotalType> taxSubtotal;

    /**
     * 
     * 						7.1.1.4 - Importe Impuesto: Importe del impuesto
     * 						retenido
     * 					
     * 
     * @return
     *     possible object is
     *     {@link TaxAmountType }
     *     
     */
    public TaxAmountType getTaxAmount() {
        return taxAmount;
    }

    /**
     * Define el valor de la propiedad taxAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxAmountType }
     *     
     */
    public void setTaxAmount(TaxAmountType value) {
        this.taxAmount = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link RoundingAmountType }
     *     
     */
    public RoundingAmountType getRoundingAmount() {
        return roundingAmount;
    }

    /**
     * Define el valor de la propiedad roundingAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link RoundingAmountType }
     *     
     */
    public void setRoundingAmount(RoundingAmountType value) {
        this.roundingAmount = value;
    }

    /**
     * 
     * 						Indica que el elemento es un Impuesto retenido
     * 						(7.1.1) y no un impuesto (8.1.1)
     * 					
     * 
     * @return
     *     possible object is
     *     {@link TaxEvidenceIndicatorType }
     *     
     */
    public TaxEvidenceIndicatorType getTaxEvidenceIndicator() {
        return taxEvidenceIndicator;
    }

    /**
     * Define el valor de la propiedad taxEvidenceIndicator.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxEvidenceIndicatorType }
     *     
     */
    public void setTaxEvidenceIndicator(TaxEvidenceIndicatorType value) {
        this.taxEvidenceIndicator = value;
    }

    /**
     * 
     * 						Estructura requerida por UBL para representar la
     * 						informaci�n requerida por la factura electr�nica
     * 						DIAN
     * 					Gets the value of the taxSubtotal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxSubtotal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxSubtotal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxSubtotalType }
     * 
     * 
     */
    public List<TaxSubtotalType> getTaxSubtotal() {
        if (taxSubtotal == null) {
            taxSubtotal = new ArrayList<TaxSubtotalType>();
        }
        return this.taxSubtotal;
    }

}
