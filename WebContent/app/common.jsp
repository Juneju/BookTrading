<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="${pageContext.request.contextPath }/app/detail/style/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${pageContext.request.contextPath }/app/detail/style/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath }/app/detail/style/css/owl.carousel.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Swim Wear Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/bootstrap-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/simpleCart.min.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <script defer src="${pageContext.request.contextPath }/app/detail/style/js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/app/detail/style/css/flexslider.css" type="text/css" media="screen" />
<script src="${pageContext.request.contextPath }/app/detail/style/js/imagezoom.js"></script>
<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>
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
.caca{
	cursor:pointer;
	width:100px;
	height:20px;
	position:absolute;
	right:0px;
	top:0px;
	
}
</style>
<script>
function submitForm(){
	//获取form表单对象
	    var form = document.getElementById("myform");
	    form.submit();//form表单提交
	}
	</script>

<body>
	<!--header-->
		<div class="header">
			<div class="header-top">
			<div class="container">
				 <div class="lang_list"><font color="white">商品分类</font>lixin
				<form id="myform" action="${pageContext.request.contextPath }/goods?method=sear" method=POST>
				
					<select name="gclass" tabindex="4" class="dropdown1" onchange="submitForm();">
								<option value=0>选择</option>
	                            <c:forEach items="${applicationScope.typelist }" var="type">
			   						<option value="${type.cl_id}">${type.cl_cate }</option>
			   					</c:forEach>	   					
                            </select>
                  </form>	  
   				 </div>
			<div class="topp-right">
				<ul>

				<c:choose>
					<c:when test="${user !=null}">
						<li class="text">
						<a href="${pageContext.request.contextPath }/index?method=infodisplay&uid=${user }">${user }的信息</a>
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
