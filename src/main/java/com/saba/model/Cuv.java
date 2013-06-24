package com.saba.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="cuv")
public class Cuv {
	
	public Cuv() {
		// TODO Auto-generated constructor stub
	}
	
	private Uv uv;
	private Integer c;

	
	public Cuv(Uv uv, Integer c) {
		super();
		this.uv = uv;
		this.c = c;
	}
	public Uv getUv() {
		return uv;
	}
	public void setUv(Uv uv) {
		this.uv = uv;
	}
	public Integer getC() {
		return c;
	}
	public void setC(Integer c) {
		this.c = c;
	}
	
	
}
