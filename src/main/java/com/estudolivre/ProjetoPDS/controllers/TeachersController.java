package com.estudolivre.ProjetoPDS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.estudolivre.ProjetoPDS.models.Teacher;
import com.estudolivre.ProjetoPDS.repositories.TeachersRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios/professor")
public class TeachersController {

    @Autowired
    private TeachersRepository teachersRepository;

    @GetMapping("/form")
    public String form() {
        return "teachers/formTeacher"; // nome do arquivo HTML
    }

    @PostMapping
    public String adicionar(Teacher Teachers) {
        teachersRepository.save(Teachers);
        return "redirect:/teachers";
    }

    @GetMapping
    public ModelAndView listar() {
        List<Teacher> teachers = teachersRepository.findAll();
        ModelAndView mv = new ModelAndView("teachers/listaTeachers");
        mv.addObject("teachers", teachers);
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("teachers/detalhesTeacher");
        Optional<Teacher> teacher = teachersRepository.findById(id);
        if (teacher.isPresent()) {
            mv.addObject("teacher", teacher.get());
        } else {
            mv.setViewName("redirect:/teachers");
        }
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String deletar(@PathVariable Long id) {
        teachersRepository.deleteById(id);
        return "redirect:/teachers";
    }
}