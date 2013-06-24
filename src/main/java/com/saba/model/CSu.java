package com.saba.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="cSu")
public class CSu {
	private U u;
	private Integer c;
	
	public CSu() {
		// TODO Auto-generated constructor stub
	}
	
	
	public CSu(U u, Integer c) {
		super();
		this.u = u;
		this.c = c;
	}


	public U getU() {
		return u;
	}
	public void setU(U u) {
		this.u = u;
	}
	public Integer getC() {
		return c;
	}
	public void setC(Integer c) {
		this.c = c;
	}
	
}
