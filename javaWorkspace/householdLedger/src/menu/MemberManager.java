package menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MemberManager {
	
	// 멤버변수
	private Scanner sc;
	private File file; // 파일
	private PrintWriter printWriter; // 텍스트 출력 스트림
	private BufferedReader bufferedReader; // 텍스트 읽어오기 스트림

	// 생성자
	public MemberManager() throws Exception {
		sc = new Scanner(System.in);
		// separator : OS마다 다른 \\
		String x = File.separator;
		file = new File("D:" + x + "dev" + x + "academy" + x + "Adata" + x + "userData.txt");
		// = new PrintWriter(FileWriter 객체(파일, 개행여부), auto flush 여부)
		printWriter = new PrintWriter(new FileWriter(file, true), true);
	}
	
	// 메인메뉴 선택
	public void showMenu() throws Exception {
		System.out.println("             Main");
		System.out.println("-------------------------------");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		
		String menu = sc.nextLine();
		
		switch(menu) {
		case "1" : join(); break;
		case "2" : login();break;
		default: System.err.println("잘못 입력하셨습니다."); break;
		}
	}

	// 로그인
	private void login() throws Exception {
		
		bufferedReader = new BufferedReader(new FileReader(file));

		System.out.println("-------------------------------");
		System.out.println("             Login");
		System.out.println("-------------------------------");
		
		// 유저한테 데이터 입력받기
		System.out.print("아이디 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		boolean isOk = false;
		String memoNick = null;
		while(true) {
			// 파일에서 회원정보 조회
			String str = bufferedReader.readLine();
			if(str == null) {break;} // 읽어들인 버퍼드리더 1줄 정보가 null값이면 반복문 중지
			
			// 회원정보에서 id, pwd 만 꺼내기
			int idx = str.indexOf("#");
			// 0부터 idx가 있는 자리까지
			String memoId = str.substring(0, idx); // 앞자리는 포함, 뒷자리는 미만으로 처리됨 /첫번째 #위치
			
			int idx2 = str.lastIndexOf("#");
			String memoPwd = str.substring(idx + 1, idx2);
			
			int lastIdx = str.lastIndexOf("#");
			memoNick = str.substring(lastIdx + 1);
			
			// 일치 여부 확인
			isOk = id.equals(memoId) && pwd.equals(memoPwd);
			if(isOk) {break;}
		}
		if(isOk) {
			System.out.println("로그인 성공!");
			// 로그인 성공시 가계부 메뉴 보여줌
			MoneyManager moneyManager = new MoneyManager();
			while(true) {
				moneyManager.showMoneyMenu(id, memoNick);
			}
		} else {
			System.err.println("로그인 실패");
		}
		
	}
	
	// 회원가입
	private void join() throws Exception {
		
		System.out.println("-------------------------------");
		System.out.println("             Join");
		System.out.println("-------------------------------");
		
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
		
		bufferedReader = new BufferedReader(new FileReader(file));
		while(true) {
			// 파일에서 회원정보 조회
			String str = bufferedReader.readLine();
			if(str == null) {break;} // 읽어들인 버퍼드리더 1줄 정보가 null값이면 반복문 중지
			
			// 회원정보에서 id, pwd 만 꺼내기
			int idx = str.indexOf("#");
			// 0부터 idx가 있는 자리까지
			String memoId = str.substring(0, idx);
			
			if(id.equals(memoId)) {
				throw new Exception("이미 사용중인 아이디입니다.");
			}
		}
		
		
		// 파일(메모장)에 저장하기
		printWriter.println(id + "#" + pwd + "#" + nick);
		
		System.out.println("회원가입이 완료되었습니다!");
		
	}
	
}
