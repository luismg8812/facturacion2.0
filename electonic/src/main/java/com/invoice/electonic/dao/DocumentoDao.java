package com.invoice.electonic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.invoice.electonic.model.Documento;

public interface DocumentoDao extends JpaRepository<Documento, Long>{
	
		@Modifying
	    @Transactional
	    @Query("select d from Documento d where  d.estadoDocumentoId= :estado")
		List<Documento> getByEstado(@Param("estado")Long estado);

}