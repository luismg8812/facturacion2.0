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
@Table(name="TIPO_ORGANIZACION_JURIDICA")
public class TipoOrganizacionJuridica {

	@Id
	@SequenceGenerator(name="S_TIPO_ORGANIZACION_JURIDICA", sequenceName="S_TIPO_ORGANIZACION_JURIDICA", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_TIPO_ORGANIZACION_JURIDICA")
	@NotNull
	@Column(name="TIPO_ORGANIZACION_JURIDICA_ID")
	private Long tipoOrganizacionJuridicaId;
	
	@Column(name="NOMBRE")
	private String nombre;
		
	
	
	public Long getTipoOrganizacionJuridicaId() {
		return tipoOrganizacionJuridicaId;
	}

	public void setTipoOrganizacionJuridicaId(Long tipoOrganizacionJuridicaId) {
		this.tipoOrganizacionJuridicaId = tipoOrganizacionJuridicaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
