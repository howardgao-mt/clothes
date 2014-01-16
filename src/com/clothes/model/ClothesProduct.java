package com.clothes.model;

import java.util.HashSet;
import java.util.Set;

/**
 * ClothesProduct entity. @author MyEclipse Persistence Tools
 */

public class ClothesProduct implements java.io.Serializable {

	// Fields

	private Integer productId;
	private ClothesCheck clothesCheck;
	private String productName;
	private Integer productPrice;
	private String productDescription;
	private Integer productStatus;
	private Set clothesCartItems = new HashSet(0);
	private Set clothesSubscribeItems = new HashSet(0);

	// Constructors

	/** default constructor */
	public ClothesProduct() {
	}

	/** minimal constructor */
	public ClothesProduct(ClothesCheck clothesCheck, String productName,
			Integer productPrice) {
		this.clothesCheck = clothesCheck;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	/** full constructor */
	public ClothesProduct(ClothesCheck clothesCheck, String productName,
			Integer productPrice, String productDescription,
			Integer productStatus, Set clothesCartItems,
			Set clothesSubscribeItems) {
		this.clothesCheck = clothesCheck;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productStatus = productStatus;
		this.clothesCartItems = clothesCartItems;
		this.clothesSubscribeItems = clothesSubscribeItems;
	}

	// Property accessors

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public ClothesCheck getClothesCheck() {
		return this.clothesCheck;
	}

	public void setClothesCheck(ClothesCheck clothesCheck) {
		this.clothesCheck = clothesCheck;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getProductStatus() {
		return this.productStatus;
	}

	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}

	public Set getClothesCartItems() {
		return this.clothesCartItems;
	}

	public void setClothesCartItems(Set clothesCartItems) {
		this.clothesCartItems = clothesCartItems;
	}

	public Set getClothesSubscribeItems() {
		return this.clothesSubscribeItems;
	}

	public void setClothesSubscribeItems(Set clothesSubscribeItems) {
		this.clothesSubscribeItems = clothesSubscribeItems;
	}

}