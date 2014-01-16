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
    
    <title>My JSP 'adminCart.jsp' starting page</title>
    
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
		<h2>購物車管理</h2>
	</div>
		<s:form theme="simple">
			<fieldset>
				<legend>購物車管理</legend>
				<br>
					<font color="red"><s:property value="message"/></font>
				<br>
				<table border="1">
					<tr>
						<th>訂單編號</th>
						<th>會員編號</th>
						<th>會員帳號</th>
						<th>訂單狀態</th>
						<th>購物車刪除</th>
					</tr>
					<s:iterator value="clothesCarts">
						<tr>
							<td align="center"><s:property value="cartId" /></td>
							<td align="center"><s:property value="clothesUser.userId" /></td>
						    <td align="center"><s:property value="clothesUser.userAccount" /></td>
						    <td align="center">
							<s:if  test="%{cartStatus == 0}">未成立</s:if> 
							<s:if  test="%{cartStatus == 1}">已成立</s:if>
						    </td>
							<td align="center">&nbsp;&nbsp;
							<a href="delete_cart.action?cartId=<s:property value="cartId"/>" target="mainFrame"onclick="return confirm_delete()">刪除</a>&nbsp;&nbsp;
							</td>
						</tr>
					</s:iterator>
				</table>
			</fieldset>
	</s:form>
</div>
  </body>
</html>
