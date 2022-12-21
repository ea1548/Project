package com.mealkit.infoboard;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mealkit.paging.Criteria;

@Service
public interface InfoBoardService {
	
	// 정보공유 게시글 작성
	void infoBoardInsert(InfoBoardVo infoBoardVo, Principal principal);
	
	// 정보공유 게시글 조회
	List<InfoBoardVo> getInfoBoardList(Criteria cri);
	
	// 게시글 총 갯수
	int listCount();
	
	// 정보공유 세부게시글 조회
	InfoBoardVo infoBoardDetail(int info_no);
	
	// 정보공유 게시글 수정
	void updateInfoBoard(InfoBoardVo infoBoardVo);
	
	// 정보공유 게시글 삭제
	void deleteInfoBoard(int info_no);


}
