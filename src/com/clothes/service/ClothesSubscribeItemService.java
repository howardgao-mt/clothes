package com.clothes.service;

import java.util.List;

import com.clothes.model.ClothesSubscribe;
import com.clothes.model.ClothesSubscribeItem;

public interface ClothesSubscribeItemService {
	public void saveClothesSubscribeItem(ClothesSubscribeItem clothesSubscribeItem);
	
	public void updateClothesSubscribeItem(ClothesSubscribeItem clothesSubscribeItem);
	
	public void deleteClothesSubscribeItem(ClothesSubscribeItem clothesSubscribeItem);
	
	public List<ClothesSubscribeItem> getAllClothesSubscribeItem();
	
	public ClothesSubscribeItem getClothesSubscribeItemById(int subscribeitemId);
    //類別跟商品的對應關係
	public List<ClothesSubscribeItem> search(ClothesSubscribe clothesSubscribe, String subscribeitemName);
	
	public List<ClothesSubscribeItem> getClothesSubscribeItemListBySubscribe(ClothesSubscribe clothesSubscribe);
}
