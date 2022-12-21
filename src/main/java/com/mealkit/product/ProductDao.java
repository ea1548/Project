package com.mealkit.product;


import java.util.List;

import com.mealkit.foodpaging.Criteria;



public interface ProductDao {

	 // 상품 추가
	 public void ProductEnroll(ProductVo product);
	
	 //상품 목록
	 public List<ProductVo> productGetList();
	 
	 //상품 수정
	 public void Modifyproduct(ProductVo productVo);
	 
	 // 상품수정 정보
	 public ProductVo updateDetail(int product_number);
		

	 //상품 삭제	
	 public int deleteproduct(int product_number);
	 
	
	 //상품 분류된 페이지 ( 한식, 일식, 중식...)
	 public List<ProductVo> cateselect();

		
		//이미지 등록	
	 	public void imageEnroll(AttachImageVO vo);
			
		//  이미지 정보 반환	
		public List<AttachImageVO> getAttachList(int product_number);

		// 상품 정보
		public  List<ProductImgVo> getProductInfolist(int product_number);
		
			 	 
		//  지정 상품 이미지 정보 얻기
		
		public List<AttachImageVO> getAttachInfo(int product_number);

		//  상품 리스트 페이지 정보
		
		// 한식 리스트
		public List<ProductImgVo> getProductImgList(Criteria cri);
	 

		//한식페이지
		public List<ProductVo> koreaList(Criteria cri);
		 
		//한식 페이징
		public int listCount();

		
		
		
		
		// 중식 리스트
		public List<ProductImgVo> chinaImgList(Criteria cri);
		
		
		 
		//중식 페이지
	 	public List<ProductVo> chinaList(Criteria cri);
	 	 
	 	//중식 페이징
	 	public int listChinaCount();

		
		
		
		
		
		// 일식 리스트
		public List<ProductImgVo> japImgList(Criteria cri);
		
		
	 	//일식페이지
	 	public List<ProductVo> japList(Criteria cri);
	 	 
	 	//일식 페이징
	 	public int listJapCount();
		
		
		
		
		

		// 양식 리스트
		public List<ProductImgVo> euImgList(Criteria cri);
		
		
		//양식페이지
		public List<ProductVo> euList(Criteria cri); 
		 
		//양식 페이징
		public int listEuCount();
		 
		
		
		
		

		// 이벤트 리스트
		public List<ProductImgVo> eventImgList(Criteria cri);
 
		//이벤트
		public List<ProductVo> eventList(Criteria cri);
		 
		 //이벤트 페이징
		 public int listEventCount();
	 
	 
	 
	 


 	

	 
	// 한식 상세 페이지
	public  ProductVo koreaInfo(int product_number);

	// 중식 상세 페이지
	public ProductVo chinaInfo(int product_number);
	
	// 일식 상세 페이지
	public ProductVo japInfo(int product_number);

	// 양식 상세 페이지
	public ProductVo euInfo(int product_number);

	// 이벤트 상세 페이지
	public ProductVo eventInfo(int product_number);

	public List<ProductImgVo> mainImgList();

	

	

	

	

	
	 
	 
}
