package com.clothes.service.impl;

import java.util.List;

import com.clothes.dao.ClothesPayDao;
import com.clothes.model.ClothesPay;
import com.clothes.service.ClothesPayService;

public class ClothesPayServiceImpl implements ClothesPayService{
	
	private ClothesPayDao clothesPayDao;
	
	public ClothesPayServiceImpl() {}
		public ClothesPayServiceImpl(ClothesPayDao clothesPayDao) {
			this.clothesPayDao = clothesPayDao;
	}
	public void setClothesPayDao(ClothesPayDao clothesPayDao) {
		this.clothesPayDao = clothesPayDao;
	}

	
	public ClothesPayDao getClothesPayDao() {
		return clothesPayDao;
	}

	public void saveClothesPay(ClothesPay clothesPay) {
		// TODO Auto-generated method stub
		clothesPayDao.saveClothesPay(clothesPay);			
	}

	public void updateClothesPay(ClothesPay clothesPay) {
		// TODO Auto-generated method stub
		clothesPayDao.saveClothesPay(clothesPay);			
	}

	public void deleteClothesPay(ClothesPay clothesPay) {
		// TODO Auto-generated method stub
		clothesPayDao.saveClothesPay(clothesPay);			
	}

	public List<ClothesPay> getAllClothesPay() {
		// TODO Auto-generated method stub
		return clothesPayDao.getAllClothesPay();
	}

	public ClothesPay getClothesPayById(int payId) {
		// TODO Auto-generated method stub
		return clothesPayDao.getClothesPayById(payId);
	}

}
