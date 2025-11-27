package com.estudolivre.ProjetoPDS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.estudolivre.ProjetoPDS.models.Student;
import com.estudolivre.ProjetoPDS.services.StudentService;

import java.util.List;

@Controller
@RequestMapping("/usuarios/estudante")
public class StudentController {

	@Autowired
	private StudentService service;

    @GetMapping("/form")
    public String form() {
        return "students/formStudent"; // nome do HTML
    }

    @PostMapping
    public void salvar(Student student) {
        service.saveStudent(student);
    }

    @GetMapping("/lista")
    public List<Student> listar() {
        return service.listAllStudents();
    }

    @GetMapping("/{id}")
    public Student buscarPorID(@PathVariable Long id) {
    	return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletar(@PathVariable Long id) {
        service.delete(id);
    }
}