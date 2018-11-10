package com.invoice.electonic.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="RECEPTOR")
public class Receptor {

	@Id
	@SequenceGenerator(name="S_RECEPTOR", sequenceName="S_RECEPTOR", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_RECEPTOR")
	@NotNull
	@Column(name="RECEPTOR_ID")
	private Long receptorId;
	
	@Column(name="NOMBRE")
	private String nombre;
		
	@Column(name="IDENTIFICACION")
	private String identificacion;

	public Long getReceptorId() {
		return receptorId;
	}

	public void setReceptorId(Long receptorId) {
		this.receptorId = receptorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
}
