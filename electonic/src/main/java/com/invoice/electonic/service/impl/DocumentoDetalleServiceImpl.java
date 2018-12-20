package com.invoice.electonic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.electonic.dao.DocumentoDetalleDao;
import com.invoice.electonic.model.DocumentoDetalle;
import com.invoice.electonic.service.DocumentoDetalleService;

@Service
public class DocumentoDetalleServiceImpl implements DocumentoDetalleService{

	@Autowired
	protected DocumentoDetalleDao documentoDetalleDao;

	@Override
	public List<DocumentoDetalle> getByDocumentId(Long documentId) {
		return documentoDetalleDao.getByDocumentId(documentId);
	}
}
