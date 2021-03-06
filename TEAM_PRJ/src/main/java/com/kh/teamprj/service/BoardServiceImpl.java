package com.kh.teamprj.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.teamprj.vo.BoardCategoryVO;
import com.kh.teamprj.vo.BoardVO;
import com.kh.teamprj.vo.FileVO;
import com.kh.teamprj.vo.ReplyVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<BoardCategoryVO> selectBoardCategoryList(String memType) {
		return sqlSession.selectList("boardMapper.selectBoardCategoryList", memType);
	}
	
	@Override
	public List<BoardCategoryVO> selectBoardCategoryListAll() {
		return sqlSession.selectList("boardMapper.selectBoardCategoryListAll");
	}
	
	@Override
	public void insertBoardCategory(String cateName) {
		sqlSession.insert("boardMapper.insertBoardCategory", cateName);
	}

	@Override
	public void updateBoardCategory(BoardCategoryVO category) {
		sqlSession.update("boardMapper.updateBoardCategory", category);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String insertBoard(BoardVO board) {
		sqlSession.insert("boardMapper.insertBoard", board);
		return sqlSession.selectOne("boardMapper.selectLastBoardNo");
	}

	@Override
	public int countBoardList(BoardVO board) {
		return sqlSession.selectOne("boardMapper.countBoardList", board);
	}

	@Override
	public List<BoardVO> selectBoardListPaging(BoardVO board) {
		return sqlSession.selectList("boardMapper.selectBoardListPaging", board);
	}

	@Override
	public List<BoardVO> selectNoticeBoardList(String cateNo) {
		return sqlSession.selectList("boardMapper.selectNoticeBoardList", cateNo);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public BoardVO selectBoardOne(String boardNo) {
		sqlSession.update("boardMapper.updateReadCnt", boardNo);
		return sqlSession.selectOne("boardMapper.selectBoardOne", boardNo);
	}

	@Override
	public void deleteBoardOne(String boardNo) {
		sqlSession.update("boardMapper.deleteBoardOne", boardNo);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateBoardOne(BoardVO board) {
		sqlSession.update("boardMapper.updateBoardOne", board);
		sqlSession.delete("boardMapper.deleteFileList", board);
		if (board.getFileInfos() != null) { // ???????????? ??????????????? ?????? ???
			sqlSession.insert("boardMapper.insertFileList", board);
		}
	}

	@Override
	public List<ReplyVO> selectReplyList(BoardVO board) {
		return sqlSession.selectList("boardMapper.selectReplyListPaging", board);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertReply(ReplyVO reply) {
		sqlSession.insert("boardMapper.insertReply", reply);
		sqlSession.update("boardMapper.plusReplyCntByBoard", reply);
	}

	@Override
	public void updateReply(ReplyVO reply) {
		sqlSession.update("boardMapper.updateReply", reply);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteReply(String replyNo) {
		sqlSession.update("boardMapper.minusReplyCntByBoard", replyNo);
		sqlSession.update("boardMapper.deleteReply", replyNo);
	}

	@Override
	public int countReplyList(String boardNo) {
		return sqlSession.selectOne("boardMapper.countReplyList", boardNo);
	}

	@Override
	public List<FileVO> selectFileList(String boardNo) {
		return sqlSession.selectList("boardMapper.selectFileList", boardNo);
	}

	@Override
	public List<BoardVO> selectViewBoardList(String cateType) {
		return sqlSession.selectList("boardMapper.selectViewBoardList", cateType);
	}

	@Override
	public String selectCateName(String cateNo) {
		return sqlSession.selectOne("boardMapper.selectCateName", cateNo);
	}

}
