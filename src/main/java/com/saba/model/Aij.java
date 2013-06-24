/**
 * 
 */
package com.saba.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author rpuduppully
 *
 */
@Document(collection="aij")
public class Aij {
	private String r;
	
	private int[][] ij;
	
	public Aij() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Aij(String r, int[][] ij) {
		super();
		this.r = r;
		this.ij = ij;
	}

	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	public int[][] getIj() {
		return ij;
	}
	public void setIj(int[][] ij) {
		this.ij = ij;
	}
	
	

}
