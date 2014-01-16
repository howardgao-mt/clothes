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
    
    <title>My JSP 'adminedit.jsp' starting page</title>
    
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
	<h2>類別資料修改</h2>
	<br><br>
	<div id="msg"><font color="red"><s:property value="success"/></font></div>
	<br>	
	<div>
	</div>
		<a href="loginadmin_Page.action">回上一頁</a>
		<s:form  action="category_edit.action" theme="simple">
			<table border="1">
				<tr>
					<th>類別名稱:</th>
					<td><s:textfield id="checkname" name="clothesCheck.checkName" />
					</td>
				</tr>
				<tr>
					<th>上下架狀態:</th>
					<td><s:radio id="checkstatus" name="clothesCheck.checkStatus" list="#{'1':'上架','2':'下架'}" value="clothesCheck.checkStatus"/></td>
					
				</tr>
		</table>
				<tr>
					<td id="log_td" colspan="2" align="right"><input type="submit" class="submit_btn" value="儲存類別資料"/></td>

				</tr>
	</s:form>
</div>
  </body>
</html>
