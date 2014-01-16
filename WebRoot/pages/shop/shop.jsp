<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-46795775-1', 'metrics.com.tw');
  ga('send', 'pageview');

</script>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shop.jsp' starting page</title>
    
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
	<div class="log_header" align="center">歡迎光臨購物商城</div>
	<div class="log_header" align="center">商品總類超多，任君選購!!</div>
		<div class="shop" align="center">
		<tr>
			<th>歡迎回來 </th>
			<td><s:property value="clothesUser.userName" /></td>
			<th> 先生/女士 </th>
		</tr>
		<div>
			<div align="center">
		<h2>商品類別</h2>
		<fieldset>
				<legend>商品類別</legend>
		<table border="1">
					<s:iterator value="clothesChecks">
						<tr>
							<td align="center">&nbsp;&nbsp;
								<a  href="shop_product.action?checkId=<s:property value="checkId"/>" target="mainFrame"><s:property  value="checkName"  /></a>&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</s:iterator>				
	    </table>
		</fieldset>	
		
			<font color="red"><s:property value="message"/></font>
		<br>
  </body>
</html>
