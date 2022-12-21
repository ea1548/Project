package com.mealkit.product;


public class ProductCategory {
	
	 //  상품 분류
	private String category_code;	
	// primary key  상품 코드
	
	private String category_name; 
	// 분류 이름
	
	public ProductCategory() {}
	
	public ProductCategory(
			String category_code,
			String category_name			
			) {
		this.category_code = category_code;
		this.category_name = category_name;
	}
	
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
	@Override
	public String toString() {
		return "ProductCategory [category_code=" + category_code + ", category_name=" + category_name + "]";
	}
	
}
