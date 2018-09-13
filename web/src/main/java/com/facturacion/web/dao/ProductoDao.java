package com.facturacion.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.web.model.Producto;

public interface ProductoDao extends JpaRepository<Producto, Long>{

}
