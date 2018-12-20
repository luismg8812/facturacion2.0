
package co.gov.dian.www.servicios.facturaelectronica.ReportarFactura;

import java.net.MalformedURLException;
import java.net.URL;
import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "facturaElectronicaPortNameService", targetNamespace = "http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", wsdlLocation = "https://facturaelectronica.dian.gov.co/habilitacion/B2BIntegrationEngine/FacturaElectronica/facturaElectronica.wsdl")
@HandlerChain(file = "FacturaElectronicaPortNameService_handler.xml")
public class FacturaElectronicaPortNameService
    extends Service
{

    private final static URL FACTURAELECTRONICAPORTNAMESERVICE_WSDL_LOCATION;
    private final static WebServiceException FACTURAELECTRONICAPORTNAMESERVICE_EXCEPTION;
    private final static QName FACTURAELECTRONICAPORTNAMESERVICE_QNAME = new QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "facturaElectronicaPortNameService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://facturaelectronica.dian.gov.co/habilitacion/B2BIntegrationEngine/FacturaElectronica/facturaElectronica.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FACTURAELECTRONICAPORTNAMESERVICE_WSDL_LOCATION = url;
        FACTURAELECTRONICAPORTNAMESERVICE_EXCEPTION = e;
    }

    public FacturaElectronicaPortNameService() {
        super(__getWsdlLocation(), FACTURAELECTRONICAPORTNAMESERVICE_QNAME);
    }

    public FacturaElectronicaPortNameService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FACTURAELECTRONICAPORTNAMESERVICE_QNAME, features);
    }

    public FacturaElectronicaPortNameService(URL wsdlLocation) {
        super(wsdlLocation, FACTURAELECTRONICAPORTNAMESERVICE_QNAME);
    }

    public FacturaElectronicaPortNameService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FACTURAELECTRONICAPORTNAMESERVICE_QNAME, features);
    }

    public FacturaElectronicaPortNameService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FacturaElectronicaPortNameService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FacturaElectronicaPortName
     */
    @WebEndpoint(name = "facturaElectronicaPortNameSoap11")
    public FacturaElectronicaPortName getFacturaElectronicaPortNameSoap11() {
        return super.getPort(new QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "facturaElectronicaPortNameSoap11"), FacturaElectronicaPortName.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FacturaElectronicaPortName
     */
    @WebEndpoint(name = "facturaElectronicaPortNameSoap11")
    public FacturaElectronicaPortName getFacturaElectronicaPortNameSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", "facturaElectronicaPortNameSoap11"), FacturaElectronicaPortName.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FACTURAELECTRONICAPORTNAMESERVICE_EXCEPTION!= null) {
            throw FACTURAELECTRONICAPORTNAMESERVICE_EXCEPTION;
        }
        return FACTURAELECTRONICAPORTNAMESERVICE_WSDL_LOCATION;
    }

}
