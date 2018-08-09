import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {
 private an:any;
  constructor(private http: HttpClient) {
   //this.getJSON().subscribe(data => {
    //  console.log(data)
    //});
    //console.log("an");
    //console.log(this.an);
  }

  public getJSON(): Observable<any> {
    return this.http.get("./assets/config/config.json");
  }
}
