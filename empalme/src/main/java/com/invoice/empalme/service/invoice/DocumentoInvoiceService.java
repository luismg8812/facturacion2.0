package com.invoice.empalme.service.invoice;

import java.util.List;

import com.invoice.empalme.model.invoice.Documento;



public interface DocumentoInvoiceService {

	Documento getById(Long documentoId);

	void saveOrUpdate(Documento documento);

}
