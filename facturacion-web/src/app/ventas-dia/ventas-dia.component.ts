import { DocumentoDetalleService } from './documento-detalle.service';
import { DocumentoDetalleVoModel } from './../modelVo/documentoDetalleVo.model';
import { DocumentosService } from './documentos.service';
import { ProductosService } from './productos.service';
import { element } from 'protractor';
import { DocumentoModel } from './../model/documento.model';
import { ClienteModel } from './../model/cliente.model';
import { ActivacionModel } from './../model/activacion';
import { Component, OnInit, Renderer2, ElementRef, ViewChild } from '@angular/core';
import { UsuariosService } from '../usuarios/usuarios.service';
import { ClientesService } from '../clientes/clientes.service';
import { ProductoModel } from '../model/producto.model';
import { DocumentoDetalleModel } from '../model/documentoDetalle.model';
import { Alert } from 'selenium-webdriver';

@Component({
  selector: 'app-ventas-dia',
  templateUrl: './ventas-dia.component.html',
  styleUrls: ['./ventas-dia.component.css']
})
export class VentasDiaComponent implements OnInit {

  @ViewChild("clientePV") clientePV: ElementRef;
  @ViewChild("tipoDocumentoPV") tipoDocumentoPV: ElementRef;
  @ViewChild("empleadoPV") empleadoPV: ElementRef;
  @ViewChild("CodigoBarrasPV") CodigoBarrasPV: ElementRef;
  @ViewChild("articuloPV") articuloPV: ElementRef;
  @ViewChild("codigoPV") codigoPV: ElementRef;
  @ViewChild("cantidadPV") cantidadPV: ElementRef;
  @ViewChild("precioPV") precioPV: ElementRef;

  //botones de acciones
  @ViewChild("siguientePV") siguientePV: ElementRef;
  @ViewChild("anteriorPV") anteriorPV: ElementRef;
  @ViewChild("primeraPV") primeraPV: ElementRef;
  @ViewChild("ultimaPV") ultimaPV: ElementRef;
  @ViewChild("buscarPV") buscarPV: ElementRef;
  @ViewChild("nuevaPV") nuevaPV: ElementRef;
  @ViewChild("imprimirPV") imprimirPV: ElementRef;
  @ViewChild("opcionPV") opcionPV: ElementRef;
  @ViewChild("finPV") finPV: ElementRef;

  //botonos de imprimir
  @ViewChild("descuentoPV") descuentoPV: ElementRef;
  @ViewChild("descuentoLavel") descuentoLavel: ElementRef;
  @ViewChild("carteraPV") carteraPV: ElementRef;
  @ViewChild("tarjetaPV") tarjetaPV: ElementRef;
  @ViewChild("vrTarjetaPV") vrTarjetaPV: ElementRef;
  @ViewChild("efectovoPV") efectovoPV: ElementRef;
  @ViewChild("continuaImpresionPV") continuaImpresionPV: ElementRef;
  @ViewChild("cancalarImpresionPV") cancalarImpresionPV: ElementRef;
  @ViewChild("impresionPV") impresionPV: ElementRef;





  @ViewChild("divCantidad") divCantidad: ElementRef; // div de donde se busca  la cantidad
  @ViewChild("divCodigo") divCodigo: ElementRef; // div de donde se busca el codigo del producto
  @ViewChild("divArticulo") divArticulo: ElementRef; // div de donde se busca el articulo
  @ViewChild("divUnitario") divUnitario: ElementRef; // div de donde se busca el articulo
  @ViewChild("divParcial") divParcial: ElementRef; // div de donde se busca el articulo

  //botores de acciones
  @ViewChild("divSiguiente") divSiguiente: ElementRef;
  @ViewChild("divAnterior") divAnterior: ElementRef;
  @ViewChild("divPrimera") divPrimera: ElementRef;
  @ViewChild("divUltima") divUltima: ElementRef;
  @ViewChild("divBuscar") divBuscar: ElementRef;
  @ViewChild("divNueva") divNueva: ElementRef;
  @ViewChild("divImprimir") divImprimir: ElementRef;
  @ViewChild("divOpciones") divOpciones: ElementRef;
  @ViewChild("divFin") divFin: ElementRef;
  @ViewChild("imprimirBtn") imprimirBtn: ElementRef;


  private activaciones: Array<ActivacionModel>;
  private clientes: Array<ClienteModel>;
  private productosAll: Array<ProductoModel>;
  private clienteSelect: string;
  private tipoDocumentSelect: string;
  private empleadoSelect: string;
  private productoSelect: string;
  private document: DocumentoModel;
  private productos: Array<DocumentoDetalleVoModel>;


  private clienteActivo: boolean = false;
  private guiaTransporteActivo: boolean = false;
  private clienteObligatorioActivo: boolean = false;
  private empreadoActivo: boolean = false;
  private codigoBarrasActivo: boolean = false;
  private descuentosActivo: boolean = false;


  constructor(private renderer: Renderer2, private usuarioService: UsuariosService, private documentosService: DocumentosService,
    private clienteService: ClientesService, private productosService: ProductosService, private documentoDetalleService: DocumentoDetalleService) { }

  ngOnInit() {

    this.estadoDivBotones("d-block");
    this.siguientePV.nativeElement.focus();
    this.estadoDivProducto("d-none") // se muestra el div de producto
    this.CodigoBarrasPV.nativeElement.classList.add("d-none");
    var userLogin = sessionStorage.getItem("usuarioId");
    this.getActivaciones(userLogin);
    this.getclientes();
    this.getProductosAll();
    this.clienteActivo = false;
    this.guiaTransporteActivo = false;
    this.clienteObligatorioActivo = false;
    this.empreadoActivo = false;
    this.codigoBarrasActivo = false;
    this.clienteSelect = "";
    this.tipoDocumentSelect = "";
    this.empleadoSelect = "";
    this.document = new DocumentoModel();
    this.productos = [];
  }


  controlTeclas(event, element) {
    if (event.keyCode == 39) { //cuando se presiona la tacla derecha 				
      if (element.id == 'siguientePV') {
        this.anteriorPV.nativeElement.focus();
        return;
      }
      if (element.id == 'anteriorPV') {
        this.primeraPV.nativeElement.focus();
        return;
      }
      if (element.id == 'primeraPV') {
        this.ultimaPV.nativeElement.focus();
        return;
      }
      if (element.id == 'ultimaPV') {
        this.buscarPV.nativeElement.focus();
        return;
      }
      if (element.id == 'buscarPV') {
        this.nuevaPV.nativeElement.focus();
        return;
      }
      if (element.id == 'nuevaPV') {
        this.imprimirPV.nativeElement.focus();
        return;
      }
      if (element.id == 'imprimirPV') {
        this.opcionPV.nativeElement.focus();
        return;
      }
      if (element.id == 'opcionPV') {
        this.finPV.nativeElement.focus();
        return;
      }
    }
    if (event.keyCode == 37) { //cuando se presiona la tacla izq 				
      if (element.id == 'anteriorPV') {
        this.siguientePV.nativeElement.focus();
        return;
      }
      if (element.id == 'primeraPV') {
        this.anteriorPV.nativeElement.focus();
        return;
      }
      if (element.id == 'ultimaPV') {
        this.primeraPV.nativeElement.focus();
        return;
      }
      if (element.id == 'buscarPV') {
        this.ultimaPV.nativeElement.focus();
        return;
      }
      if (element.id == 'nuevaPV') {
        this.buscarPV.nativeElement.focus();
        return;
      }
      if (element.id == 'imprimirPV') {
        this.nuevaPV.nativeElement.focus();
        return;
      }
      if (element.id == 'opcionPV') {
        this.imprimirPV.nativeElement.focus();
        return;
      }
      if (element.id == 'finPV') {
        this.opcionPV.nativeElement.focus();
        return;
      }
    }
    if (event.keyCode == 78) { //cuando se presiona la tacla N 		 
      this.nuevafactura();
    }
    if (event.keyCode == 73) { //cuando se presiona la tacla i 		 
      this.imprimirModal();
    }
  }

  scapeTecla(element) {
    //if (element.id == "clientePV") {
    this.estadoDivBotones("d-block");
    this.siguientePV.nativeElement.focus();
    this.estadoDivProducto("d-none") // se muestra el div de producto
    //}

  }


  enterTecla(element) {
    console.log(element.id);
    if (element.id == "nuevaPV") {
      this.nuevafactura();
    }
    if (element.id == "imprimirPV") {
      this.imprimirModal();
    }
    if (element.id == "clientePV") {
      this.clienteSelectFun(element);
    }
    if (element.id == "tipoDocumentoPV") {
      this.tipoDocumentoSelect(element);
    }
    if (element.id == "empleadoPV") {
      this.empleadoSelectFunt(element);
    }
    if (element.id == "CodigoBarrasPV") {
      this.codigoBarrasSelect(element);
    }
    if (element.id == "articuloPV") {
      this.productoEnter(element);
    }
    if (element.id == "codigoPV") {
      this.codigoProductoSelect(element);
      console.log("enter en producto");
    }
    if (element.id == "cantidadPV") {
      this.cantidadEnter(element);
    }
    if (element.id == "precioPV") {
      this.precioEnter(element);
    }
    if (element.id == "descuentoPV") {
      this.carteraPV.nativeElement.focus();
    }
    if (element.id == "carteraPV") {
      this.enterCartera(element);
    }
    if (element.id == "tarjetaPV") {
      this.enterTarjeta(element);
    }
    if (element.id == "vrTarjetaPV") {
      this.efectovoPV.nativeElement.focus();
    }
    if (element.id == "efectovoPV") {
      this.continuaImpresionPV.nativeElement.focus();
    }
    if (element.id == "continuaImpresionPV") {
      this.enterContinuarImpresion(element);

    }


  }

  limpiar() {
    this.estadoDivBotones("d-block");
    this.siguientePV.nativeElement.focus();
    this.estadoDivProducto("d-none") // se muestra el div de producto
    this.CodigoBarrasPV.nativeElement.value = "";
    this.CodigoBarrasPV.nativeElement.classList.add("d-none"); this.clienteActivo = false;
    this.guiaTransporteActivo = false;
    this.clienteObligatorioActivo = false;
    this.empreadoActivo = false;
    this.codigoBarrasActivo = false;
    this.clienteSelect = "";
    this.tipoDocumentSelect = "";
    this.empleadoSelect = "";
    this.document = new DocumentoModel();
    this.clientePV.nativeElement.value = "";
    this.tipoDocumentoPV.nativeElement.value = "";
    this.empleadoPV.nativeElement.value = "";
    this.articuloPV.nativeElement.value = "";
    this.codigoPV.nativeElement.value = "";
    this.cantidadPV.nativeElement.value = "";
    this.precioPV.nativeElement.value = "";
    this.productos = [];
    this.descuentoPV.nativeElement.value="";
    //this.carteraPV.nativeElement.value="";
    //this.tarjetaPV.nativeElement.value="";
    //this.vrTarjetaPV.nativeElement.value="";
    //this.efectovoPV.nativeElement.value="";
    //this.continuaImpresionPV.nativeElement.value="";
  }

   

  imprimirFactura() {
    if (this.document.documentoId == "") {
      alert("El documento esta corructo, vuelva a crearlo");
      return;
    }
    
    //se asigna un tipo de pago
    if(this.carteraPV.nativeElement.value=="S" ||this.carteraPV.nativeElement.value=="s"){
      this.document.tipoPagoId="2";//tipo de pago a credito
    }else{
      if(this.tarjetaPV.nativeElement.value=="S" ||this.tarjetaPV.nativeElement.value=="s"){
        this.document.tipoPagoId="5";//tipo de pago con tarjeta
      }else{
        this.document.tipoPagoId="1";//tipo de pago con en efectivo
      }
    }
    // se verifica si hay descuento para aplicar
    let des1 = this.descuentoPV.nativeElement.value==""?0.0:this.descuentoPV.nativeElement.value;
    if(des1!=0.0){
      let desTemp = 0.0;
      this.getAplicarDescuento(des1);
    }
    //TODO hacer la parte que del docuemto asigna la mac desde type scrip
    //this.document.mac=""
    this.documentosService.imprimirFactura(this.document).subscribe(res => {
        if(res.responseCode==200){
          this.limpiar();
          if(res.message!=""){
            alert(res.message);
          }
        }else{
          if(res.responseCode==500){
            alert(res.message);
          }
        }
        this.cancalarImpresionPV.nativeElement.click();
        this.siguientePV.nativeElement.focus();
    },(err) => {
      alert("Error imprimiendo factura desde el server");
    });
  }

  getAplicarDescuento(descuento){
    let desTemp = 0.0;
		// si el descuento es mayor o menor que 100 entonces se calcula el descuento en %		
		if (descuento < -100.0 || descuento > 100.0) {
			this.document.descuento = descuento;
			desTemp = (descuento * 100) / +this.document.total;
			console.log("% descuento:" + desTemp);
		} else {
			this.document.descuento=""+(+this.document.total * descuento / 100);
			desTemp = descuento;
			console.log("% descuento:" + desTemp);
		}
		//if (desTemp < -15 || desTemp > 15) {
		//	return;
		//}
		let des = desTemp / 100;
		let  temp:Array<DocumentoDetalleVoModel>=[];
		for(var i=0; i<this.productos.length; i++){
			let parcialDescuento = +this.productos[i].parcial + (+this.productos[i].parcial * des);
			let unitarioDescuento = +this.productos[i].unitario + (+this.productos[i].unitario * des);
			this.productos[i].parcial=""+parcialDescuento;
			this.productos[i].unitario=""+unitarioDescuento;
			temp.push(this.productos[i]);
		}
		let totalTemp = +this.document.total;
		let ivaTemp = +this.document.iva + (+this.document.iva * des);
		let excentoTemp = +this.document.excento + (+this.document.excento * des);
		let gravadoTemp = +this.document.gravado + (+this.document.gravado * des);
		this.document.total=""+totalTemp;
		this.document.saldo=""+totalTemp;
		this.document.iva=""+ivaTemp;
		this.document.excento=""+excentoTemp;
		this.document.gravado=""+gravadoTemp;
		this.productos=temp;
		// se valida si el descuento es mayor o menor a 1.5
		//if (desTemp >= 1.5 || desTemp <= -1.5) {
		//	Evento evento = new Evento();
		//	TipoEvento tipoEvento = new TipoEvento();
		//	tipoEvento.setTipoEventoId(2l); // se asigna tipo evento igual a
											// descuento mayor al 1.5
		//	evento.setFechaRegistro(new Date());
		//	evento.setTipoEventoId(tipoEvento);
		//	evento.setUsuarioId(usuario());
		//	evento.setCampo("" + getDocumento().getDocumentoId());
		//	evento.setValorActual("" + totalTemp);
		//	evento.setValorAnterior("" + getDescuento());
		//	eventoService.save(evento);
		//}
  }

  enterContinuarImpresion(element) {
    let contador = 0;
    var myInterval = setInterval(() => {
      if (element.value == 'n' || element.value == 'N') {
        this.cancalarImpresionPV.nativeElement.click();
      } else {
        console.log("flujo si imprimir");
        this.impresionPV.nativeElement.click();

      }
      contador = contador + 1;
      if (contador >= 1) {
        clearInterval(myInterval);
      }
    }, 150);
  }

  enterCartera(element) {
    let contador = 0;
    var myInterval = setInterval(() => {
      this.carteraPV.nativeElement.focus();
      this.carteraPV.nativeElement = element.value;
      this.tarjetaPV.nativeElement.focus();
      this.tarjetaPV.nativeElement.value = "";
      contador = contador + 1;
      if (contador >= 1) {
        clearInterval(myInterval);
      }
    }, 200);
  }

  enterTarjeta(element) {
    let contador = 0;
    var myInterval = setInterval(() => {
      if (element.value == 's' || element.value == 'S') {
        this.vrTarjetaPV.nativeElement.focus();
      } else {
        this.efectovoPV.nativeElement.focus();
      }
      contador = contador + 1;
      if (contador >= 1) {
        clearInterval(myInterval);
      }
    }, 200);
  }

  precioEnter(element) {
    if (this.codigoBarrasActivo) {
      this.CodigoBarrasPV.nativeElement.classList.add("d-block");
      this.CodigoBarrasPV.nativeElement.focus();
    } else {
      this.articuloPV.nativeElement.focus();
    }
    let precio = this.precioPV.nativeElement.value;
    this.articuloPV.nativeElement.value = "";
    this.CodigoBarrasPV.nativeElement.value = "";
    this.precioPV.nativeElement.value = "";
    console.log("precio enter:" + precio);
    if (isNaN(precio)) {
      console.log("no es numérico:" + precio);
      return;
    }
    if (precio == null || precio == '' || precio <= 0) {
      return;
    }
    console.log("//TODO hacer lo que tiene que hacer cuando se le da enter en precio del x01");
  }

  cantidadEnter(element) {

    let cantidad = this.cantidadPV.nativeElement.value;
    if (cantidad > 1500) {
      alert("La cantidad no puede ser mayor a 1500");
      return;
    }
    if (this.codigoBarrasActivo) {
      this.CodigoBarrasPV.nativeElement.classList.add("d-block");
      this.CodigoBarrasPV.nativeElement.focus();
    } else {
      this.articuloPV.nativeElement.focus();
    }
    this.articuloPV.nativeElement.value = "";
    this.CodigoBarrasPV.nativeElement.value = "";
    this.cantidadPV.nativeElement.value = "";
    console.log("cantidad enter:" + cantidad);
    if (isNaN(cantidad)) {
      console.log("no es numérico:" + cantidad);
      return;
    }
    if (cantidad == null || cantidad == '' || cantidad <= 0) {
      return;
    }
    console.log("//TODO aqui hacer la validacion de stock min");
    console.log("//TODO aqui hacer la validacion de que el producto se agotó");
    let docDetalle = new DocumentoDetalleModel();
    if (this.document.documentoId == "") {
      this.document.clienteId = this.clienteSelect;
      this.document.tipoDocumentoId = this.tipoDocumentSelect;
      this.document.fechaRegistro = new Date();
      var userLogin = sessionStorage.getItem("usuarioId");
      this.document.usuarioId = userLogin;
      this.documentosService.saveDocumento(this.document).subscribe(res => {
        this.document = res;
        //c cambia se hace en el back-end
        docDetalle.cantidad = cantidad;
        docDetalle.productoId = this.productoSelect;
        docDetalle.documentoId = this.document.documentoId;
        docDetalle.estado = '1';
        //TODO hacer en el back la logica del doble server
        this.documentoDetalleService.agregarDocumentoDetalle(docDetalle).subscribe(res => {
          this.productos.push(res);
          this.productos = this.productos.reverse();
          this.documentosService.getDocumentoById(this.document.documentoId).subscribe(res => {
            this.document = res;
          });
        });

      });

    } else {

      let docDetalle = new DocumentoDetalleModel();
      //c cambia se hace en el back-end

      docDetalle.cantidad = cantidad;
      docDetalle.productoId = this.productoSelect;
      docDetalle.documentoId = this.document.documentoId;
      docDetalle.estado = '1';
      //TODO hacer en el back la logica del doble server
      this.documentoDetalleService.agregarDocumentoDetalle(docDetalle).subscribe(res => {
        this.productos.push(res);
        this.documentosService.getDocumentoById(this.document.documentoId).subscribe(res => {
          this.document = res;
        });
      });

    }

  }

  codigoProductoSelect(element) {
    if (element.value == '') {
      if (this.codigoBarrasActivo) {
        this.CodigoBarrasPV.nativeElement.classList.remove("d-none");
        this.CodigoBarrasPV.nativeElement.classList.add("d-block");
        this.CodigoBarrasPV.nativeElement.focus();
      } else {
        this.articuloPV.nativeElement.focus();
      }
    } else {
      console.log("TO DO// busqueda de código de producto")
    }
  }

  productoEnter(element) {
    if (element.value == '') {
      this.codigoPV.nativeElement.focus();
    }
  }

  articuloSelect(element) {
    console.log("articulo select:" + element.value);
    var splitted = element.value.split("|");
    this.productoSelect = splitted[3];
    if (this.productoSelect == '1' || this.productoSelect == '2' || this.productoSelect == '0') {
      this.precioPV.nativeElement.classList.add("d-block");
      this.precioPV.nativeElement.classList.remove("d-none");
      this.precioPV.nativeElement.focus();
    } else {
      this.productosService.getProductoById(this.productoSelect).subscribe(res => {
        if (res.balanza == '1') {
          console.log("//TODO hacer lo de balanza");
        } else {
          this.cantidadPV.nativeElement.focus();
        }
        console.log(res);
      });
    }
  }

  codigoBarrasSelect(element) {

    if (element.value == '') {
      this.articuloPV.nativeElement.focus();
    } else {
      console.log("TODO//busqueda de producto por codigo de barras:" + element.value);
    }
  }

  ocultarCodigoBarras() {
    this.CodigoBarrasPV.nativeElement.classList.remove("d-block");
    this.CodigoBarrasPV.nativeElement.classList.add("d-none");
  }

  ocultarPrecio() {
    this.precioPV.nativeElement.classList.remove("d-block");
    this.precioPV.nativeElement.classList.add("d-none");
  }

  empleadoSelectFunt(element) {
    this.empleadoSelect = element.value;
    if (this.codigoBarrasActivo) {
      this.CodigoBarrasPV.nativeElement.classList.add("d-block");
      this.CodigoBarrasPV.nativeElement.focus();
    } else {
      this.articuloPV.nativeElement.focus();
    }

  }

  tipoDocumentoSelect(element) {
    switch (element.value) {
      case '': {
        console.log("factura de venta por defecto");
        break;
      }
      case 'C': {
        console.log("cotizacion");
        break;
      }
      case 'c': {
        console.log("cotizacion");
        break;
      }
      case 'R': {
        console.log("remision");
        break;
      }
      case 'r': {
        console.log("remision");
        break;
      }
      case 'f': {
        console.log("Factura");
        break;
      }
      case 'F': {
        console.log("Factura");
        break;
      }
      default: {
        console.log("incorrecto");
        alert("Tipo de documento invalido");
        element.value = '';
        return;
      }
    }
    this.tipoDocumentSelect = element.value;
    if (this.empreadoActivo) {
      this.empleadoPV.nativeElement.focus();
    } else {
      if (this.codigoBarrasActivo) {
        this.CodigoBarrasPV.nativeElement.classList.add("d-block");
        this.CodigoBarrasPV.nativeElement.focus();
      } else {
        this.articuloPV.nativeElement.focus();
      }
    }
  }

  clienteSelectFun(element) {
    if (this.clienteObligatorioActivo && element.value == '') {
      alert("El cliente es obligatorio");
      return;
    } else {
      var splitted = element.value.split("|");
      this.clienteSelect = splitted[0];
    }

    console.log("cliente select:" + element.value);
    if (this.guiaTransporteActivo) {
      this.tipoDocumentoPV.nativeElement.focus();
    } else {
      if (this.empreadoActivo) {
        this.empleadoPV.nativeElement.focus();
      } else {
        if (this.codigoBarrasActivo) {
          this.CodigoBarrasPV.nativeElement.classList.add("d-block");
          this.CodigoBarrasPV.nativeElement.focus();
        } else {
          this.articuloPV.nativeElement.focus();
        }
      }
    }

  }


  nuevafactura() {
    console.log("nueva factura");
    this.limpiar();
    this.estadoDivBotones("d-none");
    this.estadoDivProducto("d-block") // se muestra el div de producto
    for (var e = 0; e < this.activaciones.length; e++) {
      if (this.activaciones[e].codigo == "CLIENTE_FACTURACION") {
        console.log("cliente activo");
        this.clienteActivo = true;
      }
      if (this.activaciones[e].codigo == "GUIA_TRANSPORTE") {
        console.log("guia de trasporte activa");
        this.guiaTransporteActivo = true;
      }
      if (this.activaciones[e].codigo == "CLIENTE_OBLIGATORIO") {
        console.log("cliente obligatorio");
        this.clienteObligatorioActivo = true;
      }
      if (this.activaciones[e].codigo == "EMPLEADOS") {
        console.log("empleado activado");
        this.empreadoActivo = true;
      }
      if (this.activaciones[e].codigo == "CODIGO_BARRAS") {
        console.log("codigo barras activado");
        this.codigoBarrasActivo = true;
      }
      if (this.activaciones[e].codigo == "DESCUENTOS") {
        console.log("descuentos activos ");
        this.descuentosActivo = true;
      }
    }
    if (this.clienteActivo) {
      this.clientePV.nativeElement.focus();
    } else {
      if (this.guiaTransporteActivo) {
        this.tipoDocumentoPV.nativeElement.focus();
      } else {
        if (this.empreadoActivo) {
          this.empleadoPV.nativeElement.focus();
        } else {
          if (this.codigoBarrasActivo) {
            this.CodigoBarrasPV.nativeElement.classList.add("d-block");
            this.CodigoBarrasPV.nativeElement.focus();
          } else {
            this.articuloPV.nativeElement.focus();
          }
        }
      }
    }
  }

  imprimirModal() {
    if (this.document.documentoId == "") {
      alert("debe crear primero una factura");
      return;
    }
    let contador = 0;
    this.imprimirBtn.nativeElement.click();
    if (this.descuentosActivo) {
      this.descuentoLavel.nativeElement.classList.remove("d-none");
      this.descuentoLavel.nativeElement.classList.add("d-block");
      this.descuentoPV.nativeElement.classList.remove("d-none");
      this.descuentoPV.nativeElement.classList.add("d-block");
      var myInterval = setInterval(() => {
        console.log(contador);
        this.descuentoPV.nativeElement.focus();
        contador = contador + 1;
        if (contador >= 1) {
          clearInterval(myInterval);
        }
      }, 800);
    } else {
      var myInterval = setInterval(() => {
        this.carteraPV.nativeElement.focus();
        contador = contador + 1;
        if (contador >= 1) {
          clearInterval(myInterval);
        }
      }, 800);
    }


  }

  estadoDivProducto(visible: string) {
    if (visible == "d-block") {
      this.divCantidad.nativeElement.classList.add("d-block");
      this.divCodigo.nativeElement.classList.add("d-block");
      this.divArticulo.nativeElement.classList.add("d-block");
      this.divUnitario.nativeElement.classList.add("d-block");
      this.divParcial.nativeElement.classList.add("d-block");
      this.divCantidad.nativeElement.classList.remove("d-none");
      this.divCodigo.nativeElement.classList.remove("d-none");
      this.divArticulo.nativeElement.classList.remove("d-none");
      this.divUnitario.nativeElement.classList.remove("d-none");
      this.divParcial.nativeElement.classList.remove("d-none");

    } else {
      this.divCantidad.nativeElement.classList.add("d-none");
      this.divCodigo.nativeElement.classList.add("d-none");
      this.divArticulo.nativeElement.classList.add("d-none");
      this.divUnitario.nativeElement.classList.add("d-none");
      this.divParcial.nativeElement.classList.add("d-none");
      this.divCantidad.nativeElement.classList.remove("d-block");
      this.divCodigo.nativeElement.classList.remove("d-block");
      this.divArticulo.nativeElement.classList.remove("d-block");
      this.divUnitario.nativeElement.classList.remove("d-block");
      this.divParcial.nativeElement.classList.remove("d-block");
    }
  }
  estadoDivBotones(visible: string) {
    if (visible == "d-block") {
      this.divSiguiente.nativeElement.classList.add("d-block");
      this.divAnterior.nativeElement.classList.add("d-block");
      this.divPrimera.nativeElement.classList.add("d-block");
      this.divUltima.nativeElement.classList.add("d-block");
      this.divBuscar.nativeElement.classList.add("d-block");
      this.divNueva.nativeElement.classList.add("d-block");
      this.divImprimir.nativeElement.classList.add("d-block");
      this.divOpciones.nativeElement.classList.add("d-block");
      this.divFin.nativeElement.classList.add("d-block");
    } else {
      this.divSiguiente.nativeElement.classList.add("d-none");
      this.divAnterior.nativeElement.classList.add("d-none");
      this.divPrimera.nativeElement.classList.add("d-none");
      this.divUltima.nativeElement.classList.add("d-none");
      this.divBuscar.nativeElement.classList.add("d-none");
      this.divNueva.nativeElement.classList.add("d-none");
      this.divImprimir.nativeElement.classList.add("d-none");
      this.divOpciones.nativeElement.classList.add("d-none");
      this.divFin.nativeElement.classList.add("d-none");

      this.divSiguiente.nativeElement.classList.remove("d-block");
      this.divAnterior.nativeElement.classList.remove("d-block");
      this.divPrimera.nativeElement.classList.remove("d-block");
      this.divUltima.nativeElement.classList.remove("d-block");
      this.divBuscar.nativeElement.classList.remove("d-block");
      this.divNueva.nativeElement.classList.remove("d-block");
      this.divImprimir.nativeElement.classList.remove("d-block");
      this.divOpciones.nativeElement.classList.remove("d-block");
      this.divFin.nativeElement.classList.remove("d-block");
    }
  }

  getActivaciones(user: string) {
    this.usuarioService.getActivacionByUsuario(user).subscribe(res => {
      this.activaciones = res;
      console.log(res);
    });
  }

  getclientes() {
    this.clienteService.getClientesAll().subscribe(res => {
      this.clientes = res;
    });
  }

  getProductosAll() {
    this.productosService.getProductosAll().subscribe(res => {
      this.productosAll = res;
      console.log(res);
    });
  }

}
