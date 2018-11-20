package com.invoice.empalme.dao.invoice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoice.empalme.model.invoice.DocumentoDetalle;



public interface DocumentoDetalleDao extends JpaRepository<DocumentoDetalle, Long>{

}
