package com.estudolivre.ProjetoPDS.controllers.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.estudolivre.ProjetoPDS.models.users.Admin;
import com.estudolivre.ProjetoPDS.models.users.Student;
import com.estudolivre.ProjetoPDS.models.users.Teacher;
import com.estudolivre.ProjetoPDS.services.users.AdminService;
import com.estudolivre.ProjetoPDS.services.users.StudentService;
import com.estudolivre.ProjetoPDS.services.users.TeachersService;

@Controller
@RequestMapping("/usuarios")
public class UsersController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeachersService teachersService;
	@Autowired
	private AdminService adminService;
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView listar() {
		
		List<Student> listAllStudents = studentService.listAllStudents();
		List<Teacher> listAllTeachers = teachersService.listAllTeachers();
		List<Admin> listAllAdmins = adminService.listAllAdmins();
		
		ModelAndView modelAndView = new ModelAndView("/users/users-list");
		modelAndView.addObject("estudantes", listAllStudents);
		modelAndView.addObject("professores", listAllTeachers);
		modelAndView.addObject("administradores", listAllAdmins);
		
		return modelAndView;
	}
	
	@GetMapping("/forms")
	public String form() {
		return "/users/Cadastro";
	}

}
