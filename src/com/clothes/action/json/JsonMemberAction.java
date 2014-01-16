package com.clothes.action.json;

import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.clothes.model.ClothesUser;
import com.clothes.service.ClothesUserService;
import com.opensymphony.xwork2.ActionSupport;

public class JsonMemberAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	// 訊息傳送
	//JSON格式 //需加入@JSON(serialize = false)
	private String result;
	private Object object;
	private List<Object> list;
	private Map<String, Object> map;
	//JSON格式  //需加入@JSON(serialize = false)
	//非JSON格式
	private String email;
	private ClothesUserService clothesUserService;
	private ClothesUser clothesUser;
	//非JSON格式
	
	public String checkEmail() {
		ClothesUser member = clothesUserService.getClothesUserByEmail(email);
		
		if(member != null) {
			result = "error";
		} else {
			result = "success";
		}
		return "success";
	}
	@JSON(serialize = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@JSON(serialize = false)
	public ClothesUserService getClothesUserService() {
		return clothesUserService;
	}

	public void setClothesUserService(ClothesUserService clothesUserService) {
		this.clothesUserService = clothesUserService;
	}
	@JSON(serialize = false)
	public ClothesUser getClothesUser() {
		return clothesUser;
	}

	public void setClothesUser(ClothesUser clothesUser) {
		this.clothesUser = clothesUser;
	}
	@JSON(serialize = false)
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
	
	
	
}
