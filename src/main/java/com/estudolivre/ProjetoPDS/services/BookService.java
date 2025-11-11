package com.estudolivre.ProjetoPDS.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.estudolivre.ProjetoPDS.models.Book;
import com.estudolivre.ProjetoPDS.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	public Book upload(MultipartFile file) throws IOException {
		Book book = new Book();
		book.setData(file.getBytes());
		return bookRepository.save(book);
	}

}
