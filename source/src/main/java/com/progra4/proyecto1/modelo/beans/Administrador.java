package com.progra4.proyecto1.modelo.beans;

public class Administrador {

	private Integer idAdministrador;
	private String usuarioId;
	private String apellido1;
	private String apellido2;
	private String nombre;
	private String telefono;
	private String email;

	public Administrador() {

	}

	public Administrador(Integer idAdministrador, String usuarioId, String apellido1, String apellido2, String nombre,
			String telefono, String email) {
		this.idAdministrador = idAdministrador;
		this.usuarioId = usuarioId;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	public Integer getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Integer idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEMail() {
		return email;
	}

	public void setEMail(String eMail) {
		this.email = eMail;
	}

}
