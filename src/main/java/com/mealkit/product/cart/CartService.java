package com.mealkit.product.cart;

import java.security.Principal;
import java.util.List;


public interface CartService {
	
	//장바구니 추가
	public void addCart(CartVo vo, Principal principal);
	
	//장바구니 리스트
	public List<CartVo> getCartList();
	
	// 다른유저가 접근했을때의 배송지 리스트
	public List<CartVo> getCartList2(String member_id);
	
	//장바구니 수량 수정
	public int modifyCount(CartVo cart);
	
	//장바구니 삭제
	public void deleteCart(int cart_no) throws Exception;
	
	// 다른유저가 접근했을때의 배송지 삭제
	public CartVo deleteCart2(int cart_no);

	int getCartSum(Principal principal);
}
