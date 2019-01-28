<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>用户信息</title>
<%@include file="common.jsp"%>	
<!--/.content-->
<div class="content white">
	<nav class="navbar navbar-default" role="navigation">
	    <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
	        </button>
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
		  	  <form action="${pageContext.request.contextPath }/index?method=uup1" method=POST> 
		  
				 <div class="register-top-grid">
					<h3>个人信息</h3>
					 <div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span>学号</span>
						<input type="text" value="${infouser.uid }" name="uid"> 
											 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>姓名</span>
						<input type="text" value="${infouser.uname }" name="uname"> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						 <span>电话</span>
						 <input type="text" value="${infouser.utel }" name="utel"> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						 <span>校区</span>
						 <select  value="${infouser.ucampus }" name="ucampus" >
	                            <c:forEach items="${applicationScope.campuslist }" var="campus">
			   						<option value="${campus.c_id}">${campus.c_name }</option>
			   					</c:forEach>	   					
                            </select>
					 </div>
					 <div class="clearfix"> </div>
					 
			
				
		   </div>
		 </div>
	</div>
                                <div class="clearfix"> </div>
				<div class="register-but">
				
					   <center><input type="submit" value="修改"></center>
					   <div class="clearfix"> </div>
				   </form>
				</div>

<div class="content">
<div class="cart-items">
	<div class="container">
			 <h2>我的库存</h2>
			 <c:forEach items="${requestScope.infogoods }" var="goodslist"> 
				<c:if test="${goodslist.gdeal!=1 }">
			 <div class="cart-header">
				 <div >
				 	<a class="caca" href="${pageContext.request.contextPath }/index?method=delete&id=${goodslist.gid }&uid=${user }"><button>取消售卖</button></a>
				 </div>
				 <div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							 <img src="${goodslist.gimg }" class="img-responsive" alt="">
						</div>
					   <div class="cart-item-info">
						<h3><a href="#"> ${goodslist.gname } </a></h3>
						<ul class="qty">
							<li><p>详情：${goodslist.gdetail }</p></li>
							<li><p>FREE delivery</p></li>
						</ul>
							 <div class="delivery">
							 <p>价格：${goodslist.gprice }元</p>
							 <div class="clearfix"></div>
				        </div>	
					   </div>
					   <div class="clearfix"></div>
											
				  </div>
			 </div>
			 </c:if>
			 </c:forEach>
			 	
		 </div>
		 </div>
<div class="content">
<div class="cart-items">
	<div class="container">
			 <h2>我的交易记录</h2>
			 <c:forEach items="${requestScope.dealgoods }" var="goods"> 
				<script>$(document).ready(function(c) {
					$('.close1').on('click', function(c){
						$('.cart-header').fadeOut('slow', function(c){
							$('.cart-header').remove();
						});
						});	  
					});
			   </script>
			 <div class="cart-header">
				 <div class="close1"> </div>
				 <div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							 <img src="${goods.gimg }" class="img-responsive" alt="">
						</div>
					   <div class="cart-item-info">
						<h3><a href="#"> ${goods.gname } </a></h3>
							 <div class="delivery">
							 <p>价格：${goods.gprice }元</p>
							 <span></span>
							 <div class="clearfix"></div>
				        </div>	
					   </div>
					   <div class="clearfix"></div>
											
				  </div>
			 </div>
			 	</c:forEach>
		 </div>
		 </div>
		 
			
</body>
</html>