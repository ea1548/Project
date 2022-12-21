package com.mealkit.address;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AddressService {
	
	//배송지 입력(저장)
	public void insertAddress(AddressVo vo, Principal principal);
	
	//배송지 목록 조회
	List<AddressVo> getAddressList();

	//배송지 변경
	AddressVo updateAddress(AddressVo vo);

	// 배송지 삭제
	public void deleteAddress(int address_member_no) throws Exception;
	
	// 배송지 변경 상세 페이지
	public List<AddressVo> getAddressOne(String member_id);

	public AddressVo getAddressOne2(int address_member_no);


}
