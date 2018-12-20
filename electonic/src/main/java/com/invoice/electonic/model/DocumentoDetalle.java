package com.invoice.electonic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="DOCUMENTO_DETALLE")
public class DocumentoDetalle {
	
	@Id
	@SequenceGenerator(name="S_DOCUMENTO_DETALLE", sequenceName="S_DOCUMENTO_DETALLE", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_DOCUMENTO_DETALLE")
	@NotNull
	@Column(name="DOCUMENTO_DETALLE_ID")
	private Long documentoDetalleId;

	@Column(name="DOCUMENTO_ID")
	private Long documentoId;
	
	@ManyToOne
	@JoinColumn(name="PRODUCTO_ID")
	private Producto producto;
	
	@Column(name = "FECHA_REGISTRO")
	private Date fechaRegistro;
	
	@Column(name = "FECHA_ACTUALIZA")
	private Date fechaActualiza;
	
	@Column(name = "CANTIDAD")
	private Long cantidad;
	
	@Column(name = "CODIGO_IMPUESTO")
	private Long codigoImpuesto;
	
	@Column(name = "PARCIAL")
	private Long parcial;

	public Long getDocumentoDetalleId() {
		return documentoDetalleId;
	}

	public void setDocumentoDetalleId(Long documentoDetalleId) {
		this.documentoDetalleId = documentoDetalleId;
	}

	public Long getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(Long documentoId) {
		this.documentoId = documentoId;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActualiza() {
		return fechaActualiza;
	}

	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public Long getCodigoImpuesto() {
		return codigoImpuesto;
	}

	public void setCodigoImpuesto(Long codigoImpuesto) {
		this.codigoImpuesto = codigoImpuesto;
	}

	public Long getParcial() {
		return parcial;
	}

	public void setParcial(Long parcial) {
		this.parcial = parcial;
	}
}
