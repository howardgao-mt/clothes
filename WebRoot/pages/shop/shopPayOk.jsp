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
    
    <title>My JSP 'shopPayOk.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
</script>
<style type="text/css">
.style26 {
				text-align: center;
}
.style24 {
				text-decoration: none;
}
.style25 {
				color: #EA0000;
}
.style27 {
				font-family: 標楷體;
				text-align: center;
				color: #FFFFFF;
}
.style29 {
				border-width: 0;
}
</style>
  </head>
  
  <body>
<div align="center">
	<div><h2>交易成功</h2></div>
	<div><font color="red"><s:property value="message"/></font></div>
	<div>
		<s:form action="save_paycheck" method="post" theme="simple" target="mainFrame">
		<s:token name="tokenSession">
			<table border="1">
				<tr>
					<td colspan="7" align="center"><a href="login_Shop.action">繼續購物去</a></td>
				</tr>
				<tr>
					<td colspan="7" align="center"><a href="login_Page.action">登出</a></td>
				</tr>
			</table>
			</s:token>
		</s:form>
	</div>
</div>
  </body>
</html>
