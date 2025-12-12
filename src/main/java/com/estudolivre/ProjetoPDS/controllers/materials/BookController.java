package com.estudolivre.ProjetoPDS.controllers.materials;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.estudolivre.ProjetoPDS.models.materials.Book;
import com.estudolivre.ProjetoPDS.services.materials.BookService;

@Controller
@RequestMapping("/materiais/livros")
public class BookController {
	
	private final BookService service;

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.service = bookService;
	}
	
	@GetMapping("/form")
	@PreAuthorize("hasRole('TEACHER')")
	public String form(Book livro) {
		return "materials/books/formLivro";
	}
	
	@PostMapping
	@PreAuthorize("hasRole('TEACHER')")
	public String salvar(Book livro) {
		service.saveBook(livro);
		return "redirect:/materiais";
	}

	@PostMapping("/upload")
	@PreAuthorize("hasRole('TEACHER')")
	public Book uploadFile(@RequestParam Long id, @RequestParam MultipartFile file) throws IOException {
		return service.upload(id, file);
	}
	
	@GetMapping("/lista")
	public List<Book> listar() {
		return service.listAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book buscarLivro(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('TEACHER')")
	public String deletar(@PathVariable Long id) {
		service.delete(id);
		
		return "redirect:/materiais";
	}

}
