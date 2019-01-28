package com.sfu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sfu.dao.GoodsDao;
import com.sfu.entity.Goods;
import com.sfu.entity.Users;
import com.sfu.utils.Condition;
import com.sfu.utils.JdbcUtils;
import com.sfu.utils.PageBean;

public class GoodsDaoImpl implements GoodsDao{
	private QueryRunner qr = JdbcUtils.getQuerrRunner();
	
	
	@Override
	public void changeState(int id,int uid) {
		String sql="update goods set gdeal=1 , gbid=? where gid=?";
		try {
			qr.update(sql,uid,id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	@Override
	public List<Goods> deal() {
		String sql="select * from goods where gdeal=1 ";
		try {
			return  qr.query(sql,new BeanListHandler<Goods>(Goods.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<Goods> deal(int uid) {
		String sql="select * from goods where gdeal=1 and (guid=? or gbid=?);";
		try {
			return  qr.query(sql,new BeanListHandler<Goods>(Goods.class),uid,uid);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void add(Goods goods) {
		String sql="insert into goods(gname,gdetail,gprice,gimg,gclass,gdegree,guid,gindex) values(?,?,?,?,?,?,?,?);";
		try {
			qr.update(sql,goods.getGname(),goods.getGdetail(),goods.getGprice(),goods.getGimg(),goods.getGclass(),goods.getGdegree(),goods.getGuid(),goods.getGindex());
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void delete(int id) {
		try {
			String sql ="DELETE FROM goods WHERE gid=?";
			qr.update(sql,id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void update(Goods goods) {
		try {
			String sql ="update goods set gname=? ,gdetail=?,gprice=?,gimg=?,gclass=?,gdegree=? ,gindex=? where gid=? ";
			qr.update(sql,goods.getGname(),goods.getGdeal(),goods.getGprice(),goods.getGimg(),goods.getGclass(),goods.getGdegree(),goods.getGindex(),goods.getGuid());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<Goods>query(){
		try {
			String sql ="SELECT * FROM goods ";
			return  qr.query(sql,new BeanListHandler<Goods>(Goods.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public Goods findById(int id) {
		try {
			String sql ="SELECT * FROM goods where gid =?";
			return qr.query(sql,new BeanHandler<Goods>(Goods.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<Goods>query(String keyword){
		try {
			String sql ="SELECT * FROM goods WHERE gname LIKE ?";
			return qr.query(sql,new BeanListHandler<Goods>(Goods.class) , "%"+keyword+"%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<Goods>findByType(int type){
		try {
			String sql ="SELECT * FROM goods WHERE gclass =?";
			return qr.query(sql, new BeanListHandler<Goods>(Goods.class), type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void getAll(PageBean<Goods>pb) {
		int totalCount=this.getTotalCount(pb);
		pb.setTotalCount(totalCount);
		List<Object>list=new ArrayList<Object>();
		if (pb.getCurrentPage() <=0) {
			pb.setCurrentPage(1);					    // 把当前页设置为1
		} else if (pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());		// 把当前页设置为最大页数
		}
		int currentPage = pb.getCurrentPage();
		int index = (currentPage -1 ) * pb.getPageCount();		// 查询的起始行 
		int count = pb.getPageCount();	
		Condition condition = pb.getCondition();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append("     	g.g_id,");
		sb.append("     	g.g_name,");
		sb.append("     	g.g_classify,");
		sb.append("     	g.g_price,");
		sb.append("     	g.g_detail,");
		sb.append("         g.g_degree,");
		sb.append("     	g.g_img,");
		sb.append(" FROM ");
		sb.append("     	goods g,");
		sb.append("     	classify gt");
		sb.append(" WHERE 	1=1 ");
		sb.append("     	AND g.g_classify=gt.cl_id");
		if(condition!=null) {
			String goodsName=condition.getGoodsName();
			if(goodsName!=null&&goodsName.isEmpty()) {
				sb.append("and g.g_name like ?");
				list.add("%"+goodsName+"%");
			}
			int type_id=condition.getGoodsType_id();
			if(type_id>0){
				sb.append(" AND g.g_classify=? ");
				list.add(type_id);
			}
		}
		sb.append(" limit ?,?");
		list.add(index);
		list.add(count);
		try {
			  // 根据当前页，查询当前页数据(一页数据)  
			if(index>=0){
				List<Goods> pageData = qr.query(sb.toString(), new BeanListHandler<Goods>(Goods.class), list.toArray());
				 // 设置到pb对象中  
				pb.setPageData(pageData);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	@Override
	public int getTotalCount(PageBean<Goods>pb) {
		StringBuilder sb = new StringBuilder();
		List<Object> list = new ArrayList<Object>();
		sb.append(" SELECT");
		sb.append("   count(*) ");
		sb.append(" FROM ");
		sb.append("     	goods g,");
		sb.append("     	classify gt");
		sb.append(" WHERE 	1=1 ");
		sb.append("     	AND g.g_classify=gt.cl_id");
		
		Condition condition = pb.getCondition();
		//判断
		if(condition!=null){
			String goodsName = condition.getGoodsName();
			if(goodsName!=null && !goodsName.isEmpty()){
				sb.append("  AND g.g_name LIKE ? ");
				list.add("%"+goodsName+"%");
			}
			
			int type_id = condition.getGoodsType_id();
			if(type_id>0){
				sb.append(" AND g.g_classify=? ");
				list.add(type_id);
			}
		}
		try {
			//执行查询，返回结果的第一行的第一列
			Long count = qr.query(sb.toString(), new ScalarHandler<Long>(),list.toArray());
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public List<Goods> findByUser(int type) {
		try {
			String sql ="SELECT * FROM goods WHERE guid =?";
			return qr.query(sql, new BeanListHandler<Goods>(Goods.class), type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
