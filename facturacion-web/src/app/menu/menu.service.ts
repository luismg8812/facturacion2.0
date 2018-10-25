import { Injectable } from '@angular/core';
import { HttpClient}  from '@angular/common/http';
import { Observable } from 'rxjs';
import { MenuModel } from '../model/menu.model';
import { ConfigService } from '../config.service';
import { OpcionUsuarioModel } from '../model/opcionUsuario.model';
import { SubMenuModel } from '../model/submenu.model';
import { UsuarioModel } from '../model/usuario.model';
import { ResponseCodeModel } from '../MODEL/responseCode.model';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  
  private host:string= sessionStorage.getItem("host");;
  private port:string = sessionStorage.getItem("port");;
  private menu:MenuModel;
  constructor(private http:HttpClient) { 
    console.log("servicio menuService funcionando: ");
  }

  public getByAll():Observable<MenuModel[]>{  
    return this.http.get<MenuModel[]>("http://"+this.host+":"+this.port+"/menu/getMenuAll");  
  }

  public getOpcionUsuarioByMenu(usuarioId:string):Observable<OpcionUsuarioModel[]>{ 
    return this.http.get<OpcionUsuarioModel[]>("http://"+this.host+":"+this.port+"/menu/getOpcionUsuarioByMenu?usuarioId="+usuarioId);  
  }

  public getSubMenuByOU(ou: Array<string>): Observable<SubMenuModel[]> {
    return this.http.get<SubMenuModel[]>("http://"+this.host+":"+this.port+"/menu/geSubMenuByOU?ouId="+ou);  
  }

  public getSubMenuAll(): Observable<SubMenuModel[]> {
    return this.http.get<SubMenuModel[]>("http://" + this.host + ":" + this.port + "/menu/getSubMenuAll");
  }

  public getSubMenuByUsuario(usuarioId:string):Observable<SubMenuModel[]>{ 
    return this.http.get<SubMenuModel[]>("http://"+this.host+":"+this.port+"/menu/getSubMenuByUsuario?usuarioId="+usuarioId);  
  }

  public guardarRutas(user:UsuarioModel,idSubmenu:Array<string>):Observable<ResponseCodeModel> {
    let url:string="http://" + this.host + ":" + this.port + "/menu/guardarRutas?usuarioId="+user.usuarioId+"&idSubmenu="+idSubmenu;
    console.log(url);
    return this.http.get<ResponseCodeModel>(url);
  }

  public guardarActivaciones(user:UsuarioModel,idActivaciones:Array<string>):Observable<ResponseCodeModel> { 

    return this.http.get<ResponseCodeModel>("http://" + this.host + ":" + this.port + "/menu/guardarActivaciones?usuarioId="+user.usuarioId+"&idActivaciones="+idActivaciones);
  }

  public getRegistrarSession(usuarioId:string):Observable<string>{ 
    return this.http.get<string>("http://"+this.host+":"+this.port+"/menu/getRegistrarSession?usuarioId="+usuarioId);  
  }

}
