package com.clothes.user;


import java.util.List;

import com.clothes.action.BaseActionSupport;
import com.clothes.model.ClothesCheck;
import com.clothes.service.ClothesCartItemService;
import com.clothes.service.ClothesCartService;
import com.clothes.service.ClothesCheckService;
import com.clothes.service.ClothesPayService;
import com.clothes.service.ClothesProductService;
import com.clothes.service.ClothesSubscribeItemService;
import com.clothes.service.ClothesSubscribeService;
import com.clothes.service.ClothesUserService;

public class CategoryAction extends BaseActionSupport{
	/**
	 * 
	 */
	// 訊息傳送
	private ClothesCheckService clothesCheckService;
	private ClothesProductService clothesProductService;
	private ClothesUserService clothesUserService;
	private ClothesCartItemService clothesCartItemService;
	private ClothesCartService clothesCartService;
	private ClothesPayService clothesPayService;
	private ClothesSubscribeService clothesSubscribeService;
	private ClothesSubscribeItemService clothesSubscribeItemService;
	// 訊息傳送	
	private String message;
	private String modName;
	private String modifyState;
	private ClothesCheck clothesCheck;
	private List<ClothesCheck> clothesChecks;
	private int checkId;
	private String checkName;
	private int checkStatus;

	private int categoryId;

	
/*	public String modifyState() throws Exception {//modify category status
		initServlet();
		try {
			if(checkbox.size() == 0) {
				message = "沒有選取要修改的類別。";
				resultPage = "main";
			} else {
				for(int i = 0; i < checkbox.size(); i++) {
					ClothesCheck category = clothesCheckService.getClothesCheck(checkbox.get(i));
					category.setCategoryState(modifyState);
					category.setCategoryModId(sessionAdminId());
					category.setCategoryModTime(TimeUtil.getTimeStamp(new Date()));
					clothesCheckService.updateclothesCheck(category);
				}
				checkbox.clear();
				resultPage = main();
				message = "狀態修改成功。";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}*/
	
	public String addCategory() throws Exception { // link to add.jsp
		initServlet();
		try {
			if (clothesCheck != null) clothesCheck = null;//清空舊資料
			resultPage = "adminCategory";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
	
	public String saveCategory() throws Exception { // add NEW category information
		initServlet();
		try {
			//clothesCheck.setCategoryAddTime(TimeUtil.getTimeStamp(new Date()));
			clothesCheckService.saveClothesCheck(clothesCheck);
			message = "類別: [ " + clothesCheck.getCheckName() + " ]新增成功!";
			if(clothesCheck != null) clothesCheck = null; //清除資料
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkList();
	}
	
	public String checkList() {
		clothesChecks = clothesCheckService.getAllClothesCheck();
		return "Checkcategory";
	}	

	public String modifyCategory() throws Exception { // modify admin information
		initServlet();
		try {
			clothesCheckService.updateClothesCheck(clothesCheck);
			clothesChecks = clothesCheckService.getAllClothesCheck();
			message = "商品類別資料已經修改。";
			if(clothesCheck != null) clothesCheck = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "categoryedit";
	}
	
	public String jumpedit(){
		clothesCheck = clothesCheckService.getClothesCheckById(checkId);
		return "changeedit";		
	}
	
	public String detailCategory() throws Exception {//link to admin_edit.jsp
		initServlet();
		try {
			clothesCheck = clothesCheckService.getClothesCheckById(checkId);
			resultPage = "detailCategory";	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
/*	public String edit() throws Exception { //link to edit.jsp
		try {
			initServlet();
			ezCategory = ezCategoryService.getEzCategory(categoryId);
			if(ezCategory.getCategoryModId() != null && !"".equals(ezCategory.getCategoryModId())) {
				modName = ezAdminService.getEzAdmin(ezCategory.getCategoryModId()).getAdminName();
			} else {
				modName = null;
			}
			resultPage = "edit";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}*/	
	public String deleteCategory() throws Exception { // delete category information
		try {
			initServlet();
			ClothesCheck check = clothesCheckService.getClothesCheckById(checkId);
			clothesCheckService.deleteClothesCheck(check);
			message = "類別: [ " + check.getCheckName() + " ] 已經刪除。";
			if(clothesCheck != null) clothesCheck = null;
			clothesChecks = clothesCheckService.getAllClothesCheck();
		} catch (Exception e) {
			message = "無法刪除，此類別正在被使用中。";
			e.printStackTrace();
		}
		return "categorydelete";
	}
	public String jumpdelete(){
		clothesCheck = clothesCheckService.getClothesCheckById(checkId);
		return "changedelete";		
	}
	
	private int sessionAdminId() {//return session admin id
		return Integer.valueOf(session.getAttribute("loginAdmin").toString());
	}
	
	
	// 超連結-回首頁
		public String jumpjacket() throws Exception {
			System.out.println("start jumpjacket..");
			return "Categoryjacket";
		}
		public String changejacket() throws Exception {
			System.out.println("start changejacket..");
			return "Categoryjacket";
		}
		
	// 超連結-回首頁
		public String jumpshopedit() throws Exception {
			clothesChecks = clothesCheckService.getAllClothesCheck();
			System.out.println("start jumpshopedit..");
			return "shopedit";
		}
		public String jumpCategory() throws Exception {
			System.out.println("start jumpCategory..");
			return "adminCategory";
		}

//getter and setter
		
	public ClothesCheckService getClothesCheckService() {
		return clothesCheckService;
	}
	public List<ClothesCheck> getClothesChecks() {
		return clothesChecks;
	}

	public void setClothesChecks(List<ClothesCheck> clothesChecks) {
		this.clothesChecks = clothesChecks;
	}

	public ClothesCheck getClothesCheck() {
		return clothesCheck;
	}

	public void setClothesCheck(ClothesCheck clothesCheck) {
		this.clothesCheck = clothesCheck;
	}

	public int getCheckId() {
		return checkId;
	}

	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setClothesCheckService(ClothesCheckService clothesCheckService) {
		this.clothesCheckService = clothesCheckService;
	}
	public ClothesProductService getClothesProductService() {
		return clothesProductService;
	}
	public void setClothesProductService(ClothesProductService clothesProductService) {
		this.clothesProductService = clothesProductService;
	}
	public ClothesUserService getClothesUserService() {
		return clothesUserService;
	}
	public void setClothesUserService(ClothesUserService clothesUserService) {
		this.clothesUserService = clothesUserService;
	}

	public String getModName() {
		return modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public String getModifyState() {
		return modifyState;
	}

	public void setModifyState(String modifyState) {
		this.modifyState = modifyState;
	}

	public ClothesCartItemService getClothesCartItemService() {
		return clothesCartItemService;
	}

	public void setClothesCartItemService(
			ClothesCartItemService clothesCartItemService) {
		this.clothesCartItemService = clothesCartItemService;
	}

	public ClothesCartService getClothesCartService() {
		return clothesCartService;
	}

	public void setClothesCartService(ClothesCartService clothesCartService) {
		this.clothesCartService = clothesCartService;
	}

	public ClothesPayService getClothesPayService() {
		return clothesPayService;
	}

	public void setClothesPayService(ClothesPayService clothesPayService) {
		this.clothesPayService = clothesPayService;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public int getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(int checkStatus) {
		this.checkStatus = checkStatus;
	}

	public ClothesSubscribeService getClothesSubscribeService() {
		return clothesSubscribeService;
	}

	public void setClothesSubscribeService(
			ClothesSubscribeService clothesSubscribeService) {
		this.clothesSubscribeService = clothesSubscribeService;
	}

	public ClothesSubscribeItemService getClothesSubscribeItemService() {
		return clothesSubscribeItemService;
	}

	public void setClothesSubscribeItemService(
			ClothesSubscribeItemService clothesSubscribeItemService) {
		this.clothesSubscribeItemService = clothesSubscribeItemService;
	}

	
	
}
