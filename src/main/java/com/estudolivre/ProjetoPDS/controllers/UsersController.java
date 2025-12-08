package com.estudolivre.ProjetoPDS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.estudolivre.ProjetoPDS.models.Student;
import com.estudolivre.ProjetoPDS.models.Teacher;
import com.estudolivre.ProjetoPDS.services.StudentService;
import com.estudolivre.ProjetoPDS.services.TeachersService;

@Controller
@RequestMapping("/usuarios")
public class UsersController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeachersService teachersService;
	
	@GetMapping
	public ModelAndView index() {
		
		List<Student> listAllStudents = studentService.listAllStudents();
		List<Teacher> listAllTeachers = teachersService.listAllTeachers();
		
		ModelAndView modelAndView = new ModelAndView("/users/users-list");
		modelAndView.addObject("estudantes", listAllStudents);
		modelAndView.addObject("professores", listAllTeachers);
		
		return modelAndView;
	}

}
