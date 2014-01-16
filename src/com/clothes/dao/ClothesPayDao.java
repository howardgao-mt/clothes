package com.clothes.dao;

import java.util.List;

import com.clothes.model.ClothesPay;

public interface ClothesPayDao {
	public void saveClothesPay(ClothesPay clothesPay);
	public void updateClothesPay(ClothesPay clothesPay);
	public void deleteClothesPay(ClothesPay clothesPay);
	
	public List<ClothesPay> getAllClothesPay();

	public ClothesPay getClothesPayById(int payId);
}
