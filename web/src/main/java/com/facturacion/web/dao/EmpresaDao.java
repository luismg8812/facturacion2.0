package com.facturacion.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.web.model.Empresa;

public interface EmpresaDao extends JpaRepository<Empresa, Long>{

}
