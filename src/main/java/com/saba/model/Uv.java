package com.saba.model;

import java.io.Serializable;

public class Uv implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String u;
	private String v;
	
	
	@Override
	public String toString() {
		return "Uv [u=" + u + ", v=" + v + "]";
	}
	public Uv(String u, String v) {
		super();
		this.u = u;
		this.v = v;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((u == null) ? 0 : u.hashCode());
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uv other = (Uv) obj;
		if (u == null) {
			if (other.u != null)
				return false;
		} else if (!u.equals(other.u))
			return false;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		return true;
	}
	
	public String getU() {
		return u;
	}
	public void setU(String u) {
		this.u = u;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	
}