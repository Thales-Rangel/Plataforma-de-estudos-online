package com.estudolivre.ProjetoPDS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudolivre.ProjetoPDS.models.Admin;
import com.estudolivre.ProjetoPDS.repositories.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
	public List<Admin> listAllAdmins(){
		List<Admin> all = adminRepository.findAll();
		return all.stream().toList();
	}
	
	public void delete(Long id) {
		Optional<Admin> byId = adminRepository.findById(id);
		if (byId.isEmpty()) {
			return;
		}
		
		Admin admin = byId.get();
		adminRepository.delete(admin);
	}
	
	public Admin findById(Long id) {
		Optional<Admin> byId = adminRepository.findById(id);
		if (byId.isEmpty()) {
			return null;
		}
		
		Admin admin = byId.get();
		return admin;
	}

}
