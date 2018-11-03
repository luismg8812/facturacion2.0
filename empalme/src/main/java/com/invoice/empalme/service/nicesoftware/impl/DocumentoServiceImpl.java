package com.invoice.empalme.service.nicesoftware.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.empalme.dao.nicesoftware.DocumentoDao;
import com.invoice.empalme.model.nicesoftware.Documento;
import com.invoice.empalme.service.nicesoftware.DocumentoOracleService;



@Service
public class DocumentoServiceImpl implements DocumentoOracleService {

	@Autowired
	protected DocumentoDao documentoDao;

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
	public List<Documento> getByinvoice() {
		return documentoDao.getByinvoice();
		
	}
	
}
