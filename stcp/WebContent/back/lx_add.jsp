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
<title>双体菜谱</title>
<style type="text/css">
	.form1{
		float: left;
		width: 20%;
		line-height: 30px;
		margin-left: 40%;
		margin-top: 10%;
	}
	td{
		text-align:center;
	}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	
	<form action="<%=basePath %>lxadd" method="post" class="form1">
		<h1 align="center">类型新增</h1><br/>
		类型名称：<input name="lxmc"/><br/>
		<input type="submit" value="新增菜谱类"/>
	</form>
	
</body>
</html>