package com.estudolivre.ProjetoPDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudolivre.ProjetoPDS.models.Papeis;

public interface PapeisRepository extends JpaRepository<Papeis, Long> {
	
	Papeis findByNome(String nome);

}
