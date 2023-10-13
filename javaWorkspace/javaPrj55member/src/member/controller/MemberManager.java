package member.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MemberManager {
	
	// 멤버변수
	private Scanner sc;
	private File f; // 파일
	private PrintWriter pw; // 
	private BufferedReader br;
	
	public MemberManager() throws Exception {
		sc = new Scanner(System.in);
		String x = File.separator;
		f = new File("F:" + x + "data.txt");
		pw = new PrintWriter(new FileWriter(f, true), true);
	}

	// 메뉴 선택
	public void showMenu() throws Exception {
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 전체 회원 조회");
		System.out.println("===============");
		
		String menu = sc.nextLine();
		
		switch(menu) {
		case "1" : join(); break;
		case "2" : login(); break;
		case "3" : selectAllUser(); break;
		default: System.err.println("잘못 입력하셨습니다."); break;
		}
	}
	
	// 회원가입
	private void join() throws Exception {
		// 유저한테 데이터 입력받기
		System.out.println("===== 회원가입 =====");
		
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		System.out.print("닉네임 : ");
		String nick = sc.nextLine();
		
		// 데이터 검사
		boolean isError = id.contains("#") || pwd.contains("#") || nick.contains("#");
		if(isError) {
			throw new Exception("아이디/패스워드/닉네임에는 #을 사용할 수 없습니다.");
		}
		
		// 파일(메모장)에 저장하기
		pw.println(id + "#" + pwd + "#" + nick);
		
		System.out.println("회원가입이 완료되었습니다!");
	}
	
	// 로그인
	private void login() throws Exception {
		br = new BufferedReader(new FileReader(f));
		System.out.println("===== 로그인 =====");
		// 유저한테 데이터(아이디, 비밀번호) 입력받기
		System.out.print("아이디 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		boolean isOk = false;
		while(true) {
			// 파일에서 회원정보 조회
			String str = br.readLine();
			if(str == null) {break;}
			
			// 회원정보에서 id, pwd 만 꺼내기
			int idx = str.indexOf("#");
			String memoId = str.substring(0, idx); // 앞자리는 포함, 뒷자리는 미만으로 처리됨 /첫번째 #위치
			
			int idx2 = str.lastIndexOf("#");
			String memoPwd = str.substring(idx + 1, idx2);
			
			// 일치 여부 확인
			isOk = id.equals(memoId) && pwd.equals(memoPwd);
			if(isOk) {break;}
		}
		if(isOk) {
			System.out.println("로그인 성공!");
		} else {
			System.err.println("로그인 실패");
		}
	}
	
	// 모든 회원 정보 조회
	private void selectAllUser() throws Exception {
		br = new BufferedReader(new FileReader(f));
		// 파일에서 모든 정보 읽기
		while(true) {
			String str = br.readLine();
			if(str == null) {break;}
			System.out.println(str);			
		}
	}
	
}
