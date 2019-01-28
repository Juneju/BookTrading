package com.sfu.service.impl;

import java.util.List;

import com.sfu.dao.UsersCampusDao;
import com.sfu.entity.Campus;
import com.sfu.entity.Users;
import com.sfu.entity.classify;
import com.sfu.factory.BeanFactory;
import com.sfu.service.UserCampusService;

public class UserCampusServiceImpl implements UserCampusService {
	UsersCampusDao dao=BeanFactory.getInstance("usersCampusDao", UsersCampusDao.class);

	@Override
	public void add(Campus campus) {
		dao.add(campus);
		
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}

	@Override
	public void update(Campus campus) {
		dao.update(campus);
		
	}

	@Override
	public List<Campus> query() {
		return dao.query();
	}

	@Override
	public Campus findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Campus> query(String keyword) {
		return dao.query(keyword);
	}

	@Override
	public Integer getFirstType() {
		return dao.getFirstType();
	}
	
	
}
