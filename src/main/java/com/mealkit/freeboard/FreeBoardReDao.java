package com.mealkit.freeboard;

import java.security.Principal;
import java.util.List;

public interface FreeBoardReDao {
	//조회
	public List<FreeBoardReVo> readFreeReply(int free_no) throws Exception;
	
	//입력
	public void writeFreeReply (FreeBoardReVo freeBoardReVo, Principal principal ) throws Exception;

	//댓글 수정
	public void updateFreeReply(FreeBoardReVo freeBoardReVo)throws Exception;
	
	//댓글 삭제
	public void deleteFreeReply(int free_reply_no)throws Exception;
	
	//선택된 댓글 조회
	public FreeBoardReVo selectFreeReply(int free_reply_no) throws Exception;
	
	
}
