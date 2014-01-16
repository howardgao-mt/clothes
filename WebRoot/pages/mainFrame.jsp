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

<title>歡迎光臨購物商城</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/admin.css">


</head>
<frameset rows="40px,*">
	<frame name="topFrame" src="admin_top.action" scrolling="no" marginwidth="0" marginheight="0" frameborder="0" noresize>
	<frameset cols="220px,*">
		<frame name="menuFrame" src="admin_menu.action" scrolling="no" marginwidth="0" marginheight="0" frameborder="0" noresize>
		<frame name="mainFrame" src="loginadmin_Page.action" frameborder="0">
	</frameset>
</frameset>
</html>
