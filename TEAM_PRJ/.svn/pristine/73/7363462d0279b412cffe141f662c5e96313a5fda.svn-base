package com.kh.teamprj.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.teamprj.service.BoardService;
import com.kh.teamprj.vo.BoardCategoryVO;
import com.kh.teamprj.vo.BoardVO;
import com.kh.teamprj.vo.FileVO;
import com.kh.teamprj.vo.MemberVO;
import com.kh.teamprj.vo.PagingVO;
import com.kh.teamprj.vo.ReplyVO;


@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
    ServletContext servletContext;
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@GetMapping("/boardWrite")
	public String boardWrite(Model model) {
		model.addAttribute("categoryList", boardService.selectBoardCategoryList());
		return "board/write";
	}
	
	@PostMapping("/boardWrite")
	@ResponseBody
	public void boardWrite(BoardVO board, MultipartFile[] files, HttpSession session) throws IllegalStateException, IOException {
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		board.setBoardWriter(member == null ? "MEM_1" : member.getMemNo()); // 비 로그인 시 작성자 설정 (테스트용)
		
		if (files.length != 0) { // 첨부파일이 있을 때
			String realPath = "C:\\Git\\workspaceSTS\\TEAM_PRJ\\src\\main\\webapp\\resources\\upload"; // 파일 업로드 경로
			String today = new SimpleDateFormat("yyMMdd").format(new Date()); // 해당 날짜
	        String saveFolder = realPath + File.separator + today; // 폴더 경로
	        
	        File folder = new File(saveFolder); // 폴더 생성
	        
	        if(!folder.exists()) { // 해당 경로에 폴더가 없을 경우
	            folder.mkdirs(); // 폴더 생성
	        }
	        
	        List<FileVO> fileInfos = new ArrayList<FileVO>(); // 파일을 담을 리스트
	        
	        for (MultipartFile mfile : files) { // 파일 목록
	            FileVO fileVO = new FileVO(); // DB에 담을 파일VO 생성
	            String originalFileName = mfile.getOriginalFilename(); // 원본 파일명
	            
	            if (!originalFileName.isEmpty()) { // 원본 파일명이 있을 시
	                String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf('.')); // 저장 파일명 생성
	                fileVO.setSaveFolder(today); // 폴더명은 오늘 날짜
	                fileVO.setOriginFile(originalFileName); // 원본 파일명
	                fileVO.setSaveFile(saveFileName); // 저장 파일명
	                mfile.transferTo(new File(folder, saveFileName)); // 파일 업로드
	                fileInfos.add(fileVO); // 리스트에 담기
	            }
	        }
	        
	        board.setFileInfos(fileInfos); // DB에 저장하기 위한 파일 리스트 세팅
	        board.setFileCnt("" + fileInfos.size()); // DB에 저장하기 위한 파일 수 세팅
		}
        
		boardService.insertBoard(board);
	}
	
	@GetMapping("/download")
	public ModelAndView downloadFile(String sfolder, String ofile, String sfile, HttpSession session) {
//		MemberVO member = (MemberVO) session.getAttribute("loginInfo");
//	    if(member != null) {
	        Map<String, Object> fileInfo = new HashMap<String, Object>();
	        fileInfo.put("sfolder", sfolder);
	        fileInfo.put("ofile", ofile);
	        fileInfo.put("sfile", sfile);
	        return new ModelAndView("fileDownLoadView", "downloadFile", fileInfo);
//	    } else {
//	        return new ModelAndView("redirect:/");
//	    }
	}
	
	@GetMapping("/boardList")
	public String boardList(Model model, String nowPage, BoardVO board, ReplyVO reply) {
		if (nowPage == null) {
			nowPage = "1";
		}
		
		if ((reply.getReplyContent() != null && !reply.getReplyContent().equals("")) 
				|| (reply.getReplyWriter() != null && !reply.getReplyWriter().equals(""))) {
			board.setReply(reply);
		}
		
		int total = boardService.countBoardList(board);
		
		board.setPaging(new PagingVO(total, Integer.parseInt(nowPage)));
		
		model.addAttribute("boardPage", board);
		model.addAttribute("noticeList", boardService.selectNoticeBoardList(board.getCateNo()));
		model.addAttribute("boardList", boardService.selectBoardListPaging(board));
		
		return "board/list";
	}
	
	@GetMapping("/boardContent")
	public String boardContent(String boardNo, String nowPage, Model model) {
		BoardVO board = new BoardVO();
		
		int total = boardService.countReplyList(boardNo);
		
		if (nowPage == null) {
			nowPage = "1";
		}
		
		board.setBoardNo(boardNo);
		board.setPaging(new PagingVO(total, Integer.parseInt(nowPage)));
		board.setFileInfos(boardService.selectFileList(boardNo));
		
		model.addAttribute("boardPage", board);
		model.addAttribute("board", boardService.selectBoardOne(boardNo));
		
		return "board/content";
	}
	
	@PostMapping("/deleteBoard")
	@ResponseBody
	public void deleteBoard(String boardNo) {
		boardService.deleteBoardOne(boardNo);
	}
	
	@GetMapping("/editBoard")
	public String editBoard(String boardNo, Model model) {
		BoardVO board = boardService.selectBoardOne(boardNo);
		board.setFileInfos(boardService.selectFileList(boardNo));
		model.addAttribute("board", board);
		model.addAttribute("categoryList", boardService.selectBoardCategoryList());
		return "board/write";
	}

	@PostMapping("/editBoard")
	@ResponseBody
	public void editBoard(BoardVO board, MultipartFile[] files) throws IllegalStateException, IOException {
		if (files.length != 0) { // 첨부파일이 있을 때
			String realPath = "C:\\Git\\workspaceSTS\\TEAM_PRJ\\src\\main\\webapp\\resources\\upload"; // 파일 업로드 경로
			String today = new SimpleDateFormat("yyMMdd").format(new Date()); // 해당 날짜
	        String saveFolder = realPath + File.separator + today; // 폴더 경로
	        
	        File folder = new File(saveFolder); // 폴더 생성
	        
	        if(!folder.exists()) { // 해당 경로에 폴더가 없을 경우
	            folder.mkdirs(); // 폴더 생성
	        }
	        
	        List<FileVO> fileInfos = new ArrayList<FileVO>(); // 파일을 담을 리스트
	        
	        for (MultipartFile mfile : files) { // 파일 목록
	            FileVO fileVO = new FileVO(); // DB에 담을 파일VO 생성
	            String originalFileName = mfile.getOriginalFilename(); // 원본 파일명
	            
	            if (!originalFileName.isEmpty()) { // 원본 파일명이 있을 시
	                String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf('.')); // 저장 파일명 생성
	                fileVO.setSaveFolder(today); // 폴더명은 오늘 날짜
	                fileVO.setOriginFile(originalFileName); // 원본 파일명
	                fileVO.setSaveFile(saveFileName); // 저장 파일명
	                mfile.transferTo(new File(folder, saveFileName)); // 파일 업로드
	                fileInfos.add(fileVO); // 리스트에 담기
	            }
	        }
	        
	        board.setFileInfos(fileInfos); // DB에 저장하기 위한 파일 리스트 세팅
	        board.setFileCnt("" + fileInfos.size()); // DB에 저장하기 위한 파일 수 세팅
		}
		
		boardService.updateBoardOne(board);
	}
	
	@GetMapping("/reply")
	@ResponseBody
	public List<ReplyVO> reply(String boardNo, String nowPage) {
		BoardVO board = new BoardVO();
		
		int total = boardService.countReplyList(boardNo);
		
		if (nowPage == null) {
			nowPage = "1";
		}
		
		board.setBoardNo(boardNo);
		board.setPaging(new PagingVO(total, Integer.parseInt(nowPage)));
		
		return boardService.selectReplyList(board);
	}
	
	@PostMapping("/insertReply")
	@ResponseBody
	public void insertReply(ReplyVO reply) {
		boardService.insertReply(reply);
	}
	
	@PostMapping("/updateReply")
	@ResponseBody
	public void updateReply(ReplyVO reply) {
		boardService.updateReply(reply);
	}
	
	@PostMapping("/deleteReply")
	@ResponseBody
	public void deleteReply(String replyNo) {
		boardService.deleteReply(replyNo);
	}
	
	@GetMapping("/category")
	public String category(Model model) {
		model.addAttribute("cateList", boardService.selectBoardCategoryListAll());
		return "board/category";
	}

	@PostMapping("/insertCategory")
	@ResponseBody
	public void insertCategory(String cateName) {
		boardService.insertBoardCategory(cateName);
	}
	
	@PostMapping("/editCategory")
	@ResponseBody
	public void editCategory(BoardCategoryVO category) {
		boardService.updateBoardCategory(category);
	}
	
	@GetMapping("/viewBoardList")
	@ResponseBody
	public List<BoardVO> viewBoardList(String cateType) {
		return boardService.selectViewBoardList(cateType);
	}
	
	@GetMapping("/cateList")
	@ResponseBody
	public List<BoardCategoryVO> cateList() {
		return boardService.selectBoardCategoryList();
	}
	
}
