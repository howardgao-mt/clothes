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
    
    <title>My JSP 'adminregister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.js" ></script>
	<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom.css">
	<script type="text/javascript" src="js/jquery.ui.datepicker-zh-TW.js" charset='big5'></script>
	<script type="text/javascript">
$(document).ready(function(){
	var checkEmail = false;
	var checkName = false;
	var checkPwd = false;
	var checkCell = false;
	var checkAddr = false;
	var doubleCheckPwd = false;
	$("#useremail").blur(function(){
		var email = $(this).val();
		var useremailDiv = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if(email == "") {
			$("#useremailDiv").html("");
			$("#useremailDiv").html("<font color='red'>E-MAIL不得為空.</font>");
			checkEmail = false;
			return null;
		} else if(useremailDiv.test(email)) {
			$.ajax({
			url:"jsonMember_checkEmail.action",//記得查看路徑位址
			type:"post",
			data:{
				email:email
			},
			error:function() {
				$("#msg").html("<font color='red'>系統錯誤!請聯絡系統管理員.</font>");
			},
			success:function(data) {
				if(data.result == "success") {
					$("#useremailDiv").html("");
					$("#useremailDiv").html("<font color='green'>此E-mail可以使用.</font>");
					checkEmail = true;
				}
				if(data.result == "error") {
					$("#useremailDiv").html("");
					$("#useremailDiv").html("<font color='red'>此Email已被使用,請更換一個Email.</font>");
					checkEmail = false;
				}
			}
		});
		} else {
			$("#useremailDiv").html("");
			$("#useremailDiv").html("<font color='red'>E-MAIL格式不正確.</font>");
			checkEmail = false;
		}
	});
	
	$("#username").blur(function(){
		var name = $(this).val();
		if(name == "") {
			$("#usernameDiv").html("");
			$("#usernameDiv").html("<font color='red'>姓名不得為空.</font>");
			checkName = false;
		} else {
			$("#usernameDiv").html("");
			$("#usernameDiv").html("<font color='green'>v</font>");
			checkName = true;
		}
	});
	
	$("#userpassword").blur(function(){
		var pwd = $(this).val();
		var usercheckpassword = $("#usercheckpassword").val();
		var pattern = /([a-zA-Z0-9]).{7,15}$/;
		if(pwd == "") {
			$("#userpasswordDiv").html("");
			$("#userpasswordDiv").html("<font color='red'>密碼不得為空.</font>");
			checkPwd = false;
		} else if(pattern.test(pwd)){
			$("#userpasswordDiv").html("");
			$("#userpasswordDiv").html("<font color='green'>v</font>");
			if(usercheckpassword != "") {
				if(pwd == usercheckpassword) {
					$("#usercheckpasswordDiv").html("");
					$("#usercheckpasswordDiv").html("<font color='green'>兩次密碼輸入正確.</font>");
					doubleCheckPwd = true;
				} else {
					$("#usercheckpasswordDiv").html("");
					$("#usercheckpasswordDiv").html("<font color='red'>兩次密碼輸入不相同.</font>");
					doubleCheckPwd = false;
				}
			}
			checkPwd = true;
		} else {
			$("#userpasswordDiv").html("");
			$("#userpasswordDiv").html("<font color='red'>請輸入8~16位元英文或數字混合的密碼.</font>");
			checkPwd = false;
		}
		
	});
	
	$("#userphone").blur(function(){
		var cell = $(this).val();
		var pattern = /[0]{1}[9]{1}[0-9]{8}$/;
		if(cell == "") {
			$("#userphoneDiv").html("");
			$("#userphoneDiv").html("<font color='red'>電話號碼不得為空.</font>");
			checkCell = false;
		} else if(pattern.test(cell)){
			$("#userphoneDiv").html("");
			$("#userphoneDiv").html("<font color='green'>v</font>");
			checkCell = true;
		} else {
			$("#userphoneDiv").html("");
			$("#userphoneDiv").html("<font color='green'>格式不正確，請填寫正確格式。</font>");
			checkCell = true;
		}
	});
	
	$("#usercheckpassword").blur(function(){
		var usercheckpassword = $(this).val();
		var pwd = $("#userpassword").val();
		var pattern = /^([a-zA-Z0-9]).{7,15}$/;
		if(chkPwd == ""){
			$("#usercheckpasswordDiv").html("");
			$("#usercheckpasswordDiv").html("<font color='red'>密碼不得為空.</font>");
			doubleCheckPwd = false;
		} else if(pattern.test(usercheckpassword)){
			if(pwd == usercheckpassword) {
				$("#usercheckpasswordDiv").html("");
				$("#usercheckpasswordDiv").html("<font color='green'>兩次密碼輸入正確.</font>");
				doubleCheckPwd = true;
			} else {
				$("#usercheckpasswordDiv").html("");
				$("#usercheckpasswordDiv").html("<font color='red'>兩次密碼輸入不相同.</font>");
				doubleCheckPwd = false;
			}
		} else {
			$("#usercheckpasswordDiv").html("");
			$("#usercheckpasswordDiv").html("<font color='red'>請輸入8~16位元英文或數字混合的密碼.</font>");
			doubleCheckPwd = false;
		}
	});
	
	$("#useraddress").blur(function(){
		var addr = $(this).val();
		if(addr == "") {
			$("#useraddressDiv").html("");
			$("#useraddressDiv").html("<font color='red'>地址不得為空.</font>");
			checkAddr = false;
		} else {
			$("#useraddressDiv").html("");
			$("#useraddressDiv").html("<font color='green'>v</font>");
			checkAddr = true;
		}
	});
	
	$("#userid").blur(function(){
		var usercheckid = /[a-zA-Z]{1}[1-2]{1}[0-9]{8}$/;
		var userid = $(this).val();
		if(userid != "") {
			if(usercheckid.test(userid)) {
				$("#useridDiv").html("");
				$("#useridDiv").html("<font color='green'>v</font>");
			} else {
				$("#useridDiv").html("");
				$("#useridDiv").html("<font color='red'>格式錯誤，請填寫正確格式。</font>");
			}
		}
	});
	
	$("#sub").click(function(){
		if(checkEmail && checkName && checkPwd && checkCell && checkAddr && doubleCheckPwd) {
			return true;
		} else {
			return false;
		}
	});
});
</script>

  </head>
  
  <body>
	<div class="main" align="center">
		<br>
		<a href="loginadmin_Page" >回管理頁面</a>
		<br><br>
		<s:form action="register" method="post" theme="simple">
			<br>
			<div><font color="red"><s:property value="message"/></font></div>
			<br>
			<fieldset>
				<legend>會員註冊</legend>
				<table>
					<tr>
						<th>會員帳號: </th>
						<td><s:textfield id="useraccount" name="clothesUser.userAccount"/></td>
						<td><div id="useridDiv">*</div>
					</tr>
					<tr>
						<th>會員姓名: </th>
						<td><s:textfield id="username" name="clothesUser.userName"/></td>
						<td><div id="usernameDiv">*</div>
					</tr>
					<tr>
						<th>密           碼: </th>
						<td><s:password id="userpassword" name="clothesUser.userPassword"/></td>
						<td><div id="userpasswordDiv">*</div>
					</tr>
					<tr>
						<th>再次確認密碼: </th>
						<td><s:password id="usercheckpassword" name="usercheckpassword"/></td>
						<td><div id="usercheckpasswordDiv">*</div>
					</tr>
					<tr>
						<th>電           話: </th>
						<td><s:textfield id="userphone" name="clothesUser.userPhone" /></td>
						<td><div id="userphoneDiv">*</div>
					</tr>
					<tr>
						<th>E-Mail: </th>
						<td><s:textfield id="useremail" name="clothesUser.userEmail" size="50"/></td>
						<td><div id="useremailDiv">*</div>
					</tr>
					<tr>
						<th>地址: </th>
						<td><s:textfield id="useraddress" name="clothesUser.userAddress" size="50"/></td>
						<td><div id="useraddressDiv">*</div>
					</tr>
					<tr>
						<th>性別: </th>
						<td><s:radio id="usersex" name="clothesUser.userSex" list="#{'1':'男生','2':'女生'}" value="clothesUser.userSex"/></td>
					</tr>
					
				</table>	
			</fieldset>
			<br>
			<input type="submit" class="submit_btn" value="會員註冊"/>
	
		</s:form>
	</div>
  </body>
</html>
