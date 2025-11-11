package com.estudolivre.ProjetoPDS.repositories;

import java.util.List;
import java.util.Optional;

import com.estudolivre.ProjetoPDS.models.Student;

public interface StudentRepository {

	void save(Student student);

	List<Student> findAll();

	Optional<Student> findById(Long id);

	void deleteById(Long id);

}
