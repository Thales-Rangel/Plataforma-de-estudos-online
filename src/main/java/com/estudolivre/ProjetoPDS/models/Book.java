package com.estudolivre.ProjetoPDS.models;

import java.util.Arrays;

import jakarta.persistence.Entity;

@Entity
public class Book extends Materials {
	private byte[] file;

	public byte[] getDatFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Book [file=" + Arrays.toString(file) + "]";
	}
	
}
