package com.estudolivre.ProjetoPDS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudolivre.ProjetoPDS.models.Curso;
import com.estudolivre.ProjetoPDS.models.Teacher;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	List<Curso> findByProfessor(Teacher professor);

}
