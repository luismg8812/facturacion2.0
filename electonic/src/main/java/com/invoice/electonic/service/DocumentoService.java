package com.invoice.electonic.service;

import java.util.List;

import com.invoice.electonic.model.Documento;

public interface DocumentoService {

	Documento getById(Long documentoId);
	
	List<Documento> getByEstado(Long estado);

	void saveOrUpdate(Documento documento);
}
