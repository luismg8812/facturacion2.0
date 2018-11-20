package com.invoice.empalme.service.invoice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.invoice.empalme.dao.invoice.DocumentoDetalleDao;
import com.invoice.empalme.model.invoice.Documento;
import com.invoice.empalme.model.invoice.DocumentoDetalle;
import com.invoice.empalme.service.invoice.DocumentoDetalleService;


@Service
public class DocumentoDetalleServiceImpl implements DocumentoDetalleService {

	@Autowired
	protected DocumentoDetalleDao documentoDetalleDao;

	@Override
	public void saveOrUpdate(DocumentoDetalle docDetalle) {
		documentoDetalleDao.save(docDetalle);
		
	}

	@Override
	public List<DocumentoDetalle> getByDocumentoId(Documento documentoId) {
		DocumentoDetalle detalle= new DocumentoDetalle(); 
		detalle.setDocumentoId(documentoId);
		Example<DocumentoDetalle> example = Example.of(detalle);
		return  documentoDetalleDao.findAll(example);
	}


	

	
}
