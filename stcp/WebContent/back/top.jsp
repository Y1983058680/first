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
<link rel="stylesheet"
	href=" https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/css/layui.css">
<script
	src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/layui.js"></script>
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">STCP 后台管理</div>
			<!-- 头部区域 -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="<%=basePath %>lxsel">查询类型</a></li>
				<li class="layui-nav-item"><a href="<%=basePath %>/back/lx_add.jsp">新增类型</a></li>
				<li class="layui-nav-item"><a href="<%=basePath %>usermanage">用户管理</a></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> 
					 个人中心
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">修改密码</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="<%=basePath %>logout">退了</a></li>
			</ul>
		</div>
	</div>
	<script src="//res.layui.com/layui/src/layui.js?t=1573457678867"
		charset="utf-8"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?d214947968792b839fd669a4decaaffc";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>
</html>