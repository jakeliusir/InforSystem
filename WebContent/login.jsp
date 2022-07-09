<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + 
			":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>电脑销售管理系统</title>
<base href="<%=basePath%>">
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

</head>

<body>
	<div class="login">
		<div class="login-box">
			<div class="logo png"></div>
			<div class="login-form">
				<form action="Loginservlet" method="post" class="form">
				 <span id="infor" style="color:red;margin:0 100px">${msg}</span>
					<div class="name">
						<label>用户名</label><input type="text" class="text" id="userName"
							placeholder="用户名" name="username" tabindex="1" required="required" onfocus="change()"></br>
					</div>
					<div class="pwd">
						<label>密&nbsp;&nbsp;码</label><input type="password" class="text"
							placeholder="密码" name="password" tabindex="2" required="required"></br>
						<input class="submit" type="submit" value="登陆" />
					</div>
				</form>
			</div>
		</div>
		<div class="air-balloon ab-1 png"></div>
		<div class="air-balloon ab-2 png"></div>
		<div class="footer"></div>
	</div>
	<script >
	function change() {
		document.getElementById("infor").innerHTML="";
	}
	</script>
</body>

</html>