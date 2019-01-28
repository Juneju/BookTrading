package com.sfu.entity;

public class classify {
	private int cl_id;
	private String cl_cate;
	public int getCl_id() {
		return cl_id;
	}
	public void setCl_id(int cl_id) {
		this.cl_id = cl_id;
	}
	public String getCl_cate() {
		return cl_cate;
	}
	public void setCl_cate(String cl_cate) {
		this.cl_cate = cl_cate;
	}
	@Override
	public String toString() {
		return "classify [cl_id=" + cl_id + ", cl_cate=" + cl_cate + "]";
	}
	
}
