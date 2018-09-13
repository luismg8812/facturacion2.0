import { Observable } from 'rxjs';
import { ConfigService } from './../config.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ClienteModel } from '../model/cliente.model';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  private host: string = sessionStorage.getItem("host");
  private port: string = sessionStorage.getItem("port");

  constructor(private http: HttpClient) {
    console.log("clientes service is working");
   }

   public getClientesAll(): Observable<ClienteModel[]> {
    return this.http.get<ClienteModel[]>("http://" + this.host + ":" + this.port + "/getClientesAll");
  }
   
}
