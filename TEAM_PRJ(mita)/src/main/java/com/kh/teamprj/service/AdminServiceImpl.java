package com.kh.teamprj.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.teamprj.vo.BaedohunVO1;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<BaedohunVO1> selectStudentList() {
		return sqlSession.selectList("adminMapper.selectStudentList");
	}

}
