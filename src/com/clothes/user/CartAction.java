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
import com.clothes.model.ClothesUser;
import com.clothes.service.ClothesCartItemService;
import com.clothes.service.ClothesCartService;
import com.clothes.service.ClothesCheckService;
import com.clothes.service.ClothesPayService;
import com.clothes.service.ClothesProductService;
import com.clothes.service.ClothesSubscribeItemService;
import com.clothes.service.ClothesSubscribeService;
import com.clothes.service.ClothesUserService;

public class CartAction extends BaseActionSupport{
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
	private List<ClothesCart> clothesCarts;
	private ClothesCart clothesCart;
	private List<ClothesCartItem> clothesCartItems;
	private ClothesCartItem clothesCartItem;
	private List<String> checkbox;

	//List
	private String username;
	private int checkId;
	private int userId;
	private int productId;
	private int cartId;
	private int cartitemId;
	private int payId;
	private String cartAddress;
	private int cartStatus;
	private int cartitemQuantity;
	private int cartitemPrice;
	private int cartitemSum;
	private String totalSum;

	//要注意為integer/String	
	private String sessionUserAccount() {
		return String.valueOf(session.getAttribute("userlogin").toString());
	}
//要注意為integer/String		
	private Logger logger = Logger.getLogger(CartAction.class);
//跳耀函式	
	public String jumpshopCart() throws Exception {
		initServlet();
		try{		
		clothesUser = clothesUserService.getClothesUserByAccount(sessionUserAccount());
		clothesCart = clothesCartService.getClothesCartByUserId(null, clothesUser , null);
		clothesCartItems = clothesCartItemService.getClothesCartItemListByCart(clothesCart);
		//刪除下架的cartitem裡的productId
		checkprod();	
		clothesCartItems = clothesCartItemService.getClothesCartItemListByCart(clothesCart);
		totalSum();
		System.out.println("start jumpshopCart..");
		resultPage = "shopCart";
		} catch (Exception e){
			e.printStackTrace();
		}
		return resultPage;
	}
//刪除下架的cartitem裡的productId	
	public String checkprod(){
		String msg="";
		message = "所選商品已經下架。";
			for(int i=0 ; i < clothesCartItems.size() ; i++ ){
				ClothesProduct pro = clothesCartItems.get(i).getClothesProduct();
				if (pro.getProductStatus()==2 || pro.getClothesCheck().getCheckStatus()==2){
					clothesCartItemService.deleteClothesCartItem(clothesCartItems.get(i));					
				}
/*			if (pro.getClothesCheck().getCheckStatus()==2){
					clothesCartItemService.deleteClothesCartItem(clothesCartItems.get(i));					
				}*/
			}
		
		return msg;
	} 
//總花費	
	private boolean totalSum() {
		boolean value = true;
		int total = 0;
		for (int i = 0; i < clothesCartItems.size(); i++) {
			total = total + clothesCartItems.get(i).getCartItemSum();
		} if (clothesCartItems.size() == 0) {
			value = false;
		}
		totalSum = String.valueOf(total);
		return value;
	}
	
//跳耀函式	
	public String main() throws Exception {//link to main.jsp
		initServlet();
		try {
			logger.debug("start main");
			resultPage = "main";
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		logger.debug("end main");
		return resultPage;
	}
	public String detail() throws Exception {//link to detail.jsp
		initServlet();
		try {
			clothesCart = clothesCartService.getClothesCartById(cartId);
			clothesCartItems = clothesCartItemService.getClothesCartItemListByCart(clothesCart);
			resultPage = "detail";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
	
	public String deleteCart() throws Exception {//delete basket information
		initServlet();
		try {
			ClothesCart cart =  clothesCartService.getClothesCartById(cartId);
			clothesCartService.deleteClothesCart(cart);
			message = "編號: [ " + cart.getCartId() + " ] 已經刪除。";
			if(clothesCart != null) clothesCart = null;
			clothesCarts= clothesCartService.getAllClothesCart();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "deletecart";
	}
	public String deleteList() throws Exception {//delete basket information use list
		initServlet();
		try {
			if (checkbox == null) {
				message = "沒有選取資料。";
				resultPage = "main";
			} else {
				for (int i = 0; i < checkbox.size(); i++) {
					ClothesCart cart = clothesCartService.getClothesCartById(checkbox.get(i));
					clothesCartService.deleteClothesCart(cart);
				}
				checkbox.clear();
				resultPage = main();
				message = "所選記錄已刪除。";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
/*	
	public String cartitemList() {
		clothesCartItems = clothesCartItemService.getAllClothesCartItem();
		return "success";
	}*/
// 超連結-跳到adminMember
		public String jumpadminCart() throws Exception {
			clothesCarts = clothesCartService.getAllClothesCart();
			System.out.println("start jumpadminCart..");
			return "adminCart";
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public ClothesCartItem getClothesCartItem() {
		return clothesCartItem;
	}
	public void setClothesCartItem(ClothesCartItem clothesCartItem) {
		this.clothesCartItem = clothesCartItem;
	}
	public String getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(String totalSum) {
		this.totalSum = totalSum;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCartitemId() {
		return cartitemId;
	}

	public void setCartitemId(int cartitemId) {
		this.cartitemId = cartitemId;
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
	public List<ClothesCart> getClothesCarts() {
		return clothesCarts;
	}

	public void setClothesCarts(List<ClothesCart> clothesCarts) {
		this.clothesCarts = clothesCarts;
	}

	public void setCartitemSum(int cartitemSum) {
		this.cartitemSum = cartitemSum;
	}
	public List<ClothesCartItem> getClothesCartItems() {
		return clothesCartItems;
	}
	public void setClothesCartItems(List<ClothesCartItem> clothesCartItems) {
		this.clothesCartItems = clothesCartItems;
	}

	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<String> getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(List<String> checkbox) {
		this.checkbox = checkbox;
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

	
	
}
