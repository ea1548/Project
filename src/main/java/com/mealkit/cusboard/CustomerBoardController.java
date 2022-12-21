package com.mealkit.cusboard;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mealkit.cusboard.re.CustomerBoardReService;
import com.mealkit.cusboard.re.CustomerBoardReVo;
import com.mealkit.infoboard.re.InfoBoardReService;
import com.mealkit.infoboard.re.InfoBoardReVo;
import com.mealkit.paging.Criteria;
import com.mealkit.paging.PageMaker;


@Controller
public class CustomerBoardController {

	
	 @Autowired
	 private CustomerBoardService customerBoardService;
	  
	 @Autowired
	 private CustomerBoardReService customerBoardReService;
	  
	  
	  
	  //고객센터 목록
	  @RequestMapping("/member/customerboard") 
	  public String home(Model model, Criteria cri) { 
		  List<CustomerBoardVo> customerBoardList =
		  customerBoardService.getCustomerBoardList(cri);
		  
		  model.addAttribute("customerBoardList",customerBoardList);
	  
		  PageMaker pageMaker = new PageMaker(); pageMaker.setCri(cri);
		  pageMaker.setTotalCount(customerBoardService.listCount());
		  System.out.println(pageMaker.getTotalCount());
		  model.addAttribute("pageMaker", pageMaker);
	  
	  	return "board/cusboard/home"; 
	  }
	  
	 //고객센터 게시판 등록 폼
	  
	  @RequestMapping("/member/customerWriteForm") 
	  public String write() { 
		  return "board/cusboard/write";
	  }
	  
	  // 고객센터 게시판 등록
	  
	  @RequestMapping("/member/cuswrite") 
	  public ModelAndView write(CustomerBoardVo customerBoardVo, Principal principal ) {
	  // 새글 저장
		customerBoardService.customerBoardInsert( customerBoardVo, principal );
	  
		ModelAndView mv = new ModelAndView();
	  	mv.setViewName("redirect:/member/customerboard"); 
	  	return mv; 
	  }
	  
	  // 정보공유 게시판 상세페이지
	  
	  @RequestMapping("/member/customerboard/{cus_no}")
	  public String infoBoardDetail(Model model, @PathVariable("cus_no") int cus_no) { 
		  CustomerBoardVo customerBoardDetail = customerBoardService.customerBoardDetail(cus_no);
		  model.addAttribute("customerBoardDetail", customerBoardDetail);
	  
		  List<CustomerBoardReVo> getCustomerReplyList = customerBoardReService.getCustomerReplyList(cus_no);
		  model.addAttribute("getCustomerReplyList", getCustomerReplyList); 
		  return "board/cusboard/readView"; 
	  }
	  
	  // 고객센터 게시판 수정
	  @RequestMapping("/member/customerBoardUpdateForm/{cus_no}") 
	  public String update(Model model, @PathVariable("cus_no") int cus_no) {
	  
	  CustomerBoardVo customerBoardDetail = customerBoardService.customerBoardDetail(cus_no);
	  
	  model.addAttribute("customerBoardDetail", customerBoardDetail);
	  
	  return "board/cusboard/updateView"; 
	  }
	  
	  // 정보공유 게시판 수정등록
	  
	  @RequestMapping("/member/customerBoardUpdate") 
	  public String updateSuccess(CustomerBoardVo customerBoardVo) throws Exception{
		  customerBoardService.updateCustomerBoard(customerBoardVo);
	  
	  	return "redirect:/member/customerboard/" + customerBoardVo.getCus_no(); 
	  }
	  
	  // 게시판 삭제
	  
	  @RequestMapping("/member/customerBoardDelete/{cus_no}")
	  public String delete(@PathVariable int cus_no) throws Exception{
	  
		  customerBoardService.deleteCustomerBoard(cus_no);
	  
	  return "redirect:/member/customerboard"; 
	  }
	 
}
