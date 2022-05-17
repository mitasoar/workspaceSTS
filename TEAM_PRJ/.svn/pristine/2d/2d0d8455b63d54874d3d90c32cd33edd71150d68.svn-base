package com.kh.teamprj.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.teamprj.vo.AcademicAppVO;
import com.kh.teamprj.vo.DeptAppVO;
import com.kh.teamprj.vo.DeptVO;
import com.kh.teamprj.vo.GradeVO;
import com.kh.teamprj.vo.LecVO;
import com.kh.teamprj.vo.SemesterVO;
import com.kh.teamprj.vo.StudentVO;
import com.kh.teamprj.vo.TimeVO;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void updateStuInfo(StudentVO studentVO) {
		sqlSession.update("studentMapper.updateStuInfo", studentVO);
	}

	@Override
	public List<LecVO> selectLecList(LecVO lecVO) {
		return sqlSession.selectList("professorMapper.selectLecList", lecVO);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertClass(GradeVO gradeVO) {
		sqlSession.insert("studentMapper.insertClass", gradeVO);
		sqlSession.update("studentMapper.updateNowNum", gradeVO);
	}

	@Override
	public List<AcademicAppVO> selectAcademicAppList(StudentVO studentVO) {
		return sqlSession.selectList("studentMapper.selectAcademicAppList", studentVO);
	}

	@Override
	public void insertAcademicApp(AcademicAppVO academicAppVO) {
		sqlSession.insert("studentMapper.insertAcademicApp", academicAppVO);
	}
	
	@Override
	public void deleteAcademicApp(AcademicAppVO academicAppVO) {
		sqlSession.delete("studentMapper.deleteAcademicApp", academicAppVO);
	}

	@Override
	public List<DeptAppVO> selectDeptAppList(StudentVO studentVO) {
		return sqlSession.selectList("studentMapper.selectDeptAppList", studentVO);
	}

	@Override
	public void insertDeptApp(DeptAppVO deptAppVO) {
		sqlSession.insert("studentMapper.insertDeptApp", deptAppVO);
	}

	@Override
	public SemesterVO selectSem(SemesterVO semesterVO) {
		return sqlSession.selectOne("studentMapper.selectSem", semesterVO);
	}

	@Override
	public List<GradeVO> selectRegLecList(GradeVO gradeVO) {
		return sqlSession.selectList("studentMapper.selectRegLecList", gradeVO);
	}

	@Override
	public List<TimeVO> selectClassTime(String stuNo) {
		return sqlSession.selectList("studentMapper.selectClassTime", stuNo);
	}

	@Override
	public DeptVO selectDept(DeptAppVO deptAppVO) {
		return sqlSession.selectOne("studentMapper.selectDept", deptAppVO);
	}

	@Override
	public void deleteDeptApp(DeptAppVO deptAppVO) {
		sqlSession.delete("studentMapper.deleteDeptApp", deptAppVO);
	}

	@Override
	public List<GradeVO> selectStuGrade(GradeVO gradeVO) {
		return sqlSession.selectList("studentMapper.selectStuGrade", gradeVO);
	}

	@Override
	public List<SemesterVO> selectSemList(SemesterVO semesterVO) {
		return sqlSession.selectList("studentMapper.selectSem", semesterVO);
	}

	@Override
	public DeptVO selectDeptbyDeptVO(DeptVO deptVO) {
		return sqlSession.selectOne("studentMapper.selectDeptbyDeptVO", deptVO);
	}

}