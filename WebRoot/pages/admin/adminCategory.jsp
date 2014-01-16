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
    
    <title>My JSP 'adminCategory.jsp' starting page</title>
    
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
  	<div class="main" align="center">
		<br>
		<a href="loginadmin_Page.action" >回上一頁</a>
		<br><br>
		<s:form action="save_Category.action" method="post" theme="simple">
			<br>
			<div><font color="red"><s:property value="message"/></font></div>
			<br>
			<fieldset>
				<legend>類別資料登錄</legend>
				<table>
					<tr>
						<th>類別名稱: </th>
						<td><s:textfield id="checkname" name="clothesCheck.checkName"/></td>
					</tr>
					<tr>
						<th>類別狀態: </th>
						<td><s:radio id="checkstatus" name="clothesCheck.checkStatus" list="#{'1':'上架','2':'下架'}" value="2"/></td>
					</tr>
				</table>	
			</fieldset>
			<br>
			<input type="submit" class="submit_btn" value="類別新增"/>
		</s:form>
	</div>
  </body>
</html>
