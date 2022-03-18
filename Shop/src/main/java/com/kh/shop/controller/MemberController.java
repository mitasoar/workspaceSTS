package com.kh.shop.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/edit")
	public String edit(MemberVO member, HttpSession session) {
		memberService.updateMember(member);
		session.setAttribute("login", member);
		return "redirect:/item/itemList";
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
}
