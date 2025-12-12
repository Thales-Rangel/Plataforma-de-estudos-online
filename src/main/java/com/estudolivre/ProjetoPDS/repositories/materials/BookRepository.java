package com.estudolivre.ProjetoPDS.repositories.materials;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudolivre.ProjetoPDS.models.materials.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
