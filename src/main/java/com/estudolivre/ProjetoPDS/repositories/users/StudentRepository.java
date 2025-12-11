package com.estudolivre.ProjetoPDS.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudolivre.ProjetoPDS.models.users.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Student findByEmail(String email);

}
