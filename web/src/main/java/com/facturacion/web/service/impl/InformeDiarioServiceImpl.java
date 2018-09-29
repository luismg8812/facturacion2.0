package com.facturacion.web.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.InformeDiarioDao;
import com.facturacion.web.model.InfoDiario;
import com.facturacion.web.service.InformeDiarioService;

@Service
public class InformeDiarioServiceImpl implements InformeDiarioService{

	@Autowired
	protected InformeDiarioDao informeDiarioDao;

	@Override
	public void saveOrUpdate(InfoDiario InfoDiario) {
		informeDiarioDao.save(InfoDiario);
		
	}

	@Override
	public List<InfoDiario> buscarInfodiarioByFecha(Date fechaInicio, Date fechaFinal) {
		return informeDiarioDao.buscarInfodiarioByFecha(fechaInicio,fechaFinal);
	}

	
}
