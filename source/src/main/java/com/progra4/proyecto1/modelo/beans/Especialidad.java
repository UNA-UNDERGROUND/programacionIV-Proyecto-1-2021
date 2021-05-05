package com.progra4.proyecto1.modelo.beans;

public class Especialidad {

	private Integer idProfesor;
	private Integer idAreaTematica;

	public Especialidad() {

	}

	public Especialidad(Integer idProfesor, Integer idAreaTematica) {
		this.idProfesor = idProfesor;
		this.idAreaTematica = idAreaTematica;
	}

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public Integer getIdAreaTematica() {
		return idAreaTematica;
	}

	public void setIdAreaTematica(Integer idAreaTematica) {
		this.idAreaTematica = idAreaTematica;
	}

}
