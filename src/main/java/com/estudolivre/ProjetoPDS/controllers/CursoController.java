package com.estudolivre.ProjetoPDS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estudolivre.ProjetoPDS.models.Curso;
import com.estudolivre.ProjetoPDS.models.Teacher;
import com.estudolivre.ProjetoPDS.services.CursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	public String form() {
		return "cursos/formCursos"; // nome do HTML
	}
	
	@PostMapping
	public void salvar(Curso curso) {
		service.saveCurso(curso);
	}
	
	@GetMapping("/lista")
	public List<Curso> listar() {
		return service.listAllCursos();
	}
	
	@GetMapping("/lista/professor")
	public List<Curso> buscarPorProfessor(Teacher professor){
		return service.searchForTeacher(professor);
	}
	
	@GetMapping("/{id}")
	public Curso buscarPorId(@PathVariable Long id) {
		return service.searchForId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletar (@PathVariable Long id) {
		service.delete(id);
	}

}
