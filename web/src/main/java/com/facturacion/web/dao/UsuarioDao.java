package com.facturacion.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.web.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{

}
