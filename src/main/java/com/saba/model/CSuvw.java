package com.saba.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="cSuvw")
public class CSuvw {
	private Uvw uvw;
	private Integer c;
	
	public CSuvw() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CSuvw(Uvw uvw, Integer c) {
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
