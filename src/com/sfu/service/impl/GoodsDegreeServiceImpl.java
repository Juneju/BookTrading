package com.sfu.service.impl;

import java.util.List;

import com.sfu.dao.GoodsDegreeDao;
import com.sfu.entity.Degree;
import com.sfu.factory.BeanFactory;
import com.sfu.service.GoodsDegreeService;

public class GoodsDegreeServiceImpl implements GoodsDegreeService{
	GoodsDegreeDao dao=BeanFactory.getInstance("goodsDegreeDao", GoodsDegreeDao.class);
	@Override
	public void add(Degree gooddegree) {
		dao.add(gooddegree);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(Degree gooddegree) {
		// TODO Auto-generated method stub
		dao.update(gooddegree);
	}

	@Override
	public List<Degree> query() {
		// TODO Auto-generated method stub
		return dao.query();
	}

	@Override
	public Degree findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Degree> query(String keyword) {
		// TODO Auto-generated method stub
		return dao.query(keyword);
	}

	@Override
	public Integer getFirstType() {
		// TODO Auto-generated method stub
		return dao.getFirstType();
	}

}
