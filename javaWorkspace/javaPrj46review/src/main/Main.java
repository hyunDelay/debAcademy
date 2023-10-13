package main;

import java.util.ArrayList;
import java.util.List;

import menu.Burger;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 맥도날드 =====");
		
		// 메뉴 준비
		Burger b1 = new Burger("콰트로치즈버거", 5000);
		Burger b2 = new Burger("불고기버거", 6000);
		Burger b3 = new Burger("상하이스파이시버거", 7000);
		
		// 여러 객체 한번에 관리하기
//		Burger[] burgerArr = new Burger[3];
//		burgerArr[0] = b1;
//		burgerArr[1] = b2;
//		burgerArr[2] = b3;
		
		List<Burger> burgerArr = new ArrayList<Burger>();
		burgerArr.add(b1);
		burgerArr.add(b2);
		burgerArr.add(b3);

		// 메뉴 보여주기
//		for(int i = 0; i < burgerArr.length; i++) {
//			System.out.println(burgerArr[i]);
//		}
		for(Burger b : burgerArr) {
			System.out.println(b);
		}
	}

}
