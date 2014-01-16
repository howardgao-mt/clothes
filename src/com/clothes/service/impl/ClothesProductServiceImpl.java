package com.clothes.service.impl;

import java.util.List;
import com.clothes.dao.ClothesProductDao;
import com.clothes.model.ClothesCheck;
import com.clothes.model.ClothesProduct;
import com.clothes.service.ClothesProductService;

public class ClothesProductServiceImpl implements ClothesProductService{
	private ClothesProductDao clothesProductDao;
	
	public ClothesProductServiceImpl() {}
		public ClothesProductServiceImpl(ClothesProductDao clothesProductDao) {
			this.clothesProductDao = clothesProductDao;
	}
	public void setClothesProductDao(ClothesProductDao clothesProductDao) {
		this.clothesProductDao = clothesProductDao;
	}

	
	public ClothesProductDao getClothesProductDao() {
		return clothesProductDao;
	}
	public void saveClothesProduct(ClothesProduct clothesProduct) {
		// TODO Auto-generated method stub
		clothesProductDao.saveClothesProduct(clothesProduct);
	}

	public void updateClothesProduct(ClothesProduct clothesProduct) {
		// TODO Auto-generated method stub
		clothesProductDao.updateClothesProduct(clothesProduct);		
	}

	public void deleteClothesProduct(ClothesProduct clothesProduct) {
		// TODO Auto-generated method stub
		clothesProductDao.deleteClothesProduct(clothesProduct);			
	}

	public List<ClothesProduct> getAllClothesProduct(ClothesCheck clothesCheck, int productStatus) {
		// TODO Auto-generated method stub
		return clothesProductDao.getAllClothesProduct(clothesCheck, productStatus);
	}
	public List<ClothesProduct> getAllClothesProduct() {
		// TODO Auto-generated method stub
		return clothesProductDao.getAllClothesProduct();
	}

	public ClothesProduct getClothesProductById(int productId) {
		// TODO Auto-generated method stub
		return clothesProductDao.getClothesProductById(productId);
	}
    //類別跟商品的對應關係
	public List<ClothesProduct> search(ClothesCheck clothesCheck,
			String productName) {
		// TODO Auto-generated method stub		
		return clothesProductDao.searchProduct(clothesCheck, productName);
	}

}
