
package co.gov.dian.www.servicios.facturaelectronica.ReportarFactura;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "facturaElectronicaPortName", targetNamespace = "http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura")
@HandlerChain(file = "FacturaElectronicaPortName_handler.xml")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FacturaElectronicaPortName {


    /**
     * 
     * @param envioFacturaElectronicaPeticion
     * @return
     *     returns co.gov.dian.servicios.facturaelectronica.reportarfactura.AcuseRecibo
     */
    @WebMethod(operationName = "EnvioFacturaElectronica")
    @WebResult(name = "EnvioFacturaElectronicaRespuesta", targetNamespace = "http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", partName = "EnvioFacturaElectronicaRespuesta")
    public AcuseRecibo envioFacturaElectronica(
        @WebParam(name = "EnvioFacturaElectronicaPeticion", targetNamespace = "http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", partName = "EnvioFacturaElectronicaPeticion")
        EnvioFacturaElectronica envioFacturaElectronicaPeticion);

}
