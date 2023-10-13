package main;

import menu.Burger;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 맥도날드 =====");
		
		Burger burger = new Burger("치즈버거", 5000);
		
		String s = burger.getName();
		System.out.println(s);
		
		int p = burger.getPrice();
		System.out.println(p);

	}

}
