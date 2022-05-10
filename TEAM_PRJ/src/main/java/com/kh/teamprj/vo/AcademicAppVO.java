package com.kh.teamprj.vo;

public class AcademicAppVO {
	private String appNo;
	private String stuNo;
	private String applyType;
	private String applyDate;
	private String profProcessDate;
	private String profProcessStatus;
	private String adminProcessDate;
	private String adminProcessStatus;
	private String semNo;
	private SemesterVO semesterVO;
	private StudentVO studentVO;
	private MemberVO memberVO;
	
	public String getAppNo() {
		return appNo;
	}
	public void setAppNo(String applyNo) {
		this.appNo = applyNo;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getApplyType() {
		return applyType;
	}
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getSemNo() {
		return semNo;
	}
	public void setSemNo(String semNo) {
		this.semNo = semNo;
	}
	public SemesterVO getSemesterVO() {
		return semesterVO;
	}
	public void setSemesterVO(SemesterVO semesterVO) {
		this.semesterVO = semesterVO;
	}
	public String getProfProcessDate() {
		return profProcessDate;
	}
	public void setProfProcessDate(String profProcessDate) {
		this.profProcessDate = profProcessDate;
	}
	public String getProfProcessStatus() {
		return profProcessStatus;
	}
	public void setProfProcessStatus(String profProcessStatus) {
		this.profProcessStatus = profProcessStatus;
	}
	public String getAdminProcessDate() {
		return adminProcessDate;
	}
	public void setAdminProcessDate(String adminProcessDate) {
		this.adminProcessDate = adminProcessDate;
	}
	public String getAdminProcessStatus() {
		return adminProcessStatus;
	}
	public void setAdminProcessStatus(String adminProcessStatus) {
		this.adminProcessStatus = adminProcessStatus;
	}
	public StudentVO getStudentVO() {
		return studentVO;
	}
	public void setStudentVO(StudentVO studentVO) {
		this.studentVO = studentVO;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	
	
}
