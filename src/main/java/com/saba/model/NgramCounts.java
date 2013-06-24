package com.saba.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NgramCounts {
	private Map<Uvw,Integer> cuvw = new HashMap<Uvw,Integer>();
	private Map<Uv,Integer> cuv = new HashMap<Uv,Integer>();
	private Map<U,Integer> cu = new HashMap<U,Integer>();
	public Map<Uvw, Integer> getCuvw() {
		return cuvw;
	}
	public void setCuvw(Map<Uvw, Integer> cuvw) {
		this.cuvw = cuvw;
	}
	public Map<Uv, Integer> getCuv() {
		return cuv;
	}
	public void setCuv(Map<Uv, Integer> cuv) {
		this.cuv = cuv;
	}
	public Map<U, Integer> getCu() {
		return cu;
	}
	public void setCu(Map<U, Integer> cu) {
		this.cu = cu;
	}
	
}




