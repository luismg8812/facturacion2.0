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
      this.imprimirFactura();
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
      this.imprimirFactura();
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
          this.productos=this.productos.reverse();
          this.documentosService.getDocumentoById(this.document.documentoId).subscribe(res => {
            this.document=res;
            console.log(this.document);
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
          console.log(this.productos);
          this.documentosService.getDocumentoById(this.document.documentoId).subscribe(res => {
            this.document=res;
            console.log(this.document);
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
        console.log(res);
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

  imprimirFactura(){
    if(this.document.documentoId==""){
      alert("debe crear primero una factura");
      return;
    }
    alert("imprimir factura");  
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
