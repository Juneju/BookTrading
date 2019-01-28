<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>首页-立信校园二手交易平台</title>
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
	    <!--/.navbar-header-->
	
	    
	</nav>
	<!--/.navbar-->
</div>
			<!--header-->
		<div class="banner-section">
			<div class="container">
				<div class="banner-grids">
					<div class="col-md-6 banner-grid">
						<h2>立信校园二手交易商城</h2>
						<p>欢迎来到立信校园专属二手交易平台！在这里，你可以淘到喜爱又便宜的宝贝，也可以卖出你不用的闲置物品。现在，开启你的购物之旅吧...</p>
						<a href="${pageContext.request.contextPath }/goods?method=list3" class="button"> 开始购物 </a>
					</div>
				<div class="col-md-6 banner-grid1">
						<img src="${pageContext.request.contextPath }/app/detail/style/images/p2.jpg" class="img-responsive" alt=""/>
				</div>
				
			</div>
		</div>
		</div>
		<div class="banner-bottom">
		<div class="gallery-cursual">
		<!--requried-jsfiles-for owl-->
		<script src="js/owl.carousel.js"></script>
			<script>
				$(document).ready(function() {
					$("#owl-demo").owlCarousel({
						items : 3,
						lazyLoad : true,
						autoPlay : true,
						pagination : false,
					});
				});
			</script>
		<!--requried-jsfiles-for owl -->
		<!--start content-slider-->
		
		<!--sreen-gallery-cursual-->
		</div>
		</div>
		<div class="gallery">
			<div class="container">
			<h3>热销商品</h3>
								
			<div class="gallery-grids">
			<c:forEach items="${applicationScope.goodslist }" var="goodslist"> 
				<c:choose >
				<c:when test="${goodslist.gindex==1 }">
				<div class="col-md-3 gallery-grid ">

					<a href="${pageContext.request.contextPath }/index?method=getGoodsDetail&goods=${goodslist.gid}"><img src="${pageContext.request.contextPath }/${goodslist.gimg }" class="img-responsive" alt=""/>
					<div class="gallery-info">
					<div class="quick">
					<p><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> view</p>
					</div>
					</div></a>
					<div class="galy-info">
						<p>${goodslist.gname }</p>
						<div class="galry">
						<div class="prices">
						<h5 class="item_price">${goodslist.gprice }</h5>
						</div>
					<div class="rating">
									<span>☆</span>
									<span>☆</span>
									<span>☆</span>
									<span>☆</span>
									<span>☆</span>
								</div>
						
					<div class="clearfix"></div>
					</div>
					</div>
				</div>
				</c:when>
				</c:choose>
				</c:forEach>
				</div>
					
	
		
</body>
</html>