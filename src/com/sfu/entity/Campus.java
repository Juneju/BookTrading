package com.sfu.entity;

public class Campus {
	private int c_id;
	private String c_name;
	private String c_add;
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_add() {
		return c_add;
	}
	public void setC_add(String c_add) {
		this.c_add = c_add;
	}
	@Override
	public String toString() {
		return "Campus [c_id=" + c_id + ", c_name=" + c_name + ", c_add=" + c_add + "]";
	}
	
}
