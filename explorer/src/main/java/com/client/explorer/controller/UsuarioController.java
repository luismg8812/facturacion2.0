package com.client.explorer.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Path;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.client.explorer.model.Activacion;
import com.client.explorer.model.Rol;
import com.client.explorer.model.Usuario;
import com.client.explorer.utils.BasicConfiguration;
import com.client.explorer.utils.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/client")
@RestController
public class UsuarioController {

	private static Logger log = Logger.getLogger(UsuarioController.class);
	
	@Autowired
	private BasicConfiguration configuration;
	
	protected ObjectMapper objectMapper;
	
	
	@RequestMapping(value="/saveOrUpdateUsuario", method=RequestMethod.POST )
	@CrossOrigin
	public RestResponse saveOrUpdate(@RequestBody String user) throws IOException {
		objectMapper = new ObjectMapper();
		Usuario usuario = this.objectMapper.readValue(user, Usuario.class);
		if(!validar(usuario)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"campos obligatorios no completos");
		}
		//usuarioService.save(usuario);
		return new RestResponse(200);
	}
	
	private boolean validar(Usuario user){
    	boolean valido= true;
    	
    	return valido;
	}
	
	@RequestMapping(value="/getUsuarioById", method=RequestMethod.GET )
	@CrossOrigin
	public Usuario getUsuarioById(@RequestParam("usuarioId") String usuarioId) {
		return new Usuario();
		//return usuarioService.getById(usuarioId);
	}
	
	@RequestMapping(value="/getUsuarioByLogin", method=RequestMethod.GET )
	@CrossOrigin
	public Usuario getUsuarioByLogin(@RequestParam("login") String login) {
		RestTemplate restTemplate = new RestTemplate();
        Usuario quote = restTemplate.getForObject("http://"+ configuration.+ "/random", Usuario.class);
		//List<Usuario> usuario= usuarioService.getByLogin(login);
		//return usuario.isEmpty()?null:usuario.get(0);
		return null;
	}
	
	@RequestMapping(value="/getByFiltros", method=RequestMethod.GET )
	@CrossOrigin
	public List<Usuario> getByFiltros(@RequestParam("nombre") String nombre,@RequestParam("login") String login,
			@RequestParam("rol") String rol,@RequestParam("identificacion") String identificacion) {
		//return usuarioService.getByFiltros(nombre,login,rol,identificacion);
		return null;
	}
	
	@RequestMapping(value="/getRollAll", method=RequestMethod.GET )
	@CrossOrigin
	public List<Rol> getRollAll() {
		//return rolService.getByAll();
		return null;
	}
	
	@RequestMapping(value="/getActivacionAll", method=RequestMethod.GET )
	@CrossOrigin
	public List<Activacion> getActivacionAll() {
		log.info("todas las activaciones");
		//return activacionService.getActivacionAll();}
		return null;
	}
	
	@RequestMapping(value="/getActivacionByUsuario", method=RequestMethod.GET )
	@CrossOrigin
	public List<Activacion> getActivacionByUsuario(@RequestParam("usuarioId") String usuarioId) {
		//return activacionService.getByUsuario(usuarioId);
		return null;
	}
	
	
	
	
}
