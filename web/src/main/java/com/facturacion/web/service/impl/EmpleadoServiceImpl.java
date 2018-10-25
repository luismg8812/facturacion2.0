package com.facturacion.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.EmpleadoDao;
import com.facturacion.web.model.Empleado;
import com.facturacion.web.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	protected EmpleadoDao empleadoDao;


	@Override
	public List<Empleado> getByAll() {
		return  empleadoDao.findAll();
	}
	
	@Override
	public Empleado getById(String empleadoId) {
		Optional<Empleado> list = empleadoDao.findById(Long.valueOf(empleadoId));
		return list.get();
	}

	
}
