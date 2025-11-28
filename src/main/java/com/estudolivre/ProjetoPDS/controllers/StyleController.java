package com.estudolivre.ProjetoPDS.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estilos")
public class StyleController {
	
	public String estilos() {
		return "estilos/Estilo";
	}

}
