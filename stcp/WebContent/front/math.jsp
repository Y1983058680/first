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
<title>Insert title here</title>
	<script>
			function move(){
				var t=Math.random()*500;
				var l=Math.random()*500;
				
				var img=document.getElementById("img001");
				img.style.top=t+"px";
				img.style.left=l+"px";
				
				setTimeout("move()",1000);
			}
		</script>
</head>
<body onload="move()">
		<img id="img001" style="position:absolute;
					top:200px;
					left:200px;" src="<%=basePath %>images/logo.png"/>
</body>
</html>