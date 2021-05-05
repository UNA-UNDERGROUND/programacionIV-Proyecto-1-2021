package com.progra4.proyecto1.modelo.beans;

public class Grupo {

	private long numGrupo;
	private long cursoId;
	private long profesorId;

	public Grupo() {

	}

	public Grupo(Integer numGrupo, Integer cursoId, Integer profesorId) {
		this.numGrupo = numGrupo;
		this.cursoId = cursoId;
		this.profesorId = profesorId;
	}

	public long getNumGrupo() {
		return numGrupo;
	}

	public void setNumGrupo(long numGrupo) {
		this.numGrupo = numGrupo;
	}

	public long getCursoId() {
		return cursoId;
	}

	public void setCursoId(long cursoId) {
		this.cursoId = cursoId;
	}

	public long getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(long profesorId) {
		this.profesorId = profesorId;
	}

}
