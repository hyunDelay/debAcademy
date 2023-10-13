package main;

import java.util.ArrayList;
import java.util.List;

import emp.CounterEmp;
import menu.Burger;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("복습");
		
		List<Burger> burgerList = new ArrayList<Burger>();

		burgerList.add(new Burger("콰트로치즈버거", 5800));
		burgerList.add(new Burger("불고기버거", 7800));
		burgerList.add(new Burger("맥스파이시버거", 6800));
		burgerList.add(new Burger("불고기버거", 7800));
		burgerList.add(new Burger("맥스파이시버거", 6800));
		burgerList.add(new Burger("불고기버거", 7800));
		burgerList.add(new Burger("맥스파이시버거", 6800));
		
		System.out.println("메인 메소드에서 버거 리스트 출력");
		System.out.println(burgerList);
		
		// 버거 메뉴출력
		CounterEmp cemp = new CounterEmp();
		cemp.showBurgerMenu(burgerList);

		System.out.println("메인 메소드에서 버거 리스트 출력");
		System.out.println(burgerList);
	}

}
