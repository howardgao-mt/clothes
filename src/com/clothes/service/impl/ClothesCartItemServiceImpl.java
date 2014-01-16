package com.clothes.service.impl;

import java.util.List;

import com.clothes.dao.ClothesCartItemDao;
import com.clothes.model.ClothesCart;
import com.clothes.model.ClothesCartItem;
import com.clothes.service.ClothesCartItemService;

public class ClothesCartItemServiceImpl implements ClothesCartItemService{
	
	private ClothesCartItemDao clothesCartItemDao;
	
	public ClothesCartItemServiceImpl() {}
	
	public ClothesCartItemServiceImpl(ClothesCartItemDao clothesCartItemDao) {
		this.clothesCartItemDao = clothesCartItemDao;
	}
	public void setClothesCartItemDao(ClothesCartItemDao clothesCartItemDao) {
		this.clothesCartItemDao = clothesCartItemDao;
	}

	
	public ClothesCartItemDao getClothesCartItemDao() {
		return clothesCartItemDao;
	}


	public void saveClothesCartItem(ClothesCartItem clothesCartItem) {
		// TODO Auto-generated method stub
		clothesCartItemDao.saveClothesCartItem(clothesCartItem);
	}

	public void updateClothesCartItem(ClothesCartItem clothesCartItem) {
		// TODO Auto-generated method stub
		clothesCartItemDao.updateClothesCartItem(clothesCartItem);
	}

	public void deleteClothesCartItem(ClothesCartItem clothesCartItem) {
		// TODO Auto-generated method stub
		clothesCartItemDao.deleteClothesCartItem(clothesCartItem);
	}

	public List<ClothesCartItem> getAllClothesCartItem() {
		// TODO Auto-generated method stub
		return clothesCartItemDao.getAllClothesCartItem();
	}

	public ClothesCartItem getClothesCartItemById(int cartitemId) {
		// TODO Auto-generated method stub
		return clothesCartItemDao.getClothesCartItemById(cartitemId);
	}
    //類別跟商品的對應關係
	public List<ClothesCartItem> search(ClothesCart clothesCart,
			String cartitemName) {
		// TODO Auto-generated method stub
		return clothesCartItemDao.searchCartItem(clothesCart, cartitemName);
	}
	public List<ClothesCartItem> getClothesCartItemListByCart(
			ClothesCart clothesCart) {
		// TODO Auto-generated method stub
		return clothesCartItemDao.getCartItemListByCart(clothesCart);
	}



}
