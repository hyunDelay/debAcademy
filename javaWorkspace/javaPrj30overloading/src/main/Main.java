package main;

import data.Person;

public class Main {

	public static void main(String[] args) {

		System.out.println("생성자 오버로딩");
		
//		// 생성자를 이용한 객체 준비
//		Person p = new Person("심원용", 20);
//		System.out.println(p.getFieldInfo());
		
		// setter를 이용한 객체 준비
		Person p = new Person();
		p.setAge(33);
		p.setName("심원용");
		System.out.println(p);
		
	}

}
