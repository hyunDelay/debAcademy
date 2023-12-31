package com.kh.mini.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.mini.main.Main;
import com.kh.mini.member.service.MemberService;
import com.kh.mini.member.vo.MemberVo;

public class MemberController {
	
	private final MemberService service;
	
	public MemberController() {
		service = new MemberService();
	}
	
	// 메뉴선택
	public void selectMenu() {
		System.out.println("===== MEMBER =====");
		
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 로그아웃");
		System.out.println("4. 회원탈퇴");
		System.out.println("5. 전체회원조회");
		System.out.println("6. 마이페이지");
		
		String num = Main.SC.nextLine();
		switch(num) {
		case "1" : join(); break;
		case "2" : login(); break;
		case "3" : logout(); break;
		case "4" : quit(); break;
		case "5" : memberList(); break;
		case "6" : mypage(); break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	/*
	 * <컨트롤러>
	 * 데이터
	 * 서비스 호출
	 * 결과처리
	 * 
	 * */
	/**
	 * 회원가입
	 * 
	 * 클라이언트로부터 
	 * ID, PWD, NICK을 입력받아서 DB에 저장
	 * INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES (SEQ_MEMBER_NO.NEXTVAL, 아이디, 패스워드, 닉네임);
	 * */
	public void join() {
		
		try {
			
			System.out.println("----- 회원가입 -----");
			
			// 데이터
			System.out.print("아이디 : ");
			String id = Main.SC.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = Main.SC.nextLine();
			System.out.print("닉네임 : ");
			String nick = Main.SC.nextLine();
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setNick(nick);
			
			// 서비스 호출
			int result = service.join(vo);
			
			// 결과처리
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("회원가입 성공!");
			
		} catch(Exception e) {
			System.err.println("회원가입 실패...");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 아이디, 비번 입력받기
	 * DB에서 1개 행 조회
	 * 
	 * SELECT * FROM MEMBER
	 * WHERE ID = 아이디 AND PWD = 패스워드
	 * */
	// 로그인
	public void login() {
		try {
			System.out.println("----- 로그인 ------");
			// 데이터
			System.out.print("아이디 : ");
			String id = Main.SC.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = Main.SC.nextLine();
			
			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);
			
			// 서비스 호출
			MemberVo x = service.login(vo);
			
			// 결과처리
			if(x == null) {
				throw new Exception();
			}
			Main.loginMember = x;
			System.out.println("로그인 성공!");
			System.out.println("닉네임 : " + x.getNick());
			
		} catch(Exception e) {
			System.err.println("로그인 실패...");
			e.printStackTrace();
		}
	}
	
	// 로그아웃
	public void logout() {
		if(Main.loginMember == null) {
			System.err.println("로그인 하고 진행해주세요.");
			return;
		} else {
			System.out.println("로그아웃 되었습니다.");
			Main.loginMember = null;
		}
		
	}
	
	/**
	 * 회원 탈퇴
	 * 
	 * UPDATE MEMBER SET DEL_YN = 'Y', MODIFY_DATE = SYSDATE WHERE NO = ?
	 * 
	 * */
	public void quit() {
		try {
			System.out.println("----- 회원탈퇴 ------");
			
			// 로그인 여부 검사
			if(Main.loginMember == null) {
				throw new Exception("로그인을 하고 회원탈퇴를 시도하세요.");
			}
			
			// 데이터
			String no = Main.loginMember.getNo();
			
			// 서비스
			int result = service.quit(no);
			
			// 결과
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("탈퇴되었습니다.");
			logout();
			
		} catch(Exception e) {
			System.err.println("회원탈퇴 실패");
			e.printStackTrace();
		}
	}
	
	/**
	 * 마이페이지 (현재 로그인한 본인 정보 조회)
	 * */
	public void mypage() {
		
		try {
			System.out.println("----- 마이페이지 -----");
			
			// 로그인 검사
			if(Main.loginMember == null) {
				throw new Exception("로그인이 필요합니다.");
			}
			
			System.out.println("아이디 : " + Main.loginMember.getId());
			System.out.println("패스워드 : " + Main.loginMember.getPwd());
			System.out.println("닉네임 : " + Main.loginMember.getNick());
			System.out.println("가입일시 : " + Main.loginMember.getEnrollDate());
			System.out.println("-----------------------------");
			
			// 정보 변경
			System.out.println("1. 닉네임 변경");
			System.out.println("2. 비밀번호 변경");
			System.out.println("9. 이전으로 돌아가기");
			
			String num = Main.SC.nextLine();
			
			switch(num) {
			case "1" : changeNick(); break;
			case "2" : changePwd(); break;
			case "9" : return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
			
			
			
		} catch(Exception e) {
			System.out.println("마이페이지 조회 실패");
			e.printStackTrace();
		}
		
		
		
	}
	
	/**
	 * 비밀번호 수정
	 * 
	 * UPDATE MEMBER SET PWD = ? WHERE NO = ? AND PWD = ?
	 * */
	public void changePwd() {
		
		try {
			System.out.println("----- 비밀번호 변경 -----");
			
			// 데이터
			System.out.print("기존 비밀번호 : ");
			String oldPwd = Main.SC.nextLine();
			System.out.print("신규 비밀번호 : ");
			String newPwd = Main.SC.nextLine();
			String loginMemberNo = Main.loginMember.getNo();
			
			Map<String, String> m = new HashMap<String, String>();
			m.put("newPwd", newPwd);
			m.put("loginMemberNo", loginMemberNo);
			m.put("oldPwd", oldPwd);
			
			// 서비스
			int result = service.changePwd(m);
			
			// 결과
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("비밀번호 변경 성공");
			logout();
			
		} catch(Exception e) {
			System.out.println("비밀번호 변경 실패");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 닉네임 수정
	 * 
	 * UPDATE MEMBER SET NICK = ? WHERE NO = ?
	 * */
	public void changeNick() {
		try {
			System.out.println("--- 닉네임 변경 ---");
			
			// 데이터
			System.out.print("변경할 닉네임 : ");
			String newNick = Main.SC.nextLine();
			
			MemberVo vo = new MemberVo();
			vo.setNick(newNick);
			vo.setNo(Main.loginMember.getNo());
			
			// 서비스
			int result = service.changeNick(vo);
			
			// 결과
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("닉네임 변경 성공");
			logout(); // Main.loginMember 값을 다시 할당하기 위해서
			
		} catch(Exception e) {
			System.out.println("닉네임 변경 실패");
			e.printStackTrace();
		}
	}

	/**
	 * 전체 회원 조회 (관리자만 가능)
	 * 
	 * SELECT ID, NICK, ENROLL_DATE, MODIFY_DATE, DEL_YN FROM MEMBER
	 * 
	 * 
	 * */
	public void memberList() {
		
		try {
			
			System.out.println("----- 전체 회원 조회 ------");
			
			// 관리자 체크
			if(!Main.loginMember.getNo().equals("1")) {
				throw new Exception("관리자만 접근 가능합니다.");
			}
			
			// 데이터
			
			// 서비스
			List<MemberVo> voList = service.memberList();
			
			// 결과
			for(MemberVo vo : voList) {
				System.out.print(vo.getId() + " ┃ ");
				System.out.print(vo.getNick() + " ┃ ");
				System.out.print(vo.getEnrollDate() + " ┃ ");
				System.out.print(vo.getModifyDate() + " ┃ ");
				System.out.print(vo.getDelYn());
				System.out.println();
			}
			
		} catch(Exception e) {
			System.out.println("전체 회원 목록 조회 실패");
			e.printStackTrace();
		}
		
	}
	
	// 회원 조회 - 번호 (관리자만 가능)
	// 회원 조회 - 아이디 (관리자만 가능)
	// 회원 조회 - 닉네임 (관리자만 가능)
	// 회원 강제탈퇴 (관리자만 가능)
	
	
}
