package com.invoice.empalme.model.invoice;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="DOCUMENTO")
public class Documento {

	@Id
	@SequenceGenerator(name="S_DOCUMENTO", sequenceName="S_DOCUMENTO", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_DOCUMENTO")
	@NotNull
	@Column(name="DOCUMENTO_ID")
	private Long documentoId;
	
	@Column(name="TIPO_DOCUMENTO_ID")
	private Long tipoDocumentoId;
	
	
	@ManyToOne
	@JoinColumn(name="RECEPTOR_ID")
	private Receptor receptorId;
	
	
	
	@Column(name="FECHA_REGISTRO")
	private Date fechaRegistro;
	
	@Column(name="FECHA_ACTUALIZA")
	private Date fechaActualiza;
	
	@Column(name="NUMERO_DOCUMENTO")
	private String numeroDocumento;
	
	
	@Column(name="TOTAL")
	private Double total;
	
	@Column(name="EXCENTO")
	private Double excento;
	
	@Column(name="GRAVADO")
	private Double gravado;
	
	@Column(name="IVA")
	private Double iva;
	
	@Column(name="IVA_19")
	private Double iva19;
	
	@Column(name="IVA_5")
	private Double iva5;
	
	@Column(name="BASE_19")
	private Double base19;
	
	@Column(name="BASE_5")
	private Double base5;
	
		
	@Column(name="PREFIJO")
	private String prefijo;
	
	public Long getDocumentoId() {
		return documentoId;
	}

	public Long getTipoDocumentoId() {
		return tipoDocumentoId;
	}

	public void setTipoDocumentoId(Long tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}



	public Receptor getReceptorId() {
		return receptorId;
	}

	public void setReceptorId(Receptor receptorId) {
		this.receptorId = receptorId;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActualiza() {
		return fechaActualiza;
	}

	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getExcento() {
		return excento;
	}

	public void setExcento(Double excento) {
		this.excento = excento;
	}

	public Double getGravado() {
		return gravado;
	}

	public void setGravado(Double gravado) {
		this.gravado = gravado;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getIva19() {
		return iva19;
	}

	public void setIva19(Double iva19) {
		this.iva19 = iva19;
	}

	public Double getIva5() {
		return iva5;
	}

	public void setIva5(Double iva5) {
		this.iva5 = iva5;
	}

	public Double getBase19() {
		return base19;
	}

	public void setBase19(Double base19) {
		this.base19 = base19;
	}

	public Double getBase5() {
		return base5;
	}

	public void setBase5(Double base5) {
		this.base5 = base5;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public void setDocumentoId(Long documentoId) {
		this.documentoId = documentoId;
	}
	
}
