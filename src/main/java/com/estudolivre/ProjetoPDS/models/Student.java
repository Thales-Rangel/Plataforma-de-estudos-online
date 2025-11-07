package com.estudolivre.ProjetoPDS.models;

public class Student extends Users {
	
	private String matricula;
	private String curso;

	public Student(int id, String nomeCompleto, String email, String senha, String matricula, String curso) {
		super(id, nomeCompleto, email, senha);
		this.curso = curso;
		this.matricula = matricula;
	}
	
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
