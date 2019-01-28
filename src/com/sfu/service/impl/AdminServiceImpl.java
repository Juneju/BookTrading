package com.sfu.service.impl;

import com.sfu.dao.AdminDao;
import com.sfu.entity.Admin;
import com.sfu.factory.BeanFactory;
import com.sfu.service.AdminServiceService;

public class AdminServiceImpl implements AdminServiceService{
	AdminDao dao=BeanFactory.getInstance("adminDao", AdminDao.class);
	@Override
	public boolean existAdmin(Admin us) {
		return dao.existAdmin(us);
	}

	@Override
	public boolean IsAdmin(Admin us) {
		// TODO Auto-generated method stub
		return dao.IsAdmin(us);
	}
	
}
