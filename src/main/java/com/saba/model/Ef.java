package com.saba.model;


public class Ef{
	private String e;
	private String f;
	private String eIndex;
	private String fIndex;
	
	
	public Ef(String e, String f) {
		super();
		this.e = e;
		this.f = f;
		this.eIndex = e.length() >20 ? e.substring(0,20): e;
		this.fIndex = f.length() >20 ? f.substring(0,20) : f;
	}
	
	public String getE() {
		return e;
	}
	
	public String getF() {
		return f;
	}
	
	public String geteIndex() {
		return eIndex;
	}
	
	public String getfIndex() {
		return fIndex;
	}
	
	public void seteIndex(String eIndex) {
		this.eIndex = eIndex;
	}
	
	public void setfIndex(String fIndex) {
		this.fIndex = fIndex;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		result = prime * result + ((f == null) ? 0 : f.hashCode());
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
		Ef other = (Ef) obj;
		if (e == null) {
			if (other.e != null)
				return false;
		} else if (!e.equals(other.e))
			return false;
		if (f == null) {
			if (other.f != null)
				return false;
		} else if (!f.equals(other.f))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Ef [e=" + e + ", f=" + f + "]";
	}
	
	
	
}
