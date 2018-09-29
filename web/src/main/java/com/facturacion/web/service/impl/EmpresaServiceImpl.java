package com.facturacion.web.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.EmpresaDao;
import com.facturacion.web.model.Empresa;
import com.facturacion.web.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	protected EmpresaDao empresaDao;

	@Override
	public Empresa getById(Long empresaiId) {
		Optional<Empresa> list = empresaDao.findById(empresaiId);
		return list.get();
	}


	


	
}
