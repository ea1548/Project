package com.mealkit.member;

import java.util.List;

import com.mealkit.paging.Criteria;

public interface MemberDao {

	void registerMember(MemberVo memberVo);

	List<MemberVo> getUserList(Criteria cri);

	void deleteMember(String member_id);
	
	//회원정보 수정
	MemberVo updateMember(MemberVo memberVo);
	
	//회원정보 조회
	MemberVo getMember(String member_id);

	int listCount();


}
