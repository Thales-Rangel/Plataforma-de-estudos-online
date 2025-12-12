package com.estudolivre.ProjetoPDS.services.users;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estudolivre.ProjetoPDS.models.Papeis;
import com.estudolivre.ProjetoPDS.models.users.Teacher;
import com.estudolivre.ProjetoPDS.repositories.PapeisRepository;
import com.estudolivre.ProjetoPDS.repositories.users.TeachersRepository;

@Service
public class TeachersService {
	
	@Autowired
	private TeachersRepository teachersRepository;
	@Autowired
	private PapeisRepository papeisRepository;
	
	public void saveTeacher(Teacher teacher) throws SQLIntegrityConstraintViolationException {
		String encode = new BCryptPasswordEncoder().encode(teacher.getSenha());
		teacher.setSenha(encode);
		
		Papeis byNome = papeisRepository.findByNome("ROLE_TEACHER");
		List<Papeis> papeis = new ArrayList<Papeis>();
		papeis.add(byNome);
		
		teacher.setPapeis(papeis);
		
		teachersRepository.save(teacher);
	}
	
	public List<Teacher> listAllTeachers(){
		List<Teacher> all = teachersRepository.findAll();
		return all.stream().toList();
	}
	
	public void delete(Long id) {
		Optional<Teacher> byId = teachersRepository.findById(id);
		
		if (byId.isEmpty()) {
			return;
		}
		
		Teacher teacher = byId.get();
		teachersRepository.delete(teacher);
	}
	
	public Teacher findById(Long id) {
		Optional<Teacher> byId = teachersRepository.findById(id);
		if (byId.isEmpty()) {
			return null;
		}
		
		Teacher teacher = byId.get();
		return teacher;
	}

}
