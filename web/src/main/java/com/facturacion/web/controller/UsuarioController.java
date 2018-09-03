package com.facturacion.web.controller;

import java.io.IOException;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.web.Utils.RestResponse;
import com.facturacion.web.model.Activacion;
import com.facturacion.web.model.Rol;
import com.facturacion.web.model.Usuario;
import com.facturacion.web.service.ActivacionService;
import com.facturacion.web.service.RolService;
import com.facturacion.web.service.UsuarioService;
import com.facturacion.web.service.impl.UsuarioServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UsuarioController {

	private static Logger log = Logger.getLogger(UsuarioController.class);
	
	@Autowired
	protected UsuarioService usuarioService;
	
	@Autowired
	protected RolService rolService;
	
	@Autowired
	protected ActivacionService activacionService;
	
	protected ObjectMapper objectMapper;
	
	
	@RequestMapping(value="/saveOrUpdateUsuario", method=RequestMethod.POST )
	@CrossOrigin
	public RestResponse saveOrUpdate(@RequestBody String user) throws IOException {
		objectMapper = new ObjectMapper();
		Usuario usuario = this.objectMapper.readValue(user, Usuario.class);
		if(!validar(usuario)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"campos obligatorios no completos");
		}
		usuarioService.save(usuario);
		return new RestResponse(200);
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
	
	@RequestMapping(value="/getByFiltros", method=RequestMethod.GET )
	@CrossOrigin
	public List<Usuario> getByFiltros(@RequestParam("nombre") String nombre,@RequestParam("login") String login,
			@RequestParam("rol") String rol,@RequestParam("identificacion") String identificacion) {
		return usuarioService.getByFiltros(nombre,login,rol,identificacion);
	}
	
	@RequestMapping(value="/getRollAll", method=RequestMethod.GET )
	@CrossOrigin
	public List<Rol> getRollAll() {
		return rolService.getByAll();
	}
	
	@RequestMapping(value="/getActivacionAll", method=RequestMethod.GET )
	@CrossOrigin
	public List<Activacion> getActivacionAll() {
		log.info("todas las activaciones");
		return activacionService.getActivacionAll();
	}
	
	@RequestMapping(value="/getActivacionByUsuario", method=RequestMethod.GET )
	@CrossOrigin
	public List<Activacion> getActivacionByUsuario(@RequestParam("usuarioId") String usuarioId) {
		return activacionService.getByUsuario(usuarioId);
	}
	
	
	
	
}
