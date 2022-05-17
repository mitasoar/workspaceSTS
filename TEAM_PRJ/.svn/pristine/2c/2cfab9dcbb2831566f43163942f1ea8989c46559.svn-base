package com.kh.teamprj.service;

import java.util.HashMap;
import java.util.List;

import com.kh.teamprj.vo.MemberVO;

public interface MemberService {
	
	// 로그인
	MemberVO loginMember(String memId);
	
	// 이메일 중복 체크
	HashMap<String, String> selectEmailByMember(String email);
	
	// 연락처 중복 체크
	HashMap<String, String> selectPhoneByMember(String phone);

	// 회원 등록
	HashMap<String, String> insertMember(MemberVO member);

	// 회원 정보
	MemberVO selectMemberOne(String memNo);
	
	// 회원 수정
	void updateMember(MemberVO member);
	
	// 회원 탈퇴
	void deleteMember(String memNo);
	
	// 비밀번호 조회
	String selectMemberPw(String memNo);
	
	// 비밀번호 변경
	void updateMemberPw(MemberVO member);

	// 회원 조회(검색용)
	List<MemberVO> selectMemberList(String name);

	// 회원 조회(회원관리용)
	List<MemberVO> selectMemberListByAdmin(MemberVO member);

	// 회원 목록 갯수 조회
	int countMemberList(MemberVO member);

	// 회원 정보(관리자용)
	MemberVO selectMemberOneByAdmin(String memNo);

	// 회원 탈퇴
	void updateWithdrawList(String[] withdrawList);

	// 회원 재가입
	void updateRejoinList(String[] rejoinList);
	
}
