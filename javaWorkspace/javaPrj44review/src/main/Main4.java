package main;

import java.util.Stack;

public class Main4 {

	public static void main(String[] args) {

		// 여러개의 객체를 관리할 컬렙션
		Stack<User> s = new Stack<User>();
		// 유저 객체 여러개 만들고, 위에서 만든 컬렉션에 담기
		User u1 = new User("user01", "1234");
		User u2 = new User("user02", "1234");
		User u3 = new User("user03", "1234");
		
		s.add(u1);
		s.add(u2);
		s.add(u3);
		// 여러개의 객체 전부 다 출력 (모든 필드 값)
		System.out.println(s);
		for(User elem : s) {
			System.out.println(elem.getId());
			System.out.println(elem.getPwd());
		}
	}

}
