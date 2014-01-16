package com.clothes.dao;

import java.util.List;

import com.clothes.model.ClothesCart;
import com.clothes.model.ClothesUser;

public interface ClothesCartDao {
	public void saveClothesCart(ClothesCart clothesCart);
	
	public void updateClothesCart(ClothesCart clothesCart);
	
	public void deleteClothesCart(ClothesCart clothesCart);
	
	public List<ClothesCart> getAllClothesCart();

	public ClothesCart getClothesCartById(int cartId);
	
	public List<ClothesCart> getClothesCartByUserId(String cartId, ClothesUser clothesUser, String cartStatus);
	
	public List<ClothesCart> searchCart(ClothesUser clothesUser, String cartStatus);
}
