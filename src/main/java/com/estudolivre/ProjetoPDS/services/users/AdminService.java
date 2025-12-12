package com.estudolivre.ProjetoPDS.services.users;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estudolivre.ProjetoPDS.models.Papeis;
import com.estudolivre.ProjetoPDS.models.users.Admin;
import com.estudolivre.ProjetoPDS.repositories.PapeisRepository;
import com.estudolivre.ProjetoPDS.repositories.users.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private PapeisRepository papeisRepository;

	public void saveAdmin(Admin admin) throws SQLIntegrityConstraintViolationException {
		String encode = new BCryptPasswordEncoder().encode(admin.getSenha());
		admin.setSenha(encode);

		Papeis byNome = papeisRepository.findByNome("ROLE_ADMIN");
		List<Papeis> list = new ArrayList<Papeis>();
		list.add(byNome);
		admin.setPapeis(list);

		adminRepository.save(admin);
	}

	public List<Admin> listAllAdmins() {
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
