package com.clothes.model;

/**
 * ClothesSubscribe entity. @author MyEclipse Persistence Tools
 */

public class ClothesSubscribe implements java.io.Serializable {

	// Fields

	private Integer subscribeId;
	private ClothesUser clothesUser;
	private String subscribeAddress;
	private Integer subscribeStatus;
	private String subscribeName;
	private String subscribePhone;
	private String subscribeEmail;

	// Constructors

	/** default constructor */
	public ClothesSubscribe() {
	}

	/** full constructor */
	public ClothesSubscribe(ClothesUser clothesUser, String subscribeAddress,
			Integer subscribeStatus, String subscribeName,
			String subscribePhone, String subscribeEmail) {
		this.clothesUser = clothesUser;
		this.subscribeAddress = subscribeAddress;
		this.subscribeStatus = subscribeStatus;
		this.subscribeName = subscribeName;
		this.subscribePhone = subscribePhone;
		this.subscribeEmail = subscribeEmail;
	}

	// Property accessors

	public Integer getSubscribeId() {
		return this.subscribeId;
	}

	public void setSubscribeId(Integer subscribeId) {
		this.subscribeId = subscribeId;
	}

	public ClothesUser getClothesUser() {
		return this.clothesUser;
	}

	public void setClothesUser(ClothesUser clothesUser) {
		this.clothesUser = clothesUser;
	}

	public String getSubscribeAddress() {
		return this.subscribeAddress;
	}

	public void setSubscribeAddress(String subscribeAddress) {
		this.subscribeAddress = subscribeAddress;
	}

	public Integer getSubscribeStatus() {
		return this.subscribeStatus;
	}

	public void setSubscribeStatus(Integer subscribeStatus) {
		this.subscribeStatus = subscribeStatus;
	}

	public String getSubscribeName() {
		return this.subscribeName;
	}

	public void setSubscribeName(String subscribeName) {
		this.subscribeName = subscribeName;
	}

	public String getSubscribePhone() {
		return this.subscribePhone;
	}

	public void setSubscribePhone(String subscribePhone) {
		this.subscribePhone = subscribePhone;
	}

	public String getSubscribeEmail() {
		return this.subscribeEmail;
	}

	public void setSubscribeEmail(String subscribeEmail) {
		this.subscribeEmail = subscribeEmail;
	}

}