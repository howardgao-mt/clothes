package com.clothes.dao;

import java.util.List;

import com.clothes.model.ClothesCheck;
import com.clothes.model.ClothesProduct;


public interface ClothesProductDao {
	public void saveClothesProduct(ClothesProduct clothesProduct);
	
	public void updateClothesProduct(ClothesProduct clothesProduct);
	
	public void deleteClothesProduct(ClothesProduct clothesProduct);
	
	public List<ClothesProduct> getAllClothesProduct(ClothesCheck clothesCheck, int productStatus);

	public ClothesProduct getClothesProductById(int productId);
    //���O��ӫ~���������Y
	public List<ClothesProduct> searchProduct(ClothesCheck clothesCheck, String productName);
	public List<ClothesProduct> getAllClothesProduct();

}

