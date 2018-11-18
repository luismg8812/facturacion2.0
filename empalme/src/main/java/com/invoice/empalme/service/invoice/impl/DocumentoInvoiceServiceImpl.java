package com.invoice.empalme.service.invoice.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.empalme.dao.invoice.DocumentoInvoiceDao;
import com.invoice.empalme.model.invoice.Documento;
import com.invoice.empalme.service.invoice.DocumentoInvoiceService;





@Service
public class DocumentoInvoiceServiceImpl implements DocumentoInvoiceService {

	@Autowired
	protected DocumentoInvoiceDao documentoDao;

	@Override
	public Documento getById(Long documentoId) {
		Optional<Documento> list = documentoDao.findById(documentoId);
		return list.isPresent()?list.get():null;
	}

	@Override
	public void saveOrUpdate(Documento documento) {
		documentoDao.save(documento);		
	}

	@Override
	public List<Documento> getByNumber(String numeroDocumento) {
		List<Documento> list = documentoDao.getByNumber(numeroDocumento);
		return list;
	}

	@Override
	public void delete(Documento documento) {
		documentoDao.delete(documento);
		
	}

	
}
