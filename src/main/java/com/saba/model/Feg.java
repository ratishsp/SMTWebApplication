package com.saba.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feg {
	private Ef ef;
	private Double g;
	public Ef getEf() {
		return ef;
	}
	public void setEf(Ef ef) {
		this.ef = ef;
	}
	public Double getG() {
		return g;
	}
	public void setG(Double g) {
		this.g = g;
	}
	
	
	public Feg() {
		// TODO Auto-generated constructor stub
	}
	public Feg(Ef ef, Double g) {
		super();
		this.ef = ef;
		this.g = g;
	}

	
	
}
