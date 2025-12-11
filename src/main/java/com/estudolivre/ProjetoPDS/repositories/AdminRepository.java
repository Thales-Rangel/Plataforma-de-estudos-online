package com.estudolivre.ProjetoPDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudolivre.ProjetoPDS.models.users.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	Admin findByEmail(String email);
	
	Admin findByPasse(Long passe);

}
