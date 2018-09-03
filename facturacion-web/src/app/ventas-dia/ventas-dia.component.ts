import { Component, OnInit,Renderer2, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-ventas-dia',
  templateUrl: './ventas-dia.component.html',
  styleUrls: ['./ventas-dia.component.css']
})
export class VentasDiaComponent implements OnInit {

  @ViewChild("siguientePV") siguientePV: ElementRef;
  @ViewChild("anteriorPV") anteriorPV: ElementRef;
  @ViewChild("primeraPV") primeraPV: ElementRef;
  @ViewChild("ultimaPV") ultimaPV: ElementRef;
  @ViewChild("buscarPV") buscarPV: ElementRef;
  @ViewChild("nuevaPV") nuevaPV: ElementRef;
  @ViewChild("imprimirPV") imprimirPV: ElementRef;
  @ViewChild("opcionPV") opcionPV: ElementRef;
  @ViewChild("finPV") finPV: ElementRef;

  constructor(private renderer: Renderer2) { }

  ngOnInit() {
    this.siguientePV.nativeElement.focus(); 
  }

  controlTeclas(event ,element){
    if( event.keyCode==39){ //cuando se presiona la tacla derecha 				
      if(element.id=='siguientePV'){
        this.anteriorPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='anteriorPV'){
        this.primeraPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='primeraPV'){
        this.ultimaPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='ultimaPV'){
        this.buscarPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='buscarPV'){
        this.nuevaPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='nuevaPV'){
        this.imprimirPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='imprimirPV'){
        this.opcionPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='opcionPV'){
        this.finPV.nativeElement.focus(); 
        return;
      }
    }
    if( event.keyCode==37){ //cuando se presiona la tacla izq 				
      if(element.id=='anteriorPV'){
        this.siguientePV.nativeElement.focus(); 
        return;
      }
      if(element.id=='primeraPV'){
        this.anteriorPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='ultimaPV'){
        this.primeraPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='buscarPV'){
        this.ultimaPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='nuevaPV'){
        this.buscarPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='imprimirPV'){
        this.nuevaPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='opcionPV'){
        this.imprimirPV.nativeElement.focus(); 
        return;
      }
      if(element.id=='finPV'){
        this.opcionPV.nativeElement.focus(); 
        return;
      }
    }
  }

  enterTecla(element){
    console.log(element);
  }

}
