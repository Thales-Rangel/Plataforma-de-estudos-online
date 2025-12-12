package com.estudolivre.ProjetoPDS.repositories.materials;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudolivre.ProjetoPDS.models.materials.VideoAula;
import com.estudolivre.ProjetoPDS.repositories.materials.VideoRepository;

@Repository
public interface VideoRepository extends JpaRepository<VideoAula, Long> {
	
}