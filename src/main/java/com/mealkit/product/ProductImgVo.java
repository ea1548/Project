package com.mealkit.product;



public class ProductImgVo {

	
	private int product_number;
	// 상품 번호
	
	private String product_name;
	// 상품 이름
	
	private int product_price;   
	// 상품 가격
		
	// 경로 
	private String uploadPath;
	
	// uuid 
	private String uuid;
	
	// 파일 이름 
	private String fileName;

	public ProductImgVo() {}
	public ProductImgVo(int product_number, String product_name, int product_price, String uploadPath, String uuid,
			String fileName) {
		super();
		this.product_number = product_number;
		this.product_name = product_name;
		this.product_price = product_price;
		this.uploadPath = uploadPath;
		this.uuid = uuid;
		this.fileName = fileName;
	}
	public int getProduct_number() {
		return product_number;
	}
	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		return "ProductImgVo [product_number=" + product_number + ", product_name=" + product_name + ", product_price="
				+ product_price + ", uploadPath=" + uploadPath + ", uuid=" + uuid + ", fileName=" + fileName + "]";
	}
	

	
	
}
