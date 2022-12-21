package com.mealkit.infoboard.re;

import java.util.List;

public interface InfoBoardReService {

	void replyInsert(InfoBoardReVo infoBoardReVo);

	List<InfoBoardReVo> getInfoReplyList(int info_no);

	void replyUpdate(InfoBoardReVo infoBoardReVo);

	InfoBoardReVo getReplyOne(int info_reply_no);

	void replyDelete(int info_reply_no);

}
