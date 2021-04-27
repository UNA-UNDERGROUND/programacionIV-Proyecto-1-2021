package com.progra4.proyecto1.modelo.beans;

public class Matricula {

	private Integer estudianteId;
	private Integer grupoNum;
	private Integer cursoId;
	private Integer estadoId;
	private Integer nota;

	public Matricula() {

	}

	public Matricula(Integer estudianteId, Integer grupoNum, Integer cursoId, Integer estadoId, Integer nota) {
		this.estudianteId = estudianteId;
		this.grupoNum = grupoNum;
		this.cursoId = cursoId;
		this.estadoId = estadoId;
		this.nota = nota;
	}

	public Integer getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(Integer estudianteId) {
		this.estudianteId = estudianteId;
	}

	public Integer getGrupoNum() {
		return grupoNum;
	}

	public void setGrupoNum(Integer grupoNum) {
		this.grupoNum = grupoNum;
	}

	public Integer getCursoId() {
		return cursoId;
	}

	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

}
