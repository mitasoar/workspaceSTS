package com.kh.teamprj.service;

import java.util.List;

import com.kh.teamprj.vo.ClassVO;
import com.kh.teamprj.vo.Stu1VO;

public interface StudentService {
	
	//학생조회
	List<Stu1VO> selectStudentList();

	//수업 등록
	void insertClass(ClassVO classVo);
		
	//시간표 조회
	List<ClassVO> selectClass();
	}

