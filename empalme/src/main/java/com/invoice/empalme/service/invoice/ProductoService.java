package com.invoice.empalme.service.invoice;

import java.util.List;

import com.invoice.empalme.model.invoice.Producto;


public interface ProductoService {

	List<Producto> getByAll();

	Producto getProductoById(String productoId);

	void update(Producto proCantidad);

	Producto getByCodigoInterno(String codigoInterno);
}
