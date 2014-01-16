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
    
    <title>My JSP 'shopPayCheck.jsp' starting page</title>
    
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
<div align="center">
	<div><h2>確認訂單</h2></div>
	<div><font color="red"><s:property value="message"/></font></div>
	<div>
		<s:form action="save_paycheck" method="post" theme="simple" target="mainFrame">
		<s:token name="tokenSession">
			<table border="1">
				<tr>
					<td colspan="7" align="center"><a href="shop_pay.action">上一步</a></td>
				</tr>
				<tr>
					<td align="center">會員帳號:</td>
					<td colspan="6" align="center"><s:property value="clothesUser.userAccount"/></td>
				</tr>
				<tr>
					<td align="center">會員姓名: </td>
					<td colspan="6" align="center"><s:property value="clothesUser.userName"/></td>
				</tr>
				<tr>
					<td align="center">收件人: </td>
					<td colspan="6" align="center"><s:property value="clothesSubscribe.subscribeName"/></td>
				</tr>
				<tr>
					<td align="center">收件電話: </td>
					<td colspan="6" align="center"><s:property value="clothesSubscribe.subscribePhone"/></td>
				</tr>
				<tr>
					<td align="center">收件地址: </td>
					<td colspan="6" align="center"><s:property value="clothesSubscribe.subscribeAddress"/></td>
				</tr>
				<tr>
					<td align="center">收件e-mail: </td>
					<td colspan="6" align="center"><s:property value="clothesSubscribe.subscribeEmail"/></td>
				</tr>
				<tr>
					<td align="center">總額: </td>
					<td colspan="6" align="center" class="style25"><s:property value="totalSum"/></td>
				</tr>
				<tr>
					<td align="center" >交易方式: </td>
					<td align="center" colspan="6" class="style29">
						<s:if  test="%{clothesPay.payBank == 1}">線上ATM</s:if> 
						<s:if  test="%{clothesPay.payBank == 2}">信用卡轉帳</s:if>
					</td>
				</tr>
				<tr>
					<td align="center" >信用卡卡號: </td>
					<td colspan="6" class="style25" align="center"><s:property value="clothesPay.payStatus"/></td>
				</tr>
				<tr>
					<td align="center" >運送方式: </td>
					<td  align="center" colspan="6" class="style29">
						<s:if  test="%{clothesPay.payTransport == 20}">郵局寄送</s:if> 
						<s:if  test="%{clothesPay.payTransport == 70}">超商取貨</s:if>
						<s:if  test="%{clothesPay.payTransport == 130}">貨到付款</s:if> 
					</td>
				</tr>
				<tr>
					<td align="center" align="center">總消費金額: </td>
					<td colspan="6" align="center" class="style25"><s:property value="totalpayship"/></td>
				</tr>
				<tr>
					<th>商品名稱</th>
					<th>單價</th>
					<th>數量</th>
					<th>小計</th>
				</tr>
				<s:iterator value="clothesCartItems">
					<tr>
						<td align="center">
							<s:property value="clothesProduct.productName"/>
						</td>
						<td align="center">
							<s:property value="cartItemPrice"/>
						</td>
						<td align="center">
							<s:property value="cartItemQuantity"/>
						</td>
						<td align="center">
							<s:property value="cartItemSum"/>
						</td>

					</tr>
				</s:iterator>
				<tr>
					<td colspan="7" align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:submit value="送出訂單"/></td>
				</tr>
			</table>
			</s:token>
		</s:form>
	</div>
</div>
  </body>
</html>
