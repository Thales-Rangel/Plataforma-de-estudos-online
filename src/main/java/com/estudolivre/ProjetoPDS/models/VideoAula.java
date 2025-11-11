package com.estudolivre.ProjetoPDS.models;
import jakarta.persistence.*;

public class VideoAula extends Materials {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 private String nome;
	 private String tipo;

	 @Lob
	 private byte[] dados;

	 public Long getId() { 
	 return id; 
	 }
	 public void setId(Long id) { 
	 this.id = id; 
	 }

	 public String getNome() { 
     return nome; 
     }
	 public void setNome(String nome) { 
	 this.nome = nome; 
	 }

	 public String getTipo() { 
	 return tipo; 
	 }
	 public void setTipo(String tipo) { 
	 this.tipo = tipo; 
	 }

	 public byte[] getDados() { 
	 return dados; 
	 }
	 public void setDados(byte[] dados) { 
	 this.dados = dados; 
	 }
}
