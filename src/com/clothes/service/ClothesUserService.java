package com.clothes.service;
import java.util.List;

import com.clothes.model.ClothesUser;

public interface ClothesUserService {
	public void saveClothesUser(ClothesUser clothesUser);
	
	public void updateClothesUser(ClothesUser clothesUser);
	
	public void deleteClothesUser(ClothesUser clothesUser);
	
	public List<ClothesUser> getAllClothesUser();
	
	public ClothesUser getClothesUserByAccount(String userAccount);
	
	public ClothesUser getClothesUserById(int userId);
	
	public ClothesUser getClothesUserByEmail(String userEmail);



}