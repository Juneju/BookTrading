<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">

    <link rel="stylesheet" href="${pageContext.request.contextPath }/sys/css/login.css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/sys/js/jquery.min.js"></script>
	<title>后台登陆</title>
</head>
<body>
	<div id="login_top">
		<div id="welcome">
			欢迎使用立信二手交易平台管理系统
		</div>
		<div id="back">
			<a href="${pageContext.request.contextPath }/app/index.jsp" style="background-color: #808080">返回首页</a>&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="#">帮助</a>
		</div>
	</div>
	<div id="login_center">
		<div id="login_area">
			<div id="login_form">
				<form action="${pageContext.request.contextPath }/admin?method=login" method="post">
					<div id="login_tip">
						用户登录&nbsp;&nbsp;UserLogin
					</div>
					<div><input type="text" class="username" name="uid"></div>
					<div><input type="password" class="pwd" name="upwd"></div>
					<div id="btn_area">
						<input type="submit"  name="submit" id="sub_btn" value="登&nbsp;&nbsp;录" 
                            style="color: #000000; background-color: #C0C0C0;">&nbsp;&nbsp;
						
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>