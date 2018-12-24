package com.invoice.electonic.utils;

import java.io.File;
import java.util.ArrayList;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipManager {
	public ZipManager (String ruta) throws Exception{
		System.out.println("Zipping file");
		ZipFile ZipFactura = new ZipFile(ruta.replaceAll(".xml", ".zip"));
		ArrayList<File> listaFatura = new ArrayList<File>();
		listaFatura.add(new File(ruta));
		
		ZipParameters parametros = new ZipParameters();
		parametros.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parametros.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		
		ZipFactura.addFiles(listaFatura, parametros);
	}
}
