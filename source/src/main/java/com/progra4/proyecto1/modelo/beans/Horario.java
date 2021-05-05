package com.progra4.proyecto1.modelo.beans;

public class Horario {

	private Integer seq;
	private Integer grupoNum;
	private Integer grupoCursoId;
	private Integer dia;
	private Integer hora;

	public Horario() {

	}

	public Horario(Integer seq, Integer grupoNum, Integer grupoCursoId, Integer dia, Integer hora) {
		this.seq = seq;
		this.grupoNum = grupoNum;
		this.grupoCursoId = grupoCursoId;
		this.dia = dia;
		this.hora = hora;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getGrupoNum() {
		return grupoNum;
	}

	public void setGrupoNum(Integer grupoNum) {
		this.grupoNum = grupoNum;
	}

	public Integer getGrupoCursoId() {
		return grupoCursoId;
	}

	public void setGrupoCursoId(Integer grupoCursoId) {
		this.grupoCursoId = grupoCursoId;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

}
