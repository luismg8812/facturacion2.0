import { ConfigService } from './../config.service';
import { LoginService } from '../login/login.service';
import { Component, OnInit } from '@angular/core';
import { UsuarioModel } from '../model/usuario.model';
import { Router } from '@angular/router';
import { MenuService } from '../menu/menu.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public usuario: UsuarioModel;
  public user: UsuarioModel;
  constructor(private loginService: LoginService, private router: Router,private configService:ConfigService,
              private menuService:MenuService) { }

  ngOnInit() {
    this.usuario = new UsuarioModel();
    //se lee las configuración del programa
    this.configService.getJSON().subscribe(data=>{     
      sessionStorage.setItem("host",data.host);  
      sessionStorage.setItem("port",data.port);  
        
    });
    // se lee las configuraciones locales
    this.configService.getIpAddress().subscribe(data => {
      console.log(data);
    });
   // this.configService.getLocalJSON().subscribe(data=>{
    //  sessionStorage.setItem("printer",data.printer);
    //  console.log("impresora seleccionada:"+data.printer);
   // });
  }

  public loginUsuario(): void {
    if (this.usuario.nombre == undefined || this.usuario.clave == undefined) {
      alert("Usuario y contraseña requerida");
      return;
    }
    this.getByUsuarioId();

  }

  private getByUsuarioId(): void {
    //console.log(login); 

    this.loginService.getByLogin(this.usuario.nombre).subscribe(res => {
      this.user = res;
      //console.log(this.user);
      if (this.user == null) {
        alert("Usuario o contraseña incorrectos");        
        return;
      }
      if (this.user.clave != this.usuario.clave) {
        alert("Usuario o contraseña incorrectos");        
        return;
      }
      
      
      sessionStorage.setItem("userLogin",this.user.login);
      sessionStorage.setItem("usuarioId",this.user.usuarioId);
      this.menuService.getRegistrarSession(this.user.usuarioId).subscribe(res => {
        
      });

      this.router.navigate(['/menu']);
    });

  }

}
