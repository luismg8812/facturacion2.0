package com.facturacion.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    	
    	return valido;
	}
	
	@RequestMapping(value="/getUsuarioById", method=RequestMethod.GET )
	@CrossOrigin
	public Usuario getUsuarioById(@RequestParam("usuarioId") String usuarioId) {
		return usuarioService.getById(usuarioId);
	}
	
	@RequestMapping(value="/getUsuarioByLogin", method=RequestMethod.GET )
	@CrossOrigin
	public Usuario getUsuarioByLogin(@RequestParam("login") String login) {
		List<Usuario> usuario= usuarioService.getByLogin(login);
		return usuario.isEmpty()?null:usuario.get(0);
	}
}
