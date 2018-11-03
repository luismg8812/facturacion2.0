package com.invoice.empalme.service.nicesoftware;

import java.util.List;

import com.invoice.empalme.model.nicesoftware.Documento;

public interface DocumentoOracleService {

	Documento getById(Long documentoId);
	
	List<Documento> getByinvoice();

	void saveOrUpdate(Documento documento);

}
