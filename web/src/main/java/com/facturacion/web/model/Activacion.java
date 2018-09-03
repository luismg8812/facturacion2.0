package com.facturacion.web.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ACTIVACION")
public class Activacion {

	@Id
	@SequenceGenerator(name="S_ACTIVACION", sequenceName="S_ACTIVACION", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_ACTIVACION")
	@NotNull
	@Column(name="ACTIVACION_ID")
	private Long activacionId;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="ESTADO")
	private Long estado;
	
	@Column(name="CODIGO")
	private String codigo;
	
	@Column(name="USUARIO_ID")
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
