package com.sfu.service.impl;

import java.util.List;

import com.sfu.dao.GoodsDao;
import com.sfu.entity.Goods;
import com.sfu.factory.BeanFactory;
import com.sfu.service.GoodsService;
import com.sfu.utils.PageBean;

public class GoodsServiceImpl implements GoodsService{
	GoodsDao dao=BeanFactory.getInstance("goodsDao", GoodsDao.class);
	
	

	@Override
	public List<Goods> deal() {
		return dao.deal();
	}

	@Override
	public void changeState(int id, int uid) {
		dao.changeState(id, uid);
		
	}

	@Override
	public List<Goods> deal(int uid) {
		return dao.deal(uid);
	}

	@Override
	public void add(Goods goods) {
		dao.add(goods);		
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}

	@Override
	public void update(Goods good) {
		dao.update(good);
		
	}

	@Override
	public List<Goods> query() {
		List<Goods>g=dao.query();
		for(Goods f:g) {
			System.out.println(f+"SS");
			
		}
		return g;
	}

	@Override
	public Goods findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Goods> query(String keyword) {
		return dao.query(keyword);
	}

	@Override
	public List<Goods> findByType(int type) {
		return dao.findByType(type);
	}

	@Override
	public void getAll(PageBean<Goods> pb) {
		// TODO Auto-generated method stub
		//dao.getAll(pb);
	}

	@Override
	public int getTotalCount(PageBean<Goods> pb) {
		// TODO Auto-generated method stub
		return dao.getTotalCount(pb);
	}

	@Override
	public List<Goods> findByUser(int type) {
		// TODO Auto-generated method stub
		return dao.findByUser(type);
	}

}
