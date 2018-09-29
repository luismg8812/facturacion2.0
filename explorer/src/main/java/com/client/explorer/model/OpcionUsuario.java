package com.client.explorer.model;

import java.util.Date;

public class OpcionUsuario {

	private Long opcionUsuarioId;

	private Long subMenuId;

	private Long usuarioId;

	private Long estado;

	private Date fechaRegistro;

	private Date fechaActualiza;

	private String ruta;

	private Long liberarCuadre;

	public Long getOpcionUsuarioId() {
		return opcionUsuarioId;
	}

	public void setOpcionUsuarioId(Long opcionUsuarioId) {
		this.opcionUsuarioId = opcionUsuarioId;
	}

	public Long getSubMenuId() {
		return subMenuId;
	}

	public void setSubMenuId(Long subMenuId) {
		this.subMenuId = subMenuId;
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

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Long getLiberarCuadre() {
		return liberarCuadre;
	}

	public void setLiberarCuadre(Long liberarCuadre) {
		this.liberarCuadre = liberarCuadre;
	}

}
