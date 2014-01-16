<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<style type="text/css">
.style26 {
				text-align: center;
}
.style24 {
				text-decoration: none;
}
.style25 {
				color: #EA0000;
}
.style27 {
				font-family: 標楷體;
				text-align: left;
				color: #FFFFFF;
}
.style29 {
				border-width: 0;
}
</style>
<body >
<div class="header01">&nbsp;&nbsp;&nbsp;&nbsp;衣服購物商城 <div class="log">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:a href="back_index.action" target="_parent">登出</s:a></div></div>
</body>
</html>
