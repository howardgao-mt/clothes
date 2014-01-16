package com.clothes.action.shop;

import java.util.List;

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

public class ShopAction extends BaseActionSupport{
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
	
	public String cart() throws Exception {//link to basket.jsp
		initServlet();
		try {
			clothesUser = clothesUserService.getClothesUserByAccount(sessionUserAccount());
			resultPage = "cartdelete";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
/*	try {
		initServlet();
		ClothesProduct product = clothesProductService.getClothesProductById(productId);
		clothesProductService.deleteClothesProduct(product);
		message = "商品: [ " + product.getProductName() + " ] 已經刪除。";
		if(clothesProduct != null) clothesProduct = null;
		clothesProducts = clothesProductService.getAllClothesProduct();
	} catch (Exception e) {
		message = "無法刪除，此商品正在被選取中。";
		e.printStackTrace();
	}
	return "productdelete";*/
	
	
	public String deleteCartItem() throws Exception {//delete basket item
	initServlet();
		try {
			ClothesCartItem cartitem = clothesCartItemService.getClothesCartItemById(cartItemId);
			clothesCartItemService.deleteClothesCartItem(cartitem);
			if(clothesCartItem != null) clothesCartItem = null;
			clothesCartItems = clothesCartItemService.getAllClothesCartItem();
		} catch (Exception e) {
			message = "無法刪除，此商品正在被選取中。";
			e.printStackTrace();
		}
		return "cartdelete";
	}
	/*			clothesCartItem = clothesCartItemService.getClothesCartItemById(cartitemId);
	clothesProduct = clothesProductService.getClothesProductById(clothesCartItem.getClothesProduct().getProductId());
	clothesCartItemService.deleteClothesCartItem(clothesCartItem);
	resultPage = cart();
	if (message == "") message = "商品 [ " + clothesProduct.getProductName() + " ]已刪除。";
} catch (Exception e) {
	e.printStackTrace();
}
return resultPage;*/
	
	public String jumpdCartdelete() throws Exception {
	initServlet();
	try{
		clothesCartItem = clothesCartItemService.getClothesCartItemById(cartItemId);
		clothesProduct = clothesProductService.getClothesProductById(productId);
		clothesCheck = clothesCheckService.getClothesCheckById(checkId);
 		clothesProducts = clothesProductService.search(getClothesCheck(), null);
		clothesCartItems = clothesCartItemService.getAllClothesCartItem();
		System.out.println("start jumpdCartelete..");
		resultPage = "changecartdelete";
	} catch(Exception e) {
		e.printStackTrace();
	}
	return resultPage;
	}
//跳耀至訂單檢視介面	
	public String jumpshopPay() throws Exception {
		initServlet();
		try{
		clothesUser = clothesUserService.getClothesUserByAccount(sessionUserAccount());
		clothesCart = clothesCartService.getClothesCartByUserId(null, clothesUser , null);
		clothesCartItems = clothesCartItemService.getClothesCartItemListByCart(clothesCart);
		//自動產生新的表格
		clothesSubscribe = new ClothesSubscribe();
		//自動產生新的表格
		clothesSubscribe.setSubscribeName(clothesUser.getUserName());
		clothesSubscribe.setSubscribeAddress(clothesUser.getUserAddress());
		clothesSubscribe.setSubscribePhone(String.valueOf(clothesUser.getUserPhone()));
		clothesSubscribe.setSubscribeEmail(clothesUser.getUserEmail());
		totalSum();
		System.out.println("start jumpshopPay..");
		resultPage = "shopPay";
		} catch (Exception e){
			e.printStackTrace();
		}
		return resultPage;
	}
//儲存收件人資料	
	public String savePay() throws Exception {//add new product information
		initServlet();
		try {
			clothesPay.getPayBank();
			clothesPay.getPayStatus();
			clothesPay.getPayTransport();	
			message = " 訂單是否成立?";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payList();
	}
	
	public String payList() {
		clothesSubscribes = clothesSubscribeService.getAllClothesSubscribe();
		return "success";
	}
//儲存收件人資料	
	
//跳耀至訂單確認檢視介面		
	public String jumpshopPayCheck() throws Exception {
		initServlet();
		try{
		clothesUser = clothesUserService.getClothesUserByAccount(sessionUserAccount());
		clothesCart = clothesCartService.getClothesCartByUserId(null, clothesUser , null);
		clothesCartItems = clothesCartItemService.getClothesCartItemListByCart(clothesCart);
		clothesSubscribes = clothesSubscribeService.getAllClothesSubscribe();
		clothesPays = clothesPayService.getAllClothesPay();
		totalSum();
		System.out.println("start jumpshoppPayCheck..");
		resultPage = "shopPayCheck";
		} catch (Exception e){
			e.printStackTrace();
		}
		return resultPage;
	}
	
	public String savePayCheck() throws Exception {//add new product information
		initServlet();
		try {
			ClothesUser model = clothesUserService.getClothesUserById(Integer.valueOf(userId));
			clothesSubscribe.setClothesUser(model);
			clothesSubscribe.setSubscribeStatus(1);
			clothesSubscribeService.saveClothesSubscribe(clothesSubscribe);
			clothesPayService.saveClothesPay(clothesPay);
			message = " 訂單已成立";
			if (clothesSubscribe != null) clothesSubscribe = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payList();
	}
	
	private boolean totalSum() {//檢查總金額
		boolean value = true;
		int total = 0;
		for (int i = 0; i < clothesCartItems.size(); i++) {
			total = total + clothesCartItems.get(i).getCartItemSum();
			clothesCartItems = clothesCartItemService.getAllClothesCartItem();
		} if (clothesCartItems.size() == 0) {
			value = false;
		}
		clothesCartItems = clothesCartItemService.getAllClothesCartItem();
		totalSum = String.valueOf(total);
		return value;
	}
	
	private String sessionUserAccount() {
		return String.valueOf(session.getAttribute("userlogin").toString());
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


	public List<ClothesPay> getClothesPays() {
		return clothesPays;
	}


	public void setClothesPays(List<ClothesPay> clothesPays) {
		this.clothesPays = clothesPays;
	}


	public String getTotalPaySum() {
		return totalPaySum;
	}


	public void setTotalPaySum(String totalPaySum) {
		this.totalPaySum = totalPaySum;
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

	
}
