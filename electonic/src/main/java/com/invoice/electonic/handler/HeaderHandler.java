package com.invoice.electonic.handler;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author foqc
 */
public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {
    
    @Override
    public Set<QName> getHeaders() {
        // throw new UnsupportedOperationException("Not supported yet.");
        final QName securityHeader = new QName(
                "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
                "Security", "wsse");
 
        final HashSet headers = new HashSet();
        headers.add(securityHeader);
 
        return headers;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext messageContext) {
        try {
            SOAPMessage msg = messageContext.getMessage();

            //se revisa si el WS es de consulta o de salida
            boolean bolMsgSalida = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
                    
            if (bolMsgSalida) {
                try {
                    // Obtenemos el contenedor del mensaje SOAP
                    SOAPPart sp = msg.getSOAPPart();
                    // A partir del contendor, obtenemos el nodo "Envelope"
                    SOAPEnvelope env = sp.getEnvelope();
                    
                    //se clarea el header por si existe algo
                    if (env.getHeader() != null) env.getHeader().detachNode();
                    
                    // Definimos los elementos a incluir en el mensaje para enviarlos al servidor que ofrece el servicio web
                    // Creo elemento - prefijo - URI y en el objeto padre Security se instancian todas las URIs
                    SOAPElement soapSecurity = SOAPFactory.newInstance().createElement("Security" , "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
                    soapSecurity.addNamespaceDeclaration("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
                    
                    SOAPElement soapUsernameToken = soapSecurity.addChildElement("UsernameToken", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

                    SOAPElement soapUsername = soapUsernameToken.addChildElement("Username", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
                    SOAPElement soapPassword = soapUsernameToken.addChildElement("Password", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
                    SOAPElement soapNonce = soapUsernameToken.addChildElement("Nonce", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
                    SOAPElement soapCreated = soapUsernameToken.addChildElement("Created", "wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

                    // Rellenamos la información del nodo credencial - AQUI SE DEBE COLOCAR LA INFO COMO SI FUERA UN OBJETO
                    soapUsername.addTextNode("54a7fd82-9ea1-498d-9d03-35fc75097a3d");
                    soapPassword.addTextNode("ba9033d37b0f85b299fea6ad1fd0ea0765a52d7bfaff07947a3ad01484844308");
                    soapNonce.addTextNode("FmbZRkx1jh2A+imgjD2fLQ==Password0000000000");
                    
                    try{
                        GregorianCalendar c = new GregorianCalendar();
                        c.setTime(new Date());
                        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

                        soapCreated.addTextNode(date2.toString());
                    }catch(DatatypeConfigurationException e){}

                    //asignacion de attributos de elementos hijos del header
                    soapSecurity.setAttribute("soapenv:mustUnderstand", "1");
                    soapPassword.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
                    soapNonce.setAttribute("EncodingType", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wsssoap-message-security-1.0#Base64Binary");

                    SOAPHeader soapHeader = env.addHeader(); // Crea un elemento cabecera SOAP
                    
                    soapHeader.addChildElement(soapSecurity);   //anido los elementos del objeto Security
                    
                    //get the soap message and envelope
                    SOAPMessage soapMsg = messageContext.getMessage();
                    soapMsg.getSOAPPart().getEnvelope().setPrefix("soapenv");
                    soapMsg.getSOAPBody().setPrefix("soapenv");
                    soapMsg.getSOAPHeader().setPrefix("soapenv");
                    
                    //Configuraciones para Instancias del Envelope
                    soapMsg.getSOAPPart().getEnvelope().setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:rep", "http://www.dian.gov.co/servicios/facturaelectronica/ReportarFactura");
                    soapMsg.getSOAPPart().getEnvelope().setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
                    soapMsg.getSOAPPart().getEnvelope().removeAttribute("xmlns:S");
                    soapMsg.getSOAPPart().getEnvelope().removeAttribute("xmlns:SOAP-ENV");
                    
                    //Configurando prefijo en el Body
                    soapMsg.getSOAPBody().getElementsByTagName("EnvioFacturaElectronicaPeticion").item(0).setPrefix("rep");
                    soapMsg.getSOAPBody().getElementsByTagName("NIT").item(0).setPrefix("rep");
                    soapMsg.getSOAPBody().getElementsByTagName("InvoiceNumber").item(0).setPrefix("rep");
                    soapMsg.getSOAPBody().getElementsByTagName("IssueDate").item(0).setPrefix("rep");
                    soapMsg.getSOAPBody().getElementsByTagName("Document").item(0).setPrefix("rep");
                    
                    msg.setProperty(SOAPMessage.WRITE_XML_DECLARATION, Boolean.TRUE.toString());
                    msg.saveChanges();
                } catch (SOAPException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(HeaderHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}