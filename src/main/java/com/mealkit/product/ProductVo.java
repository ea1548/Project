package com.mealkit.product;




import java.util.List;




public class ProductVo {

	// 상품 테이블
	private int product_number;
	// 상품 번호
	
	private String product_name;
	// 상품 이름
	
	private int product_price;   
	// 상품 가격
	
	private int product_stock; 
	// 상품 재고
	
	private String product_desc;
	//상품 설명
	
	private String category_code;
	//분류코드
	
	
	private AttachImageVO attachImageVO;
	 // 이미지 정보
	
	private List<AttachImageVO> imageList;
	
	
	public ProductVo() {}
	
	
	//경로
	private String uploadPath  ;
	
	// uuid
	private String uuid ; 
	
	// 파일 이름
	private String fileName ;
	
	
	
	
	
	
	
	public ProductVo(int product_number, String product_name, int product_price, int product_stock,
			String product_desc, String category_code, AttachImageVO attachImageVO, List<AttachImageVO> imageList,
			String uploadPath, String uuid, String fileName) {
		super();
		this.product_number = product_number;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_stock = product_stock;
		this.product_desc = product_desc;
		this.category_code = category_code;
		this.attachImageVO = attachImageVO;
		this.imageList = imageList;
		this.uploadPath = uploadPath;
		this.uuid = uuid;
		this.fileName = fileName;
	}

	public Integer getProduct_number() {
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

	public Integer getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public Integer getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public AttachImageVO getAttachImageVO() {
		return attachImageVO;
	}

	public void setAttachImageVO(AttachImageVO attachImageVO) {
		this.attachImageVO = attachImageVO;
	}

	public List<AttachImageVO> getImageList() {
		return imageList;
	}

	public void setImageList(List<AttachImageVO> imageList) {
		this.imageList = imageList;
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
		return "ProductVo [product_number=" + product_number + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_stock=" + product_stock + ", product_desc=" + product_desc
				+ ", category_code=" + category_code + ", attachImageVO=" + attachImageVO + ", imageList=" + imageList
				+ ", uploadPath=" + uploadPath + ", uuid=" + uuid + ", fileName=" + fileName + "]";
	}

	
	
	
	
	
	


	

	
	
}
