package com.sfu.utils;

public class Condition {
	private String goodsName;
	private int goodsType_id;
	
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsType_id() {
		return goodsType_id;
	}

	public void setGoodsType_id(int goodsType_id) {
		this.goodsType_id = goodsType_id;
	}

	@Override
	public String toString() {
		return "Condition [goodsName=" + goodsName + ", goodsType_id=" + goodsType_id + "]";
	}

	


}
