package com.estudolivre.ProjetoPDS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.estudolivre.ProjetoPDS.models.Student;
import com.estudolivre.ProjetoPDS.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios/estudante")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/form")
    public String form() {
        return "students/formStudent"; // nome do HTML
    }

    @PostMapping
    public String adicionar(Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping
    public ModelAndView listar() {
        List<Student> students = studentRepository.findAll();
        ModelAndView mv = new ModelAndView("students/listaStudents");
        mv.addObject("students", students);
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("students/detalhesStudent");
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            mv.addObject("student", student.get());
        } else {
            mv.setViewName("redirect:/students");
        }
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String deletar(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }
}