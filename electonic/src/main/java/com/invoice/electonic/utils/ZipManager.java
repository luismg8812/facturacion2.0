package com.invoice.electonic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipManager {
	public static void ZipFileTradicional (String ruta, String nombreArchivo) throws Exception{
		String rutaCompleta = ruta + nombreArchivo;
		File archivo = new File(rutaCompleta);
        
		int leido;
		byte[] buffer = new byte[(int) Files.size(Paths.get(rutaCompleta))];
		
		ZipOutputStream zipFacturaFisica = new ZipOutputStream(new FileOutputStream(rutaCompleta.replaceAll(".xml", ".zip")));
		zipFacturaFisica.setLevel(Deflater.DEFAULT_COMPRESSION);
		zipFacturaFisica.setMethod(Deflater.DEFLATED);
		FileInputStream entrada = new FileInputStream(archivo);
        zipFacturaFisica.putNextEntry(new ZipEntry(nombreArchivo));
        while ((leido = entrada.read(buffer)) > 0) {
        	zipFacturaFisica.write(buffer, 0, leido);
        }
        entrada.close();
        zipFacturaFisica.flush();
        zipFacturaFisica.close();
	}
	
	    public static void ZipFile(String ruta, String nombreArchivo) throws IOException {
	        String sourceFile = ruta + nombreArchivo;
	        FileOutputStream fos = new FileOutputStream(sourceFile.replaceAll(".xml", ".zip"));
	        ZipOutputStream zipOut = new ZipOutputStream(fos);
	        File fileToZip = new File(sourceFile);
	        FileInputStream fis = new FileInputStream(fileToZip);
	        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
	        zipOut.putNextEntry(zipEntry);
	        byte[] bytes = new byte[1024];
	        int length;
	        while((length = fis.read(bytes)) >= 0) {
	            zipOut.write(bytes, 0, length);
	        }
	        zipOut.close();
	        fis.close();
	        fos.close();
	    }
	
	public static void ZipFileZip4j (String ruta) throws Exception{
		System.out.println("Zipping file");
		ZipFile ZipFactura = new ZipFile(ruta.replaceAll(".xml", ".zip"));
		
		//codigo por si se quiere anidar varios archivos al zip
		//ArrayList<File> listaFatura = new ArrayList<File>();
		//listaFatura.add(new File(ruta));
		
		ZipParameters parametros = new ZipParameters();
		parametros.setCompressionMethod(Zip4jConstants.COMP_STORE);
		parametros.setCompressionLevel(Zip4jConstants.ENC_NO_ENCRYPTION);
		
		ZipFactura.addFile(new File(ruta), parametros);
	}
}

