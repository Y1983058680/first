<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>STCP</title>
<style type="text/css">
		.div2{
			height: 1000px;
			width: 100%;
			background-color: #7f8c8d;
		}
		.box1{
			width: 300px;
			padding: 20px;
			position: absolute;
			top: 60%;
			left: 50%;
			transform: translate(-50%,-50%);
			background-color: #c0392b;
			text-align: center;
		}
		.box1 h1{
			color: black;
			font-weight: 800;
		}
		.box2 input[type = "text"],.box2 input[type = "password"]{
			border: 0;
			height: 25px;
			border-radius: 5px;
		}
		.box2{
			height: 40px;
			margin-bottom:20px;
			color: black;
			font-size: 20px;
		}
		.box1 input[type = submit]{
            border: 0;
            background: none;
            display: block;
            margin: 20px auto;
            text-align: center;
            border: 2px solid #f39c12;

            padding: 14px 40px ;
            outline: none;
            color: white;
            border-radius: 15px;
            transition: 0.25s;
            cursor: pointer;
        }
        .box1 input[type = submit]:hover{
            background: #2980b9;

        }
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="div2">
		<form class="box1" action="<%=basePath %>flogin" method="post">
			<h1>登录</h1>
			<div class="box2">
				账号&nbsp&nbsp<input type="text" name="zh" placeholder="请输入账号"/>
			</div>
			<div class="box2">
				密码&nbsp&nbsp<input type="password" name="pass" placeholder="请输入密码"/>
			</div>
			<input type="submit" value="登录"/>
		</form>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>