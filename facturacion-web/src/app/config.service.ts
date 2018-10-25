import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {
 private an:any;
  constructor(private http: HttpClient) {
  
  }

  public getJSON(): Observable<any> {
    return this.http.get("./assets/config/config.json");
  }

  public getLocalJSON(): Observable<any> {
    console.log("entra a local");
    return this.http.get("C://effectiveSoftware/facturacion/config/localConfig.json");
  }

}
