package com.client.explorer.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RequestMapping("/client")
@RestController
public class UsuarioController {

	private static Logger log = Logger.getLogger(UsuarioController.class);
	private static final String HTTP = "http://";
	
	@Autowired
	private BasicConfiguration configuration;
	
	protected ObjectMapper objectMapper;
	
	
	@RequestMapping(value="/saveOrUpdateUsuario", method=RequestMethod.POST )
	@CrossOrigin
	public RestResponse saveOrUpdate(@RequestBody String user) throws IOException {
		objectMapper = new ObjectMapper();
		Usuario usuario = this.objectMapper.readValue(user, Usuario.class);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Usuario> requestBody = new HttpEntity<>(usuario);
		restTemplate.postForObject(HTTP+ configuration.getServerHost()+":"+configuration.getServerPort()+ "/saveOrUpdateUsuario",requestBody, Usuario.class);
		return new RestResponse(200);
	}
	
	
	
	@RequestMapping(value="/getUsuarioById", method=RequestMethod.GET )
	@CrossOrigin
	public Usuario getUsuarioById(@RequestParam("usuarioId") String usuarioId) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(HTTP+ configuration.getServerHost()+":"+configuration.getServerPort()+ "/getUsuarioById?usuarioId="+usuarioId, Usuario.class);
	}
	
	@RequestMapping(value="/getUsuarioByLogin", method=RequestMethod.GET )
	@CrossOrigin
	public Usuario getUsuarioByLogin(@RequestParam("login") String login) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(HTTP+ configuration.getServerHost()+":"+configuration.getServerPort()+ "/getUsuarioByLogin?login="+login, Usuario.class);	
	}
	
	@RequestMapping(value="/getByFiltros", method=RequestMethod.GET )
	@CrossOrigin
	public List<Usuario> getByFiltros(@RequestParam("nombre") String nombre,@RequestParam("login") String login,
			@RequestParam("rol") String rol,@RequestParam("identificacion") String identificacion) {
		RestTemplate restTemplate = new RestTemplate();
		String list= restTemplate.getForObject(
				HTTP + configuration.getServerHost() + ":" + configuration.getServerPort() + "/getByFiltros?nombre=" + nombre + "&login=" + login+ "&rol=" + rol + "&identificacion="+identificacion,
				String.class);
		log.info(list);
		Gson gson = new Gson();         
        Type type = new TypeToken<List<Usuario>>() {}.getType();
        return gson.fromJson(list, type);		
	}
	
	@RequestMapping(value="/getRolAll", method=RequestMethod.GET )
	@CrossOrigin
	public List<Rol> getRollAll() {
		RestTemplate restTemplate = new RestTemplate();
		String list = restTemplate.getForObject(
				HTTP + configuration.getServerHost() + ":" + configuration.getServerPort() + "/getRollAll",
				String.class);
		log.info(list);
		Gson gson = new Gson();
		Type type = new TypeToken<List<Rol>>() {
		}.getType();
		return gson.fromJson(list, type);
	}
	
	@RequestMapping(value="/getActivacionAll", method=RequestMethod.GET )
	@CrossOrigin
	public List<Activacion> getActivacionAll() {
		log.info("todas las activaciones");
		RestTemplate restTemplate = new RestTemplate();
		String list= restTemplate.getForObject(
				HTTP + configuration.getServerHost() + ":" + configuration.getServerPort() + "/getActivacionAll",
				String.class);
		log.info(list);
		Gson gson = new Gson();         
        Type type = new TypeToken<List<Activacion>>() {}.getType();
        return gson.fromJson(list, type);
	}
	
	@RequestMapping(value="/getActivacionByUsuario", method=RequestMethod.GET )
	@CrossOrigin
	public List<Activacion> getActivacionByUsuario(@RequestParam("usuarioId") String usuarioId) {
		RestTemplate restTemplate = new RestTemplate();
		String list= restTemplate.getForObject(
				HTTP + configuration.getServerHost() + ":" + configuration.getServerPort() + "/getActivacionByUsuario?usuarioId="+usuarioId,
				String.class);
		log.info(list);
		Gson gson = new Gson();         
        Type type = new TypeToken<List<Activacion>>() {}.getType();
        return gson.fromJson(list, type);
	}
	
	
	
	
}
