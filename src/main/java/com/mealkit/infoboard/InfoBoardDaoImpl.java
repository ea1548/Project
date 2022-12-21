package com.mealkit.infoboard;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mealkit.paging.Criteria;


@Repository
public class InfoBoardDaoImpl implements InfoBoardDao{

	
	  @Autowired SqlSession sqlSession;
	  
	  @Override public void infoBoardInsert(InfoBoardVo infoBoardVo, Principal
	  principal) { 
		  infoBoardVo.setMember_id(principal.getName());
	  sqlSession.insert("InfoBoard.InfoBoardInsert", infoBoardVo); 
	  }
	  
	  @Override public List<InfoBoardVo> getInfoBoardList(Criteria cri) {
		  List<InfoBoardVo> infoboardList =
	  sqlSession.selectList("InfoBoard.InfoBoardList", cri); return infoboardList;
	  }
	  
	  @Override public InfoBoardVo infoBoardDetail(int info_no) { 
		  InfoBoardVo infoBoardDetail = sqlSession.selectOne("InfoBoard.infoBoardDetail", info_no);
	  	return infoBoardDetail; 
	  }
	  
	  @Override public void updateInfoBoard(InfoBoardVo infoBoardVo) {
		  sqlSession.update("InfoBoard.infoBoardUpdate", infoBoardVo); 
	  }
	  
	  @Override public void deleteInfoBoard(int info_no) {
		  sqlSession.delete("InfoBoard.deleteinfoBoard", info_no);
	  }
	  
	  @Override
	  public int listCount() {
	  
		  return sqlSession.selectOne("InfoBoard.listCount"); 
	  }
	 
}
