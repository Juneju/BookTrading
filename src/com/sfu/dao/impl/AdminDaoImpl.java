package com.sfu.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.sfu.dao.AdminDao;
import com.sfu.entity.Admin;
import com.sfu.entity.Users;
import com.sfu.utils.JdbcUtils;
//对于AdminDao接口的实现
public class AdminDaoImpl implements AdminDao{
	private QueryRunner qr=JdbcUtils.getQuerrRunner();
	@Override
	public boolean existAdmin(Admin us) {
		int k=-1;
		try {
			String sql="select uid from admin where a_id=?;";
			Admin u=qr.query(sql, new BeanHandler<Admin>(Admin.class),us.getA_id());
			k=u.getA_id();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		if(k!=-1) return true;
		else return false;
	}
	public boolean IsAdmin(Admin us) {
		int k=-1;
		try {
			String sql="select a_id from admin where a_id=? and a_pwd=?;";
			Admin u=qr.query(sql,new BeanHandler<Admin>(Admin.class),us.getA_id(),us.getA_pwd());
			k=u.getA_id();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		if(k!=-1) return true;
		else return false;
	}
}
