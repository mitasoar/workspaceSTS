package com.kh.teamprj.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.teamprj.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource(name="adminService")
	AdminService adminService;
	
	//관리자페이지 홈
	@GetMapping("/home")
	public String home(){
		
		return "admin/home";
	}
	//학생관리 - 학생조회
	@GetMapping("/studentList")
	public String studentManage(Model model){
		model.addAttribute("studentList", adminService.selectStudentList());
		
		return "admin/student_list";
	}
	//학생관리 - 성적관리
	@GetMapping("/scoreManage")
	public String courseManage(){
		
		return "admin/score_manage";
	}
	//학생관리 - 학적 변동 승인
	@GetMapping("/academicAppr")
	public String academicAppr(){
		
		return "admin/academic_appr";
	}
	//학생관리 - 학사경고
	@GetMapping("/probation")
	public String probation(){
		
		return "admin/probation";
	}
	//학생관리 - 제적
	@GetMapping("/expel")
	public String expel(){
		
		return "admin/expel";
	}
	//학생관리 - 전과 / 복수전공
	@GetMapping("/majorTask")
	public String majorTask(){
		
		return "admin/majorTask";
	}
}
