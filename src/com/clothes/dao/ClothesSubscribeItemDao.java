package com.clothes.dao;

import java.util.List;

import com.clothes.model.ClothesSubscribe;
import com.clothes.model.ClothesSubscribeItem;
import com.clothes.model.ClothesUser;

public interface ClothesSubscribeItemDao {
	public void saveClothesSubscribeItem(ClothesSubscribeItem clothesSubscribeItem);
	
	public void updateClothesSubscribeItem(ClothesSubscribeItem clothesSubscribeItem);
	
	public void deleteClothesSubscribeItem(ClothesSubscribeItem clothesSubscribeItem);
	
	public List<ClothesSubscribeItem> getAllClothesSubscribeItem();

	public ClothesSubscribeItem getClothesSubscribeItemById(int subscribeitemId);
    //類別跟商品的對應關係
	public List<ClothesSubscribeItem> searchSubscribeItem(ClothesSubscribe clothesSubscribe, String subscribeitemName);
	
	public List<ClothesSubscribeItem> getSubscribeItemListBySubscribe(ClothesSubscribe clothesSubscribe);
}
