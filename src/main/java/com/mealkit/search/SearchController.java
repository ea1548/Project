package com.mealkit.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mealkit.product.ProductImgVo;
import com.mealkit.product.ProductVo;



@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/index/search")
	public String Search(SearchVo searchVo,String keyword, Model model) {
		
		
	
		
		List<SearchVo> searchinfo = searchService.searchinfo(keyword);
		System.out.println("12313213212331"+searchinfo);
		model.addAttribute("searchinfo", searchService.searchinfo(keyword));
		
		return "index/search";
	}
	
}
