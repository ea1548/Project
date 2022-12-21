package com.mealkit.product.cart;

import java.security.Principal;
import java.util.List;

public interface CartDao {
	
	//카트 추가
	CartVo addCart(CartVo vo, Principal principal);
	
	//카트 삭제
	public void deleteCart(int cart_no) throws Exception;
	
	//다른아이디로 들어왔을때 카트 삭제
	CartVo deleteCart2(int cart_no);
	
	//카트 수량 수정 
	public int modifyCount(CartVo cart);
	
	//카트 목록 
	public List<CartVo> getCartList();	
	
	//다른 아이디로 접근했을때의 카트 목록
	public List<CartVo> getCartList2(String member_id);

	int getCartSum(Principal principal);

}
