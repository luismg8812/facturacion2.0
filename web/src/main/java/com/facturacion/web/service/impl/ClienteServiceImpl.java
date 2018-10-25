package com.facturacion.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.ClienteDao;
import com.facturacion.web.model.Cliente;
import com.facturacion.web.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private static Logger log = Logger.getLogger(ClienteServiceImpl.class);

	@Autowired
	protected ClienteDao clienteDao;

	@Override
	public Cliente save(Cliente cliente) {
		log.info("cliente a guardar:"+cliente);
		return clienteDao.save(cliente);
	}

	@Override
	public Cliente getById(String clienteId) {
		Optional<Cliente> list = clienteDao.findById(Long.valueOf(clienteId));
		return list.get();
	}

	@Override
	public List<Cliente> getByAll() {
		
		return  clienteDao.findAll();
	}
	
}
