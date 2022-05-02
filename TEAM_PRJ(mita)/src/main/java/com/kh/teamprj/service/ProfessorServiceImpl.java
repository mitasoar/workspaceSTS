package com.kh.teamprj.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.teamprj.vo.CollVO;
import com.kh.teamprj.vo.DeptVO;
import com.kh.teamprj.vo.LecVO;
import com.kh.teamprj.vo.Stu1VO;
import com.kh.teamprj.vo.StuScoreVO;

@Service("professorService")
public class ProfessorServiceImpl implements ProfessorService {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertLec(LecVO lecVO) {
		sqlSession.insert("professorMapper.insertLec", lecVO);
	}

	@Override
	public void insertScore(StuScoreVO scoreVO) {
		sqlSession.insert("professorMapper.insertScore", scoreVO);
	}

	@Override
	public List<LecVO> selectLecList() {
		return sqlSession.selectList("professorMapper.selectLecList");
	}

	@Override
	public List<CollVO> selectCollege() {
		return sqlSession.selectList("professorMapper.selectCollege");
	}

	@Override
	public List<Stu1VO> selectStu() {
		return sqlSession.selectList("professorMapper.selectStu");
	}

	@Override
	public List<DeptVO> selectDeptList(DeptVO deptVO) {
		return sqlSession.selectList("professorMapper.selectDeptList", deptVO);
	} 

}
