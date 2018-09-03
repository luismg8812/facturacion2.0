package com.facturacion.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.web.model.Activacion;

public interface ActivacionDao extends JpaRepository<Activacion, Long>{

}
