package com.kh.teamprj.service;

import java.util.List;

import com.kh.teamprj.vo.AcademicAppVO;
import com.kh.teamprj.vo.CollVO;
import com.kh.teamprj.vo.DeptAppVO;
import com.kh.teamprj.vo.DeptVO;
import com.kh.teamprj.vo.EmpVO;
import com.kh.teamprj.vo.EmploymenteVO;
import com.kh.teamprj.vo.LecVO;
import com.kh.teamprj.vo.SemesterVO;
import com.kh.teamprj.vo.StudentVO;
import com.kh.teamprj.vo.TimeVO;
import com.kh.teamprj.vo.GradeVO;

public interface ProfessorService {
	//강의 등록
	void insertLec(LecVO lecVo);
	
	//강의 리스트
	List<LecVO> selectLecList(LecVO lecVO);
	
	//강의 시간
	List<TimeVO> selectLecTime(String empNo);
	
	//강의 시간 중복 체크
	boolean selectLecTimeChk(LecVO lecVO);
	
	//강의 삭제
	void updateLecClose(String lecNo);
	
	//성적 등록
	void updateGrade(GradeVO gradeVO);
	
	//내 강의를 듣고있는 학생 조회
	List<StudentVO> selectLecStu(StudentVO studentVO);
	
	//단과대 리스트
	List<CollVO> selectCollege();
	
	//단과대 번호로 학과 조회
	List<DeptVO> selectDeptList(DeptVO deptVO);
	
	//학기 정보 리스트
	SemesterVO selectSem(SemesterVO semVO);
	
	//학적 변동 신청 조회
	List<AcademicAppVO> selectAppList(String empNo);
	
	//학적 변동 승인
	void updateApp(AcademicAppVO appVO);
	
	//학적 상태(차트)
	List<Double> selectStatus();
	
	//강의 별 인원수 (차트)
	List<EmploymenteVO> selectLecNum(int emplYear);
	
	//세션 정보로 emp정보 찾기
	EmpVO selectEmpInfo(String memNo);
	
	//
	List<DeptAppVO> selectDeptApply(DeptAppVO deptAppVO);
	
	//전과 복전 승인
	void updateDeptApp(DeptAppVO deptAppVO);
}
