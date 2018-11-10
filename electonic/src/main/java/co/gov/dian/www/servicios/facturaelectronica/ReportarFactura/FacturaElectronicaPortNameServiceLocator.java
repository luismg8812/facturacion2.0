/**
 * FacturaElectronicaPortNameServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.gov.dian.www.servicios.facturaelectronica.ReportarFactura;

public class FacturaElectronicaPortNameServiceLocator extends org.apache.axis.client.Service implements co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortNameService {

    public FacturaElectronicaPortNameServiceLocator() {
    }


    public FacturaElectronicaPortNameServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FacturaElectronicaPortNameServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for facturaElectronicaPortNameSoap11
    private java.lang.String facturaElectronicaPortNameSoap11_address = "http://facturaelectronica.dian.gov.co:80/habilitacion/B2BIntegrationEngine/FacturaElectronica";

    public java.lang.String getfacturaElectronicaPortNameSoap11Address() {
        return facturaElectronicaPortNameSoap11_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String facturaElectronicaPortNameSoap11WSDDServiceName = "facturaElectronicaPortNameSoap11";

    public java.lang.String getfacturaElectronicaPortNameSoap11WSDDServiceName() {
        return facturaElectronicaPortNameSoap11WSDDServiceName;
    }

    public void setfacturaElectronicaPortNameSoap11WSDDServiceName(java.lang.String name) {
        facturaElectronicaPortNameSoap11WSDDServiceName = name;
    }

    public co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortName getfacturaElectronicaPortNameSoap11() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(facturaElectronicaPortNameSoap11_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getfacturaElectronicaPortNameSoap11(endpoint);
    }

    public co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortName getfacturaElectronicaPortNameSoap11(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortNameSoap11Stub _stub = new co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortNameSoap11Stub(portAddress, this);
            _stub.setPortName(getfacturaElectronicaPortNameSoap11WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setfacturaElectronicaPortNameSoap11EndpointAddress(java.lang.String address) {
        facturaElectronicaPortNameSoap11_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortName.class.isAssignableFrom(serviceEndpointInterface)) {
                co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortNameSoap11Stub _stub = new co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortNameSoap11Stub(new java.net.URL(facturaElectronicaPortNameSoap11_address), this);
                _stub.setPortName(getfacturaElectronicaPortNameSoap11WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("facturaElectronicaPortNameSoap11".equals(inputPortName)) {
            return getfacturaElectronicaPortNameSoap11();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "facturaElectronicaPortNameService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "facturaElectronicaPortNameSoap11"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("facturaElectronicaPortNameSoap11".equals(portName)) {
            setfacturaElectronicaPortNameSoap11EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
