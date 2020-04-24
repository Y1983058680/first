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
	.table1{
		float: left;
		width: 60%;
		line-height: 30px;
		margin-left: 20%;
		
	}
	td{
		text-align:center;
	}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<table class="table1">
		<tr>
			<td>
				编号
			</td>
			<td>
				账号
			</td>
			<td>
				密码
			</td>
			<td>
				真实姓名
			</td>
			<td>
				操作
			</td>
		</tr>
		<c:forEach items="${requestScope.users }" var="user">
			<tr>
			<td>
				${user.id }
			</td>
			<td>
				${user.zh }
			</td>
			<td>
				${user.pass }
			</td>
			<td>
				${user.realname }
			</td>
			<td>
				<a href="">编辑</a>
				<a href="<%=basePath %>userdel?id=${user.id }">永久封号</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>