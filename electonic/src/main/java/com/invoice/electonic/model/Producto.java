package com.invoice.electonic.model;

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
@Table(name="PRODUCTO")
public class Producto {
	@Id
	@SequenceGenerator(name="S_PRODUCTO", sequenceName="S_PRODUCTO", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_PRODUCTO")
	@NotNull
	@Column(name="PRODUCTO_ID")
	private Long productoId;
	
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;
	
	@Column(name="COSTO")
	private Long costo;
	
	@Column(name="COSTO_PUBLICO")
	private Long costoPublico;
	
	@Column(name = "IVA")
	private Long iva;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "CODIGO_INTERNO")
	private String codigoInterno;

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

	public Long getCosto() {
		return costo;
	}

	public void setCosto(Long costo) {
		this.costo = costo;
	}

	public Long getCostoPublico() {
		return costoPublico;
	}

	public void setCostoPublico(Long costoPublico) {
		this.costoPublico = costoPublico;
	}

	public Long getIva() {
		return iva;
	}

	public void setIva(Long iva) {
		this.iva = iva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoInterno() {
		return codigoInterno;
	}

	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
	}
}
