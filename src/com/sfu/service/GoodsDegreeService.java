package com.sfu.service;

import java.util.List;

import com.sfu.entity.Degree;

public interface GoodsDegreeService {
	void add(Degree gooddegree);
	void delete(int id);
	void update(Degree gooddegree);
	List<Degree>query();
	Degree findById(int id);
	List<Degree> query(String keyword);
	
	Integer getFirstType();
}
