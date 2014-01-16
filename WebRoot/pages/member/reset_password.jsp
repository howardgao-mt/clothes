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
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div align="center">
		<br><br>
		<h2>填寫您的E-MAIL重置密碼</h2>
		<br>
		<div id="msg"><font color="red"><s:property value="message"/></font></div>
		<br>
		<s:form action="user_resetPwd" method="post" theme="simple">
		<s:token name="tokenSession"/>
			<table>
				<tr>
					<td>E-Mail 帳號:</td>
					<td><s:textfield name="userEmail"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><s:submit value="送出"/></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>
