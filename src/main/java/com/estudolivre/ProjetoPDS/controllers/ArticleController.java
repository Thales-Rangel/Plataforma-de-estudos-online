package com.estudolivre.ProjetoPDS.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.estudolivre.ProjetoPDS.models.Article;
import com.estudolivre.ProjetoPDS.services.ArticleService;

@Controller
@RequestMapping("/Artigos")
public class ArticleController {
	
	private final ArticleService articleService;

	public ArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}
	
	@PostMapping("/upload")
	public Article uploadFile (@RequestParam Long id, @RequestParam MultipartFile file) throws IOException {
		return articleService.upload(id, file);
	}

}
