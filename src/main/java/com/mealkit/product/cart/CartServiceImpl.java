package com.mealkit.product.cart;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	//장바구니 추가
	@Override
	public void addCart(CartVo vo, Principal principal) {
		
		cartDao.addCart(vo, principal);
		
	}
	
	//장바구니 목록
	@Override
	public List<CartVo> getCartList() {
		
		List<CartVo> cart = cartDao.getCartList();
		
		return cart;
	}
	
	//다른사용자가 접속했을때의 장바구니 목록
	@Override
	public  List<CartVo> getCartList2(String member_id) {
		
		List<CartVo> cart2 = cartDao.getCartList2(member_id);
		
		return cart2;
	}
	
	
	//장바구니 수량 변경
	@Override
	public int modifyCount(CartVo cart) {
		
		return cartDao.modifyCount(cart);
	}
	
	//장바구니 삭제
	public void deleteCart(int cart_no) throws Exception {
		
		System.out.println("삭제 전 : " + cart_no);
		
		cartDao.deleteCart(cart_no);
	}

	//다른아이디로 접근시 장바구니 삭제
	public CartVo deleteCart2(int cart_no) {
		
		CartVo vo = cartDao.deleteCart2(cart_no);
		
		return vo;
	}

	@Override
	public int getCartSum(Principal principal) {
		
		System.out.println("데이터 값 : " + principal);
		
		if(principal != null) {
			return cartDao.getCartSum(principal);
		} else {
			return cartDao.getCartSum(principal);
		}

	}


}
