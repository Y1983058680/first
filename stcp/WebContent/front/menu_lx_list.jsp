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
		float: left;
		width: 100%;
		height: 1000px;
		background-color: #e74c3c;
	}
	.div21{
		float: left;
		width: 13%;
		height: 100%;
	}
	.div22{
		float: left;
		width: 70%;
		height: 100%;
		margin-left:2%;
		background-color: #e74c3c;
	}
	.div23{
		float: right;
		width: 13%;
		height: 100%;
	}
	table{
		width: 700px;
		margin: 0 auto;
		border-collapse: collapse;
		margin-top: 50px;
		background-color: white;
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
	<div class="div2">
		<div class="div21"></div>
		<div class="div22">
	<table>
		<tr>
			<th>
				标题
			</th>
			<th width=300px>
				创建时间
			</th>
		</tr>
		<c:forEach items="${requestScope.menulx }" var="menu">
			<tr>
				<td>
					<a href="<%=basePath %>menudetail?id=${menu.id }">${menu.title }</a>
				</td>
				<td>
					${menu.createtime }
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div class="div23"></div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>