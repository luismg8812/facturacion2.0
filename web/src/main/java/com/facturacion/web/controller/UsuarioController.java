package com.facturacion.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.web.Utils.RestResponse;
import com.facturacion.web.model.Usuario;
import com.facturacion.web.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UsuarioController {

	@Autowired
	protected UsuarioService usuarioService;
	
	protected ObjectMapper objectMapper;
	
	@RequestMapping(value="/saveOrUpdateUsuario", method=RequestMethod.POST )
	public RestResponse saveOrUpdate(@RequestBody String user) throws IOException {
		objectMapper = new ObjectMapper();
		Usuario usuario = this.objectMapper.readValue(user, Usuario.class);
		if(!validar(usuario)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"campos obligatorios no completos");
		}
		usuarioService.save(usuario);
		return null;
	}
	
	private boolean validar(Usuario user){
    	boolean valido= true;
    	if (user.getRolId() == null ||user.getRolId()==0l) {
            //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!, El Rol es obligatorio",""));
            valido = false;         
        }
    	if (user.getClave() == null || user.getClave().equals("")) {
            //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!, La Clave es obligatoria",""));
            valido = false;         
        }
    	if (user.getLogin() == null || user.getLogin().equals("")) {
            //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!, El login es obligatorio",""));
            valido = false;         
//        }else{
//        	Usuario u=usuarioService.getByName(getLogin().toUpperCase());
//        	if(u!=null){
//        		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!, El Usuario ya existe",""));
//                valido = false;         
//        	}
//        	//hacer la parte de que busca usaurio por login
        }
    	return valido;
	}
}
