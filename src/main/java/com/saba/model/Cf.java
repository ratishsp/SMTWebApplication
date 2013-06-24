package com.saba.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cf")
public class Cf {
	
	private String f;
	private Integer c;
	
	
	public String getF() {
		return f;
	}


	public void setF(String f) {
		this.f = f;
	}


	public Integer getC() {
		return c;
	}


	public void setC(Integer c) {
		this.c = c;
	}


	public Cf() {
		// TODO Auto-generated constructor stub
	}


	public Cf(String f, Integer c) {
		super();
		this.f = f;
		this.c = c;
	}
	
	
	
}
