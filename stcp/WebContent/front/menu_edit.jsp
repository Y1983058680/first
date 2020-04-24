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
<style type="text/css">
table{
		width: 700px;
		margin: 0 auto;
		border-collapse: collapse;
		margin-top: 50px;
		background-color: white;
		text-decoration-line: none;
		text-align: center;
	}
	td , th{
		border: 1px solid black;
		font-size: 25px;
		
		
	}
</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<form action="<%=basePath%>menuup" method="post">
		<table>
			<tr>
				<th>菜谱类型</th>
				<td><select name="lxid" id="lxid">
						<c:forEach items="${requestScope.lxs }" var="lx">
							<option value="${lx.id }">${lx.lxmc }</option>
						</c:forEach>
						<script>
							var lxid = $
							{
								menu.lxid
							};
							document.getElementById("lxid").value = lxid;
						</script>
				</select></td>
			</tr>
			<tr>
				<th>标题</th>
				<td><input name="title"
					style="width: 540px; height: 30px; border: none"
					value="${menu.title }" /></td>
			</tr>
			<tr>
				<th>内容</th>
				<td><textarea style="width: 540px; height: 100px; border: none"
						name="content" rows="5" cols="50">${menu.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>