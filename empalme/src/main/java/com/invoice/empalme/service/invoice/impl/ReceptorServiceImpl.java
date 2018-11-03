package com.invoice.empalme.service.invoice.impl;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.empalme.dao.invoice.ReceptorDao;
import com.invoice.empalme.model.invoice.Receptor;
import com.invoice.empalme.service.invoice.ReceptorService;


@Service
public class ReceptorServiceImpl implements ReceptorService {
	
	private static Logger log = Logger.getLogger(ReceptorServiceImpl.class);

	@Autowired
	protected ReceptorDao receptorDao;

	@Override
	public Receptor save(Receptor receptor) {
		log.info("cliente a guardar:"+receptor);
		return receptorDao.save(receptor);
	}

	@Override
	public Receptor getById(String clienteId) {
		Optional<Receptor> list = receptorDao.findById(Long.valueOf(clienteId));
		return list.get();
	}

	@Override
	public List<Receptor> getByAll() {	
		return  receptorDao.findAll();
	}

	@Override
	public Receptor getByIdentificacion(String identificacion) {
		List<Receptor> list = receptorDao.getByIdentificacion(identificacion);
		return list.isEmpty()?null:list.get(0);
	}
	
}
