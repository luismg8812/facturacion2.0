package com.facturacion.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.ConsecutivoDianDao;
import com.facturacion.web.model.ConsecutivoDian;
import com.facturacion.web.service.ConsecutivoDianService;

@Service
public class ConsecutivoDianServiceImpl implements ConsecutivoDianService {

	@Autowired
	protected ConsecutivoDianDao consecutivoDianDao;


	
	@Override
	public ConsecutivoDian getconsecutivoDian() {
		ConsecutivoDian consecutivoDian = new ConsecutivoDian();
		return consecutivoDianDao.save(consecutivoDian);		
	}

	
}
