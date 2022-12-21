package com.mealkit.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.mealkit.paging.Criteria;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private  SqlSession sqlSession;
	
	@Override
	public void registerMember(MemberVo memberVo) {
		memberVo.setMember_pwd(pe.encode(memberVo.getMember_pwd()));
		sqlSession.insert("Member.Register", memberVo);
	}

	@Override
	public List<MemberVo> getUserList(Criteria cri) {

		List<MemberVo>  userList  =  sqlSession.selectList("Member.UserList", cri);

		return  userList;
	
	}

	@Override
	public void deleteMember(String member_id) {
		sqlSession.delete("Member.deleteMember", member_id);
	}
	
	// 회원정보 수정(비밀번호, 이메일, 전화번호)
	@Override
	public MemberVo updateMember(MemberVo memberVo) {
		System.out.println("업데이트 시작");
		String mempwd= pe.encode(memberVo.getMember_npwd());
		memberVo.setMember_pwd(mempwd);
		System.out.println("mempwd = " + mempwd);
		sqlSession.update("Member.updateMember", memberVo);
		System.out.println("업데이트 종료");
		
		return memberVo;
	}
	// 회원정보 출력
	@Override
	public MemberVo getMember(String member_id) {
		MemberVo vo = sqlSession.selectOne("Member.GetMember", member_id);
		
		System.out.println("회원정보 출력 : " + member_id);
		return vo;
	}

	@Override
	public int listCount() {
		
		return sqlSession.selectOne("Member.listCount");
	}
	

}
