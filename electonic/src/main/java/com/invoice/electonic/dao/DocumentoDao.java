package com.invoice.electonic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoice.electonic.model.Documento;

public interface DocumentoDao extends JpaRepository<Documento, Long>{
	
	

}
