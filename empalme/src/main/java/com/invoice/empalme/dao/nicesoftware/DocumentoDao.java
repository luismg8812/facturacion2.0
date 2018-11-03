package com.invoice.empalme.dao.nicesoftware;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.invoice.empalme.model.nicesoftware.Documento;



public interface DocumentoDao extends JpaRepository<Documento, Long>{
	
	//tipo documento=10 factura de venta 
	@Modifying
    @Transactional
    @Query("select d from Documento d where d.invoice is null and d.tipoDocumentoId.tipoDocumentoId=10")
	List<Documento> getByinvoice();

}
