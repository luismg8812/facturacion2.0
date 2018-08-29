package com.facturacion.web.service;

import java.util.List;

import com.facturacion.web.model.SubMenu;

public interface SubMenuService {
	
	List<SubMenu> geSubMenuByOU(List<String> opcionUsuarioIdList);

	

}
