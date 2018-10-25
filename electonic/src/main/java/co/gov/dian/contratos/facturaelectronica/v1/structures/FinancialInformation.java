//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2018.10.08 a las 09:39:43 AM COT 
//


package co.gov.dian.contratos.facturaelectronica.v1.structures;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialAccountType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.TextType;


/**
 * 
 * 				2.1.12 - 2.1.12 Informaci�n Financiera
 * 			
 * 
 * <p>Clase Java para FinancialInformation complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FinancialInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Assignee" type="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PartyType"/>
 *         &lt;element name="PaymentDetails" type="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FinancialAccountType"/>
 *         &lt;element name="Clause" type="{urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2}TextType"/>
 *         &lt;element name="DocumentReference" type="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentReferenceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInformation", propOrder = {
    "assignee",
    "paymentDetails",
    "clause",
    "documentReference"
})
public class FinancialInformation {

    @XmlElement(name = "Assignee", required = true)
    protected PartyType assignee;
    @XmlElement(name = "PaymentDetails", required = true)
    protected FinancialAccountType paymentDetails;
    @XmlElement(name = "Clause", required = true)
    protected TextType clause;
    @XmlElement(name = "DocumentReference")
    protected List<DocumentReferenceType> documentReference;

    /**
     * Obtiene el valor de la propiedad assignee.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getAssignee() {
        return assignee;
    }

    /**
     * Define el valor de la propiedad assignee.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setAssignee(PartyType value) {
        this.assignee = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentDetails.
     * 
     * @return
     *     possible object is
     *     {@link FinancialAccountType }
     *     
     */
    public FinancialAccountType getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * Define el valor de la propiedad paymentDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialAccountType }
     *     
     */
    public void setPaymentDetails(FinancialAccountType value) {
        this.paymentDetails = value;
    }

    /**
     * Obtiene el valor de la propiedad clause.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getClause() {
        return clause;
    }

    /**
     * Define el valor de la propiedad clause.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setClause(TextType value) {
        this.clause = value;
    }

    /**
     * Gets the value of the documentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getDocumentReference() {
        if (documentReference == null) {
            documentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.documentReference;
    }

}
