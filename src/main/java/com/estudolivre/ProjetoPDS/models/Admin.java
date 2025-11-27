package com.estudolivre.ProjetoPDS.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Admin extends Users {

	private static final long serialVersionUID = 1L;
	
	@Column(unique=true)
	private Long passe;

	public Long getPasse() {
		return passe;
	}

	public void setPasse(Long passe) {
		this.passe = passe;
	}

	@Override
	public String toString() {
		return "admin [passe=" + passe + "]";
	}

}
