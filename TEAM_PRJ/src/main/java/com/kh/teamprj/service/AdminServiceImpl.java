package com.kh.teamprj.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.teamprj.vo.AcademicAppVO;
import com.kh.teamprj.vo.CollVO;
import com.kh.teamprj.vo.DeptAppVO;
import com.kh.teamprj.vo.DeptVO;
import com.kh.teamprj.vo.GradeVO;
import com.kh.teamprj.vo.StudentVO;
import com.kh.teamprj.vo.LecVO;
import com.kh.teamprj.vo.ProbationVO;
import com.kh.teamprj.vo.SemesterVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<StudentVO> selectStudentList() {
		return sqlSession.selectList("adminMapper.selectStudentList");
	}

	@Override
	public List<CollVO> selectCollList() {
		return sqlSession.selectList("adminMapper.selectCollList");
	}

	@Override
	public List<DeptVO> selectDeptList() {
		return sqlSession.selectList("adminMapper.selectDeptList");
	}
	
	@Override
	public List<DeptVO> selectDeptListWithCollNo(CollVO collVO) {
		return sqlSession.selectList("adminMapper.selectDeptListWithCollNo", collVO);
	}
	
	@Override
	public List<LecVO> selectLecList() {
		return sqlSession.selectList("adminMapper.selectLecList");
	}

	@Override
	public List<StudentVO> searchStudentList(StudentVO studentVO) {
		return sqlSession.selectList("adminMapper.searchStudentList", studentVO);
	}

	@Override
	public List<LecVO> searchLecList(LecVO lecVO) {
		return sqlSession.selectList("adminMapper.searchLecList", lecVO);
	}

	@Override
	public List<GradeVO> selectLecDetail(LecVO lecVO) {
		return sqlSession.selectList("adminMapper.selectLecDetail", lecVO);
	}

	@Override //학생 상세 정보 조회
	public StudentVO selectStudentDetail(StudentVO studentVO) {
		return sqlSession.selectOne("adminMapper.selectStudentDetail", studentVO);
	}

	@Override //학기정보 조회
	public SemesterVO selectSem(SemesterVO semesterVO) {
		return sqlSession.selectOne("adminMapper.selectSem", semesterVO);
	}

	@Override //학사경고 입력
	public void insertProbation(ProbationVO probationVO) {
		sqlSession.insert("adminMapper.insertProbation", probationVO);
	}

	@Override
	public List<ProbationVO> selectProbationList(StudentVO studentVO) {
		return sqlSession.selectList("adminMapper.selectProbationList", studentVO);
	}

	@Override
	public List<AcademicAppVO> selectAcademicAppList() {
		return sqlSession.selectList("adminMapper.selectAcademicAppList");
	}

	@Override
	public void approveAcademicApp(AcademicAppVO academicAppVO) {
		sqlSession.update("adminMapper.approveAcademicApp", academicAppVO);
	}

	@Override
	public void updateStuStatus(StudentVO studentVO) {
		sqlSession.update("adminMapper.updateStuStatus", studentVO);
	}

	@Override
	public AcademicAppVO selectAcademicApp(AcademicAppVO academicAppVO) {
		return sqlSession.selectOne("adminMapper.selectAcademicApp", academicAppVO);
	}

	@Override //전과/복전 신청 목록 조회
	public List<DeptAppVO> selectDeptAppList() {
		return sqlSession.selectList("adminMapper.selectDeptAppList");
	}

	@Override
	public StudentVO expel(StudentVO studentVO) {
		return sqlSession.selectOne("adminMapper.expel", studentVO);
	}

	@Override //가장 큰 APP_NO + 1 조회
	public String selectNextAppNo() {
		return sqlSession.selectOne("adminMapper.selectNextAppNo");
	}

	

}
