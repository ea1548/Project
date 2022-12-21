package com.mealkit.search;

import java.util.List;

public interface SearchDao {
	// 검색
	//SearchVo searchinfo(String product_name);
	public  List<SearchVo> searchinfo(String keyword);
}
