<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html lang="zh-CN">
 <head>
   <meta charset="UTF-8">
    <%@include file="common.jsp"%>	
   <title>Document</title>
 </head>
 <body>
  <div class="container">
     <div class="main_top">
          <div class="main_left fl span6">
              <div class="box pr5">
                <div class="box_border">
                  <div class="box_top">
  <div id="button" class="mt10">
       <input type="button" name="button" class="btn btn82 btn_add" value="通过"> 
       <input type="button" name="button" class="btn btn82 btn_del" value="删除">  
       <input type="button" name="button" class="btn btn82 btn_search" value="查询">   
     </div>
                    
     <div id="table" class="mt10">
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="100">ID</th>
                   <th width="100">商品名</th>
                   <th width="100">价格</th>
                   <th width="100">买家</th>
                   <th width="100">卖家</th>
                   <th width="100">操作</th>
                   
                    </tr>
                <tr class="tr">
                   <td>aad</td>
                   <td>aad</td>
                   <td>aad</td>
                   <td>aad</td>
                   <td>aad</td>
                   <td><a href="" class="">审核</td>
                 
                 </tr>
                 <tr class="tr"> 
                   <td>aad</td>
                   <td>aad</td>
                   <td>aad</td>
                   <td>aad</td>
                   <td>aad</td>
                
                 </tr>
                               
              </table>
              <div class="page mt10">
                <div class="pagination">
                  <ul>
                      <li class="first-child"><a href="#">首页</a></li>
                      <li class="disabled"><span>上一页</span></li>
                      <li class="active"><span>1</span></li>
                      <li><a href="#">2</a></li>
                      <li><a href="#">下一页</a></li>
                      <li class="last-child"><a href="#">末页</a></li>
                  </ul>
                </div>

              </div>
   <div class="box_bottom pb5 pt5 pr10" style="border-top:1px solid #dadada;">
              <div class="search_bar_btn" style="text-align:right;">
                 <input type="submit" value="确定" class="ext_btn ext_btn_submit">
                 <input type="button" value="返回" onclick="location.href='index.html'" class="ext_btn">
              </div>
            </div>
        </div>
     </div>
     
     
      
     
 </body>
 </html>
  