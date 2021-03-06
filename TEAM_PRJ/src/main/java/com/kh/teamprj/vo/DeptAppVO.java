package com.kh.teamprj.vo;

public class DeptAppVO {
	private String deptAppNo;
	private String stuNo;
	private String applyType;
	private String applyDate;
	private String originalColl;
	private String originalCollName;
	private String originalDept;
	private String originalDeptName;
	private String oriDeptProcessStatus;
	private String oriDeptProcessDate;
	private String applyColl;
	private String applyCollName;
	private String applyDept;
	private String applyDeptName;
	private String appDeptProcessStatus;
	private String appDeptProcessDate;
	private String semNo;
	private SemesterVO semesterVO;
	private StudentVO studentVO;
	private MemberVO memberVO;
	
	public String getDeptAppNo() {
		return deptAppNo;
	}
	public void setDeptAppNo(String deptAppNo) {
		this.deptAppNo = deptAppNo;
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
	public String getOriginalColl() {
		return originalColl;
	}
	public void setOriginalColl(String originalColl) {
		this.originalColl = originalColl;
	}
	public String getOriginalDept() {
		return originalDept;
	}
	public void setOriginalDept(String originalDept) {
		this.originalDept = originalDept;
	}
	public String getOriDeptProcessStatus() {
		return oriDeptProcessStatus;
	}
	public void setOriDeptProcessStatus(String oriDeptProcessStatus) {
		this.oriDeptProcessStatus = oriDeptProcessStatus;
	}
	public String getOriDeptProcessDate() {
		return oriDeptProcessDate;
	}
	public void setOriDeptProcessDate(String oriDeptProcessDate) {
		this.oriDeptProcessDate = oriDeptProcessDate;
	}
	public String getApplyColl() {
		return applyColl;
	}
	public void setApplyColl(String applyColl) {
		this.applyColl = applyColl;
	}
	public String getApplyDept() {
		return applyDept;
	}
	public void setApplyDept(String applyDept) {
		this.applyDept = applyDept;
	}
	public String getAppDeptProcessStatus() {
		return appDeptProcessStatus;
	}
	public void setAppDeptProcessStatus(String appDeptProcessStatus) {
		this.appDeptProcessStatus = appDeptProcessStatus;
	}
	public String getAppDeptProcessDate() {
		return appDeptProcessDate;
	}
	public void setAppDeptProcessDate(String appDeptProcessDate) {
		this.appDeptProcessDate = appDeptProcessDate;
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
	public String getApplyCollName() {
		return applyCollName;
	}
	public void setApplyCollName(String applyCollName) {
		this.applyCollName = applyCollName;
	}
	public String getApplyDeptName() {
		return applyDeptName;
	}
	public void setApplyDeptName(String applyDeptName) {
		this.applyDeptName = applyDeptName;
	}
	public String getOriginalCollName() {
		return originalCollName;
	}
	public void setOriginalCollName(String originalCollName) {
		this.originalCollName = originalCollName;
	}
	public String getOriginalDeptName() {
		return originalDeptName;
	}
	public void setOriginalDeptName(String originalDeptName) {
		this.originalDeptName = originalDeptName;
	}
	@Override
	public String toString() {
		return "DeptAppVO [deptAppNo=" + deptAppNo + ", stuNo=" + stuNo + ", applyType=" + applyType + ", applyDate="
				+ applyDate + ", originalColl=" + originalColl + ", originalDept=" + originalDept
				+ ", oriDeptProcessStatus=" + oriDeptProcessStatus + ", oriDeptProcessDate=" + oriDeptProcessDate
				+ ", applyColl=" + applyColl + ", applyCollName=" + applyCollName + ", applyDept=" + applyDept
				+ ", applyDeptName=" + applyDeptName + ", appDeptProcessStatus=" + appDeptProcessStatus
				+ ", appDeptProcessDate=" + appDeptProcessDate + ", semNo=" + semNo + ", semesterVO=" + semesterVO
				+ ", studentVO=" + studentVO + ", memberVO=" + memberVO + "]";
	}
}
