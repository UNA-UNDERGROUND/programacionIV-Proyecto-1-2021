package com.progra4.proyecto1.modelo.beans;

public class AreaTematica {

	private Integer idArea;
	private String descripcion;

	public AreaTematica() {

	}

	public AreaTematica(Integer idArea, String descripcion) {
		this.idArea = idArea;
		this.descripcion = descripcion;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
