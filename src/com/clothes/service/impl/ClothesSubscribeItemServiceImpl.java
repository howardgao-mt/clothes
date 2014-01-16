package com.clothes.service.impl;

import java.util.List;

import com.clothes.dao.ClothesSubscribeDao;
import com.clothes.dao.ClothesSubscribeItemDao;
import com.clothes.model.ClothesSubscribe;
import com.clothes.model.ClothesSubscribeItem;
import com.clothes.service.ClothesSubscribeItemService;

public class ClothesSubscribeItemServiceImpl implements ClothesSubscribeItemService{
	private ClothesSubscribeItemDao clothesSubscribeItemDao;
	
	public ClothesSubscribeItemServiceImpl() {}
		public ClothesSubscribeItemServiceImpl(ClothesSubscribeItemDao clothesSubscribeItemDao) {
			this.clothesSubscribeItemDao = clothesSubscribeItemDao;
	}
	public void setClothesSubscribeItemDao(ClothesSubscribeItemDao clothesSubscribeItemDao) {
		this.clothesSubscribeItemDao = clothesSubscribeItemDao;
	}

	
	public ClothesSubscribeItemDao getClothesSubscribeItemDao() {
		return clothesSubscribeItemDao;
	}
	public void saveClothesSubscribeItem(
			ClothesSubscribeItem clothesSubscribeItem) {
		// TODO Auto-generated method stub
		clothesSubscribeItemDao.saveClothesSubscribeItem(clothesSubscribeItem);
	}

	public void updateClothesSubscribeItem(
			ClothesSubscribeItem clothesSubscribeItem) {
		// TODO Auto-generated method stub
		clothesSubscribeItemDao.updateClothesSubscribeItem(clothesSubscribeItem);
	}

	public void deleteClothesSubscribeItem(
			ClothesSubscribeItem clothesSubscribeItem) {
		// TODO Auto-generated method stub
		clothesSubscribeItemDao.deleteClothesSubscribeItem(clothesSubscribeItem);	
	}

	public List<ClothesSubscribeItem> getAllClothesSubscribeItem() {
		// TODO Auto-generated method stub
		return clothesSubscribeItemDao.getAllClothesSubscribeItem();
	}

	public ClothesSubscribeItem getClothesSubscribeItemById(int subscribeitemId) {
		// TODO Auto-generated method stub
		return clothesSubscribeItemDao.getClothesSubscribeItemById(subscribeitemId);
	}

	public List<ClothesSubscribeItem> search(ClothesSubscribe clothesSubscribe,
			String subscribeitemName) {
		// TODO Auto-generated method stub
		return clothesSubscribeItemDao.searchSubscribeItem(clothesSubscribe, subscribeitemName);
	}

	public List<ClothesSubscribeItem> getClothesSubscribeItemListBySubscribe(
			ClothesSubscribe clothesSubscribe) {
		// TODO Auto-generated method stub
		return clothesSubscribeItemDao.getSubscribeItemListBySubscribe(clothesSubscribe);
	}

}
