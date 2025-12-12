package com.estudolivre.ProjetoPDS.controllers.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.estudolivre.ProjetoPDS.models.users.Admin;
import com.estudolivre.ProjetoPDS.services.users.AdminService;

@Controller
@RequestMapping("usuarios/admin")
public class AdminController {

	@Autowired
	private AdminService service;

	@GetMapping("/form")
	@PreAuthorize("hasRole('ADMIN')")
	public String form(Admin admin) {
		return "users/admins/cadastro-admin"; // Nome da página de formulário
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public String salvar(Admin admin, RedirectAttributes attributes) {
		try {
			service.saveAdmin(admin);
		} catch (Exception e) {
			attributes.addFlashAttribute("erro", "Endereço de email já cadastrado");
			return "redirect:/usuarios/admin/form";
		}
		return "redirect:/usuarios";
	}

	@GetMapping("/lista")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Admin> listar() {
		return service.listAllAdmins();
	}

	@GetMapping("/{id}")
	public Admin buscarPorId(@PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deletar(@PathVariable Long id) {
		service.delete(id);

		return "redirect:/usuarios";
	}

}
