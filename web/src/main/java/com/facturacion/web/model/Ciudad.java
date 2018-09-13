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
@Table(name="CIUDAD")
public class Ciudad {

	@Id
	@SequenceGenerator(name="S_CIUDAD", sequenceName="S_CIUDAD", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_CIUDAD")
	@NotNull
	@Column(name="CIUDAD_ID")
	private Long ciudadId;
	@NotNull
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="ESTADO")
	private Long estado;
	
	@Column(name="DEPARTAMENTO_ID")
	private Long departamentoId;

	public Long getCiudadId() {
		return ciudadId;
	}

	public void setCiudadId(Long ciudadId) {
		this.ciudadId = ciudadId;
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

	public Long getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Long departamentoId) {
		this.departamentoId = departamentoId;
	}


	
	
}
