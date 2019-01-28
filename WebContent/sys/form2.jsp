<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>商品种类管理</title>

<style type="text/css">
	form{width: 500px;overflow: hidden;margin: 50px auto;}
	div{line-height: 40px;}
	input{width: 250px;padding-left: 10px;height: 30px;
	line-height: 30px;color: #333;font-size: 14px;
	border: 1px solid #666;outline: none;margin-bottom: 10px;display: inline-block;
        margin-left: 25px;
    }
	span{display: inline-block;float: left;
        height: 28px;
        width: 80px;
    }
	.submit{width: 120px;background: #666;color: #fff;margin-left: 167px;
cursor: pointer;
    }
</style>

</head>
<body>

<c:choose>
<c:when test="${requestScope.type==null }">
<form action="${pageContext.request.contextPath }/type?method=add" method="post" class="form" onsubmit="return check(this)">
</c:when>
<c:otherwise>
<form action="${pageContext.request.contextPath }/type?method=up1" method="post" class="form" onsubmit="return check(this)">
</c:otherwise>
</c:choose>
	<div><span>ID：&nbsp; &nbsp;</span><input type="text" name="cl_id" value="${requestScope.type.cl_id }" /><br /></div>
	<div><span>种类:</span><input type="text" name="cl_cate" value="${requestScope.type.cl_cate }" /><br /></div>
	
	
    <br /></div>	
	<input type="submit" value="提交" class="submit" />
</form>


</body>
</html>