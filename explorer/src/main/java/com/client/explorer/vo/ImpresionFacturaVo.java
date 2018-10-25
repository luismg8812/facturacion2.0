package com.client.explorer.vo;

import java.io.Serializable;
import java.util.List;

import com.client.explorer.model.Configuracion;
import com.client.explorer.model.Documento;
import com.client.explorer.model.Empresa;



public class ImpresionFacturaVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3076690247465100987L;
	
	private Documento documentoId;	
	private String nombreProveedor;
	private String nombreUsuario;
	private String nombreCliente;
	private String identificacionCliente;
	private String nombreEmpleado;
	private Empresa empresa;
	private List<DocumentoDetalleVo> documentoDetalleVo;
	private String titulaFactura;
	private String mensaje;
	private Long numeroImpresioes;
	private Configuracion configuracion;
	
	public Configuracion getConfiguracion() {
		return configuracion;
	}

	public void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}
	
	
	public String getIdentificacionCliente() {
		return identificacionCliente;
	}

	public void setIdentificacionCliente(String identificacionCliente) {
		this.identificacionCliente = identificacionCliente;
	}

	public Documento getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(Documento documentoId) {
		this.documentoId = documentoId;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}


	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Long getNumeroImpresioes() {
		return numeroImpresioes;
	}

	public void setNumeroImpresioes(Long numeroImpresioes) {
		this.numeroImpresioes = numeroImpresioes;
	}

	public String getTitulaFactura() {
		return titulaFactura;
	}

	public void setTitulaFactura(String titulaFactura) {
		this.titulaFactura = titulaFactura;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<DocumentoDetalleVo> getDocumentoDetalleVo() {
		return documentoDetalleVo;
	}

	public void setDocumentoDetalleVo(List<DocumentoDetalleVo> documentoDetalleVo) {
		this.documentoDetalleVo = documentoDetalleVo;
	}
}
