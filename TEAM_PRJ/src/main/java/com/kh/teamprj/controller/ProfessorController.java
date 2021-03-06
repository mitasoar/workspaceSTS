package com.kh.teamprj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.teamprj.service.ProfessorService;
import com.kh.teamprj.util.MyDateUtil;
import com.kh.teamprj.vo.AcademicAppVO;
import com.kh.teamprj.vo.DeptAppVO;
import com.kh.teamprj.vo.DeptVO;
import com.kh.teamprj.vo.EmpVO;
import com.kh.teamprj.vo.EmploymenteVO;
import com.kh.teamprj.vo.LecVO;
import com.kh.teamprj.vo.MemberVO;
import com.kh.teamprj.vo.SemesterVO;
import com.kh.teamprj.vo.StudentVO;
import com.kh.teamprj.vo.TimeVO;

import com.kh.teamprj.vo.GradeVO;


@Controller
@RequestMapping("/pro")
public class ProfessorController {
	@Resource(name = "professorService")
	private ProfessorService professorService;

	//로그인 하지 않았거나 empNo가 없을경우
	@GetMapping("/checkEmpNo")
	public String checkEmpNo() {
		
		return "professor/alert";
	}
	
	// 강의 등록 페이지로 이동
	@GetMapping("/regLecForm")
	public String regLecForm(Model model, SemesterVO semVO, HttpSession session) {
		
		//오늘의 날짜 세팅
		int[] sem = MyDateUtil.getSemDate();
		semVO.setYear(sem[0]);
		semVO.setSemester(sem[1]);
		
		// 단과대 리스트
		model.addAttribute("collList", professorService.selectCollege());
		// 학기 정보
		model.addAttribute("sem", professorService.selectSem(semVO));
		
		//System.out.println(professorService.selectSemYn(semVO));
		return "professor/reg_lec";
	}

	// 단과대 선택에 따라 학과 선택창이 나오도록
	@ResponseBody
	@PostMapping("/selectDept")
	public List<DeptVO> selectDept(DeptVO deptVO) {
		List<DeptVO> list = professorService.selectDeptList(deptVO);

		return list;
	}

	//강의 등록
	@PostMapping("/regLec")
	public String regLec(LecVO lecVO, HttpSession session, String semNo, Model model) {
		String uri = "redirect:/pro/regLecForm";
		
		// 강의 교수 이름가져와 세팅
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		lecVO.setEmpNo(member.getEmpNo());
		
		//시간 중복 체크
		boolean result = professorService.selectLecTimeChk(lecVO);
		
		if(result) {
			uri = "professor/alert";
			model.addAttribute("check", 1);
		}
		else {
			// lecVO 정보로 lec를 등록한다
			professorService.insertLec(lecVO);
		}
		

		return uri;
	}
	
	//폐강
	@ResponseBody
	@PostMapping("/lecClose")
	public void lecClose(String lecNo) {
		professorService.updateLecClose(lecNo);
		
	}

	//강의 리스트
	@GetMapping("/lecList")
	public String lecList(Model model, LecVO lecVO, HttpSession session, SemesterVO semVO) {
		// 교수 정보
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		lecVO.setEmpNo(member.getEmpNo());
		
		// 학기 정보
		model.addAttribute("semList", professorService.selectSemList());
		
		// 강의 리스트
		model.addAttribute("lecList", professorService.selectLecList(lecVO));

		return "professor/lec_list";
	}
	
	//강의 검색
	@ResponseBody
	@PostMapping("searchLecList")
	public List<LecVO> searchLecList(LecVO lecVO) {
		
		return professorService.selectLecList(lecVO);
	}


	// 강의를 듣고있는 학생
	@ResponseBody
	@PostMapping("/lecStuList")
	public List<StudentVO> lecStuList(StudentVO studentVO) {

		return professorService.selectLecStu(studentVO);
	}

	//성적 등록
	@ResponseBody
	@PostMapping("/regGrade")
	public List<StudentVO> regScore(StudentVO studentVO, GradeVO gradeVO) {
		/*
		 * List<GradeVO> gradeList = new ArrayList<GradeVO>(); gradeList.add(gradeVO);
		 * studentVO.setGradeList(gradeList);
		 */
		// 성적 등록
		professorService.updateGrade(gradeVO);

		return professorService.selectLecStu(studentVO);
	}


	// 교수 시간표
	@GetMapping("/schedule")
	public String schedule(Model model) {

		return "professor/schedule";
	}
	
	//교수시간표 AJAX
	@ResponseBody
	@PostMapping("/lecSchedule")
	public List<TimeVO> lecSchedule(HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");

		return professorService.selectLecTime(member.getEmpNo());
	}

	// 학적변동 승인으로 이동
	@GetMapping("/academicApp")
	public String academicApp(Model model, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		String deptNo = professorService.selectEmpInfo(member.getMemNo()).getDeptNo();
		
		//학적 변동 신청 조회
		model.addAttribute("appList", professorService.selectAppList(deptNo));

		return "professor/academic_app";
	}

	//학적 변동 승인
	@PostMapping("/updateApp")
	public String updateApp(AcademicAppVO appVO, Model model) {
		// 오늘 날짜를 세팅
		appVO.setProfProcessDate(MyDateUtil.getNowDateToString());
		professorService.updateApp(appVO);
		
		return "redirect:/pro/academicApp";
	}
	
	//일괄 승인
	@ResponseBody
	@PostMapping("/updateApps")
	public void updateApps(@RequestParam(value = "objArr[]") ArrayList<String> objArr, AcademicAppVO appVO) {
		
		for(String e : objArr) {
			appVO.setAppNo(e);
			appVO.setProfProcessDate(MyDateUtil.getNowDateToString());
			professorService.updateApp(appVO);
		}
		
	}
	
	//전과 복수전공 페이지로 이동
	@GetMapping("/deptAppForm")
	public String deptAppForm(HttpSession session, DeptAppVO deptAppVO, Model model) {
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		EmpVO empVO = professorService.selectEmpInfo(member.getMemNo());
		deptAppVO.setOriginalDept(empVO.getDeptNo());
		deptAppVO.setApplyDept(empVO.getDeptNo());
		
		model.addAttribute("deptAppList", professorService.selectDeptApply(deptAppVO));
		model.addAttribute("empVO", empVO);
		
		return "professor/dept_app";
	}
	
	//전과, 복수전공 승인
	@PostMapping("/updateDeptApp")
	public String updateDeptApp(DeptAppVO deptAppVO) {
		if(deptAppVO.getOriginalDept() != null) {
			deptAppVO.setOriDeptProcessDate(MyDateUtil.getNowDateToString());
		}
		else {
			deptAppVO.setApplyDate(MyDateUtil.getNowDateToString());
		}
		//승인
		professorService.updateDeptApp(deptAppVO);
		
		//최종 승인 체크
		List<DeptAppVO> deptList = professorService.selectDeptAppChk();
		
		if(deptList.size() > 0) {
			//최종 승인
			professorService.updateDeptAppLasts(deptList);
		}
		
		return "redirect:/pro/deptAppForm";
	}
	
	//전과, 복전 일괄 승인
	@ResponseBody
	@PostMapping("/updateDeptApps")
	public void updateDeptApps(@RequestParam(value = "objArr[]") ArrayList<String> objArr
			, @RequestParam(value = "deptArr[]") ArrayList<String> deptArr, HttpSession session, String app) {
		MemberVO memberVO = (MemberVO)session.getAttribute("loginInfo");
		EmpVO empVO = professorService.selectEmpInfo(memberVO.getMemNo());
		
		List<DeptAppVO> deptAppList = new ArrayList<DeptAppVO>();
		
		for(int i = 0 ; i < objArr.size() ; i++) {
			DeptAppVO deptAppVO = new DeptAppVO();
			deptAppVO.setDeptAppNo(objArr.get(i));
			
			//기존학과와 로그인 교수에 deptNo가 같다면
			if(empVO.getDeptNo().equals(deptArr.get(i))) {
				deptAppVO.setOriDeptProcessStatus(app);
				deptAppVO.setOriDeptProcessDate(MyDateUtil.getNowDateToString());
			}
			else {
				deptAppVO.setAppDeptProcessStatus(app);
				deptAppVO.setAppDeptProcessDate(MyDateUtil.getNowDateToString());
			}
			deptAppList.add(deptAppVO);
		}
		professorService.updateDeptApps(deptAppList);
		
		//최종승인 체크
		List<DeptAppVO> deptList = professorService.selectDeptAppChk();
		
		//최종승인
		if(deptList.size() > 0) {
			professorService.updateDeptAppLasts(deptList);
		}
		
	}
	
}

