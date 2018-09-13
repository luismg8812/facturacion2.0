package com.facturacion.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturacion.web.model.Documento;

public interface DocumentoDao extends JpaRepository<Documento, Long>{

}
