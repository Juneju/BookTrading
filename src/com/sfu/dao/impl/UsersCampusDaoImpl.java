package com.sfu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sfu.dao.UsersCampusDao;
import com.sfu.entity.Campus;
import com.sfu.entity.classify;
import com.sfu.utils.JdbcUtils;

public class UsersCampusDaoImpl implements UsersCampusDao{
	private QueryRunner qr = JdbcUtils.getQuerrRunner();
	@Override
	public void add(Campus campus) {
		try {
			String sql="insert into Campus(c_name,c_add) values(?,?);";
			qr.update(sql,campus.getC_name(),campus.getC_add());
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			String sql ="DELETE FROM campus WHERE c_id=?";
			qr.update(sql,id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(Campus campus) {
		try {
			String sql ="UPDATE campus SET c_name=?,c_add=? WHERE c_id =?";
			qr.update(sql,campus.getC_name(),campus.getC_add(),campus.getC_id());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Campus> query() {
		try {
			String sql ="SELECT * FROM campus";
			return  qr.query(sql,new BeanListHandler<Campus>(Campus.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Campus findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Campus> query(String keyword) {
		try {
			String sql ="SELECT * FROM Campus WHERE c_name LIKE ?";
			return qr.query(sql,new BeanListHandler<Campus>(Campus.class) , "%"+keyword+"%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Integer getFirstType() {
		try {
			String sql = "select * from Campus";
			return qr.query(sql, new ScalarHandler<Integer>());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
