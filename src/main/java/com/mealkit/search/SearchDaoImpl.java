package com.mealkit.search;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("SearchDao")
public class SearchDaoImpl implements SearchDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<SearchVo> searchinfo(String keyword){
		
		List<SearchVo> searchVo = sqlSession.selectList("Search.searchinfo", keyword);
		
		
		return searchVo;
		
	}
	

	
}
