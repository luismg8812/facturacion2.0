package com.facturacion.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.MenuDao;
import com.facturacion.web.model.Menu;
import com.facturacion.web.model.OpcionUsuario;
import com.facturacion.web.model.Usuario;
import com.facturacion.web.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	protected MenuDao menuDao;


	@Override
	public List<Menu> getByAll() {
		return  menuDao.findAll();
	}


	
}
