package com.estudolivre.ProjetoPDS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(autorize -> autorize
				.requestMatchers("/").permitAll()
				.requestMatchers("/usuarios/forms").permitAll()
				.requestMatchers("/usuarios/estudante/form").permitAll()
				.requestMatchers("/usuarios/professor/form").permitAll()
				.requestMatchers(HttpMethod.POST, "/usuarios/estudante").permitAll()
				.requestMatchers(HttpMethod.POST, "/usuarios/professor").permitAll()
				.anyRequest().authenticated()
				)
		.formLogin(formLogin -> formLogin
				.loginPage("/login")
				.permitAll()
				.successForwardUrl("/")
		)
		.logout(logout -> logout.permitAll());

		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
