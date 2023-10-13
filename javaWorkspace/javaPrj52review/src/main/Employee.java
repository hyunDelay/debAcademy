package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {
	
	// 멤버변수
	private List<Menu> menuList = new ArrayList<Menu>();
	private int totalPrice = 0;

	public void startWork() {
		// 메뉴판 준비	
		prepareMenu();
		
		// 메뉴 보여주기
		showMenu();
		
		// 주문 받기
		order();
		
		// 결제 하기
		pay();
	}
	
	// 메뉴판 준비	
	private void prepareMenu() {
		menuList.add(new Menu("참치김밥", 7500));
		menuList.add(new Menu("멸추김밥", 7000));
		menuList.add(new Menu("그냥김밥", 4000));
		menuList.add(new Menu("김치김밥", 4500));
		menuList.add(new Menu("라면", 4500));
		menuList.add(new Menu("제육덮밥", 8000));
	}
	
	// 메뉴 보여주기
	private void showMenu() {
		for(Menu list : menuList) {
			System.out.println(list);
		}
	}
	
	// 주문 받기
	private void order() {
		System.out.println("원하시는 메뉴 번호를 선택하세요.");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		switch(str) {
		case "1" : totalPrice = 7500; break;
		case "2" : totalPrice = 7000; break;
		case "3" : totalPrice = 4000; break;
		case "4" : totalPrice = 4500; break;
		case "5" : totalPrice = 4500; break;
		case "6" : totalPrice = 8000; break;
		default: System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	// 결제 하기
	private void pay() {
		System.out.println("결제하실 금액은 " + totalPrice + "원입니다.");
	}
}
