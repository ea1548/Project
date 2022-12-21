package com.mealkit.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SearchService")
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SearchDao searchDao;
	
	@Override
	public List<SearchVo> searchinfo(String keyword) {
		List<SearchVo> searchinfo = searchDao.searchinfo(keyword);
		
		return searchinfo;
	}
}
