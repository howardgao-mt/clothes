package com.clothes.service;

import java.util.List;

import com.clothes.model.ClothesCart;
import com.clothes.model.ClothesCartItem;


public interface ClothesCartItemService {
	public void saveClothesCartItem(ClothesCartItem clothesCartItem);
	
	public void updateClothesCartItem(ClothesCartItem clothesCartItem);
	
	public void deleteClothesCartItem(ClothesCartItem clothesCartItem);
	
	public List<ClothesCartItem> getAllClothesCartItem();
	
	public ClothesCartItem getClothesCartItemById(int cartitemId);
    //���O��ӫ~���������Y
	public List<ClothesCartItem> search(ClothesCart clothesCart, String cartitemName);
	
	public List<ClothesCartItem> getClothesCartItemListByCart(ClothesCart clothesCart);
	
}
