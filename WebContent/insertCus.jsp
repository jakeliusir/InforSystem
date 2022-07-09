<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="container">
	    <div class="col-lg-8">
	      <div class="panel panel-info">	      
	         <div class="panel-heading">
	                                 顾客信息新增
	         </div>
	         <div class="panel-body">
	         
	           <form  role="form" action="CusAddServlet" method="post">
	           
	             <div class="form-group">
	                 <label>顾客</label>
	                  <input class="form-control" name="顾客">
                      <p class="help-block">*请填写正确的顾客名字，便于后期审核.</p>
	             </div>
	            
	           
	              <div  class="form-group">
                          <label>接待人</label>
                   <input class="form-control" name="接待人">
                   <p class="help-block">请填写正确的接待人姓名</p>         
                  </div> 
                                      
                  <div class="form-group">
                   <label>电脑品牌</label>
                   <input class="form-control" name="电脑品牌">
                   <p class="help-block">请填写正确的电脑品牌 </p>
                 </div>  
                  
	             <div class="form-group">
                   <label>价格</label>
                   <input class="form-control" name="价格">
                   <p class="help-block">请填写正确的电脑价格</p>
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