package com.clothes.service;

import java.util.List;

import com.clothes.model.ClothesCart;
import com.clothes.model.ClothesUser;

public interface ClothesCartService {
	public void saveClothesCart(ClothesCart clothesCart);
	
	public void updateClothesCart(ClothesCart clothesCart);
	
	public void deleteClothesCart(ClothesCart clothesCart);
	
	public List<ClothesCart> getAllClothesCart();
	
	public ClothesCart getClothesCartById(int cartId);
	
	public List<ClothesCart> getClothesCartListByUserId(String cartId, ClothesUser clothesUser, String cartStatus);
	
	public ClothesCart getClothesCartByUserId(String cartId, ClothesUser clothesUser, String cartStatus);

	public ClothesCart getClothesCartById(String cartId);
}
