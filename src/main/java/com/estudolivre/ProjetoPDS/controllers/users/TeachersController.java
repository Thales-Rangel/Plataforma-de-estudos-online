package com.estudolivre.ProjetoPDS.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.estudolivre.ProjetoPDS.models.users.Teacher;
import com.estudolivre.ProjetoPDS.services.users.TeachersService;

import java.util.List;

@Controller
@RequestMapping("/usuarios/professor")
public class TeachersController {

    @Autowired
    private TeachersService service;

    @GetMapping("/form")
    public String form() {
        return "teachers/formTeacher"; // nome do arquivo HTML
    }

    @PostMapping
    public void salvar(Teacher Teacher) {
        service.saveTeacher(Teacher);
    }

    @GetMapping("/lista")
    public List<Teacher> listar() {
    	return service.listAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher buscarPorId(@PathVariable Long id) {
    	return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public String deletar(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/usuarios";
    }
}