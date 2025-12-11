package com.estudolivre.ProjetoPDS.services.materials;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.estudolivre.ProjetoPDS.models.materials.Book;
import com.estudolivre.ProjetoPDS.repositories.materials.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	public void saveBook(Book livro) {
		bookRepository.save(livro);
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
