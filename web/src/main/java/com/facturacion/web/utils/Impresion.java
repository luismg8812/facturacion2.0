package com.facturacion.web.utils;



import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.jboss.logging.Logger;

import com.facturacion.web.model.Configuracion;
import com.facturacion.web.model.Documento;
import com.facturacion.web.model.Empresa;
import com.facturacion.web.model.OpcionUsuario;
import com.facturacion.web.model.Producto;
import com.facturacion.web.model.Usuario;
import com.facturacion.web.vo.DocumentoDetalleVo;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/** 
 * Clase que contiene los metodos de impresion de las facturas
 * 
 * @author luismg
 *
 */
public class Impresion {
	
	private static Logger log = Logger.getLogger(Impresion.class);
	private final static String  LINEA = "-------------------------------------------------";

	/**
	 * Metodo que imprime la factura en formato a5 o media carta
	 * 
	 * @param documentoImp
	 * @param productos
	 * @param usuario
	 * @param config
	 * @param descuentoEnFactura
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 * @throws PrinterException
	 * @throws PrintException
	 */
	public static String imprimirBig(Documento documentoImp, List<DocumentoDetalleVo> productos, Usuario usuario,
			Configuracion config, OpcionUsuario descuentoEnFactura, Empresa e)
			throws DocumentException, IOException, PrinterException, PrintException {
		String pdf = "C:\\effectiveSotware\\facturacion\\facturas\\factura_" + documentoImp.getDocumentoId() + ".pdf";
		float fntSize, lineSpacing;
		fntSize = 9f;
		lineSpacing = 10f;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fhoyIni = df.format(documentoImp.getFechaRegistro());
		String[] fechaHora = fhoyIni.split(" ");
		DecimalFormat formatea = new DecimalFormat("###,###.##");
		Double tope = 15.0;// esta variable controla el nuero de productos por
							// pagina en la factura
		Double numPaginas = (double) productos.size();
		numPaginas = Math.ceil(numPaginas / tope);
		String numeroPaginas = Calculos.cortarCantidades(numPaginas, 7);
		int paginaActual = 1;
		int inicio = 0;
		Float yDetalle = 267f;
		Float yDetalle2 = 283f;
		int fin = productos.size();
		PdfReader pdfReader = new PdfReader("C:/effectiveSoftware/facturacion/factura_big.pdf");
		PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(pdf));
		PdfContentByte canvas = pdfStamper.getOverContent(1);
		log.info("productos: " + fin);
		String fuente = "arial";
		float resta = 0;// se utiliza esta variable si si se necesita bajar o
						// subir todo el texto
		// si hay mas de dos paginas se crean las paginas faltantes
		if (numPaginas >= 2) {
			int pagina = 3;
			for (int i = 1; i < numPaginas; i++) {
				pdfStamper.insertPage(pagina, pdfReader.getPageSize(1));
				System.out.println("se crea la pagina.:" + pagina);
				pdfStamper.replacePage(pdfReader, 1, pagina);
				pdfStamper.insertPage(pagina + 1, pdfReader.getPageSize(1));
				System.out.println("se crea la pagina:" + (pagina + 1));
				pdfStamper.replacePage(pdfReader, 2, pagina + 1);
				pagina++;
			}
		}
		String TituloFactura = "";
		String TituloFactura1 = "";
		switch ("" + documentoImp.getTipoDocumentoId()) {
		case "10":
			TituloFactura = "FACTURA";
			TituloFactura1 ="DE VENTA";
			break;
		case "9":
			TituloFactura = "GUÍA DE ";
			TituloFactura1 ="REMISIÓN";
			break;
		case "4":
			TituloFactura = "COTIZACIÓN";
			TituloFactura1="";
			break;
		default:
			break;
		}
		String execto = "";
		String gravado = "";
		String iva = "";
		String total = "";
		// si valida si se desea que el descuento se refleje en la factura
		if (descuentoEnFactura != null) {
			execto = Calculos.cortarCantidades(formatea.format(documentoImp.getExcento()), 13);
			gravado = Calculos.cortarCantidades(formatea.format(documentoImp.getGravado()), 21);
			iva = Calculos.cortarCantidades(formatea.format(documentoImp.getIva()), 13);			
			//total = Calculos.cortarCantidades(formatea.format(documentoImp.getTotal() + descuento), 16);
			total = Calculos.cortarCantidades(formatea.format(documentoImp.getTotal()), 16);
		} else {
			execto = Calculos.cortarCantidades(formatea.format(documentoImp.getExcento()), 13);
			gravado = Calculos.cortarCantidades(formatea.format(documentoImp.getGravado()), 21);
			iva = Calculos.cortarCantidades(formatea.format(documentoImp.getIva()), 13);
			total = Calculos.cortarCantidades(formatea.format(documentoImp.getTotal()), 16);
		}
		String peso = Calculos.cortarCantidades(formatea.format(documentoImp.getPesoTotal()), 16);
		String resolucion = Calculos.cortarCantidades(e.getResolucionDian(), 23);
		String fechaResolucion = Calculos.cortarDescripcion(e.getFechaResolucion(), 10);
		String desde = Calculos.cortarCantidades(e.getAutorizacionDesde(), 12);
		String hasta = Calculos.cortarCantidades(e.getAutorizacionHasta(), 10);

		for (int i = 1; i < numPaginas * 2; i += 2) {
			// encabezado factura principal
			canvas = pdfStamper.getOverContent(i);
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, TituloFactura, FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)), 430f, 360, 0);// tituo
																												// factura
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, TituloFactura1, FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)), 430f, 350, 0);// tituo
																												// factura1
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(lineSpacing,e.getLetraConsecutivo()+
					documentoImp.getConsecutivoDian(), FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize + 2)),
					500f, 355, 0);// # DOCUMENTO
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, "" + documentoImp.getDocumentoId(), FontFactory.getFont(fuente, fntSize)),
					50f, 334 - resta, 0);// guia
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(lineSpacing,
					"aqui va nombre cliente"+" "+"direccion cliente", FontFactory.getFont(fuente, fntSize)), 160f, 334 - resta,
					0);// cliente
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, "" + fechaHora[0], FontFactory.getFont(fuente, fntSize)), 385f, 334 - resta,
					0);// fecha
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, "" + fechaHora[1], FontFactory.getFont(fuente, fntSize)), 500f, 330 - resta,
					0);// hora
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(lineSpacing,
					"" + usuario.getUsuarioId() + " " + usuario.getNombre()
							+ " " + usuario.getApellido(),
					FontFactory.getFont(fuente, fntSize)), 60f, 317 - resta, 0);// cajero
			String telCliente = "" + "telefono del cliente";
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, telCliente, FontFactory.getFont(fuente, fntSize)), 259f, 315 - resta, 0);
			ColumnText
					.showTextAligned(
							canvas, Element.ALIGN_LEFT, new Phrase(lineSpacing,
									"documento del cliente", FontFactory.getFont(fuente, fntSize)),
							45f, 303 - resta, 0);// nit
			// fin encabezado factura principal

			// pie de pagina factura principal
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, execto, FontFactory.getFont(fuente, fntSize)), 70f, 76, 0);// execto
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, gravado, FontFactory.getFont(fuente, fntSize)), 170f, 76, 0);// gravado
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, iva, FontFactory.getFont(fuente, fntSize)), 289f, 76, 0);// iva
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, peso, FontFactory.getFont(fuente, fntSize)), 410f, 76, 0);// peso
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, total, FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize + 2)), 463f,
					58, 0);// total
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, resolucion, FontFactory.getFont(fuente, fntSize - 1)), 55f, 41, 0);// resolucion
																												// dian
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, fechaResolucion, FontFactory.getFont(fuente, fntSize - 1)), 160f, 41, 0);// fecha
																														// resolcion
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, desde, FontFactory.getFont(fuente, fntSize - 1)), 215f, 41, 0);// desde
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, hasta, FontFactory.getFont(fuente, fntSize - 1)), 265f, 41, 0);// hasta
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, Calculos.cortarCantidades("" + i, 1), FontFactory.getFont(fuente, fntSize)),
					313f, 26, 0);// pagina actual
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, numeroPaginas, FontFactory.getFont(fuente, fntSize)), 320f, 26, 0);// numero
																												// de
																												// paginas
			// fin pie de pagina factura principal

			// inico encabezado control de entrega
			canvas = pdfStamper.getOverContent(i + 1);
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, "" + documentoImp.getDocumentoId(), FontFactory.getFont(fuente, fntSize)),
					50f, 360, 0);
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(lineSpacing,
					"nombre cliente", FontFactory.getFont(fuente, fntSize)), 175f, 360, 0);
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, "" + fechaHora[0], FontFactory.getFont(fuente, fntSize)), 380f, 360, 0);
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, "" + fechaHora[1], FontFactory.getFont(fuente, fntSize)), 510f, 360, 0);
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(lineSpacing,
					"" + usuario.getUsuarioId() + " " + usuario.getNombre()
							+ " " + usuario.getApellido(),
					FontFactory.getFont(fuente, fntSize)), 60f, 346, 0);
			telCliente = "" + "cliente";
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, telCliente, FontFactory.getFont(fuente, fntSize)), 259f, 346, 0);
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(lineSpacing,
					"", FontFactory.getFont(fuente, fntSize)), 40f, 331, 0);
			// fin encabezado control de entrega

			// inicio pie control de entrega
			// Image imar=
			// Calculos.generarCodBaras(documentoImp.getDocumentoId());
			ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
					new Phrase(lineSpacing, "" + i + "  " + numeroPaginas, FontFactory.getFont(fuente, fntSize)), 391f,
					45, 0);
			// fin pie control de entrega
		}

		try {
			int pagina = 1;
			for (int j = inicio; j < fin; j++) {
				canvas = pdfStamper.getOverContent(paginaActual);
				String varios = " ";
				//hay que agregar el varios a productos vo
				//if(productos.get(j).getProductoId().getVarios()!=null){
					//varios=	productos.get(j).getProductoId().getVarios() == 1l ? "V" : "   ";
					varios=	"   ";
				//}
				String cantidadProducto = Calculos.cortarCantidades(productos.get(j).getCantidad(), 11);
				String nombreProducto = Calculos.cortarDescripcion(productos.get(j).getNombreProducto(), 34);
				String iva1 = Calculos.cortarCantidades(formatea.format(productos.get(j).getIva()), 6);
				String unidadProducto = "";
				String totalProducto = "";
				// si valida si se desea que el descuento se refleje en la
				// factura
				//if (descuentoEnFactura == null) {
				//	unidadProducto = Calculos
				//			.cortarCantidades(formatea.format(productos.get(j).getCostoPublico()), 13);
				//	totalProducto = Calculos.cortarCantidades(formatea.format(
				//			productos.get(j).getProductoId().getCostoPublico() * productos.get(j).getCantidad()), 11);
				//} else {
					unidadProducto = Calculos.cortarCantidades(formatea.format(productos.get(j).getUnitario()), 13);
					totalProducto = Calculos.cortarCantidades(
							formatea.format(productos.get(j).getUnitario() * productos.get(j).getCantidad()), 11);
				//}
				// productos factura
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
						new Phrase(lineSpacing, " (" + varios + ") ", FontFactory.getFont(fuente, fntSize + 2)), 21f,
						yDetalle, 0);// varios
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
						new Phrase(lineSpacing, cantidadProducto, FontFactory.getFont(fuente, fntSize + 2)), 30f,
						yDetalle, 0);// cantidad
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
						new Phrase(lineSpacing, nombreProducto, FontFactory.getFont(fuente, fntSize + 2)), 80f,
						yDetalle, 0);// nombre producto
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
						new Phrase(lineSpacing, unidadProducto, FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize + 2)), 375f,
						yDetalle, 0);// precio unitario
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
						new Phrase(lineSpacing, totalProducto, FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize + 2)), 456f,
						yDetalle, 0);// parcial
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
						new Phrase(lineSpacing, iva1 + "%", FontFactory.getFont(fuente, fntSize + 1)), 538f, yDetalle,
						0); // iva
				// productos entrega mercancia
				canvas = pdfStamper.getOverContent(paginaActual + 1);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
						new Phrase(lineSpacing, " (" + varios + ") ", FontFactory.getFont(fuente, fntSize + 2)), 25f,
						yDetalle2, 0);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
						new Phrase(lineSpacing, cantidadProducto, FontFactory.getFont(fuente, fntSize + 2)), 50f,
						yDetalle2, 0);
				ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
						new Phrase(lineSpacing, nombreProducto, FontFactory.getFont(fuente, fntSize + 2)), 130f,
						yDetalle2, 0);
				yDetalle -= 12;
				yDetalle2 -= 12;
				if (j >= tope * pagina) {
					yDetalle = 267f;
					yDetalle2 = 283f;
					paginaActual += 2;
					pagina++;
					// break;
				}
			}
			// Image imar=
			// Calculos.generarCodBaras(documentoImp.getDocumentoId());
			pdfStamper.close();
			pdfReader.close();
			printer(e.getImpresion(), pdf, config);
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		return "";
	}
	
	public static String imprimirEntadaAlmacenPDF(Documento documentoImp, List<DocumentoDetalleVo> productos, Usuario usuario,
			Configuracion config,Empresa e) throws MalformedURLException, IOException, DocumentException{
		log.info("imprimir entrada almacen");
		String pdf = "C:\\effectiveSoftware\\facturacion\\facturas\\entradas\\entrada_" + documentoImp.getDocumentoId() + ".pdf";
		FileOutputStream archivo = new FileOutputStream(pdf);
		DecimalFormat formatea = new DecimalFormat("###,###.##");
		Document documento = new Document();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Image imagen=null;
		try {
		    imagen = Image.getInstance("C://facturacion/logoEmpresa.jpg");
			imagen.scaleAbsoluteWidth(200f);
			imagen.scaleAbsoluteHeight(80f);
		} catch (Exception e2) {
			log.info("impresion: sin imagen");
		}
		float fntSize, lineSpacing;
		fntSize = 9f;
		lineSpacing = 10f;
		PdfWriter.getInstance(documento, archivo);
		documento.setMargins(10, 1, 1, 1);
		documento.open();
		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
		if(imagen!=null){
			documento.add(imagen); // LEGAL
		}
		documento.add(new Paragraph(
				new Phrase(lineSpacing, "" + e.getNombre(), FontFactory.getFont(FontFactory.COURIER_BOLD, 13f)))); // NOMBRE
																													// EMPRESA
		documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getSlogan().toUpperCase() == null ? "" : e.getSlogan(),
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
		documento.add(new Paragraph(new Phrase(lineSpacing, "Entrada de almacen: " + documentoImp.getDocumentoId(),
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
						"PROVEEDOR: " + (documentoImp.getProveedorId() == null ? "VARIOS"
								: "nombre del proveedor"),
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
		documento.add(new Paragraph(new Phrase(lineSpacing,
				"CC/NIT: " + "documento del proveedor" == null ? ""
						: "documento del proveedor",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
		// lineSpacing, "Descripci�n CANT UNIDAD TOTAL" LEGAL
		String impuesto = e.getImpuesto().equals("IVA") ? "IVA" : "IPO";
		documento.add(new Paragraph(new Phrase(lineSpacing, "CANT Descripci�n      UNI  TOTAL  " + impuesto,
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
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
		documento
		.add(new Paragraph(new Phrase(lineSpacing,
				"Retefuente:         "
						+ Calculos.cortarCantidades(formatea.format(documentoImp.getRetefuente()), 13),
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); //retefuente
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
		
		documento.add(new Paragraph(new Phrase(lineSpacing, "  *****GRACIAS POR SU COMPRA*****      ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
		documento.add(new Paragraph(new Phrase(lineSpacing, "         Software  NICESOTF            ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "LUIS MIGUEL GONZALEZ  Cel 3185222474   ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.add(new Paragraph(new Phrase(lineSpacing, "DIANA MARÍA GONZALEZ  Cel 3178736068  ",
				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																			// LEGAL
		documento.close();

		printer(e.getImpresion(), pdf, config);

		return pdf;
	}

	/**
	 * Metodo encargado de imprimir la factura en formato txt
	 * 
	 * @param documentoImp
	 * @param productos
	 * @param usuario
	 * @return retorna la ruta donde se almacena en disco
	 * @throws DocumentException
	 * @throws IOException
	 * @throws PrinterException
	 * @throws PrintException
	 */
	public static String imprimirPDF(Documento documentoImp, List<DocumentoDetalleVo> productos, Usuario usuario,
			Configuracion config,String impresora,Empresa e, String enPantalla) throws DocumentException, IOException, PrinterException, PrintException {
		log.info("todo el codigo de imprimir");
		String carpeta = "C:\\effectiveSoftware\\facturacion\\facturas";
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
	
	/**
	 * Metodo encargado de imprimir la factura en formato txt
	 * 
	 * @param documentoImp
	 * @param productos
	 * @param usuario
	 * @return retorna la ruta donde se almacena en disco
	 * @throws DocumentException
	 * @throws IOException
	 * @throws PrinterException
	 * @throws PrintException
	 */
	public static String imprimirPDFSmall(Documento documentoImp, List<DocumentoDetalleVo> productos, Usuario usuario,
			Configuracion config, String impresora) throws DocumentException, IOException, PrinterException, PrintException {
//		System.out.println("todo el codigo de imprimir");
//		Empresa e = Login.getEmpresaLogin();
//		String pdf = "C:\\facturas\\factura_" + documentoImp.getDocumentoId() + ".pdf";
//		FileOutputStream archivo = new FileOutputStream(pdf);
//		DecimalFormat formatea = new DecimalFormat("###,###.##");
//		Document documento = new Document();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Image imagen = Image.getInstance("C://facturacion/logoEmpresa.jpg");
//		imagen.scaleAbsoluteWidth(120f);
//		imagen.scaleAbsoluteHeight(50f);
//		float fntSize, lineSpacing;
//		fntSize = 6f;
//		lineSpacing = 10f;
//		PdfWriter.getInstance(documento, archivo);
//		documento.setMargins(1, 1, 1, 1);
//		documento.open();
//		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
//		documento.add(imagen); // LEGAL
//		documento.add(new Paragraph(
//				new Phrase(lineSpacing, "" + e.getNombre(), FontFactory.getFont(FontFactory.COURIER_BOLD, 10f)))); // NOMBRE
//																													// EMPRESA
//		documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getSlogan() == null ? "" : e.getSlogan(),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // slogan
//		documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getRepresentante(),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, "NIT. " + e.getNit() + " " + e.getRegimen(),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // NIT
//		documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getDireccion() + " - " + e.getBarrio(),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // DIRECCION
//																			// Y
//																			// BARRIO
//		documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getCiudad() + "- " + e.getDepartamento(),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // ciudad
//		documento.add(new Paragraph(new Phrase(lineSpacing, "TEL: " + e.getTelefonoFijo() + " - " + e.getCel(),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // tel
//		documento.add(new Paragraph(new Phrase(lineSpacing, "FACTURA DE VENTA: " + documentoImp.getConsecutivoDian(),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, 9f)))); // numer
//																		// de
//																		// factura
//		String fhoyIni = df.format(documentoImp.getFechaRegistro());
//		documento.add(new Paragraph(
//				new Phrase(lineSpacing, "Fecha: " + fhoyIni, FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // fecha
//		documento.add(new Paragraph(new Phrase(lineSpacing,
//				"CAJERO: " + documentoImp.getUsuarioId().getUsuarioId() + " " + documentoImp.getUsuarioId().getNombre()
//						+ " " + documentoImp.getUsuarioId().getApellido(),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, "CAJA: " + Calculos.conseguirMAC(),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // fecha
//		documento
//				.add(new Paragraph(new Phrase(lineSpacing,
//						"CLIENTE: " + (documentoImp.getClienteId() == null ? "VARIOS"
//								: documentoImp.getClienteId().getNombre()),
//						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//		documento.add(new Paragraph(new Phrase(lineSpacing,
//				"CC/NIT: " + documentoImp.getClienteId().getDocumento() == null ? ""
//						: documentoImp.getClienteId().getDocumento(),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//		// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
//		// lineSpacing, "Descripci�n CANT UNIDAD TOTAL" LEGAL
//		String impuesto = e.getImpuesto().equals("IVA") ? "IVA" : "IPO";
//		documento.add(new Paragraph(new Phrase(lineSpacing, "CANT Descripci�n      UNI  TOTAL  " + impuesto,
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
//		// LEGAL
//		for (DocumentoDetalleVo ddV : productos) {
//			// descripcion
//			String nombre = "";
//			int maxTama�oNombre = config.getNombreProductoLargo() == 1l ? 24 : 17;
//			nombre = Calculos.cortarDescripcion(ddV.getProductoId().getNombre(), maxTama�oNombre);
//
//			// Cantidad
//			String cant = "";
//			int maxTama�oCant = 3;
//			cant = Calculos.cortarCantidades(ddV.getCantidad(), maxTama�oCant);
//
//			// Unitario
//			String unit = "";
//			int maxTama�oUnit = 5;
//			unit = Calculos.cortarCantidades(ddV.getUnitario(), maxTama�oUnit);
//
//			// total
//			Double totalDouble = 0.0;
//			String total = "";
//			int maxTama�oTotal = 6;
//			try {
//				totalDouble = ddV.getUnitario() * ddV.getCantidad();
//			} catch (Exception e2) {
//				totalDouble = 0.0;
//			}
//			total = Calculos.cortarCantidades(totalDouble, maxTama�oTotal);
//
//			// iva
//			String iva = "";
//			iva = Calculos.cortarCantidades(ddV.getProductoId().getIva(), 2);
//			if (config.getNombreProductoLargo() == 1l) {
//				documento.add(new Paragraph(new Phrase(lineSpacing, cant + " " + nombre,
//						FontFactory.getFont(FontFactory.COURIER_BOLD, 12f)))); // CANTIDAD
//																				// NOMBRE
//				documento.add(
//						new Paragraph(new Phrase(lineSpacing, "                  " + unit + " " + total + "  " + iva,
//								FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//			} else {
//				documento.add(new Paragraph(
//						new Phrase(lineSpacing, cant + " " + nombre + " " + unit + " " + total + " " + iva,
//								FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // CANTIDAD
//																							// NOMBRE
//			}
//
//			// LEGAL
//		}
//		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
//		// LEGAL
//		documento
//				.add(new Paragraph(new Phrase(lineSpacing,
//						"Valor Exento:          "
//								+ Calculos.cortarCantidades(formatea.format(documentoImp.getExcento()), 13),
//						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																					// LEGAL
//		documento
//				.add(new Paragraph(new Phrase(lineSpacing,
//						"Valor Gravado:         "
//								+ Calculos.cortarCantidades(formatea.format(documentoImp.getGravado()), 13),
//						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																					// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing,
//				(e.getImpuesto().equals("IVA") ? "IVA" : "IPO") + ":                   "
//						+ Calculos.cortarCantidades(formatea.format(documentoImp.getIva()), 13),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
//		// LEGAL
//		documento
//				.add(new Paragraph(new Phrase(lineSpacing, "TOTAL A PAGAR: " + formatea.format(documentoImp.getTotal()),
//						FontFactory.getFont(FontFactory.COURIER_BOLD, 9f)))); // REPRESENTANTE
//																				// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
//		// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, "         **** FORMA DE PAGO****        ",
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		Double pago = documentoImp.getValorTarjeta() == null ? 0l : documentoImp.getValorTarjeta();
//		documento.add(
//				new Paragraph(new Phrase(lineSpacing, "Vr. Pago con Tarjeta:  " + Calculos.cortarCantidades(pago, 13),
//						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																					// LEGAL
//		documento.add(
//				new Paragraph(new Phrase(lineSpacing, "Vr. Pago con cheque:   " + Calculos.cortarCantidades(0.0, 13),
//						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																					// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing,
//				"Efectivo:			           " + Calculos.cortarCantidades(
//						(documentoImp.getEfectivo() == null ? "0" : "" + documentoImp.getEfectivo()), 13),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing,
//				"Cambio:	 		            " + Calculos
//						.cortarCantidades((documentoImp.getCambio() == null ? "0" : "" + documentoImp.getCambio()), 13),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
//		// LEGAL
//		documento.add(new Paragraph(
//				new Phrase(lineSpacing, "Res. " + e.getResolucionDian() + " Fecha: " + e.getFechaResolucion(),
//						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																					// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing,
//				"Rango autorizado desde: " + e.getAutorizacionDesde() + " a " + e.getAutorizacionHasta(),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, "Factura: " + e.gettFactura(),
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, "  *****GRACIAS POR SU COMPRA*****      ",
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, "         Software  NICESOTF            ",
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, "LUIS MIGUEL GONZALEZ  Cel 3185222474   ",
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		documento.add(new Paragraph(new Phrase(lineSpacing, "JOHAN ANDRES ORDO�EZ  Cel 3112864974  ",
//				FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
//																			// LEGAL
//		documento.close();
//		printer(impresora, pdf, config);
		//return pdf;
		return "";
	}

	public static void printer(String impresora, String rutaArchivo, Configuracion configuracion) {
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

	/**
	 * metodo encargado de realizar la impresion del inventario
	 * 
	 * @param productos
	 * @param usuario
	 * @return
	 */
	public static String imprimirInventarioPDF(List<Producto> productos, Usuario usuario, Configuracion con, Empresa  e) {
		System.out.println("todo el codigo de imprimir");
		String carpeta = "C:\\effectiveSoftware\\facturacion\\inventarios";
		SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		String fhoyIni = df2.format(new Date());
		String pdf = "\\inventario_" + fhoyIni + ".pdf";
		File folder = new File(carpeta);
		folder.mkdirs();
		FileOutputStream archivo = null;
		try {
			archivo = new FileOutputStream(carpeta + pdf);
		} catch (FileNotFoundException e1) {
			System.out.print("Error creando archivo de inventario pdf");
			e1.printStackTrace();
		}
		Document documento = new Document();
		float fntSize, lineSpacing;
		fntSize = 9f;
		lineSpacing = 10f;
		try {
			PdfWriter.getInstance(documento, archivo);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		documento.setMargins(1, 1, 1, 1);
		documento.open();
		try {
			documento.add(new Paragraph(new Phrase(lineSpacing, LINEA)));
			documento.add(new Paragraph(new Phrase(lineSpacing, ">>" + e.getNombre() + "<<",
					FontFactory.getFont(FontFactory.COURIER_BOLD, 13f)))); // NOMBRE
																			// EMPRESA
			documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getSlogan() == null ? "" : e.getSlogan(),
					FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // slogan
			documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getRepresentante(),
					FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																				// LEGAL
			documento.add(new Paragraph(new Phrase(lineSpacing, "NIT. " + e.getNit() + " " + e.getRegimen(),
					FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // NIT
			documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getDireccion(),
					FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // DIRECCION
			documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getBarrio(),
					FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // barrio
			documento.add(new Paragraph(new Phrase(lineSpacing, "" + e.getCiudad() + "- " + e.getDepartamento(),
					FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // ciudad
			documento.add(new Paragraph(new Phrase(lineSpacing, "TEL: " + e.getTelefonoFijo() + " - " + e.getCel(),
					FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // tel
			documento.add(new Paragraph(new Phrase(lineSpacing, "			    INVENTARIO",
					FontFactory.getFont(FontFactory.COURIER_BOLD, 13f)))); // NOMBRE
			documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE
			// lineSpacing, "Descripci�n CANT UNIDAD TOTAL" LEGAL
			documento.add(new Paragraph(new Phrase(lineSpacing, "Descripci�n                       CANT ",
					FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
			documento.add(new Paragraph(new Phrase(lineSpacing, LINEA))); // REPRESENTANTE

			for (Producto p : productos) {
				// descripcion
				String nombre = "";
				int maxTamanoNombre = 31;
				nombre = Calculos.cortarDescripcion(p.getNombre(), maxTamanoNombre);
				// cantidad
				String cant = "";
				int maxTamanoCant = 4;
				cant = Calculos.cortarCantidades(p.getCantidad(), maxTamanoCant);
				documento.add(new Paragraph(new Phrase(lineSpacing, nombre + " " + cant,
						FontFactory.getFont(FontFactory.COURIER_BOLD, fntSize)))); // REPRESENTANTE
																					// LEGAL
			}
			documento.close();
			printer(e.getImpresion(), carpeta + pdf, con);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		return "";
	}
	
	public static String imprimirTxt(Documento documentoImp, List<DocumentoDetalleVo> productos, Usuario usuario,
			Configuracion config,String impresora,Empresa e) throws IOException {
		System.out.println("entra a imprimir");
		String pdf = "C:\\effectivesSoftware\\facturacion\\facturas\\factura_" + documentoImp.getDocumentoId() + ".txt";
		File archivo = new File(pdf);
		BufferedWriter bw;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DecimalFormat formatea = new DecimalFormat("###,###.##");
		bw = new BufferedWriter(new FileWriter(archivo));
		bw.write("----------------------------------------\n");
		bw.write(">>" + e.getNombre() + "<<\n");
		bw.write("" + e.getRepresentante() + "\n");
		bw.write("NIT. " + e.getNit() + "   " + e.getRegimen() + "\n");
		bw.write("" + e.getDireccion() + "\n");
		bw.write("" + e.getBarrio() + "            \n");
		bw.write("" + e.getCiudad() + "-" + e.getDepartamento() + "\n");
		bw.write("TEL: " + e.getTelefonoFijo() + "\n");
		bw.write("FACTURA DE VENTA: " + documentoImp.getConsecutivoDian());
		bw.write("\n" +df.format(documentoImp.getFechaRegistro())) ;
		bw.write("\nCAJERO: " + usuario.getUsuarioId() + " "
				+ usuario.getNombre() + " " + usuario.getApellido()
				+ "\nCLIENTE: ");
		bw.write("\nCLIENTE: " + documentoImp.getClienteId() == null ? "VARIOS"
				: usuario.getNombre());
		bw.write("\nNIT/CC:" + "documento cliente");
		if(documentoImp.getEmpleadoId()!=null){
			bw.write("\nMESERO: " + "empleado nobre");
		}
		bw.write("\n----------------------------------------\n");
		bw.write("DESCRIPCIÓN       CANT   UNIDAD    TOTAL\n");
		bw.write("----------------------------------------");
		for (DocumentoDetalleVo ddV : productos) {			
			String nombreProducto = Calculos.cortarDescripcion(ddV.getNombreProducto(), 17);
			String cantidadProducto = Calculos.cortarCantidades(formatea.format(ddV.getCantidad()), 4);
			String unidadProducto = Calculos.cortarCantidades(formatea.format(ddV.getUnitario()), 8);
			String totalProducto = Calculos.cortarCantidades(formatea.format(ddV.getParcial()), 8);
			bw.write("\n" + nombreProducto + " " + cantidadProducto + " " + unidadProducto + " " + totalProducto);
		}
		bw.write("\n----------------------------------------");
		bw.write("\nValor Exento:                " + Calculos.cortarCantidades(formatea.format(documentoImp.getExcento()), 11));
		bw.write("\nValor Gravado:               " + Calculos.cortarCantidades(formatea.format(documentoImp.getGravado()), 11));
		bw.write("\nIva:                         " + Calculos.cortarCantidades(formatea.format(documentoImp.getIva()), 11));
		bw.write("\n----------------------------------------\n");
		bw.write("\nTOTAL A PAGAR:               " +  Calculos.cortarCantidades(formatea.format(documentoImp.getTotal()), 11));
		bw.write("\n----------------------------------------\n");
		bw.write("         **** FORMA DE PAGO****        ");
		Double pago = documentoImp.getValorTarjeta() == null ? 0l : documentoImp.getValorTarjeta();
		bw.write("\nVr. Pago con Tarjeta:        " + Calculos.cortarCantidades(formatea.format(pago), 11));
		bw.write("\nVr. Comisi�n Tarjeta:        " + Calculos.cortarCantidades(formatea.format(0l), 11));
		bw.write("\nVr. Total Factura:           " + Calculos.cortarCantidades(formatea.format(documentoImp.getTotal()), 11));
		bw.write("\nEfectivo:		 	  " + Calculos.cortarCantidades(formatea.format(documentoImp.getEfectivo()), 11));
		bw.write("\nCambio:			      " + Calculos.cortarCantidades(formatea.format(documentoImp.getCambio()), 11));
		bw.write("\n");
		bw.write("\nEl servicio voluntario no es obligatorio");
		bw.write("\ny puede ser modificado por el cliente.");
		
		bw.write("\n  *****GRACIAS POR SU COMPRA*****   \n");
		bw.write("          Software NICESOFT      \n");
		bw.write(" LUIS MIGUEL GONZALEZ CEL: 3184222474  \n");
		bw.write(" JOHAN ANDRES ORDO�ES CEL: 3112864974  ");
		bw.write("\n");
		bw.write("\n");
		bw.write("\n");
		bw.write(" \n");
		bw.write(" \n");
		bw.write(" \n");
		bw.write(" \n");
		bw.write(" \n");
		bw.close();

		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(pdf);
			System.out.println(pdf);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		if (inputStream == null) {
			// return;
		}
		DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
		Doc document = new SimpleDoc(inputStream, docFormat, null);
		PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
		
		PrintService defaultPrintService=PrintServiceLookup.lookupDefaultPrintService();
		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
		System.out.println("Number of printers configured1: " + printServices.length);
		for (PrintService printer : printServices) {
			System.out.println("Printer: " + printer.getName());
			System.out.println("comparacion:"+impresora+":"+printer.getName());
			if (printer.getName().toString().equals(impresora)) {
				defaultPrintService=printer;
				System.out.println( impresora+" : " + printer.getName());
				break;
			}
		}
		
		
		
		
		//defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
		if (defaultPrintService != null) {
			DocPrintJob printJob = defaultPrintService.createPrintJob();
			
			try {
				printJob.print(document, attributeSet);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			System.err.println("No existen impresoras instaladas");
		}
		return pdf;
	}

}
