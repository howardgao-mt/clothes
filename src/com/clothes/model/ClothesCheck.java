package com.clothes.model;

import java.util.HashSet;
import java.util.Set;

/**
 * ClothesCheck entity. @author MyEclipse Persistence Tools
 */

public class ClothesCheck implements java.io.Serializable {

	// Fields

	private Integer checkId;
	private String checkName;
	private Integer checkStatus;
	private Set clothesProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public ClothesCheck() {
	}

	/** minimal constructor */
	public ClothesCheck(String checkName, Integer checkStatus) {
		this.checkName = checkName;
		this.checkStatus = checkStatus;
	}

	/** full constructor */
	public ClothesCheck(String checkName, Integer checkStatus,
			Set clothesProducts) {
		this.checkName = checkName;
		this.checkStatus = checkStatus;
		this.clothesProducts = clothesProducts;
	}

	// Property accessors

	public Integer getCheckId() {
		return this.checkId;
	}

	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}

	public String getCheckName() {
		return this.checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public Integer getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Set getClothesProducts() {
		return this.clothesProducts;
	}

	public void setClothesProducts(Set clothesProducts) {
		this.clothesProducts = clothesProducts;
	}

}