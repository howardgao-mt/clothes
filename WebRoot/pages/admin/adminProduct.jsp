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
    
    <title>My JSP 'adminProduct.jsp' starting page</title>
    
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
		<a href="shop_edit.action" >新商品登錄</a>
		<br>
		<div>
		<div align="center">
		<h2>商品管理</h2>
	</div>
		<s:form theme="simple">
			<fieldset>
				<legend>商品管理</legend>
				<br>
					<font color="red"><s:property value="message"/></font>
				<br>
				<table border="1">
					<tr>
						<th>商品名稱</th>
						<th>商品價錢</th>
						<th>商品描述</th>
						<th>商品類別</th>
						<th>庫存數量</th>
						<th>上/下架</th>
						<th>商品修改</th>
						<th>商品刪除</th>
					</tr>
					<s:iterator value="clothesProducts">
						<tr>
							<td align="center"><s:property value="productName" /></td>
							<td align="center"><s:property value="productPrice" /></td>
						    <td align="center"><s:property value="productDescription" /></td>
						    <td align="center"><s:property value="clothesCheck.checkName" /></td>
						    <td align="center"><s:property value="100" /></td>
						    <td align="center">
							<s:if  test="%{productStatus == 1}">上架</s:if> 
							<s:if  test="%{productStatus == 2}">下架</s:if>
						    </td>
							<td>&nbsp;&nbsp;
								<a href="changeproduct_edit.action?productId=<s:property value="productId"/>" target="mainFrame">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td>&nbsp;&nbsp;
								<a href="product_delete.action?productId=<s:property value="productId"/>" target="mainFrame" onclick="return confirm_delete()">刪除</a>&nbsp;&nbsp;
							</td>
						</tr>
					</s:iterator>
				</table>
			</fieldset>
	</s:form>
</div>
  </body>
</html>
