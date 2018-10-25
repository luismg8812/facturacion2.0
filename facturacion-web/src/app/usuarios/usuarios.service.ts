import { ActivacionModel } from './../model/activacion';
import { ResponseCodeModel } from './../MODEL/responseCode.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioModel } from '../model/usuario.model';
import { ConfigService } from '../config.service';
import { RolModel } from '../model/rol.model';
import { SubMenuModel } from '../model/submenu.model';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private host: string = sessionStorage.getItem("host");
  private port: string = sessionStorage.getItem("port");
  constructor(private http: HttpClient) { }
  public getByFiltros(usuario: UsuarioModel): Observable<UsuarioModel[]> {
    return this.http.get<UsuarioModel[]>("http://" + this.host + ":" + this.port + "/client/getByFiltros?nombre=" + usuario.nombre +
      "&login=" + usuario.login + "&rol=" + usuario.rolId + "&identificacion=" + usuario.identificacion);
  }

  public saveUsuario(usuario: UsuarioModel): Observable<ResponseCodeModel> {
    let json = JSON.stringify(usuario);
    console.log(json);
    return this.http.post<ResponseCodeModel>("http://" + this.host + ":" + this.port + "/client/saveOrUpdateUsuario", json);
  }

  public getRolAll(): Observable<RolModel[]> {
    return this.http.get<RolModel[]>("http://" + this.host + ":" + this.port + "/client/getRolAll");
  }

  public getActivacionAll(): Observable<ActivacionModel[]> {
    return this.http.get<ActivacionModel[]>("http://" + this.host + ":" + this.port + "/client/getActivacionAll");
  }

  public getActivacionByUsuario(user:string): Observable<ActivacionModel[]> {
    return this.http.get<ActivacionModel[]>("http://" + this.host + ":" + this.port + "/client/getActivacionByUsuario?usuarioId="+user);
  }

}
