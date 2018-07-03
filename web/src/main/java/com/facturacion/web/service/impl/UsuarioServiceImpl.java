package com.facturacion.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.UsuarioDao;
import com.facturacion.web.model.Usuario;
import com.facturacion.web.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	protected UsuarioDao usuarioDao;

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}
}
