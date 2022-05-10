package com.kh.teamprj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.teamprj.service.AdminService;
import com.kh.teamprj.service.ProfessorService;
import com.kh.teamprj.service.StudentService;
import com.kh.teamprj.util.ScheduleColor;
import com.kh.teamprj.vo.AcademicAppVO;
import com.kh.teamprj.vo.DeptVO;
import com.kh.teamprj.vo.GradeVO;
import com.kh.teamprj.vo.LecVO;
import com.kh.teamprj.vo.SemesterVO;
import com.kh.teamprj.vo.StudentVO;
import com.kh.teamprj.vo.TimeVO;

@Controller
@RequestMapping("/stu")
public class StudentController {
	@Resource(name="studentService")
	private StudentService studentService;
	
	@Resource(name="adminService")
	private AdminService adminService;
	
	@Resource(name="professorService")
	private ProfessorService professorService;
	
	//홈으로
	@GetMapping("/home")
	public String home(){
		
		return "stu/home";
	}
	@GetMapping("/login")
	public String login() {
		
		return "stu/imsi_stu_login";
	}
	//임시로그인 - 아이디로만 로그인
	@GetMapping("/imsiLogin")
	public String imsiLogin(StudentVO studentVO, HttpSession session) {
		System.out.println(studentVO.getStuNo());
		session.setAttribute("loginInfo", studentVO);
		return "stu/selectPage";
	}

	// 내정보 조회 페이지로 이동
	@GetMapping("/stuInfo")
	public String stuInfo(HttpSession session, StudentVO studentVO) {
		studentVO = (StudentVO)session.getAttribute("loginInfo");

		session.setAttribute("loginInfo", adminService.selectStudentDetail(studentVO));
		return "stu/stu_info";
	}
	//내정보 변경 form ajax
	@ResponseBody
	@GetMapping("/stuInfoAjax")
	public String stuInfoAjax() {
		return "";
	}

	//내정보 변경 저장 ajax
	@ResponseBody
	@GetMapping("/updateStuInfo")
	public StudentVO updateStuInfo(StudentVO studentVO) {
		//memNo를 얻기 위한 쿼리
		StudentVO newStudentVO = adminService.selectStudentDetail(studentVO);
		//memNo를 가진 새로운 학생vo에 변경된 정보를 저장
		newStudentVO.getMemberVO().setMemPhone(studentVO.getMemberVO().getMemPhone());
		newStudentVO.getMemberVO().setMemAddr(studentVO.getMemberVO().getMemAddr());
		//업데이트 쿼리
		studentService.updateStuInfo(newStudentVO);
		//업데이트로 쿼리로 변경된 학생정보를 다시 select하여 리턴
		return adminService.selectStudentDetail(studentVO);
	}

	// 내시간표 조회 페이지로 이동
	@GetMapping("/myClass")
	public String myClass() {

		return "stu/my_class";
	}

	// 휴복학 조회 및 신청 페이지로 이동
	@GetMapping("/academic")
	public String academic(HttpSession session, StudentVO studentVO, Model model, SemesterVO semesterVO) {
		//세션에 저장되어있는 정보로 studentVO를 세팅
		studentVO = (StudentVO)session.getAttribute("loginInfo");
		//학번으로 학생의 모든 정보를 가져와서 세션에 저장
		session.setAttribute("loginInfo", adminService.selectStudentDetail(studentVO));
		//학생의 휴복학신청내역 조회
		model.addAttribute("applyList", studentService.selectAcademicAppList(studentVO));
		//학기정보 조회
		model.addAttribute("semInfo", studentService.selectSem(semesterVO));
		
		return "stu/academic";
	}
	//휴복학 신청 버튼 클릭 시 insert
	@ResponseBody
	@PostMapping("academicAppAjax")
	public List<AcademicAppVO> academicAppAjax(AcademicAppVO academicAppVO, StudentVO studentVO) {
		//학생의 휴복학신청 중 미승인 내역이 하나라도 있으면 신청불가
		List<AcademicAppVO> appList = studentService.selectAcademicAppList(studentVO);
		//미승인 내역을 찾는 반복문
		boolean nonAppr = false;
		for(int i = 0; i < appList.size(); i++) {
			if(appList.get(i).getAdminProcessStatus().equals("미승인")) {
				nonAppr = true;
				break;
			}
		}
		//미승인 내역이 하나도 없으면 새로운 신청을 insert하고 학생의 신청내역리스트를 리턴
		if(nonAppr == false) {
			studentService.insertAcademicApp(academicAppVO);
			return studentService.selectAcademicAppList(studentVO);
		}
		//미승인 내역이 하나라도 있으면 신청을 insert하지 않고 null리턴
		else {
			return studentService.selectAcademicAppList(studentVO);
		}
	}
	//휴학 or 복학 선택시 ajax
	@ResponseBody
	@GetMapping("academicCateAjax")
	public String academicCateAjax(String academicCate) {
		return academicCate;
	}
	//휴/복학신청 취소
	@ResponseBody
	@PostMapping("deleteAcademicAppAjax")
	public List<AcademicAppVO> deleteAcademicAppAjax(AcademicAppVO academicAppVO, StudentVO studentVO) {
		//studentService.deleteAcademicApp(academicAppVO);
		
		return studentService.selectAcademicAppList(studentVO);
	}
	
	//자퇴신청 페이지로 이동
	@GetMapping("/dropOut")
	public String dropOut(HttpSession session, StudentVO studentVO, Model model, SemesterVO semesterVO) {
		//세션에 저장되어있는 정보로 studentVO를 세팅
		studentVO = (StudentVO)session.getAttribute("loginInfo");
		//학번으로 학생의 모든 정보를 가져와서 세션에 저장
		session.setAttribute("loginInfo", adminService.selectStudentDetail(studentVO));
		//학생의 휴복학신청내역 조회
		model.addAttribute("applyList", studentService.selectAcademicAppList(studentVO));
		//학기정보 조회
		model.addAttribute("semInfo", studentService.selectSem(semesterVO));
		
		return "stu/drop_out";
	}
		
	//전과/복전 페이지로 이동
	@GetMapping("/deptApp")
	public String deptApp(HttpSession session, StudentVO studentVO, Model model, SemesterVO semesterVO) {
		//세션에 저장되어있는 정보로 studentVO를 세팅
		studentVO = (StudentVO)session.getAttribute("loginInfo");
		//학번으로 학생의 모든 정보를 가져와서 세션에 저장
		session.setAttribute("loginInfo", adminService.selectStudentDetail(studentVO));
		//학생의 전과/복전 내역 조회
		model.addAttribute("applyList", studentService.selectDeptAppList(studentVO));
		//학기정보 조회
		model.addAttribute("semInfo", studentService.selectSem(semesterVO));
		
		return "stu/dept_app";
	}
		
	// 내 성적 확인 페이지로 이동
	@GetMapping("/myScore")
	public String myScore(Model model, HttpSession session) {
		StudentVO studentVO = (StudentVO)session.getAttribute("loginInfo");
		
		//내 성적들
		model.addAttribute("gradeList", studentService.selectStuGrade(studentVO.getStuNo()));
		return "stu/my_score";
	}
	// 수강신청 페이지로 이동
	@GetMapping("/regClassForm")
	public String regClassForm(Model model, LecVO lecVO, HttpSession session, GradeVO gradeVO) {
		StudentVO studentVO = (StudentVO)session.getAttribute("loginInfo");
		gradeVO.setStuNo(studentVO.getStuNo());
		gradeVO.setSemNo("SEM_1");
		
		//단과대 리스트
		model.addAttribute("collList", professorService.selectCollege());
		
		//강의 목록
		model.addAttribute("lecList", studentService.selectLecList(lecVO));
		
		//수강신청한 목록
		model.addAttribute("regLecList", studentService.selectRegLecList(gradeVO));
		
		return "stu/reg_class";
	}
	
	//단과대 선택에 따라 학과 리턴
	@ResponseBody
	@PostMapping("selectDept")
	public List<DeptVO> selectDept(DeptVO deptVO) {
		
		return professorService.selectDeptList(deptVO);
	}
	
	//강의 검색
	@ResponseBody
	@PostMapping("searchLecList")
	public List<LecVO> searchLecList(LecVO lecVO) {
		
		return studentService.selectLecList(lecVO);
	}
	
	//수강 신청
	@ResponseBody
	@PostMapping("regClass")
	public List<LecVO> regClass(GradeVO gradeVO, LecVO lecVO, HttpSession session) {
		StudentVO studentVO = (StudentVO)session.getAttribute("loginInfo");
		gradeVO.setStuNo(studentVO.getStuNo());
		
		//학기정보 임시 세팅
		gradeVO.setSemNo("SEM_1");
		
		//수강신청
		studentService.insertClass(gradeVO);
		
		return studentService.selectLecList(lecVO);
	}
	
	//수강신청한 강의 목록
	@ResponseBody
	@PostMapping("/regLecList")
	public List<GradeVO> regLecList(HttpSession session, GradeVO gradeVO) {
		StudentVO studentVO = (StudentVO)session.getAttribute("loginInfo");

		gradeVO.setStuNo(studentVO.getStuNo());
		gradeVO.setSemNo("SEM_1");
		
		return studentService.selectRegLecList(gradeVO);
	}
	
	@ResponseBody
	@PostMapping("/classSchedule")
	public List<TimeVO> classSchedule(HttpSession session, ScheduleColor color){
		StudentVO studentVO = (StudentVO)session.getAttribute("loginInfo");
		List<TimeVO> list = studentService.selectClassTime(studentVO.getStuNo());
		String[] colorArr = color.getScheduleColor();

		for (int i = 0; i < list.size(); i++) {
			list.get(i).setColor(colorArr[i]);
		}

		for (int i = 0; i < list.size(); i++) {
			int num1 = -1;
			int num2 = -1;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(i).getLecNo().equals(list.get(j).getLecNo())) {
					num1 = i;
					num2 = j;
				}
			}
			if (num1 != -1 && num2 != -1 && num1 != num2) {
				list.get(num1).setColor(colorArr[num1]);
				list.get(num2).setColor(colorArr[num1]);
			}

		}
		
		
		return list;
	}
	
	
	
	
}








