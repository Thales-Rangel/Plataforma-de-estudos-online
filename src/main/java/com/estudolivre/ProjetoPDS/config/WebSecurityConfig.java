package com.estudolivre.ProjetoPDS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(autorize -> autorize
				.requestMatchers("/").permitAll()
				.anyRequest().authenticated()
				)
		.formLogin(formLogin -> formLogin
				.loginPage("/login")
				.permitAll())
		.logout(logout -> logout.permitAll());

		return http.build();
	}

}
