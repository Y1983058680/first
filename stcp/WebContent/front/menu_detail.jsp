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
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<script>
	function checkLogin(){
		$.ajax( {
			url:'plchecklogin',
			type:'post',
			data: {
							
			},
			datatype : "json",//"xml", "html", "script", "json", "jsonp", "text".           
			success : function(data) {
				
				if(data=="Y"){
					fbpl();
					//alert("发表评论");
				}else{
					alert("请登录后再发表评论");
				}
				
			}
		});
	}

	function fbpl() {
		var mid=${requestScope.menu.id };
		var con=$("#plcon").val();
		
		$.ajax( {
			url:'pladd',
			type:'post',
			data: {
				mid:mid,
				con:con
			},
			datatype : "json",//"xml", "html", "script", "json", "jsonp", "text".           
			success : function(data) {
				var json=eval('('+data+')');
				var plr=json.plr;
				var plsj=json.plsj;
				
				var plcon="<tr><td>评论人："+plr+"评论时间"+plsj+"</td></tr><tr><td style='border-bottom: 1px solid red;'>"+con+"</td></tr>";
				$("#pllb").prepend(plcon);

				
			}
		});
	}
</script>
<!-- 页面CSS -->
<style type="text/css">
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
	<table>
		<tr>
			<th align="center">
				${requestScope.menu.title }
			</th>
		</tr>
		<tr>
			<td align="center">
				作者：${requestScope.menu.auther }
				创建时间：${requestScope.menu.createtime }
				阅读量：${requestScope.menu.ydl }
			</td>
		</tr>
		<tr>
			<td align="center">
				${requestScope.menu.content }
			</td>
		</tr>
		<tr>
			<td>
				<textarea id="plcon" rows="5" cols="80"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="发表评论" onclick="checkLogin()"/>
			</td>
		</tr>
		
	</table>
	<!-- 评论展示 -->
	<table id="pllb">
		<c:forEach items="${pls }" var="pl">
			<tr>
				<td>评论人：${pl.plr }评论时间：${pl.plsj }</td>
			</tr>
			<tr>
				<td style='border-bottom: 1px solid red;'>${pl.content }</td>
			</tr>
		</c:forEach>
	</table>
	
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>