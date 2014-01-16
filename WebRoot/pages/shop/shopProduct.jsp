<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shopProduct.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	
<script type="text/javascript">
$(document).ready(function(){
	$(".css_add_btn").click(function() {
	var quantity = $("#qty"+$(this).attr("id")).val();
		$.ajax({
			url : 'jsonCart_add.action',
			type : 'post',
			data : {
				productId : $(this).attr("id"),
				quantity: quantity
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
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-46795775-1', 'metrics.com.tw');
  ga('send', 'pageview');

</script>
  </head>
  
  <body>
	<div class="log_header" align="center">歡迎光臨購物商城</div>
	<div class="log_header" align="center">商品總類超多，任君選購!!</div>
		<div class="shop" align="center">
		<tr>
			<th>歡迎回來 </th>
			<td><s:property value="clothesUser.userName" /></td>
			<th> 先生/女士 </th>
		</tr>
		</div>
			<div align="center">
		<h2>商品種類</h2>
	<s:form theme="simple">
		<fieldset>
				<legend>商品種類</legend>
				<table border="1">
					<tr>
						<th>商品名稱</th>
						<th>商品價錢</th>
						<th>商品描述</th>
						<th>商品數量</th>
						<th>商品庫存</th>
						<th>商品選擇</th>
					</tr>
					<s:iterator value="clothesProducts">
						<tr>
							<td align="center">&nbsp;&nbsp;
							<a  href="user_product.action?productId=<s:property value="productId"/>" target="mainFrame"><s:property  value="productName"  /></a>&nbsp;&nbsp;&nbsp;&nbsp;
							<%-- <s:property value="productName" /> --%>
							</td>
							<td align="center"><s:property value="productPrice" /></td>
						    <td align="center"><s:property value="productDescription" /></td>
						    <td align="center" ><s:textfield style="text-align:right;" value="0" size="1" id="qty%{productId}"/></td>
						    <td align="center"><s:property value="100" /></td>
							<td>&nbsp;&nbsp;
								<div class="css_add_btn" id='<s:property value="productId"/>'>購買</div>&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</s:iterator>
				</table>
			</fieldset>
	</s:form>
</div>
  </body>
</html>
