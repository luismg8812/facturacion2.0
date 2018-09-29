package com.client.explorer.model;

public class SubMenu {

	private Long subMenuId;

	private String nombre;

	private Long estado;

	private String url;

	private String bar;

	private String ruta;

	private Long menuId;

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getSubMenuId() {
		return subMenuId;
	}

	public void setSubMenuId(Long subMenuId) {
		this.subMenuId = subMenuId;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBar() {
		return bar;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
