package com.mealkit.product.korea;

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
public class KoreaController {


	@Autowired
	private ProductService productService;
		
	
	// 한식 리스트 페이지
	@RequestMapping("product/product_korea_list")
	public  String korea(ProductVo productVo, Model model, Criteria cri) {
		
		List<ProductVo> koreaList = productService.koreaList(cri);
		List<ProductImgVo> productImgList = productService.getProductImgList( cri);
		
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(productService.listCount());
		System.out.println(pageMaker.getTotalCount());
		
		
		
		System.out.println(productImgList); 				
		model.addAttribute("productImgList", productImgList);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("koreaList", koreaList);
		return "product/korea/product_korea_list";
	}
			
	// 한식 상세 페이지  
	@RequestMapping("/product/korea/detail/korea_detail")
	public String koreadetail(int product_number, Model model, Criteria cri) {
			
		ProductVo koreaInfo = productService.koreaInfo(product_number);
		
		System.out.println(koreaInfo);
			
			model.addAttribute("koreaInfo", koreaInfo);
			
			model.addAttribute("koreaInfo",productService.koreaInfo(product_number));

		return "product/korea/detail/korea_detail";
		}
			
			
			// �ѽ� -> ��ٱ���
			@PostMapping("product/product_korea_list")
			public String koreacart() {
				
				return "cart/cart";
			}

}
