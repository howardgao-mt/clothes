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
    
    <title>My JSP 'adminMembersearch.jsp' starting page</title>
    
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
	<h2>管理者資料檢索</h2>
	<br><br>

	<div id="msg"><font color="red"><s:property value="success"/></font></div>
	<br>	
	<div>
	
	</div>
		<br>
		<a href="loginadmin_Page" >回管理頁面</a>
		<br>
		<s:form theme="simple">
			<table border="1">
				<tr>
					<th>管理者帳號:</th>
					<td><s:property value="clothesUser.userAccount"  />
					</td>
				</tr>
				<tr>
					<th>管理者姓名:</th>
					<td><s:property value="null" />
					</td>
				</tr>
				<tr>
					<th>管理者密碼:</th>
					<td><s:property value="clothesUser.userPassword" />
					</td>
				</tr>
				<tr>
					<th>電話:</th>
					<td><s:property value="null" />
					</td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><s:property value="null" />
					</td>
				</tr>
				<tr>
					<th>地址:</th>
					<td><s:property value="null"/>
					</td>
				</tr>
				<tr>
					<th>性別:</th>
					<td>
						<s:if  test="%{clothesUser.userSex == 1}">男生</s:if> 
						<s:if  test="%{clothesUser.userSex == 2}">女生</s:if>
					</td>
				</tr>
		</table>
	</s:form>
</div>
  </body>
</html>
