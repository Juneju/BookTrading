<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>订单</title>
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
	        <h1 class="navbar-brand"><a  href="index.html">我的订单</a></h1>
	    </div>
	    <!--/.navbar-header-->
	
	    

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
<!-- checkout -->
<div class="content">
<div class="cart-items">
	<div class="container">
			 <h2>订单详情</h2>
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
							 <img src="${requestScope.goods.gimg }" class="img-responsive" alt="">
						</div>
					   <div class="cart-item-info">
						<h3><a href="#"> ${requestScope.goods.gname } </a></h3>
					
							 <div class="delivery">
							 <p>价格 ${requestScope.goods.gprice }元</p>
							 <span>Delivered in 1-1:30 hours</span>
							 <div class="clearfix"></div>
				        </div>	
					   </div>
					   <div class="clearfix"></div>
											
				  </div>
			 </div>
			 		
		 </div>
		 </div>
<!-- checkout -->	
<div class="subscribe">
	 
		 <form action="${pageContext.request.contextPath }/goods?method=changeState&gid=${requestScope.goods.gid }&uid=${user }"  method=POST>
			 
			 <input type="submit" value="立即付款">
		 </form>
	 </div>
	 <div class="clearfix"></div>
	 </div>
</div>
</div>

	
			
</body>
</html>