package com.kh.teamprj.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.teamprj.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public String selectEmailByMember(String email) {
		return sqlSession.selectOne("memberMapper.selectEmailByMember", email);
	}

	@Override
	public String selectPhoneByMember(String phone) {
		return sqlSession.selectOne("memberMapper.selectPhoneByMember", phone);
	}

	@Override
	public void insertMember(MemberVO member) {
		sqlSession.insert("memberMapper.insertMember", member);
	}

	@Override
	public MemberVO loginMember(MemberVO member) {
		return sqlSession.selectOne("loginMember", member);
	} 

}
