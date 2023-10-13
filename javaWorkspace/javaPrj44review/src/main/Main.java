package main;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		System.out.println("복습 ~");
		System.err.println("에러~");
		
		// 메뉴 객체 여러개 만들기
		List menuArr = new ArrayList();
		menuArr.add(new Menu("아메리카노", 3000)); 
		menuArr.add(new Menu("아메리카노", 3000)); 
		menuArr.add(new Menu("아메리카노", 3000)); 
		menuArr.add(new Menu("아메리카노", 3000)); 
		menuArr.add(new Menu("아메리카노", 3000)); 
		
		// 여러개의 객체를 관리할 변수
		// 여러개의 객체 전부 다 출력 (모든 필드 값)
		// 여러개의 객체 전부 다 출력 (객체의 name 필드만 출력)
		// 여러개의 객체 전부 다 출력 (객체의 price 필드만 출력)
		for(int i = 0; i < menuArr.size(); i++) {
			System.out.println(menuArr.get(i));
			Menu menuName = (Menu)menuArr.get(i);
			System.out.println(menuName.getName());
			Menu menuPrice = (Menu)menuArr.get(i);
			System.out.println(menuName.getPrice() + "원");
		}
		
		
		
	}

}
