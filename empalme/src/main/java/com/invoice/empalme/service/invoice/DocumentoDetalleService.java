package com.invoice.empalme.service.invoice;

import java.util.List;

import com.invoice.empalme.model.invoice.Documento;
import com.invoice.empalme.model.invoice.DocumentoDetalle;


public interface DocumentoDetalleService {

	void saveOrUpdate(DocumentoDetalle docDetalle);

	List<DocumentoDetalle> getByDocumentoId(Documento documentoId);
	
	
}
