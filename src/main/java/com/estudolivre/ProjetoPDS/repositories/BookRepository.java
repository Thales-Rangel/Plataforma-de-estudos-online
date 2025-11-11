package com.estudolivre.ProjetoPDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudolivre.ProjetoPDS.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
