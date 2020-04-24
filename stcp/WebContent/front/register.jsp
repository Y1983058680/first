<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>STCP</title>
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<script>
function checkName(){
	var zh=$("#zh").val();
	
	$.ajax( {
		url:'<%=basePath %>checkname',
		type:'post',
		data: {
			zh:zh			
		},
		datatype : "json",//"xml", "html", "script", "json", "jsonp", "text".           
		success : function(data) {
			
			if(data=="Y"){
				$("#res").html("已存在");
			}else{
				$("#res").html("");
			}
			
			
		}
	});
	
}

</script>

<style type="text/css">
.div2 {
	height: 1000px;
	width: 100%;
	background-color: #7f8c8d;
}

.box1 {
	width: 300px;
	padding: 20px;
	position: absolute;
	top: 55%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: #c0392b;
	text-align: center;
}

.box1 h1 {
	color: black;
	text-transform: uppercase;
	font-weight: 800;
}

.box2 {
	height: 40px;
	margin-bottom: 20px;
	color: black;
	font-size: 20px;
}

.box2 input[type="text"], .box2 input[type="password"] {
	border: 0;
	height: 25px;
	border-radius: 5px;
}

.box1 input[type=submit] {
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #f39c12;
	padding: 14px 40px;
	outline: none;
	color: white;
	border-radius: 15px;
	transition: 0.25s;
	cursor: pointer;
}

.box1 input[type=submit]:hover {
	background: #2980b9;
}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="div2">
		<form class="box1" action="<%=basePath%>register" method="post">
			<h1>注册</h1>
			<div class="box2">
				账号&nbsp&nbsp<input type="text" name="zh" placeholder="请输入账号" onblur="checkName()" id="zh"/><div id="res"></div>
				
			</div>
			<div class="box2">
				密码&nbsp&nbsp<input type="password" name="pass" placeholder="请输入密码" />
			</div>
			<div class="box2">
				姓名&nbsp&nbsp<input type="text" name="realname" placeholder="请输入真实姓名" />
			</div>
			<input type="submit" value="注册" />
		</form>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>