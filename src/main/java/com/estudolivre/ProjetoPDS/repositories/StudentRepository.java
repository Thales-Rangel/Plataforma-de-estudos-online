package com.estudolivre.ProjetoPDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudolivre.ProjetoPDS.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
