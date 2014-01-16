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
    
    <title>My JSP 'adminSubscribe.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">

function confirm_delete() {

return confirm('確定進行刪除資料?');

}

</script>

  </head>
  
  <body>
		<div class="shop" align="center">
        <br>
        <br>
		<tr>
			<th>歡迎回來!    管理者    先生/女士</th>
		</tr>
		<br>
		<a href="loginadmin_Page.action" >回上一頁</a>
		<br>
		<div>
		<div align="center">
		<h2>訂單管理</h2>
	</div>
		<s:form theme="simple">
			<fieldset>
				<legend>訂單管理</legend>
				<br>
					<font color="red"><s:property value="message"/></font>
				<br>
				<table border="1">
					<tr>
						<th>訂單編號</th>
						<th>會員編號</th>
						<th>收件人姓名</th>
						<th>收件人狀態</th>
						<th>收件人地址</th>
						<th>收件人電話</th>
						<th>收件人信箱</th>
						<th>訂單刪除</th>
					</tr>
					<s:iterator value="clothesSubscribes">
						<tr>
							<td align="center"><s:property value="subscribeId" /></td>
							<td align="center"><s:property value="clothesUser.userId" /></td>
							<td align="center"><s:property value="subscribeName" /></td>
							<td align="center"><s:property value="subscribeStatus" /></td>
							<td align="center"><s:property value="subscribeAddress" /></td>
							<td align="center"><s:property value="subscribePhone" /></td>
							<td align="center"><s:property value="subscribeEmail" /></td>
							<td align="center">&nbsp;&nbsp;
							<a href="detlete_subscribe.action?subscribeId=<s:property value="subscribeId"/>" target="mainFrame"onclick="return confirm_delete()">刪除</a>&nbsp;&nbsp;
							</td>
						</tr>
					</s:iterator>
				</table>
			</fieldset>
	</s:form>
</div>
  </body>
</html>
