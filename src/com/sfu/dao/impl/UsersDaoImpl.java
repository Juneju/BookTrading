package com.sfu.dao.impl;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sfu.dao.UsersDao;
import com.sfu.entity.Users;
import com.sfu.utils.JdbcUtils;

public class UsersDaoImpl implements UsersDao {
	private QueryRunner qr=JdbcUtils.getQuerrRunner();
	@Override
	public boolean existUser(Users us) {
		int k=-1;
		try {
			String sql="select uid from user where uid=?;";
			Users u=qr.query(sql, new BeanHandler<Users>(Users.class),us.getUid());
			k=u.getUid();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		if(k!=-1) return true;
		else return false;
	}
	public boolean IsUser(Users us) {
		int k=-1;
		try {
			String sql="select uid from user where uid=? and pwd=?;";
			Users u=qr.query(sql,new BeanHandler<Users>(Users.class),us.getUid(),us.getPwd());
			k=u.getUid();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		if(k!=-1) return true;
		else return false;
	}
	
	public void add(Users us) {
		try {
			String sql="insert into user(uid,uname,pwd,utel,ucampus) values(?,?,?,?,?);";
			qr.update(sql,us.getUid(),us.getUname(),us.getPwd(),us.getUtel(),us.getUcampus());
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void  update(Users us) {
		String sql = "update user set pwd=?, uname=?, utel=?, ucampus=? where uid=?;";
		try {
			qr.update(sql,us.getPwd(),us.getUname(),us.getUtel(),us.getUcampus(),us.getUid());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void  update2(Users us) {
		String sql = "update user set  uname=?, utel=?, ucampus=? where uid=?;";
		try {
			qr.update(sql,us.getUname(),us.getUtel(),us.getUcampus(),us.getUid());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public List<Users>query(){
		String sql = "select * from user;";
		try {
			return qr.query(sql, new BeanListHandler<Users>(Users.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public List<Users>search(int id){
		String sql = "select * from user where uid=?";
		try {
			return qr.query(sql, new BeanListHandler<Users>(Users.class),id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public Users findById(int id) {
		String sql = "select * from user where uid=?;";
		try {
			return qr.query(sql, new BeanHandler<Users>(Users.class),id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void quitUser(int id) {
		String sql = "delete from user where uid=?;";
		try {
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
}
