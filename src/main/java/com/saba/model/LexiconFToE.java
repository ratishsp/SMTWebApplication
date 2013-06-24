package com.saba.model;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class LexiconFToE {
	private String f;
	private Set<String> e;
	
	public LexiconFToE() {
		// TODO Auto-generated constructor stub
	}
	public LexiconFToE(String f, Set<String> e) {
		super();
		this.f = f;
		this.e = e;
	}
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	public Set<String> getE() {
		return e;
	}
	public void setE(Set<String> e) {
		this.e = e;
	}
	
	
}
