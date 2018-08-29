import { ResponseCodeModel } from './../MODEL/responseCode.model';
import { UsuariosService } from './usuarios.service';
import { Component, OnInit } from '@angular/core';
import { UsuarioModel } from '../model/usuario.model';
declare var jquery:any;
declare var $ :any;

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  public usuarioBuscar: UsuarioModel;
  public usuarioCrear: UsuarioModel;
  public usuarioList: Array<UsuarioModel>;

  constructor(private usuarioService: UsuariosService) { 
    this.usuarioBuscar=new UsuarioModel();
    this.usuarioBuscar.nombre="";
    this.usuarioBuscar.login="";
    this.usuarioBuscar.rolId="";
    this.usuarioBuscar.identificacion="";
    this.usuarioCrear=new UsuarioModel();
   
  }

  ngOnInit() {
    
  }

  buscarUsuarios(){
    
    this.usuarioService.getByFiltros(this.usuarioBuscar).subscribe(res => {
      this.usuarioList = res;      
    });
  }

  crearUsuario(){
    let valido:boolean=true;
    let mensageError:string= "Son obligatorios:\n ";
    if(this.usuarioCrear.nombre==""){
      mensageError+="nombre\n";
      valido=false;
    }
    if(this.usuarioCrear.login==""){
      mensageError+="login\n";
      valido=false;
    }
    if(this.usuarioCrear.rolId!=""){
      mensageError+="rol\n";
      valido=false;
    }
    if(this.usuarioCrear.identificacion==""){
      mensageError+="identificación\n";
      valido=false;
    }
    if(this.usuarioCrear.clave==""){
      mensageError+="clave\n";
      valido=false;
    }
    if(valido==false){
      alert(mensageError);
      return;
    }
    if(this.usuarioCrear.estado){
      this.usuarioCrear.estado='1';
    }else{
      this.usuarioCrear.estado='0';
    }
    this.usuarioService.saveUsuario(this.usuarioCrear).subscribe(res => {
      let respuesta:ResponseCodeModel = res; 
      if(respuesta.responseCode==200){
        $('#exampleModal').modal('hide');
      }else{
        alert("Algo salio mal Creando el usuario... "+respuesta.message+"\nComunicate con soporte");
      }     
    });
  }

}
