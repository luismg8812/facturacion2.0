package com.client.explorer.vo;

import java.util.Date;

public class DocumentoDetalleVo {

	
	private Long documentoDetalleId;	
	private Long documentoId;
	private Long productoId;
	private Date fechaRegistro;
	private Double parcial;
	private Double iva;
	private String nombreProducto;
	private Double cantidad;
	private Double unitario;
	private Double costoUnitario;
	private Double cantidadDevolucion;
	private Double cambioPrecio;
	private String borrar;
	private Double cantidad1;
	private Double cantidad2;
	private Double peso;
	private Long varios;
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
	public Double getParcial() {
		return parcial;
	}
	public void setParcial(Double parcial) {
		this.parcial = parcial;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Double getUnitario() {
		return unitario;
	}
	public void setUnitario(Double unitario) {
		this.unitario = unitario;
	}
	public Double getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(Double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	public Double getCantidadDevolucion() {
		return cantidadDevolucion;
	}
	public void setCantidadDevolucion(Double cantidadDevolucion) {
		this.cantidadDevolucion = cantidadDevolucion;
	}
	public Double getCambioPrecio() {
		return cambioPrecio;
	}
	public void setCambioPrecio(Double cambioPrecio) {
		this.cambioPrecio = cambioPrecio;
	}
	public String getBorrar() {
		return borrar;
	}
	public void setBorrar(String borrar) {
		this.borrar = borrar;
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
	public Double getIva() {
		return iva;
	}
	public void setIva(Double iva) {
		this.iva = iva;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Long getVarios() {
		return varios;
	}
	public void setVarios(Long varios) {
		this.varios = varios;
	}
	
	
	
}

