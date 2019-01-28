package com.sfu.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sfu.entity.Admin;
import com.sfu.factory.BeanFactory;
import com.sfu.service.AdminServiceService;
//管理员业务处理
public class AdminServlet extends HttpServlet{
	private AdminServiceService service=BeanFactory.getInstance("adminService", AdminServiceService.class);
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method=req.getParameter("method");
		System.out.println("2method:"+method);
		 if("login".equals(method)) {
			login(req,resp);
		}else if("logout".equals(method)) {
			logout(req,resp);
		}
		 
	}
	//登陆功能
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();		
		int uid=Integer.parseInt(req.getParameter("uid"));
		String upwd=req.getParameter("upwd");
		Admin us=new Admin();
		us.setA_pwd(upwd);
		us.setA_id(uid);
		
		boolean b2=service.IsAdmin(us);
		if(b2==true) {
			req.removeAttribute("warn");
			session.setAttribute("admin",uid );
			
			resp.sendRedirect("sys/index1.jsp");
		}else {
			boolean b1=service.existAdmin(us);
			if(b1==false) {
				String warn="Account doesn't exist.";
				req.setAttribute("warn",warn);
				req.getRequestDispatcher("sys/login.jsp").forward(req, resp);
			}else {
				String warn="Password is incorrect.";
				req.setAttribute("warn",warn);
				req.getRequestDispatcher("sys/login.jsp").forward(req, resp);;
			}
		}
	}
	
	
	//登出功能
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();	
		if(session!=null){			
			session.removeAttribute("admin");			
		}
		req.getRequestDispatcher("sys/login.jsp").forward(req, resp);	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
