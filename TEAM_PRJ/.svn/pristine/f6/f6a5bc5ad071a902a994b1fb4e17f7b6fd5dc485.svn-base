package com.kh.teamprj.util;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kh.teamprj.service.MessageService;
import com.kh.teamprj.vo.MemberVO;

public class UserIntercetptor extends HandlerInterceptorAdapter {
	@Resource(name = "messageService")
	private MessageService messageService;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (!("XMLHttpRequest".equals(request.getHeader("X-Requested-With")) || modelAndView.getViewName().equals("message/message"))) { // ajax 요청 & 학사톡 페이지 이동 제외
			MemberVO user = (MemberVO) request.getSession().getAttribute("loginInfo");
			if (user != null && messageService.checkMyMessage(user.getMemNo()) != 0) {
				modelAndView.addObject("chkMsg", "Y");
			}
		}
	}
}
