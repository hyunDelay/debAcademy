package com.kh.app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.app.jdbc.JDBCTemplate;
import com.kh.app.service.MemberService;
import com.kh.app.vo.MemberVo;

public class MemberController {
	
	// 필드 (멤버변수)
	private final Scanner sc;
	private final MemberService ms;
	
	// 기본 생성자
	public MemberController() {
		sc = new Scanner(System.in);
		ms = new MemberService();
	}

	// 메뉴 선택
	public void selectMenu() {
		System.out.println("===================");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 회원 목록 조회");
		System.out.println("===================");
		
		String num = sc.nextLine();
		switch(num) {
		case "1" : join(); break;
		case "2" : login(); break;
		case "3" : printMemberList(); break;
		default : System.out.println("그런 메뉴 없음");
		}
	}
	
	// 회원가입
	public void join() {
		// 데이터 입력받기 
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");		
		String userPwd = sc.nextLine();
		
		MemberVo vo = new MemberVo();
		vo.setId(userId);
		vo.setPwd(userPwd);
		
		// 서비스
		try {
			int result = ms.join(vo);
			
			// 결과 처리
			if(result == 1) {
				System.out.println("회원가입 성공!!");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.err.println("회원가입 실패...");
			e.printStackTrace();
		}
		
	}

	// 로그인
	public void login() {
		// 데이터 준비
		System.out.println("아이디 : ");
		String userId = sc.nextLine();
		System.out.println("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		MemberVo vo = new MemberVo();
		vo.setId(userId);
		vo.setPwd(userPwd);
		
		// 서비스 호출
		try {
			MemberVo dbVo = ms.login(vo);
			
			// result
			if(dbVo != null) {
				System.out.println("로그인 성공 !!!");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.err.println("로그인 실패...");
			e.printStackTrace();
		}
	}
	
	// 전체회원조회
	public void printMemberList() {
		System.out.println("----- 전체 회원 조회 -----");
		
		// 데이터 준비
		
		// 서비스 호출
		ArrayList<MemberVo> voList = null;
		try {
			voList = ms.getMemberList();
			
			// 결과 처리
			for(MemberVo vo : voList) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			System.err.println("회원 목록 조회 실패");
			e.printStackTrace();
		}
		
		
		/*
		for(int i = 0; i < voList.size(); ++i) {
			System.out.println(voList.get(i));
		}
		*/
		
		
	}
	
}
