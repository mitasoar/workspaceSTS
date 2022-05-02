package com.kh.teamprj.service;

import java.util.List;

import com.kh.teamprj.vo.CollVO;
import com.kh.teamprj.vo.DeptVO;
import com.kh.teamprj.vo.LecVO;
import com.kh.teamprj.vo.Stu1VO;
import com.kh.teamprj.vo.StuScoreVO;

public interface ProfessorService {
	//강의 등록
	void insertLec(LecVO lecVo);
	
	//성적 등록
	void insertScore(StuScoreVO scoreVO);
	
	//강의 리스트
	List<LecVO> selectLecList();
	
	//단과대 리스트
	List<CollVO> selectCollege();
	
	//학생 조회
	List<Stu1VO> selectStu();
	
	//단과대 번호로 학과 조회
	List<DeptVO> selectDeptList(DeptVO deptVO);
}
