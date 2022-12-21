package com.mealkit.freeboard;

import java.security.Principal;
import java.util.List;

public interface FreeBoardService {

	void boardInsert(FreeBoardVo freeBoardVo, Principal principal);
	
	//게시물 목록조회
	public List<FreeBoardVo> list(Standard standard) throws Exception;
	//게시물 총 갯수
	public int listCount() throws Exception;
	
	
	//게시물 조회
	public FreeBoardVo read(int free_no) throws Exception;
	
	//게시물 수정
	public void update(FreeBoardVo freeBoardVo) throws Exception;
	
	// 게시물 삭제
	public void delete(int free_no) throws Exception;
	
	
	
}
