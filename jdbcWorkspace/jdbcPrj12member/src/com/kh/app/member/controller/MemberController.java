package com.kh.app.member.controller;

import java.util.Scanner;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

public class MemberController {
	
	// 필드 == 멤버변수
	private final Scanner sc;
	private final MemberService ms;
	
	// 기본생성자
	public MemberController() {
		sc = new Scanner(System.in);
		ms = new MemberService();
	}
	
	// 메뉴선택
	
	// 회원가입
	public void join() {
		
		// 데이터
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		System.out.print("닉네임 : ");
		String nick = sc.nextLine();
		
		MemberVo vo = new MemberVo(id, pwd, nick);
		// 서비스
		try {			
			int result = ms.join(vo);
			// 결과
			if(result == 1) {
				System.out.println("회원가입 성공!");
			} else {
				throw new Exception();
			}
		} catch(Exception e) {
			System.err.println("회원가입 실패..");
			e.printStackTrace();
		}
		
		
		
	}
	
	// 로그인
	public void login() {
		
		// 데이터
		
		// 서비스
		
		// 결과
		
	}
	
	// 전체 회원목록 조회
	public void printMemberList() {
		
		// 데이터
		
		// 서비스
		
		// 결과
		
	}
	
	// 회원탈퇴
	public void quit() {
		
		// 데이터
		System.out.println("----- 회원탈퇴 -----");
		System.out.print("탈퇴할 아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPwd(pwd);
		
		// 서비스
		try {			
			int result = ms.quit(vo);
			// 결과
			if(result == 1) {
				System.out.println("탈퇴되었습니다.");
			} else {
				throw new Exception();
			}
		} catch(Exception e) {
			System.err.println("회원정보가 일치하지 않습니다.");
			e.printStackTrace();
		}
		
	}
	
	// 비밀번호 변경
	public void editPwd() {
		
		// 데이터
		System.out.println("----- 비밀번호 변경 -----");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		System.out.print("새로운 비밀번호 : ");
		String newPwd = sc.nextLine();
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPwd(pwd);
		
		// 서비스
		try {			
			int result = ms.editPwd(vo, newPwd);
			// 결과
			if(result == 1) {
				System.out.println("변경되었습니다.");
			} else {
				throw new Exception();
			}
		} catch(Exception e) {
			System.err.println("회원정보가 일치하지 않습니다.");
			e.printStackTrace();
		}
		
		// 결과
		
	}
	
}
