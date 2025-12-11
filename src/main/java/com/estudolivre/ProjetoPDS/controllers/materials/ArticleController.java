package com.estudolivre.ProjetoPDS.controllers.materials;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.estudolivre.ProjetoPDS.models.materials.Article;
import com.estudolivre.ProjetoPDS.services.materials.ArticleService;

@Controller
@RequestMapping("/materiais/artigos")
public class ArticleController {
	
	@Autowired
	private ArticleService service;
	
	@GetMapping("/form")
	public String form(Article artigo) {
		return "materials/articles/formArtigo"; //name do HTML
	}
	
	@PostMapping
	public String salvar(Article artigo) {
		service.saveArticle(artigo);
		return "redirect:/materiais";
	}
	
	@PostMapping("/upload")
	public void uploadFile (@RequestParam Article artigo, @RequestParam MultipartFile file) throws IOException {
		service.upload(artigo, file);
	}
	
	@GetMapping("/lista")
	public List<Article> listar(){
		return service.listAllArticles();
	}
	
	@GetMapping("/{id}")
	public Article buscarArticle(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletar(@PathVariable Long id) {
		service.delete(id);
	}

}
