package com.mealkit.product.cart;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SqlSession sqlSession;
	
	//카트 추가
	@Override
	public CartVo addCart(CartVo vo, Principal principal) {
		
		System.out.println("Dao 진입 : " + principal.getName() + vo);
		
		vo.setMember_id(principal.getName());

		sqlSession.insert("Cart.cartAdd", vo);
		
		return vo;
	}

	//카트 삭제
	@Override
	public void deleteCart(int cart_no) throws Exception {
		
		sqlSession.delete("Cart.deleteCart", cart_no);
		
		System.out.println("카트 삭제 : " + cart_no);
		
	}

	//다른아이디로 들어왔을때 카트 삭제
	public CartVo deleteCart2(int cart_no) {
		
		CartVo vo = sqlSession.selectOne("Cart.deleteCart2", cart_no);
		
		System.out.println("카트 삭제 : " + cart_no);
		
		return vo;
	}

	//카트 수량 수정 
	public int modifyCount(CartVo cart) {
		//수정 예정
		return 0;
	}

	//카트 목록 
	public List<CartVo> getCartList() {
	
		List<CartVo> cartList = sqlSession.selectList("Cart.CartList");
		
		return cartList;
	}

	//다른 아이디로 접근했을때의 카트 목록
	public List<CartVo> getCartList2(String member_id) {
		
		List<CartVo> vo = sqlSession.selectList("Cart.CartList2", member_id);
		
		return vo;
	}

	@Override
	public int getCartSum(Principal principal) {

		return sqlSession.selectOne("Cart.getCartSum", principal.getName());
	}

}
