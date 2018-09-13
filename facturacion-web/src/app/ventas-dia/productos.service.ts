import { ProductoModel } from '../MODEL/producto.model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  private host: string = sessionStorage.getItem("host");
  private port: string = sessionStorage.getItem("port");
  constructor(private http: HttpClient) { }

  public getProductosAll(): Observable<ProductoModel[]> {
    return this.http.get<ProductoModel[]>("http://" + this.host + ":" + this.port + "/getProductosAll");
  }

  public getProductoById(productoId:string): Observable<ProductoModel> {
    return this.http.get<ProductoModel>("http://" + this.host + ":" + this.port + "/getProductoById?productoId="+productoId);
  }

  
}
