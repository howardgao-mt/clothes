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
    
    <title>My JSP 'shopPay.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
$(document).ready(function(){
	$("select").change(function(){
		var value = $(this).val();
		var total = $("#total").text();
		$("#totalship").text(parseInt(value) + parseInt(total));
		$("#totalpayship").val(parseInt(value) + parseInt(total));
		//alert($("#totalpayship").val());
	});
});
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
		<div>
			<h2>訂購明細</h2>
		</div>
		<br>
		<a href="shop_cart.action" >回上一頁</a>
		<br><br>
		<div>
			<font color="red"><s:property value="message" />
			</font>
		</div>
		<s:form action="save_pay" method="post" theme="simple" target="mainFrame">		
		<div>
			<table border="1">
				<tr>
					<th>收件人:</th>
					<td colspan="9"><s:textfield id="subscribename" name="clothesSubscribe.subscribeName" size="44"/>
					</td>
				</tr>
				<tr>
					<th>收件人電話:</th>
					<td colspan="9"><s:textfield id="subscribephone" name="clothesSubscribe.subscribePhone" size="44"/>
					</td>
				</tr>
				<tr>
					<th>收件人地址:</th>
					<td colspan="9"><s:textfield id="subscribeaddress" name="clothesSubscribe.subscribeAddress" size="44"/>
					</td>
				</tr>
				<tr>
					<th>收件E-mail:</th>
					<td colspan="9"><s:textfield id="subscribeemail" name="clothesSubscribe.subscribeEmail" size="44"/>
					</td>
				</tr>
				<tr>
					<th>商品名稱</th>
					<th>單價</th>
					<th>數量</th>
					<th>小計</th>
				</tr>
				<s:iterator value="clothesCartItems">
					<tr>
						<td align="center"><s:property value="clothesProduct.productName" /></td>
						<td align="center"><s:property value="cartItemPrice" /></td>
						<td align="center"><s:property value="cartItemQuantity" /></td>
						<td align="center"><s:property value="cartItemSum" /></td>
					</tr>
				</s:iterator>
				<tr>
					<td align="center">總額:</td>
					<td id="total" colspan="9" align="center" class="style25"><s:property value="totalSum" />
					</td>
				</tr>
				<tr>
					<td align="center">交易方式:</td>
					<td colspan="9"align="center"><s:radio id="paybank" name="clothesPay.payBank" list="#{'1':'線上ATM','2':'信用卡轉帳'}" value="2"/></td>
				</tr>
				<tr>
					<td>運送方式:</td>					
					<td >
						<select id="paytransport" name="clothesPay.payTransport" >
							<option value="20">郵局寄送</option>
							<option value="70">超商取貨</option>
							<option value="130">貨到付款</option>
						</select>
					<td class="style25">信用卡卡號:</td>
					<td colspan="9"><s:textfield id="paystatus" name="clothesPay.payStatus" size="12"/>
<%-- 					<select id="bank">
							<option value="0">請選擇銀行</option>
							<option value="0">中央銀行</option>
							<option value="0">臺灣銀行</option>
							<option value="0">高雄銀行</option>
					</select>
					<select id="placebank">
							<option value="0">請選擇分行</option>
							<option value="0">台北分行</option>
							<option value="0">花蓮分行</option>
							<option value="0">高雄分行</option>
					</select> --%>
					</td>						
				</tr>

				<tr>
					<td align="center">總消費金額:</td>
					<td id="totalship" align="center" colspan="9" class="style25"></td>
					<s:hidden id="totalpayship" name="totalpayship"/>
				</tr>
				<tr>
					<td id="log_td" colspan="9" align="center"><input type="submit" class="submit_btn" value="提交" /></td>
				</tr>	
			</table>
		</div>
		</s:form>
		
	</div>
  </body>
</html>
