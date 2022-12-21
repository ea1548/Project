package com.mealkit.product.event;

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
public class EventController {
	
	
	@Autowired
	private ProductService productService;
	
		
	
	// 이벤트식 분류 페이지
	@RequestMapping("product/product_event_list")
	public  String event(ProductVo productVo, Model model, Criteria cri) {
		
		List<ProductVo> eventList = productService.eventList(cri);
		List<ProductImgVo> eventImgList = productService.eventImgList(cri);
		model.addAttribute("eventImgList", eventImgList);
		
		
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(productService.listEventCount());
		System.out.println(pageMaker.getTotalCount());
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("eventList", eventList);
		return "product/event/product_event_list";
	}
			
	// 이벤트식 상세 페이지	   
	@RequestMapping("/product/event/detail/event_detail")
	public String eventdetail(int product_number, Model model) {
				ProductVo eventInfo = productService.eventInfo(product_number);
				System.out.println(eventInfo);
				model.addAttribute("eventInfo", eventInfo);
				model.addAttribute("eventInfo",productService.eventInfo(product_number));
		return "product/event/detail/event_detail";
	}
			
			
	
		
}
