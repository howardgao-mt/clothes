package com.clothes.user;

import java.util.List;

import com.clothes.action.BaseActionSupport;
import com.clothes.model.ClothesCart;
import com.clothes.model.ClothesCartItem;
import com.clothes.model.ClothesSubscribe;
import com.clothes.service.ClothesCartItemService;
import com.clothes.service.ClothesCartService;
import com.clothes.service.ClothesCheckService;
import com.clothes.service.ClothesPayService;
import com.clothes.service.ClothesProductService;
import com.clothes.service.ClothesSubscribeItemService;
import com.clothes.service.ClothesSubscribeService;
import com.clothes.service.ClothesUserService;

public class SubscribeAction extends BaseActionSupport{
	private ClothesCheckService clothesCheckService;
	private ClothesProductService clothesProductService;
	private ClothesUserService clothesUserService;
	private ClothesCartItemService clothesCartItemService;
	private ClothesCartService clothesCartService;
	private ClothesPayService clothesPayService;
	private ClothesSubscribeService clothesSubscribeService;
	private ClothesSubscribeItemService clothesSubscribeItemService;
	private List<ClothesSubscribe> clothesSubscribes;
	private ClothesSubscribe clothesSubscribe;
	private int subscribeId;
	
	public String jumpadminSubscribe() throws Exception {
		clothesSubscribes = clothesSubscribeService.getAllClothesSubscribe();
		System.out.println("start jumpadminSubscribe..");
		return "adminSubscribe";
	}
	public String deleteSubscribe() throws Exception {//delete basket information
		initServlet();
		try {
			ClothesSubscribe cart =  clothesSubscribeService.getClothesSubscribeById(subscribeId);
			clothesSubscribeService.deleteClothesSubscribe(cart);
			message = "訂單編號: [ " + cart.getSubscribeId() + " ] 已經刪除。";
			clothesSubscribes = clothesSubscribeService.getAllClothesSubscribe();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "detleteSubscribe";
	}
	

	public int getSubscribeId() {
		return subscribeId;
	}
	public void setSubscribeId(int subscribeId) {
		this.subscribeId = subscribeId;
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
	
}
