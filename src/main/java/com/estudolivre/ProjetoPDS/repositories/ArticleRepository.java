package com.estudolivre.ProjetoPDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudolivre.ProjetoPDS.models.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
