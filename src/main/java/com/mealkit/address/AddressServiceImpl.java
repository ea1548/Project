package com.mealkit.address;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AddressService")
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao addressDao;
	
	// 배송지 입력(저장)
	@Override
	public void insertAddress(AddressVo vo, Principal principal) {
		
		System.out.println("데이터 저장");
		
		addressDao.insertAddress(vo, principal);
		
		System.out.println("데이터 저장" + vo);
	}
	
	// 배송지 목록 조회
	@Override
	public List<AddressVo> getAddressList() {
		
		System.out.println("배송지 목록 데이터 호출");
		
		List<AddressVo> addressList = addressDao.getAddressList();
		
		System.out.println("배송지 목록 출력" + addressList);
		
		return addressList;
	}
	

	//배송지 변경
	@Override
	public AddressVo updateAddress(AddressVo vo) {
		
		System.out.println("배송지 변경 전 : " + vo);
		
		addressDao.updateAddress(vo);
		
		System.out.println("배송지 변경 후 : " + vo);
		
		return vo;
	}

	//배송지 삭제
	@Override
	public void deleteAddress(int member_address_no) throws Exception {
		
		System.out.println("배송지 삭제 전 : " + member_address_no);
		
		addressDao.deleteAddress(member_address_no);
		
		System.out.println("배송지 삭제 후 : " + member_address_no);

	}
	
	// 배송지 변경 상세 페이지
	@Override
	public List<AddressVo> getAddressOne(String member_id) {
		List<AddressVo> vo = addressDao.getAddressOne(member_id);
		return vo;
	}

	@Override
	public AddressVo getAddressOne2(int address_member_no) {
		AddressVo vo = addressDao.getAddressOne2(address_member_no);
		return vo;
	}


}
