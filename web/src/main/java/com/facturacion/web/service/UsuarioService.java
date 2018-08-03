package com.facturacion.web.service;

import java.util.List;

import com.facturacion.web.model.Usuario;

public interface UsuarioService {

	Usuario save(Usuario usuario);

	Usuario getById(String usuarioId);

	List<Usuario> getByLogin(String login);

}
