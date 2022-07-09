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
	<div class="container"> </div>
	    <div class="col-lg-8">
	      <div class="panel panel-info">	      
	         <div class="panel-heading">
	                                 电脑信息新增
	         </div>
	         <div class="panel-body">
	         
	           <form  role="form" action="StuAddServlet" method="post">
	           
	             <div class="form-group">
	                 <label>电脑品牌</label>
	                  <input class="form-control" name="brand">
                      <p class="help-block">*请填写正确电脑品牌，便于后期审核.</p>
	             </div>
	            
	           
	              <div  class="form-group">
                          <label>电脑价格</label>
                   <input class="form-control" name="price">
                   <p class="help-block">请填写准确的电脑价格</p>         
                  </div> 
                                      
                  <div class="form-group">
                   <label>电脑颜色</label>
                   <input class="form-control" name="color">
                   <p class="help-block">请填写正确的电脑颜色 </p>
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