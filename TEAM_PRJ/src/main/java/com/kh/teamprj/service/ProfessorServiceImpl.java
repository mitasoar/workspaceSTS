package com.kh.teamprj.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.teamprj.vo.AcademicAppVO;
import com.kh.teamprj.vo.CollVO;
import com.kh.teamprj.vo.DeptAppVO;
import com.kh.teamprj.vo.DeptVO;
import com.kh.teamprj.vo.EmpVO;
import com.kh.teamprj.vo.EmploymenteVO;
import com.kh.teamprj.vo.GradeVO;
import com.kh.teamprj.vo.LecVO;
import com.kh.teamprj.vo.SemesterVO;
import com.kh.teamprj.vo.StudentVO;
import com.kh.teamprj.vo.TimeVO;

@Service("professorService")
public class ProfessorServiceImpl implements ProfessorService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void insertLec(LecVO lecVO) { //강의 등록
		sqlSession.insert("professorMapper.insertLec", lecVO);
	}

	@Override
	public List<LecVO> selectLecList(LecVO lecVO) { //강의 목록
		return sqlSession.selectList("professorMapper.selectLecList", lecVO);
	}
	
	@Override
	public List<TimeVO> selectLecTime(String empNo) {
		return sqlSession.selectList("professorMapper.selectLecTime", empNo);
	}
	

	@Override
	public void updateGrade(GradeVO gradeVO) { //성적 등록
		sqlSession.update("professorMapper.updateGrade", gradeVO);
	}

	@Override
	public List<CollVO> selectCollege() { //단과대 목록
		return sqlSession.selectList("professorMapper.selectCollege");
	}

	@Override
	public List<StudentVO> selectLecStu(StudentVO studentVO) { //내강의를 듣고있는 학생 목록
		return sqlSession.selectList("adminMapper.searchStudentList", studentVO);
	}

	@Override
	public List<DeptVO> selectDeptList(DeptVO deptVO) { //학과 목록
		return sqlSession.selectList("professorMapper.selectDeptList", deptVO);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public SemesterVO selectSem(SemesterVO semVO) { //학기정보
		SemesterVO sVO = sqlSession.selectOne("professorMapper.selectSemYn", semVO);
		
		if(sVO == null) {
			String semName = semVO.getYear() + "년 " + semVO.getSemester() + "학기";
			semVO.setSemName(semName);
			sqlSession.insert("professorMapper.insertSem", semVO);
		}
		
		return sqlSession.selectOne("professorMapper.selectSem", semVO);
	}


	@Override
	public List<AcademicAppVO> selectAppList(String deptNo) { //학적 변동 신청정보
		return sqlSession.selectList("professorMapper.selectAppList", deptNo);
	}

	@Override
	public void updateApp(AcademicAppVO appVO) { //학적 승인
		sqlSession.update("professorMapper.updateApp", appVO);
	}

	@Override
	public void updateLecClose(String lecNo) { //폐강
		sqlSession.update("professorMapper.updateLecClose", lecNo);
	}

	@Override
	public List<Double> selectStatus() { //학적 데이터 리스트 (차트)
		return sqlSession.selectList("professorMapper.selectStatus");
	}

	@Override
	public List<EmploymenteVO> selectLecNum() {
		return sqlSession.selectList("professorMapper.selectLecNum");
	}

	@Override
	public boolean selectLecTimeChk(LecVO lecVO) { //강의 등록 중복 요일 체크
		List<TimeVO> list = sqlSession.selectList("professorMapper.selectLecTime", lecVO.getEmpNo());
		boolean result  = false;
		
		if(list.size() != 0) {
			for(int i = 0 ; i < list.size() ; i++) {
				for(int j = 0 ; j < lecVO.getTimeList().size() ; j++) {
					if(list.get(i).getDay().equals(lecVO.getTimeList().get(j).getDay())) {
						result = true;
					}
				}
			}
		}
		
		return result;
	}

	@Override
	public EmpVO selectEmpInfo(String memNo) { //empNo찾기
		return sqlSession.selectOne("professorMapper.selectEmpInfo", memNo);
	}

	@Override
	public List<DeptAppVO> selectDeptApply(DeptAppVO deptAppVO) {
		return sqlSession.selectList("professorMapper.selectDeptApply", deptAppVO);
	}

	@Override
	public void updateDeptApp(DeptAppVO deptAppVO) {
		sqlSession.update("professorMapper.updateDeptApp", deptAppVO);
	}
	
	public void updateDeptApps(List<DeptAppVO> deptAppList) {
		sqlSession.update("professorMapper.updateDeptApps", deptAppList);
	}

	@Override
	public List<SemesterVO> selectSemList() {
		return sqlSession.selectList("professorMapper.selectSemList");
	}

	@Override
	public List<DeptAppVO> selectDeptAppChk() {
		return sqlSession.selectList("professorMapper.selectDeptAppChk");
	}


	@Override
	public void updateDeptAppLasts(List<DeptAppVO> deptAppList) {
		sqlSession.update("professorMapper.updateDeptAppLasts", deptAppList);
	}

	






}
