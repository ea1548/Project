package com.mealkit.cusboard.re;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerBoardReController {
	
	
	  @Autowired
	  private CustomerBoardReService customerBoardReService;
	  
	  // 게시판 댓글 작성
	  
	  @RequestMapping("/member/customerboard/replyInsert")
	  public String replyInsert(CustomerBoardReVo customerBoardReVo) {

		  customerBoardReService.replyInsert(customerBoardReVo);
	  
	  	  return "redirect:/member/customerboard/" + customerBoardReVo.getCus_no(); 
	  }
	  
	  // 댓글 수정 폼
	  
	  @RequestMapping("/member/customerReplyUpdateForm/{customer_reply_no}")
	  public String replyUpdateForm(@PathVariable("customer_reply_no") int customer_reply_no, 
			  Model model) {
	  
		  CustomerBoardReVo customerBoardReVo =
		  customerBoardReService.getReplyOne(customer_reply_no);
		  model.addAttribute("getReplyOne", customerBoardReVo); 
		  return "board/cusboard/replyUpdateView"; 
	  }
	  
	 // 댓글 수정
	  
	  @RequestMapping("/member/customerReplyUpdate")
	  public String replyUpdate(CustomerBoardReVo customerBoardReVo) {
		  System.out.println(customerBoardReVo);
		  customerBoardReService.replyUpdate(customerBoardReVo); 
		  return "redirect:/member/customerboard/" + customerBoardReVo.getCus_no(); 
	  }
	  
	 // 댓글 삭제
	  
	  @RequestMapping("/member/customerReplyDelete/{customer_reply_no}")
	  public String replyDelete(@PathVariable("customer_reply_no") int customer_reply_no,
			  Model model) {
		  CustomerBoardReVo customerBoardReVo = customerBoardReService.getReplyOne(customer_reply_no);
		  customerBoardReService.replyDelete(customer_reply_no); 
		  
		  return "redirect:/member/customerboard/" + customerBoardReVo.getCus_no(); 
		  
	  }
	 
}
