package com.mealkit.address;

import java.security.Principal;
import java.util.List;

public interface AddressDao {
	
	// 배송지 입력(저장)
	AddressVo insertAddress(AddressVo vo, Principal principal);
	
	// 배송지 목록 조회
	List<AddressVo> getAddressList();

	// 배송지 변경
	AddressVo updateAddress(AddressVo vo);
	
	// 배송지 삭제
	public void deleteAddress(int member_address_no) throws Exception;
	
	// 배송지 변경 상세 페이지
	List<AddressVo> getAddressOne(String member_id);

	AddressVo getAddressOne2(int address_member_no);


	
}
