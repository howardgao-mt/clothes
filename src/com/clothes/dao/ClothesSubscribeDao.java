package com.clothes.dao;

import java.util.List;

import com.clothes.model.ClothesSubscribe;
import com.clothes.model.ClothesUser;

public interface ClothesSubscribeDao {
	
	public void saveClothesSubscribe(ClothesSubscribe clothesSubscribe);
	
	public void updateClothesSubscribe(ClothesSubscribe clothesSubscribe);
	
	public void deleteClothesSubscribe(ClothesSubscribe clothesSubscribe);
	
	public List<ClothesSubscribe> getAllClothesSubscribe();

	public ClothesSubscribe getClothesSubscribeById(int subscribeId);
	
	public List<ClothesSubscribe> getClothesSubscribeByUserId(String subscribeId, ClothesUser clothesUser, String subscribeStatus);
	
	public List<ClothesSubscribe> searchSubscribe(ClothesUser clothesUser, String subscribeStatus);
}
