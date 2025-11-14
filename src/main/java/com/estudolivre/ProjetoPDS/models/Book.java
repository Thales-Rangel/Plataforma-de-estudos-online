package com.estudolivre.ProjetoPDS.models;

import java.util.Arrays;

import jakarta.persistence.Entity;

@Entity
public class Book extends Materials {
	private byte[] file;

	public byte[] getDatFile() {
		return file;
	}

	public void setFile(byte[] data) {
		this.file = data;
	}

	@Override
	public String toString() {
		return "Book [data=" + Arrays.toString(file) + "]";
	}
	
}
