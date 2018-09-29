package com.client.explorer.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.client.explorer.model.Configuracion;
import com.client.explorer.model.Menu;
import com.client.explorer.model.OpcionUsuario;
import com.client.explorer.model.SubMenu;
import com.client.explorer.utils.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MenuController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2441820156467139694L;

	private static Logger log = Logger.getLogger(MenuController.class);

	
	
	protected ObjectMapper objectMapper;
	
	

	
	@RequestMapping(value="/getMenuAll", method=RequestMethod.GET )
	@CrossOrigin
	public List<Menu> getMenuAll() {		
		//return menuService.getByAll();
		return null;
	}
	
	@RequestMapping(value="/getOpcionUsuarioByMenu", method=RequestMethod.GET )
	@CrossOrigin
	public List<OpcionUsuario> getOpcionUsuarioByMenu(@RequestParam("usuarioId") String usuarioId) {		
//		return opcionUsuarioService.getOpcionUsuarioByMenu(usuarioId);
		return null;
	}
	
	@RequestMapping(value="/geSubMenuByOU", method=RequestMethod.GET )
	@CrossOrigin
	public List<SubMenu> geSubMenuByOU(@RequestParam("ouId") List<String> opcionUsuarioIdList) {		
//		return subMenuService.geSubMenuByOU(opcionUsuarioIdList);
		return null;
	}
	
	@RequestMapping(value="/getRegistrarSession", method=RequestMethod.GET )
	@CrossOrigin
	public void getRegistrarSession(@RequestParam("usuarioId") List<String> usuarioId, HttpSession session) {	
		//Configuracion configuracion = configuracionService.getById(1l);		
		session.setAttribute("usuarioId", usuarioId);
		//session.setAttribute("configuracion", configuracion);
		
	}
	
	
	
	@RequestMapping(value="/getSubMenuByUsuario", method=RequestMethod.GET )
	@CrossOrigin
	public List<SubMenu> getSubMenuByUsuario(@RequestParam("usuarioId") String usuarioId) {		
		//return subMenuService.getSubMenuByUsuario(usuarioId);
		return null;
	}
	
	@RequestMapping(value="/getSubMenuAll", method=RequestMethod.GET )
	@CrossOrigin
	public List<SubMenu> getSubMenuAll() {		
		//return subMenuService.getSubMenuAll();
		return null;
	}
	
	
	@RequestMapping(value="/guardarRutas", method=RequestMethod.GET )
	@CrossOrigin
	public RestResponse guardarRutas(@RequestParam("usuarioId") String usuarioId,@RequestParam("idSubmenu") List<String> idSubmenu) {		
		//return subMenuService.guardarRutas(usuarioId,idSubmenu);
		return null;
	}
	
	@RequestMapping(value="/guardarActivaciones", method=RequestMethod.GET )
	@CrossOrigin
	public RestResponse guardarActivaciones(@RequestParam("usuarioId") String usuarioId,@RequestParam("idActivaciones") List<String> idActivaciones) {		
		//return activacionService.guardarActivaciones(usuarioId,idActivaciones);
		return null;
	}
	
	
}
