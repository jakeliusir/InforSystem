<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.min.css"  rel="stylesheet">
</head>
<body>
<table class="table table-hover  table-striped" style="width:800px;height:200px"><!--bootstrap 前端框架  -->
    <tr>
       <td>id</td>   
       <td>员工</td>   
       <td>密码</td>   
       <td>电话</td> 
        <td>部门</td> 
         <td>操作</td>     
    </tr>
     <c:forEach items="${list }"  var="map">
<tr>
<td>${map.id }</td>
<td>${map.username }</td>
<td>${map.password}</td>
<td>${map.phone }</td>
<td>${map.section }</td>
<td><a href="updateemp1?id=${map.id }">修改</a> <a href="DeleteEmpServlet?id=${map.id }">删除</a> </td>
</tr>
</c:forEach>
     
 </table>
 
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</body>
</html>