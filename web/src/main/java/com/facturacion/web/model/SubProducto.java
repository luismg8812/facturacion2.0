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
@Table(name="SUB_PRODUCTO")
public class SubProducto {

	@Id
	@SequenceGenerator(name="S_SUB_PRODUCTO", sequenceName="S_SUB_PRODUCTO", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_SUB_PRODUCTO")
	@NotNull
	@Column(name="SUB_PRODUCTO_ID")
	private Long subProductoId;
	@NotNull
	
	@Column(name="PRODUCTO_PADRE")
	private Long productoPadre;
	
	@Column(name="PRODUCTO_HIJO")
	private Long productoHijo;
	
	@Column(name="CANTIDAD")
	private Double cantidad;
	
	@Column(name="ESTADO")
	private Long estado;

	public Long getSubProductoId() {
		return subProductoId;
	}

	public void setSubProductoId(Long subProductoId) {
		this.subProductoId = subProductoId;
	}

	public Long getProductoPadre() {
		return productoPadre;
	}

	public void setProductoPadre(Long productoPadre) {
		this.productoPadre = productoPadre;
	}

	public Long getProductoHijo() {
		return productoHijo;
	}

	public void setProductoHijo(Long productoHijo) {
		this.productoHijo = productoHijo;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}	
}
