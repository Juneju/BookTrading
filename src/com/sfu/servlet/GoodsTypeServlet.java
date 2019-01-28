package com.sfu.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfu.entity.Goods;
import com.sfu.entity.Users;
import com.sfu.entity.classify;
import com.sfu.factory.BeanFactory;
import com.sfu.service.GoodsDegreeService;
import com.sfu.service.GoodsService;
import com.sfu.service.GoodsTypeService;
import com.sfu.utils.PageBean;

public class GoodsTypeServlet extends HttpServlet{
	private GoodsService gservice=BeanFactory.getInstance("goodsService",GoodsService.class);
	private GoodsTypeService service=BeanFactory.getInstance("goodsTypeService", GoodsTypeService.class);
	private GoodsDegreeService gds=BeanFactory.getInstance("goodsDegreeService", GoodsDegreeService.class);
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<classify>list=service.query();
		config.getServletContext().setAttribute("typelist",list );
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		if ("delete".equals(method)) {
			delete(req, resp);
		} else if ("list".equals(method)) {
			list(req, resp);
		} else if("getform2".equals(method)) {
			getform2(req,resp);
		}else if("up1".equals(method)) {
			update(req,resp);
		}else if("add".equals(method)) {
			add(req,resp);
		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("cl_id"));
		String cl_cate=request.getParameter("cl_cate");
		URLEncoder.encode(cl_cate,"utf-8");
		classify c=new classify();
		c.setCl_cate(cl_cate);
		c.setCl_id(id);
		service.update(c);
		list(request,response);
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("cl_id"));
		String cl_cate=request.getParameter("cl_cate");
		URLEncoder.encode(cl_cate,"utf-8");
		classify c=new classify();
		c.setCl_cate(cl_cate);
		c.setCl_id(id);
		service.add(c);
		list(request,response);
	}
	
	private void getform2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		classify type = service.findById(Integer.parseInt(id));
		
		request.setAttribute("type", type);
		request.getRequestDispatcher("/sys/form2.jsp").forward(request,response);
		
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
		List<classify> list=service.query();
		req.setAttribute("list", list);
		req.getServletContext().setAttribute("typelist",list);
		req.getRequestDispatcher("/sys/main4.jsp").forward(req, resp);
		
	}
	private void list2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<classify> list=service.query();
		req.setAttribute("list", list);
		req.getServletContext().setAttribute("typelist",list);
		
	}

}
