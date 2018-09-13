package com.facturacion.web.service;

import java.util.List;

import com.facturacion.web.model.Producto;

public interface ProductoService {

	List<Producto> getByAll();

	Producto getProductoById(String productoId);

	void update(Producto proCantidad);
}
