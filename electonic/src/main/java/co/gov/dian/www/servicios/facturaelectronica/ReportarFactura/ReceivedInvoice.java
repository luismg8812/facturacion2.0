/**
 * ReceivedInvoice.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.gov.dian.www.servicios.facturaelectronica.ReportarFactura;

public class ReceivedInvoice  implements java.io.Serializable {
    private java.lang.String numeroFactura;

    /* El identificador universal de la factura. */
    private java.lang.String UUID;

    /* El código de respuesta, puede
     * 						incluir mensajes de error de validación estructural. */
    private int response;

    /* Espacio para comentarios */
    private java.lang.String comments;

    public ReceivedInvoice() {
    }

    public ReceivedInvoice(
           java.lang.String numeroFactura,
           java.lang.String UUID,
           int response,
           java.lang.String comments) {
           this.numeroFactura = numeroFactura;
           this.UUID = UUID;
           this.response = response;
           this.comments = comments;
    }


    /**
     * Gets the numeroFactura value for this ReceivedInvoice.
     * 
     * @return numeroFactura
     */
    public java.lang.String getNumeroFactura() {
        return numeroFactura;
    }


    /**
     * Sets the numeroFactura value for this ReceivedInvoice.
     * 
     * @param numeroFactura
     */
    public void setNumeroFactura(java.lang.String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }


    /**
     * Gets the UUID value for this ReceivedInvoice.
     * 
     * @return UUID   * El identificador universal de la factura.
     */
    public java.lang.String getUUID() {
        return UUID;
    }


    /**
     * Sets the UUID value for this ReceivedInvoice.
     * 
     * @param UUID   * El identificador universal de la factura.
     */
    public void setUUID(java.lang.String UUID) {
        this.UUID = UUID;
    }


    /**
     * Gets the response value for this ReceivedInvoice.
     * 
     * @return response   * El código de respuesta, puede
     * 						incluir mensajes de error de validación estructural.
     */
    public int getResponse() {
        return response;
    }


    /**
     * Sets the response value for this ReceivedInvoice.
     * 
     * @param response   * El código de respuesta, puede
     * 						incluir mensajes de error de validación estructural.
     */
    public void setResponse(int response) {
        this.response = response;
    }


    /**
     * Gets the comments value for this ReceivedInvoice.
     * 
     * @return comments   * Espacio para comentarios
     */
    public java.lang.String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this ReceivedInvoice.
     * 
     * @param comments   * Espacio para comentarios
     */
    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReceivedInvoice)) return false;
        ReceivedInvoice other = (ReceivedInvoice) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numeroFactura==null && other.getNumeroFactura()==null) || 
             (this.numeroFactura!=null &&
              this.numeroFactura.equals(other.getNumeroFactura()))) &&
            ((this.UUID==null && other.getUUID()==null) || 
             (this.UUID!=null &&
              this.UUID.equals(other.getUUID()))) &&
            this.response == other.getResponse() &&
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              this.comments.equals(other.getComments())));
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
        if (getNumeroFactura() != null) {
            _hashCode += getNumeroFactura().hashCode();
        }
        if (getUUID() != null) {
            _hashCode += getUUID().hashCode();
        }
        _hashCode += getResponse();
        if (getComments() != null) {
            _hashCode += getComments().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReceivedInvoice.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "ReceivedInvoice"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroFactura");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "NumeroFactura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("UUID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "UUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("response");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "Response"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "Comments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
