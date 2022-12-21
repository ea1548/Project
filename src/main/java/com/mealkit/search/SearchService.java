package com.mealkit.search;

import java.util.List;



public interface SearchService {
	
	// 검색
	//public SearchVo searchinfo(String product_name);
	
	 public  List<SearchVo> searchinfo(String keyword);
}
