package com.invoice.electonic.service;

import java.util.List;

import com.invoice.electonic.model.DocumentoDetalle;

public interface DocumentoDetalleService {
	
	List <DocumentoDetalle> getByDocumentId(Long documentId);
}
