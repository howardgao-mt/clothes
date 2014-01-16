package com.clothes.user;

import java.util.List;

import org.apache.log4j.Logger;

import com.clothes.action.BaseActionSupport;
import com.clothes.model.ClothesCart;
import com.clothes.model.ClothesCartItem;
import com.clothes.model.ClothesCheck;
import com.clothes.model.ClothesPay;
import com.clothes.model.ClothesProduct;
import com.clothes.model.ClothesSubscribe;
import com.clothes.model.ClothesSubscribeItem;
import com.clothes.model.ClothesUser;
import com.clothes.service.ClothesCartItemService;
import com.clothes.service.ClothesCartService;
import com.clothes.service.ClothesCheckService;
import com.clothes.service.ClothesPayService;
import com.clothes.service.ClothesProductService;
import com.clothes.service.ClothesSubscribeItemService;
import com.clothes.service.ClothesSubscribeService;
import com.clothes.service.ClothesUserService;

public class FrameAction extends BaseActionSupport{
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
	//List
	private ClothesUser clothesUser;
	private List<ClothesUser> clothesUsers;
	private ClothesCheck clothesCheck;
	private List<ClothesCheck> clothesChecks;
	private ClothesProduct clothesProduct;
	private List<ClothesProduct> clothesProducts;
	private ClothesPay clothesPay;
	private ClothesCart clothesCart;
	private List<ClothesCartItem> clothesCartItems;
	private ClothesCartItem clothesCartItem;
	private List<ClothesSubscribeItem> clothesSubscribeItems;
	private ClothesSubscribeItem clothesSubscribeItem;
	private List<ClothesSubscribe> clothesSubscribes;
	private ClothesSubscribe clothesSubscribe;
	private List<ClothesPay> clothesPays;
	private List<String> checkbox;

	//List
	private String username;
	private int checkId;
	private int userId;
	private int productId;
	private String cartId;
	private int cartItemId;
	private int payId;
	private String cartAddress;
	private int cartStatus;
	private int cartitemQuantity;
	private int cartitemPrice;
	private int cartitemSum;
	private String totalSum;
	private String totalPaySum;
	private int subscribeId;
	private int subscribeitemId;
	private String subscribeAddress;
	private String subscribeStatus;
	private String subscribeName;
	private String subscribePhone;
	private String subscribeEmail;
	private int subscribeitemQuantity;
	private int subscribeitemPrice;
	private int subscribeitemSum;
	private String totalpaySum;
	private String totalpayship;
	private String userPassword;
	private String userEmail;
	private Logger logger = Logger.getLogger(FrameAction.class);
	
	public String top() throws Exception {//link to top.jsp
		logger.info("start top() method...");
		initServlet();
		try {
			resultPage = "top";
		} catch(Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		logger.info("end top() method... link to top.jsp");
		return resultPage;
	}
	
	public String menu() throws Exception { //link to menu.jsp
		initServlet();
		try {
			resultPage = "menu";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
	
	public String index() throws Exception { //link to index.jsp
		initServlet();
		try {
			resultPage = "index";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
	public String usertop() throws Exception {//link to top.jsp
		logger.info("start top() method...");
		initServlet();
		try {
			resultPage = "top";
		} catch(Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		logger.info("end top() method... link to top.jsp");
		return resultPage;
	}
	
	public String usermenu() throws Exception { //link to menu.jsp
		initServlet();
		try {
			clothesChecks = clothesCheckService.getAllClothesCheck(1);
			resultPage = "menu";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
	
	public String userindex() throws Exception { //link to index.jsp
		initServlet();
		try {
			resultPage = "index";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
	public String userbottom() throws Exception { //link to index.jsp
		initServlet();
		try {
			resultPage = "bottom";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
	
	
	
	
	
	
	
	public ClothesCheckService getClothesCheckService() {
		return clothesCheckService;
	}
	public void setClothesCheckService(ClothesCheckService clothesCheckService) {
		this.clothesCheckService = clothesCheckService;
	}
	public ClothesProductService getClothesProductService() {
		return clothesProductService;
	}
	public void setClothesProductService(ClothesProductService clothesProductService) {
		this.clothesProductService = clothesProductService;
	}
	public ClothesUserService getClothesUserService() {
		return clothesUserService;
	}
	public void setClothesUserService(ClothesUserService clothesUserService) {
		this.clothesUserService = clothesUserService;
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
	public ClothesUser getClothesUser() {
		return clothesUser;
	}
	public void setClothesUser(ClothesUser clothesUser) {
		this.clothesUser = clothesUser;
	}
	public List<ClothesUser> getClothesUsers() {
		return clothesUsers;
	}
	public void setClothesUsers(List<ClothesUser> clothesUsers) {
		this.clothesUsers = clothesUsers;
	}
	public ClothesCheck getClothesCheck() {
		return clothesCheck;
	}
	public void setClothesCheck(ClothesCheck clothesCheck) {
		this.clothesCheck = clothesCheck;
	}
	public List<ClothesCheck> getClothesChecks() {
		return clothesChecks;
	}
	public void setClothesChecks(List<ClothesCheck> clothesChecks) {
		this.clothesChecks = clothesChecks;
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
	public ClothesPay getClothesPay() {
		return clothesPay;
	}
	public void setClothesPay(ClothesPay clothesPay) {
		this.clothesPay = clothesPay;
	}
	public ClothesCart getClothesCart() {
		return clothesCart;
	}
	public void setClothesCart(ClothesCart clothesCart) {
		this.clothesCart = clothesCart;
	}
	public List<ClothesCartItem> getClothesCartItems() {
		return clothesCartItems;
	}
	public void setClothesCartItems(List<ClothesCartItem> clothesCartItems) {
		this.clothesCartItems = clothesCartItems;
	}
	public ClothesCartItem getClothesCartItem() {
		return clothesCartItem;
	}
	public void setClothesCartItem(ClothesCartItem clothesCartItem) {
		this.clothesCartItem = clothesCartItem;
	}
	public List<ClothesSubscribeItem> getClothesSubscribeItems() {
		return clothesSubscribeItems;
	}
	public void setClothesSubscribeItems(
			List<ClothesSubscribeItem> clothesSubscribeItems) {
		this.clothesSubscribeItems = clothesSubscribeItems;
	}
	public ClothesSubscribeItem getClothesSubscribeItem() {
		return clothesSubscribeItem;
	}
	public void setClothesSubscribeItem(ClothesSubscribeItem clothesSubscribeItem) {
		this.clothesSubscribeItem = clothesSubscribeItem;
	}
	public List<ClothesSubscribe> getClothesSubscribes() {
		return clothesSubscribes;
	}
	public void setClothesSubscribes(List<ClothesSubscribe> clothesSubscribes) {
		this.clothesSubscribes = clothesSubscribes;
	}
	public ClothesSubscribe getClothesSubscribe() {
		return clothesSubscribe;
	}
	public void setClothesSubscribe(ClothesSubscribe clothesSubscribe) {
		this.clothesSubscribe = clothesSubscribe;
	}
	public List<ClothesPay> getClothesPays() {
		return clothesPays;
	}
	public void setClothesPays(List<ClothesPay> clothesPays) {
		this.clothesPays = clothesPays;
	}
	public List<String> getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(List<String> checkbox) {
		this.checkbox = checkbox;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public String getCartAddress() {
		return cartAddress;
	}
	public void setCartAddress(String cartAddress) {
		this.cartAddress = cartAddress;
	}
	public int getCartStatus() {
		return cartStatus;
	}
	public void setCartStatus(int cartStatus) {
		this.cartStatus = cartStatus;
	}
	public int getCartitemQuantity() {
		return cartitemQuantity;
	}
	public void setCartitemQuantity(int cartitemQuantity) {
		this.cartitemQuantity = cartitemQuantity;
	}
	public int getCartitemPrice() {
		return cartitemPrice;
	}
	public void setCartitemPrice(int cartitemPrice) {
		this.cartitemPrice = cartitemPrice;
	}
	public int getCartitemSum() {
		return cartitemSum;
	}
	public void setCartitemSum(int cartitemSum) {
		this.cartitemSum = cartitemSum;
	}
	public String getTotalSum() {
		return totalSum;
	}
	public void setTotalSum(String totalSum) {
		this.totalSum = totalSum;
	}
	public String getTotalPaySum() {
		return totalPaySum;
	}
	public void setTotalPaySum(String totalPaySum) {
		this.totalPaySum = totalPaySum;
	}
	public int getSubscribeId() {
		return subscribeId;
	}
	public void setSubscribeId(int subscribeId) {
		this.subscribeId = subscribeId;
	}
	public int getSubscribeitemId() {
		return subscribeitemId;
	}
	public void setSubscribeitemId(int subscribeitemId) {
		this.subscribeitemId = subscribeitemId;
	}
	public String getSubscribeAddress() {
		return subscribeAddress;
	}
	public void setSubscribeAddress(String subscribeAddress) {
		this.subscribeAddress = subscribeAddress;
	}
	public String getSubscribeStatus() {
		return subscribeStatus;
	}
	public void setSubscribeStatus(String subscribeStatus) {
		this.subscribeStatus = subscribeStatus;
	}
	public String getSubscribeName() {
		return subscribeName;
	}
	public void setSubscribeName(String subscribeName) {
		this.subscribeName = subscribeName;
	}
	public String getSubscribePhone() {
		return subscribePhone;
	}
	public void setSubscribePhone(String subscribePhone) {
		this.subscribePhone = subscribePhone;
	}
	public String getSubscribeEmail() {
		return subscribeEmail;
	}
	public void setSubscribeEmail(String subscribeEmail) {
		this.subscribeEmail = subscribeEmail;
	}
	public int getSubscribeitemQuantity() {
		return subscribeitemQuantity;
	}
	public void setSubscribeitemQuantity(int subscribeitemQuantity) {
		this.subscribeitemQuantity = subscribeitemQuantity;
	}
	public int getSubscribeitemPrice() {
		return subscribeitemPrice;
	}
	public void setSubscribeitemPrice(int subscribeitemPrice) {
		this.subscribeitemPrice = subscribeitemPrice;
	}
	public int getSubscribeitemSum() {
		return subscribeitemSum;
	}
	public void setSubscribeitemSum(int subscribeitemSum) {
		this.subscribeitemSum = subscribeitemSum;
	}
	public String getTotalpaySum() {
		return totalpaySum;
	}
	public void setTotalpaySum(String totalpaySum) {
		this.totalpaySum = totalpaySum;
	}
	public String getTotalpayship() {
		return totalpayship;
	}
	public void setTotalpayship(String totalpayship) {
		this.totalpayship = totalpayship;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
