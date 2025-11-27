package com.estudolivre.ProjetoPDS.services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.estudolivre.ProjetoPDS.models.Article;
import com.estudolivre.ProjetoPDS.repositories.ArticleRepository;

@Service
public class ArticleService {
	
	private final ArticleRepository articleRepository;

	public ArticleService(ArticleRepository articleRepository) {
		super();
		this.articleRepository = articleRepository;
	}
	
	public Article saveArticle(String author, String title, LocalDate publicationDate) {
		Article article = new Article();
		article.setAuthor(author);
		article.setTitle(title);
		article.setPublicationDate(publicationDate);
		return articleRepository.save(article);
	}
	
	public Article updateArticle(Long id, String author, LocalDate publicationDate, MultipartFile file) throws IOException {
		Optional<Article> byId = articleRepository.findById(id);
		if (byId.isEmpty()) {
			return null;
		}
		
		Article article = byId.get();
		article.setAuthor(author);
		article.setPublicationDate(publicationDate);
		article.setFile(file.getBytes());
		
		return articleRepository.save(article);
	}
	
	public Article upload(Long id, MultipartFile file) throws IOException{
		Optional<Article> byId = articleRepository.findById(id);
		if (byId.isEmpty()) {
			return null;
		}
		
		Article article = byId.get();
		article.setFile(file.getBytes());
		return articleRepository.save(article);
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
