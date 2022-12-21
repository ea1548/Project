package com.mealkit.infoboard;

import java.security.Principal;
import java.util.List;

import com.mealkit.paging.Criteria;


public interface InfoBoardDao {

	void infoBoardInsert(InfoBoardVo infoBoardVo, Principal principal);

	List<InfoBoardVo> getInfoBoardList(Criteria cri);

	int listCount();
	
	InfoBoardVo infoBoardDetail(int info_no);

	void updateInfoBoard(InfoBoardVo infoBoardVo);

	void deleteInfoBoard(int info_no);


}
