package com.facturacion.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.facturacion.web.dao.DocumentoDetalleDao;
import com.facturacion.web.model.DocumentoDetalle;
import com.facturacion.web.service.DocumentoDetalleService;

@Service
public class DocumentoDetalleServiceImpl implements DocumentoDetalleService {

	@Autowired
	protected DocumentoDetalleDao documentoDetalleDao;

	@Override
	public void saveOrUpdate(DocumentoDetalle docDetalle) {
		documentoDetalleDao.save(docDetalle);
		
	}

	@Override
	public List<DocumentoDetalle> getByDocumentoId(Long documentoId) {
		DocumentoDetalle detalle= new DocumentoDetalle(); 
		detalle.setDocumentoId(documentoId);
		Example<DocumentoDetalle> example = Example.of(detalle);
		return  documentoDetalleDao.findAll(example);
	}


	

	
}
