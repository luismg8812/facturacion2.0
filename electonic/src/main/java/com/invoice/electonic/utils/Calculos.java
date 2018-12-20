package com.invoice.electonic.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Calculos {
	
	public static String completarDescripcion(String cantidad, int maxTamanoUnit) {
		String unit = "";
		int tamanoUnit = 0;
		unit = cantidad == null ? "0" : "" + cantidad;
		
		try {
			unit = unit.substring(0, maxTamanoUnit);
		} catch (Exception e2) {
			tamanoUnit = unit.length();
		}
		if (tamanoUnit != 0) {
			for (int j = tamanoUnit; j < maxTamanoUnit; j++) {
				unit = "0" + unit;
			}
		}
		return unit;
	}
	
	public static byte[] outputToByte(String ruta) throws IOException {
		File file = new File(ruta);     
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int red = 0;
		boolean finished = false;
		byte[] tempdata = new byte[(int) file.length()];
		FileInputStream fileInputStream = new FileInputStream(file);
		while (!finished) {
		  red = fileInputStream.read(tempdata);
		  if (red > 0) {
		    baos.write(tempdata, 0, red);
		  } else {
		    finished = true;
		  }
		}
		baos.flush();
		byte[] data = baos.toByteArray();
		baos.close();
		fileInputStream.close();
		return data;
	}
	
	public static String byteArrayToHexString(byte[] b) {
	  String result = "";
	  for (int i=0; i < b.length; i++) {
	    result +=
	          Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
	  }
	  return result;
	}
	
	public static Calendar toCalendar(Date date){ 
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(date);
	  return cal;
	}
}
