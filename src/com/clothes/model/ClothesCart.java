package com.clothes.model;

import java.util.HashSet;
import java.util.Set;

/**
 * ClothesCart entity. @author MyEclipse Persistence Tools
 */

public class ClothesCart implements java.io.Serializable {

	// Fields

	private Integer cartId;
	private ClothesUser clothesUser;
	private String cartAddress;
	private Integer cartStatus;
	private Set clothesCartItems = new HashSet(0);

	// Constructors

	/** default constructor */
	public ClothesCart() {
	}

	/** minimal constructor */
	public ClothesCart(ClothesUser clothesUser, Integer cartStatus) {
		this.clothesUser = clothesUser;
		this.cartStatus = cartStatus;
	}

	/** full constructor */
	public ClothesCart(ClothesUser clothesUser, String cartAddress,
			Integer cartStatus, Set clothesCartItems) {
		this.clothesUser = clothesUser;
		this.cartAddress = cartAddress;
		this.cartStatus = cartStatus;
		this.clothesCartItems = clothesCartItems;
	}

	// Property accessors

	public Integer getCartId() {
		return this.cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public ClothesUser getClothesUser() {
		return this.clothesUser;
	}

	public void setClothesUser(ClothesUser clothesUser) {
		this.clothesUser = clothesUser;
	}

	public String getCartAddress() {
		return this.cartAddress;
	}

	public void setCartAddress(String cartAddress) {
		this.cartAddress = cartAddress;
	}

	public Integer getCartStatus() {
		return this.cartStatus;
	}

	public void setCartStatus(Integer cartStatus) {
		this.cartStatus = cartStatus;
	}

	public Set getClothesCartItems() {
		return this.clothesCartItems;
	}

	public void setClothesCartItems(Set clothesCartItems) {
		this.clothesCartItems = clothesCartItems;
	}

}