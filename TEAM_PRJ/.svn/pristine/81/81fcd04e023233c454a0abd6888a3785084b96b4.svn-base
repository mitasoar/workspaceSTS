package com.kh.teamprj.service;

import java.util.List;

import com.kh.teamprj.vo.MessageVO;

public interface MessageService {
	
	// 메세지 전송
	void sendMessage(MessageVO msg);
	
	// 메세지 목록
	List<MessageVO> selectChatList(String user);
	
	// 메세지 대화 목록
	List<MessageVO> selectChatMsgList(MessageVO msg);
	
	// 미확인 메세지 갯수
	int checkMyMessage(String user);
	
}
