package com.sfu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sfu.dao.GoodsTypeDao;
import com.sfu.entity.classify;
import com.sfu.utils.JdbcUtils;

public class GoodsTypeDaoImpl implements GoodsTypeDao{
	private QueryRunner qr = JdbcUtils.getQuerrRunner();
	@Override
	public void add(classify goodtype) {
		try {
			String sql="insert into classify(cl_cate) values(?);";
			qr.update(sql,goodtype.getCl_cate());
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void delete(int id) {
		try {
			String sql ="DELETE FROM classify WHERE cl_id=?";
			qr.update(sql,id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void update(classify goodtype) {
		try {
			String sql ="UPDATE classify SET cl_cate=? WHERE cl_id =?";
			qr.update(sql,goodtype.getCl_cate(),goodtype.getCl_id());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<classify>query(){
		try {
			String sql ="SELECT * FROM classify";
			return  qr.query(sql,new BeanListHandler<classify>(classify.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public classify findById(int id) {
		try {
			String sql ="SELECT * FROM classify where cl_id =?";
			return qr.query(sql,new BeanHandler<classify>(classify.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<classify> query(String keyword){
		try {
			String sql ="SELECT * FROM classify WHERE cl_cate LIKE ?";
			return qr.query(sql,new BeanListHandler<classify>(classify.class) , "%"+keyword+"%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Integer getFirstType(){
		try {
			String sql = "select * from classify";
			return qr.query(sql, new ScalarHandler<Integer>());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
