package com.kh.shop.vo;

import java.util.Objects;

public class MemberVO {
	private String memId, memPw, memName, memPhone, memEmail, memAddress, isAdmin, joinDate;
	
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
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

	public String getMemPhone() {
		return memPhone;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemAddress() {
		return memAddress;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone.replace(",", "-");
	}
	
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress.replace(",", "/");
	}

	@Override
	public int hashCode() {
		return Objects.hash(isAdmin, joinDate, memAddress, memEmail, memId, memName, memPhone, memPw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(isAdmin, other.isAdmin) && Objects.equals(joinDate, other.joinDate)
				&& Objects.equals(memAddress, other.memAddress) && Objects.equals(memEmail, other.memEmail)
				&& Objects.equals(memId, other.memId) && Objects.equals(memName, other.memName)
				&& Objects.equals(memPhone, other.memPhone) && Objects.equals(memPw, other.memPw);
	}

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPw=" + memPw + ", memName=" + memName + ", memPhone=" + memPhone
				+ ", memEmail=" + memEmail + ", memAddress=" + memAddress + ", isAdmin=" + isAdmin + ", joinDate="
				+ joinDate + "]";
	}
	
}
