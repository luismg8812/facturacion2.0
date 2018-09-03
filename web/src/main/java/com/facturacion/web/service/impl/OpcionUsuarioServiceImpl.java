package com.facturacion.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.OpcionUsuarioDao;
import com.facturacion.web.model.OpcionUsuario;
import com.facturacion.web.service.OpcionUsuarioService;

@Service
public class OpcionUsuarioServiceImpl implements OpcionUsuarioService {

	@Autowired
	protected OpcionUsuarioDao opcionUsuarioDao;

	@Override
	public List<OpcionUsuario> getOpcionUsuarioByMenu( String usuarioId) {
		OpcionUsuario opcionUsuario= new OpcionUsuario(); 
		opcionUsuario.setUsuarioId(Long.valueOf(usuarioId));
		Example<OpcionUsuario> example = Example.of(opcionUsuario);
		return  opcionUsuarioDao.findAll(example);
	}
}
