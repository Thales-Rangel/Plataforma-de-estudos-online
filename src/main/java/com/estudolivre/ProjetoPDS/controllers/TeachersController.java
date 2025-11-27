package com.estudolivre.ProjetoPDS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.estudolivre.ProjetoPDS.models.Teacher;
import com.estudolivre.ProjetoPDS.services.TeachersService;

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

    @DeleteMapping("/delete/{id}")
    public void deletar(@PathVariable Long id) {
        service.delete(id);
    }
}