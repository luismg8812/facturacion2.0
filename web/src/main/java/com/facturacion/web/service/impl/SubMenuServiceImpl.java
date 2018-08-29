package com.facturacion.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.MenuDao;
import com.facturacion.web.dao.SubMenuDao;
import com.facturacion.web.model.Menu;
import com.facturacion.web.model.OpcionUsuario;
import com.facturacion.web.model.SubMenu;
import com.facturacion.web.model.Usuario;
import com.facturacion.web.service.MenuService;
import com.facturacion.web.service.SubMenuService;

@Service
public class SubMenuServiceImpl implements SubMenuService {

	@Autowired
	protected SubMenuDao subMenuDao;

	@Override
	public List<SubMenu> geSubMenuByOU(List<String> opcionUsuarioIdList) {
		 
		List<Long> opcionUsuarioId = new ArrayList<>();
		for(String id : opcionUsuarioIdList) {
			opcionUsuarioId.add(Long.valueOf(id));
		}
		return  subMenuDao.findAllById(opcionUsuarioId);
	}



	
}
