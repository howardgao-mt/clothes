package com.clothes.dao;

import java.util.List;

import com.clothes.model.ClothesCart;
import com.clothes.model.ClothesCartItem;
import com.clothes.model.ClothesUser;



public interface ClothesCartItemDao {
	public void saveClothesCartItem(ClothesCartItem clothesCartItem);
	
	public void updateClothesCartItem(ClothesCartItem clothesCartItem);
	
	public void deleteClothesCartItem(ClothesCartItem clothesCartItem);
	
	public List<ClothesCartItem> getAllClothesCartItem();

	public ClothesCartItem getClothesCartItemById(int cartitemId);
    //類別跟商品的對應關係
	public List<ClothesCartItem> searchCartItem(ClothesCart clothesCart, String cartitemName);
	public List<ClothesCartItem> getCartItemListByCart(ClothesCart clothesCart);
	
}
