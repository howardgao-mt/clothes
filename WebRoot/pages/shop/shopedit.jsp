<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shopedit.jsp' starting page</title>
    
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
		<a href="loginadmin_Page.action" >回管理者介面</a>
		<br><br>
		<s:form action="product_save.action" method="post" theme="simple">
			<br>
			<div><font color="red"><s:property value="message"/></font></div>
			<br>
			<fieldset>
				<legend>商品資料登錄</legend>
				<table>
					<tr>
						<th>商品名稱: </th>
						<td><s:textfield id="productname" name="clothesProduct.productName"/></td>
					</tr>
					<tr>
						<th>商品價錢: </th>
						<td><s:textfield id="productprice" name="clothesProduct.productPrice"/></td>
					</tr>
					<tr>
						<th>商品描述: </th>
						<td><s:textfield id="productdescription" name="clothesProduct.productDescription"/></td>
					</tr>
					<tr>
						<th>類別 ID: </th>
						<td><s:select id="checkid" name="checkid" list="clothesChecks" listKey="checkId" listValue="checkName" /></td>
					</tr>
					<tr>
						<th>商品狀態: </th>
						<td><s:radio id="productstatus" name="clothesProduct.productStatus" list="#{'1':'上架','2':'下架'}" value="2"/></td>
					</tr>
				</table>	
			</fieldset>
			<br>
			<input type="submit" class="submit_btn" value="資料登錄"/>
	
		</s:form>
	</div>
  </body>
</html>
