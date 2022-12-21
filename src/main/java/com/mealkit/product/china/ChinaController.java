package com.mealkit.product.china;

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
public class ChinaController {
	
	
	@Autowired
	private ProductService productService;
	
		
	
	// 중식 분류 페이지
	@RequestMapping("product/product_china_list")
	public  String china(ProductVo productVo, Model model, Criteria cri) {
		
		List<ProductVo> chinaList = productService.chinaList(cri);
		List<ProductImgVo> chinaImgList = productService.chinaImgList(cri);
		
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(productService.listChinaCount());
		System.out.println(pageMaker.getTotalCount());
		
		 				
		model.addAttribute("chinaImgList", chinaImgList);					
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("chinaList", chinaList);
		return "product/china/product_china_list";
	}
			
	// 중식 상세 페이지	   
	@RequestMapping("/product/china/detail/china_detail")
	public String chinadetail(int product_number, Model model) {
				ProductVo chinaInfo = productService.chinaInfo(product_number);
				System.out.println(chinaInfo);
				model.addAttribute("chinaInfo", chinaInfo);
		return "product/china/detail/china_detail";
	}
			
			
	
		
}
