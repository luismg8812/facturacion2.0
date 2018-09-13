package com.facturacion.web.service;

import java.util.List;

import com.facturacion.web.model.Activacion;
import com.facturacion.web.utils.RestResponse;

public interface ActivacionService {

	List<Activacion> getActivacionAll();

	List<Activacion> getByUsuario(String usuarioId);

	RestResponse guardarActivaciones(String usuarioId, List<String> idActivaciones);
}
