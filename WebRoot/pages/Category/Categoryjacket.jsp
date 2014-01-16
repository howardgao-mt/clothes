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
    
    <title>My JSP 'Categoryjacket.jsp' starting page</title>
    
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
	<h2>上衣資料查詢</h2>
	<br><br>
	<a href="back_index.action" >回首頁</a>
	<div id="msg"><font color="red"><s:property value="success"/></font></div>
	<br>	
	<div>
	
	</div>
		<s:form theme="simple">
			<fieldset>
				<legend>上衣列表</legend>
				<br>
					<font color="red"><s:property value="message"/></font>
				<br>
				<table border="1">
					<tr>
						<th>商品名稱</th>
						<th>商品價錢</th>
						<th>商品描述</th>
					</tr>
					<s:iterator value="clothesProducts">
						<tr>
							<td align="center"><s:property value="productName" /></td>
							<td align="center"><s:property value="productPrice" /></td>
							<td align="center"><s:property value="productDescription" /></td>
						</tr>
					</s:iterator>
				</table>
			</fieldset>
	</s:form>
</div>
   </body>
</html>
