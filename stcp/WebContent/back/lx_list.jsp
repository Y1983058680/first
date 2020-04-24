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
<title>双体菜谱</title>
<style type="text/css">
	body {
		background-image: url(images/2.jpg);
		background-repeat:no-repeat;
    	background-position:center;
		}
	.table1{
		float: left;
		width: 60%;
		line-height: 30px;
		margin-left: 20%;
		background-color: #747d8c;
	}
	td{
		text-align:center;
	}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>

	<table class="table1" >
		<tr>
			<th>编号</th>
			<th>菜系</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.lxs }" var="lx">
			<tr>
				<td>${lx.id }</td>
				<td>${lx.lxmc }</td>
				<td>
					<a href="<%=basePath %>lxedit?id=${lx.id }">编辑</a> 
					<a href="<%=basePath %>lxdel?id=${lx.id }">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>