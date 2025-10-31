package com.estudolivre.ProjetoPDS.models;

import java.util.Arrays;

import jakarta.persistence.Entity;

@Entity
public class Book extends Materials {
	
	private byte[] data;

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Book [data=" + Arrays.toString(data) + "]";
	}
	
}
