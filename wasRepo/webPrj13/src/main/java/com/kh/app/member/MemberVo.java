package com.kh.app.member;

public class MemberVo {

	private String memberId;
	private String memberPwd1;
	private String memberPwd2;
	private String memberNick;
	
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String memberId, String memberPwd1, String memberPwd2, String memberNick) {
		super();
		this.memberId = memberId;
		this.memberPwd1 = memberPwd1;
		this.memberPwd2 = memberPwd2;
		this.memberNick = memberNick;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd1() {
		return memberPwd1;
	}
	public void setMemberPwd1(String memberPwd1) {
		this.memberPwd1 = memberPwd1;
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
	
	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberPwd1=" + memberPwd1 + ", memberPwd2=" + memberPwd2
				+ ", memberNick=" + memberNick + "]";
	}
	
}
