package com.estudolivre.ProjetoPDS.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudolivre.ProjetoPDS.models.users.Teacher;

@Repository
public interface TeachersRepository extends JpaRepository<Teacher, Long> {
	
	Teacher findByEmail(String email);

}
