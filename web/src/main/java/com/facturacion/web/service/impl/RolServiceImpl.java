package com.facturacion.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.RolDao;
import com.facturacion.web.model.Rol;
import com.facturacion.web.service.RolService;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	protected RolDao rolDao;


	@Override
	public List<Rol> getByAll() {
		return  rolDao.findAll();
	}


	
}
