package com.client.explorer.utils;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import org.jboss.logging.Logger;

public class Conector {
	
	private static Logger log = Logger.getLogger(Conector.class);
	static Socket cliente;
	static int puerto = 7010;
	
	static BufferedReader entrada;
	static PrintStream salida;
	
	public  String inicio(String ip,String gramera){
		String dato="";
		try {
			cliente =  new Socket(ip, puerto);
			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			String tec = "inicio";
			salida = new PrintStream(cliente.getOutputStream());
			salida.println(tec+":"+gramera);
			String msg=entrada.readLine();
			dato=msg;
			log.info(msg);
			entrada.close();
			salida.close();
			cliente.close();
		} catch (Exception e) {
			log.error("Error en el conector del socket:"+e.getStackTrace().toString());
		}
		return dato;
	}

}
