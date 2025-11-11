package com.estudolivre.ProjetoPDS.repositories;

import java.util.List;
import java.util.Optional;

import com.estudolivre.ProjetoPDS.models.Teachers;

public interface TeachersRepository {

	void save(Teachers teachers);

	List<Teachers> findAll();

	Optional<Teachers> findById(Long id);

	void deleteById(Long id);

}
