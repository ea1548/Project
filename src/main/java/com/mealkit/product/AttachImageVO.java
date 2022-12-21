package com.mealkit.product;

public class AttachImageVO {
	
	// 경로 
	private String uploadPath;
	
	// uuid 
	private String uuid;
	
	// 파일 이름 
	private String fileName;
	
	// 상품 번호  
	private int product_number;

	
	public AttachImageVO() {
		// TODO Auto-generated constructor stub
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

	public Integer getProduct_number() {
		return product_number;
	}

	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}

	@Override
	public String toString() {
		return "AttachImageVO [uploadPath=" + uploadPath + ", uuid=" + uuid + ", fileName=" + fileName
				+ ", product_number=" + product_number + ", getUploadPath()=" + getUploadPath() + ", getUuid()="
				+ getUuid() + ", getFileName()=" + getFileName() + ", getProduct_number()=" + getProduct_number()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


	
	
	
	
	
}
