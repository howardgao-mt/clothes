package com.clothes.action.json;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.clothes.model.ClothesCart;
import com.clothes.model.ClothesCartItem;
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
import com.opensymphony.xwork2.ActionSupport;

public class JsonCartAction extends ActionSupport{
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	// 訊息傳送
	private String value;
	private ClothesCart clothesCart;
	private List<ClothesCart> list;
	private Map<String, ClothesCart> map;
	
	private HttpSession session;
	
	private ClothesCheckService clothesCheckService;
	private ClothesProductService clothesProductService;
	private ClothesUserService clothesUserService;
	private ClothesCartItemService clothesCartItemService;
	private ClothesCartService clothesCartService;
	private ClothesPayService clothesPayService;
	private ClothesSubscribeService clothesSubscribeService;
	private ClothesSubscribeItemService clothesSubscribeItemService;
	private ClothesUser clothesUser;
	private ClothesProduct clothesProduct;
	private ClothesCartItem clothesCartItem;
	private int cartId;
	private int productId;
	private String quantity;
	// 訊息傳送
	
	private String sessionUserAccount() {
		return String.valueOf(session.getAttribute("userlogin").toString());
	}

	
	public String add() {
		init();
		try {
			if (session.getAttribute("userlogin") == null) {
				value = "請先登入會員。";
			} else {
				clothesUser = clothesUserService.getClothesUserByAccount(sessionUserAccount());
				clothesCart = clothesCartService.getClothesCartByUserId(null, clothesUser, "0");
				if (clothesCart == null) {
					createNewCart();
				}
				addCartItem();
				value = "[ " + clothesProduct.getProductName()+ " ] " + quantity + " 個 已加入購物車。";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
		
	}
	private void addCartItem() {
		// TODO Auto-generated method stub
		clothesProduct = clothesProductService.getClothesProductById(productId);
		List<ClothesCartItem> list = clothesCartItemService.getClothesCartItemListByCart(clothesCart);
		if(checkProduct(list, productId)) {
			clothesCartItem = list.get(Integer.valueOf(value));
			int i = clothesCartItem.getCartItemQuantity();
			clothesCartItem.setCartItemQuantity(i + Integer.valueOf(quantity));
			clothesCartItem.setCartItemSum(clothesCartItem.getCartItemPrice()* clothesCartItem.getCartItemQuantity());
			clothesCartItemService.updateClothesCartItem(clothesCartItem);
		} else {
			clothesCartItem = new ClothesCartItem();
			clothesCartItem.setCartItemQuantity(Integer.valueOf(quantity));
			clothesCartItem.setClothesCart(clothesCart);
			clothesCartItem.setClothesProduct(clothesProduct);
			clothesCartItem.setCartItemPrice(clothesProduct.getProductPrice());
			clothesCartItem.setCartItemSum(clothesCartItem.getCartItemPrice()
					* clothesCartItem.getCartItemQuantity());
			clothesCartItemService.saveClothesCartItem(clothesCartItem);
		}
		clothesCart = null;
	}
	
	private void createNewCart() {
		clothesCart = new ClothesCart();
		clothesCart.setCartStatus(0);
		clothesCart.setClothesUser(clothesUser);
		clothesCartService.saveClothesCart(clothesCart);
	}
	
	private boolean checkProduct(List<ClothesCartItem> list, int productId) {
		boolean check = false;
		for(int i = 0; i < list.size();i++) {
			ClothesProduct pro = list.get(i).getClothesProduct();
			if(productId == pro.getProductId()) {
				this.value = String.valueOf(i);
				check = true;
			}
		}
		return check;
	}
	
	private void init() {
		// TODO Auto-generated method stub
		this.session = ServletActionContext.getRequest().getSession();
		
	}
	//記得getter要加@JSON(serialize = false)；setter則不用
	@JSON(serialize = false)
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	@JSON(serialize = false)
	public ClothesCheckService getClothesCheckService() {
		return clothesCheckService;
	}
	public void setClothesCheckService(ClothesCheckService clothesCheckService) {
		this.clothesCheckService = clothesCheckService;
	}
	
	@JSON(serialize = false)
	public ClothesProductService getClothesProductService() {
		return clothesProductService;
	}
	public void setClothesProductService(ClothesProductService clothesProductService) {
		this.clothesProductService = clothesProductService;
	}
	
	@JSON(serialize = false)
	public ClothesUserService getClothesUserService() {
		return clothesUserService;
	}
	public void setClothesUserService(ClothesUserService clothesUserService) {
		this.clothesUserService = clothesUserService;
	}
	@JSON(serialize = false)
	public ClothesCartItemService getClothesCartItemService() {
		return clothesCartItemService;
	}
	public void setClothesCartItemService(
			ClothesCartItemService clothesCartItemService) {
		this.clothesCartItemService = clothesCartItemService;
	}
	@JSON(serialize = false)
	public ClothesCartService getClothesCartService() {
		return clothesCartService;
	}
	public void setClothesCartService(ClothesCartService clothesCartService) {
		this.clothesCartService = clothesCartService;
	}
	@JSON(serialize = false)
	public ClothesPayService getClothesPayService() {
		return clothesPayService;
	}
	public void setClothesPayService(ClothesPayService clothesPayService) {
		this.clothesPayService = clothesPayService;
	}
	@JSON(serialize = false)
	public ClothesUser getClothesUser() {
		return clothesUser;
	}
	public void setClothesUser(ClothesUser clothesUser) {
		this.clothesUser = clothesUser;
	}
	@JSON(serialize = false)
	public ClothesProduct getClothesProduct() {
		return clothesProduct;
	}
	public void setClothesProduct(ClothesProduct clothesProduct) {
		this.clothesProduct = clothesProduct;
	}
	@JSON(serialize = false)
	public ClothesCartItem getClothesCartItem() {
		return clothesCartItem;
	}
	public void setClothesCartItem(ClothesCartItem clothesCartItem) {
		this.clothesCartItem = clothesCartItem;
	}
	@JSON(serialize = false)
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	@JSON(serialize = false)
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@JSON(serialize = false)
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@JSON(serialize = false)
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ClothesCart getClothesCart() {
		return clothesCart;
	}
	public void setClothesCart(ClothesCart clothesCart) {
		this.clothesCart = clothesCart;
	}
	public List<ClothesCart> getList() {
		return list;
	}
	public void setList(List<ClothesCart> list) {
		this.list = list;
	}
	public Map<String, ClothesCart> getMap() {
		return map;
	}
	public void setMap(Map<String, ClothesCart> map) {
		this.map = map;
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
