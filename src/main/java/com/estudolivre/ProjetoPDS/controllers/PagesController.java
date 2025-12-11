package com.estudolivre.ProjetoPDS.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {
	
	@RequestMapping("/")
	public String index() {
		return "Home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}

}
