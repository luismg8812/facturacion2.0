import { DocumentoDetalleModel } from './../MODEL/documentoDetalle.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DocumentoDetalleVoModel } from '../modelVo/documentoDetalleVo.model';

@Injectable({
  providedIn: 'root'
})
export class DocumentoDetalleService {
  private host: string = sessionStorage.getItem("host");
  private port: string = sessionStorage.getItem("port");

  constructor(private http: HttpClient) { }

  public agregarDocumentoDetalle(documentoDetalle: DocumentoDetalleModel): Observable<DocumentoDetalleVoModel> {
    let json = JSON.stringify(documentoDetalle);
    return this.http.post<DocumentoDetalleVoModel>("http://" + this.host + ":" + this.port + "/agregarDocumentoDetalle", json);
  }
}
