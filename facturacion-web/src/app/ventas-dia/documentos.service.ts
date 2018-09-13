import { Observable } from 'rxjs';
import { DocumentoModel } from './../model/documento.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DocumentosService {
  private host: string = sessionStorage.getItem("host");
  private port: string = sessionStorage.getItem("port");

  constructor(private http: HttpClient) { }

  public saveDocumento(documento: DocumentoModel): Observable<DocumentoModel> {
    let json = JSON.stringify(documento);
    return this.http.post<DocumentoModel>("http://" + this.host + ":" + this.port + "/saveOrUpdateDocumento", json);
  }

  public getDocumentoById(documentoId:string): Observable<DocumentoModel> {
    return this.http.get<DocumentoModel>("http://" + this.host + ":" + this.port + "/getDocumentoById?documentoId="+documentoId);
  }
}
