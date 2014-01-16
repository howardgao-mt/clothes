package com.clothes.dao;

import java.util.List;

import com.clothes.model.ClothesCheck;
import com.clothes.model.ClothesUser;


public interface ClothesCheckDao {
	public void saveClothesCheck(ClothesCheck clothesCheck);
	public void updateClothesCheck(ClothesCheck clothesCheck);
	public void deleteClothesCheck(ClothesCheck clothesCheck);
	
	public List<ClothesCheck> getAllClothesCheck(int checkStatus);
	
	public List<ClothesCheck> getAllClothesCheck();

	public ClothesCheck getClothesCheckById(int checkId);

}