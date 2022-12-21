package com.mealkit.product.cart;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	//장바구니 저장
	@PostMapping("/CartAdd")
	public String addCart(CartVo cart, Principal principal) throws Exception {
		
		System.out.println(principal.getName());
		
		cartService.addCart(cart, principal);
		
		System.out.println("장바구니 저장 서비스 진입");
		
		return "redirect:/CartList?member_id=" + cart.getMember_id();
	}
	
	//장바구니 목록(정보)조회 + 다른 아이디로 접근했을때 기능 실행
	@GetMapping("/CartList")
	public String cartList(String member_id, Model model, Principal principal) {
		
		List<CartVo> cartList = cartService.getCartList();
		List<CartVo> cartList2 = cartService.getCartList2(member_id);
		int cartSum = cartService.getCartSum(principal);
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("cartListDifferent", cartList2);
		System.out.println("난 카트 썸" + cartSum);
		model.addAttribute("cartSum", cartSum);
		
		System.out.println("진입");
		
		return "cart/cart";
	}
	
	//장바구니 수량 변경(수정 안되면 기능 삭제)
	@PostMapping("/CartUpdate")
	public String updateCartCount(CartVo cart) {
		
		cartService.modifyCount(cart);
		
		return "redirect:/cart/" + cart.getMember_id();
	}
	
	//장바구니 삭제(데이터 삭제)
	@RequestMapping(value = "/CartDelete", method = RequestMethod.GET)
	public String cartDelete(int cart_no, Principal principal) throws Exception {
		System.out.println("삭제 서비스 진입");
		CartVo cart = cartService.deleteCart2(cart_no); //다른 아이디로 접근했을때 삭제허용
					  cartService.deleteCart(cart_no);
		
		return "redirect:/CartList?member_id="+ principal.getName();
	}
	
	@RequestMapping("/DeleteCart")
	public String deleteCart(Principal principal) {
		
		
		return "cart/CartSucccess";
	}
	
	
	
}
