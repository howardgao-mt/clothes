package com.clothes.user;



import java.util.List;

import com.clothes.action.BaseActionSupport;
import com.clothes.model.ClothesCheck;
import com.clothes.model.ClothesProduct;
import com.clothes.service.ClothesCartItemService;
import com.clothes.service.ClothesCartService;
import com.clothes.service.ClothesCheckService;
import com.clothes.service.ClothesPayService;
import com.clothes.service.ClothesProductService;
import com.clothes.service.ClothesSubscribeItemService;
import com.clothes.service.ClothesSubscribeService;
import com.clothes.service.ClothesUserService;


public class ProductAction extends BaseActionSupport{
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
	
	private String productname;
	private String productprice;
	private String productdescription;
	private String checkid;
	private int productId;
	private int productStatus;
	private String chkName;
	
	private ClothesProduct clothesProduct;
	private List<ClothesProduct> clothesProducts;
	private ClothesCheck clothesCheck;
	private List<ClothesCheck> clothesChecks;
	public String addproduct() throws Exception {//link to add.jsp
		initServlet();
		try {
			if (clothesProduct != null) clothesProduct = null;//清空舊資料
			clothesChecks = clothesCheckService.getAllClothesCheck();
			resultPage = "shopedit";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}
	public String productSave() throws Exception {//add new product information
		initServlet();
		try {
			ClothesCheck model = clothesCheckService.getClothesCheckById(Integer.valueOf(checkid));
			clothesProduct.setClothesCheck(model);
			clothesProductService.saveClothesProduct(clothesProduct);
			message = " 商品: [ " + clothesProduct.getProductName() + " ] 新增成功! ";
			if (clothesProduct != null) clothesProduct = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList();
	}
	
	public String productList() {
		clothesProducts = clothesProductService.getAllClothesProduct();
		return "success";
	}
	// 超連結-跳到adminproduct
	public String jumpadminProduct() throws Exception {
		clothesProducts = clothesProductService.getAllClothesProduct();
		System.out.println("start jumpadminProduct..");
		return "adminProduct";
	}
	
	public String modifyProduct() throws Exception { // modify information
		initServlet();
		try {					
			clothesProducts = clothesProductService.getAllClothesProduct();
			ClothesCheck check = clothesCheckService.getClothesCheckById(Integer.valueOf(checkid));
			clothesProduct.setClothesCheck(check);
			clothesProductService.updateClothesProduct(clothesProduct);
			clothesProducts = clothesProductService.getAllClothesProduct();

			message = "商品資料已經修改。";
			if(clothesProduct != null) clothesProduct = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "productedit";
	}
	
	public String jumpproductedit(){
		clothesProduct = clothesProductService.getClothesProductById(productId);
		clothesChecks = clothesCheckService.getAllClothesCheck();

		return "changeproductedit";		
	}
	
	public String detailProduct() throws Exception {//link to admin_edit.jsp
		initServlet();
		try {
			clothesProduct = clothesProductService.getClothesProductById(productId);
			resultPage = "detailProduct";	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultPage;
	}	
	public String deleteProduct() throws Exception { // delete product information
		try {
			initServlet();
			ClothesProduct product = clothesProductService.getClothesProductById(productId);
			clothesProductService.deleteClothesProduct(product);
			message = "商品: [ " + product.getProductName() + " ] 已經刪除。";
			if(clothesProduct != null) clothesProduct = null;
			clothesProducts = clothesProductService.getAllClothesProduct();
		} catch (Exception e) {
			message = "無法刪除，此商品正在被選取中。";
			e.printStackTrace();
		}
		return "productdelete";
	}
	public String jumpproductdelete(){
		clothesProduct = clothesProductService.getClothesProductById(productId);

		return "changeproductdelete";		
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductprice() {
		return productprice;
	}

	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}

	public String getCheckid() {
		return checkid;
	}

	public void setCheckid(String checkid) {
		this.checkid = checkid;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public ClothesProduct getClothesProduct() {
		return clothesProduct;
	}

	public void setClothesProduct(ClothesProduct clothesProduct) {
		this.clothesProduct = clothesProduct;
	}

	public ClothesCheckService getClothesCheckService() {
		return clothesCheckService;
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

	public List<ClothesProduct> getClothesProducts() {
		return clothesProducts;
	}

	public void setClothesProducts(List<ClothesProduct> clothesProducts) {
		this.clothesProducts = clothesProducts;
	}
	public ClothesCheck getClothesCheck() {
		return clothesCheck;
	}
	public void setClothesCheck(ClothesCheck clothesCheck) {
		this.clothesCheck = clothesCheck;
	}
	public List<ClothesCheck> getClothesChecks() {
		return clothesChecks;
	}
	public void setClothesChecks(List<ClothesCheck> clothesChecks) {
		this.clothesChecks = clothesChecks;
	}
	public String getChkName() {
		return chkName;
	}
	public void setChkName(String chkName) {
		this.chkName = chkName;
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
