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
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
	<div id='cssmenu'>
<ul>
   <li class='active'><a href="loginadmin_Page" target="mainFrame"><span>管理員系統</span></a></li>
   <li class='has-sub'><a href="admin_product.action" target="mainFrame"><span>商品詳細一覽</span></a>
<%--       <ul>
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
      </ul> --%>
   </li>
   <li><a href="adminMember_search"  target="mainFrame"><span>管理資料查詢</span></a></li>
   <li><a href="admin_member.action" target="mainFrame"><span>會員資料管理</span></a></li>
   <li><a href="loginadmin_Page" target="mainFrame"><span>商品類別管理</span></a></li>
   <li><a href="admin_Category.action" target="mainFrame"><span>新增商品類別</span></a></li>
   <li><a href="admin_product.action" target="mainFrame"><span>商品資料管理</span></a></li>
   <li><a href="admin_cart.action" target="mainFrame"><span>購物資料管理</span></a></li>
   <li><a href="admin_subscribe.action" target="mainFrame"><span>訂單管理</span></a></li>
   <li><a href="http://www.wretch.cc/blog/momogoing999/25523233" target="mainFrame"><span>說明</span></a></li>
   <li class='last'><a href="back_index.action" target="_parent"><span>登出</span></a></li>
</ul>
</div>
</body>
</html>
