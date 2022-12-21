package com.mealkit.infoboard.re;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InfoBoardReDaoImpl implements InfoBoardReDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void replyInsert(InfoBoardReVo infoBoardReVo) {
		sqlSession.insert("InfoBoardRe.replyInsert", infoBoardReVo);
		
	}

	@Override
	public List<InfoBoardReVo> getInfoReplyList(int info_no) {
		
			List<InfoBoardReVo> infoBoardReVo = sqlSession.selectList("InfoBoardRe.getInfoReplyList", info_no);

		return infoBoardReVo;
	}

	@Override
	public void replyUpdate(InfoBoardReVo infoBoardReVo) {
		sqlSession.update("InfoBoardRe.replyUpdate", infoBoardReVo);
		
	}

	@Override
	public InfoBoardReVo getReplyOne(int info_reply_no) {
		
		InfoBoardReVo infoBoardReVo = sqlSession.selectOne("InfoBoardRe.getInfoReplyOne", info_reply_no);
		return infoBoardReVo;
	}

	@Override
	public void replyDelete(int info_reply_no) {
		sqlSession.delete("InfoBoardRe.replyDelete", info_reply_no);
		
	}

}
