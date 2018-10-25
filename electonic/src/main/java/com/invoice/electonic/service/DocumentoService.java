package com.invoice.electonic.service;

import com.invoice.electonic.model.Documento;

public interface DocumentoService {

	Documento getById(Long documentoId);

	void saveOrUpdate(Documento documento);

	
}
