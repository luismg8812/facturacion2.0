package com.facturacion.web.service;

import java.util.List;

import com.facturacion.web.model.DocumentoDetalle;

public interface DocumentoDetalleService {

	void saveOrUpdate(DocumentoDetalle docDetalle);

	List<DocumentoDetalle> getByDocumentoId(Long documentoId);
	
	
}
