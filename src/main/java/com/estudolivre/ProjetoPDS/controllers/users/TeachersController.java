package com.estudolivre.ProjetoPDS.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.estudolivre.ProjetoPDS.models.users.Teacher;
import com.estudolivre.ProjetoPDS.services.users.TeachersService;

import java.util.List;

@Controller
@RequestMapping("/usuarios/professor")
public class TeachersController {

    @Autowired
    private TeachersService service;

    @GetMapping("/form")
    public String form(Teacher teacher) {
        return "users/teachers/cadastro-professor"; // nome do arquivo HTML
    }

    @PostMapping
    public String salvar(Teacher teacher, RedirectAttributes attributes) {
        try {
			service.saveTeacher(teacher);
		} catch (Exception e) {
			attributes.addFlashAttribute("erro", "Endereço de email já cadastrado!");
			return "redirect:/usuarios/professor/form";
		}
        
        return "redirect:/";
    }

    @GetMapping("/lista")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Teacher> listar() {
    	return service.listAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher buscarPorId(@PathVariable Long id) {
    	return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public String deletar(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/usuarios";
    }
}