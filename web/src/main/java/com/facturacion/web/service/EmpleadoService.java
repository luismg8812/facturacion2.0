package com.facturacion.web.service;

import java.util.List;

import com.facturacion.web.model.Empleado;

public interface EmpleadoService {

	List<Empleado> getByAll();
	
	Empleado getById(String empleadoId);
}
