import { SubMenuModel } from './../model/submenu.model';
import { element, Key } from 'protractor';
import { Component, OnInit, Renderer2, ElementRef, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { MenuService } from './menu.service';
import { MenuModel } from '../model/menu.model';
import { OpcionUsuarioModel } from '../model/opcionUsuario.model';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  private show: string;
  private menus: Array<MenuModel>;
  private opUsuario: Array<OpcionUsuarioModel>;
  private subMenu: Array<SubMenuModel>;
  private subMenuAll:Array<SubMenuModel>;
  @ViewChild("informes") informes: ElementRef;
  @ViewChild("facturacion") facturacion: ElementRef;
  constructor(private router: Router, private menuService: MenuService, private renderer: Renderer2) { }

  ngOnInit() {
    var userLogin = sessionStorage.getItem("userLogin");
    if (userLogin == null) {
      this.router.navigate(['/login']);
    } else {
      this.getByAllMenu();
       this.getSubMenuAll();
      this.getOpActivas();
    }
    
  }

  private getByAllMenu(): void {
    this.menuService.getByAll().subscribe(res => {
      this.menus = res;
    });
  }

  getSubMenuAll(){
    this.menuService.getSubMenuAll().subscribe(res => { 
      this.subMenuAll=res;
    }); 
  }

  getOpActivas(){
    var usuarioId = sessionStorage.getItem("usuarioId");
    this.menuService.getOpcionUsuarioByMenu( usuarioId).subscribe(res => {  
      this.opUsuario = res;
    });
  }

  getOpcionUsuarioByMenu(menuId) {
      this.subMenu=[];
      console.log(menuId)
      
      for (var _i = 0; _i < this.subMenuAll.length; _i++) {
        for (var e = 0; e < this.opUsuario.length; e++) {
          if(this.subMenuAll[_i].subMenuId==this.opUsuario[e].subMenuId &&
            this.subMenuAll[_i].menuId==menuId){
            this.subMenu.push(this.subMenuAll[_i]);
          }
        }
      }
      console.log(this.subMenu); // 1, "string", false
  }

  onKeyTeclasMenu(event, element) {

    //console.log(element);
    //console.log(event.keyCode);
    var elec = element;
    if (event.keyCode == 39) { //cuando se presiona la tacla lado derecho 
      if (elec == 'facturacion') {
        //this.show="informes";
        console.log(this.informes);
        //this.informes.nativeElement.click();
        this.renderer.selectRootElement('#informes').click();
        //console.log(this.show);
        return;
      }
      if (elec == 'informes') {
        console.log("entra a informe");
        this.show = "clientes";
        let siguiente: HTMLElement = document.getElementById('clientes') as HTMLElement;
        siguiente.click();
        console.log(this.show);
        return;
      }
      if (elec == 'clientes') {
        console.log("entra a clientes");
        this.show = "configuracion";
        let siguiente: HTMLElement = document.getElementById('configuracion') as HTMLElement;
        siguiente.focus();
        siguiente.click();
        console.log(this.show);
        return;
      }
      if (elec == 'configuracion') {
        console.log("entra a configuracion");
        this.show = "facturacion";
        let siguiente: HTMLElement = document.getElementById('facturacion') as HTMLElement;
        siguiente.focus();
        siguiente.click();
        console.log(this.show);
        return siguiente;
      }
    }
  }

}
