package com.sfu.servlet;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.sfu.entity.Campus;
import com.sfu.entity.Users;
import com.sfu.factory.BeanFactory;
import com.sfu.service.UserCampusService;

public class UserCampusServlet extends HttpServlet{
	private UserCampusService service=BeanFactory.getInstance("userCampusService", UserCampusService.class);
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		List<Campus> list=service.query();
	
		config.getServletContext().setAttribute("campuslist", list);
	}

}
