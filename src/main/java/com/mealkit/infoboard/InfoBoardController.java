package com.mealkit.infoboard;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mealkit.infoboard.re.InfoBoardReService;
import com.mealkit.infoboard.re.InfoBoardReVo;
import com.mealkit.paging.Criteria;
import com.mealkit.paging.PageMaker;


@Controller
public class InfoBoardController {

	@Autowired
	private  InfoBoardService infoBoardService;
	
	@Autowired
	private InfoBoardReService infoBoardReService;
	
	
	
	// 정보공유 게시판 목록	
	@RequestMapping("/member/infoboard")
	public  String  home(Model model, Criteria cri) {
		List<InfoBoardVo> infoBoardList = infoBoardService.getInfoBoardList(cri);
		model.addAttribute("infoBoardList", infoBoardList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(infoBoardService.listCount());
		System.out.println(pageMaker.getTotalCount());
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/infoboard/home";
	}
	
	// 정보공유 게시판 등록 폼
	@RequestMapping("/member/infoWriteForm")
	public  String  write() {
		return "board/infoboard/write";
	}
	
	// 정보공유 게시판 등록
	@RequestMapping("/member/infowrite")
	public  ModelAndView  write(  InfoBoardVo infoBoardVo, Principal principal ) {
		// 새글 저장
		
		infoBoardService.infoBoardInsert( infoBoardVo, principal );
		
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("redirect:/member/infoboard");
		return  mv;
	}
	
	// 정보공유 게시판 상세페이지
	@RequestMapping("/member/infoboard/{info_no}")
	public  String  infoBoardDetail(Model model, 
			@PathVariable("info_no") int info_no) {
		InfoBoardVo infoBoardDetail = infoBoardService.infoBoardDetail(info_no);
		model.addAttribute("infoBoardDetail", infoBoardDetail);
		
		List<InfoBoardReVo> getInfoReplyList = infoBoardReService.getInfoReplyList(info_no);
		model.addAttribute("getInfoReplyList", getInfoReplyList);
		return "board/infoboard/readView";
	}
	
	// 정보공유 게시판 수정
	@RequestMapping("/member/infoBoardUpdateForm/{info_no}")
	public String update(Model model, @PathVariable("info_no") int info_no) {

		InfoBoardVo infoBoardDetail = infoBoardService.infoBoardDetail(info_no);
		model.addAttribute("infoBoardDetail", infoBoardDetail);
		return "board/infoboard/updateView";
	}
	
	// 정보공유 게시판 수정등록
	@RequestMapping("/member/infoBoardUpdate")
	public String updateSuccess(InfoBoardVo infoBoardVo) throws Exception{
		infoBoardService.updateInfoBoard(infoBoardVo);

		return "redirect:/member/infoboard/" + infoBoardVo.getInfo_no();
	}
	
	// 게시판 삭제
	@RequestMapping("/member/infoBoardDelete/{info_no}")
	public String delete(@PathVariable int info_no) throws Exception{
		
		infoBoardService.deleteInfoBoard(info_no);
				
		return "redirect:/member/infoboard";
	}
		
	/*
	// 게시판 조회
		@RequestMapping(value = "freeboard/readView", method = RequestMethod.GET)
		public String read(FreeBoardVo freeBoardVo, Model model) throws Exception{
			
			
			model.addAttribute("read", freeBoardService.read(freeBoardVo.getFree_no()));
			
			//댓글 조회
			List<FreeBoardReVo> freeReplyList = freeBoardReService.readFreeReply(freeBoardVo.getFree_no());
			System.out.println("답글 + " + freeReplyList);
			model.addAttribute("freeReplyList", freeReplyList);
			
			return "board/freeboard/readView";
		}
		
		 */
}
