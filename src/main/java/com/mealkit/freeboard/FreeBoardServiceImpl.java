package com.mealkit.freeboard;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FreeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService{

	@Autowired
	private  FreeBoardDao freeBoardDao;
	
	
	public void boardInsert(FreeBoardVo freeBoardVo, Principal principal) {
		
		freeBoardDao.freeBoardInsert( freeBoardVo, principal );
		
	}

	//게시물 목록조회
	@Override
	public List<FreeBoardVo> list(Standard standard)throws Exception {
		
				
		return freeBoardDao.list(standard);
	}


	@Override
	public FreeBoardVo read(int free_no) throws Exception {
		
		return freeBoardDao.read(free_no);
	}

	@Override
	public void update(FreeBoardVo freeBoardVo) throws Exception {
		
		freeBoardDao.update(freeBoardVo);
	}


	@Override
	public void delete(int free_no) throws Exception {
		
		freeBoardDao.delete(free_no);
	}

	@Override
	public int listCount() throws Exception {
		
		return freeBoardDao.listCount();
				
	}


	

		
}


	

