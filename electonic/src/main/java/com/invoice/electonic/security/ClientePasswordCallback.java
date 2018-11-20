package com.invoice.electonic.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;








public class ClientePasswordCallback implements CallbackHandler{
	 @Override
	   public void handle(Callback[] callbacks) throws IOException,
	         UnsupportedCallbackException {
	      WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
	      // set the password for our message.
	      pc.setPassword("BA9033D37B0F85B299FEA6AD1FD0EA0765A52D7BFAFF07947A3AD01484844308");
	      System.out.println("pass: BA9033D37B0F85B299FEA6AD1FD0EA0765A52D7BFAFF07947A3AD01484844308");
	      // En caso de que el cliente sea multiusuario, 
	      // con pc.getIdentifier() podriamos obtener el nombre de usuario
	      // para poner la password que corresponda a ese usuario.
	   }
}
