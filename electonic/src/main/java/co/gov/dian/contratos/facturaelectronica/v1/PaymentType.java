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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstructionIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaidAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaidDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaidTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReceivedDateType;


/**
 * <p>Clase Java para PaymentType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PaymentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaidAmount"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReceivedDate" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaidDate"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaidTime" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InstructionID" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentType", propOrder = {
    "id",
    "paidAmount",
    "receivedDate",
    "paidDate",
    "paidTime",
    "instructionID"
})
public class PaymentType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "PaidAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PaidAmountType paidAmount;
    @XmlElement(name = "ReceivedDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ReceivedDateType receivedDate;
    @XmlElement(name = "PaidDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PaidDateType paidDate;
    @XmlElement(name = "PaidTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaidTimeType paidTime;
    @XmlElement(name = "InstructionID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InstructionIDType instructionID;

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
     * 						6.1.1.2 - Importe Anticipo: Importe del anticipo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PaidAmountType }
     *     
     */
    public PaidAmountType getPaidAmount() {
        return paidAmount;
    }

    /**
     * Define el valor de la propiedad paidAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link PaidAmountType }
     *     
     */
    public void setPaidAmount(PaidAmountType value) {
        this.paidAmount = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ReceivedDateType }
     *     
     */
    public ReceivedDateType getReceivedDate() {
        return receivedDate;
    }

    /**
     * Define el valor de la propiedad receivedDate.
     * 
     * @param value
     *     allowed object is
     *     {@link ReceivedDateType }
     *     
     */
    public void setReceivedDate(ReceivedDateType value) {
        this.receivedDate = value;
    }

    /**
     * 
     * 						6.1.1.1 - Fecha: Fecha en formato reconocido del
     * 						anticipo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PaidDateType }
     *     
     */
    public PaidDateType getPaidDate() {
        return paidDate;
    }

    /**
     * Define el valor de la propiedad paidDate.
     * 
     * @param value
     *     allowed object is
     *     {@link PaidDateType }
     *     
     */
    public void setPaidDate(PaidDateType value) {
        this.paidDate = value;
    }

    /**
     * 
     * 						6.1.1.1 - Fecha (hora): Fecha en formato
     * 						reconocido del anticipo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link PaidTimeType }
     *     
     */
    public PaidTimeType getPaidTime() {
        return paidTime;
    }

    /**
     * Define el valor de la propiedad paidTime.
     * 
     * @param value
     *     allowed object is
     *     {@link PaidTimeType }
     *     
     */
    public void setPaidTime(PaidTimeType value) {
        this.paidTime = value;
    }

    /**
     * 
     * 						Opcional no usado por la DIAN, las partes pueden
     * 						definir un significado o simplemente omitirlo
     * 					
     * 
     * @return
     *     possible object is
     *     {@link InstructionIDType }
     *     
     */
    public InstructionIDType getInstructionID() {
        return instructionID;
    }

    /**
     * Define el valor de la propiedad instructionID.
     * 
     * @param value
     *     allowed object is
     *     {@link InstructionIDType }
     *     
     */
    public void setInstructionID(InstructionIDType value) {
        this.instructionID = value;
    }

}
