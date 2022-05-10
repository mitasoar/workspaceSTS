package com.kh.teamprj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.teamprj.service.MessageService;
import com.kh.teamprj.vo.MemberVO;
import com.kh.teamprj.vo.MessageVO;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/message")
	public String message(Model model, HttpSession session) {
		model.addAttribute("memNo", ((MemberVO)session.getAttribute("loginInfo")).getMemNo());
		return "message/message";
	}
	
	@GetMapping("/chat")
	public String chat() {
		return "message/chat";
	}
	
	@PostMapping("/sendMsg")
	@ResponseBody
	public void sendMsg(MessageVO msg, HttpSession session) {
		msg.setFromUser(((MemberVO)session.getAttribute("loginInfo")).getMemNo());
		messageService.sendMessage(msg);
	}
	
	@GetMapping("/chatList")
	@ResponseBody
	public List<MessageVO> chatList(HttpSession session) {
		return messageService.selectChatList(((MemberVO)session.getAttribute("loginInfo")).getMemNo());
	}
	
	@GetMapping("/chatMsgList")
	@ResponseBody
	public List<MessageVO> chatMsgList(MessageVO msg) {
		return messageService.selectChatMsgList(msg);
	}
	
}