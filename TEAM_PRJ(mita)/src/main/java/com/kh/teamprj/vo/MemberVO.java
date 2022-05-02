package com.kh.teamprj.vo;

public class MemberVO {
	private String memNo, memPw, memName, memEmail, memAddr, memPhone, memImage, memGender, memBirth, memType, isJoin, createDate, withdrawDate;
	private String memId;
	
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr.replace(",", "/");
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone.replace(",", "-");
	}

	public String getMemImage() {
		return memImage;
	}

	public void setMemImage(String memImage) {
		this.memImage = memImage;
	}

	public String getMemGender() {
		return memGender;
	}

	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}

	public String getMemBirth() {
		return memBirth;
	}

	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
	}

	public String getMemType() {
		return memType;
	}

	public void setMemType(String memType) {
		this.memType = memType;
	}

	public String getIsJoin() {
		return isJoin;
	}

	public void setIsJoin(String isJoin) {
		this.isJoin = isJoin;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getWithdrawDate() {
		return withdrawDate;
	}

	public void setWithdrawDate(String withdrawDate) {
		this.withdrawDate = withdrawDate;
	}

	@Override
	public String toString() {
		return "MemberVO [memNo=" + memNo + ", memPw=" + memPw + ", memName=" + memName + ", memEmail=" + memEmail
				+ ", memAddr=" + memAddr + ", memPhone=" + memPhone + ", memImage=" + memImage + ", memGender="
				+ memGender + ", memBirth=" + memBirth + ", memType=" + memType + ", isJoin=" + isJoin + ", createDate="
				+ createDate + ", withdrawDate=" + withdrawDate + ", memId=" + memId + "]";
	}
	
	
}
