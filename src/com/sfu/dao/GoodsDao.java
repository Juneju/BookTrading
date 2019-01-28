package com.sfu.dao;

import java.util.List;

import com.sfu.entity.Goods;
import com.sfu.utils.PageBean;

public interface GoodsDao {
	void add(Goods goods);
	void delete(int id);
	void update(Goods good);
	List<Goods>query();
	Goods findById(int id);
	List<Goods>query(String keyword);
	List<Goods>findByType(int type);
	List<Goods>findByUser(int type);
	void getAll(PageBean<Goods>pb);
	int getTotalCount(PageBean<Goods>pb);
	void changeState(int id,int uid);
	List<Goods>deal(int uid);
	List<Goods>deal();
}
