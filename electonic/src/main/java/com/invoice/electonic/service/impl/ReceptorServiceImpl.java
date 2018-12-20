package com.invoice.electonic.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.electonic.dao.ReceptorDao;
import com.invoice.electonic.model.Receptor;
import com.invoice.electonic.service.ReceptorService;

@Service
public class ReceptorServiceImpl implements ReceptorService{

	@Autowired
	protected ReceptorDao receptorDao;
	
	@Override
	public Receptor getById(Long receptorId) {
		Optional<Receptor> list = receptorDao.findById(receptorId);
		return list.get();
	}
}
