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
@Table(name="FIRMA")
public class Firma {
	@Id
	@SequenceGenerator(name="S_FIRMA", sequenceName="S_FIRMA", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_FIRMA")
	@NotNull
	@Column(name="FIRMA_ID")
	private Long firmaId;

	@Column(name="CERTIFICADO")
	private byte[] Certificado;
	
	@Column(name="FIRMA_DIGITAL")
	private String FirmaDigital;

	@Column(name="LLAVE_CERTIFICADO")
	private String Llave_Certificado;
	
	@Column(name="FECHA_DESDE")
	private Date FechaDesde;

	@Column(name="FECHA_HASTA")
	private Date FechaHasta;

	@Column(name="NUMERO_SERIAL")
	private String NumeroSerial;

	@Column(name="SUJETO")
	private String Sujeto;

	@Column(name="IDENTIFICADOR")
	private String Identificador;

	public Long getFirmaId() {
		return firmaId;
	}

	public void setFirmaId(Long firmaId) {
		this.firmaId = firmaId;
	}

	public byte[] getCertificado() {
		return Certificado;
	}

	public void setCertificado(byte[] certificado) {
		Certificado = certificado;
	}

	public String getFirmaDigital() {
		return FirmaDigital;
	}

	public void setFirmaDigital(String firmaDigital) {
		FirmaDigital = firmaDigital;
	}

	public String getLlave_Certificado() {
		return Llave_Certificado;
	}

	public void setLlave_Certificado(String llave_Certificado) {
		Llave_Certificado = llave_Certificado;
	}

	public Date getFechaDesde() {
		return FechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		FechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return FechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		FechaHasta = fechaHasta;
	}

	public String getNumeroSerial() {
		return NumeroSerial;
	}

	public void setNumeroSerial(String numeroSerial) {
		NumeroSerial = numeroSerial;
	}

	public String getSujeto() {
		return Sujeto;
	}

	public void setSujeto(String sujeto) {
		Sujeto = sujeto;
	}

	public String getIdentificador() {
		return Identificador;
	}

	public void setIdentificador(String identificador) {
		Identificador = identificador;
	}
}
