package com.sfu.service.impl;

import java.util.List;

import com.sfu.dao.GoodsTypeDao;
import com.sfu.entity.classify;
import com.sfu.factory.BeanFactory;
import com.sfu.service.GoodsTypeService;

public class GoodsTypeServiceImpl implements GoodsTypeService {
	GoodsTypeDao dao=BeanFactory.getInstance("goodsTypeDao", GoodsTypeDao.class);
	@Override
	public void add(classify goodtype) {
		dao.add(goodtype);
		
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}

	@Override
	public void update(classify goodtype) {
		dao.update(goodtype);
		
	}

	@Override
	public List<classify> query() {
		return dao.query();
	}

	@Override
	public classify findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<classify> query(String keyword) {
		return dao.query(keyword);
	}

	@Override
	public Integer getFirstType() {
		return dao.getFirstType();
	}
	
}
