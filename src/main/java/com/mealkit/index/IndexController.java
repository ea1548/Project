package com.mealkit.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mealkit.product.ProductImgVo;
import com.mealkit.product.ProductService;

@Controller
public class IndexController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		List<ProductImgVo> mainImgList = productService.mainImgList();
		model.addAttribute("mainImgList", mainImgList);
		System.out.println("메인리스트" + mainImgList);
		
		return "index/home";
	}
	
	@RequestMapping("/cart")
	public String cart() {
		return "cart/cart";
	}
	
	@GetMapping("/loginForm")
	public String login() {
		return "login/login";
	}
	
	@RequestMapping("/loginForm2")
	public String loginForm() {
		return "login/loginform";
	}
	

	
}
