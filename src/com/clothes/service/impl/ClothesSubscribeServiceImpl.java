package com.clothes.service.impl;

import java.util.List;

import com.clothes.dao.ClothesSubscribeDao;
import com.clothes.model.ClothesSubscribe;
import com.clothes.model.ClothesUser;
import com.clothes.service.ClothesSubscribeService;

public class ClothesSubscribeServiceImpl implements ClothesSubscribeService{
	private ClothesSubscribeDao clothesSubscribeDao;
	
	public ClothesSubscribeServiceImpl() {}
		public ClothesSubscribeServiceImpl(ClothesSubscribeDao clothesSubscribeDao) {
			this.clothesSubscribeDao = clothesSubscribeDao;
	}
	public void setClothesSubscribeDao(ClothesSubscribeDao clothesSubscribeDao) {
		this.clothesSubscribeDao = clothesSubscribeDao;
	}

	
	public ClothesSubscribeDao getClothesSubscribeDao() {
		return clothesSubscribeDao;
	}
	public void saveClothesSubscribe(ClothesSubscribe clothesSubscribe) {
		// TODO Auto-generated method stub
		clothesSubscribeDao.saveClothesSubscribe(clothesSubscribe);
	}

	public void updateClothesSubscribe(ClothesSubscribe clothesSubscribe) {
		// TODO Auto-generated method stub
		clothesSubscribeDao.updateClothesSubscribe(clothesSubscribe);
	}

	public void deleteClothesSubscribe(ClothesSubscribe clothesSubscribe) {
		// TODO Auto-generated method stub
		clothesSubscribeDao.deleteClothesSubscribe(clothesSubscribe);
	}

	public List<ClothesSubscribe> getAllClothesSubscribe() {
		// TODO Auto-generated method stub
		return clothesSubscribeDao.getAllClothesSubscribe();
	}

	public ClothesSubscribe getClothesSubscribeById(int subscribeId) {
		// TODO Auto-generated method stub
		return clothesSubscribeDao.getClothesSubscribeById(subscribeId);
	}

	public List<ClothesSubscribe> getClothesSubscribeListByUserId(
			String subscribeId, ClothesUser clothesUser, String subscribeStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	public ClothesSubscribe getClothesSubscribeByUserId(String subscribeId,
			ClothesUser clothesUser, String subscribeStatus) {
		// TODO Auto-generated method stub
		List<ClothesSubscribe> list = clothesSubscribeDao.getClothesSubscribeByUserId(subscribeId, clothesUser, subscribeStatus);
		if (list.size()!= 1){
			return null;
		} else
		return list.get(0);
	}

}
