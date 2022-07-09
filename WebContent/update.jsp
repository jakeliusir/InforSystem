<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%String basePath=request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SB Admin 2 - Bootstrap Admin Theme</title>
    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath %>/css/bootstrap.min.css" rel="stylesheet">   
</head>
<body>	
 
   
        

	<div class="container"></div>
	    <div class="col-lg-8">
	      <div class="panel panel-info">	      
	         <div class="panel-heading">
	                                 电脑信息修改
	         </div>
	         <div class="panel-body">
	         
	           <form  role="form" action="update2" method="post">
	            <!--  需要埋一个主键  用于发送到后台根据ID进行修改 -->
	            <!-- stu 是这个被修改的单条休息 -->
	            <!-- value 是默认值 -->
	             <input   type = "hidden" name="id" value="${com.id }"/>
	           
	             <div class="form-group">
	                 <label>电脑名称</label>
	                  <input class="form-control" name="brand"   value="${com.brand }">
                      <p class="help-block">*请填写正确的电脑名称，便于后期审核.</p>
	             </div>
	            
	           
	              <div  class="form-group">
                        <label>电脑价格</label>
	                  <input class="form-control" name="price"   value="${com.price }">
                      <p class="help-block">*请填写正确的电脑价格，便于后期审核.</p>             
                  </div> 
                                      
                  <div class="form-group">
                   <label>电脑颜色</label>
                   <input class="form-control" name="color" value="${com.color }">
                   <p class="help-block">请填写正确的颜色 </p>
                 </div>   
	             
	             
	             
	           
	               <button type="submit" class="btn btn-primary btn-lg btn-block">提交</button>
	           </form>         
	         
	         </div>	         
	         <div class="panel-footer">
	                              后台管理系统千锋版权所有
	         </div>
	    
	    
	    </div>
	
	
	
	
	</div>
	
</body>
</html>