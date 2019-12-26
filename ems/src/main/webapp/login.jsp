<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="css/bootstrap.css">
<style>
.login {
	position: absolute;
	top: 40%;
	left: 48%;
	margin: -150px 0 0 -150px;
	width: 1000px;
	height: 300px;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">登录</h1>
	<hr width="80%">
	<form action="${pageContext.request.contextPath }/EmpServlet?cmd=login"
		method="post" class="form-horizontal">
		<div class="login">
			<div class="form-group">
				<label class="col-sm-1 control-label">账号</label>
				<div class="col-sm-3">
					<input class="form-control" id="nickname" name="nickname">
				</div>
			</div>
			<br>
			<div class="form-group">
				<label for="inputpassword" class="col-sm-1 control-label">密码</label>
				<div class="col-sm-3">
					<input type="password" class="form-control" id="password"
						name="password">
				</div>
			</div>
			<br>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<button type="submit" class="btn btn-primary"  style="margin-right:100px;">登陆</button>
					<button type="reset" class="btn btn-primary"
						onClick="window.location.href='register.jsp'">注册</button>
				</div>
			</div>
		</div>
	</form>

</body>
</html>