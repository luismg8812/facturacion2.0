import { Injectable } from '@angular/core';
import { HttpClient}  from '@angular/common/http';
import { UsuarioModel } from '../model/usuario.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http:HttpClient) { 
    console.log("servicio funcionando");
  }

  public getByUsuarioId():Observable<UsuarioModel>{
    return this.http.get<UsuarioModel>("http://localhost:8080/getUsuarioById?usuarioId=1");
  }

  public getByLogin(login:string):Observable<UsuarioModel>{
    return this.http.get<UsuarioModel>("http://localhost:8080/getUsuarioByLogin?login="+login);
  }

  getConfig(){
    
  }
  
}
