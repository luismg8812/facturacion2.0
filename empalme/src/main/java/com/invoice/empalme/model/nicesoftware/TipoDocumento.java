package com.invoice.empalme.model.nicesoftware;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TIPO_DOCUMENTO")
public class TipoDocumento {

	@Id
	@SequenceGenerator(name="S_TIPO_DOCUMENTO", sequenceName="S_TIPO_DOCUMENTO", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_TIPO_DOCUMENTO")
	@NotNull
	@Column(name="TIPO_DOCUMENTO_ID")
	private Long tipoDocumentoId;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="CODIGO")
	private Long codigo;
	
	@Column(name="NOMBRE_CORTO")
	private String nombreCorto;

	public Long getTipoDocumentoId() {
		return tipoDocumentoId;
	}

	public void setTipoDocumentoId(Long tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
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

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	
	
}
