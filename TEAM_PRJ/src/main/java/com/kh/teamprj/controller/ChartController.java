package com.kh.teamprj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.teamprj.service.ProfessorService;
import com.kh.teamprj.util.MyDateUtil;
import com.kh.teamprj.vo.EmploymenteVO;


@Controller
@RequestMapping("/chart")
public class ChartController {
	@Resource(name = "professorService")
	private ProfessorService professorService;

	//차트
	@GetMapping("/chart")
	public String chart() {
		
		return "professor/chart";
	}
	
	//학생 현황차트 ajax
	@ResponseBody
	@PostMapping("/chartAll")
	public List<Double> selectStatus(){
		List<Double> list = professorService.selectStatus();
		
		double totalNum = 0.0;
		
		List<Double> numList = new ArrayList<Double>();
		
		for(double e : list) {
			totalNum += e;
		}
		for(double e : list) {
			double num1 = (e / totalNum) * 100;
			String numStr = String.format("%.2f", num1);
			double num2 = Double.parseDouble(numStr);
			System.out.println(num2);
			numList.add(num2);
		}
		
		return numList;
	}
	
	//취업률 AJAX
	@ResponseBody
	@PostMapping("/selectLecNum")
	public List<EmploymenteVO> selectLecNum(){
		//모든 정보 취업정보
		List<EmploymenteVO> list = professorService.selectLecNum();
		//최근 5년의 날짜 정보
		List<Integer> yearList = MyDateUtil.getNowYear();
		//년도와 그 년도의 취업률을 담을 리스트
		List<EmploymenteVO> emplList = new ArrayList<EmploymenteVO>();
		
		for(int i = 0 ; i < yearList.size() ; i++) {
			double n = 0;
			double y = 0;
			EmploymenteVO emplVO = new EmploymenteVO();
			
			for(int j = 0 ; j < list.size() ; j++) {
				if(yearList.get(i) == list.get(j).getEmplYear()) {
					if(list.get(j).getIsYn().equals("Y")) {
						y = list.get(j).getNum();
					}
					else if(list.get(j).getIsYn().equals("N")) {
						n = list.get(j).getNum();
					}
				}
			}
			double num = y + n;
			double result = Double.parseDouble(String.format("%.2f", (y / num) * 100));
			
			emplVO.setEmplYear(yearList.get(i));
			emplVO.setNum(result);
			emplList.add(emplVO);
		}
		
		return emplList;
	}
	
	
}

