import { ResponseCodeModel } from './../MODEL/responseCode.model';
import { Injectable } from '@angular/core';
import { HttpClient}  from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioModel } from '../model/usuario.model';
import { ConfigService } from '../config.service';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private host:string=sessionStorage.getItem("host");;
  private port:string=sessionStorage.getItem("port");
  constructor(private http:HttpClient,private configService:ConfigService) { }
  public getByFiltros(usuario:UsuarioModel):Observable<UsuarioModel[]>{
    return this.http.get<UsuarioModel[]>("http://"+this.host+":"+this.port+"/getByFiltros?nombre="+usuario.nombre+
          "&login="+usuario.login+"&rol="+usuario.rolId+"&identificacion="+usuario.identificacion);
  }

  public saveUsuario(usuario:UsuarioModel):Observable<ResponseCodeModel>{
    let json = JSON.stringify(usuario);
    console.log(json);
    let params = "json="+json; 
    return this.http.post<ResponseCodeModel>("http://"+this.host+":"+this.port+"/saveOrUpdateUsuario",json);
  }

  
}
