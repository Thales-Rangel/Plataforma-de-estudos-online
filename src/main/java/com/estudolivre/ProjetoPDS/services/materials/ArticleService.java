package com.estudolivre.ProjetoPDS.services.materials;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.estudolivre.ProjetoPDS.models.materials.Article;
import com.estudolivre.ProjetoPDS.repositories.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public void saveArticle(Article artigo) {
		articleRepository.save(artigo);
	}
	
	public void upload(Article artigo, MultipartFile file) throws IOException{
		artigo.setFile(file.getBytes());
		articleRepository.save(artigo);
	}
	
	public List<Article> listAllArticles() {
		return articleRepository.findAll();
	}
	
	public void delete(Long id) {
		Optional<Article> byId = articleRepository.findById(id);
		
		if (byId.isEmpty()) {
			return;
		}
		
		Article article = byId.get();
		articleRepository.delete(article);
	}
	
	public Article findById(Long id) {
		Optional<Article> byId = articleRepository.findById(id);
		if (byId.isEmpty()) {
			return null;
		}
		
		return byId.get();
	}

}
