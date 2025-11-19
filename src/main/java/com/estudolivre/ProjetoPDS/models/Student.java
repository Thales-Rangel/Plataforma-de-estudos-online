package com.estudolivre.ProjetoPDS.models;

import jakarta.persistence.Entity;

@Entity
public class Student extends Users {
	
	private static final long serialVersionUID = 1L;
	
	private String matricula;
	private String curso;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	

}
