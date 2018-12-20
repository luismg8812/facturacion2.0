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
@Table(name="RECEPTOR")
public class Receptor {

	@Id
	@SequenceGenerator(name="S_RECEPTOR", sequenceName="S_RECEPTOR", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_RECEPTOR")
	@NotNull
	@Column(name="RECEPTOR_ID")
	private Long receptorId;
	
	@Column(name="NOMBRE")
	private String nombre;
		
	@Column(name="IDENTIFICACION")
	private String identificacion;
	
	@Column(name="TIPO_ORGANIZACION_JURIDICA_ID")
	private Long tipoOrganizacionJuridicaId ;
	
	@Column(name="TIPO_IDENTIFICACION_ID")
	private Long tipoIdenificacionId ;
	
	@Column(name="REGIMEN")
	private Long regimen;
	
	@Column(name="RAZON_SOCIAL")
	private String razonSocial;
	
	@Column(name="APELLIDOS")
	private String apellidos;
	
	@Column(name="DIRECCION")
	private String direccion;
	
	@Column(name="EMAIL")
	private String email;

	public Long getReceptorId() {
		return receptorId;
	}

	public void setReceptorId(Long receptorId) {
		this.receptorId = receptorId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Long getTipoOrganizacionJuridicaId() {
		return tipoOrganizacionJuridicaId;
	}

	public void setTipoOrganizacionJuridicaId(Long tipoOrganizacionJuridicaId) {
		this.tipoOrganizacionJuridicaId = tipoOrganizacionJuridicaId;
	}

	public Long getTipoIdenificacionId() {
		return tipoIdenificacionId;
	}

	public void setTipoIdenificacionId(Long tipoIdenificacionId) {
		this.tipoIdenificacionId = tipoIdenificacionId;
	}

	public Long getRegimen() {
		return regimen;
	}

	public void setRegimen(Long regimen) {
		this.regimen = regimen;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
