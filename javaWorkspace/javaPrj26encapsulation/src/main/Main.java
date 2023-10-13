package main;

import data.Person;
import data.Pokemon;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("====== 포켓몬 ======");
		
//		Person p1 = new Person();
//		p1.setName("홍길동");
//		p1.setAge(26);
////		p1.name = "홍길동";
////		p1.age = 20;
//		
//		System.out.println(p1.getName());
//		System.out.println(p1.getAge());
//		
//		// 1년 후
//		System.out.println();

		Pokemon p = new Pokemon();
		
		p.setName("파이리");
		p.setHp(100);
		p.setAtk(30);

		String s = p.toString();
		System.out.println(s);
		
		
	}

}
