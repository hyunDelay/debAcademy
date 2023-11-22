package com.kh.app.member.vo;

import java.util.Arrays;

public class MemberVo {
	
	
	private String no;
	private String memberId;
	private String memberPwd;
	private String memberPwd2;
	private String memberNick;
	private String memberPhone;
	private String memberEmail;
	private String memberAddress;
	private String[] memberChk;
	private String hobbyStr;
	private String enrollDate;
	private String modifyDate;
	private String status;
	
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVo(String no, String memberId, String memberPwd, String memberPwd2, String memberNick,
			String memberPhone, String memberEmail, String memberAddress, String[] memberChk, String hobbyStr,
			String enrollDate, String modifyDate, String status) {
		super();
		this.no = no;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberPwd2 = memberPwd2;
		this.memberNick = memberNick;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
		this.memberChk = memberChk;
		this.hobbyStr = hobbyStr;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberPwd2() {
		return memberPwd2;
	}

	public void setMemberPwd2(String memberPwd2) {
		this.memberPwd2 = memberPwd2;
	}

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String[] getMemberChk() {
		return memberChk;
	}

	public void setMemberChk(String[] memberChk) {
		this.memberChk = memberChk;
		this.hobbyStr = String.join(", ", memberChk);
	}

	public String getHobbyStr() {
		return hobbyStr;
	}

	public void setHobbyStr(String hobbyStr) {
		this.hobbyStr = hobbyStr;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberPwd2="
				+ memberPwd2 + ", memberNick=" + memberNick + ", memberPhone=" + memberPhone + ", memberEmail="
				+ memberEmail + ", memberAddress=" + memberAddress + ", memberChk=" + Arrays.toString(memberChk)
				+ ", hobbyStr=" + hobbyStr + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status="
				+ status + "]";
	}

	
}
