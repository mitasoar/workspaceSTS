package com.kh.teamprj.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.teamprj.service.StudentService;
import com.kh.teamprj.vo.ClassVO;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource(name="studentService")
	private StudentService studentService;
	
	//홈으로
	@GetMapping("/home")
	public String home(){
		
		return "student/home";
	}
	//내정보관리 - 내정보조회
	@GetMapping("/studentList")
	public String studentManage(Model model){
		model.addAttribute("studentList", studentService.selectStudentList());
		
		return "admin/student_list";
	}
	//학생관리 - 성적관리
	@GetMapping("/studentScore")
	public String manageScore(){
		
		return "admin/student_manage";
	}
	//수강신청 등록 페이지로 이동
	@GetMapping("/regClassForm")
	public String regClassForm() {
		//단과대 리스트( 셀렉트 박스)
		//studentService.selectCollege();
		
		return "class/reg_class";
	}
	//수업 등록
	@PostMapping("/regClass")
	public String regClass(ClassVO classVO, HttpSession session) {
		//강의 교수 이름가져와 세팅
		//member1VO member = session.getAttribute("loginInfo");
		//lecVO.setLecPr(member.getName());
		
		//classVO 정보로 class를 등록한다
		studentService.insertClass(classVO);
		
		return "class/reg_class";
	}
	//내정보 조회 페이지로 이동
	@GetMapping("/myStu")
	public String myStu() {
		//내 정보 조회
		
		return "";
	}
	
}
