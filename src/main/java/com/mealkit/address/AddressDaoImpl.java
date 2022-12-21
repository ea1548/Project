package com.mealkit.address;

import java.security.Principal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("AddressDao")
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 배송지 입력(별명저장)
	@Override
	public AddressVo insertAddress(AddressVo vo, Principal principal) {
		
		vo.setMember_id(principal.getName());
				
		System.out.println("확인" + principal.getName());
		sqlSession.insert("Address.insertAddress", vo);
		System.out.println("배송지 저장" + vo);
		
		return vo;
		}
	
	//배송지 목록 조회
	@Override
	public List<AddressVo> getAddressList() {

		List<AddressVo> addressList = sqlSession.selectList("Address.AddressList");
		
		return addressList;
	}

	
	// 배송지 변경
	@Override
	public AddressVo updateAddress(AddressVo vo) {
				
		System.out.println("Member_oldAddress = " + vo); //이전 배송지
		
		sqlSession.update("Address.updateAddress", vo);
		
		System.out.println("Member_newAddress = " + vo); //새로운 배송지

		
		return vo;
	}

	// 배송지 삭제(추후 수정예정)
	@Override
	public void deleteAddress(int member_address_no) {
		

		System.out.println("삭제 : " + member_address_no);
		
		sqlSession.delete("Address.deleteAddress", member_address_no);

	}
	
	// 배송지 변경 상세 페이지
	@Override
	public List<AddressVo> getAddressOne(String member_id) {
		List<AddressVo> vo = sqlSession.selectList("Address.getAddressOne", member_id);
		return vo;
	}

	@Override
	public AddressVo getAddressOne2(int address_member_no) {
		AddressVo vo = sqlSession.selectOne("Address.getAddressOne2", address_member_no);
		return vo;
	}


}
