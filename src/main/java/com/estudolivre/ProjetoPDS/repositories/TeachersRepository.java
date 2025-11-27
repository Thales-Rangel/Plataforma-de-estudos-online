package com.estudolivre.ProjetoPDS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudolivre.ProjetoPDS.models.Teacher;

@Repository
public interface TeachersRepository extends JpaRepository<Teacher, Long> {

}
