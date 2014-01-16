package com.clothes.model;

/**
 * ClothesCartItem entity. @author MyEclipse Persistence Tools
 */

public class ClothesCartItem implements java.io.Serializable {

	// Fields

	private Integer cartItemId;
	private ClothesProduct clothesProduct;
	private ClothesCart clothesCart;
	private Integer cartItemQuantity;
	private Integer cartItemPrice;
	private Integer cartItemSum;

	// Constructors

	/** default constructor */
	public ClothesCartItem() {
	}

	/** full constructor */
	public ClothesCartItem(ClothesProduct clothesProduct,
			ClothesCart clothesCart, Integer cartItemQuantity,
			Integer cartItemPrice, Integer cartItemSum) {
		this.clothesProduct = clothesProduct;
		this.clothesCart = clothesCart;
		this.cartItemQuantity = cartItemQuantity;
		this.cartItemPrice = cartItemPrice;
		this.cartItemSum = cartItemSum;
	}

	// Property accessors

	public Integer getCartItemId() {
		return this.cartItemId;
	}

	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}

	public ClothesProduct getClothesProduct() {
		return this.clothesProduct;
	}

	public void setClothesProduct(ClothesProduct clothesProduct) {
		this.clothesProduct = clothesProduct;
	}

	public ClothesCart getClothesCart() {
		return this.clothesCart;
	}

	public void setClothesCart(ClothesCart clothesCart) {
		this.clothesCart = clothesCart;
	}

	public Integer getCartItemQuantity() {
		return this.cartItemQuantity;
	}

	public void setCartItemQuantity(Integer cartItemQuantity) {
		this.cartItemQuantity = cartItemQuantity;
	}

	public Integer getCartItemPrice() {
		return this.cartItemPrice;
	}

	public void setCartItemPrice(Integer cartItemPrice) {
		this.cartItemPrice = cartItemPrice;
	}

	public Integer getCartItemSum() {
		return this.cartItemSum;
	}

	public void setCartItemSum(Integer cartItemSum) {
		this.cartItemSum = cartItemSum;
	}

}