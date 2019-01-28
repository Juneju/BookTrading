package com.sfu.service;

import java.util.List;

import com.sfu.entity.Goods;
import com.sfu.utils.PageBean;

public interface GoodsService {
	void add(Goods goods);
	void delete(int id);
	void update(Goods good);
	List<Goods>query();
	Goods findById(int id);
	List<Goods>query(String keyword);
	List<Goods>findByType(int type);
	void getAll(PageBean<Goods>pb);
	int getTotalCount(PageBean<Goods>pb);
	List<Goods>findByUser(int type);
	void changeState(int id,int uid);
	List<Goods>deal(int uid);
	List<Goods>deal();
}
