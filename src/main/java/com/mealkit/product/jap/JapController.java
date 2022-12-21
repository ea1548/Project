package com.mealkit.product.jap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mealkit.foodpaging.Criteria;
import com.mealkit.foodpaging.PageMaker;
import com.mealkit.product.ProductImgVo;
import com.mealkit.product.ProductService;
import com.mealkit.product.ProductVo;

@RequestMapping
@Controller
public class JapController {
	
	
	@Autowired
	private ProductService productService;
	
		
	
	// 일식 분류 페이지
	@RequestMapping("product/product_jap_list")
	public  String jap(ProductVo productVo, Model model, Criteria cri) {
		
		List<ProductVo> japList = productService.japList(cri);
		List<ProductImgVo> japImgList = productService.japImgList(cri);
		model.addAttribute("japImgList", japImgList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(productService.listJapCount());
		System.out.println(pageMaker.getTotalCount());
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("japList", japList);
		return "product/jap/product_jap_list";
	}
			
	// 일식 상세 페이지	   
	@RequestMapping("/product/jap/detail/jap_detail")
	public String japdetail(int product_number, Model model) {
				ProductVo japInfo = productService.koreaInfo(product_number);
				System.out.println(japInfo);
				model.addAttribute("japInfo", japInfo);

				model.addAttribute("japInfo",productService.japInfo(product_number));
				
		return "product/jap/detail/jap_detail";
	}
			
			
	
		// �씪�떇 -> �옣諛붽뎄�땲
			@PostMapping("product/product_jap_list")
			public String japcart() {
				
				return "cart/cart";
			}
}
