package com.sfu.entity;

public class Degree {
	private int d_id;
	private String d_degree;
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_degree() {
		return d_degree;
	}
	public void setD_degree(String d_degree) {
		this.d_degree = d_degree;
	}
	@Override
	public String toString() {
		return "Degree [d_id=" + d_id + ", d_degree=" + d_degree + "]";
	}
	
}
