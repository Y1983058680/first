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
		.div33{
			float: left;
			background-color: rgba(241, 242, 246,1.0);
			width: 100%;
			height: 100px;
			margin-top: 2%;
			margin-bottom:1px;
			}
		.foot1{
			
			margin-left: 16%; 
			color: black;
			text-decoration-line: none;
		}
		.foot2{
			margin-top: 12px;
			margin-left: 16%; 
		}
</style>
</head>
<body>
	<!-- 底部 -->
	<div class="div33">
	<p class="foot1">
	<a target="" href="" title="关于我们">关于我们</a> ·
	<a target="" href="" title="联系我们">联系我们</a> ·
	<a target="" href="" title="加入我们">加入我们</a> ·
	<a target="_" href="" title="服务声明">服务声明</a> ·
	<a target="" href="" title="友情链接">友情链接</a> ·
	<a target="" href="" title="网站地图">网站地图</a> 
	</p>
	<p class="foot2">&copy; 2019-2020 ST菜谱 保留所有权利 - 京ICP证******号</p>
	</div>
</body>
</html>