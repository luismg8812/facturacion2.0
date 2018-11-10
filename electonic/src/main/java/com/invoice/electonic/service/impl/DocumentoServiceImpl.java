package com.invoice.electonic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.electonic.dao.DocumentoDao;
import com.invoice.electonic.model.Documento;
import com.invoice.electonic.service.DocumentoService;

@Service
public class DocumentoServiceImpl implements DocumentoService {

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
	public List<Documento> getByEstado(Long estado) {
		return documentoDao.getByEstado(estado);
		
	}
}
