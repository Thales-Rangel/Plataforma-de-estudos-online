package com.estudolivre.ProjetoPDS.models;

public class Teachers extends Users {
	
	private String disciplina;
	private String formacao; 
	
	public Teachers(int id, String nomeCompleto, String email, String senha, String disciplina, String formacao) {
		super(id, nomeCompleto, email, senha);
		this.disciplina = disciplina;
		this.formacao = formacao;
	}

	private Users Users;

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

	public Users getUsers() {
		return Users;
	}

	public void setUsers(Users users) {
		Users = users;
	}
	

}
