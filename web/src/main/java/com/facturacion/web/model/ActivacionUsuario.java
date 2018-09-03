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
@Table(name="ACTIVACION_USUARIO")
public class ActivacionUsuario {

	@Id
	@SequenceGenerator(name="S_ACTIVACION_USUARIO", sequenceName="S_ACTIVACION_USUARIO", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_ACTIVACION_USUARIO")
	@NotNull
	@Column(name="ACTIVACION_USUARIO_ID")
	private Long activacionUsuarioId;
	
	
	@Column(name="ACTIVACION_ID")
	private Long activacionId;
	
	
	@Column(name="USUARIO_ID")
	private Long usuarioId;
	
	@Column(name="ESTADO")
	private Long estado;
	
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;
	
	@Column(name="FECHA_ACTUALIZA")
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
