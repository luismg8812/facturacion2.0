package com.facturacion.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.ProductoDao;
import com.facturacion.web.model.Producto;
import com.facturacion.web.service.ProductoService;


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


	
}
