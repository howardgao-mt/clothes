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
    
    <title>My JSP 'adminProductedit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript">
$(document).ready(function(){
	$(".css_add_btn").click(function() {
		$.ajax({
			url : 'jsonBasket_add.action',
			type : 'post',
			data : {
				productId : $(this).attr("id"),
				quantity: 1
			},
			dataType : 'json',
			error : function() {
				$("#msg").html("<font color='red'>error!</font>");
			},
			success : function(data) {
				$("#msg").html("<font color='red'>" + data.value + "</font>");
			}
		});
	});
});
</script> 
  </head>

  <body>
<div align="center">
	<h2>類別資料修改</h2>
	<br><br>
	<div id="msg"><font color="red"><s:property value="success"/></font></div>
	<br>	
	<div>
	</div>
		<a href="loginadmin_Page.action">回上一頁</a>
		<s:form  action="product_edit.action" theme="simple">
			<table border="1">
				<tr>
					<th>商品名稱:</th>
					<td><s:textfield id="productname" name="clothesProduct.productName" />
					</td>
				</tr>
				<tr>
					<th>商品價錢:</th>
					<td><s:textfield id="productprice" name="clothesProduct.productPrice" />
				</tr>
				<tr>
					<th>商品描述:</th>
					<td><s:textfield id="productdescription" name="clothesProduct.productDescription" />
				</tr>
				<tr>
					<th>商品庫存:</th>
					<td><s:textfield id="productprice" name="clothesProduct.productPrice" />
				</tr>
				<tr>
					<th>類別名稱:</th>
				<td><s:select id="checkid" name="checkid" list="clothesChecks" listKey="checkId" listValue="checkName" /></td>	
				</tr>
				<tr>
					<th>上下架狀態:</th>
					<td><s:radio id="productstatus" name="clothesProduct.productStatus" list="#{'1':'上架','2':'下架'}" value="clothesProduct.productStatus"/></td>
					
				</tr>
		</table>
				<tr>
					<td id="log_td" colspan="2" align="right"><s:submit cssClass="css_add_btn" type="submit"  value="修改商品資料"/></td>

				</tr>
	</s:form>
</div>
  </body>
</html>
