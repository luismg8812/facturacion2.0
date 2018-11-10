package com.invoice.electonic.utils;

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
}
