package com.invoice.electonic.model;


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
	
	@Column(name="TIPO_ORGANIZACION_JURIDICA_ID")
	private Long tipoOrganizacionJuridicaId;
	
	@Column(name="TIPO_IDENTIFICACION_ID")
	private Long tipoIdentificacionId;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="RAZON_SOCIAL")
	private String RazonSocial;
	
	@Column(name="APELLIDOS")
	private String Apellidos;
	
	@Column(name="IDENTIFICACION")
	private String identificacion;

	@Column(name="DIRECCION")
	private String Direccion;
	
	@Column(name="REGIMEN")
	private Long Regimen;
	
	@Column(name="EMAIL")
	private String Email;
	
	@Column(name="TELEFONO")
	private String Telefono;

	public Long getTipoOrganizacionJuridicaId() {
		return tipoOrganizacionJuridicaId;
	}

	public void setTipoOrganizacionJuridicaId(Long tipoOrganizacionJuridicaId) {
		this.tipoOrganizacionJuridicaId = tipoOrganizacionJuridicaId;
	}

	public Long getTipoIdentificacionId() {
		return tipoIdentificacionId;
	}

	public void setTipoIdentificacionId(Long tipoIdentificacionId) {
		this.tipoIdentificacionId = tipoIdentificacionId;
	}

	public String getRazonSocial() {
		return RazonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public Long getRegimen() {
		return Regimen;
	}

	public void setRegimen(Long regimen) {
		Regimen = regimen;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
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

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
}
