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
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	类型新增页面
	<form action="<%=basePath %>lxup" method="post">
		<input type="hidden" name="id" value="${lx.id }"/><br/>
		类型名称：<input name="lxmc" value="${lx.lxmc }"/><br/>
		<input type="submit" value="编辑菜谱类型"/>
	</form>
</body>
</html>