package com.kh.teamprj.service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.teamprj.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public HashMap<String, String> selectEmailByMember(String email) {
		return sqlSession.selectOne("memberMapper.selectEmailByMember", email);
	}

	@Override
	public HashMap<String, String> selectPhoneByMember(String phone) {
		return sqlSession.selectOne("memberMapper.selectPhoneByMember", phone);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public HashMap<String, String> insertMember(MemberVO member) {
		sqlSession.insert("memberMapper.insertMember", member);
		return sqlSession.selectOne("memberMapper.selectJoinMember");
	}

	@Override
	public MemberVO loginMember(String memId) {
		return sqlSession.selectOne("memberMapper.loginMember", memId);
	}

	@Override
	public MemberVO selectMemberOne(String memNo) {
		return sqlSession.selectOne("memberMapper.selectMemberOne", memNo);
	}

	@Override
	public void updateMember(MemberVO member) {
		sqlSession.update("memberMapper.updateMember", member);
	}

	@Override
	public void deleteMember(String memNo) {
		sqlSession.update("memberMapper.deleteMember", memNo);
	}

	@Override
	public String selectMemberPw(String memNo) {
		return sqlSession.selectOne("memberMapper.selectMemberPw", memNo);
	}

	@Override
	public void updateMemberPw(MemberVO member) {
		sqlSession.update("memberMapper.updateMemberPw", member);
	}

	@Override
	public List<MemberVO> selectMemberList(String name) {
		return sqlSession.selectList("memberMapper.selectMemberList", name);
	}

	@Override
	public List<MemberVO> selectMemberListByAdmin(MemberVO member) {
		return sqlSession.selectList("memberMapper.selectMemberListByAdmin", member);
	}

	@Override
	public int countMemberList(MemberVO member) {
		return sqlSession.selectOne("memberMapper.countMemberList", member);
	}

	@Override
	public MemberVO selectMemberOneByAdmin(String memNo) {
		return sqlSession.selectOne("memberMapper.selectMemberOneByAdmin", memNo);
	}

	@Override
	public void updateWithdrawList(String[] withdrawList) {
		sqlSession.update("memberMapper.updateWithdrawList", withdrawList);
	}

	@Override
	public void updateRejoinList(String[] rejoinList) {
		sqlSession.update("memberMapper.updateRejoinList", rejoinList);
	} 

}
