package com.clothes.model;

/**
 * ClothesPay entity. @author MyEclipse Persistence Tools
 */

public class ClothesPay implements java.io.Serializable {

	// Fields

	private Integer payId;
	private ClothesUser clothesUser;
	private Integer payStatus;
	private String payBank;
	private String payTransport;

	// Constructors

	/** default constructor */
	public ClothesPay() {
	}

	/** full constructor */
	public ClothesPay(ClothesUser clothesUser, Integer payStatus,
			String payBank, String payTransport) {
		this.clothesUser = clothesUser;
		this.payStatus = payStatus;
		this.payBank = payBank;
		this.payTransport = payTransport;
	}

	// Property accessors

	public Integer getPayId() {
		return this.payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	public ClothesUser getClothesUser() {
		return this.clothesUser;
	}

	public void setClothesUser(ClothesUser clothesUser) {
		this.clothesUser = clothesUser;
	}

	public Integer getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayBank() {
		return this.payBank;
	}

	public void setPayBank(String payBank) {
		this.payBank = payBank;
	}

	public String getPayTransport() {
		return this.payTransport;
	}

	public void setPayTransport(String payTransport) {
		this.payTransport = payTransport;
	}

}