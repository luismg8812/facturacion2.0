package com.facturacion.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

	@Override
	public Usuario getById(String usuarioId) {
		Optional<Usuario> list = usuarioDao.findById(Long.valueOf(usuarioId));
		return list.get();
	}

	@Override
	public List<Usuario> getByLogin(String login) {
		Usuario usuario= new Usuario(); 
		usuario.setLogin(login);
		Example<Usuario> example = Example.of(usuario);
		return  usuarioDao.findAll(example);
	}
}
