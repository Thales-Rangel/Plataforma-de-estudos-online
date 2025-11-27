package com.estudolivre.ProjetoPDS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudolivre.ProjetoPDS.models.Teacher;
import com.estudolivre.ProjetoPDS.repositories.TeachersRepository;

@Service
public class TeachersService {
	
	@Autowired
	private TeachersRepository teachersRepository;
	
	public void saveTeacher(Teacher teacher) {
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
