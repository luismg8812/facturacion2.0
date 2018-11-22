package com.invoice.electonic.ws.dian.config;


import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;


@Configuration
public class Config {
	
	@Bean
    public Wss4jSecurityInterceptor securityInterceptor(){
        Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
        wss4jSecurityInterceptor.setSecurementPasswordType("PasswordText");
        wss4jSecurityInterceptor.setSecurementActions(WSHandlerConstants.USERNAME_TOKEN);
        wss4jSecurityInterceptor.setSecurementUsername("54a7fd82-9ea1-498d-9d03-35fc75097a3d");
        wss4jSecurityInterceptor.setSecurementPassword("BA9033D37B0F85B299FEA6AD1FD0EA0765A52D7BFAFF07947A3AD01484844308");
        wss4jSecurityInterceptor.setSecurementUsernameTokenCreated(true);
        wss4jSecurityInterceptor.setSecurementUsernameTokenNonce(true);    
        return wss4jSecurityInterceptor;
    }
	
	
	
    @Bean 
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.invoice.electonic.ws.dian");
        return marshaller;
    }
 
    @Bean
    public SOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
        SOAPConnector client = new SOAPConnector();
        client.setDefaultUri("http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setInterceptors(new ClientInterceptor[] {securityInterceptor()});
        return client;
    }
}