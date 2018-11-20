package com.invoice.empalme.service.invoice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.empalme.dao.invoice.ProductoDao;
import com.invoice.empalme.model.invoice.Producto;
import com.invoice.empalme.service.invoice.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	protected ProductoDao productoDao;


	@Override
	public List<Producto> getByAll() {
		return  productoDao.findAll();
	}


	@Override
	public Producto getProductoById(String productoId) {
		Optional<Producto> list = productoDao.findById(Long.valueOf(productoId));
		return list.get();
	}


	@Override
	public void update(Producto proCantidad) {
		productoDao.save(proCantidad);
		
	}


	@Override
	public Producto getByCodigoInterno(String codigoInterno) {		
		List<Producto> list = productoDao.getByCodigoInterno(codigoInterno);
		return list.isEmpty()?null:list.get(0);
	}


	
}
