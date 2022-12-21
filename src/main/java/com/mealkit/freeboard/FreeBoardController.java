package com.mealkit.freeboard;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.JsonObject;

@Controller
public class FreeBoardController {
	

	@Autowired
	private  FreeBoardService freeBoardService;
	
	@Autowired
	private  FreeBoardReService freeBoardReService;
	
	
	//게시판 목록조회
	@RequestMapping("/member/freeboard")
	public  String  home(Model model, Standard standard)throws Exception {
		
		model.addAttribute("freeBoardList", freeBoardService.list(standard));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setstandard(standard);
		pageMaker.setTotalCount(freeBoardService.listCount());
		
		model.addAttribute("pageMaker", pageMaker);
		System.out.println("뭘까" + pageMaker);
		return "board/freeboard/home";
	}
	
	
	@RequestMapping("member/userwrite")
	public  String  write() {
		return "board/freeboard/write";
	}
	
	@RequestMapping("member/write")
	public  ModelAndView  write(  FreeBoardVo freeBoardVo, Principal principal ) {
		// 새글 저장
		freeBoardVo.setMember_id(principal.getName());
		freeBoardService.boardInsert ( freeBoardVo, principal );
		
		ModelAndView  mv = new ModelAndView();
		mv.setViewName("redirect:/member/freeboard");
		return  mv;
	}
	
	
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
		
		
		//댓글 작성
		@RequestMapping(value="/writeFreeReply", method = RequestMethod.POST)
		public String replyWrite(FreeBoardReVo freeBoardReVo , Principal principal ) throws Exception {
			
			
			freeBoardReService.writeFreeReply(freeBoardReVo, principal);
			System.out.println("테스트"+freeBoardReVo.getFree_no());
			int number = freeBoardReVo.getFree_no();
			return "redirect:/freeboard/readView?free_no=" + number;
					
		}
		
		//댓글 수정 GET
		@RequestMapping(value="/board/freeboard/replyFreeUpdateView", method = RequestMethod.GET)
		public String replyUpdateView(FreeBoardReVo freeBoardReVo, Model model) throws Exception {
			
			
			model.addAttribute("replyFreeUpdate", freeBoardReService.selectFreeReply(freeBoardReVo.getFree_reply_no()));
			model.addAttribute("freeBoardReVo", freeBoardReVo);
			System.out.println(freeBoardReVo);
			
			return "board/freeboard/replyFreeUpdateView";
		}
		
		//댓글 수정 POST
		@RequestMapping(value="/board/freeboard/replyFreeUpdate", method = RequestMethod.POST)
		public String replyUpdate(FreeBoardReVo freeBoardReVo, RedirectAttributes rttr) throws Exception {
			
			
			freeBoardReService.updateFreeReply(freeBoardReVo);
			System.out.println("뭐가들었니" + freeBoardReVo);
			rttr.addAttribute("Free_no", freeBoardReVo.getFree_no());
			
			
			return "redirect:/freeboard/readView";
		}
			
		//댓글 삭제
		@RequestMapping(value="/board/freeboard/replyFreeDeleteView")
		public String replyDelete(int free_reply_no, int free_no) throws Exception {
			
			freeBoardReService.deleteFreeReply(free_reply_no);
			return "redirect:/freeboard/readView?free_no=" + free_no;
		}
		

		// 게시판 수정뷰
		@RequestMapping(value = "/updateView", method = RequestMethod.GET)
		public String updateView(FreeBoardVo freeboardVo, Model model) throws Exception{
			
			
			model.addAttribute("update", freeBoardService.read(freeboardVo.getFree_no()));
			
			return "board/freeboard/updateView";
		}
		
		// 게시판 수정
		@RequestMapping(value = "/FreeBoard/update", method = RequestMethod.POST)
		public String update(FreeBoardVo freeboardVo) throws Exception{
			
			System.out.println("컨트롤러 업데이트");
			freeBoardService.update(freeboardVo);
			
			return "redirect:/member/freeboard";
		}

		// 게시판 삭제
		@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public String delete(FreeBoardVo freeboardVo) throws Exception{
			
			
			freeBoardService.delete(freeboardVo.getFree_no());
			
			return "redirect:/member/freeboard";
		}
		
		
	
}

