package com.kh.shop.controller;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.shop.service.MemberService;
import com.kh.shop.vo.MemberVO;

// @Controller 어노테이션의 역할
// 1. 해당 클래스를 controller 인식
// 2. 해당 클래스에 대한 객체를 생성
@Controller
@RequestMapping("/member") // - 요청 경로가 /member로 시작하면 MemberController 실행
public class MemberController {
	@Resource(name="memberService")
	private MemberService memberService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@PostMapping("/edit")
	@ResponseBody
	public void edit(MemberVO member, HttpSession session) {
		memberService.updateMember(member);
		session.setAttribute("login", member);
	}
	
	@PostMapping("/join")
	public String join(MemberVO member) {
		memberService.insertMember(member);
		return "redirect:/item/itemList";
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public String idCheck(String id) {
		if (memberService.idCheck(id)) {
			return "ok";
		} else {
			return "fail";
		}
	}
	
//	@PostMapping("/login")
//	public String login(MemberVO member, HttpSession session) {
//		MemberVO loginMember = memberService.loginMember(member);
//		if (loginMember != null) {
//			session.setAttribute("login", loginMember);
//		}
//		return "redirect:/item/itemList";
//	}
	
	@PostMapping("/login")
	@ResponseBody
	public String loginCheck(MemberVO member, HttpSession session) {
		MemberVO loginMember = memberService.loginMember(member);
		if (loginMember != null) {
			session.setAttribute("login", loginMember);
			return "ok";
		} else {
			return "fail";
		}
	}
	
	@GetMapping("/logout")
	public String login(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/item/itemList";
	}
	
	@GetMapping("/findPw")
	public String findPw() {
		return "member/find_pw";
	}
	
	@PostMapping("/findPw")
	@ResponseBody
	public void findPw(String memId) {
		// 메일 정보 조회
		String memEmail = memberService.findEmail(memId);
		
		// 임시 비밀번호 생성 소문자 + 대문자 + 숫자 포함 8자리
		String temporaryPw = getTemporaryPw(8);
		
		memberService.updatePw(new MemberVO(memId, temporaryPw));
		
		try {
			// 메일 보내기
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(message, true, "UTF-8");
			msgHelper.setFrom("운영자 <mitasoar@gmail.com>"); // 메일 발신 계정
			msgHelper.setTo(memEmail); // 메일 수신 계정
			msgHelper.setSubject(memId + "님이 요청하신 임시비밀번호 메일입니다."); // 메일 제목
			msgHelper.setText(memId + "님의 임시비밀번호는 '" + temporaryPw + "' 입니다."); // 메일 내용

			mailSender.send(message); // 메일 발송
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public String getTemporaryPw(int num) {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder returnPw = new StringBuilder();
		
		for (int i = 0; i < num; i++) {
			returnPw.append(str.charAt(new SecureRandom().nextInt(str.length())));
		}
		
		return returnPw.toString();
	}
}
