package com.kh.shop.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.shop.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private SqlSessionTemplate sqlSession; 

	@Override
	public void insertMember(MemberVO member) {
		sqlSession.insert("memberMapper.insertMember", member);
	}

	@Override
	public MemberVO loginMember(MemberVO member) {
		return sqlSession.selectOne("memberMapper.loginMember", member);
	}

	@Override
	public boolean idCheck(String id) {
		String idCheck = sqlSession.selectOne("idCheck", id);
		if (idCheck == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateMember(MemberVO member) {
		sqlSession.update("memberMapper.updateMember", member);
	}

}
