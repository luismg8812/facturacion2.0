package com.invoice.empalme.vo;

import java.util.List;

import com.invoice.empalme.model.invoice.Documento;
import com.invoice.empalme.model.nicesoftware.DocumentoDetalle;

public class DocumentoDeltaVo {
	
	private Documento documentoId;
	private List<DocumentoDetalle> documentoDetalleId;
	
	public Documento getDocumentoId() {
		return documentoId;
	}
	public void setDocumentoId(Documento documentoId) {
		this.documentoId = documentoId;
	}
	public List<DocumentoDetalle> getDocumentoDetalleId() {
		return documentoDetalleId;
	}
	public void setDocumentoDetalleId(List<DocumentoDetalle> documentoDetalleId) {
		this.documentoDetalleId = documentoDetalleId;
	}
	

}
