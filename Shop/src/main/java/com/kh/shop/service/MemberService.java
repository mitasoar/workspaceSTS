package com.kh.shop.service;

import com.kh.shop.vo.MemberVO;

public interface MemberService {
	// 회원 등록
	void insertMember(MemberVO member);
	
	// 회원정보 수정
	void updateMember(MemberVO member);
	
	// 회원 로그인
	MemberVO loginMember(MemberVO member);
	
	// 아이디 체크
	boolean idCheck(String id);
	
	// 이메일 찾기
	String findEmail(String memId);
	
	// 비밀번호 변경
	void updatePw(MemberVO member);
}
