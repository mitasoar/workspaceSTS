package com.kh.teamprj.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.teamprj.vo.BoardCategoryVO;
import com.kh.teamprj.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<BoardCategoryVO> selectBoardCategoryList() {
		return sqlSession.selectList("boardMapper.selectBoardCategoryList");
	}

	@Override
	public void insertBoard(BoardVO board) {
		sqlSession.insert("boardMapper.insertBoard", board);
	}

	@Override
	public List<BoardVO> selectBoardList() {
		return sqlSession.selectList("boardMapper.selectBoardList");
	}

	@Override
	public int countBoardList(String cateNo) {
		return sqlSession.selectOne("boardMapper.countBoardList", cateNo);
	}

	@Override
	public List<BoardVO> selectBoardListPaging(BoardVO board) {
		return sqlSession.selectList("boardMapper.selectBoardListPaging", board);
	}
	
}
