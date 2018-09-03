package com.facturacion.web.service;

import java.util.List;

import com.facturacion.web.Utils.RestResponse;
import com.facturacion.web.model.Activacion;

public interface ActivacionService {

	List<Activacion> getActivacionAll();

	List<Activacion> getByUsuario(String usuarioId);

	RestResponse guardarActivaciones(String usuarioId, List<String> idActivaciones);
}
