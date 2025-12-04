package com.estudolivre.ProjetoPDS.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@ManyToOne
	private Teacher professor;
	@ManyToMany
	private List<Materials> materiais;
	@ManyToMany
	private List<Student> inscritos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Teacher getProfessor() {
		return professor;
	}

	public void setProfessor(Teacher professor) {
		this.professor = professor;
	}

	public List<Materials> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Materials> materiais) {
		this.materiais = materiais;
	}

	public List<Student> getInscritos() {
		return inscritos;
	}

	public void setInscritos(List<Student> inscritos) {
		this.inscritos = inscritos;
	}

}
