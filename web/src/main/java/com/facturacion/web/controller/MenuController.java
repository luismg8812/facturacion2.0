package com.facturacion.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.web.model.Configuracion;
import com.facturacion.web.model.Menu;
import com.facturacion.web.model.OpcionUsuario;
import com.facturacion.web.model.SubMenu;
import com.facturacion.web.service.ActivacionService;
import com.facturacion.web.service.ConfiguracionService;
import com.facturacion.web.service.MenuService;
import com.facturacion.web.service.OpcionUsuarioService;
import com.facturacion.web.service.SubMenuService;
import com.facturacion.web.utils.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MenuController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2441820156467139694L;

	private static Logger log = Logger.getLogger(MenuController.class);

	@Autowired
	protected MenuService menuService;
	
	@Autowired
	protected OpcionUsuarioService opcionUsuarioService;
	
	@Autowired
	protected SubMenuService subMenuService;
	
	@Autowired
	protected ActivacionService activacionService;
	
	@Autowired
	protected ConfiguracionService configuracionService;
	
	protected ObjectMapper objectMapper;
	
	

	
	@RequestMapping(value="/getMenuAll", method=RequestMethod.GET )
	@CrossOrigin
	public List<Menu> getMenuAll() {		
		return menuService.getByAll();
	}
	
	@RequestMapping(value="/getOpcionUsuarioByMenu", method=RequestMethod.GET )
	@CrossOrigin
	public List<OpcionUsuario> getOpcionUsuarioByMenu(@RequestParam("usuarioId") String usuarioId) {		
		return opcionUsuarioService.getOpcionUsuarioByMenu(usuarioId);
	}
	
	@RequestMapping(value="/geSubMenuByOU", method=RequestMethod.GET )
	@CrossOrigin
	public List<SubMenu> geSubMenuByOU(@RequestParam("ouId") List<String> opcionUsuarioIdList) {		
		return subMenuService.geSubMenuByOU(opcionUsuarioIdList);
	}
	
	@RequestMapping(value="/getRegistrarSession", method=RequestMethod.GET )
	@CrossOrigin
	public void getRegistrarSession(@RequestParam("usuarioId") List<String> usuarioId, HttpSession session) {	
		Configuracion configuracion = configuracionService.getById(1l);		
		session.setAttribute("usuarioId", usuarioId);
		session.setAttribute("configuracion", configuracion);
		
	}
	
	
	
	@RequestMapping(value="/getSubMenuByUsuario", method=RequestMethod.GET )
	@CrossOrigin
	public List<SubMenu> getSubMenuByUsuario(@RequestParam("usuarioId") String usuarioId) {	
		
		log.info("opciones por usuario: ");
		return subMenuService.getSubMenuByUsuario(usuarioId);
	}
	
	@RequestMapping(value="/getSubMenuAll", method=RequestMethod.GET )
	@CrossOrigin
	public List<SubMenu> getSubMenuAll() {		
		return subMenuService.getSubMenuAll();
	}
	
	
	@RequestMapping(value="/guardarRutas", method=RequestMethod.GET )
	@CrossOrigin
	public RestResponse guardarRutas(@RequestParam("usuarioId") String usuarioId,@RequestParam("idSubmenu") List<String> idSubmenu) {		
		return subMenuService.guardarRutas(usuarioId,idSubmenu);
	}
	
	@RequestMapping(value="/guardarActivaciones", method=RequestMethod.GET )
	@CrossOrigin
	public RestResponse guardarActivaciones(@RequestParam("usuarioId") String usuarioId,@RequestParam("idActivaciones") List<String> idActivaciones) {		
		return activacionService.guardarActivaciones(usuarioId,idActivaciones);
	}
	
	
}
