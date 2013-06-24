package com.saba.model;

import java.io.Serializable;

public class U implements Serializable{
	private String u;

	
	@Override
	public String toString() {
		return "U [u=" + u + "]";
	}

	public U(String u) {
		super();
		this.u = u;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((u == null) ? 0 : u.hashCode());
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
		U other = (U) obj;
		if (u == null) {
			if (other.u != null)
				return false;
		} else if (!u.equals(other.u))
			return false;
		return true;
	}

	public String getU() {
		return u;
	}

	public void setU(String u) {
		this.u = u;
	}

	
	
	

}