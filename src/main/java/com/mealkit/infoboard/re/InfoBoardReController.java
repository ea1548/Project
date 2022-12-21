package com.mealkit.infoboard.re;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoBoardReController {
	
	@Autowired
	InfoBoardReService infoBoardReService;

	// 게시판 댓글 작성
	@RequestMapping("/member/infoboard/replyInsert")
	public String replyInsert(InfoBoardReVo infoBoardReVo, Principal principal) {
		infoBoardReVo.setMember_id(principal.getName());
		infoBoardReService.replyInsert(infoBoardReVo);
		
		return "redirect:/member/infoboard/" + infoBoardReVo.getInfo_no();
	}
	
	// 댓글 수정 폼
	@RequestMapping("/member/infoReplyUpdateForm/{info_reply_no}")
	public String replyUpdateForm(@PathVariable("info_reply_no") int info_reply_no,
				Model model) {
		
		InfoBoardReVo infoBoardReVo = infoBoardReService.getReplyOne(info_reply_no);
		model.addAttribute("getReplyOne", infoBoardReVo);
		return "board/infoboard/replyUpdateView";
	}
	
	// 댓글 수정
	@RequestMapping("/member/infoReplyUpdate")
	public String replyUpdate(InfoBoardReVo infoBoardReVo) {

		infoBoardReService.replyUpdate(infoBoardReVo);
		return "redirect:/member/infoboard/" + infoBoardReVo.getInfo_no();
	}
	
	// 댓글 삭제
	@RequestMapping("/member/infoReplyDelete/{info_reply_no}")
	public String replyDelete(@PathVariable("info_reply_no") int info_reply_no,
			Model model) {
		InfoBoardReVo infoBoardReVo = infoBoardReService.getReplyOne(info_reply_no);
		infoBoardReService.replyDelete(info_reply_no);
		return "redirect:/member/infoboard/" + infoBoardReVo.getInfo_no();
	}	
}
