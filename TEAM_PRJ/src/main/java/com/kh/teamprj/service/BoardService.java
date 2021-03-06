package com.kh.teamprj.service;

import java.util.List;

import com.kh.teamprj.vo.BoardCategoryVO;
import com.kh.teamprj.vo.BoardVO;
import com.kh.teamprj.vo.FileVO;
import com.kh.teamprj.vo.ReplyVO;

public interface BoardService {
	// 사용하는 게시판 카테고리 목록
	List<BoardCategoryVO> selectBoardCategoryList(String memType);
	
	// 모든 게시판 카테고리 목록
	List<BoardCategoryVO> selectBoardCategoryListAll();
	
	// 게시판 카테고리 등록
	void insertBoardCategory(String cateName);
	
	// 게시판 카테고리 수정
	void updateBoardCategory(BoardCategoryVO category);
	
	// 게시글 등록
	String insertBoard(BoardVO board);

	// 게시판 목록 갯수
	int countBoardList(BoardVO board);
	
	// 게시판 목록 리스트(페이징)
	List<BoardVO> selectBoardListPaging(BoardVO board);
	
	// 게시판 공지사항 목록 
	List<BoardVO> selectNoticeBoardList(String cateNo);

	// 게시판 상세 정보(조회수 업데이트)
	BoardVO selectBoardOne(String boardNo);

	// 게시판 삭제
	void deleteBoardOne(String boardNo);

	// 게시판 수정
	void updateBoardOne(BoardVO board);
	
	// 댓글 등록
	void insertReply(ReplyVO reply);
	
	// 댓글 조회
	List<ReplyVO> selectReplyList(BoardVO board);
	
	// 게시글 댓글 목록 수
	int countReplyList(String boardNo);
	
	// 댓글 수정
	void updateReply(ReplyVO reply);
	
	// 댓글 삭제
	void deleteReply(String replyNo);
	
	// 첨부파일 목록
	List<FileVO> selectFileList(String boardNo);

	// 메인화면 게시글 목록
	List<BoardVO> selectViewBoardList(String cateType);

	// 카테고리 이름
	String selectCateName(String cateNo);

}
