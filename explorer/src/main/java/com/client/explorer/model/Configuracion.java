package com.client.explorer.model;



import java.io.Serializable;
import java.util.Date;


public class Configuracion implements Serializable {

	
	private static final long serialVersionUID = 2581576753037884798L;

	
	
	private Long configuracionId;
	
	
	private String demo;
	
	
	private Date fechaIngreso;
	
	
	private Long server;
	
	
	private Long fechaCombinada;
	
	
	private Long impresionContinua;
	
	
	private Long nombreProductoLargo;

	
	private Long guardarFacturas;
	
	
	private Long gramera;
	
	
	private Long numImpresion;
	
	public Long getNumImpresion() {
		return numImpresion;
	}

	public void setNumImpresion(Long numImpresion) {
		this.numImpresion = numImpresion;
	}

	public Long getConfiguracionId() {
		return configuracionId;
	}

	public void setConfiguracionId(Long configuracionId) {
		this.configuracionId = configuracionId;
	}

	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Long getServer() {
		return server;
	}

	public void setServer(Long server) {
		this.server = server;
	}

	public Long getFechaCombinada() {
		return fechaCombinada;
	}

	public void setFechaCombinada(Long fechaCombinada) {
		this.fechaCombinada = fechaCombinada;
	}

	public Long getImpresionContinua() {
		return impresionContinua;
	}

	public void setImpresionContinua(Long impresionContinua) {
		this.impresionContinua = impresionContinua;
	}

	public Long getNombreProductoLargo() {
		return nombreProductoLargo;
	}

	public void setNombreProductoLargo(Long nombreProductoLargo) {
		this.nombreProductoLargo = nombreProductoLargo;
	}

	public Long getGuardarFacturas() {
		return guardarFacturas;
	}

	public void setGuardarFacturas(Long guardarFacturas) {
		this.guardarFacturas = guardarFacturas;
	}

	public Long getGramera() {
		return gramera;
	}

	public void setGramera(Long gramera) {
		this.gramera = gramera;
	}
	
	
}
