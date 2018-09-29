package com.facturacion.web.utils;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.jboss.logging.Logger;

import com.facturacion.web.model.Configuracion;
import com.facturacion.web.model.Documento;
import com.facturacion.web.model.Empresa;
import com.facturacion.web.model.Usuario;
import com.facturacion.web.vo.DocumentoDetalleVo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class ImpresionFull {
	
	private static Logger log = Logger.getLogger(Impresion.class);
	private final  String  LINEA = "-------------------------------------------------";
	private final  String  RUTA_FACTURAS = "C:\\effectiveSoftware\\facturacion\\facturas";
	
	
	public String imprimirPDF(Documento documentoImp, List<DocumentoDetalleVo> productos, Usuario usuario,
			Configuracion config,String impresora,Empresa e, String enPantalla) throws DocumentException, FileNotFoundException {
		log.info("todo el codigo de imprimir");
		String carpeta = RUTA_FACTURAS;
		String pdf = "\\factura_" + documentoImp.getDocumentoId() + ".pdf";
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
			log.info("la empresa no tiene logo");
		}
		
		float fntSize, lineSpacing;
		fntSize = 9f;
		lineSpacing = 10f;
		PdfWriter.getInstance(documento, archivo);
		documento.setMargins(10, 1, 1, 1);
		String TituloFactura = "";
		switch ("" + documentoImp.getTipoDocumentoId()) {
		case "10":
			TituloFactura = "FACTURA DE VENTA";
			break;
		case "9":
			TituloFactura = "GUÍA DE REMISIÓN";
			break;
		case "4":
			TituloFactura = "COTIZACIÓN";
		
			break;
		default:
			break;
		}
		documento.open();
		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
		if(imagen!=null){
			documento.add(imagen); // LEGAL
		}
		documento.add(new Paragraph(
				new Phrase(lineSpacing, "" + e.getNombre(), FontFactory.getFont(FontFactory.COURIER_BOLD, 13f)))); // NOMBRE
																													// EMPRESA
		documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getSlogan() == null ? "" : e.getSlogan().toUpperCase(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // slogan
		documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getRepresentante(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "NIT. " + e.getNit() + " " + e.getRegimen(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // NIT
		documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getDireccion() + " - " + e.getBarrio(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // DIRECCION
																			// Y
																			// BARRIO
		documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getCiudad() + "- " + e.getDepartamento(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // ciudad
		documento.add(new Paragraph(new Phrase(lineSpacing, "TEL: " + e.getTelefonoFijo() + " - " + e.getCel(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // tel
		documento.add(new Paragraph(new Phrase(lineSpacing, TituloFactura+": " + documentoImp.getConsecutivoDian(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, 11f)))); // numer
																		// de
																		// factura
		String fhoyIni = df.format(documentoImp.getFechaRegistro());
		documento.add(new Paragraph(
				new Phrase(lineSpacing, "FECHA: " + fhoyIni, FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // fecha
		documento.add(new Paragraph(new Phrase(lineSpacing,
				"CAJERO: " + usuario.getUsuarioId() + " " + usuario.getNombre()
						+ " " + usuario.getApellido(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "CAJA: " + Calculos.conseguirMAC(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // fecha
		documento
				.add(new Paragraph(new Phrase(lineSpacing,
						"CLIENTE: " + (documentoImp.getClienteId() == null ? "VARIOS"
								: "aqui va el nombe del cliente"),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
		documento.add(new Paragraph(new Phrase(lineSpacing,
				"CC/NIT: " + "aqui va el documento del cliente" == null ? ""
						: "aqui va el documento del cliente",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
		if(documentoImp.getEmpleadoId()!=null){
			documento.add(new Paragraph(
					new Phrase(lineSpacing, "MESERO: " + "nombre del mesero", FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // fecha
		}
		// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
		// lineSpacing, "Descripci�n CANT UNIDAD TOTAL" LEGAL
		String impuesto = e.getImpuesto().equals("IVA") ? "IVA" : "IPO";
		documento.add(new Paragraph(new Phrase(lineSpacing, "CANT Descripción      UNI  TOTAL  " + impuesto,
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
		// LEGAL
		for (DocumentoDetalleVo ddV : productos) {
			// descripcion
			String nombre = "";
			int maxTamanoNombre = config.getNombreProductoLargo() == 1l ? 24 : 17;
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
			if (config.getNombreProductoLargo() == 1l) {
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
		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
		// LEGAL
		documento
				.add(new Paragraph(new Phrase(lineSpacing,
						"Valor Exento:          "
								+ Calculos.cortarCantidades(formatea.format(documentoImp.getExcento()), 13),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																					// LEGAL
		documento
				.add(new Paragraph(new Phrase(lineSpacing,
						"Valor Gravado:         "
								+ Calculos.cortarCantidades(formatea.format(documentoImp.getGravado()), 13),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																					// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing,
				(e.getImpuesto().equals("IVA") ? "IVA" : "IPO") + ":                   "
						+ Calculos.cortarCantidades(formatea.format(documentoImp.getIva()), 13),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
		// LEGAL
		documento
				.add(new Paragraph(new Phrase(lineSpacing, "TOTAL A PAGAR: " + formatea.format(documentoImp.getTotal()),
						FontFactory.getFont(FontFactory.COURIER_BOLD, 14f)))); // REPRESENTANTE
																				// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
		// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "         **** FORMA DE PAGO****        ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		Double pago = documentoImp.getValorTarjeta() == null ? 0l : documentoImp.getValorTarjeta();
		documento.add(
				new Paragraph(new Phrase(lineSpacing, "Vr. Pago con Tarjeta:  " + Calculos.cortarCantidades(pago, 13),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																					// LEGAL
		documento.add(
				new Paragraph(new Phrase(lineSpacing, "Vr. Pago con cheque:   " + Calculos.cortarCantidades(0.0, 13),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																					// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing,
				"Efectivo:			             " + Calculos.cortarCantidades(
						(documentoImp.getEfectivo() == null ? "0" : "" + documentoImp.getEfectivo()), 13),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing,
				"Cambio:	 		              " + Calculos
						.cortarCantidades((documentoImp.getCambio() == null ? "0" : "" + documentoImp.getCambio()), 13),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
		// LEGAL
		documento.add(new Paragraph(
				new Phrase(lineSpacing, "Res. " + e.getResolucionDian() + " Fecha: " + e.getFechaResolucion(),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																					// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing,
				"Rango autorizado desde: " + e.getAutorizacionDesde() + " a " + e.getAutorizacionHasta(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "Factura: " + e.gettFactura(),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "  *****GRACIAS POR SU COMPRA*****      ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
		documento.add(new Paragraph(new Phrase(lineSpacing, "El servicio voluntario no es obligatorio",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
		documento.add(new Paragraph(new Phrase(lineSpacing, "puede ser modificado por el cliente.",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "         Software  NICESOTF            ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "LUIS MIGUEL GONZALEZ  Cel 3185222474   ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "DIANA MARIA GONZALEZ  Cel 3178736068  ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.close();
		if(enPantalla.equals("false")){
			log.info("imprime en papel");
			printer(e.getImpresion(), carpeta+pdf, config);
		}		
		return pdf;
	}
	
	public  void printer(String impresora, String rutaArchivo, Configuracion configuracion) {
		PrinterJob job = PrinterJob.getPrinterJob();
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
		log.info("Number of printers configured1: " + printServices.length);
		for (PrintService printer : printServices) {
			log.info("Printer: " + printer.getName());
			log.info("comparacion:"+impresora+":"+printer.getName());
			if (printer.getName().equals(impresora)) {
				try {
					job.setPrintService(printer);
					log.info( impresora+" : " + printer.getName());
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
			try {
				job.print();
			} catch (PrinterException e) {
				e.printStackTrace();
			}
			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (configuracion.getGuardarFacturas() == 0l) {
			File borrar = new File(rutaArchivo);
			if (!borrar.delete()) {
				System.out.println("Error borrando facturas");
			} else {
				System.out.println("Documento borrado");
			}
		}

	}
	
}
