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
    
    <title>My JSP 'adminMembermodification.jsp' starting page</title>
    
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
	<h2>個人資料修改</h2>
	<br><br>
	<div id="msg"><font color="red"><s:property value="success"/></font></div>
	<br>	
	<div>
	</div>
		<a href="Member_passwordchange.action">修改密碼</a>
		<s:form  action="Member_modification.action" theme="simple">
			<table border="1">
				<tr>
					<th>會員帳號:</th>
					<td><s:textfield id="useraccount" name="clothesUser.userAccount" />
					</td>
				</tr>
				<tr>
					<th>會員姓名:</th>
					<td><s:textfield id="username" name="clothesUser.userName"/>
					</td>
				</tr>
				<tr>
					<th>會員密碼:</th>
					<td><s:textfield id="userpassword" name="clothesUser.userPassword" />
					</td>
				</tr>
				<tr>
					<th>電話:</th>
					<td><s:textfield id="userphone" name="clothesUser.userPhone" />
					</td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><s:textfield id="useremail" name="clothesUser.userEmail" size="50" />
					</td>
				</tr>
				<tr>
					<th>地址:</th>
					<td><s:textfield id="useraddress" name="clothesUser.userAddress" size="50" />
					</td>
				</tr>
				<tr>
					<th>性別:</th>
					<td><s:radio id="usersex" name="clothesUser.userSex" list="#{'1':'男生','2':'女生'}" value="clothesUser.userSex"/></td>
				</tr>
		</table>
				<tr>
					<td id="log_td" colspan="2" align="right"><input type="submit" class="submit_btn" value="儲存資料"/></td>

				</tr>
	</s:form>
</div>
  </body>
</html>
