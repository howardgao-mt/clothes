<%@ page language="java" import="java.util.*" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>歡迎光臨購物商城</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="button.css">

  </head>
  
  <body>
	<div class="log" align="right">
	<div class="log_header" align="center">歡迎光臨購物系統</div>
	<div align="center" class="log_form">
		<s:form action="login" method="post" theme="simple" name="insImg">
			<table>
				<tr>
					<td id="log_td">會員帳號:</td>
					<td id="log_td"><s:textfield id="useraccount" name="clothesUser.userAccount" /></td>
				</tr>
				<tr>
					<td id="log_td">會員密碼:</td>
					<td id="log_td"><s:password id="userpassword" name="clothesUser.userPassword" /></td>
				</tr>
				<tr>
					<td id="log_td" colspan="2" align="center"><input type="submit" class="123" value="登入"/></td>
				</tr>			
			</table>
		</s:form>
	</div>
	<div align="center">
	<s:a href="reg_test.action">會員註冊</s:a> 
	<s:a href="user_reset.action">忘記密碼</s:a>
	<a href="newlogin">管理者登入</a>
	</div> 
	<div class="log_msg"  align="center"><font color="red"><s:property value="message"/></font></div>
	</div>

  </body>
  
</html>
