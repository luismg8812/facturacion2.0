package com.client.explorer.model;



import java.util.Date;


public class ActivacionUsuario {

	
	private Long activacionUsuarioId;
	
	
	
	private Long activacionId;
	
	
	
	private Long usuarioId;
	
	
	private Long estado;
	
	
	private Date fechaRegistro;
	
	
	private Date fechaActualiza;

	public Long getActivacionUsuarioId() {
		return activacionUsuarioId;
	}

	public void setActivacionUsuarioId(Long activacionUsuarioId) {
		this.activacionUsuarioId = activacionUsuarioId;
	}

	public Long getActivacionId() {
		return activacionId;
	}

	public void setActivacionId(Long activacionId) {
		this.activacionId = activacionId;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
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
	
}
