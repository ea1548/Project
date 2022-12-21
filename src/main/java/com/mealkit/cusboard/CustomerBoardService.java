package com.mealkit.cusboard;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mealkit.paging.Criteria;

@Service
public interface CustomerBoardService {
	
	//정보공유 게시글 작성
	void customerBoardInsert(CustomerBoardVo customerBoardVo, Principal principal);
	
	// 정보공유 게시글 조회
	List<CustomerBoardVo> getCustomerBoardList(Criteria cri);
	
	// 게시글 총 갯수
	int listCount();
	
	// 정보공유 세부게시글 조회
	CustomerBoardVo customerBoardDetail(int cus_no);
	
	// 정보공유 게시글 수정
	void updateCustomerBoard(CustomerBoardVo customerBoardVo);
	
	// 정보공유 게시글 삭제
	void deleteCustomerBoard(int cus_no);


}
