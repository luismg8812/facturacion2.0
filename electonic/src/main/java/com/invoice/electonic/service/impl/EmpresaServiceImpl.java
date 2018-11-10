package com.invoice.electonic.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.electonic.dao.EmpresaDao;
import com.invoice.electonic.model.Empresa;
import com.invoice.electonic.service.EmpresaService;



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
