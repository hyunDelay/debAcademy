package main;

import java.util.HashMap;
import java.util.Scanner;

import data.Member;

public class MemberManager {
	
	// 멤버 변수
	private Scanner sc = new Scanner(System.in);
	private HashMap<String, Member> memberMap = new HashMap<String, Member>();

	// 일 시작
	public void startWork() {
		// 메뉴 보여주기
		showMenu();
		
		// 입력받기
		String input = scanUserString();
		
		switch(input) {
		case "1" : join(); break;
		case "2" : login(); break;
		default: System.err.println("잘못 입력하셨습니다.");
		}
		
	};
	
	// 메뉴 보여주기
	private void showMenu() {
		System.out.println("========================");
		System.out.println("원하시는 메뉴 번호를 입력하세요.");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("========================");
	}
	
	// 입력받기
	private String scanUserString() {
		return sc.nextLine();
	}
	
	// 회원가입
	private void join() {
		System.out.println("===== 회원가입 ======");
		
		System.out.println("아이디를 입력해주세요.");
		String id = scanUserString();
		
		System.out.println("비밀번호를 입력해주세요.");
		String pwd = scanUserString();
		
		System.out.println("닉네임을 설정해주세요");
		String nick = scanUserString();
		
		Member m = new Member(id, pwd, nick);
		
		// 회원가입 검증
		try {
			checkValidation(m);			
		} catch(Exception e) {
			
		}
		
		// 멤버 객체 데이터 저장하기
		memberMap.put(m.getId(), m);
		
		System.out.println(m.getNick() + "님 회원가입 완료되었습니다!");
	}
	
	private void checkValidation(Member m) throws Exception {
		
		// 아이디 검사
		checkId(m.getId());
		
		// 비밀번호 검사
		checkPwd(m.getPwd());
		
		// 닉네임 검사
		checkNick(m.getNick());
	}

	private void checkNick(String nick) {
		
	}

	private void checkPwd(String pwd) {
		
	}

	private void checkId(String id) throws Exception {
		if(id.length() < 4) {
			throw new Exception("아이디가 너무 짧습니다.");
		}
	}

	// 로그인
	private void login() {
		System.out.println("===== 로그인 =====");
		System.out.print("아이디 : ");
		String userId = scanUserString();
		System.out.print("비밀번호 : ");
		String userPwd = scanUserString();
		
		Member x = memberMap.get(userId);
		boolean result = userId.equals(x.getId()) && userPwd.equals(x.getId());
		if(result) {
			System.out.println(x.getNick() + "님 환영합니다!");
		} else {
			System.err.println("로그인 실패");
		}
	}
	
}
