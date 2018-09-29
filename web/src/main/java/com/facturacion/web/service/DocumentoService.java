package com.facturacion.web.service;

import com.facturacion.web.model.Documento;

public interface DocumentoService {

	Documento getById(Long documentoId);

	void saveOrUpdate(Documento documento);

	
}
