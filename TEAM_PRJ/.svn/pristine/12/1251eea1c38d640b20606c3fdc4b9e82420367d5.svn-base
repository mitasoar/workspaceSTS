package com.kh.teamprj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.teamprj.service.AdminService;
import com.kh.teamprj.vo.StudentVO;

import com.kh.teamprj.vo.AcademicAppVO;
import com.kh.teamprj.vo.CollVO;
import com.kh.teamprj.vo.DeptVO;
import com.kh.teamprj.vo.GradeVO;
import com.kh.teamprj.vo.LecVO;
import com.kh.teamprj.vo.ProbationVO;
import com.kh.teamprj.vo.SemesterVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource(name="adminService")
	private AdminService adminService;
	
	//관리자페이지 홈
	@GetMapping("/home")
	public String home(){
		
		return "admin/home";
	}
	//학생조회 페이지로 이동
	@GetMapping("/studentList")
	public String studentManage(Model model){
		model.addAttribute("collList", adminService.selectCollList());
		model.addAttribute("deptList", adminService.selectDeptList());
		
		return "admin/student_list";
	}
	
	//학생조회 - 검색버튼 클릭 시 설정된 조건으로 학생 조회
	@ResponseBody
	@GetMapping("/searchStudentAjax")
	public List<StudentVO> searchStudentAjax(StudentVO studentVO) {
		
		List<StudentVO> list = adminService.searchStudentList(studentVO);
		
		return list;
	}
	//학생 상세정보 조회
	@ResponseBody
	@GetMapping("/selectStudentDetailAjax")
	public StudentVO selectStudentDetailAjax(StudentVO studentVO) {
		return adminService.selectStudentDetail(studentVO);
	}
	
	//학생조회, 성적관리 - 단과대학 변경 시 소속 학과 리스트 조회
	@ResponseBody
	@GetMapping("/collChangeAjax")
	public List<DeptVO> collChangeAjax(CollVO collVO) {
		List<DeptVO> list = adminService.selectDeptListWithCollNo(collVO);
		
		return list;
	}
	
	//성적관리 페이지로 이동
	@GetMapping("/scoreManage")
	public String courseManage(Model model){
		model.addAttribute("collList", adminService.selectCollList());
		model.addAttribute("deptList", adminService.selectDeptList());
		
		return "admin/score_manage";
	}
		
	//성적관리 - 검색버튼 클릭 시 설정된 조건으로 강의 조회
	@ResponseBody
	@GetMapping("/searchLecAjax")
	public List<LecVO> searchLecAjax(LecVO lecVO) {
		return  adminService.searchLecList(lecVO);
	}
	//성적관리 - 강의명 클릭 시 강의 상세 조회
	@ResponseBody
	@GetMapping("/lecDetailAjax")
	public List<StudentVO> lecDetailAjax(StudentVO studentVO, GradeVO gradeVO) {
		//gradeList에 lecNo가 포함된 gradeVO 추가
		List<GradeVO> gradeList = new ArrayList<GradeVO>();
		gradeList.add(gradeVO);
		
		studentVO.setGradeList(gradeList);
		
		return adminService.searchStudentList(studentVO);
	}
	
	//학생관리 - 학적 변동 승인 페이지로 이동
	@GetMapping("/academicAppr")
	public String academicAppr(Model model){
		model.addAttribute("academicAppList", adminService.selectAcademicAppList());
		
		return "admin/academic_appr";
	}
	//학적변동승인 - 최종승인하기
	@ResponseBody
	@PostMapping("/approveApply")
	public AcademicAppVO approveApply(AcademicAppVO academicAppVO, StudentVO studentVO) {
		//studentVO의 stuStatus를 academicAppVO의 applyType으로 설정(휴학, 복학 등)
		studentVO.setStuStatus(academicAppVO.getApplyType());

		adminService.updateStuStatus(studentVO);
		adminService.approveAcademicApp(academicAppVO);
		
		return adminService.selectAcademicApp(academicAppVO);
	}
	//학적변동승인 - 다중승인
	@ResponseBody
	@PostMapping("/multiApprove")
	public List<AcademicAppVO> multiApprove(@RequestParam(value = "appNoArr[]")  ArrayList<String> appNoArr, StudentVO studentVO, AcademicAppVO academicAppVO) {
		String applyType = "";
		String stuStatus = "";
		for(String appNo : appNoArr) {
			//넘어온 appNo를 academicAppVO에 저장하고 모든 정보를 불러와서 저장
			academicAppVO.setAppNo(appNo);
			academicAppVO = adminService.selectAcademicApp(academicAppVO);
			//academicAppVO의 applyType을 문자열 변수 applyType에 저장
			applyType = academicAppVO.getApplyType();
			//신청유형에 따라 저장할 학생학적상태 세팅
			if(applyType.equals("일반휴학") || applyType.equals("군휴학") || applyType.equals("가사휴학")) {
				stuStatus = "휴학";
			}
			else if(applyType.equals("복학")) {
				stuStatus = "재학";
			}
			else if(applyType.equals("자퇴")) {
				stuStatus = "자퇴";
			}
			//academicAppVO의 stuNo와 stuStatus를 studentVO에 저장
			studentVO.setStuNo(academicAppVO.getStuNo());
			studentVO.setStuStatus(stuStatus);
			adminService.approveAcademicApp(academicAppVO);
			adminService.updateStuStatus(studentVO);
		}
		
		return adminService.selectAcademicAppList();
	}
	//학생관리 - 학사경고 페이지로 이동
	@GetMapping("/probation")
	public String probation(Model model){
		model.addAttribute("collList", adminService.selectCollList());
		model.addAttribute("deptList", adminService.selectDeptList());
		
		return "admin/probation";
	}
	//학사경고 - 학생 상세조회 모달창에서 학사경고누적내역 조회
	@ResponseBody
	@GetMapping("/probationList")
	public List<ProbationVO> probationList(StudentVO studentVO) {
		
		return adminService.selectProbationList(studentVO);
	}
	
	//학사경고페이지의 학생상세조회 모달창에서 학사경고를 입력
	@GetMapping("/insertProbation")
	public String insertProbation(ProbationVO probationVO, SemesterVO semesterVO, Model model) {
		//year과 semester으로 semNo를 select하는 쿼리를 한 번 수행.
		SemesterVO semester = adminService.selectSem(semesterVO);
		//위의 select쿼리로 얻은 학기정보를 커맨드객체 probationVO에 저장
		probationVO.setSemNo(semester.getSemNo());
		//학사경고에 필요한 모든 정보를 가진 probationVO객체로 학사경고 입력
		adminService.insertProbation(probationVO);
		
		return "redirect:/admin/home";
	}
	//학사경고 - 제적가능버튼 클릭 시
	@ResponseBody
	@PostMapping("/expel")
	public void expel(StudentVO studentVO){
		adminService.expel(studentVO);
	}
	//학생관리 - 전과 / 복수전공
	@GetMapping("/deptAppr")
	public String majorTask(Model model){
		//신청목록 조회
		model.addAttribute("deptAppList", adminService.selectDeptAppList());
		
		return "admin/dept_appr";
	}
}
