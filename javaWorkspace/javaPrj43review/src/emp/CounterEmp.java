package emp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import menu.Menu;

public class CounterEmp {

	// 스캐너
	private final Scanner sc = new Scanner(System.in);
	private List menuList = new ArrayList();
	
	private void showMenu() {
		// 메뉴판 준비
		menuList.add(new Menu("아메리카노", 3000));
		menuList.add(new Menu("카페라떼", 4000));
		menuList.add(new Menu("청포도 에이드", 5000));
		menuList.add(new Menu("달고나 라떼", 6000));
		menuList.add(new Menu("베트남 연유커피", 7000));
		
		// 메뉴판 출력
		for(int i = 0; i < menuList.size(); i++) {
			Menu x = (Menu)menuList.get(i);
			
			System.out.println((i + 1) + ". " + x.getName() + " :: " + x.getPrice() + "원");
		}
		
	}
	
	// 손님 받음
	public void work() {
		
		// 메뉴 보여주기
		showMenu();
		
		// 메뉴 입력받기
		System.out.println("원하시는 메뉴 번호를 입력하세요.");
		int menuNum = scanUserInput();
		
		// 선택한 메뉴 확인시켜주고, 금액 더하기
		printMenu(menuNum);
		
		// 갯수 입력받기
		System.out.println("몇잔 시키시겠습니까?");
		int menuCnt = scanUserInput();
		
		// 결제(금액)
		int totalPrice = 0;
		int price = getMenuPrice(menuNum);
		totalPrice += price * menuCnt;
		System.out.println("총 " + totalPrice + "원 입니다.");
		
	}

	private int getMenuPrice(int menuNum) {
		Menu result = (Menu)menuList.get(menuNum - 1);
		int price = result.getPrice();
		return price;
	}

	private void printMenu(int num) {
		Menu result = (Menu)menuList.get(num - 1);
		System.out.println("선택하신 메뉴이름 [ " + result.getName() + " ]");
		System.out.println("선택하신 메뉴가격 [ " + result.getPrice() + "원 ]");
	}

	// 메뉴 입력받기
	private int scanUserInput() {
		String numStr = sc.nextLine();
		int num = Integer.parseInt(numStr);
		return num;
	}

	
}
