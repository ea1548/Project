package com.mealkit.freeboard;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("freeBoardDao")
public class FreeBoardDaoImpl implements FreeBoardDao {
	@Autowired
	private  SqlSession sqlSession;
	

	
	public List<FreeBoardVo> getFreeBoardList() {
		List<FreeBoardVo>  freeboardList  
		   =  sqlSession.selectList("FreeBoard.FreeBoardList");
		return         freeboardList;
	}

	@Override
	public void freeBoardInsert(FreeBoardVo freeboardVo, Principal principal) {
		freeboardVo.setMember_id(principal.getName());
		sqlSession.insert("FreeBoard.FreeBoardInsert",freeboardVo);
	}

	@Override
	public FreeBoardVo read(int free_no) throws Exception {
		FreeBoardVo vo = sqlSession.selectOne("FreeBoard.read", free_no);
		return vo;
	}

	@Override
	public void update(FreeBoardVo freeboardVo) throws Exception {
		sqlSession.update("FreeBoard.update", freeboardVo);
		
	}

	@Override
	public void delete(int free_no) throws Exception {
		System.out.println("삭제시작" + free_no);
		
		sqlSession.delete("FreeBoard.delete", free_no);
		System.out.println("삭제종료");
	}
	//게시물 목록 조회
	@Override
	public List<FreeBoardVo> list(Standard standard) throws Exception {
		
		return sqlSession.selectList("FreeBoard.FreeBoardListPage",standard);
	}
	//게시글 총갯수
	@Override
	public int listCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("FreeBoard.listCount");
	}

	

	
}
