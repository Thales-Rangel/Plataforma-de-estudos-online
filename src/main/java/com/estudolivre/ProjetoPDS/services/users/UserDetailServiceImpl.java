package com.estudolivre.ProjetoPDS.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.estudolivre.ProjetoPDS.models.users.Users;
import com.estudolivre.ProjetoPDS.repositories.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users byEmail = repository.findByEmail(username);
		
		if (byEmail == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return byEmail;
	}

}
