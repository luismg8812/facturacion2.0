package co.gov.dian.servicios.facturaelectronica.reportarfactura;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2018-11-17T11:34:38.855-05:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", name = "facturaElectronicaPortName")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface FacturaElectronicaPortName {

    @WebMethod(operationName = "EnvioFacturaElectronica")
    @WebResult(name = "EnvioFacturaElectronicaRespuesta", targetNamespace = "http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", partName = "EnvioFacturaElectronicaRespuesta")
    public AcuseRecibo envioFacturaElectronica(
        @WebParam(partName = "EnvioFacturaElectronicaPeticion", name = "EnvioFacturaElectronicaPeticion", targetNamespace = "http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura")
        EnvioFacturaElectronica envioFacturaElectronicaPeticion
    );
}