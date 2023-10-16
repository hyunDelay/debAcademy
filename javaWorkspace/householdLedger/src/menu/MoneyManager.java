package menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MoneyManager {
	
	// 멤버변수
	private Scanner sc;
	private File file; // 파일
	private PrintWriter printWriter; // 텍스트 출력 스트림
	private BufferedReader bufferedReader; // 텍스트 읽어오기 스트림
	private int budget = 0; // 예산
	private int budgetplus = 0; // 수입
	private int budgetminus = 0; // 지출
	
	public MoneyManager() throws Exception {
		sc = new Scanner(System.in);
		// separator : OS마다 다른 \\
		String x = File.separator;
		file = new File("D:" + x + "dev" + x + "academy" + x + "Adata" + x + "moneyData.txt");
		// = new PrintWriter(FileWriter 객체(파일, 개행여부), auto flush 여부)
		printWriter = new PrintWriter(new FileWriter(file, true), true);
		
	}

	// 가계부 메뉴 선택
	public void showMoneyMenu(String id, String nick) throws Exception {

		// 파일에서 정보 조회
		bufferedReader = new BufferedReader(new FileReader(file));
		
		while(true) {
			String str = bufferedReader.readLine();
			if(str == null) {break;}
			
			// 정보에서 수입/금액/이유 꺼내기
			int idx01 = str.indexOf("#");
			String data01 = str.substring(0, idx01); // id값 꺼내기
			
			int idx05 = str.lastIndexOf("#");
			String data05 = str.substring(idx05 + 1); // 총 금액 꺼내기
			
			if(id.equals(data01)) {
				budget = Integer.parseInt(data05);
			}
		}
		
		System.out.println(nick + "님 환영합니다!");
		System.out.println("현재 자산 :: " + budget + "원");
		System.out.println("-------------------------------");
		System.out.println("1. 수입 등록");
		System.out.println("2. 지출 등록");
		System.out.println("3. 내역 확인");
		System.out.println("4. 로그아웃");
		System.out.println("-------------------------------");
		
		String menu = sc.nextLine();
		
		switch(menu) {
		case "1" : budget(id); break;
		case "2" : income(id); break;
		case "3" : paymentDetails(id); break;
		case "4" : logout(id); break;
		default: System.err.println("잘못 입력하셨습니다."); break;
		}
	}

	// 수입등록
	private void budget(String id) {
		// 유저입력
		System.out.println("수입입력 : ");
		String budgetStr = sc.nextLine();
		budgetplus += Integer.parseInt(budgetStr);
		
		// 수입 이유
		System.out.println("수입경로를 입력해주세요.");
		System.out.println("1. 월급  2. 용돈  3. 우연히 발견한 돈  4. 직접입력");
		String reason = sc.nextLine();
		String reason01 = "월급";
		String reason02 = "용돈";
		String reason03 = "우연히 발견한 돈";
		switch(reason) {
		case "1" : reason = reason01; break;
		case "2" : reason = reason02; break;
		case "3" : reason = reason03; break;
		case "4" : 
			System.out.println("직접 입력하세요.");
			reason = sc.nextLine(); break;
		default: reason = "기타"; break;
		}
		
		// 파일(메모장)에 저장하기
		budget += budgetplus;
		printWriter.println(id + "#" + "[수입]" + "#" + budgetplus + "#" + reason + "#" + budget);
	}
	
	// 지출등록
	private void income(String id) throws Exception {
		// 유저입력
		System.out.println("지출입력 : ");
		String budgetStr = sc.nextLine();
		budgetminus -= Integer.parseInt(budgetStr);
		
		// 지출 이유
		System.out.println("수입경로를 입력해주세요.");
		System.out.println("1. 식비  2. 교통비  3. 쇼핑  4. 직접입력");
		String reason = sc.nextLine();
		String reason01 = "식비";
		String reason02 = "교통비";
		String reason03 = "쇼핑";
		switch(reason) {
		case "1" : reason = reason01; break;
		case "2" : reason = reason02; break;
		case "3" : reason = reason03; break;
		case "4" : 
			System.out.println("직접 입력하세요.");
			reason = sc.nextLine(); break;
		default: reason = "기타"; break;
		}
		
		// 데이터 검사
		boolean isError = reason.contains("#");
		if(isError) {
			throw new Exception("#는 입력할 수 없습니다.");
		}
		// 파일(메모장)에 저장하기
		budget += budgetminus;
		printWriter.println(id + "#" + "[지출]" + "#" + budgetminus + "#" + reason + "#" + budget);
	}
	
	// 내역확인
	private void paymentDetails(String id) throws Exception {
		
		bufferedReader = new BufferedReader(new FileReader(file));

		System.out.println("-------------------------------");
		System.out.println("            내역확인");
		System.out.println("-------------------------------");
		
		// 파일에서 정보 조회
		int result = 0;
		while(true) {
			String str = bufferedReader.readLine();
			if(str == null) {break;}
			
			// 정보에서 수입/금액/이유 꺼내기
			int idx01 = str.indexOf("#");
			String data01 = str.substring(0, idx01); // id값 꺼내기
			
			int idx02 = str.indexOf("#", idx01 + 1);
			String data02 = str.substring(idx01 + 1, idx02); // 수입/지출 꺼내기

			int idx03 = str.indexOf("#", idx02 + 1);
			String data03 = str.substring(idx02 + 1, idx03); // 금액 꺼내기

			int idx04 = str.indexOf("#", idx03 + 1);
			String data04 = str.substring(idx03 + 1, idx04); // 이유 꺼내기
			
			int idx05 = str.lastIndexOf("#");
			String data05 = str.substring(idx05 + 1); // 총 금액 꺼내기
			
			if(id.equals(data01)) {
				if(data02.equals("[수입]")) {
					System.out.println(data02 + " " + data03 + "원 " + data04 + " [총 금액 :: " + data05 + "원]");
				} else {
					System.out.println(data02 + " " + data03 + "원 " + data04 + " [총 금액 :: " + data05 + "원]");
				}
				
				result = 1;
			} else {
				result = 0;
			}
		}
		System.out.println("-------------------------------");
		if(result == 0) {
			System.out.println("내역이 없습니다.");
		}
		
	}
	
	// 로그아웃
	private void logout(String id) throws Exception {
		MemberManager memberManager = new MemberManager();
		memberManager.showMenu();
	}
}
