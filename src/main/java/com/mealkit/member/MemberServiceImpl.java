package com.mealkit.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mealkit.paging.Criteria;


@Service("mainService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void registerMember(MemberVo memberVo) {
		memberDao.registerMember(memberVo);
		
	}

	@Override
	public List<MemberVo> getUserList(Criteria cri) {
		List<MemberVo> userList =  memberDao.getUserList(cri);
		return    userList;
	}

	@Override
	public void deleteMember(String member_id) {
		memberDao.deleteMember(member_id);
		
	}
	
	//회원정보 출력
	@Override
	public MemberVo getMember(String member_id) {
		MemberVo vo = memberDao.getMember(member_id);
		return vo;
	}
	
	//회원정보 수정
	@Override
	public MemberVo updateMember(MemberVo vo) {
		
		memberDao.updateMember(vo);
		
		return vo;
		
	}

	@Override
	public int listCount() {
		
		return memberDao.listCount();
	}

}
