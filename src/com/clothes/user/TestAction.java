package com.clothes.user;

import java.util.List;

import javax.xml.registry.infomodel.User;

import org.apache.struts2.ServletActionContext;

import com.clothes.action.BaseActionSupport;
import com.clothes.model.ClothesCheck;
import com.clothes.model.ClothesProduct;
import com.clothes.model.ClothesUser;
import com.clothes.service.ClothesCartItemService;
import com.clothes.service.ClothesCartService;
import com.clothes.service.ClothesCheckService;
import com.clothes.service.ClothesPayService;
import com.clothes.service.ClothesProductService;
import com.clothes.service.ClothesSubscribeItemService;
import com.clothes.service.ClothesSubscribeService;
import com.clothes.service.ClothesUserService;
import com.clothes.util.MailUtil;
import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;

public class TestAction extends BaseActionSupport {
	/**
	 * 
	 */
	// 訊息傳送
	private ClothesCheckService clothesCheckService;
	private ClothesProductService clothesProductService;
	private ClothesUserService clothesUserService;
	private ClothesCartItemService clothesCartItemService;
	private ClothesCartService clothesCartService;
	private ClothesPayService clothesPayService;
	private ClothesSubscribeService clothesSubscribeService;
	private ClothesSubscribeItemService clothesSubscribeItemService;
	// 訊息傳送
	
	// 個人資料記錄
	private String message;
	private String useraccount;
	private String username;
	private String userpassword;
	private String usercheckpassword;
	private String useraddress;
	private String useremail;
	private String usersex;
	private String checkPassword;// 檢查密碼
	private String oldPassword;// 舊密碼核對
	private String newPassword;// 新密碼

// 電話
	private String firstNumber;
	private String userphone;
// 電話
	private ClothesUser clothesUser;
	private List<ClothesUser> clothesUsers;
	private List<ClothesCheck> clothesChecks;
	private ClothesProduct clothesProduct;
	private List<ClothesProduct> clothesProducts;
	private ClothesCheck clothesCheck;
	
	private int checkId;
	private int userId;
	private int productId;
	
	//test valid code
	private String rand;
	private String input;
	
	public String testValid() throws Exception{
		initServlet();
		rand = (String) ServletActionContext.getRequest().getSession().getAttribute("rand");
		input = ServletActionContext.getRequest().getParameter("insrand");
		if(rand.equals(input)){
			message = "輸入相同，認證成功！";
			}else {
			message = "輸入不同，認證失敗！";
			}
		return "testValid";
	}
	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	//end test valid code



// 個人資料記錄
// 超連結-會員註冊
	public String main() {
		System.out.println("start main..");
//讓欄位變成空的欄位	
		if(clothesUser != null) clothesUser = null;
		return "register";
//讓欄位變成空的欄位	
	}

// 超連結-管理者裡的會員註冊
		public String adminregister() {
			System.out.println("start adminregister..");
			if(clothesUser != null) clothesUser = null;
			return "adminregister";
		}	

// 超連結-回首頁
	public String back() {
		System.out.println("start back..");
		return "index";
	}

// 超連結-回首頁
	public String registersuccess() {
		System.out.println("start registersuccess..");
		return "index";
	}

// 超連結-註冊失敗畫面
	public String registererror() {
		System.out.println("start registererror..");
		return "register";
	}
	public String Membermodification() {
		System.out.println("start Memberpasswordcheck..");
		return "Memberpasswordcheck";
	}
// 超連結-跳到adminMember
	public String jumpadminMember() throws Exception {
		clothesUsers = clothesUserService.getAllClothesUser();
		System.out.println("start jumpadminMember..");
		return "adminMember";
	}
// 超連結-跳到shopProduct
//類別跟商品的對應關係
	public String jumpshopProduct() throws Exception {
	initServlet();
	try{
		clothesCheck = clothesCheckService.getClothesCheckById(checkId);		
 		clothesProducts = clothesProductService.getAllClothesProduct(clothesCheck, 1);
		System.out.println("start jumpshopProduct..");
		resultPage = "shopProduct";
	} catch(Exception e) {
		e.printStackTrace();
	}
	return resultPage;
	}
// 超連結-從商品列表 ->商品詳細頁
	public String jumpuserProduct() throws Exception {
	initServlet();
	try{
		clothesProduct = clothesProductService.getClothesProductById(productId);//抓取對應到的ID
		clothesProducts = clothesProductService.getAllClothesProduct(clothesCheck, 1);
		System.out.println("start jumpuserProduct");
		resultPage = "userProduct";
	}catch(Exception e) {
		e.printStackTrace();
	}
		return resultPage;
	}
	
public String loginPage(){
	return "LoginPage";
}
public String loginadminPage(){
	clothesUser = clothesUserService.getClothesUserByAccount(sessionAdminAccount());
	clothesChecks = clothesCheckService.getAllClothesCheck();
	clothesUsers = clothesUserService.getAllClothesUser();
	return "LoginadminPage";
}
	
// 驗證帳密是否正確
	public String login() {
		initServlet();
		ClothesUser userlogin = clothesUserService.getClothesUserByAccount(clothesUser.getUserAccount());
		if (userlogin != null) {
			if ("admin".equals(userlogin.getUserPassword()) && userlogin.getUserPassword().equals(clothesUser.getUserPassword())){
				System.out.println("start admin..");
				session.setAttribute("adminlogin", userlogin.getUserAccount());
				clothesChecks = clothesCheckService.getAllClothesCheck();
				clothesUsers = clothesUserService.getAllClothesUser();
				message = "管理者登入";
				resultPage = "adminLogin";
			} else if (userlogin.getUserPassword().equals(clothesUser.getUserPassword())) {
				System.out.println("start shop..");
				//要注意為integer/String	
				session.setAttribute("userlogin", userlogin.getUserAccount());
				//要注意為integer/String	
				if ("1".equals(String.valueOf(userlogin.getUserStatus()))){
				clothesUser = userlogin;
				//類別顯示上架狀態
				clothesChecks = clothesCheckService.getAllClothesCheck(1);
				message = "登入成功";
				resultPage =  "shop";
				} else {
					resultPage = "error";
					message = "登入失敗，請驗證信箱，謝謝!";
				}
			} else {
				message = "登入失敗，請重新註冊";
				resultPage =  "success";
			}
		}
		return resultPage;
	}
//會員註冊啟用連結	
	public String validateEmail() throws Exception {//validate Email
		initServlet();
		try {
			ClothesUser clothesUser = clothesUserService.getClothesUserById(userId);
			clothesUser.setUserStatus(1);
			clothesUserService.updateClothesUser(clothesUser);
			resultPage = "validate";
			message = "驗証成功！會員已經啟用。";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
	public String backadminregister() {
		System.out.println("start backadminregister..");
		return "backadminregister";
	}
// 超連結-會員購物畫面	
	public String loginShop() {
		clothesCheck = clothesCheckService.getClothesCheckById(checkId);
 		clothesProducts = clothesProductService.search(getClothesCheck(), null);
		System.out.println("start shop..");
		return "shop";
	}

// 超連結-會員查詢資料畫面
	public String shop() {
		System.out.println("start Membersearch..");
		return "Membersearch";
	}
	public String adminMembersearch() {
		System.out.println("start adminMembersearch..");
		return "adminMembersearch";
	}

// 帳號密碼儲存
	public String register() throws Exception { // link to register.jsp
		initServlet();
		try {
			if (clothesUser != null)
				clothesUser = null;
			resultPage = "register";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}

// 帳號密碼儲存
	public String registerSave() {
		initServlet();
		try{
		if (usercheckpassword.equals(clothesUser.getUserPassword())) {
			clothesUserService.saveClothesUser(clothesUser);
			//未啟用帳號
			clothesUser.setUserStatus(2);
			clothesUserService.updateClothesUser(clothesUser);
			MailUtil.sendEmail(clothesUser.getUserEmail(), String.valueOf(clothesUser.getUserId()), clothesUser.getUserName());
			String userCaptchaResponse = request.getParameter("jcaptcha");
			boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, userCaptchaResponse);
			if(captchaPassed){
			} else {
			}
			return "success";
		} else {
			return "error";
		}}catch (Exception e) {
			e.printStackTrace();
	}
	return resultPage;	
	}


//程式先執行跳頁再執行程式
	public String changeData(){
		clothesUser = clothesUserService.getClothesUserById(userId);
		
		return "data";		
	}
//程式先執行跳頁再執行程式
// 修改會員資料
// 超連結-會員查詢資料畫面
	public String modify() throws Exception { // modify member information
		initServlet();
		try {			
			clothesUserService.updateClothesUser(clothesUser);
			clothesUsers = clothesUserService.getAllClothesUser();
			resultPage = detail();
			message = "會員資料已經修改。";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Membermodification";
	}

	public String detail() throws Exception {// link to member/detail.jsp
		initServlet();
		try {
			clothesUser = clothesUserService.getClothesUserByAccount(sessionUserAccount());
			resultPage = "detail";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
	public String deleteUser() throws Exception { // delete product information
		try {
			initServlet();
			ClothesUser user = clothesUserService.getClothesUserById(userId);
			clothesUserService.deleteClothesUser(user);
			message = "名稱為:" + user.getUserAccount() + "  會員資料已經刪除。";
			if(clothesUser != null) clothesUser = null;
			clothesUsers = clothesUserService.getAllClothesUser();
		} catch (Exception e) {
			message = "無法刪除，此會員正在線上中。";
			e.printStackTrace();
		}
		return "userdelete";
	}
	public String jumpuserdelete(){
		clothesUser = clothesUserService.getClothesUserById(userId);
		return "changeuserdelete";		
	}
	//程式先執行跳頁再執行程式
	public String changePwd(){
		return "change";
	}
	//程式先執行跳頁再執行程式	
	public String modifyPwd() throws Exception {//modify member password
		initServlet();
		try {
			if (oldPassword.equals(clothesUser.getUserPassword())) {
				if (newPassword.equals(checkPassword)) {
					clothesUser.setUserPassword(newPassword);
					clothesUserService.updateClothesUser(clothesUser);
					resultPage = "Membermodification";
					message = "密碼已修改。";
				} else {
					message = "兩次密碼輸入不相同";
					resultPage= "Memberpasswordcheck";
				}
			} else {
				message = "舊密碼錯誤!";
				resultPage = "Memberpasswordcheck";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
	/*
	 * public String main() throws Exception { //link to member/main.jsp
	 * initServlet(); try { resultPage = "main"; } catch (Exception e) {
	 * e.printStackTrace(); } return resultPage; }
	 */

	/*
	 * public String edit() throws Exception { //link to member/edit.jsp
	 * initServlet(); try { if (clothesUser.getUserPassword() != null &&
	 * !"".equals(clothesUser.getUserPassword())) {
	 * disPhone(clothesUser.getUserPassword()); } brithDay =
	 * TimeUtil.getDateString(clothesUser.getMemberBirth()); resultPage =
	 * "edit"; } catch (Exception e) { e.printStackTrace(); } return resultPage;
	 * }
	 */

	// link to login.jsp
	/*
	 * public String loginPage() throws Exception { initServlet(); try { if
	 * (clothesUser != null) clothesUser = null;//清空舊資料 resultPage = "login"; }
	 * catch (Exception e) { e.printStackTrace(); } return resultPage; }
	 */
	//要注意為integer/String	
	private String sessionUserAccount() {
		return String.valueOf(session.getAttribute("userlogin").toString());
	}
	
	private String sessionAdminAccount() {
		return String.valueOf(session.getAttribute("adminlogin").toString());
	}
	//要注意為integer/String	
	// 檢查session 是否存在
	private boolean checkSession() {
		if (session.getAttribute("userlogin") == null) {
			return false;
		} else {
			return true;
		}
	}
	// 將電話 區碼和號碼分開
	private void disPhone(String phone) {
		this.firstNumber = phone.substring(0, 2);
		this.userphone = phone.substring(2, phone.length());
	}

	// getter and setter
	public ClothesCheckService getClothesCheckService() {
		return clothesCheckService;
	}

	public void setClothesCheckService(ClothesCheckService clothesCheckService) {
		this.clothesCheckService = clothesCheckService;
	}

	public ClothesProductService getClothesProductService() {
		return clothesProductService;
	}

	public void setClothesProductService(
			ClothesProductService clothesProductService) {
		this.clothesProductService = clothesProductService;
	}

	public ClothesUserService getClothesUserService() {
		return clothesUserService;
	}

	public void setClothesUserService(ClothesUserService clothesUserService) {
		this.clothesUserService = clothesUserService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsercheckpassword() {
		return usercheckpassword;
	}

	public void setUsercheckpassword(String usercheckpassword) {
		this.usercheckpassword = usercheckpassword;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(String firstNumber) {
		this.firstNumber = firstNumber;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public ClothesUser getClothesUser() {
		return clothesUser;
	}

	public void setClothesUser(ClothesUser clothesUser) {
		this.clothesUser = clothesUser;
	}

	public String getUsersex() {
		return usersex;
	}

	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public List<ClothesCheck> getClothesChecks() {
		return clothesChecks;
	}

	public void setClothesChecks(List<ClothesCheck> clothesChecks) {
		this.clothesChecks = clothesChecks;
	}

	public List<ClothesUser> getClothesUsers() {
		return clothesUsers;
	}

	public void setClothesUsers(List<ClothesUser> clothesUsers) {
		this.clothesUsers = clothesUsers;
	}

	public ClothesProduct getClothesProduct() {
		return clothesProduct;
	}

	public void setClothesProduct(ClothesProduct clothesProduct) {
		this.clothesProduct = clothesProduct;
	}

	public List<ClothesProduct> getClothesProducts() {
		return clothesProducts;
	}

	public void setClothesProducts(List<ClothesProduct> clothesProducts) {
		this.clothesProducts = clothesProducts;
	}

	public ClothesCheck getClothesCheck() {
		return clothesCheck;
	}

	public void setClothesCheck(ClothesCheck clothesCheck) {
		this.clothesCheck = clothesCheck;
	}

	public int getCheckId() {
		return checkId;
	}

	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ClothesCartItemService getClothesCartItemService() {
		return clothesCartItemService;
	}

	public void setClothesCartItemService(
			ClothesCartItemService clothesCartItemService) {
		this.clothesCartItemService = clothesCartItemService;
	}

	public ClothesCartService getClothesCartService() {
		return clothesCartService;
	}

	public void setClothesCartService(ClothesCartService clothesCartService) {
		this.clothesCartService = clothesCartService;
	}

	public ClothesPayService getClothesPayService() {
		return clothesPayService;
	}

	public void setClothesPayService(ClothesPayService clothesPayService) {
		this.clothesPayService = clothesPayService;
	}

	public ClothesSubscribeService getClothesSubscribeService() {
		return clothesSubscribeService;
	}

	public void setClothesSubscribeService(
			ClothesSubscribeService clothesSubscribeService) {
		this.clothesSubscribeService = clothesSubscribeService;
	}

	public ClothesSubscribeItemService getClothesSubscribeItemService() {
		return clothesSubscribeItemService;
	}

	public void setClothesSubscribeItemService(
			ClothesSubscribeItemService clothesSubscribeItemService) {
		this.clothesSubscribeItemService = clothesSubscribeItemService;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}


	
	
	
}
