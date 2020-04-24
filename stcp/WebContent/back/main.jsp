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
	body {
		background-image: url(images/1.jpg);
		
    	
		}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
</body>
</html>