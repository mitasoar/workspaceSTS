package com.kh.teamprj.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.teamprj.service.BoardService;
import com.kh.teamprj.vo.BoardVO;
import com.kh.teamprj.vo.MemberVO;
import com.kh.teamprj.vo.PagingVO;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Resource(name="boardService")
	private BoardService boardService;
	
	@GetMapping("/boardWrite")
	public String boardWrite(Model model) {
		model.addAttribute("categoryList", boardService.selectBoardCategoryList());
		return "board/write";
	}
	
	@PostMapping("/boardWrite")
	@ResponseBody
	public void boardWrite(BoardVO board, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		board.setBoardWriter(member == null ? "MEM_1" : member.getMemNo());
		boardService.insertBoard(board);
	}
	
	@GetMapping("/boardList")
	public String boardList(Model model, String nowPage, String cateNo) {
		BoardVO board = new BoardVO();
		
		int total = boardService.countBoardList(cateNo);
		
		if (nowPage == null) {
			nowPage = "1";
		}
		
		board.setCateNo(cateNo);
		board.setPaging(new PagingVO(total, Integer.parseInt(nowPage)));
		
		model.addAttribute("boardPage", board);
		model.addAttribute("boardList", boardService.selectBoardListPaging(board));
		return "board/list";
	}
	
	
}
