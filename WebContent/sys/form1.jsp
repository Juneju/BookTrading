<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>

<style type="text/css">
	form{width: 500px;overflow: hidden;margin: 50px auto;}
	div{line-height: 40px;}
	input{width: 250px;padding-left: 10px;height: 30px;
	line-height: 30px;color: #333;font-size: 14px;
	border: 1px solid #666;outline: none;margin-bottom: 10px;display: inline-block;}
	span{display: inline-block;float: left;
        width: 97px;
    }
	.submit{width: 109px;
background: #666;color: #fff;margin-left: 195px;
cursor: pointer;
    }
</style>

</head>
<body>
<c:choose>
<c:when test="${requestScope.user==null }">
<form action="${pageContext.request.contextPath }/user?method=add" method="post" class="form" onsubmit="return check(this)">
</c:when>
<c:otherwise>
<form action="${pageContext.request.contextPath }/user?method=up1" method="post" class="form" onsubmit="return check(this)">
</c:otherwise>
</c:choose>
	<div><span>ID：&nbsp; &nbsp;</span><input type="text" name="uid" value="${requestScope.user.uid }" /><br /></div>
	<div><span>用户名:</span><input type="text" name="uname" value="${requestScope.user.uname }" /><br /></div>
	<div><span>密码：&nbsp;&nbsp;</span><input type="text"  name="upwd" value="${requestScope.user.pwd }" /><br /></div>						
	<div><span>电话：&nbsp;&nbsp;</span><input type="text"  name="utel" value="${requestScope.user.utel }" /><br /></div>	
	<div><span>校区：&nbsp;&nbsp;</span>
	<select name="ucampus" style="width:80px" value="${requestScope.user.ucampus }">
	                            <c:forEach items="${applicationScope.campuslist }" var="campus">
			   						<option value="${campus.c_id}">${campus.c_name }</option>
			   					</c:forEach>	   					
                            </select>
    <br /></div>	
	<input type="submit" value="提交" class="submit" />
</form>


</body>
</html>