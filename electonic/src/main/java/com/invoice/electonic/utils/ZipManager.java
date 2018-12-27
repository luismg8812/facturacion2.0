package com.invoice.electonic.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipManager {
	public static void ZipFileTradicional (String ruta, String nombreArchivo) throws Exception{
		String rutaCompleta = ruta + nombreArchivo;
		File archivo = new File(rutaCompleta);
        
		int leido;
		byte[] buffer = new byte[(int) Files.size(Paths.get(rutaCompleta))];
		
		ZipOutputStream zipFacturaFisica = new ZipOutputStream(new FileOutputStream(rutaCompleta.replaceAll(".xml", ".zip")));
		
		FileInputStream entrada = new FileInputStream(archivo);
        zipFacturaFisica.putNextEntry(new ZipEntry(nombreArchivo));
        while ((leido = entrada.read(buffer)) > 0) {
        	zipFacturaFisica.write(buffer, 0, leido);
        }
        
        zipFacturaFisica.flush();
        zipFacturaFisica.close();
	}
	
	public static void ZipFileZip4j (String ruta) throws Exception{
		System.out.println("Zipping file");
		ZipFile ZipFactura = new ZipFile(ruta.replaceAll(".xml", ".zip"));
		
		//codigo por si se quiere anidar varios archivos al zip
		//ArrayList<File> listaFatura = new ArrayList<File>();
		//listaFatura.add(new File(ruta));
		
		ZipParameters parametros = new ZipParameters();
		parametros.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parametros.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		
		ZipFactura.addFile(new File(ruta), parametros);
	}
}

