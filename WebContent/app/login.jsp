<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户登录</title>
<%@include file="common.jsp"%>
			<div class="content">
 <div class="main-1">
		<div class="container">
<div class="login-page">
			   <div class="account_grid">
			   
			   <div class="col-md-6 login-right">
			  	<h3>账号登录</h3>
				<p>请用你已有的账号登录。</p>
				<form action="${pageContext.request.contextPath }/user?method=login" method="post">
				  <div>
					<span>用户ID<label>*</label></span>
					<input type="text" name="uid"> 

				  </div>
				  <div>
					<span>密码<label>*</label></span>
					<input type="password" name="upwd"> 
				  </div>
				 
				  <a class="forgot" href="#">忘记密码?</a>
				  <input type="submit"  class="button" value="登录">
			    </form>
			   </div>	
			   <div class="clearfix"> </div>
			 </div>
		   </div>
		   </div>
	</div>
	</div>
<!-- login -->

			
</body>
</html>