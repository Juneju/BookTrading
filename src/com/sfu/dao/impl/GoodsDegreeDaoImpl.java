package com.sfu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sfu.dao.GoodsDegreeDao;
import com.sfu.entity.Degree;
import com.sfu.entity.classify;
import com.sfu.utils.JdbcUtils;

public class GoodsDegreeDaoImpl implements GoodsDegreeDao {
	private QueryRunner qr = JdbcUtils.getQuerrRunner();
	@Override
	public void add(Degree gooddegree) {
		try {
			String sql="insert into degree(d_degree) values(?);";
			qr.update(sql,gooddegree.getD_degree());
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void delete(int id) {
		try {
			String sql ="DELETE FROM degree WHERE d_id=?";
			qr.update(sql,id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void update(Degree gooddegree) {
		try {
			String sql ="UPDATE degree SET d_degree=? WHERE d_id =?";
			qr.update(sql,gooddegree.getD_degree(),gooddegree.getD_id());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<Degree>query(){
		try {
			String sql ="SELECT * FROM degree";
			return  qr.query(sql,new BeanListHandler<Degree>(Degree.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public Degree findById(int id) {
		try {
			String sql ="SELECT * FROM degree where d_id =?";
			return qr.query(sql,new BeanHandler<Degree>(Degree.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<Degree> query(String keyword){
		try {
			String sql ="SELECT * FROM degree WHERE d_degree LIKE ?";
			return qr.query(sql,new BeanListHandler<Degree>(Degree.class) , "%"+keyword+"%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Integer getFirstType() {
		try {
			String sql = "select * from degree";
			return qr.query(sql, new ScalarHandler<Integer>());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
