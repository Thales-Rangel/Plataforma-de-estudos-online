package com.estudolivre.ProjetoPDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudolivre.ProjetoPDS.models.users.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	
	Users findByEmail(String email);

}
