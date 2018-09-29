package com.client.explorer.model;

public class SubProducto {

	
	private Long subProductoId;
	
	
	private Long productoPadre;
	
	
	private Long productoHijo;
	
	
	private Double cantidad;
	
	
	private Long estado;

	public Long getSubProductoId() {
		return subProductoId;
	}

	public void setSubProductoId(Long subProductoId) {
		this.subProductoId = subProductoId;
	}

	public Long getProductoPadre() {
		return productoPadre;
	}

	public void setProductoPadre(Long productoPadre) {
		this.productoPadre = productoPadre;
	}

	public Long getProductoHijo() {
		return productoHijo;
	}

	public void setProductoHijo(Long productoHijo) {
		this.productoHijo = productoHijo;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}	
}
