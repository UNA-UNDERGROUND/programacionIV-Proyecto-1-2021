package com.progra4.proyecto1.modelo.beans;

public class Curso {

	private Integer idCurso;
	private String descripcion;
	private Integer areaTematicaId;

	public Curso() {

	}

	public Curso(Integer idCurso, String descripcion, Integer areaTematicaId) {
		this.idCurso = idCurso;
		this.descripcion = descripcion;
		this.areaTematicaId = areaTematicaId;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getAreaTematicaId() {
		return areaTematicaId;
	}

	public void setAreaTematicaId(Integer areaTematicaId) {
		this.areaTematicaId = areaTematicaId;
	}

}
