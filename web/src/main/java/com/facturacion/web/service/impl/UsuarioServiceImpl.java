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

	@Override
	public List<Usuario> getByFiltros(String nombre, String login, String rol, String idenficacion) {
		Usuario usuario= new Usuario(); 
		if(login!=null && !login.isEmpty()) {
			usuario.setLogin(login);
		}
		if(nombre!=null && !nombre.isEmpty()) {
			usuario.setNombre(nombre);
		}
		if(rol!=null && !rol.isEmpty()) {
			usuario.setRolId(Long.valueOf(rol));
		}
		if(idenficacion!=null && !idenficacion.isEmpty()) {
			usuario.setNombre(idenficacion);
		}
		
		Example<Usuario> example = Example.of(usuario);
		return  usuarioDao.findAll(example);
	}
}
