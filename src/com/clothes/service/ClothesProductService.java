package com.clothes.service;
import java.util.List;

import com.clothes.model.ClothesCheck;
import com.clothes.model.ClothesProduct;

public interface ClothesProductService {
	public void saveClothesProduct(ClothesProduct clothesProduct);
	
	public void updateClothesProduct(ClothesProduct clothesProduct);
	
	public void deleteClothesProduct(ClothesProduct clothesProduct);
	
	public List<ClothesProduct> getAllClothesProduct(ClothesCheck clothesCheck, int productStatus);
	public List<ClothesProduct> getAllClothesProduct();
	
	public ClothesProduct getClothesProductById(int productId);
    //���O��ӫ~���������Y
	public List<ClothesProduct> search(ClothesCheck clothesCheck, String productName);

}
