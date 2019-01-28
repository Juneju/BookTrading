package com.sfu.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sfu.entity.Goods;
import com.sfu.entity.Users;
import com.sfu.entity.classify;
import com.sfu.factory.BeanFactory;
import com.sfu.service.GoodsDegreeService;
import com.sfu.service.GoodsService;
import com.sfu.service.GoodsTypeService;
import com.sfu.utils.PageBean;

public class GoodsServlet extends HttpServlet{
	private GoodsService service=BeanFactory.getInstance("goodsService",GoodsService.class);
	private GoodsTypeService gts=BeanFactory.getInstance("goodsTypeService", GoodsTypeService.class);
	private GoodsDegreeService gds=BeanFactory.getInstance("goodsDegreeService", GoodsDegreeService.class);
	private Object uri;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		PageBean<Goods> pageBean=new PageBean<Goods>();
		pageBean.setPageCount(6);
		//service.getAll(pageBean);
		List<Goods>list=service.query();
		for(Goods goods:list) {
			System.out.println(goods.getGname());
		}
		System.out.println(list.get(0));
		config.getServletContext().setAttribute("goodslist",list );
		config.getServletContext().setAttribute("pb", pageBean);
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		System.out.println(method);
		if ("add".equals(method)) {
			add(req, resp);
		} else if ("list".equals(method)) {
			list(req, resp);
		} else if ("update".equals(method)) {
			update(req, resp);
		} else if ("delete".equals(method)) {
			delete(req, resp);
		} else if ("sear".equals(method)) {
			sear(req, resp);
		} else if ("changeState".equals(method)) {
			changeState(req, resp);
		} else if ("list3".equals(method)) {
			list3(req, resp);
		} 
	}
	
	private void changeState(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int gid = Integer.parseInt(request.getParameter("gid"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		service.changeState(gid, uid);
		list2(request,response);
		request.getRequestDispatcher("/app/index.jsp").forward(request, response);
	}
	
	
	private void goTo(HttpServletRequest req, HttpServletResponse resp,Object uri) throws ServletException, IOException {
		if (uri instanceof RequestDispatcher) {
			((RequestDispatcher) uri).forward(req, resp);

		} else {
			resp.sendRedirect(req.getContextPath() + (String) uri);
		}
	}
		

		
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Goods> list=service.query();
		req.setAttribute("list", list);
		req.getServletContext().setAttribute("goodslist",list);
		req.getRequestDispatcher("/sys/main2.jsp").forward(req, resp);
		
	}
	
private void list3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<Goods> list=service.query();
	req.setAttribute("list", list);
	req.getServletContext().setAttribute("goodslist",list);
	req.getRequestDispatcher("/app/details.jsp").forward(req, resp);
	
}
	private void list2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Goods> list=service.query();
		req.setAttribute("list", list);
		req.getServletContext().setAttribute("goodslist",list);
		
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
		service.add(goods);
		list2(req,resp);
		req.getRequestDispatcher("/app/index.jsp").forward(req, resp);
		
		
	}
		
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(10 * 1024 * 1024); // 单个文件大小限制
			upload.setSizeMax(50 * 1024 * 1024); // 总文件大小限制
			upload.setHeaderEncoding("UTF-8"); // 对中文文件编码处理
			if (upload.isMultipartContent(req)) {
				Goods goods=new Goods();
				List<FileItem> list = upload.parseRequest(req);
				for (FileItem item : list) {
					if (item.isFormField()) {// 普通本文内容
						String name = item.getFieldName();
						// 获取值
						String value = item.getString();
						value = new String(value.getBytes("ISO-8859-1"),
								"UTF-8");
						BeanUtils.setProperty(goods, name, value);
				}else {
					String fieldName = item.getFieldName();
					String path = getServletContext()
							.getRealPath("/upload");
					File f = new File(path);
					if (!f.exists()) {
						f.mkdir();
					}
					String name = item.getName();
					if(name!=null && !"".equals(name.trim())){
						BeanUtils.setProperty(goods, fieldName,
								("upload/" + name));

						File file = new File(path, name);
					
						if (!file.isDirectory()) {
							item.write(file);
						}
						item.delete(); // 删除组件运行时产生的临时文件
					}else{
						int id = goods.getGid();
						String img =service.findById(id).getGimg();
						BeanUtils.setProperty(goods, "img",img);
						
					}
				}
			}
				service.update(goods);
		}else {
			
			}
			list(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
			goTo(req, resp, uri);
		}
	}
		
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			service.delete(Integer.parseInt(id));
			List<Goods> list=service.query();
			req.setAttribute("list", list);
			req.getServletContext().setAttribute("goodslist",list);
			req.getRequestDispatcher("/sys/main2.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
			goTo(req, resp, uri);
		}
	}
	
	private void sear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int  keyword = Integer.parseInt(req.getParameter("gclass"));
			if(keyword==0) req.getRequestDispatcher("/app/index.jsp").forward(req, resp);
			if (keyword != 0) {
				List<Goods> list = service.findByType(keyword);
				List<classify> types = new ArrayList<classify>();
				classify c=gts.findById(keyword);
				if (list != null) {
					for (Goods goods : list) {
						classify goodstype = gts.findById(goods.getGclass());
						types.add(goodstype);
					}
				}
				req.setAttribute("type", c.getCl_cate());
				req.setAttribute("list", list);
				req.getRequestDispatcher("/app/goodslist.jsp").forward(req, resp);
				
			}
		} catch (Exception e) {
			uri = "/error/error.jsp";
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
	
}
