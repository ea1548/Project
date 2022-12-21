package com.mealkit.freeboard;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardReServiceImpl implements FreeBoardReService {

	@Autowired 
	private FreeBoardReDao freeBoardReDao;
	
	@Override
	public List<FreeBoardReVo> readFreeReply(int free_no) throws Exception {
		List<FreeBoardReVo> freeBoardReVo = freeBoardReDao.readFreeReply(free_no);
		return freeBoardReVo;
	}

	@Override
	public void writeFreeReply(FreeBoardReVo freeBoardReVo , Principal principal ) throws Exception {
		freeBoardReDao.writeFreeReply(freeBoardReVo, principal);
		
	}
	//댓글수정
	@Override
	public void updateFreeReply(FreeBoardReVo freeBoardReVo) throws Exception {
		freeBoardReDao.updateFreeReply(freeBoardReVo);
		
	}

	@Override
	public void deleteFreeReply(int free_reply_no) throws Exception {
		freeBoardReDao.deleteFreeReply(free_reply_no);
		
	}

	@Override
	public FreeBoardReVo selectFreeReply(int free_reply_no) throws Exception {
		
		return freeBoardReDao.selectFreeReply(free_reply_no);
	}

}
