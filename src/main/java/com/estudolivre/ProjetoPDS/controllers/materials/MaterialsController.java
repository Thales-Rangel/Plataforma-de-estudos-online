package com.estudolivre.ProjetoPDS.controllers.materials;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.estudolivre.ProjetoPDS.models.Article;
import com.estudolivre.ProjetoPDS.models.Book;
import com.estudolivre.ProjetoPDS.services.ArticleService;
import com.estudolivre.ProjetoPDS.services.BookService;

@Controller
@RequestMapping("/materiais")
public class MaterialsController {
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ModelAndView index() {
		List<Article> listAllArticles = articleService.listAllArticles();
		List<Book> listAllBooks = bookService.listAllBooks();
		
		ModelAndView modelAndView = new ModelAndView("materials/Materiais");
		modelAndView.addObject("artigos", listAllArticles);
		modelAndView.addObject("livros", listAllBooks);
		
		return modelAndView;
	}

}
