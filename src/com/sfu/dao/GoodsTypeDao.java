package com.sfu.dao;

import java.util.List;

import com.sfu.entity.classify;

public interface GoodsTypeDao {
	void add(classify goodtype);
	void delete(int id);
	void update(classify goodtype);
	List<classify>query();
	classify findById(int id);
	List<classify> query(String keyword);
	
	Integer getFirstType();
}
