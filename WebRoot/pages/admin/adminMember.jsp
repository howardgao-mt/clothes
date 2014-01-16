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
    
    <title>My JSP 'adminMember.jsp' starting page</title>
    
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
		<br>
		<a href="admin_register.action" >新會員登錄</a>
		<br>
		<div>
		<div align="center">
		<h2>會員資料管理</h2>
	</div>
		<s:form theme="simple">
			<fieldset>
				<legend>會員資料管理</legend>
				<br>
					<font color="red"><s:property value="message"/></font>
				<br>
				<table border="1">
					<tr>
						<th>會員帳號</th>
						<th>會員名稱</th>
						<th>會員密碼</th>
						<th>電話</th>
						<th>E-mail</th>
						<th>地址</th>
						<th>性別</th>
						<th>資料修改</th>
						<th>資料刪除</th>
					</tr>
					<s:iterator value="clothesUsers">
						<tr>
							<td align="center"><s:property value="userAccount" /></td>
							<td align="center"><s:property value="userName" /></td>
						    <td align="center"><s:property value="userPassword" /></td>
						    <td align="center"><s:property value="userPhone" /></td>
						    <td align="center"><s:property value="userEmail" /></td>
						    <td align="center"><s:property value="userAddress" /></td>
						    <td align="center">
						    <s:if  test="%{userSex == 1}">男生</s:if> 
							<s:if  test="%{userSex == 2}">女生</s:if>
							</td>
							<td>&nbsp;&nbsp;
								<a href="Member_datachange.action?userId=<s:property value="userId"/>" target="mainFrame">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td>&nbsp;&nbsp;
								<a href="user_delete.action?userId=<s:property value="userId"/>" target="mainFrame" onclick="return confirm_delete()">刪除</a>&nbsp;&nbsp;
							</td>
						</tr>
					</s:iterator>
				</table>
			</fieldset>
	</s:form>
</div>
  </body>
</html>
