package com.client.explorer.model;

import java.util.Date;

public class Cliente {

	private Long clienteId;

	private String nombre;

	private Long codigo;

	private String documento;

	private Long ciudadId;

	private String barrio;

	private String direccion;

	private Long celular;

	private Long fijo;

	private Date fechaRegistro;

	private Long creditoActivo;

	private Long cupoCredito;

	private Double retencion;

	private Long guiaTransporte;

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Long getCiudadId() {
		return ciudadId;
	}

	public void setCiudadId(Long ciudadId) {
		this.ciudadId = ciudadId;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public Long getFijo() {
		return fijo;
	}

	public void setFijo(Long fijo) {
		this.fijo = fijo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Long getCreditoActivo() {
		return creditoActivo;
	}

	public void setCreditoActivo(Long creditoActivo) {
		this.creditoActivo = creditoActivo;
	}

	public Long getCupoCredito() {
		return cupoCredito;
	}

	public void setCupoCredito(Long cupoCredito) {
		this.cupoCredito = cupoCredito;
	}

	public Double getRetencion() {
		return retencion;
	}

	public void setRetencion(Double retencion) {
		this.retencion = retencion;
	}

	public Long getGuiaTransporte() {
		return guiaTransporte;
	}

	public void setGuiaTransporte(Long guiaTransporte) {
		this.guiaTransporte = guiaTransporte;
	}

}
