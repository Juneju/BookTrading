<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>立信校园二手交易平台</title>
</head>
	<frameset rows="120px,*,19px" framespacing="0" border="0" frameborder="0">
		<frame src="top.jsp" scrolling="yes"  /> 
		<frameset cols="178px,*">
			<frame noresize src="left.jsp" scrolling="yes" /> 
			<frame noresize name="right" src="right.jsp" scrolling="yes" /> 
		</frameset>

	<noframes>
		<body>
			你的浏览器不支持框架布局，推荐你使用<a href="http://www.firefox.com.cn/download/" style="text-decoration: none;">火狐浏览器</a>,
			<a href="http://www.google.cn/intl/zh-CN/chrome/" style="text-decoration: none;">谷歌浏览器</a>
		</body>
	</noframes>
</html>