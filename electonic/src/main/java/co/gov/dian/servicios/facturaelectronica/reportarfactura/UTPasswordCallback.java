package co.gov.dian.servicios.facturaelectronica.reportarfactura;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class UTPasswordCallback implements CallbackHandler{
	private Map<String, String> passwords = new HashMap<String, String>();
	
	public UTPasswordCallback() {
		passwords.put("cxf", "cxf");
	}
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (Callback callback : callbacks) {
			WSPasswordCallback pc = (WSPasswordCallback) callback;
			
			String pass = (String) passwords.get(pc.getIdentifier());
			if (pass != null) {
				pc.setPassword(pass);
				return;
			}
		}

	}

}
