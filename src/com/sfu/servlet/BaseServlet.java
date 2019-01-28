package com.sfu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sfu.factory.BeanFactory;
import com.sfu.service.GoodsDegreeService;
import com.sfu.service.GoodsService;
import com.sfu.service.GoodsTypeService;
import com.sfu.service.UserCampusService;
import com.sfu.service.UserService;
import com.sfu.utils.WebUtils;

public abstract class BaseServlet extends HttpServlet{
	
	protected UserService userService=BeanFactory.getInstance(
			"userService",UserService.class);
	protected GoodsService goodsService=BeanFactory.getInstance(
			"goodsService",GoodsService.class);
	protected GoodsTypeService goodsTypeService=BeanFactory.getInstance(
			"goodsTypeService",GoodsTypeService.class);
	protected GoodsDegreeService goodsDegreeService=BeanFactory.getInstance(
			"goodsDegreeService",GoodsDegreeService.class);
	protected UserCampusService userCampusService=BeanFactory.getInstance(
			"userCampusService",UserCampusService.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// (保存跳转的资源)  方法返回值
		System.out.println("bbb");
				Object returnValue = null;
		// 获取操作类型;  【约定 > 俗成： 操作类型的值，必须对应servlet中的方法名称】
		String methodName = request.getParameter("method");  // listTable
		System.out.println("1:"+methodName);
		try {
			// 1. 获取当前运行类的字节码
			Class clazz = this.getClass();
			// 2. 获取当前执行的方法的Method类型
			Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			// 3. 执行方法
			System.out.print("method:"+method);
			returnValue = method.invoke(this, request,response);
			System.out.println("return:"+returnValue);
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = "/error/error.jsp";
		}
		// 跳转
		WebUtils.goTo(request, response, returnValue);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
	
	
}
