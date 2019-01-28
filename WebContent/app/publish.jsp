<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>我要发布</title>



<%@include file="common.jsp"%>		
<div class="content white">
	<nav class="navbar navbar-default" role="navigation">
	    <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
	        </button>
	        <h1 class="navbar-brand"><a  href="#">发布商品</a></h1>
	    </div>	     
	</nav>
	<!--/.navbar-->
</div>
			   <div class="search-box">
					<div id="sb-search" class="sb-search">
						<form>
							<input class="sb-search-input" placeholder="搜索商品" type="search" name="search" id="search">
							<input class="sb-search-submit" type="submit" value="">
							<span class="sb-icon-search"> </span>
						</form>
					</div>
				</div>
			
<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
					<!-- //search-scripts -->
					<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!--header-->
			<div class="content">
 <!-- registration -->
	<div class="main-1">
		<div class="container">
			<div class="register">
		  	  <form action="${pageContext.request.contextPath }/index?method=add&uid=${user }" method=POST> 
				 <div class="register-top-grid">
					<h3>商品信息</h3>
					 <div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span>商品名称<label>*</label></span>
						<input type="text" name="gname"> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>商品价格<label>*</label></span>
						<input type="text" name="gprice"> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						 <span>商品详情</span>
						 <input type="text" name="gdetail"> 
					 </div>
					 <!-- <div class="wow fadeInRight" data-wow-delay="0.4s">
						 <span>联系方式</span>
						 <input type="text" name="gtel"> 
					 </div> -->
					 
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						 <span>新旧程度</span>
						 <select class="kuang" name="gdegree">
	                            <c:forEach items="${applicationScope.degreelist }" var="degree">
			   						<option value="${degree.d_id}">${degree.d_degree }</option>
			   					</c:forEach>	   					
                            </select>
						 
					
					 </div>
	
                                      < <div class="wow fadeInRight" data-wow-delay="0.4s">
						 <span>种类</span>
						 <select class="kuang" name="gclass">
	                            <c:forEach items="${applicationScope.typelist }" var="type">
			   						<option value="${type.cl_id}">${type.cl_cate }</option>
			   					</c:forEach>	   					
                            </select>
						
					 </div> 
									  <div class="wow fadeInRight" data-wow-delay="0.4s">
					 <span>上传图片</span>
					 <input type="file" name="gimg"/> *
					 
					 </div>
					 
					 <center><input type="submit" value="提交"></center>
				</form>
		 </div>
	</div>

			
</body>
</html>	  