package com.estudolivre.ProjetoPDS.models;

import jakarta.persistence.*;

@Entity
public class VideoAula extends Materials {

	// ADICIONE ESSA LINHA AQUI EMBAIXO:
	private String urlVideo;
	private String tipo;

	@Lob
	private byte[] dados;

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

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

}