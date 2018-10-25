package com.facturacion.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.web.model.Empleado;

public interface EmpleadoDao extends JpaRepository<Empleado, Long>{

}
