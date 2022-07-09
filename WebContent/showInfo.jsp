<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 移动端媒体自适应的写法 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link  href="<%=request.getContextPath()%>/css/bootstrap.min.css"  rel="stylesheet">

<title>Insert title here</title>
   <style>
      /*  让下面隐藏的信息  宽度小一点   往左下一点*/
      
      #xinxi{ 
      position:relative;/*相对于原来的位置进行定位移动*/
      width:80%;/*宽度变为原来的80%  */
      top:20px; /*高度往下移动20像素  */
      left:20px; /*往右移动20像素*/
      font-size:10px; /* 调整文字大小*/
      }
        
   </style>

</head>
<body>
<!-- 导航条 -->
<nav class="navbar navbar-default">
 <div class="container-fluid">
  <a href="#" class="navbar-brand">电脑销售管理系统</a>
  <!-- 增加一个列表  让 XXXX你好  在右边显示 -->
  <ul class="nav navbar-nav navbar-right">
    <li><a>欢迎 ${sessionScope.nickname }来到新世纪电脑城</a></li>
  </ul>   
  </div>
</nav>
<!--   写左侧  导航   和右侧主体部分 -->
<div  class="container-fluid">
    <!--  这是整个一行  一共有12份-->
   <div class="row">
      <!-- 左侧导航栏 -->
      <div class="col-sm-3">      
        <div class="list-group">
         <a href="#" class="list-group-item active">左侧导航</a>
          <!--  点击下面链接   隐藏部分出现  -->
         
         <a href="#xinxi1" class="list-group-item" data-toggle="collapse">电脑信息管理</a>
          <a href="#xinxi2" class="list-group-item" data-toggle="collapse">顾客信息管理</a>
           <a href="#xinxi3" class="list-group-item" data-toggle="collapse">员工信息管理</a>
             <a href="#xinxi4" class="list-group-item" data-toggle="collapse">销售信息管理</a>
                <a href="#xinxi5" class="list-group-item" data-toggle="collapse">系统帮助管理</a>
          <!-- 下面是被隐藏和出现的条目 -->
          <!-- collapse 是隐藏的意思 -->
          <div id ="xinxi1" class="panel-collapse collapse">
          <a href="ComQueryAll" class="list-group-item" target="content">电脑列表</a>
       
             <!-- 是管理员  添加电脑信息才能够显示   -->
          
               <a href="insert.jsp" class="list-group-item" target="content">添加电脑信息</a>            
          
         
            <div style="padding: 2px 0px 0px;">
				<form class="bs-example bs-example-form" role="form">
					<div class="row">						
						<div class="col-lg-12">
							<div class="input-group">
								<input id="mytext"  type="text" class="form-control">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button" onclick="chaxun()" >
										查询
									</button>
								</span>
							</div><!-- /input-group -->
						</div><!-- /.col-lg-6 -->
					</div><!-- /.row -->
				</form>
			</div>
					
<!-- 写一个查询函数  -->

<script>
   function chaxun()  {
	   var str=$("#mytext").val();
	   $("#myframe").attr("src","ChaXun?Cbrand="+str)     
   }
</script>    
     
         </div>
            <div id ="xinxi2" class="panel-collapse collapse">
           <a href="CusQueryAll" class="list-group-item" target="content">顾客列表</a>
             <!-- 是管理员  添加顾客信息才能够显示   -->
          
               <a href="insertCus.jsp" class="list-group-item" target="content">添加顾客信息</a>            
          
         
            <div style="padding: 2px 0px 0px;">
				<form class="bs-example bs-example-form" role="form">
					<div class="row">						
						<div class="col-lg-12">
							<div class="input-group">
								<input id="mytext1"  type="text" class="form-control">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button" onclick="chaxun1()" >
										查询
									</button>
								</span>
							</div><!-- /input-group -->
						</div><!-- /.col-lg-6 -->
					</div><!-- /.row -->
				</form>
			</div>
 <!-- 写一个查询函数  -->
<script>
   function chaxun1()  {
	   var str1=$("#mytext1").val();
	   $("#myframe").attr("src","ChaXuncus?CnameCus="+str1)     
   }
</script>   
					         
         </div>
           <div id ="xinxi3" class="panel-collapse collapse">
            <a href="EmpQueryAll" class="list-group-item" target="content">员工列表</a>
             <!-- 是管理员  添加员工信息才能够显示   -->
          
               <a href="insertEmp.jsp" class="list-group-item" target="content">添加员工信息</a>            
          
         
            <div style="padding: 2px 0px 0px;">
				<form class="bs-example bs-example-form" role="form">
					<div class="row">						
						<div class="col-lg-12">
							<div class="input-group">
								<input id="mytext2"  type="text" class="form-control">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button" onclick="chaxun2()" >
										查询
									</button>
								</span>
							</div><!-- /input-group -->
						</div><!-- /.col-lg-6 -->
					</div><!-- /.row -->
				</form>
			</div>
					         
         </div>
         
 <!-- 写一个查询函数  -->
<script>
   function chaxun2()  {
	   var str2=$("#mytext2").val();
	   $("#myframe").attr("src","ChaXunEmp?CnameEmp="+str2)     
   }
</script>   
               <div id ="xinxi4" class="panel-collapse collapse">
            <a href="SaleQueryAll" class="list-group-item" target="content">销售列表</a>
             <!-- 是管理员  添加员工信息才能够显示   -->
          
               <a href="insertSale.jsp" class="list-group-item" target="content">添加电脑销售信息</a>            
          
         
            <div style="padding: 2px 0px 0px;">
				<form class="bs-example bs-example-form" role="form">
					<div class="row">						
						<div class="col-lg-12">
							<div class="input-group">
								<input id="mytext3"  type="text" class="form-control">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button" onclick="chaxun3()" >
										查询
									</button>
								</span>
							</div><!-- /input-group -->
						</div><!-- /.col-lg-6 -->
					</div><!-- /.row -->
				</form>
			</div>
					         
         </div>  
 <!-- 写一个查询函数  -->
<script>
   function chaxun3()  {
	   var str3=$("#mytext3").val();
	   $("#myframe").attr("src","ChaXunSale?Cname="+str3)     
   }
</script>   
   <!--   系统帮助 -->
         <div id ="xinxi5" class="panel-collapse collapse">
           <a href = http://localhost:8080/InforSystem/login.jsp><button>退出登录</button></a>
           
         </div>
         
        </div>      
      </div>
      <!-- 右侧导航栏  主体部分 -->
      <div class="col-sm-8">     
        <iframe id="myframe" name="content" style="width:100%;height:500px;border:0" src="ComQueryAll" ></iframe>
                
      </div> 
   </div>
 </div>






<!--  引入bootstrap  js 完成动态功能 -->

<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</body>
</html>