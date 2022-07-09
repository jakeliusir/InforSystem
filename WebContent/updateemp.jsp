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
	<div class="container"></div>
	    <div class="col-lg-8">
	      <div class="panel panel-info">	      
	         <div class="panel-heading">
	                                 员工信息修改
	         </div>
	         <div class="panel-body">
	         
	           <form  role="form" action="updateemp2" method="post">
	            <!--  需要埋一个主键  用于发送到后台根据ID进行修改 -->
	            <!-- stu 是这个被修改的单条休息 -->
	            <!-- value 是默认值 -->
	             <input   type = "hidden" name="id" value="${emp.id }"/>
	           
	             <div class="form-group">
	                 <label>员工名字</label>
	                  <input class="form-control" name="username"   value="${emp.username }">
                      <p class="help-block">*请填写正确的员工名字，便于后期审核.</p>
	             </div>
	            
	           
	              <div  class="form-group">
                        <label>密码</label>
	                  <input class="form-control" name="password"   value="${emp.password}">
                      <p class="help-block">*请填写正确的员工密码，便于登录系统.</p>             
                  </div> 
                                      
                  <div class="form-group">
                   <label>电话</label>
                   <input class="form-control" name="phone" value="${emp.phone}">
                   <p class="help-block">请填写本人的有效电话 </p>
                 </div>  
                  
	             <div class="form-group">
                   <label>部门</label>
                   <input class="form-control" name="section" value="${emp.section}">
                   <p class="help-block">请填写自己所在的部门 </p>
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