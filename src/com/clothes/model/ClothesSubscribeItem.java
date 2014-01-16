package com.clothes.model;

/**
 * ClothesSubscribeItem entity. @author MyEclipse Persistence Tools
 */

public class ClothesSubscribeItem implements java.io.Serializable {

	// Fields

	private Integer subscribeId;
	private ClothesProduct clothesProduct;
	private Integer subscribeItemId;
	private Integer subscribeItemQuantity;
	private Integer subscribeItemPrice;
	private Integer subscribeItemSum;

	// Constructors

	/** default constructor */
	public ClothesSubscribeItem() {
	}

	/** minimal constructor */
	public ClothesSubscribeItem(ClothesProduct clothesProduct,
			Integer subscribeItemId) {
		this.clothesProduct = clothesProduct;
		this.subscribeItemId = subscribeItemId;
	}

	/** full constructor */
	public ClothesSubscribeItem(ClothesProduct clothesProduct,
			Integer subscribeItemId, Integer subscribeItemQuantity,
			Integer subscribeItemPrice, Integer subscribeItemSum) {
		this.clothesProduct = clothesProduct;
		this.subscribeItemId = subscribeItemId;
		this.subscribeItemQuantity = subscribeItemQuantity;
		this.subscribeItemPrice = subscribeItemPrice;
		this.subscribeItemSum = subscribeItemSum;
	}

	// Property accessors

	public Integer getSubscribeId() {
		return this.subscribeId;
	}

	public void setSubscribeId(Integer subscribeId) {
		this.subscribeId = subscribeId;
	}

	public ClothesProduct getClothesProduct() {
		return this.clothesProduct;
	}

	public void setClothesProduct(ClothesProduct clothesProduct) {
		this.clothesProduct = clothesProduct;
	}

	public Integer getSubscribeItemId() {
		return this.subscribeItemId;
	}

	public void setSubscribeItemId(Integer subscribeItemId) {
		this.subscribeItemId = subscribeItemId;
	}

	public Integer getSubscribeItemQuantity() {
		return this.subscribeItemQuantity;
	}

	public void setSubscribeItemQuantity(Integer subscribeItemQuantity) {
		this.subscribeItemQuantity = subscribeItemQuantity;
	}

	public Integer getSubscribeItemPrice() {
		return this.subscribeItemPrice;
	}

	public void setSubscribeItemPrice(Integer subscribeItemPrice) {
		this.subscribeItemPrice = subscribeItemPrice;
	}

	public Integer getSubscribeItemSum() {
		return this.subscribeItemSum;
	}

	public void setSubscribeItemSum(Integer subscribeItemSum) {
		this.subscribeItemSum = subscribeItemSum;
	}

}