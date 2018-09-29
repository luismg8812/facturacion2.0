package com.facturacion.web.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.DocumentoDao;
import com.facturacion.web.model.Documento;
import com.facturacion.web.service.DocumentoService;

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

	
}
