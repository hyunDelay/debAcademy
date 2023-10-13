package main;

import member.controller.MemberManager;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("===== 회원 관리 프로그램 =====");
		MemberManager mm = new MemberManager();
		
		while(true) {
			try {
				mm.showMenu();
			} catch (Exception e) {
				String errorMsg = e.getMessage();
				System.err.println(errorMsg);
				System.out.println("예외 발생... 처음메뉴로 돌아갑니다.");
			}		
		}
		
	}

}
