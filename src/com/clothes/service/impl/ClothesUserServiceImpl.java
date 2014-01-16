package com.clothes.service.impl;

import java.util.List;
import com.clothes.dao.ClothesUserDao;
import com.clothes.model.ClothesUser;
import com.clothes.service.ClothesUserService;

public class ClothesUserServiceImpl implements ClothesUserService {
	private ClothesUserDao clothesUserDao;
	
	public ClothesUserServiceImpl() {}
	
	public ClothesUserServiceImpl(ClothesUserDao clothesUserDao) {
		this.clothesUserDao = clothesUserDao;
	}
	
	
	
	public ClothesUserDao getClothesUserDao() {
		return clothesUserDao;
	}

	public void setClothesUserDao(ClothesUserDao clothesUserDao) {
		this.clothesUserDao = clothesUserDao;
	}

	public void saveClothesUser(ClothesUser clothesUser) {
		// TODO Auto-generated method stub
		clothesUserDao.saveClothesUser(clothesUser);
	}

	public void updateClothesUser(ClothesUser clothesUser) {
		// TODO Auto-generated method stub
		clothesUserDao.updateClothesUser(clothesUser);		
	}

	public void deleteClothesUser(ClothesUser clothesUser) {
		// TODO Auto-generated method stub
		clothesUserDao.deleteClothesUser(clothesUser);			
	}

	public List<ClothesUser> getAllClothesUser() {
		// TODO Auto-generated method stub
		return clothesUserDao.getAllClothesUser();
	}

	public ClothesUser getClothesUserByAccount(String userAccount) {
		// TODO Auto-generated method stub
		List<ClothesUser> list = clothesUserDao.getClothesUserByAccount(userAccount);
		if(list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		} 
	}

	public ClothesUser getClothesUserById(int userId) {
		// TODO Auto-generated method stub
		List<ClothesUser> list = clothesUserDao.getClothesUserById(userId);
		if(list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		} 
	}

	public ClothesUser getClothesUserByEmail(String userEmail) {
		// TODO Auto-generated method stub
		List<ClothesUser> list = clothesUserDao.getClothesUserByEmail(userEmail);
		if(list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		} 
	}

	


}
