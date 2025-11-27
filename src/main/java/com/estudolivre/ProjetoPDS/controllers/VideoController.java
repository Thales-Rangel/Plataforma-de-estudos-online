package com.estudolivre.ProjetoPDS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.estudolivre.ProjetoPDS.models.VideoAula;
import com.estudolivre.ProjetoPDS.services.VideoService;

import java.util.List;

@Controller
@RequestMapping("/materiais/videos")
public class VideoController {

	@Autowired
	private VideoService service;

	@GetMapping("/novo")
	public String abrirFormulario(Model model) {
		model.addAttribute("videoAula", new VideoAula());
		return "cadastro-video";
	}

	@PostMapping("/salvar")
	public String salvarVideo(VideoAula videoAula) {
		service.save(videoAula);
		return "redirect:/materiais/videos/novo";
	}

	@GetMapping
	public String listarVideos(Model model) {
		List<VideoAula> listar = service.listar();
		model.addAttribute("videos", listar);
		return "lista-videos";
	}
}