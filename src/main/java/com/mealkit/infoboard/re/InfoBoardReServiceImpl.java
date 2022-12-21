package com.mealkit.infoboard.re;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoBoardReServiceImpl implements InfoBoardReService {

	@Autowired
	private InfoBoardReDao infoBoardReDao;
	
	@Override
	public void replyInsert(InfoBoardReVo infoBoardReVo) {
		infoBoardReDao.replyInsert(infoBoardReVo);
		
	}

	@Override
	public List<InfoBoardReVo> getInfoReplyList(int info_no) {
		List<InfoBoardReVo> infoBoardReVo = infoBoardReDao.getInfoReplyList(info_no);
		return infoBoardReVo;
	}

	@Override
	public void replyUpdate(InfoBoardReVo infoBoardReVo) {
		infoBoardReDao.replyUpdate(infoBoardReVo);
		
	}

	@Override
	public InfoBoardReVo getReplyOne(int info_reply_no) {
		InfoBoardReVo infoBoardReVo = infoBoardReDao.getReplyOne(info_reply_no);
		return infoBoardReVo;
	}

	@Override
	public void replyDelete(int info_reply_no) {
		infoBoardReDao.replyDelete(info_reply_no);
		
	}

}
