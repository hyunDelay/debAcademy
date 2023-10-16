package main;

import java.io.File;
import java.util.Scanner;

import menu.MemberManager;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===============================");
		System.out.println("             가계부");
		System.out.println("===============================");
		
		while(true) {
			try {
				MemberManager memberManager = new MemberManager();
				memberManager.showMenu();
			} catch (Exception e) {
				String errorMsg = e.getMessage();
				System.err.println(errorMsg);
				System.err.println("ERROR! 처음메뉴로 돌아갑니다.");
			}
		}
		
	}

}
