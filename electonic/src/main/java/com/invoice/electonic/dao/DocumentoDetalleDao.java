package com.invoice.electonic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.invoice.electonic.model.DocumentoDetalle;

public interface DocumentoDetalleDao extends JpaRepository<DocumentoDetalle, Long>{

	@Modifying
    @Transactional
    @Query("select d from DocumentoDetalle d where d.documentoId = :valor")
	List<DocumentoDetalle> getByDocumentId(@Param("valor")Long documentId);
}
