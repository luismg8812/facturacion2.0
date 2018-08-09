import { Injectable } from '@angular/core';
import { HttpClient}  from '@angular/common/http';
import { Observable } from 'rxjs';
import { MenuModel } from '../model/menu.model';
import { ConfigService } from '../config.service';
import { OpcionUsuarioModel } from '../model/opcionUsuario.model';
import { SubMenuModel } from '../model/submenu.model';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
  
  private host:string;
  private port:string;
  private menu:MenuModel;
  constructor(private http:HttpClient,private configService:ConfigService) { 
    console.log("servicio menuService funcionando: ");
  }

  public getByAll():Observable<MenuModel[]>{
    this.host = sessionStorage.getItem("host");
    this.port = sessionStorage.getItem("port");
    return this.http.get<MenuModel[]>("http://"+this.host+":"+this.port+"/getMenuAll");  
  }

  public getOpcionUsuarioByMenu(menuId:string,usuarioId:string):Observable<OpcionUsuarioModel[]>{
    this.host = sessionStorage.getItem("host");
    this.port = sessionStorage.getItem("port");
    return this.http.get<OpcionUsuarioModel[]>("http://"+this.host+":"+this.port+"/getOpcionUsuarioByMenu?menuId="+menuId+"&usuarioId="+usuarioId);  
  }

  public getSubMenuByOU(ou: OpcionUsuarioModel[]): Observable<SubMenuModel[]> {
    this.host = sessionStorage.getItem("host");
    this.port = sessionStorage.getItem("port");
    console.log("llega al service"+ou);
    return this.http.get<SubMenuModel[]>("http://"+this.host+":"+this.port+"/geSubMenuByOU?ouId="+ou);  
  }
}
