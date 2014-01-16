package com.clothes.service.impl;

import java.util.List;

import com.clothes.dao.ClothesCartDao;
import com.clothes.model.ClothesCart;
import com.clothes.model.ClothesUser;
import com.clothes.service.ClothesCartService;

public class ClothesCartServiceImpl implements ClothesCartService{
	private ClothesCartDao clothesCartDao;
	
	public ClothesCartServiceImpl() {}
		public ClothesCartServiceImpl(ClothesCartDao clothesCartDao) {
			this.clothesCartDao = clothesCartDao;
	}
	public void setClothesCartDao(ClothesCartDao clothesCartDao) {
		this.clothesCartDao = clothesCartDao;
	}

	
	public ClothesCartDao getClothesCartDao() {
		return clothesCartDao;
	}

	public void saveClothesCart(ClothesCart clothesCart) {
		// TODO Auto-generated method stub
		clothesCartDao.saveClothesCart(clothesCart);	
	}

	public void updateClothesCart(ClothesCart clothesCart) {
		// TODO Auto-generated method stub
		clothesCartDao.updateClothesCart(clothesCart);	
	}

	public void deleteClothesCart(ClothesCart clothesCart) {
		// TODO Auto-generated method stub
		clothesCartDao.deleteClothesCart(clothesCart);
	}

	public List<ClothesCart> getAllClothesCart() {
		// TODO Auto-generated method stub
		return clothesCartDao.getAllClothesCart();
	}

	public ClothesCart getClothesCartById(int cartId) {
		// TODO Auto-generated method stub
		return clothesCartDao.getClothesCartById(cartId);
	}
	public ClothesCart getClothesCartById(String cartId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<ClothesCart> getClothesCartListByUserId(String cartId,
			ClothesUser clothesUser, String cartStatus) {
		// TODO Auto-generated method stub
		return null;
	}
	public ClothesCart getClothesCartByUserId(String cartId, ClothesUser clothesUser, String cartStatus) {
		// TODO Auto-generated method stub
		List<ClothesCart> list = clothesCartDao.getClothesCartByUserId(cartId, clothesUser, cartStatus);
		if (list.size()!= 1){
			return null;
		} else
		return list.get(0);
	}

}
