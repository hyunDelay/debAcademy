package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main3 {
	
	public static void main(String[] args) {
		// 여러개의 객체를 관리할 컬렙션
		Set<User> s = new HashSet<User>();
		// 유저 객체 여러개 만들고, 위에서 만든 컬렉션에 담기
		User a = new User("user01", "1111");
		User b = new User("user02", "2222");
		User c = new User("user03", "3333");
		
		s.add(a);
		s.add(b);
		s.add(c);
		
		// 여러개의 객체 전부 다 출력 (모든 필드 값)
		System.out.println(s);
		for(User elem : s) {
			System.out.println("아이디 : " + elem.getId());
			System.out.println("비밀번호 : " + elem.getPwd());
		}
		// 여러개의 객체 전부 다 출력 (객체의 name 필드만 출력)
		// 여러개의 객체 전부 다 출력 (객체의 price 필드만 출력)
	}
	
	
}
