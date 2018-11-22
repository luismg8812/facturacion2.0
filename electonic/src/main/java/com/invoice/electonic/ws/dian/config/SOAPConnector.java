package com.invoice.electonic.ws.dian.config;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.invoice.electonic.ws.dian.AcuseRecibo;

public class SOAPConnector extends WebServiceGatewaySupport {
 
    @SuppressWarnings("unchecked")
	public AcuseRecibo callWebService(String url, Object request){
    	JAXBElement<AcuseRecibo> response = (JAXBElement<AcuseRecibo>) getWebServiceTemplate().marshalSendAndReceive(url, request);
        return response.getValue();
    }
}