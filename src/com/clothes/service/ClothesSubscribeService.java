package com.clothes.service;

import java.util.List;

import com.clothes.model.ClothesSubscribe;
import com.clothes.model.ClothesUser;

public interface ClothesSubscribeService {
	public void saveClothesSubscribe(ClothesSubscribe clothesSubscribe);
	
	public void updateClothesSubscribe(ClothesSubscribe clothesSubscribe);
	
	public void deleteClothesSubscribe(ClothesSubscribe clothesSubscribe);
	
	public List<ClothesSubscribe> getAllClothesSubscribe();
	
	public ClothesSubscribe getClothesSubscribeById(int subscribeId);
	
	public List<ClothesSubscribe> getClothesSubscribeListByUserId(String subscribeId, ClothesUser clothesUser, String subscribeStatus);
	
	public ClothesSubscribe getClothesSubscribeByUserId(String subscribeId, ClothesUser clothesUser, String subscribeStatus);
}
