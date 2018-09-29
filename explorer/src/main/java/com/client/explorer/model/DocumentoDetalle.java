package com.client.explorer.model;





import java.util.Date;


public class DocumentoDetalle {

	
	private Long documentoDetalleId;
	
	
	private Long documentoId;
	
	
	private Long productoId;
	
	
	private Date fechaRegistro;
	
	
	private Date fechaActualiza;
	
	
	private Long estado;
	
	
	private Double parcial;
	
	
	private Double unitario;
	
	
	private Long s1;
	
	
	private Long s2;
	
	
	private Double cantidad1;
	
	
	private Double cantidad2;
	

	private Integer impresoComanda;

	public Long getDocumentoDetalleId() {
		return documentoDetalleId;
	}
	
	
	private Double cantidad;

	public Long getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(Long documentoId) {
		this.documentoId = documentoId;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
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

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Double getParcial() {
		return parcial;
	}

	public void setParcial(Double parcial) {
		this.parcial = parcial;
	}

	public Long getS1() {
		return s1;
	}

	public void setS1(Long s1) {
		this.s1 = s1;
	}

	public Long getS2() {
		return s2;
	}

	public void setS2(Long s2) {
		this.s2 = s2;
	}

	public Double getCantidad1() {
		return cantidad1;
	}

	public void setCantidad1(Double cantidad1) {
		this.cantidad1 = cantidad1;
	}

	public Double getCantidad2() {
		return cantidad2;
	}

	public void setCantidad2(Double cantidad2) {
		this.cantidad2 = cantidad2;
	}

	public Integer getImpresoComanda() {
		return impresoComanda;
	}

	public void setImpresoComanda(Integer impresoComanda) {
		this.impresoComanda = impresoComanda;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public void setDocumentoDetalleId(Long documentoDetalleId) {
		this.documentoDetalleId = documentoDetalleId;
	}

	public Double getUnitario() {
		return unitario;
	}

	public void setUnitario(Double unitario) {
		this.unitario = unitario;
	}	
		
}
