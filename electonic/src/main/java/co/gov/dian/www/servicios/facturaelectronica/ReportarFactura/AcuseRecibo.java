/**
 * AcuseRecibo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.gov.dian.www.servicios.facturaelectronica.ReportarFactura;

public class AcuseRecibo  implements java.io.Serializable {
    /* Relaciona cada factura recibida. */
    private co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.ReceivedInvoice receivedInvoice;

    /* La versión del formate de acuse de recibo. */
    private java.lang.String version;

    /* Fecha y hora en que se recibe el documento. */
    private java.util.Calendar receivedDateTime;

    /* Fecha y hora en que se crea el acuse de recibo */
    private java.util.Calendar responseDateTime;

    /* El código de respuesta, puede incluir mensajes
     * 						de error de validación estructural. */
    private int response;

    /* Espacio para comentarios */
    private java.lang.String comments;

    public AcuseRecibo() {
    }

    public AcuseRecibo(
           co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.ReceivedInvoice receivedInvoice,
           java.lang.String version,
           java.util.Calendar receivedDateTime,
           java.util.Calendar responseDateTime,
           int response,
           java.lang.String comments) {
           this.receivedInvoice = receivedInvoice;
           this.version = version;
           this.receivedDateTime = receivedDateTime;
           this.responseDateTime = responseDateTime;
           this.response = response;
           this.comments = comments;
    }


    /**
     * Gets the receivedInvoice value for this AcuseRecibo.
     * 
     * @return receivedInvoice   * Relaciona cada factura recibida.
     */
    public co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.ReceivedInvoice getReceivedInvoice() {
        return receivedInvoice;
    }


    /**
     * Sets the receivedInvoice value for this AcuseRecibo.
     * 
     * @param receivedInvoice   * Relaciona cada factura recibida.
     */
    public void setReceivedInvoice(co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.ReceivedInvoice receivedInvoice) {
        this.receivedInvoice = receivedInvoice;
    }


    /**
     * Gets the version value for this AcuseRecibo.
     * 
     * @return version   * La versión del formate de acuse de recibo.
     */
    public java.lang.String getVersion() {
        return version;
    }


    /**
     * Sets the version value for this AcuseRecibo.
     * 
     * @param version   * La versión del formate de acuse de recibo.
     */
    public void setVersion(java.lang.String version) {
        this.version = version;
    }


    /**
     * Gets the receivedDateTime value for this AcuseRecibo.
     * 
     * @return receivedDateTime   * Fecha y hora en que se recibe el documento.
     */
    public java.util.Calendar getReceivedDateTime() {
        return receivedDateTime;
    }


    /**
     * Sets the receivedDateTime value for this AcuseRecibo.
     * 
     * @param receivedDateTime   * Fecha y hora en que se recibe el documento.
     */
    public void setReceivedDateTime(java.util.Calendar receivedDateTime) {
        this.receivedDateTime = receivedDateTime;
    }


    /**
     * Gets the responseDateTime value for this AcuseRecibo.
     * 
     * @return responseDateTime   * Fecha y hora en que se crea el acuse de recibo
     */
    public java.util.Calendar getResponseDateTime() {
        return responseDateTime;
    }


    /**
     * Sets the responseDateTime value for this AcuseRecibo.
     * 
     * @param responseDateTime   * Fecha y hora en que se crea el acuse de recibo
     */
    public void setResponseDateTime(java.util.Calendar responseDateTime) {
        this.responseDateTime = responseDateTime;
    }


    /**
     * Gets the response value for this AcuseRecibo.
     * 
     * @return response   * El código de respuesta, puede incluir mensajes
     * 						de error de validación estructural.
     */
    public int getResponse() {
        return response;
    }


    /**
     * Sets the response value for this AcuseRecibo.
     * 
     * @param response   * El código de respuesta, puede incluir mensajes
     * 						de error de validación estructural.
     */
    public void setResponse(int response) {
        this.response = response;
    }


    /**
     * Gets the comments value for this AcuseRecibo.
     * 
     * @return comments   * Espacio para comentarios
     */
    public java.lang.String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this AcuseRecibo.
     * 
     * @param comments   * Espacio para comentarios
     */
    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AcuseRecibo)) return false;
        AcuseRecibo other = (AcuseRecibo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.receivedInvoice==null && other.getReceivedInvoice()==null) || 
             (this.receivedInvoice!=null &&
              this.receivedInvoice.equals(other.getReceivedInvoice()))) &&
            ((this.version==null && other.getVersion()==null) || 
             (this.version!=null &&
              this.version.equals(other.getVersion()))) &&
            ((this.receivedDateTime==null && other.getReceivedDateTime()==null) || 
             (this.receivedDateTime!=null &&
              this.receivedDateTime.equals(other.getReceivedDateTime()))) &&
            ((this.responseDateTime==null && other.getResponseDateTime()==null) || 
             (this.responseDateTime!=null &&
              this.responseDateTime.equals(other.getResponseDateTime()))) &&
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
        if (getReceivedInvoice() != null) {
            _hashCode += getReceivedInvoice().hashCode();
        }
        if (getVersion() != null) {
            _hashCode += getVersion().hashCode();
        }
        if (getReceivedDateTime() != null) {
            _hashCode += getReceivedDateTime().hashCode();
        }
        if (getResponseDateTime() != null) {
            _hashCode += getResponseDateTime().hashCode();
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
        new org.apache.axis.description.TypeDesc(AcuseRecibo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "AcuseRecibo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receivedInvoice");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "ReceivedInvoice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "ReceivedInvoice"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("version");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "Version"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receivedDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "ReceivedDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseDateTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "ResponseDateTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
