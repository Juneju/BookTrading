package com.sfu.dao;

import java.util.List;

import com.sfu.entity.Admin;
//管理员数据库操作接口
public interface AdminDao {
	boolean existAdmin(Admin us);          //管理员是否存在
	boolean IsAdmin(Admin us);				//是否是管理员

}
