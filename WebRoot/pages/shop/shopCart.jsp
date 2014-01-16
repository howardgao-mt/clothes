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
    
    <title>My JSP 'shopCart.jsp' starting page</title>
    
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
				font-family: 等寬字體;
				color: #EA0000;
}
.style27 {
				font-family: 標楷體;
				color: #3300FF;
}
.style29 {
				font-family: 等寬字體;
				color: #3300FF;
}
</style>

  </head>
  
  <body>
  
  <body>
	<div class="log_header" align="center">歡迎光臨購物商城</div>
	<div class="log_header" align="center">商品總類超多，任君選購!!</div>
		<div class="shop" align="center">
		</div>
			<div align="center">
		<h2>我的購物車</h2>
	<s:form theme="simple">
		<fieldset>
				<legend>購買商品種類</legend>
				<table border="1">
					<tr>
						<th>商品名稱</th>
						<th>商品描述</th>
						<th>商品價錢</th>
						<th>商品數量</th>
						<th>商品總金額</th>
						<th>商品取消</th>
					</tr>
					<s:iterator value="clothesCartItems">
						<tr>
							<td align="center"><s:property value="clothesProduct.productName" /></td>
							<td align="center"><s:property value="clothesProduct.productDescription" /></td>
						    <td align="center"><s:property value="cartItemPrice" /></td>
						    <td align="center"><s:property value="cartItemQuantity"/></td>
							<td align="center"><s:property value="cartItemSum" /></td>						
							<td>&nbsp;&nbsp;
								<s:a cssClass="css_add_btn" href="cart_delete.action?cartItemId=%{cartItemId}">刪除</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</s:iterator>
				<tr>
					<td colspan="2">合計 <s:property value="totalSum"/></td>
					<td >						
					<a class="style25"  href="shop_pay.action" target="mainFrame">前往付款</a>
<%-- 						<s:if test="%{checkBasket == 0}">

						</s:if> --%>
					</td>
				</tr>
				</table>
			</fieldset>
	</s:form>
</div>
  </body>
</html>
