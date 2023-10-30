package com.kh.mini.test;

import com.kh.mini.member.service.MemberService;
import com.kh.mini.member.vo.MemberVo;

public class TestMain {

	public static void main(String[] args) {
		
		testMemberIdDup();
		
		
		
	} // main
	
	public static void testMemberIdDup() {
		try {
			// 회원가입 아이디 중복 테스트
			MemberVo vo = new MemberVo();
			vo.setId("ADMIN");
			vo.setPwd("0000");
			vo.setNick("testNick00");
			int result = new MemberService().join(vo);
			
			if(result == 1) {
				System.out.println("테스트 실패");
			} else {
				throw new Exception();
			}
		} catch(Exception e) {
			System.out.println("테스트 성공");
			//e.printStackTrace();
		}
	}

}
