package com.facturacion.web.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="OPCION_USUARIO")
public class OpcionUsuario {

	@Id
	@SequenceGenerator(name="S_OPCION_USUARIO", sequenceName="S_OPCION_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_OPCION_USUARIO")
	@NotNull
	@Column(name="OPCION_USUARIO_ID")
	private Long opcionUsuarioId;
	
	
	@Column(name="MENU_ID")
	private Long menuId;
	
	
	@Column(name="SUB_MENU_ID")
	private Long subMenuId;
	
	
	@Column(name="USUARIO_ID")
	private Long usuarioId;
	
	@Column(name="ESTADO")
	private Long estado;
	
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;
	
	@Column(name="FECHA_ACTUALIZA")
	private Date fechaActualiza;
	
	@Column(name="RUTA")
	private String ruta;
	
	@Column(name="LIBERAR_CUADRE")
	private Long liberarCuadre;

	public Long getOpcionUsuarioId() {
		return opcionUsuarioId;
	}

	public void setOpcionUsuarioId(Long opcionUsuarioId) {
		this.opcionUsuarioId = opcionUsuarioId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
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
