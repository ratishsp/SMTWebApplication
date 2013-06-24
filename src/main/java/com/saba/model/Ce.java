package com.saba.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ce")
public class Ce {
	
	private String e;
	private Integer c;
	
	
	public String getE() {
		return e;
	}


	public void setE(String e) {
		this.e = e;
	}


	public Integer getC() {
		return c;
	}


	public void setC(Integer c) {
		this.c = c;
	}


	public Ce() {
		// TODO Auto-generated constructor stub
	}


	public Ce(String e, Integer c) {
		super();
		this.e = e;
		this.c = c;
	}
	
	
	
}
