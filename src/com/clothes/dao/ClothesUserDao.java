package com.clothes.dao;

import java.util.List;

import com.clothes.model.ClothesUser;


public interface ClothesUserDao {
	public void saveClothesUser(ClothesUser clothesUser);
	public void updateClothesUser(ClothesUser clothesUser);
	public void deleteClothesUser(ClothesUser clothesUser);
	
	
	public List<ClothesUser> getAllClothesUser();

	public List<ClothesUser> getClothesUserByAccount(String userAccount);
	
	public List<ClothesUser> getClothesUserById(int userId);
	
	public List<ClothesUser> getClothesUserByEmail(String email);


}
