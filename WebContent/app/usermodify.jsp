<!DOCTYPE HTML>
<html>
<head>
<title>修改用户信息</title>
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
	        <h1 class="navbar-brand"><a  href="index.html">我的主页</a></h1>
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
		  	  <form> 
				 <div class="register-top-grid">
					<h3>个人信息</h3>
					 <div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span>学号<label>*</label></span>
						<input type="text"> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>密码<label>*</label></span>
						<input type="text"> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						 <span>姓名</span>
						 <input type="text"> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						 <span>电话</span>
						 <input type="text"> 
					 </div>
					 <div class="wow fadeInRight" data-wow-delay="0.4s">
						 <span>校区</span>
						 <select class="kuang">
                                                 <option>浦东</option>
                                                 <option>松江</option>
                                                 <option>徐汇</option>
                                                 </select>
					</select>
					 </div>
					 <div class="clearfix"> </div>
					 
				</form>
				<div class="clearfix"> </div>
				<div class="register-but">
				   <form>
					   <center><input type="submit" value="提交"></center>
					   <div class="clearfix"> </div>
				   </form>
				</div>
		   </div>
		 </div>
	</div>

			
</body>
</html>