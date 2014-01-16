package com.clothes.model;

import java.util.HashSet;
import java.util.Set;

/**
 * ClothesUser entity. @author MyEclipse Persistence Tools
 */

public class ClothesUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userAccount;
	private String userName;
	private String userPassword;
	private String userAddress;
	private String userEmail;
	private String userSex;
	private Integer userPhone;
	private Integer userStatus;
	private Set clothesCarts = new HashSet(0);
	private Set clothesSubscribes = new HashSet(0);
	private Set clothesPaies = new HashSet(0);

	// Constructors

	/** default constructor */
	public ClothesUser() {
	}

	/** minimal constructor */
	public ClothesUser(String userAccount, String userName,
			String userPassword, String userAddress, String userEmail,
			String userSex, Integer userPhone) {
		this.userAccount = userAccount;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userSex = userSex;
		this.userPhone = userPhone;
	}

	/** full constructor */
	public ClothesUser(String userAccount, String userName,
			String userPassword, String userAddress, String userEmail,
			String userSex, Integer userPhone, Integer userStatus,
			Set clothesCarts, Set clothesSubscribes, Set clothesPaies) {
		this.userAccount = userAccount;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userSex = userSex;
		this.userPhone = userPhone;
		this.userStatus = userStatus;
		this.clothesCarts = clothesCarts;
		this.clothesSubscribes = clothesSubscribes;
		this.clothesPaies = clothesPaies;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(Integer userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Set getClothesCarts() {
		return this.clothesCarts;
	}

	public void setClothesCarts(Set clothesCarts) {
		this.clothesCarts = clothesCarts;
	}

	public Set getClothesSubscribes() {
		return this.clothesSubscribes;
	}

	public void setClothesSubscribes(Set clothesSubscribes) {
		this.clothesSubscribes = clothesSubscribes;
	}

	public Set getClothesPaies() {
		return this.clothesPaies;
	}

	public void setClothesPaies(Set clothesPaies) {
		this.clothesPaies = clothesPaies;
	}

}