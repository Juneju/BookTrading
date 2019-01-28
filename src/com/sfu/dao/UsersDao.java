package com.sfu.dao;
import java.util.List;

import com.sfu.entity.Users;
public interface UsersDao {
	boolean existUser(Users us);          
	boolean IsUser(Users us);
	void add(Users us);
	void  update(Users us);
	void  update2(Users us);
	List<Users>query();
	Users findById(int id);
	void quitUser(int id);
	 List<Users>search(int id);

}
