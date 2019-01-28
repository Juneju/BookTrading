package com.sfu.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfu.entity.Goods;
import com.sfu.entity.Users;
import com.sfu.entity.classify;
import com.sfu.factory.BeanFactory;
import com.sfu.service.GoodsService;
import com.sfu.service.GoodsTypeService;
import com.sfu.service.UserService;


public class IndexServlet extends HttpServlet{
	private GoodsService goodsService=BeanFactory.getInstance(
			"goodsService",GoodsService.class);
	private GoodsTypeService goodsTypeService=BeanFactory.getInstance(
			"goodsTypeService",GoodsTypeService.class);
	private UserService userService=BeanFactory.getInstance(
			"userService",UserService.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method=req.getParameter("method");
		if("getGoodsDetail".equals(method)) {
			getGoodsDetail(req,resp);
		}else if("infodisplay".equals(method)){
			infodisplay(req,resp);
		}else if("getOrder".equals(method)){
			getOrder(req,resp);
		}else if("delete".equals(method)) {
			delete(req,resp);
		}else if("manage".equals(method)) {
			manage(req,resp);
		}else if("uup1".equals(method)) {
			update(req,resp);
		}else if("add".equals(method)) {
			add(req,resp);
		}
	}
	private void add(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		//String gid=req.getParameter("gid");
		int uid = Integer.parseInt(req.getParameter("uid"));
		
		String gname=req.getParameter("gname");
		System.out.println("gname:"+gname);
		String gdetail=req.getParameter("gdetail");
		String gprice=req.getParameter("gprice");
		String gimg=req.getParameter("gimg");
		System.out.println("gimg:"+gimg);
		String gclass=req.getParameter("gclass");
		String gdegree=req.getParameter("gdegree");
		//int igid=Integer.parseInt(gid);
		int igprice=Integer.parseInt(gprice);
		int igclass=Integer.parseInt(gclass);
		int igdegree=Integer.parseInt(gdegree);
		URLEncoder.encode(gname,"utf-8");
		URLEncoder.encode(gdetail,"utf-8");
		URLEncoder.encode(gimg,"utf-8");
		Goods goods=new Goods();
		//goods.setGbid(igid);
		goods.setGname(gname);
		goods.setGclass(igclass);
		goods.setGdetail(gdetail);
		goods.setGimg("upload/"+gimg);
		goods.setGdegree(igdegree);
		goods.setGprice(igprice);
		goods.setGuid(uid);
		goodsService.add(goods);
		list2(req,resp);
		infodisplay(req,resp);
		
		
	}
	private void list2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Goods> list=goodsService.query();
		req.setAttribute("list", list);
		req.getServletContext().setAttribute("goodslist",list);
		
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ucampus=req.getParameter("ucampus");
		String uid=req.getParameter("uid");
		String uname=req.getParameter("uname");
		
		String utel=req.getParameter("utel");
		URLEncoder.encode(uname,"utf-8");
		System.out.println("uname:"+uname);
		int iuid=Integer.parseInt(uid);
		int iucampus=Integer.parseInt(ucampus);
		if(iuid!=0&&uname!=null&&utel!=null) {
			Users us= new Users();
			us.setUcampus(iucampus);
			us.setUid(iuid);
			us.setUname(uname);
			us.setUtel(utel);
			userService.update2(us);
			infodisplay(req,resp);
		}	
	}
	protected void manage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Goods>goods=goodsService.deal();
		req.setAttribute("dealgoods",goods);
		req.getRequestDispatcher("/sys/main3.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	protected void infodisplay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int  uid=Integer.parseInt(req.getParameter("uid"));
		Users u=userService.findById(uid);
		List<Goods> goods=goodsService.findByUser(uid);
		req.setAttribute("infouser",u );
		req.setAttribute("infogoods", goods);
		List<Goods> g2=goodsService.deal(uid);
		req.setAttribute("dealgoods",g2);
		req.getRequestDispatcher("/app/userinfo.jsp").forward(req, resp);
		

	}

	
	protected void getGoodsDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("goods");
		Goods goods = goodsService.findById(Integer.parseInt(id));
		List<classify> goodstypes = goodsTypeService.query();
		request.setAttribute("goods", goods);
		request.setAttribute("goodstypes", goodstypes);
		request.getRequestDispatcher("/app/goodsdetail.jsp").forward(request,response);
	
	}
	protected void getOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("goods");
		Goods goods = goodsService.findById(Integer.parseInt(id));
		List<classify> goodstypes = goodsTypeService.query();
		request.setAttribute("goods", goods);
		request.setAttribute("goodstypes", goodstypes);
		request.getRequestDispatcher("/app/orders.jsp").forward(request,response);
	
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			String id = req.getParameter("id");
			goodsService.delete(Integer.parseInt(id));
			List<Goods> list=goodsService.query();
			req.setAttribute("list", list);
			req.getServletContext().setAttribute("goodslist",list);
			infodisplay(req, resp);

	}

}
