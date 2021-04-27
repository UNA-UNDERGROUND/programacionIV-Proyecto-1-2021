package com.progra4.proyecto1.modelo.beans;

import java.sql.Timestamp;

public class Usuario {

	private String idUsuario;
	private Integer rolId;
	private String clave;
	private Timestamp ultimoAceso;
	private Boolean activo;

	public Usuario() {
	}

	public Usuario(String idUsuario, Integer rolId, String clave, Timestamp ultimoAcceso, Boolean activo) {
		this.idUsuario = idUsuario;
		this.rolId = rolId;
		this.clave = clave;
		this.ultimoAceso = ultimoAcceso;
		this.activo = activo;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public java.sql.Timestamp getUltimoAceso() {
		return ultimoAceso;
	}

	public void setUltimoAceso(java.sql.Timestamp ultimoAceso) {
		this.ultimoAceso = ultimoAceso;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
