package com.kh.teamprj.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.teamprj.vo.AcademicAppVO;
import com.kh.teamprj.vo.CollVO;
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
	@Transactional(rollbackFor = Exception.class)
	public void insertLec(LecVO lecVO) { //강의 등록
		sqlSession.insert("professorMapper.insertLec", lecVO);
		
		for(int i = 0 ; i < lecVO.getTimeList().size() ; i++) {
			sqlSession.insert("professorMapper.insertLecTime", lecVO.getTimeList().get(i));
		}
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
	public List<AcademicAppVO> selectAppList(String empNo) { //학적 변동 신청정보
		return sqlSession.selectList("professorMapper.selectAppList", empNo);
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
	public List<EmploymenteVO> selectLecNum(int emplYear) {
		return sqlSession.selectList("professorMapper.selectLecNum", emplYear);
	}

	@Override
	public boolean selectLecTimeChk(LecVO lecVO) {
		List<TimeVO> list = sqlSession.selectList("professorMapper.selectLecTime", lecVO.getEmpNo());
		boolean result  = false;
		
		if(list != null) {
			for(int i = 0 ; i < lecVO.getTimeList().size() ; i++) {
				if(list.get(i).getDay().equals(lecVO.getTimeList().get(i).getDay())) {
					result = true;
				}
			}
		}
		
		return result;
	}

	@Override
	public EmpVO selectEmpInfo(String memNo) {
		return sqlSession.selectOne("professorMapper.selectEmpInfo", memNo);
	}

	

	






}
