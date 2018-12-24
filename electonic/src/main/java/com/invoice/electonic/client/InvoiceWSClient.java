package com.invoice.electonic.client;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.handler.Handler;

import com.invoice.electonic.handler.LogMessageHandler;

import co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.AcuseRecibo;
import co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.EnvioFacturaElectronica;
import co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortName;
import co.gov.dian.www.servicios.facturaelectronica.ReportarFactura.FacturaElectronicaPortNameService;

@WebServiceClient(name = "EnvioFacturaService", targetNamespace = "http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura", wsdlLocation = "https://facturaelectronica.dian.gov.co/habilitacion/B2BIntegrationEngine/FacturaElectronica/facturaElectronica.wsdl")
public class InvoiceWSClient{
	public static String envioSWDIAN2(String ruta, String clienteNit, String InvoiceNumber) throws DatatypeConfigurationException, IOException{
		EnvioFacturaElectronica FacturaPeticion = new EnvioFacturaElectronica();
        
        //asignacion Body
        FacturaPeticion.setNIT(clienteNit);
        FacturaPeticion.setInvoiceNumber(InvoiceNumber);

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

        //FacturaPeticion.setIssueDate(Calculos.toCalendar(new Date()));
        FacturaPeticion.setIssueDate(date2);
        
        DataHandler document = new DataHandler(new FileDataSource(ruta));
        //byte[] binaryDocument = org.apache.commons.io.IOUtils.toByteArray(document.getInputStream());
        
        FacturaPeticion.setDocument(document);
        
        AcuseRecibo acuseRecibo = envioFacturaElectronica(FacturaPeticion);
        System.out.print(acuseRecibo);
		return "";
	}
	
	private static AcuseRecibo envioFacturaElectronica(EnvioFacturaElectronica envioFacturaElectronicaPeticion) throws RemoteException {
		FacturaElectronicaPortNameService service = new FacturaElectronicaPortNameService();
        FacturaElectronicaPortName port = service.getFacturaElectronicaPortNameSoap11();
                
        //bloque de codigo para ver que esta yendo en la peticion SOAP
        BindingProvider bindingProvider = (BindingProvider)port;
        Binding binding = bindingProvider.getBinding();
        
        //redireccion al end-point para que no bote error por http 302
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://facturaelectronica.dian.gov.co/habilitacion/B2BIntegrationEngine/FacturaElectronica/facturaElectronica.wsdl");

        List<Handler> handlerChain = binding.getHandlerChain();
        handlerChain.add(new LogMessageHandler());	//aqui se imprmie el request  el response
        binding.setHandlerChain(handlerChain);
        
        return port.envioFacturaElectronica(envioFacturaElectronicaPeticion);
    }
}
