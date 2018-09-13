package com.facturacion.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.web.model.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long>{

}
