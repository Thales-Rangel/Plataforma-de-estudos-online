package com.estudolivre.ProjetoPDS.controllers.materials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.estudolivre.ProjetoPDS.models.materials.VideoAula;
import com.estudolivre.ProjetoPDS.services.materials.VideoService;

import java.util.List;

@Controller
@RequestMapping("/materiais/videos")
public class VideoController {

	@Autowired
	private VideoService service;

	@GetMapping("/form")
	@PreAuthorize("hasRole('TEACHER')")
	public String form(VideoAula video) {
		return "materials/videos/formVideo";
	}

	@PostMapping
	@PreAuthorize("hasRole('TEACHER')")
	public String salvar(VideoAula videoAula) {
		service.save(videoAula);
		return "redirect:/materiais/videos";
	}

	@GetMapping
	public ModelAndView listar() {
		List<VideoAula> listar = service.listar();
		
		ModelAndView modelAndView = new ModelAndView("materials/videos/Videos");
		modelAndView.addObject("videos", listar);
		
		return modelAndView;
	}
	
	@DeleteMapping
	@PreAuthorize("hasRole('TEACHER')")
	public String deletar(@PathVariable Long id) {
		service.deletar(id);
		
		return "redirect:/materiais/videos";
	}
}