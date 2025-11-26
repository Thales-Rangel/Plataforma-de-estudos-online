package com.estudolivre.ProjetoPDS.models;

import jakarta.persistence.Entity;

@Entity
public class Teachers extends Users {
	
	private static final long serialVersionUID = 1L;
	
	private String disciplina;
	private String formacao; 

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

}
