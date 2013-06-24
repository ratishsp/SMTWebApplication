package com.saba.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="cuvw")
public class Cuvw {
	private Uvw uvw;
	private Integer c;
	
	public Cuvw() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Cuvw(Uvw uvw, Integer c) {
		super();
		this.uvw = uvw;
		this.c = c;
	}


	public Uvw getUvw() {
		return uvw;
	}
	public void setUvw(Uvw uvw) {
		this.uvw = uvw;
	}
	public Integer getC() {
		return c;
	}
	public void setC(Integer c) {
		this.c = c;
	}
	
	
}
