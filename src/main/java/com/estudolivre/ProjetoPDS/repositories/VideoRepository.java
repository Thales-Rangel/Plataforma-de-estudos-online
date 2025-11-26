package com.estudolivre.ProjetoPDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudolivre.ProjetoPDS.models.VideoAula;
import com.estudolivre.ProjetoPDS.repositories.VideoRepository;

public interface VideoRepository extends JpaRepository<VideoAula, Long> {
	
}