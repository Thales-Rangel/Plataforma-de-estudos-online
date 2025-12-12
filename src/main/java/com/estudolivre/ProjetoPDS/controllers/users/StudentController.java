package com.estudolivre.ProjetoPDS.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.estudolivre.ProjetoPDS.models.users.Student;
import com.estudolivre.ProjetoPDS.services.users.StudentService;

import java.util.List;

@Controller
@RequestMapping("/usuarios/estudante")
public class StudentController {

	@Autowired
	private StudentService service;

    @GetMapping("/form")
    public String form(Student student) {
        return "users/students/cadastro-aluno"; // nome do HTML
    }

    @PostMapping
    public String salvar(Student student, RedirectAttributes attributes) {
    	
        try {
			service.saveStudent(student);
		} catch (Exception e) {
			attributes.addFlashAttribute("erro", "Endereço de email já cadastrado");
			return "redirect:/usuarios/estudante/form";
		}
        
        return "redirect:/";
    }

    @GetMapping("/lista")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Student> listar() {
        return service.listAllStudents();
    }

    @GetMapping("/{id}")
    public Student buscarPorID(@PathVariable Long id) {
    	return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
    public String deletar(@PathVariable Long id) {
        service.delete(id);
        
        return "redirect:/usuarios";
    }
}