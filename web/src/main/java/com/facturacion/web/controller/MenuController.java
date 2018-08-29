package com.facturacion.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.web.model.Menu;
import com.facturacion.web.model.OpcionUsuario;
import com.facturacion.web.model.SubMenu;
import com.facturacion.web.service.MenuService;
import com.facturacion.web.service.OpcionUsuarioService;
import com.facturacion.web.service.SubMenuService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MenuController {

	@Autowired
	protected MenuService menuService;
	
	@Autowired
	protected OpcionUsuarioService opcionUsuarioService;
	
	@Autowired
	protected SubMenuService subMenuService;
	
	protected ObjectMapper objectMapper;
	
	

	
	@RequestMapping(value="/getMenuAll", method=RequestMethod.GET )
	@CrossOrigin
	public List<Menu> getMenuAll() {		
		return menuService.getByAll();
	}
	
	@RequestMapping(value="/getOpcionUsuarioByMenu", method=RequestMethod.GET )
	@CrossOrigin
	public List<OpcionUsuario> getOpcionUsuarioByMenu(@RequestParam("menuId") String menuId,@RequestParam("usuarioId") String usuarioId) {		
		return opcionUsuarioService.getOpcionUsuarioByMenu(menuId,usuarioId);
	}
	
	@RequestMapping(value="/geSubMenuByOU", method=RequestMethod.GET )
	@CrossOrigin
	public List<SubMenu> geSubMenuByOU(@RequestParam("ouId") List<String> opcionUsuarioIdList) {		
		return subMenuService.geSubMenuByOU(opcionUsuarioIdList);
	}
}
