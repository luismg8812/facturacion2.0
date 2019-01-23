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
@Table(name="EMPRESA")
public class Empresa {

	@Id
	@SequenceGenerator(name="S_EMPRESA", sequenceName="S_EMPRESA", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_EMPRESA")
	@NotNull
	@Column(name="EMPRESA_ID")
	private Long empresaId;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="REPRESENTE")
	private String representante;
	
	@Column(name="NIT")
	private String nit;

	@Column(name="REGIMEN")
	private String regimen;
	
	@Column(name="DIRECCION")
	private String direccion;
	
	@Column(name="BARRIO")
	private String barrio;
	
	@Column(name="CIUDAD")
	private String ciudad;
	
	@Column(name="DEPARTAMENTO")
	private String departamento;
	
	@Column(name="TELEFONO_FIJO")
	private String telefonoFijo;
	
	@Column(name="CEL")
	private String cel;

	@Column(name="PREFIJO")
	private String prefijo;
	
	@Column(name="FECHA_RESOLUCION")
	private String fechaResolucion;
	
	@Column(name="FECHA_FIN_RESOLUCION")
	private String fechaFinResolucion;
	
	@Column(name="AUTORIZACION_DESDE")
	private String autorizacionDesde;
	
	@Column(name="AUTORIZACION_HASTA")
	private String autorizacionHasta;
	
	@Column(name="EMAIL")
	private String email;

	@Column(name="SOFTWAREID")
	private String SoftwareID;

	@Column(name="SOFTWAREPIN")
	private String SoftwarePIN;

	@Column(name="SOFTWARE_SECURITY_CODE")
	private String SoftwareSecurityCode;

	@Column(name="CLAVE_TECNICA_CUFE")
	private String ClaveTecnicaCufe;
	
	@Column(name="CERTIFICADO")
	private byte[] Certificado;
	
	@Column(name="RESOLUCION_NUMERACION")
	private String ResolucionNumeracion;
	
	public Long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(String fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public String getFechaFinResolucion() {
		return fechaFinResolucion;
	}

	public void setFechaFinResolucion(String fechaFinResolucion) {
		this.fechaFinResolucion = fechaFinResolucion;
	}

	public String getAutorizacionDesde() {
		return autorizacionDesde;
	}

	public void setAutorizacionDesde(String autorizacionDesde) {
		this.autorizacionDesde = autorizacionDesde;
	}

	public String getAutorizacionHasta() {
		return autorizacionHasta;
	}

	public void setAutorizacionHasta(String autorizacionHasta) {
		this.autorizacionHasta = autorizacionHasta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoftwareID() {
		return SoftwareID;
	}

	public void setSoftwareID(String softwareID) {
		SoftwareID = softwareID;
	}

	public String getSoftwarePIN() {
		return SoftwarePIN;
	}

	public void setSoftwarePIN(String softwarePIN) {
		SoftwarePIN = softwarePIN;
	}

	public String getSoftwareSecurityCode() {
		return SoftwareSecurityCode;
	}

	public void setSoftwareSecurityCode(String softwareSecurityCode) {
		SoftwareSecurityCode = softwareSecurityCode;
	}

	public String getClaveTecnicaCufe() {
		return ClaveTecnicaCufe;
	}

	public void setClaveTecnicaCufe(String claveTecnicaCufe) {
		ClaveTecnicaCufe = claveTecnicaCufe;
	}

	public byte[] getCertificado() {
		return Certificado;
	}

	public void setCertificado(byte[] certificado) {
		Certificado = certificado;
	}

	public String getResolucionNumeracion() {
		return ResolucionNumeracion;
	}

	public void setResolucionNumeracion(String resolucionNumeracion) {
		ResolucionNumeracion = resolucionNumeracion;
	}
}
