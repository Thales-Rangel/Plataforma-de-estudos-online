package com.estudolivre.ProjetoPDS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudolivre.ProjetoPDS.models.Student;
import com.estudolivre.ProjetoPDS.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	
	public List<Student> listAllStudents(){
		List<Student> all = studentRepository.findAll();
		return all.stream().toList();
	}
	
	public void delete(Long id) {
		Optional<Student> byId = studentRepository.findById(id);
		
		if (byId.isEmpty()) {
			return;
		}
		
		Student student = byId.get();
		studentRepository.delete(student);
	}
	
	public Student findById(Long id) {
		Optional<Student> byId = studentRepository.findById(id);
		if (byId.isEmpty()) {
			return null;
		}
		
		Student student = byId.get();
		return student;
	}
}
