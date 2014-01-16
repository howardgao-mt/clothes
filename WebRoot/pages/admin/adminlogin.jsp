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
    
    <title>歡迎光臨購物商城</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!--追蹤程式碼:https://www.google.com/analytics/web/?et&authuser=0#management/Settings/a46795775w77911274p80552258/%3Fm.page%3DTrackingCode/-->
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-46795775-1', 'metrics.com.tw');
  ga('send', 'pageview');

</script>	
<script type="text/javascript">

function confirm_delete() {

return confirm('確定進行刪除資料?');

}

</script>


  </head>
  
  <body>
		<div class="shop" align="center">
		<tr>
			<th>歡迎回來!    管理者    先生/女士</th>
		</tr>
<!-- 		<br>
		<a href="adminMember_search" >管理者資料查詢</a>
		
		<a href="admin_Category.action">新增商品類別</a>		
		<br>
		<br>
		<a href="back_index.action" >登出</a>
		<br>
		<br>
		<a href="admin_product.action" >商品管理</a>
		<br>
		<br>
		<a href="admin_member.action" >會員管理</a>
		<br>
		<br>
		<a href="admin_cart.action" >購物車管理</a>
		<br>
		<br>
		<a href="admin_subscribe.action" >訂購管理</a>
		<br> -->
		<div>
		<div align="center">
		<h2>商品類別管理</h2>
	</div>
		<s:form theme="simple">
			<fieldset>
				<legend>類別管理</legend>
				<br>
					<font color="red"><s:property value="message"/></font>
				<br>
				<table border="1">
					<tr>
						<th>類別名稱</th>
						<th>上/下架登錄</th>
						<th>類別修訂</th>
						<th>刪除類別</th>
					</tr>
					<s:iterator value="clothesChecks">
						<tr>
							<td align="center"><s:property value="checkName" /></td>
							<td align="center">
							<s:if  test="%{checkStatus == 1}">上架</s:if> 
							<s:if  test="%{checkStatus == 2}">下架</s:if>
							</td>
							<td>&nbsp;&nbsp;
								<a href="change_edit.action?checkId=<s:property value="checkId"/>" target="mainFrame">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td>&nbsp;&nbsp;
								<a href="category_delete.action?checkId=<s:property value="checkId"/>" target="mainFrame" onclick="return confirm_delete()" 
								>刪除</a>&nbsp;&nbsp;
							</td>
						</tr>
					</s:iterator>
				</table>
			</fieldset>
	</s:form>
</div>
  </body>
</html>
