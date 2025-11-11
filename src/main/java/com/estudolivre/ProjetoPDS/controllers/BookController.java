package com.estudolivre.ProjetoPDS.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.estudolivre.ProjetoPDS.models.Book;
import com.estudolivre.ProjetoPDS.services.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	private final BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@PostMapping("/upload")
	public Book upload(@RequestParam MultipartFile file) throws IOException {
		return bookService.upload(file);
	}

}
