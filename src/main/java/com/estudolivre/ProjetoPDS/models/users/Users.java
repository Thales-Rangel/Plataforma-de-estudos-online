package com.estudolivre.ProjetoPDS.models.users;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.estudolivre.ProjetoPDS.models.Papeis;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Users implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String nomeCompleto;
	@Column(unique = true)
	protected String email;
	protected String senha;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Papeis> papeis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Papeis> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papeis> papeis) {
		this.papeis = papeis;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", nomeCompleto=" + nomeCompleto + ", email=" + email + ", senha=" + senha + "]";
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.papeis;
	}
	@Override
	public String getPassword() {
		return this.senha;
	}
	@Override
	public String getUsername() {
		return this.email;
	}

}
