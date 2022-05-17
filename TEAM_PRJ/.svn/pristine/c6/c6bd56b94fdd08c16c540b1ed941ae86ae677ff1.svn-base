package com.kh.teamprj.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.teamprj.vo.MessageVO;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void sendMessage(MessageVO msg) {
		msg.setRoomNo(sqlSession.selectOne("messageMapper.selectRoomNo", msg));
		sqlSession.insert("messageMapper.sendMessage", msg);
	}

	@Override
	public List<MessageVO> selectChatList(String user) {
		return sqlSession.selectList("messageMapper.selectChatList", user);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<MessageVO> selectChatMsgList(MessageVO msg) {
		sqlSession.update("messageMapper.updateReadMsg", msg);
		return sqlSession.selectList("messageMapper.selectChatMsgList", msg);
	}

	@Override
	public int checkMyMessage(String user) {
		return sqlSession.selectOne("messageMapper.checkMyMessage", user);
	}

}
