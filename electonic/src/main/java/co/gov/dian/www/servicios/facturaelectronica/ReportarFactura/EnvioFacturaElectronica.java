/**
 * EnvioFacturaElectronica.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.gov.dian.www.servicios.facturaelectronica.ReportarFactura;


/**
 * Envoltorio para recibir facturas electrónicas por medio de web
 * service
 */
public class EnvioFacturaElectronica  implements java.io.Serializable {
    private java.lang.String NIT;

    private java.lang.String invoiceNumber;

    private java.util.Calendar issueDate;

    /* Fichero de factura (solo una factura, en formato XML) */
    private byte[] document;

    public EnvioFacturaElectronica() {
    }

    public EnvioFacturaElectronica(
           java.lang.String NIT,
           java.lang.String invoiceNumber,
           java.util.Calendar issueDate,
           byte[] document) {
           this.NIT = NIT;
           this.invoiceNumber = invoiceNumber;
           this.issueDate = issueDate;
           this.document = document;
    }


    /**
     * Gets the NIT value for this EnvioFacturaElectronica.
     * 
     * @return NIT
     */
    public java.lang.String getNIT() {
        return NIT;
    }


    /**
     * Sets the NIT value for this EnvioFacturaElectronica.
     * 
     * @param NIT
     */
    public void setNIT(java.lang.String NIT) {
        this.NIT = NIT;
    }


    /**
     * Gets the invoiceNumber value for this EnvioFacturaElectronica.
     * 
     * @return invoiceNumber
     */
    public java.lang.String getInvoiceNumber() {
        return invoiceNumber;
    }


    /**
     * Sets the invoiceNumber value for this EnvioFacturaElectronica.
     * 
     * @param invoiceNumber
     */
    public void setInvoiceNumber(java.lang.String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }


    /**
     * Gets the issueDate value for this EnvioFacturaElectronica.
     * 
     * @return issueDate
     */
    public java.util.Calendar getIssueDate() {
        return issueDate;
    }


    /**
     * Sets the issueDate value for this EnvioFacturaElectronica.
     * 
     * @param issueDate
     */
    public void setIssueDate(java.util.Calendar issueDate) {
        this.issueDate = issueDate;
    }


    /**
     * Gets the document value for this EnvioFacturaElectronica.
     * 
     * @return document   * Fichero de factura (solo una factura, en formato XML)
     */
    public byte[] getDocument() {
        return document;
    }


    /**
     * Sets the document value for this EnvioFacturaElectronica.
     * 
     * @param document   * Fichero de factura (solo una factura, en formato XML)
     */
    public void setDocument(byte[] document) {
        this.document = document;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EnvioFacturaElectronica)) return false;
        EnvioFacturaElectronica other = (EnvioFacturaElectronica) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.NIT==null && other.getNIT()==null) || 
             (this.NIT!=null &&
              this.NIT.equals(other.getNIT()))) &&
            ((this.invoiceNumber==null && other.getInvoiceNumber()==null) || 
             (this.invoiceNumber!=null &&
              this.invoiceNumber.equals(other.getInvoiceNumber()))) &&
            ((this.issueDate==null && other.getIssueDate()==null) || 
             (this.issueDate!=null &&
              this.issueDate.equals(other.getIssueDate()))) &&
            ((this.document==null && other.getDocument()==null) || 
             (this.document!=null &&
              java.util.Arrays.equals(this.document, other.getDocument())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getNIT() != null) {
            _hashCode += getNIT().hashCode();
        }
        if (getInvoiceNumber() != null) {
            _hashCode += getInvoiceNumber().hashCode();
        }
        if (getIssueDate() != null) {
            _hashCode += getIssueDate().hashCode();
        }
        if (getDocument() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocument());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocument(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EnvioFacturaElectronica.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "EnvioFacturaElectronica"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NIT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "NIT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("invoiceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "InvoiceNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("issueDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "IssueDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("document");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "Document"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
