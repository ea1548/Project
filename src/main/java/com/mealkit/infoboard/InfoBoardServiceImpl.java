package com.mealkit.infoboard;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mealkit.paging.Criteria;

@Service
public class InfoBoardServiceImpl implements InfoBoardService{
	
	@Autowired
	private InfoBoardDao infoBoardDao;
	
	@Override
	public void infoBoardInsert(InfoBoardVo infoBoardVo, Principal principal) {
		infoBoardDao.infoBoardInsert(infoBoardVo, principal);
		
	}

	@Override
	public List<InfoBoardVo> getInfoBoardList(Criteria cri) {
		//List<InfoBoardVo> infoBoardList = infoBoardDao.getInfoBoardList(cri);		
		return infoBoardDao.getInfoBoardList(cri);
	}

	@Override
	public int listCount() {
		
		return infoBoardDao.listCount();
	}
	
	@Override
	public InfoBoardVo infoBoardDetail(int info_no) {
		InfoBoardVo infoBoardDetail = infoBoardDao.infoBoardDetail(info_no);
		return infoBoardDetail;
	}

	@Override
	public void updateInfoBoard(InfoBoardVo infoBoardVo) {
		infoBoardDao.updateInfoBoard(infoBoardVo);
	}

	@Override
	public void deleteInfoBoard(int info_no) {
		infoBoardDao.deleteInfoBoard(info_no);
		
	}


}
