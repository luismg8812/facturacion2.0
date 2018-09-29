package com.facturacion.web.service;

import java.util.Date;
import java.util.List;

import com.facturacion.web.model.InfoDiario;

public interface InformeDiarioService {

	void saveOrUpdate(InfoDiario infoDiario);

	List<InfoDiario> buscarInfodiarioByFecha(Date fechaInicio, Date fechaFinal);

	
}
