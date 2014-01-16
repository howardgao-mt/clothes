package com.clothes.service;
import java.util.List;

import com.clothes.model.ClothesCheck;

public interface ClothesCheckService {
	public void saveClothesCheck(ClothesCheck clothesCheck);
	
	public void updateClothesCheck(ClothesCheck clothesCheck);
	
	public void deleteClothesCheck(ClothesCheck clothesCheck);
	
	public List<ClothesCheck> getAllClothesCheck(int checkStatus);
	
	public ClothesCheck getClothesCheckById(int checkId);
	
	public List<ClothesCheck> getAllClothesCheck();

}