package com.mealkit.admin;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mealkit.member.MemberService;
import com.mealkit.member.MemberVo;
import com.mealkit.paging.Criteria;
import com.mealkit.paging.PageMaker;



@Controller
@RequestMapping
public class AdminController {

	@Autowired
	private MemberService memberService;
	
	// 관리자 페이지 진입
	@RequestMapping("/admin/admin_main")
	public String adminmain() {
		return "/admin/admin_main";
	}
	
	@RequestMapping("/admin/userList")
	public String adminUserList(Model model, Criteria cri) {
		List<MemberVo> userList = memberService.getUserList(cri);
		model.addAttribute("userList", userList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberService.listCount());
		System.out.println(pageMaker.getTotalCount());
		model.addAttribute("pageMaker", pageMaker);
		
		return "/admin/userList";
	}
	
	@RequestMapping("/admin/deleteMember")
	public String deleteMember(@RequestParam String member_id) {
		
		memberService.deleteMember(member_id);
		
		return "redirect:/admin/userList";
	}
		
	
	

}