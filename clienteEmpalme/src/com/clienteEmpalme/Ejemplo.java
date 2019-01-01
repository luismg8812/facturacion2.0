package com.clienteEmpalme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

public class Ejemplo {
	
	static String input1 = "{\r\n" + 
			"	\"documentoId\":{\r\n" + 
			"		\"receptorId\":{\r\n" + 
			"			\"nombre\":\"Luis miguel\",\r\n" + 
			"			\"identificacion\":\"12345678\",\r\n" + 
			"			\"tipoOrganizacionJuridicaId\":1,\r\n" + 
			"			\"tipoIdenificacionId\":31,\r\n" + 
			"			\"regimen\":2,\r\n" + 
			"			\"razonSocial\":\"empresa prueba\",\r\n" + 
			"			\"apellidos\":\"gonzalez\",\r\n" + 
			"			\"direccion\":\"calle 5 #38a-13\",\r\n" + 
			"			\"email\":\"effectivesoftware1@gmail.com\"\r\n" + 
			"		},\r\n" + 
			"		\"fechaRegistro\":\"2018-11-09T12:00:00-06:30\",\r\n" + 
			"		\"numeroDocumento\":\"1234656547\",\r\n" + 
			"		\"total\":13600,\r\n" + 
			"		\"exento\":1000,\r\n" + 
			"		\"gravado\":10000,\r\n" + 
			"		\"iva\":1300,\r\n" + 
			"		\"iva19\":1000,\r\n" + 
			"		\"iva5\":300,\r\n" + 
			"		\"base19\":4500,\r\n" + 
			"		\"base5\":2300,\r\n" + 
			"		\"prefijo\":\"ABC\",\r\n" + 
			"		\"tipoDocumentoId\":1\r\n" + 
			"	},\r\n" + 
			"	\"documentoDetalleId\":[\r\n" + 
			"	{\r\n" + 
			"		\"productoId\":{\r\n" + 
			"			\"costo\":25000.2,\r\n" + 
			"			\"costoPublico\":30000,\r\n" + 
			"			\"iva\":19.0,\r\n" + 
			"			\"nombre\":\"producto prueba\",\r\n" + 
			"			\"codigoInterno\":\"123\"\r\n" + 
			"		},\r\n" + 
			"		\"fechaRegistro\":\"2018-11-09T12:00:00-06:30\",\r\n" + 
			"		\"parcial\":2400,\r\n" + 
			"		\"cantidad\":5,\r\n" + 
			"		\"codigoImpuesto\":\"01\"\r\n" + 
			"	},{\r\n" + 
			"		\"productoId\":{\r\n" + 
			"			\"costo\":2500,\r\n" + 
			"			\"costoPublico\":3000,\r\n" + 
			"			\"iva\":19.0,\r\n" + 
			"			\"nombre\":\"producto array prueba 2\",\r\n" + 
			"			\"codigoInterno\":\"123\"\r\n" + 
			"		},\r\n" + 
			"		\"fechaRegistro\":\"2018-11-09T12:00:00-06:30\",\r\n" + 
			"		\"parcial\":2400,\r\n" + 
			"		\"cantidad\":10,\r\n" + 
			"		\"codigoImpuesto\":\"01\"\r\n" + 
			"	}]\r\n" + 
			"}\r\n" + 
			"";

	public static void main(String[] args) {
		System.out.println("si entra");
		try {
			getMetodo2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	private static void getMetodo2() throws ClientProtocolException, IOException {
		 CredentialsProvider provider = new BasicCredentialsProvider();
		 UsernamePasswordCredentials credentials
		 = new UsernamePasswordCredentials("delta", "admin");
		 provider.setCredentials(AuthScope.ANY, credentials);
		   HttpPost post = new HttpPost("http://localhost:8060/empalmeDelta");
		   StringEntity input = new StringEntity(input1);
		   input.setContentType("application/json");
		   HttpClient client = HttpClientBuilder.create()
				   .setDefaultCredentialsProvider(provider)
				   .build();		   
		   post.setEntity(input);
		   HttpResponse response = client.execute(post);
		   BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		   String line = "";
		   while ((line = rd.readLine()) != null) {
		    System.out.println(line);
		   }
	}

}
