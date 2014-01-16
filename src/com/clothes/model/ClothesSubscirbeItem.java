package com.clothes.model;

/**
 * ClothesSubscirbeItem entity. @author MyEclipse Persistence Tools
 */

public class ClothesSubscirbeItem implements java.io.Serializable {

	// Fields

	private Integer subscirbeId;
	private ClothesSubscribe clothesSubscribe;
	private ClothesProduct clothesProduct;
	private Integer subscirbeItemId;
	private Integer subscirbeItemQuantity;
	private Integer subscirbeItemPrice;
	private Integer subscirbeItemSum;

	// Constructors

	/** default constructor */
	public ClothesSubscirbeItem() {
	}

	/** full constructor */
	public ClothesSubscirbeItem(ClothesSubscribe clothesSubscribe,
			ClothesProduct clothesProduct, Integer subscirbeItemId,
			Integer subscirbeItemQuantity, Integer subscirbeItemPrice,
			Integer subscirbeItemSum) {
		this.clothesSubscribe = clothesSubscribe;
		this.clothesProduct = clothesProduct;
		this.subscirbeItemId = subscirbeItemId;
		this.subscirbeItemQuantity = subscirbeItemQuantity;
		this.subscirbeItemPrice = subscirbeItemPrice;
		this.subscirbeItemSum = subscirbeItemSum;
	}

	// Property accessors

	public Integer getSubscirbeId() {
		return this.subscirbeId;
	}

	public void setSubscirbeId(Integer subscirbeId) {
		this.subscirbeId = subscirbeId;
	}

	public ClothesSubscribe getClothesSubscribe() {
		return this.clothesSubscribe;
	}

	public void setClothesSubscribe(ClothesSubscribe clothesSubscribe) {
		this.clothesSubscribe = clothesSubscribe;
	}

	public ClothesProduct getClothesProduct() {
		return this.clothesProduct;
	}

	public void setClothesProduct(ClothesProduct clothesProduct) {
		this.clothesProduct = clothesProduct;
	}

	public Integer getSubscirbeItemId() {
		return this.subscirbeItemId;
	}

	public void setSubscirbeItemId(Integer subscirbeItemId) {
		this.subscirbeItemId = subscirbeItemId;
	}

	public Integer getSubscirbeItemQuantity() {
		return this.subscirbeItemQuantity;
	}

	public void setSubscirbeItemQuantity(Integer subscirbeItemQuantity) {
		this.subscirbeItemQuantity = subscirbeItemQuantity;
	}

	public Integer getSubscirbeItemPrice() {
		return this.subscirbeItemPrice;
	}

	public void setSubscirbeItemPrice(Integer subscirbeItemPrice) {
		this.subscirbeItemPrice = subscirbeItemPrice;
	}

	public Integer getSubscirbeItemSum() {
		return this.subscirbeItemSum;
	}

	public void setSubscirbeItemSum(Integer subscirbeItemSum) {
		this.subscirbeItemSum = subscirbeItemSum;
	}

}