package com.kh.teamprj.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.plugin.Intercepts;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kh.teamprj.vo.MemberVO;

public class ProInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(!("XMLHttpRequest".equals(request.getHeader("X-Requested-With")))){
			HttpSession session = request.getSession();
			MemberVO memberVO = (MemberVO)session.getAttribute("loginInfo");
			
			
			if(memberVO != null) {
				if(memberVO.getMemType() == null) {
					memberVO.setMemType("");
				}
				else if(memberVO.getEmpType() ==null) {
					memberVO.setEmpType("");
				}
				
				if(memberVO.getEmpType().equals("pro") || memberVO.getMemType().equals("admin")) {
					return true;
				}
			}
			response.sendRedirect("/pro/checkEmpNo");
			return false;
			
		}
		return true;
	}
	
}
