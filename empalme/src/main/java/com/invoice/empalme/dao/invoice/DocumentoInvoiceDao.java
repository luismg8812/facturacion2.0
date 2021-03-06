package com.invoice.empalme.dao.invoice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.invoice.empalme.model.invoice.Documento;
import com.invoice.empalme.model.invoice.Receptor;




public interface DocumentoInvoiceDao extends JpaRepository<Documento, Long>{
	
	@Modifying
    @Transactional
    @Query("select d from Documento d where d.numeroDocumento = :numeroDocumento")
	List<Documento> getByNumber(@Param("numeroDocumento")String numeroDocumento);

}
