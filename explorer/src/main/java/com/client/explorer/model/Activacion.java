package com.client.explorer.model;

public class Activacion {

	
	private Long activacionId;	
	private String nombre;	
	private Long estado;
	private String codigo;
	private Long usuarioId;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getActivacionId() {
		return activacionId;
	}

	public void setActivacionId(Long activacionId) {
		this.activacionId = activacionId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
		
}
