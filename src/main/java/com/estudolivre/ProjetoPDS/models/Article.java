package com.estudolivre.ProjetoPDS.models;

import java.util.Arrays;

import jakarta.persistence.Entity;

@Entity
public class Article extends Materials {
	
	private byte [] file;

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Article [file=" + Arrays.toString(file) + "]";
	}

}
