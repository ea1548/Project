package com.mealkit.address;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	//배송지 입력(저장)
	@PostMapping("/AddressInsert")
	public String insertAddress(AddressVo vo,Principal principal) throws Exception {
		System.out.println(principal.getName());
		addressService.insertAddress(vo, principal);

		
		System.out.println("확인" + vo + principal);
		
		return "redirect:/AddressList?member_id=" + vo.getMember_id();
	}
	
	// 배송지 목록 조회
	@GetMapping("/AddressList")
	public String addressList(String member_id,Model model) throws Exception {
		
		List<AddressVo> addressList = addressService.getAddressList(); 
		List<AddressVo> addressOne = addressService.getAddressOne(member_id);
		// 확장 for문 or forEach문 자주쓰임
//		for(AddressVo address : addressList) {  // :뒤에 열거형 (List) 객체
//			address.(필드명) 등등
//		}
//		for(int i = 0; i < addressList.size(); i++) {
//			
//		}
		
// 일반적인 for문과 동일한 효과 확장for문은 db에서 해당 데이터를 다 출력할때 일반 for문은 정해준 값만 출력		
		
		
		model.addAttribute("addressList", addressList);
		model.addAttribute("addressOne", addressOne);
		return "address/AddressList";
	}
	
	// 배송지 정보 변경
	@RequestMapping(value = "/AddressUpdate", method = RequestMethod.GET)
	public String addressUpdate(int address_member_no, Model model) throws Exception {
		AddressVo addressOne = addressService.getAddressOne2(address_member_no);
		model.addAttribute("addressOne", addressOne);
		return "address/AddressModify"; 
	}
	
	//배송지 정보 삭제
	@RequestMapping(value = "/AddressDelete", method = RequestMethod.GET)
	public String addressDelete(int address_member_no) throws Exception { 
		System.out.println("삭제 :  서비스로 진입");
		AddressVo vo = addressService.getAddressOne2(address_member_no);
		addressService.deleteAddress(address_member_no); //다른 아이디로 접근했을때 삭제허용
		
		return "redirect:/AddressList?member_id=" + vo.getMember_id();
			
	}
	
	//배송지 정보 상세 변경 페이지
	@RequestMapping("/AddressModify")
	public String addressModify(AddressVo vo) {
		addressService.updateAddress(vo);
		AddressVo vo2 = addressService.getAddressOne2(vo.getMember_address_no());
		System.out.println("나는 vo2 : " + vo2.getMember_id());
		return "redirect:/AddressList?member_id=" + vo2.getMember_id(); 
	}

}
