<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<!-- 引入C标签 -->

<title>Dashboard Template for Bootstrap</title>
<!-- 引入jquery框架 -->
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="dashboard.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>


<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="submit" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">系统主页</a> 

			</div>
			<div id="navbar" class="navbar-collapse collapse in"
				aria-expanded="true" style="">

				<a class="navbar-brand navbar-right" type="submit" href="login.jsp">返回登录</a>
				<form class="navbar-form navbar-right" action="${pageContext.request.contextPath }/EmpServlet?cmd=findbyid"
				method="post">
					<input type="text" class="form-control" name="id" id="id" placeholder="Search...">
					</form>
					<a class="navbar-brand navbar-right" type="submit">按ID查询</a>
			</div>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar ">
				<ul class="nav nav-sidebar ">
					<li class="active"><a href="#">选择<span class="sr-only">(current)</span></a></li>
					<li class="active"><a href="#"> <span class="sr-only">(current)</span></a></li>
					<li><a
						href="${pageContext.request.contextPath }/EmpServlet?cmd=main">用户管理主页</a></li>
				</ul>
			</div>
			<h2 class="sub-header">Section title</h2>
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>账号</th>
							<th>性别</th>
							<th>工资</th>
							<th>操作</th>
						</tr>

					</thead>
					<tbody>
						<c:forEach items="${list}" var="userList">
							<tr>
								<td>${userList.id }</td>
								<td>${userList.nickname }</td>
								<td>${userList.gender }</td>
								<td>${userList.salary }</td>
								<td><a class="btn btn-primary"
									href="${pageContext.request.contextPath }/EmpServlet?id=${userList.id}&cmd=updateget">修改</a>
									<a class="btn btn-danger"
									href="${pageContext.request.contextPath }/EmpServlet?id=${userList.id}&cmd=delete">删除</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>