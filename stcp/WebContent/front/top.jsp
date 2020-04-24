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
	*{
		margin: 0;
		padding: 0; 
	}
	body{
		background-color: #ecf0f1;
	}
	.div11{
		float: left;
		width: 100%;
		height: 80px;
		background-color: #c0392b;
	}
	.div111{
		float: left;
		margin-top: 15px;
		margin-left: 40px;
	}
	.span11{
		color: #f1c40f;
		font-size: 40px;
	}
	.ul1{
		/*
			 清楚列表样式
			 */
			list-style: none;			
	}
	.ul1 li{
		float: right;
		width: 80px;
		margin-right: 50px;
		margin-top: 20px;
		
	}
	.ul1 a{
		display: block;
		width: 100%;
		text-align: center;
		/*
		设置内边距
		 */
		padding: 5px 0;
		/* 去除下划线 */
		text-decoration-line: none;
		color: white;
		font-weight: bold;
	}
	.ul1 a:hover{
		background-color: #EA2027;
	}
	.ul2{
		list-style: none;
	}
	.ul2 li{
		float: right;
		width: 80px;
		margin-right: 10px;
		margin-top: 20px;
		
	}
	.ul2 a{
		display: block;
		width: 100%;
		text-align: center;
		/*
		设置内边距
		 */
		padding: 5px 0;
		/* 去除下划线 */
		text-decoration-line: none;
		color: white;
		font-weight: bold;
	}
	.ul2 a:hover{
		background-color: #EA2027;
	}
	
	.in1{
		float: left;
		width: 400px;
		height: 30px;
	}
	.in2{
		width: 50px;
		height: 34px;
		border: 2px solid white;
		background-color: #c0392b;
	}
	.div113{
		float: left;
		margin-top: 20px;
		margin-left: 20%;
		background-color: black;
	}
	.div113 input[type=submit]:hover{
		background-color: #EA2027;
	}
	.div12{
		float: left;
		width: 100%;
		height: 50px;
	}
	.div121{
		float: left;
		height: 100%;
		width: 15%;
	}
	.nav{
		/*
			 清楚列表样式
			 */
			list-style: none;
			/*
			
			 */
			background-color: white;
			/*
			
			 */
			width: 100%;
			height: 50px;

	}
	.nav li{
		float: left;
		width: 100px;
	}
	.nav li a{
			display: block;
			width: 100%;
			text-align: center;
			/*
			设置内边距
			 */
			padding:12px 0;
			/* 去除下划线 */
			text-decoration-line: none;
			color: black;
			font-size: 20px;
			font-weight: bold;
		}
	.nav a:hover{
			background-color: #95a5a6;
		}
	.span1{
		display: block;
		color: black;
		font-weight: hold;
		font-size: 18px;
		text-align: center;
	}
</style>
</head>
<body>
	<div class="div11">
		<div class="div111">
		<span class="span11">ST菜谱</span>
		</div>
		<div class="div113">
		<form action="<%=basePath %>sous" method="post">
			<input class="in1" type="text" name="ss" placeholder="请输入菜谱名/作者" />
			<input class="in2" type="submit" value="搜索"/>
		</form>
			
		</div>
		<div class="div112">
		<c:if test="${sessionScope.USER==null }">
			<ul class="ul1">
				<li>
					<a href="<%=basePath%>front/register.jsp">注册</a>	
				</li>
				<li>
					<a href="<%=basePath %>front/login.jsp">登录</a>	
				</li>
			</ul>
		</c:if>
		<c:if test="${sessionScope.USER!=null }">
			<ul class="ul2">
				<li><a href="<%=basePath %>flogout">退出登录</a></li>
				<li><a href="<%=basePath %>getlx">新增菜谱</a></li>
				<li><a href="<%=basePath %>menusel">我的菜谱</a></li>
				<li style="width: 120px; margin-top: 25px;"><span class="span1">${sessionScope.USER.realname },欢迎你！</span></li>
			</ul>
		</c:if>
		</div>
	</div>
	<div class="div12">
		<div class="div121"></div>
		<ul class="nav">
			<li>
				<a href="<%=basePath %>index">首页</a>
			</li>
			<c:forEach items="${sessionScope.lxs }" var="lx">
			<li>
				<a href="<%=basePath %>menusellx?lxid=${lx.id }">${lx.lxmc }</a>
			</li>
		</c:forEach>
		</ul>
	</div>
	
	
</body>
</html>