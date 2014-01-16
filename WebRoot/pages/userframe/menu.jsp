<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/style2.css">


</head>
<body>
<div id='cssmenu'>
<ul>
   <li><a href="login_Shop" target="mainFrame"><span>首頁</span></a></li>
   	<li><a href="Member_search.action" target="mainFrame"><span>我的基本資料</span></a></li>
  	<li><a href="login_Shop" target="mainFrame"><span>商品</span></a></li>
  	<li class='active'>
  		<s:iterator value="clothesChecks">
			<a href="shop_product.action?checkId=<s:property value="checkId"/>" target="mainFrame">
				<span>
					<s:property value="checkName"/>
				</span>
			</a>
		</s:iterator>
	</li>	
  	<li><a href="shop_cart.action" target="mainFrame"><span>我的購物車</span></a></li>
   	<li><a href="http://www.wretch.cc/blog/momogoing999/25523233" target="mainFrame"><span>關於</span></a></li>
	<li><a href="https://maps.google.com.tw/maps/ms?ie=UTF8&amp;brcurrent=3,0x3414a4f246c5a319:0x6c15f5b773824977,1,0x346b306390d98b9d:0xd23521cb169ab683&amp;oe=UTF8&amp;msa=0&amp;msid=202532940513371311847.00048e109523d36832e0f&amp;t=m&amp;z=13&amp;output=embed" target="mainFrame"><span>購物地址</span></a></li>
  	<li><a href="back_index.action" target="_parent"><span>登出</span></a></li>
</ul>
</div>
<%-- <div id='cssmenu'>
<ul>
   <li class='active' ><a href='index.html'><span>首頁</span></a></li>
   <li class='has-sub'><a href='#'><span>商品</span></a>
      <ul>
         <li class='has-sub'><a href='#'><span>Product 1</span></a>
            <ul>
               <li><a href='#'><span>Sub Item</span></a></li>
               <li class='last'><a href='#'><span>Sub Item</span></a></li>
            </ul>
         </li>
         <li class='has-sub'><a href='#'><span>Product 2</span></a>
            <ul>
               <li><a href='#'><span>Sub Item</span></a></li>
               <li class='last'><a href='#'><span>Sub Item</span></a></li>
            </ul>
         </li>
      </ul>
   </li>
   <li><a href='#'><span>關於</span></a></li>
   <li><a href="https://maps.google.com.tw/maps/ms?ie=UTF8&amp;brcurrent=3,0x3414a4f246c5a319:0x6c15f5b773824977,1,0x346b306390d98b9d:0xd23521cb169ab683&amp;oe=UTF8&amp;msa=0&amp;msid=202532940513371311847.00048e109523d36832e0f&amp;t=m&amp;z=13&amp;output=embed" target="mainFrame"><span>購物地址</span></a></li>
   <li class='last'><a href='#'><span>Contact</span></a></li>
</ul>
</div> --%>
</body>
</html>
