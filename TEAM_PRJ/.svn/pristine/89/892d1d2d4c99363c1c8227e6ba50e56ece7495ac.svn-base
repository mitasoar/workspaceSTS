package com.kh.teamprj.service;

import java.util.List;

import com.kh.teamprj.vo.AcademicAppVO;
import com.kh.teamprj.vo.DeptAppVO;
import com.kh.teamprj.vo.DeptVO;
import com.kh.teamprj.vo.GradeVO;
import com.kh.teamprj.vo.LecVO;
import com.kh.teamprj.vo.SemesterVO;
import com.kh.teamprj.vo.StudentVO;
import com.kh.teamprj.vo.TimeVO;

public interface StudentService {
	//학생 정보 수정
	void updateStuInfo(StudentVO studentVO);
	
	//강의 리스트
	List<LecVO> selectLecList(LecVO lecVO);
	//수강신청한 학생 내역 조회
	List<GradeVO> selectRegLecList(GradeVO gradeVO);
	//학생 성적
	List<GradeVO> selectStuGrade(GradeVO gradeVO);
	//학기 전체 정보
	List<SemesterVO> selectSemList(SemesterVO semesterVO);
	//학생 시간표
	List<TimeVO> selectClassTime(String stuNo);


	void insertClass(GradeVO gradeVO);
	//휴복학 내역 조회
	List<AcademicAppVO> selectAcademicAppList(StudentVO studentVO);
	//휴복학 신청
	void insertAcademicApp(AcademicAppVO academicAppVO);
	//휴복학신청 취소
	void deleteAcademicApp(AcademicAppVO academicAppVO);
	//전과/복전 내역 조회
	List<DeptAppVO> selectDeptAppList(StudentVO studentVO);
	//전과/복전 신청
	void insertDeptApp(DeptAppVO deptAppVO);
	//전과/복전 신청 취소
	void deleteDeptApp(DeptAppVO deptAppVO);
	//학과조회
	DeptVO selectDept(DeptAppVO deptAppVO);
	//학과조회
	DeptVO selectDeptbyDeptVO(DeptVO deptVO);
	
	
	//학기정보 조회
	SemesterVO selectSem(SemesterVO semesterVO);

}

