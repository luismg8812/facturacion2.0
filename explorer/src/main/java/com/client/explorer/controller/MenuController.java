package com.client.explorer.controller;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.client.explorer.model.Menu;
import com.client.explorer.model.OpcionUsuario;
import com.client.explorer.model.SubMenu;
import com.client.explorer.utils.BasicConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@CrossOrigin
@RequestMapping("/menu")
@RestController
public class MenuController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2441820156467139694L;
	private static final String HTTP = "http://";

	private static Logger log = Logger.getLogger(MenuController.class);

	protected ObjectMapper objectMapper;

	@Autowired
	private BasicConfiguration configuration;

	@RequestMapping(value = "/getMenuAll", method = RequestMethod.GET)
	@CrossOrigin
	public List<Menu> getMenuAll() {
		RestTemplate restTemplate = new RestTemplate();
		String list= restTemplate.getForObject(
				HTTP + configuration.getServerHost() + ":" + configuration.getServerPort() + "/getMenuAll", String.class);	
		Gson gson = new Gson();         
        Type type = new TypeToken<List<Menu>>() {}.getType();
        return gson.fromJson(list, type);
       
	
	}

	@RequestMapping(value = "/getOpcionUsuarioByMenu", method = RequestMethod.GET)
	@CrossOrigin
	public List<OpcionUsuario> getOpcionUsuarioByMenu(@RequestParam("usuarioId") String usuarioId) {
		RestTemplate restTemplate = new RestTemplate();
		String list=  restTemplate.getForObject(HTTP + configuration.getServerHost() + ":"
				+ configuration.getServerPort() + "/getOpcionUsuarioByMenu?usuarioId=" + usuarioId, String.class);
		Gson gson = new Gson();         
        Type type = new TypeToken<List<OpcionUsuario>>() {}.getType();
        return gson.fromJson(list, type);
	}

	@RequestMapping(value = "/geSubMenuByOU", method = RequestMethod.GET)
	@CrossOrigin
	public List<SubMenu> geSubMenuByOU(@RequestParam("ouId") List<String> opcionUsuarioIdList) {
		RestTemplate restTemplate = new RestTemplate();
		String list= restTemplate.getForObject(HTTP + configuration.getServerHost() + ":"
				+ configuration.getServerPort() + "/geSubMenuByOU?ouId=" + opcionUsuarioIdList, String.class);
		Gson gson = new Gson();         
        Type type = new TypeToken<List<OpcionUsuario>>() {}.getType();
        return gson.fromJson(list, type);

	}

	@RequestMapping(value = "/getRegistrarSession", method = RequestMethod.GET)
	@CrossOrigin
	public void getRegistrarSession(@RequestParam("usuarioId") List<String> usuarioId, HttpSession session) {
		// Configuracion configuracion = configuracionService.getById(1l);
		session.setAttribute("usuarioId", usuarioId);
		// session.setAttribute("configuracion", configuracion);

	}

	@RequestMapping(value = "/getSubMenuByUsuario", method = RequestMethod.GET)
	@CrossOrigin
	public List<SubMenu> getSubMenuByUsuario(@RequestParam("usuarioId") String usuarioId) {
		RestTemplate restTemplate = new RestTemplate();
		String list= restTemplate.getForObject(HTTP + configuration.getServerHost() + ":"
				+ configuration.getServerPort() + "/getSubMenuByUsuario?usuarioId=" + usuarioId, String.class);
		Gson gson = new Gson();         
        Type type = new TypeToken<List<SubMenu>>() {}.getType();
        return gson.fromJson(list, type);
	}

	
	@RequestMapping(value = "/getSubMenuAll", method = RequestMethod.GET)
	@CrossOrigin
	public List<SubMenu> getSubMenuAll() {
		RestTemplate restTemplate = new RestTemplate();
		String list= restTemplate.getForObject(
				HTTP + configuration.getServerHost() + ":" + configuration.getServerPort() + "/getSubMenuAll",
				String.class);
		log.info(list);
		Gson gson = new Gson();         
        Type type = new TypeToken<List<SubMenu>>() {}.getType();
        return gson.fromJson(list, type);
	}

	@RequestMapping(value = "/guardarRutas", method = RequestMethod.GET)
	@CrossOrigin
	public String guardarRutas(@RequestParam("usuarioId") String usuarioId,
			@RequestParam("idSubmenu") List<String> idSubmenu) {
		RestTemplate restTemplate = new RestTemplate();
		String url = HTTP + configuration.getServerHost()+":"+configuration.getServerPort()+"/guardarRutas?usuarioId="+usuarioId + "&idSubmenu=" + idSubmenu;
		url =url.replace("[","").replace("]", "").replace(" ", "");	
		objectMapper = new ObjectMapper();
		return restTemplate.getForObject(url, String.class);
		
	}

	@RequestMapping(value = "/guardarActivaciones", method = RequestMethod.GET)
	@CrossOrigin
	public String guardarActivaciones(@RequestParam("usuarioId") String usuarioId,
			@RequestParam("idActivaciones") List<String> idActivaciones) {
		RestTemplate restTemplate = new RestTemplate();
		String url = HTTP + configuration.getServerHost() + ":" + configuration.getServerPort()
		+ "/guardarActivaciones?usuarioId=" + usuarioId + "&idActivaciones=" + idActivaciones;
		url =url.replace("[","").replace("]", "").replace(" ", "");
		return restTemplate.getForObject(url, String.class);
	}

}
