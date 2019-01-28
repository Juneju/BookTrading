<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/common.css">
  <link rel="stylesheet" href="css/style.css">
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
  <script type="text/javascript">
  $(function(){
      $(".sideMenu").slide({
         titCell:"h3", 
         targetCell:"ul",
         defaultIndex:0, 
         effect:'slideDown', 
         delayTime:'500' , 
         trigger:'click', 
         triggerTime:'150', 
         defaultPlay:true, 
         returnDefault:false,
         easing:'easeInQuint',
         endFun:function(){
              scrollWW();
         }
       });
      $(window).resize(function() {
          scrollWW();
      });
  });
  function scrollWW(){
    if($(".side").height()<$(".sideMenu").height()){
       $(".scroll").show();
       var pos = $(".sideMenu ul:visible").position().top-38;
       $('.sideMenu').animate({top:-pos});
    }else{
       $(".scroll").hide();
       $('.sideMenu').animate({top:0});
       n=1;
    }
  } 

var n=1;
function menuScroll(num){
  var Scroll = $('.sideMenu');
  var ScrollP = $('.sideMenu').position();
  /*alert(n);
  alert(ScrollP.top);*/
  if(num==1){
     Scroll.animate({top:ScrollP.top-38});
     n = n+1;
  }else{
    if (ScrollP.top > -38 && ScrollP.top != 0) { ScrollP.top = -38; }
    if (ScrollP.top<0) {
      Scroll.animate({top:38+ScrollP.top});
    }else{
      n=1;
    }
    if(n>1){
      n = n-1;
    }
  }
}

		function show(){
			var div=document.createElement("div");
			div.style.width=parent.document.documentElement.scrollWidth+"px";
			div.style.height=parent.document.documentElement.scrollHeight+"px";
			div.style.backgroundColor="red";
			div.style.position="absolute";
			div.style.left=0;
			div.style.top=0;
			div.style.zIndex=9999;
			if(document.all)
     			div.style.filter = "alpha(opacity=30)";
    		else div.style.opacity = .3;
    		
			parent.document.body.appendChild(div);
		}
		
  </script>
  <title>后台首页</title>
</head>
<body>

        <div class="sideMenu" style="margin:0 auto">
         <a onclick="show()" target="right" href="${pageContext.request.contextPath }/user?method=list"> <h3>用户管理</h3></a>
           <a target="right" href="${pageContext.request.contextPath }/goods?method=list" target="menuFrame"><h3> 商品管理</h3></a>
           <a target="right" href="${pageContext.request.contextPath }/type?method=list" target="menuFrame"><h3> 商品种类管理</h3></a>
          <a target="right" href="${pageContext.request.contextPath }/sys/main6.jsp" target="menuFrame"><h3> 新旧程度管理</h3></a>
          <a target="right" href="${pageContext.request.contextPath }/sys/main5.jsp" target="menuFrame"><h3> 审核管理</h3></a>
          
          <a target="right" href="${pageContext.request.contextPath }/index?method=manage" target="menuFrame"><h3> 交易管理</h3></a>

       </div>
    
</body>

</html>
   
 