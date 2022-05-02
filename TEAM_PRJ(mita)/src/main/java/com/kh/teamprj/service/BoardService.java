package com.kh.teamprj.service;

import java.util.List;

import com.kh.teamprj.vo.BoardCategoryVO;
import com.kh.teamprj.vo.BoardVO;

public interface BoardService {
	// 게시판 카테고리 리스트
	List<BoardCategoryVO> selectBoardCategoryList();
	
	// 게시글 등록
	void insertBoard(BoardVO board);
	
	// 게시판 목록 리스트
	List<BoardVO> selectBoardList();

	// 게시판 목록 갯수
	int countBoardList(String cateNo);

	// 게시판 목록 리스트 페이징처리
	List<BoardVO> selectBoardListPaging(BoardVO board);
	
}
