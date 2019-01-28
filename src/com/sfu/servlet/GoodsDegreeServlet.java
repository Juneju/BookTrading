package com.sfu.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfu.entity.Degree;
import com.sfu.factory.BeanFactory;
import com.sfu.service.GoodsDegreeService;

public class GoodsDegreeServlet extends HttpServlet{
//	private GoodsService gservice=BeanFactory.getInstance("goodsService",GoodsService.class);
//	private GoodsTypeService gts=BeanFactory.getInstance("goodsTypeService", GoodsTypeService.class);
	private GoodsDegreeService service=BeanFactory.getInstance("goodsDegreeService", GoodsDegreeService.class);
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<Degree>list=service.query();
		config.getServletContext().setAttribute("degreelist",list );
		
		
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		if ("delete".equals(method)) {
			delete(req, resp);
		} else if ("list".equals(method)) {
			list(req, resp);
		} else if("getform3".equals(method)) {
			getform3(req,resp);
		}else if("up1".equals(method)) {
			update(req,resp);
		}else if("add".equals(method)) {
			add(req,resp);
		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("d_id"));
		String d_degree=request.getParameter("d_degree");
		URLEncoder.encode(d_degree,"utf-8");
		Degree g=new Degree();
		g.setD_degree(d_degree);
		g.setD_id(id);
		service.update(g);
		list(request,response);
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("d_id"));
		String d_degree=request.getParameter("d_degree");
		URLEncoder.encode(d_degree,"utf-8");
		Degree g=new Degree();
		g.setD_degree(d_degree);
		g.setD_id(id);
		service.add(g);
		list(request,response);
	}
	
	private void getform3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Degree g = service.findById(Integer.parseInt(id));
		
		request.setAttribute("degree", g);
		request.getRequestDispatcher("/sys/form3.jsp").forward(request,response);
		
	}
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		service.delete(Integer.parseInt(id));
		list(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Degree> list=service.query();
		req.setAttribute("list", list);
		req.getServletContext().setAttribute("degreelist",list);
		req.getRequestDispatcher("/sys/main6.jsp").forward(req, resp);
		
	}
	private void list2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Degree> list=service.query();
		req.setAttribute("list", list);
		req.getServletContext().setAttribute("degreelist",list);
		
	}
}
