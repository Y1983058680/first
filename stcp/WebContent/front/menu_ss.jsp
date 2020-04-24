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
	.div1{
		height: 700px;
	}
	table{
		width: 80%;
		margin: 0 auto;
		border-collapse: collapse;
		margin-top: 50px;
		background-color: white;
		text-decoration-line: none;
	}
	td , th{
		border: 1px solid black;
		font-size: 25px;
		
		
	}
	td a{
		text-decoration-line: none;
	}
	tr:nth-child(even) {
		background-color: #ff793f;
	}
	tr:hover{
		background-color: #ff0;
	}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="div1">
		<table>
		<tr>
			<th>
				编号
			</th>
			<th>
				标题
			</th>
			<th>
				创建时间
			</th>
			<th>
				作者
			</th>
		</tr>
		<c:forEach items="${requestScope.menus }" var="menu">
			<tr>
				<td>
					${menu.id }
				</td>
				<td>
					<a href="<%=basePath %>menudetail?id=${menu.id }">${menu.title }</a>
				</td>
				<td>
					${menu.createtime }
				</td>
				<td>
					${menu.auther }
				</td>
			</tr>
		</c:forEach>
	</table>
	
	</div>
	
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>