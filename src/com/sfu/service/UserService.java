package com.sfu.service;

import java.util.List;

import com.sfu.entity.Users;

public interface UserService {
	boolean existUser(Users us);          
	boolean IsUser(Users us);
	void add(Users us);
	void  update(Users us);
	List<Users>query();
	Users findById(int id);
	void quitUser(int id);
	 List<Users>search(int id);
		void  update2(Users us);
}
