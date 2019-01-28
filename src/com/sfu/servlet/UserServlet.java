package com.sfu.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.sfu.entity.Users;
import com.sfu.entity.classify;
import com.sfu.factory.BeanFactory;
import com.sfu.service.UserService;

public class UserServlet extends HttpServlet{
	private UserService service=BeanFactory.getInstance("userService", UserService.class);
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		List<Users> list=service.query();
		for(Users u: list) {
			System.out.println(u.getUname());
		}
		config.getServletContext().setAttribute("userlist", list);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method=req.getParameter("method");
		System.out.println("2method:"+method);
		if("add".equals(method)) {
			add(req,resp);
		}else if("list".equals(method)) {
			list(req,resp);
		}else if("up1".equals(method)) {
			update(req,resp);
		}else if("delete".equals(method)) {
			delete(req,resp);
		}else if("login".equals(method)) {
			login(req,resp);
		}else if("logout".equals(method)) {
			logout(req,resp);
		}else if("search".equals(method)) {
			search(req,resp);
		}else if("getform1".equals(method)) {
			getform1(req,resp);
		}
	}
	
	protected void getform1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Users user = service.findById(Integer.parseInt(id));
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/sys/form1.jsp").forward(request,response);
	
	}
	
	
	
	private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		int uid=Integer.parseInt(req.getParameter("uid"));
		List<Users>us=service.search(uid);
		String s="";
		for(Users u:us) {
			req.setAttribute("us", us);
		}
		
		req.getRequestDispatcher("transaction/app/userinfo").forward(req, resp);
		
	}
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();		
		int uid=Integer.parseInt(req.getParameter("uid"));
		String upwd=req.getParameter("upwd");
		Users us=new Users();
		us.setPwd(upwd);
		us.setUid(uid);
		
		boolean b2=service.IsUser(us);
		if(b2==true) {
			req.removeAttribute("warn");
			session.setAttribute("user",uid );
			
			resp.sendRedirect("app/index.jsp");
		}else {
			boolean b1=service.existUser(us);
			if(b1==false) {
				String warn="Account doesn't exist.";
				req.setAttribute("warn",warn);
				req.getRequestDispatcher("app/login.jsp").forward(req, resp);
			}else {
				String warn="Password is incorrect.";
				req.setAttribute("warn",warn);
				req.getRequestDispatcher("app/login.jsp").forward(req, resp);;
			}
		}
	}
	
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();	
		if(session!=null){			
			session.removeAttribute("user");			
		}
			resp.sendRedirect(req.getContextPath()+"/app/index.jsp");
	}		
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		service.quitUser(Integer.parseInt(id));
		list(req,resp);
	}
	
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ucampus=req.getParameter("ucampus");
		String uid=req.getParameter("uid");
		String uname=req.getParameter("uname");
		
		String upwd=req.getParameter("upwd");
		String utel=req.getParameter("utel");
		URLEncoder.encode(uname,"utf-8");
		System.out.println("uname:"+uname);
		URLEncoder.encode(upwd,"utf-8");
		int iuid=Integer.parseInt(uid);
		int iucampus=Integer.parseInt(ucampus);
		if(iuid!=0&&uname!=null&&upwd!=null&utel!=null) {
			Users us= new Users();
			us.setPwd(upwd);
			us.setUcampus(iucampus);
			us.setUid(iuid);
			us.setUname(uname);
			us.setUtel(utel);
			service.update(us);
			list(req,resp);
		}	
	}
	
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Users> list=service.query();
		req.setAttribute("list", list);
		req.getServletContext().setAttribute("userlist",list);
		req.getRequestDispatcher("/sys/main.jsp").forward(req, resp);
	}
	
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ucampus=req.getParameter("ucampus");
		String uid=req.getParameter("uid");
		String uname=req.getParameter("uname");
		
		String upwd=req.getParameter("upwd");
		String utel=req.getParameter("utel");
		URLEncoder.encode(uname,"utf-8");
		System.out.println("uname:"+uname);
		URLEncoder.encode(upwd,"utf-8");
		int iuid=Integer.parseInt(uid);
		int iucampus=Integer.parseInt(ucampus);
		if(iuid!=0&&uname!=null&&upwd!=null&utel!=null) {
			Users us= new Users();
			us.setPwd(upwd);
			us.setUcampus(iucampus);
			us.setUid(iuid);
			us.setUname(uname);
			us.setUtel(utel);
			service.add(us);
			list(req,resp);
		}	
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}


	
}
