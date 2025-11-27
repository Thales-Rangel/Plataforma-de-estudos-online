package com.estudolivre.ProjetoPDS.services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
	
	public Book saveBook(String author, String title, LocalDate publicationDate) {
		Book book = new Book();
		book.setAuthor(author);
		book.setTitle(title);
		book.setPublicationDate(publicationDate);
		return bookRepository.save(book);
	}
	
	public Book updateBook(Long id, String author, LocalDate publicationDate, MultipartFile file) throws IOException {
		Optional<Book> byId = bookRepository.findById(id);
		if (byId.isEmpty()) {
			return null;
		}
		
		Book book = byId.get();
		book.setAuthor(author);
		book.setPublicationDate(publicationDate);
		book.setFile(file.getBytes());
		
		return bookRepository.save(book);
	}
	
	public Book upload(Long id, MultipartFile file) throws IOException {
		Optional<Book> byId = bookRepository.findById(id);
		if (byId.isEmpty()) {
			return null;
		}
		
		Book book = byId.get();
		book.setFile(file.getBytes());
		return bookRepository.save(book);
	}
	
	public List<Book> listAllBooks() {
		return bookRepository.findAll();
	}
	
	public void delete(Long id) {
		Optional<Book> byId = bookRepository.findById(id);
		
		if (byId.isEmpty()) {
			return;
		}
		
		Book book = byId.get();
		bookRepository.delete(book);
	}
	
	public Book findById(Long id) {
		Optional<Book> byId = bookRepository.findById(id);
		if (byId.isEmpty()) {
			return null;
		}
		
		return byId.get();
	}

}
