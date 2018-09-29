package com.facturacion.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.web.model.Documento;

public interface DocumentoDao extends JpaRepository<Documento, Long>{
	
	

}
