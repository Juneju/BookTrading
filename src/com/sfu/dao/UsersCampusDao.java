package com.sfu.dao;

import java.util.List;

import com.sfu.entity.Campus;
import com.sfu.entity.classify;

public interface UsersCampusDao {
	void add(Campus campus);
	void delete(int id);
	void update(Campus campus);
	List<Campus>query();
	Campus findById(int id);
	List<Campus> query(String keyword);
	Integer getFirstType();
}
