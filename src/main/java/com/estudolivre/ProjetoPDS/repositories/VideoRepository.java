package com.estudolivre.ProjetoPDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudolivre.ProjetoPDS.models.VideoAula;
import com.estudolivre.ProjetoPDS.repositories.VideoRepository;

@Repository
public interface VideoRepository extends JpaRepository<VideoAula, Long> {
	
}