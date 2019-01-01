package com.invoice.electonic.handler;

import java.util.Collections;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author foqc
 */
public class LogMessageHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }
//Este método, imprime el contenido del mensaje SOAP, para determinar como se esta enviado dicho mensaje.
    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        SOAPMessage msg = context.getMessage(); //Line 1
        try {
            System.out.println("Mensaje Encontrado");
            msg.writeTo(System.out);  //Line 3
            System.out.println();
        } catch (Exception ex) {
            Logger.getLogger(LogMessageHandler.class.getName()).log(Level.SEVERE, null, ex);
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