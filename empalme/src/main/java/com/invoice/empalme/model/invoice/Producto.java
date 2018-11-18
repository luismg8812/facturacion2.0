package com.invoice.empalme.model.invoice;


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
	
	@Column(name="COSTO")
	private Double costo;
	
	@Column(name="COSTO_PUBLICO")
	private Double costoPublico;
	
	@Column(name="IVA")
	private Double iva;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="CODIGO_INTERNO")
	private String codigoInterno;

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Double getCostoPublico() {
		return costoPublico;
	}

	public void setCostoPublico(Double costoPublico) {
		this.costoPublico = costoPublico;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
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
