package com.kh.mini.main;

import java.util.Scanner;

import com.kh.jdbc.JDBCTemplate;
import com.kh.mini.board.controller.BoardController;
import com.kh.mini.member.controller.MemberController;

public class Main {

	public static final Scanner SC = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("===== 미니프로젝트 =====");
		
		// 객체
		MemberController mc = new MemberController();
		BoardController bc = new BoardController();
		
		while(true) {
			// 메뉴판
			System.out.println("1. MEMBER");
			System.out.println("2. BOARD");
			System.out.println("9. 프로그램 종료");

			// 메뉴선택
			String num = Main.SC.nextLine();
			switch(num) {
			case "1" : mc.selectMenu(); break;
			case "2" : System.out.println("미구현"); break;
			case "9" : System.out.println("프로그램 종료"); return;
//			case "2" : bc.selectMenu(); break;
			default : System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}

}
