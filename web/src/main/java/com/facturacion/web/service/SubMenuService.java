package com.facturacion.web.service;

import java.util.List;

import com.facturacion.web.model.SubMenu;
import com.facturacion.web.utils.RestResponse;

public interface SubMenuService {
	
	List<SubMenu> geSubMenuByOU(List<String> opcionUsuarioIdList);
	
	List<SubMenu> getSubMenuAll();

	List<SubMenu> getSubMenuByUsuario(String usuarioId);

	RestResponse guardarRutas(String usuarioId, List<String> idSubmenu);

	

}
