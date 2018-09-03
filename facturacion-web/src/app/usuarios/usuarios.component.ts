import { ActivacionModel } from './../model/activacion';
import { SubMenuModel } from './../model/submenu.model';
import { OpcionUsuarioModel } from './../model/opcionUsuario.model';
import { MenuService } from './../menu/menu.service';
import { ResponseCodeModel } from './../MODEL/responseCode.model';
import { UsuariosService } from './usuarios.service';
import { Component, OnInit } from '@angular/core';
import { UsuarioModel } from '../model/usuario.model';
import { RolModel } from '../model/rol.model';
declare var jquery: any;
declare var $: any;

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  public usuarioBuscar: UsuarioModel;
  public usuarioCrear: UsuarioModel;
  public usuarioSelect: UsuarioModel;
  public usuarioList: Array<UsuarioModel>;
  public rolList: Array<RolModel>;

  public subMenuAll: Array<SubMenuModel>;
  public activacionAll: Array<ActivacionModel>;
  public submenuSelect: Array<SubMenuModel>;
  public opusuarioUnSelect: Array<SubMenuModel>;
  public activacionSelect: Array<ActivacionModel>;
  public activacionUnSelect: Array<ActivacionModel>;

  constructor(private usuarioService: UsuariosService, private menuService: MenuService) {
    this.usuarioBuscar = new UsuarioModel();
    this.usuarioCrear = new UsuarioModel();
    this.roles();
  }

  ngOnInit() {

  }

  buscarUsuarios() {

    this.usuarioService.getByFiltros(this.usuarioBuscar).subscribe(res => {
      this.usuarioList = res;
    });
  }

  limpiar(){
    this.usuarioCrear=new UsuarioModel();
  }

  nameRol(idRol:string){
    for (var i = 0; i < this.rolList.length; i++) {
      if(this.rolList[i].rolId==idRol){
        return this.rolList[i].nombre;    
      }
    }
    return "";
  }

  crearUsuario() {
    let valido: boolean = true;
    let mensageError: string = "Son obligatorios:\n ";
    if (this.usuarioCrear.nombre == "") {
      mensageError += "nombre\n";
      valido = false;
    }
    if (this.usuarioCrear.login == "") {
      mensageError += "login\n";
      valido = false;
    }
    if (this.usuarioCrear.rolId == "") {
      mensageError += "rol\n";
      valido = false;
    }
    if (this.usuarioCrear.identificacion == "") {
      mensageError += "identificación\n";
      valido = false;
    }
    if (this.usuarioCrear.clave == "") {
      mensageError += "clave\n";
      valido = false;
    }
    if (valido == false) {
      alert(mensageError);
      return;
    }
    if (this.usuarioCrear.estado) {
      this.usuarioCrear.estado = '1';
    } else {
      this.usuarioCrear.estado = '0';
    }
    this.usuarioService.saveUsuario(this.usuarioCrear).subscribe(res => {
      let respuesta: ResponseCodeModel = res;
      if (respuesta.responseCode == 200) {
        $('#exampleModal').modal('hide');
      } else {
        alert("Algo salio mal Creando el usuario... " + respuesta.message + "\nComunicate con soporte");
      }
    });
  }

  EditarUsuarios(usuarioSelect: UsuarioModel) {
    this.usuarioCrear = usuarioSelect;
    console.log(usuarioSelect);
  }

  roles() {
    this.usuarioService.getRolAll().subscribe(res => {
      this.rolList = res;
    });
  }

  desactivarRuta(submenu1:SubMenuModel){
    for (var i = 0; i < this.submenuSelect.length; i++) {
      if(this.submenuSelect[i].subMenuId==submenu1.subMenuId){
        this.submenuSelect.splice(i, 1);
        break;
      }  
    }
    this.opusuarioUnSelect.push(submenu1);
  }

  activarRuta(submenu1:SubMenuModel){
    for (var i = 0; i < this.opusuarioUnSelect.length; i++) {
      if(this.opusuarioUnSelect[i].subMenuId==submenu1.subMenuId){
        this.opusuarioUnSelect.splice(i, 1);
        break;
      }  
    }
    this.submenuSelect.push(submenu1);
  }

  aplicarActivacion(activacion:ActivacionModel){
    for (var i = 0; i < this.activacionSelect.length; i++) {
      if(this.activacionSelect[i].activacionId==activacion.activacionId){
        this.activacionSelect.splice(i, 1);
        break;
      }  
    }
    this.activacionUnSelect.push(activacion);
  }

  desaplicarActivacion(activacion:ActivacionModel){
    for (var i = 0; i < this.activacionUnSelect.length; i++) {
      if(this.activacionUnSelect[i].activacionId==activacion.activacionId){
        this.activacionUnSelect.splice(i, 1);
        break;
      }  
    }
    this.activacionSelect.push(activacion);
  }

  guardarRutas(){
    let idSubmenu:Array<string>=[];
    let idActivacion:Array<string>=[];
    for (var i = 0; i < this.submenuSelect.length; i++) {
      idSubmenu.push(this.submenuSelect[i].subMenuId);
    }
    for (var i = 0; i < this.activacionSelect.length; i++) {
      idActivacion.push(this.activacionSelect[i].activacionId);
    }
    this.menuService.guardarActivaciones(this.usuarioSelect,idActivacion).subscribe(res => {
      
      if (res.responseCode == 200) {
        console.log("Activaciones guardadas");
      } else {
        alert("Algo salio mal Creando activa... " + res.message + "\nComunicate con soporte");
        return;
      }
    });
    this.menuService.guardarRutas(this.usuarioSelect,idSubmenu).subscribe(res => {
      console.log(res);
      if (res.responseCode == 200) {
        $('#exampleModal2').modal('hide');
      } else {
        alert("Algo salio mal Creando rutas... " + res.message + "\nComunicate con soporte");
      }
    });
  }

  opcionesPorUsuario(user: UsuarioModel) {
    this.activacionPorUsuario(user ); 
    this.opusuarioUnSelect = [];
    this.usuarioSelect = user;
    this.menuService.getSubMenuAll().subscribe(subMenuAll => {
      this.subMenuAll = subMenuAll;
      this.menuService.getSubMenuByUsuario(user.usuarioId).subscribe(res1 => {
        this.submenuSelect = res1;
        for (var e = 0; e < subMenuAll.length; e++) {
          var esta = false;
          for (var i = 0; i < res1.length; i++) {
            if (subMenuAll[e].subMenuId == res1[i].subMenuId) {
              esta = true;
              break;
            }
          }
          if (!esta) {
            this.opusuarioUnSelect.push(subMenuAll[e]);
          }
        }
        
      });
    });
    
  }

  activacionPorUsuario(user: UsuarioModel) {
    console.log("aqui llega");
    this.activacionUnSelect = [];
    this.usuarioSelect = user;
    this.usuarioService.getActivacionAll().subscribe(activacionAll => {
      this.activacionAll=activacionAll;
      this.usuarioService.getActivacionByUsuario(user.usuarioId).subscribe(res1 => {
        this.activacionSelect = res1;
        for (var e = 0; e < activacionAll.length; e++) {
          var esta = false;
          for (var i = 0; i < res1.length; i++) {
            if (activacionAll[e].activacionId == res1[i].activacionId) {
              esta = true;
              break;
            }
          }
          if (!esta) {
            this.activacionUnSelect.push(activacionAll[e]);
          }
        }
      });
    });
  }
}
