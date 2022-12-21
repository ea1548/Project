package com.mealkit.product;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;

import com.mealkit.foodpaging.Criteria;





@Repository("productDao")
public class ProductDaoImpl implements ProductDao {


	@Autowired
	private  SqlSession sqlSession;
	
	// 상품추가
	@Override
	public void ProductEnroll(ProductVo product) {

		sqlSession.insert("Product.ProductEnroll", product );	
	}

	// 이미지 등록
		@Override
		public void imageEnroll(AttachImageVO vo) {
			
			
			sqlSession.insert("Product.imageEnroll", vo );
			
		}
		
		// 이미지 정보 반환
		@Override
		public List<AttachImageVO> getAttachList(
				int product_number)
				 {
			
			List<AttachImageVO>	list = sqlSession.selectList("Product.ProductList");
			System.out.println("이미지 "+ list);
			
			return list;
		}



		
		//  이미지 붙이기
		@Override
		public List<AttachImageVO> getAttachInfo(int product_number) {
			 List<AttachImageVO> img = sqlSession.selectList("Product.img");
				return img;
			}

		
		
		// 상품 수정
		@Override
		public void Modifyproduct(ProductVo productVo) {
			System.out.println(productVo);
			sqlSession.update("Product.Modifyproduct", productVo); 
			
		}

		
		//상품 수정 정보
		@Override
		public ProductVo updateDetail(int product_number) {
			
			return sqlSession.selectOne("Product.updateDetail", product_number);
		}

	
			
			
			
		
			

		// 상품 목록
		@Override
		public List<ProductVo> productGetList() {
			
			List<ProductVo> productList = sqlSession.selectList("Product.ProductList");	
			
			
		
			return  productList;
		}
		
		

		// 상품삭제
		@Override
		public int deleteproduct(int product_number) {
			
			System.out.println("삭제 ");
			
			
			return sqlSession.delete("Product.deleteProduct", product_number);
			
		}
		//상품 정보
		
		@Override
		public List<ProductImgVo> getProductInfolist(int product_number){
			
			 List<ProductImgVo> getProductInfolist =  sqlSession.selectList("Product.koreaList");
			
			return getProductInfolist;
		}
	
		


		// 한식  리스트 정보
		@Override
		public List<ProductImgVo> getProductImgList(Criteria cri ) {
			System.out.println("2");
			List<ProductImgVo> productImgList = sqlSession.selectList("Product.koreaList",cri); 
			return productImgList;
		}

		
		// 한식 상세 페이지
		@Override
		public ProductVo koreaInfo(		int product_number) {
			
			ProductVo korea = sqlSession.selectOne("Product.koreaInfo",  product_number);
			
			return korea;
		}
		
		
		//한식 페이지
		@Override
		public List<ProductVo> koreaList(Criteria cri) {
			List<ProductVo> koreaList = sqlSession.selectList("Product.koreapaging", cri);
			return koreaList;
		}
		
		//한식 페이징
		@Override
		public int listCount() {
			
			 return sqlSession.selectOne("Product.listCount"); 
		}
		
		
		
		
		
		
		
		
		// 중식 리스트 정보
		@Override
		public List<ProductImgVo> chinaImgList(Criteria cri) {
			List<ProductImgVo> chinaImgList = sqlSession.selectList("Product.chinaList", cri);
			return chinaImgList;
		}

		// 중식 상세 페이지
		@Override
		public ProductVo chinaInfo(int product_number) {
			
			ProductVo productVo = sqlSession.selectOne("Product.chinaInfo", product_number);
			
			return productVo;
		}


		//중식 페이지
		@Override
		public List<ProductVo> chinaList(Criteria cri) {
			List<ProductVo> chinaList = sqlSession.selectList("Product.chinapaging", cri);
			return chinaList;
		}
		
		//중식 페이징
		@Override
		public int listChinaCount() {
			
			return sqlSession.selectOne("Product.listChinaCount"); 
		}

	
		
		
		
		
		
		// 일식 리스트 정보
		@Override
		public List<ProductImgVo> japImgList(Criteria cri) {
			List<ProductImgVo> japImgList = sqlSession.selectList("Product.japList", cri);
			return japImgList;
		}
		
		
		// 일식 상세 페이지
		@Override
		public ProductVo japInfo(int product_number) {
			
			ProductVo productVo = sqlSession.selectOne("Product.japInfo", product_number);
			
			return productVo;
		}
		
		
		//일식 페이지
		@Override
		public List<ProductVo> japList(Criteria cri) {
			List<ProductVo> japList = sqlSession.selectList("Product.jappaging", cri);
					return japList;
			}
				
		//일식 페이징
		@Override
		public int listJapCount() {
					
			return sqlSession.selectOne("Product.listJapCount");
			}		
		
		
		
		
		
		
		
		
		// 양식 리스트 정보
		@Override
		public List<ProductImgVo> euImgList(Criteria cri) {
			List<ProductImgVo> euImgList = sqlSession.selectList("Product.euList",cri);
			return euImgList;
		}
		
		// 양식 상세 페이지
		@Override
		public ProductVo euInfo(int product_number) {
			
			ProductVo productVo = sqlSession.selectOne("Product.euInfo", product_number);
			
			return productVo;
		}
		
		
		
		

		//양식 페이지
		@Override
		public List<ProductVo> euList(Criteria cri) {
			List<ProductVo> euList = sqlSession.selectList("Product.eupaging", cri);
			return euList;
		}
		
		// 양식 페이징
		@Override
		public int listEuCount() {
			
			return sqlSession.selectOne("Product.listEuCount");
		}

	
		
		
		
		
		
		
		// 이벤트식 리스트 정보
		@Override
		public List<ProductImgVo> eventImgList(Criteria cri) {
			List<ProductImgVo> eventImgList = sqlSession.selectList("Product.eventList",cri);
			return eventImgList;
		}
		
		// 이벤트 상세 페이지
		@Override
		public ProductVo eventInfo(int product_number) {
			
			ProductVo productVo = sqlSession.selectOne("Product.eventInfo", product_number);
			
			return productVo;
		}
		
		
		//이벤트 페이지
		@Override
		public List<ProductVo> eventList(Criteria cri) {
			List<ProductVo> eventList = sqlSession.selectList("Product.eventList", cri);
			return eventList;
		}

		// 이벤트 페이징
		@Override
		public int listEventCount() {
			
			return sqlSession.selectOne("Product.listEventCount");
		}
		
		
		


	

		@Override
		public List<ProductVo> cateselect() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public List<ProductImgVo> mainImgList() {
			
			return sqlSession.selectList("Product.mainImgList");
		}


		

		




	

	

	
	

	

}
