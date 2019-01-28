package com.sfu.service.impl;

import java.util.List;

import com.sfu.dao.UsersDao;
import com.sfu.entity.Users;
import com.sfu.factory.BeanFactory;
import com.sfu.service.UserService;

public class UserServiceImpl implements UserService {
	UsersDao dao=BeanFactory.getInstance("usersDao", UsersDao.class);

	@Override
	public boolean existUser(Users us) {
		return dao.existUser(us);
	}

	@Override
	public List<Users> search(int id) {
		return dao.search(id);
	}

	@Override
	public boolean IsUser(Users us) {
		return dao.IsUser(us);
	}

	@Override
	public void add(Users us) {
		dao.add(us);
		
	}

	@Override
	public void update(Users us) {
		dao.update(us);
		
	}

	@Override
	public void update2(Users us) {
		dao.update2(us);
		
	}

	@Override
	public List<Users> query() {
		return dao.query();
	}

	@Override
	public Users findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void quitUser(int id) {
		dao.quitUser(id);
		
	}
	
}
