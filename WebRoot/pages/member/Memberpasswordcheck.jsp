<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Memberpasswordcheck.jsp' starting page</title>
    
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
	<h2>會員密碼修改</h2>
	<br><br>
	<div id="msg"><font color="red"><s:property value="success"/></font></div>
	<br>	
	<div>
	</div>
		<s:form action="Member_passwordcheck.action" theme="simple">
			<table border="1">
				<tr>
					<th>原會員密碼:</th>
					<td><s:password id="oldPassword" name="oldPassword"/>
					</td>
				</tr>
				<tr>
					<th>新密碼設定:</th>
					<td><s:password id="newPassword" name="newPassword"/>
					</td>
				</tr>
				<tr>
					<th>新密碼確認:</th>
					<td><s:password id="checkPassword" name="checkPassword"/>
					</td>
				</tr>
		</table>
				<tr>
					<td id="log_td" colspan="2" align="right"><input type="submit" class="submit_btn" value="確認修改"/></td>

				</tr>
	</s:form>
</div>
  </body>
</html>
