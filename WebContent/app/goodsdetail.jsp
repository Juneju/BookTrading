<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>单个商品展示</title>
<link href="${pageContext.request.contextPath }/app/detail/style/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${pageContext.request.contextPath }/app/detail/style/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath }/app/detail/style/css/owl.carousel.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Swim Wear Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/bootstrap-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/simpleCart.min.js"></script>

<script src="${pageContext.request.contextPath }/app/detail/style/js/imagezoom.js"></script>

						<!-- FlexSlider -->
  <script defer src="${pageContext.request.contextPath }/app/detail/style/js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/app/detail/style/css/flexslider.css" type="text/css" media="screen" />





</head>

<style type="text/css">
.topp-right ul li {
    display: inline-block;
    border-right: 1px solid;
    padding: 1em 1em;
}
.topp-right ul li.text a {
color:#fff;

}
.topp-right {
    float: right;
}
.kuang{ width:525px;height:40px}

</style>
<body>
	<!--header-->
		<!--header-->
		<div class="header">
			<div class="header-top">
			<div class="container">
				 <div class="lang_list"><font color="white">商品分类</font>lixin
					
					<select name="ucampus" tabindex="4" class="dropdown1" onchange="window.location='goodslist.jsp';">
	                            <c:forEach items="${applicationScope.typelist }" var="type">
			   						<option value="${type.cl_id}">${type.cl_cate }</option>
			   					</c:forEach>	   					
                            </select>
                    
   				 </div>
			<div class="topp-right">
				<ul>

				<c:choose>
					<c:when test="${user !=null}">
						<li class="text">
						<a href="${pageContext.request.contextPath }/app/userinfo.jsp ">${user }的信息</a>
						</li>
						<li class="text"><br><a href="${pageContext.request.contextPath }/user?method=logout"> 安全退出</a>
						</li>
						<li class="text">
                    	<a href="${pageContext.request.contextPath }/app/publish.jsp">我要发布</a>
                    </li>
					</c:when>
					<c:otherwise>
						<li class="text">
							<a href="${pageContext.request.contextPath }/app/login.jsp">登录</a>
						</li>
					</c:otherwise>
				</c:choose>
						<li class="text">
                    	<a href="${pageContext.request.contextPath }/app/index.jsp">主页</a>
                    </li>
                    
			
				</ul>
			</div>
				
			</div>
			</div>
			</div>
			
	    <!--/.navbar-collapse-->
	</nav>
	<!--/.navbar-->
</div>
			   <div class="search-box">
					<div id="sb-search" class="sb-search">
						<form>
							<input class="sb-search-input" placeholder="搜索商品..." type="search" name="search" id="search">
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
	
					<div class="col-md-4 single-grid">		
						<div class="flexslider">
							<ul class="slides">
								<li data-thumb="${pageContext.request.contextPath }/${requestScope.goods.gimg }">
									<div class="thumb-image"> <img src="${pageContext.request.contextPath }/${requestScope.goods.gimg }" data-imagezoom="true" class="img-responsive"> </div>
								</li>
								<li data-thumb="images/si1.jpg">
									 <div class="thumb-image"> <img src="#" data-imagezoom="true" class="img-responsive"> </div>
								</li>
								<li data-thumb="images/si2.jpg">
								   <div class="thumb-image"> <img src="#" data-imagezoom="true" class="img-responsive"> </div>
								</li> 
							</ul>
						</div>
					</div>	
					<div class="col-md-4 single-grid simpleCart_shelfItem">		
						<h3>${requestScope.goods.gname }</h3>
							<p>${requestScope.goods.gdetail }</p>
								
							<div class="galry">
								<div class="prices">
									<h5 class="item_price">${requestScope.goods.gprice }元</h5>
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
								<p class="qty"> 数量 :  </p><input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
							<div class="btn_form">
								<a href="${pageContext.request.contextPath }/index?method=getOrder&goods=${requestScope.goods.gid} " class="add-cart item_add">立即购买</a>	
							</div>
							<div class="tag">
								<p>种类 <a href="#"> ${requestScope.goods.gclass } </a></p>
								<p>卖家: <a href="#"> ${requestScope.goods.guid } </a></p>
							</div>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
<!-- collapse -->
		<div class="collpse">
		<div class="container">
		<div class="panel-group collpse" id="accordion" role="tablist" aria-multiselectable="true">
		  <div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingOne">
			  <h4 class="panel-title">
				<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
				  商品详情
				</a>
			  </h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
			  <div class="panel-body">
				${requestScope.goods.gdetail }
			  </div>
			</div>
		  </div>
		  <div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingTwo">
			  <h4 class="panel-title">
				<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
				 价格
				</a>
				${requestScope.goods.gprice }元
			  </h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
			  <div class="panel-body">
				Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
			  </div>
			</div>
		  </div>
		  <div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingThree">
			  <h4 class="panel-title">
				<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
				  联系方式
				</a>
			  </h4>
			</div>
			<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
			  <div class="panel-body">
				Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
			  </div>
			</div>
		  </div>
		  
		  </div>
		</div>
	</div>
</div>
<!-- collapse -->
		<div class="related-products">
			<div class="container">
				<h3>其他商品</h3>
				<div class="product-model-sec single-product-grids">
				<c:forEach items="${applicationScope.goodslist }" var="goodslist"> 
				<c:choose >
				<c:when test="${goodslist.gindex==1 }">
					<div class="product-grid single-product">
						<a href="single.html">
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="${pageContext.request.contextPath }/${goodslist.gimg }" class="img-responsive" alt="">
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button> + </button>
							</h4>
							</div>
						</div>
						</a>					
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust prt_name">
								<h4>${goodslist.gname }</h4>								
								<span class="item_price">${goodslist.gprice }</span>
								<div class="ofr">
								  <p class="pric1"><del>Rs 280</del></p>
						          <p class="disc">[12% Off]</p>
								</div>
								<div class="clearfix"> </div>
							</div>												
						</div>
					</div>
					</c:when>
					</c:choose>
					</c:forEach>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
</div>
	
			
</body>
<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>
</html>