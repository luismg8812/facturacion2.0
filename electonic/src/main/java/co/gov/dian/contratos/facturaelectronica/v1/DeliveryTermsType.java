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
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LocationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LossRiskResponsibilityCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LossRiskType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SpecialTermsType;


/**
 * <p>Clase Java para DeliveryTermsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DeliveryTermsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SpecialTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LossRiskResponsibilityCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LossRisk" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryLocation" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowanceCharge" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryTermsType", propOrder = {
    "id",
    "specialTerms",
    "lossRiskResponsibilityCode",
    "lossRisk",
    "deliveryLocation",
    "allowanceCharge"
})
public class DeliveryTermsType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "SpecialTerms", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SpecialTermsType specialTerms;
    @XmlElement(name = "LossRiskResponsibilityCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LossRiskResponsibilityCodeType lossRiskResponsibilityCode;
    @XmlElement(name = "LossRisk", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LossRiskType lossRisk;
    @XmlElement(name = "DeliveryLocation", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected LocationType deliveryLocation;
    @XmlElement(name = "AllowanceCharge", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected AllowanceChargeType allowanceCharge;

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
     * 						M�todo de pago de costes de transporte: Se
     * 						utilizar para indicar c�mo se pagan los costes
     * 						del transporte (por ejemplo, Portes Debidos,
     * 						Portes Pagados)
     * 
     * 						Puede ser un texto libre que entiendan el
     * 						comprador y vendedor o codificarlo en una lista,
     * 						por ejemplo
     * 						http://www.unece.org/trade/untdid/d01b/tred/tred4215.htm
     * 					
     * 
     * @return
     *     possible object is
     *     {@link SpecialTermsType }
     *     
     */
    public SpecialTermsType getSpecialTerms() {
        return specialTerms;
    }

    /**
     * Define el valor de la propiedad specialTerms.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialTermsType }
     *     
     */
    public void setSpecialTerms(SpecialTermsType value) {
        this.specialTerms = value;
    }

    /**
     * 
     * 						2.2.10.2 - Condiciones de Entrega: Obligatorio
     * 						cuando sea una factura internacional�.Se
     * 						recomienda utilizar los INCOTERMS (International
     * 						Commercial Terms), utilizando la codificaci�n
     * 						est�ndar de 3 letras, por ejemplo�. CIF = Coste,
     * 						seguro, flete en el destino indicado CIP =
     * 						Flete, porte, seguro hasta destino CPT = Flete,
     * 						porte pagado hasta destino DAF = Entrega en la
     * 						frontera - lugar indicado FCA = Franco en el
     * 						transporte - Punto indicado EXW = En la f�brica
     * 
     * 						Esta campo deber�a pertenecer a una lista de
     * 						c�digos. Se aconseja utilizar los incoterms
     * 						2010,
     * 						http://www.iccwbo.org/products-and-services/trade-facilitation/incoterms-2010/the-incoterms-rules/
     * 					
     * 
     * @return
     *     possible object is
     *     {@link LossRiskResponsibilityCodeType }
     *     
     */
    public LossRiskResponsibilityCodeType getLossRiskResponsibilityCode() {
        return lossRiskResponsibilityCode;
    }

    /**
     * Define el valor de la propiedad lossRiskResponsibilityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link LossRiskResponsibilityCodeType }
     *     
     */
    public void setLossRiskResponsibilityCode(LossRiskResponsibilityCodeType value) {
        this.lossRiskResponsibilityCode = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link LossRiskType }
     *     
     */
    public LossRiskType getLossRisk() {
        return lossRisk;
    }

    /**
     * Define el valor de la propiedad lossRisk.
     * 
     * @param value
     *     allowed object is
     *     {@link LossRiskType }
     *     
     */
    public void setLossRisk(LossRiskType value) {
        this.lossRisk = value;
    }

    /**
     * 
     * 						10.5 - Destino Expedici�n o Despacho (ShipTO
     * 						party)
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
     *     {@link AllowanceChargeType }
     *     
     */
    public AllowanceChargeType getAllowanceCharge() {
        return allowanceCharge;
    }

    /**
     * Define el valor de la propiedad allowanceCharge.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowanceChargeType }
     *     
     */
    public void setAllowanceCharge(AllowanceChargeType value) {
        this.allowanceCharge = value;
    }

}
