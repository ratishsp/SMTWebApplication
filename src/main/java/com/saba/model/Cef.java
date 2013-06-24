package com.saba.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cef")
public class Cef {

	private Ef ef;
	private int c;
	
	public Cef() {
		// TODO Auto-generated constructor stub
	}
	
	public Cef(Ef key, int i) {
		this.ef = key;
		this.c = i;
	}
	
	public void setC(int c) {
		this.c = c;
	}
	
	public void setEf(Ef ef) {
		this.ef = ef;
	}
	
	public int getC() {
		return c;
	}
	
	public Ef getEf() {
		return ef;
	}
	
	
	

}
