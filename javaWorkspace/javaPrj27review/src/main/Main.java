package main;

import data.Person;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("복습");
		
		Person p = new Person();
		p.setName("심원용");
		p.setAge(20);
		p.setGender('M');
		
		System.out.println(p.getName() + "은 나이가 " + p.getAge() + "살이고 성별은 " + p.getGender() + "이다.");
		String str = p.getFieldInfo();
		System.out.println(str);
		
	}

}
