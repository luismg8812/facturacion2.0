package co.gov.dian.www.servicios.facturaelectronica.ReportarFactura;

public class FacturaElectronicaPortNameProxy implements co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortName {
  private String _endpoint = null;
  private co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortName facturaElectronicaPortName = null;
  
  public FacturaElectronicaPortNameProxy() {
    _initFacturaElectronicaPortNameProxy();
  }
  
  public FacturaElectronicaPortNameProxy(String endpoint) {
    _endpoint = endpoint;
    _initFacturaElectronicaPortNameProxy();
  }
  
  private void _initFacturaElectronicaPortNameProxy() {
    try {
      facturaElectronicaPortName = (new co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortNameServiceLocator()).getfacturaElectronicaPortNameSoap11();
      if (facturaElectronicaPortName != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)facturaElectronicaPortName)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)facturaElectronicaPortName)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (facturaElectronicaPortName != null)
      ((javax.xml.rpc.Stub)facturaElectronicaPortName)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortName getFacturaElectronicaPortName() {
    if (facturaElectronicaPortName == null)
      _initFacturaElectronicaPortNameProxy();
    return facturaElectronicaPortName;
  }
  
  public co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.AcuseRecibo envioFacturaElectronica(co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.EnvioFacturaElectronica envioFacturaElectronicaPeticion) throws java.rmi.RemoteException{
    if (facturaElectronicaPortName == null)
      _initFacturaElectronicaPortNameProxy();
    return facturaElectronicaPortName.envioFacturaElectronica(envioFacturaElectronicaPeticion);
  }
  
  
}