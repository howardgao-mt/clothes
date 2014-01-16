package com.clothes.service.impl;

import java.util.List;
import com.clothes.dao.ClothesCheckDao;
import com.clothes.model.ClothesCheck;
import com.clothes.service.ClothesCheckService;

public class ClothesCheckServiceImpl implements ClothesCheckService{
	private ClothesCheckDao clothesCheckDao;
	
	public ClothesCheckServiceImpl() {}
		public ClothesCheckServiceImpl(ClothesCheckDao clothesCheckDao) {
			this.clothesCheckDao = clothesCheckDao;
	}
	public void setClothesCheckDao(ClothesCheckDao clothesCheckDao) {
		this.clothesCheckDao = clothesCheckDao;
	}

	
	public ClothesCheckDao getClothesCheckDao() {
		return clothesCheckDao;
	}
	public void saveClothesCheck(ClothesCheck clothesCheck) {
		// TODO Auto-generated method stub
		clothesCheckDao.saveClothesCheck(clothesCheck);
	}

	public void updateClothesCheck(ClothesCheck clothesCheck) {
		// TODO Auto-generated method stub
		clothesCheckDao.updateClothesCheck(clothesCheck);		
	}

	public void deleteClothesCheck(ClothesCheck clothesCheck) {
		// TODO Auto-generated method stub
		clothesCheckDao.deleteClothesCheck(clothesCheck);			
	}

	public ClothesCheck getClothesCheckById(int checkId) {
		// TODO Auto-generated method stub
		return clothesCheckDao.getClothesCheckById(checkId);
	}
	public List<ClothesCheck> getAllClothesCheck(int checkStatus) {
		// TODO Auto-generated method stub
		return clothesCheckDao.getAllClothesCheck(checkStatus);
	}
	public List<ClothesCheck> getAllClothesCheck() {
		// TODO Auto-generated method stub
		return clothesCheckDao.getAllClothesCheck();
	}

}
