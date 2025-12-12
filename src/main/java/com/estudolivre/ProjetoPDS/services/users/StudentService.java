package com.estudolivre.ProjetoPDS.services.users;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estudolivre.ProjetoPDS.models.Papeis;
import com.estudolivre.ProjetoPDS.models.users.Student;
import com.estudolivre.ProjetoPDS.repositories.PapeisRepository;
import com.estudolivre.ProjetoPDS.repositories.users.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private PapeisRepository papeisRepository;
	
	public void saveStudent(Student student) throws SQLIntegrityConstraintViolationException {
		String encode = new BCryptPasswordEncoder().encode(student.getSenha());
		student.setSenha(encode);
		
		Papeis byNome = papeisRepository.findByNome("ROLE_STUDENT");
		List<Papeis> papeis = new ArrayList<Papeis>();
		papeis.add(byNome);
		
		student.setPapeis(papeis);
		
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
