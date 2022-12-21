package com.mealkit.freeboard;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FreeBoardReDaoImpl implements FreeBoardReDao {
	
	@Autowired SqlSession sqlSession;

	@Override
	public List<FreeBoardReVo> readFreeReply(int free_no) throws Exception {
		System.out.println("확인용" + free_no);
		
			List<FreeBoardReVo> freeBoardReVo = sqlSession.selectList("freeReplyMapper.readFreeReply",free_no);
			System.out.println("다오임플" + freeBoardReVo);
		return freeBoardReVo;
	}

	@Override
	public void writeFreeReply(FreeBoardReVo freeBoardReVo, Principal principal) throws Exception {
		freeBoardReVo.setMember_id(principal.getName());
		System.out.println("123" + freeBoardReVo);
		sqlSession.insert("freeReplyMapper.writeFreeReply", freeBoardReVo);
		System.out.println("12313" + principal.getName());
		
	}
	//댓글 수정
	@Override
	public void updateFreeReply(FreeBoardReVo freeBoardVo)throws Exception{
		sqlSession.update("freeReplyMapper.updateFreeReply", freeBoardVo);
		}
	
	//댓글 삭제
	@Override
	public void deleteFreeReply(int free_reply_no)throws Exception{
		sqlSession.delete("freeReplyMapper.deleteFreeReply", free_reply_no);
		
	}
	//선택된 댓글 조회
	@Override
	public FreeBoardReVo selectFreeReply(int free_reply_no)throws Exception{
		return sqlSession.selectOne("freeReplyMapper.selectFreeReply", free_reply_no);
	}
	
}
