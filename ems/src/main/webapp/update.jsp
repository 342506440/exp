<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="css/bootstrap.css">
<style>
.register {
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
<!-- 引入jquery -->
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
	
</script>
</head>

<body>
	<h1 style="text-align: center;">修改</h1>
	<hr width="80%">
	<form id="myform"
		action="${pageContext.request.contextPath }/EmpServlet?cmd=update"
		method="post" class="form-horizontal">
		<div class="register">
			<div class="form-group">
				<label for="inputnickname" class="col-sm-1 control-label">ID</label>
				<div class="col-sm-3">
					<input type="text" readonly  class="form-control" id="uid" name="uid"
						autocomplete="off" value=${emp.id }>
				</div>
			</div>
			<br>
			<div class="form-group">
				<label for="inputnickname" class="col-sm-1 control-label">账号</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="nickname"
						name="nickname" autocomplete="off" value=${emp.nickname } onclick="onclicknickname() "
						onblur="outnickname()">
				</div>
				<!-- 显示请求域中的信息 -->
				<span id="nicknameSpan"></span>
			</div>
			<br>
			<!-- 			<div class="form-group"> -->
			<!-- 				<label for="inputpassword" class="col-sm-1 control-label">密码</label> -->
			<!-- 				<div class="col-sm-3"> -->
			<!-- 					<input type="password" class="form-control" id="password" -->
			<!-- 						name="password" onclick="onclickpassword() " onblur="outpassword()"> -->
			<!-- 				</div> -->
			<!-- 				<span id="passworeSpan"></span> -->
			<!-- 			</div> -->
			<!-- 			<br> -->
			<!-- 			<div class="form-group"> -->
			<!-- 				<label for="inputpassword2" class="col-sm-1 control-label">确认</label> -->
			<!-- 				<div class="col-sm-3"> -->
			<!-- 					<input type="password" class="form-control" id="password2" -->
			<!-- 						name="password2" onclick="onclickpassword2() " onblur="outpassword2()" > -->
			<!-- 				</div> -->
			<!-- 				<span id="passworeSpan2"></span> -->
			<!-- 			</div> -->
			<!-- 			<br> -->
			<div class="form-group">
				<label for="inputgender" class="col-sm-1 control-label">性别</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="gender" name="gender" value=${emp.gender }
						autocomplete="off">
				</div>
			</div>
			<!--
			<div class="form-group">
				<label for="inputgender" class="col-sm-1 control-label" style="margin-right:20px;">性别</label>
			 <label class="radio-inline">
                <input type="radio" name="gender" id="gender1" value="1" checked > 男
            </label>
            <label class="radio-inline">
                <input type="radio" name="gender" id="gender2"  value="2"> 女
            </label>
			</div>
			-->
			<br>
			<div class="form-group">
				<label for="inputsalary" class="col-sm-1 control-label">工资</label>
				<div class="col-sm-3">
					<input class="form-control" id="salary" name="salary" value=${emp.salary }
						autocomplete="off" onclick="onclicksalary()" onblur="out()">
				</div>
				<span id="salarySpan"></span>
			</div>
			<br>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<button type="submit" class="btn btn-primary"
						style="margin-right: 100px;" id="sub">确定</button>
					<button type="reset" class="btn btn-primary"
						onClick="window.location.href='main.jsp'">返回</button>
				</div>
			</div>
			<script type="text/javascript">
				/* 当光标放入到账号的输入框中, 则提示输入信息和隐藏 */
				function onclicknickname() {
					// alert("点击了nickname输入框");

					// 获取对应的span标签, 
					var nSpan = document.getElementById("nicknameSpan");

					// 在span标签中显示提示内容
					nSpan.innerHTML = "<font color='black'>*请输入8到16位的昵称</font>";
				}
				function outnickname() {
					var nSpan = document.getElementById("nicknameSpan");
					nSpan.innerHTML = "<font color='black'></font>";
				}

				/* 当光标放入到密码的输入框中, 则提示输入信息和隐藏 */
				function onclickpassword() {

					var nSpan = document.getElementById("passworeSpan");
					nSpan.innerHTML = "<font color='black'>*请输入密码</font>";
				}
				function outpassword() {
					var nSpan = document.getElementById("passworeSpan");
					nSpan.innerHTML = "<font color='black'></font>";
				}

				/* 当光标放入到确认密码的输入框中, 则提示输入信息和隐藏 */
				function onclickpassword2() {

					var nSpan = document.getElementById("passworeSpan2");
					nSpan.innerHTML = "<font color='black'>*请再次输入密码</font>";
				}
				function outpassword2() {
					var nSpan = document.getElementById("passworeSpan2");
					nSpan.innerHTML = "<font color='black'></font>";
				}

				/* 当光标放入到工资的输入框中, 则提示输入信息和隐藏 */
				function out() {

					var nSpan = document.getElementById("salarySpan");
					nSpan.innerHTML = "<font color='black'></font>";
				}
				function onclicksalary() {

					var nSpan = document.getElementById("salarySpan");
					nSpan.innerHTML = "<font color='black'>*请输入大于0的数</font>";
				}
			</script>
		</div>
	</form>
</body>
</html>
