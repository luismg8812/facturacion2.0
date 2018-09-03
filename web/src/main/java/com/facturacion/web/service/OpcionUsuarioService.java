package com.facturacion.web.service;

import java.util.List;

import com.facturacion.web.model.OpcionUsuario;

public interface OpcionUsuarioService {

	List<OpcionUsuario> getOpcionUsuarioByMenu( String usuarioId);
}
