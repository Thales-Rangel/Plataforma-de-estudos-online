package com.estudolivre.ProjetoPDS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estudolivre.ProjetoPDS.models.Admin;
import com.estudolivre.ProjetoPDS.services.AdminService;

@Controller
@RequestMapping("usuarios/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/form")
	public String form() {
		return "admins/form"; // Nome da página de formulário
	}
	
	@PostMapping
	public void salvar(Admin admin) {
		service.saveAdmin(admin);
	}
	
	@GetMapping("/lista")
	public List<Admin> listar(){
		return service.listAllAdmins();
	}
	
	@GetMapping("/{id}")
	public Admin buscarPorId(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletar(@PathVariable Long id) {
		service.delete(id);
	}

}
