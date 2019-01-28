<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath }/sys/css/common.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath }/sys/css/main.css">

    <script type="text/javascript" src="${pageContext.request.contextPath }/sys/js/jquery.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/sys/js/jquery.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/sys/js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/sys/js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/sys/js/jquery.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath }/sys/js/main1.js"></script>
   <script type="text/javascript">
      $(function(){  
        $(".list_table").colResizable({
          liveDrag:true,
          gripInnerHtml:"<div class='grip'></div>", 
          draggingClass:"dragging", 
          minWidth:30
        }); 
        
      }); 
   </script>