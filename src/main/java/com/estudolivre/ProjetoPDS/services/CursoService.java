package com.estudolivre.ProjetoPDS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudolivre.ProjetoPDS.models.Curso;
import com.estudolivre.ProjetoPDS.models.Teacher;
import com.estudolivre.ProjetoPDS.repositories.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	public void saveCurso(Curso curso) {
		repository.save(curso);
	}
	
	public List<Curso> listAllCursos(){
		List<Curso> all = repository.findAll();
		return all.stream().toList();
	}
	
	public List<Curso> searchForTeacher(Teacher professor){
		List<Curso> byProfessor = repository.findByProfessor(professor);
		
		return byProfessor.stream().toList();
	}
	
	public void delete(Long id) {
		Optional<Curso> byId = repository.findById(id);
		if (byId.isEmpty()) {
			return;
		}
		
		Curso curso = byId.get();
		repository.delete(curso);
	}
	
	public Curso searchForId(Long id) {
		Optional<Curso> byId = repository.findById(id);
		if (byId.isEmpty()) {
			return null;
		}
		
		Curso curso = byId.get();
		return curso;
	}

}
