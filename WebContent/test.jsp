<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>欢迎来到跳转后的页面</h1>
${name1 }
<br/>
${name2 }
<br/>
${name3 }
<br>
${data }
<!-- 有一个三行三列的数据 让他以表格的方式展示 -->
<table border="1">
<tr>
<td>姓名</td>
<td>学号</td>
<td>班级</td>
<td>操作</td>
</tr>
<c:forEach items="${data }"  var="map">
<tr>
<td>${map.name }</td>
<td>${map.number }</td>
<td>${map.subject }</td>

<c:if test="${map.qx eq '1'}">
<td><button>修改</button></td>
</c:if>
</tr>
</c:forEach>


</table>

</body>
</html>
