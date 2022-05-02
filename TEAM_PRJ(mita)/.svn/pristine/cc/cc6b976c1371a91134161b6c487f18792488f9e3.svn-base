package com.kh.teamprj.controller;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.teamprj.vo.MemberVO;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

import com.kh.teamprj.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Resource(name="memberService")
	private MemberService memberService;
	
//	@Autowired
//	private JavaMailSender mailSender; // 메일 전송을 위한 변수
	
	@GetMapping("/home")
	public String home(){
		return "member/home";
	}
	
	@GetMapping("/login")
	public String login(){
		return "member/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("loginInfo"); // 로그인 정보 삭제
		return "redirect:/member/home";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public String login(MemberVO member, HttpSession session){
		MemberVO mem = memberService.loginMember(member); // 로그인 정보 가져오기
		
		if (mem != null) { // 로그인 된 경우
			session.setAttribute("loginInfo", mem); // 세션에 로그인정보 set
			session.setMaxInactiveInterval(-1); // 세션 시간대 무한으로 유지
			return "ok";
		} else { // 로그인 실패
			return "fail";
		}
	}
	
	@GetMapping("/join")
	public String join(String joinType, Model model){
		model.addAttribute("joinType", joinType); // 등록할 회원 유형 구분
		return "member/join";
	}
	
	@PostMapping("/join")
	@ResponseBody
	public void join(MemberVO member, MultipartHttpServletRequest multi){
		// 이미지 등록 및 이미지 이름 받아오기
		String imageName = addImageReturnImageName(multi.getFile("imageFile"));
		// member 객체에 이미지 정보 등록
		member.setMemImage(imageName);
		// member 등록
		memberService.insertMember(member);
	}
	
	@PostMapping("/checkEmail")
	@ResponseBody
	public String checkEmail(String email) {
		if (memberService.selectEmailByMember(email) == null) { // 중복된 이메일이 없을 시
			String certifyCode = getCertifyCode(6); // 인증 코드 발급
			
//			certifiedEmail(email, certifyCode); // 메일 보내기
			
			return certifyCode; // 인증 코드 값 리턴
		} else {
			return "fail"; // 중복된 메일이 있으므로 fail 리턴
		}
		
	}
	
	@PostMapping("/checkPhone")
	@ResponseBody
	public String checkPhone(String phone) {
		if (memberService.selectPhoneByMember(phone) == null) { // 중복된 연락처가 없을 경우
			String certifyCode = getCertifyCode(6); // 인증 코드 발급
			
//			certifiedPhoneNumber(phone, certifyCode); // 인증 코드 문자 발송
			
			return certifyCode; // 인증 코드 값 리턴
		} else {
			return "fail";  // 중복된 연락처가 있으므로 fail 리턴
		}
		
	}
	
	// 확인을 위한 임시 코드 생성
	public String getCertifyCode(int num) {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder code = new StringBuilder();
		
		for (int i = 0; i < num; i++) {
			code.append(str.charAt(new SecureRandom().nextInt(str.length())));
		}
		
		return code.toString();
	}
	
	// 이미지 업로드 기능
	public String addImageReturnImageName(MultipartFile file) {
		// 첨부파일이 저장될 위치 지정
		String uploadPath = "C:\\Git\\workspaceSTS\\TEAM_PRJ\\src\\main\\webapp\\resources\\images\\";
		
		// 첨부파일명
		String attachedFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		
		// 파일 업로드
		// 매개변수로 경로 및 파일명을 넣어줌
		try {
			// 서버에 파일 업로드
			file.transferTo(new File(uploadPath + attachedFileName));
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return attachedFileName;
	}
	
	// 메일 보내기 기능
//	public void certifiedEmail(String email, String code) {
//		try {
//			MimeMessage  message = mailSender.createMimeMessage();
//			MimeMessageHelper msgHelper = new MimeMessageHelper(message, true, "UTF-8");
//			msgHelper.setFrom("운영자 <mitasoar@gmail.com>"); // 메일 발신 계정
//			msgHelper.setTo(email); // 메일 수신 계정
//			msgHelper.setSubject("[테스트] 확인을 위한 코드 발송 메일입니다."); // 메일 제목
//			msgHelper.setText("[테스트] 이메일 확인 코드는 '" + code + "' 입니다."); // 메일 내용
//
//			mailSender.send(message); // 메일 발송
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//	}
	
	// 문자 보내기 기능
//	public void certifiedPhoneNumber(String phoneNumber, String code) {
//		String api_key = ""; //위에서 받은 api key를 추가
//	    String api_secret = "";  //위에서 받은 api secret를 추가
//	    Message coolsms = new Message(api_key, api_secret);
//	    
//	    HashMap<String, String> params = new HashMap<String, String>();
//	    params.put("to", phoneNumber); // 수신번호 등록
//	    params.put("from", ""); // 발신번호 등록
//	    params.put("type", "SMS"); // 문자 유형 등록
//	    params.put("text", "휴대폰 인증 테스트 메시지 : 인증번호는 " + "[" + code + "] 입니다."); // 문자 내용 등록
//	    params.put("app_version", "test app 1.2"); // 버전 등록
//	    
//	    try {
//	    	JSONObject obj = (JSONObject)coolsms.send(params);
//	    	System.out.println(obj.toString());
//	    } catch (CoolsmsException e) {
//	    	System.out.println(e.getMessage());
//	    	System.out.println(e.getCode());
//	    }
//	}
		
}

