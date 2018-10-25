package com.client.explorer.utils;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.jboss.logging.Logger;

import com.client.explorer.model.Configuracion;
import com.client.explorer.vo.DocumentoDetalleVo;
import com.client.explorer.vo.ImpresionFacturaVo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class ImpresionFull {
	
	private static Logger log = Logger.getLogger(ImpresionFull.class);
	private static final  String  LINE = "-------------------------------------------------";
	private static final  String  RUTA_FACTURAS = "C:\\effectiveSoftware\\facturacion\\facturas";
	
	
	public String imprimirPDF(ImpresionFacturaVo  impresionFacturaVo) throws DocumentException, FileNotFoundException {
		log.info("todo el codigo de imprimir");
		String carpeta = RUTA_FACTURAS;
		String pdf = "\\factura_" + impresionFacturaVo.getDocumentoId().getDocumentoId() + ".pdf";
		File folder = new File(carpeta);
		folder.mkdirs();
		FileOutputStream archivo = new FileOutputStream(carpeta+pdf);
		DecimalFormat formatea = new DecimalFormat("###,###.##");
		Document documento = new Document();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Image imagen=null;
		try {
		    imagen = Image.getInstance("C://facturacion/logoEmpresa.jpg");
			imagen.scaleAbsoluteWidth(200f);
			imagen.scaleAbsoluteHeight(80f);
		} catch (Exception e2) {
			log.error("la empresa no tiene logo");
		}
		
		float fntSize ;
		float lineSpacing;
		fntSize = 9f;
		lineSpacing = 10f;
		PdfWriter.getInstance(documento, archivo);
		documento.setMargins(10, 1, 1, 1);
		documento.open();
		documento.add(new Paragraph(new Phrase(lineSpacing, LINE))); // REPRESENTANTE
		if(imagen!=null){
			documento.add(imagen); // LEGAL
		}
		documento.add(new Paragraph(
				new Phrase(lineSpacing, "" + impresionFacturaVo.getEmpresa().getNombre(), FontFactory.getFont(FontFactory.COURIER_BOLD, 13f)))); // NOMBRE_EMPRESA
		documento.add(new Paragraph(new Phrase(lineSpacing, "" + impresionFacturaVo.getEmpresa().getSlogan() == null ? "" : impresionFacturaVo.getEmpresa().getSlogan().toUpperCase(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // slogan
		documento.add(new Paragraph(new Phrase(lineSpacing, "" + impresionFacturaVo.getEmpresa().getRepresentante(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE_LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "NIT. " + impresionFacturaVo.getEmpresa().getNit() + " " + impresionFacturaVo.getEmpresa().getRegimen(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // NIT
		documento.add(new Paragraph(new Phrase(lineSpacing, "TEL: " + impresionFacturaVo.getEmpresa().getTelefonoFijo() + " - " + impresionFacturaVo.getEmpresa().getCel(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // tel
		documento.add(new Paragraph(new Phrase(lineSpacing, "" + impresionFacturaVo.getEmpresa().getDireccion() + " - " + impresionFacturaVo.getEmpresa().getBarrio(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // DIRECCION_Y_BARRIO
		documento.add(new Paragraph(new Phrase(lineSpacing, "" + impresionFacturaVo.getEmpresa().getCiudad() + "- " + impresionFacturaVo.getEmpresa().getDepartamento(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // ciudad		
		documento.add(new Paragraph(new Phrase(lineSpacing, impresionFacturaVo.getTitulaFactura()+": " + impresionFacturaVo.getDocumentoId().getConsecutivoDian(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, 11f)))); // numer_de_factura
		String fhoyIni = df.format(impresionFacturaVo.getDocumentoId().getFechaRegistro());
		documento.add(new Paragraph(new Phrase(lineSpacing, "FECHA: " + fhoyIni, FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // fecha
		documento.add(new Paragraph(new Phrase(lineSpacing,"CAJERO: " + impresionFacturaVo.getNombreUsuario() ,
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "CAJA: " + Calculos.conseguirMAC(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // fecha
		documento
				.add(new Paragraph(new Phrase(lineSpacing,
						"CLIENTE: " + impresionFacturaVo.getNombreCliente(),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
		documento.add(new Paragraph(new Phrase(lineSpacing,
				"CC/NIT: " +impresionFacturaVo.getIdentificacionCliente() ,
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
		if(impresionFacturaVo.getDocumentoId().getEmpleadoId()!=null){
			documento.add(new Paragraph(
					new Phrase(lineSpacing, "MESERO: " + "nombre del mesero", FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // fecha
		}
		// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, LINE))); // REPRESENTANTE
		// lineSpacing, "Descripci�n CANT UNIDAD TOTAL" LEGAL
		String impuesto = impresionFacturaVo.getEmpresa().getImpuesto().equals("IVA") ? "IVA" : "IPO";
		documento.add(new Paragraph(new Phrase(lineSpacing, "CANT Descripción      UNI  TOTAL  " + impuesto,
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, LINE))); // REPRESENTANTE
		// LEGAL
		for (DocumentoDetalleVo ddV : impresionFacturaVo.getDocumentoDetalleVo()) {
			// descripcion
			String nombre = "";
			int maxTamanoNombre = impresionFacturaVo.getConfiguracion().getNombreProductoLargo() == 1l ? 24 : 17;
			nombre = Calculos.cortarDescripcion(ddV.getNombreProducto(), maxTamanoNombre);

			// Cantidad
			String cant = "";
			int maxTamanoCant = 3;
			cant = Calculos.cortarCantidades(ddV.getCantidad(), maxTamanoCant);

			// Unitario
			String unit = "";
			int maxTamanoUnit = 5;
			unit = Calculos.cortarCantidades(ddV.getUnitario(), maxTamanoUnit);

			// total
			Double totalDouble = 0.0;
			String total = "";
			int maxTamanoTotal = 6;
			try {
				totalDouble = ddV.getUnitario() * ddV.getCantidad();
			} catch (Exception e2) {
				totalDouble = 0.0;
			}
			total = Calculos.cortarCantidades(totalDouble, maxTamanoTotal);

			// iva
			String iva = "";
			iva = Calculos.cortarCantidades(ddV.getIva(), 2);
			if (impresionFacturaVo.getConfiguracion().getNombreProductoLargo() == 1l) {
				documento.add(new Paragraph(new Phrase(lineSpacing, cant + " " + nombre,
						FontFactory.getFont(FontFactory.COURIER_BOLD, 12f)))); // CANTIDAD
																				// NOMBRE
				documento.add(
						new Paragraph(new Phrase(lineSpacing, "                  " + unit + " " + total + "  " + iva,
								FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
			} else {
				documento.add(new Paragraph(
						new Phrase(lineSpacing, cant + " " + nombre + " " + unit + " " + total + " " + iva,
								FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // CANTIDAD
																							// NOMBRE
			}

			// LEGAL
		}
		documento.add(new Paragraph(new Phrase(lineSpacing, LINE))); // REPRESENTANTE
		// LEGAL
		documento
				.add(new Paragraph(new Phrase(lineSpacing,
						"Valor Exento:          "
								+ Calculos.cortarCantidades(formatea.format(impresionFacturaVo.getDocumentoId().getExcento()), 13),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																					// LEGAL
		documento
				.add(new Paragraph(new Phrase(lineSpacing,
						"Valor Gravado:         "
								+ Calculos.cortarCantidades(formatea.format(impresionFacturaVo.getDocumentoId().getGravado()), 13),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																					// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing,
				(impresionFacturaVo.getEmpresa().getImpuesto().equals("IVA") ? "IVA" : "IPO") + ":                   "
						+ Calculos.cortarCantidades(formatea.format(impresionFacturaVo.getDocumentoId().getIva()), 13),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, LINE))); // REPRESENTANTE
		// LEGAL
		documento
				.add(new Paragraph(new Phrase(lineSpacing, "TOTAL A PAGAR: " + formatea.format(impresionFacturaVo.getDocumentoId().getTotal()),
						FontFactory.getFont(FontFactory.COURIER_BOLD, 14f)))); // REPRESENTANTE
																				// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, LINE))); // REPRESENTANTE
		// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "         **** FORMA DE PAGO****        ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		Double pago = impresionFacturaVo.getDocumentoId().getValorTarjeta() == null ? 0l : impresionFacturaVo.getDocumentoId().getValorTarjeta();
		documento.add(
				new Paragraph(new Phrase(lineSpacing, "Vr. Pago con Tarjeta:  " + Calculos.cortarCantidades(pago, 13),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																					// LEGAL
		documento.add(
				new Paragraph(new Phrase(lineSpacing, "Vr. Pago con cheque:   " + Calculos.cortarCantidades(0.0, 13),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																					// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing,
				"Efectivo:			              " + Calculos.cortarCantidades(
						(impresionFacturaVo.getDocumentoId().getEfectivo() == null ? "0" : "" + impresionFacturaVo.getDocumentoId().getEfectivo()), 13),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing,
				"Cambio:	 		               " + Calculos
						.cortarCantidades((impresionFacturaVo.getDocumentoId().getCambio() == null ? "0" : "" + impresionFacturaVo.getDocumentoId().getCambio()), 13),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, LINE))); // REPRESENTANTE
		// LEGAL
		documento.add(new Paragraph(
				new Phrase(lineSpacing, "Res. " + impresionFacturaVo.getEmpresa().getResolucionDian() + " Fecha: " + impresionFacturaVo.getEmpresa().getFechaResolucion(),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																					// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing,
				"Rango autorizado desde: " + impresionFacturaVo.getEmpresa().getAutorizacionDesde() + " a " + impresionFacturaVo.getEmpresa().getAutorizacionHasta(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "Factura: " + impresionFacturaVo.getEmpresa().gettFactura(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "  *****GRACIAS POR SU COMPRA*****      ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
		documento.add(new Paragraph(new Phrase(lineSpacing, "El servicio voluntario no es obligatorio",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
		documento.add(new Paragraph(new Phrase(lineSpacing, "puede ser modificado por el cliente.",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "   DESARROLLADO POR EFFCTIVE SOFTWARE  ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "LUIS MIGUEL GONZALEZ  Cel 3185222474   ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "DIANA MARIA GONZALEZ  Cel 3178736068  ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.close();
		//if(enPantalla.equals("false")){
			log.info("imprime en papel");
			printer("sin_definicion", carpeta+pdf, impresionFacturaVo.getConfiguracion());
		//}		
		return pdf;
	}
	
	private  void printer(String impresora, String rutaArchivo, Configuracion configuracion) {
		PrinterJob job = PrinterJob.getPrinterJob();
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
		log.info("Number of printers configured: " + printServices.length);
		for (PrintService printer : printServices) {
			log.info("Printer: " + printer.getName());
			log.info("comparison:"+impresora+":"+printer.getName());
			if (printer.getName().equals(impresora)) {
				try {
					job.setPrintService(printer);
					log.info( "printer found: "+impresora+" : " + printer.getName());
					break;
				} catch (PrinterException ex) {
					ex.printStackTrace();
				}
			}
		}
		PDDocument document = null;
		try {
			document = PDDocument.load(new File(rutaArchivo));
			job.setPageable(new PDFPageable(document));		
			job.print();		
			document.close();
		} catch (IOException|PrinterException e) {
			log.error("error en impresión");
		}
		if (configuracion.getGuardarFacturas() == 0l) {
			File borrar = new File(rutaArchivo);
			if (!borrar.delete()) {
				log.error("Error borrando facturas");
			} else {
				log.info("Documento borrado");
			}
		}

	}
	
}
