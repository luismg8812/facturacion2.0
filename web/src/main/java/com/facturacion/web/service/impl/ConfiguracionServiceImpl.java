package com.facturacion.web.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.ConfiguracionDao;
import com.facturacion.web.model.Configuracion;
import com.facturacion.web.service.ConfiguracionService;

@Service
public class ConfiguracionServiceImpl implements ConfiguracionService {

	@Autowired
	protected ConfiguracionDao configuracionDao;

	@Override
	public Configuracion getById(Long configuracionId) {
		Optional<Configuracion> list = configuracionDao.findById(configuracionId);
		return list.get();
	}


	


	
}
