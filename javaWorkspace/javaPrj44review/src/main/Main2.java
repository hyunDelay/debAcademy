package main;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		
		
		// 메뉴 객체 여러개 만들기
		List<User> al = new ArrayList<User>();
		
		// 유저 객체 여러개 만들고, 위에서 만든 컬렉션에 담기
		User a = new User("user01", "userPassword01");
		User b = new User("user02", "userPassword02");
		User c = new User("user03", "userPassword03");
		al.add(a);
		al.add(b);
		al.add(c);
		
		// 여러개의 객체 전부 다 출력 (모든 필드 값)
		for(User e : al) {
			System.out.println(e.getId());
			System.out.println(e.getPwd());
		}
		// 향상된 포문
		// 인덱스가 생략됏네.. arrayList 에만 적용되나?
		/*
		for(int i = 0; i < al.size(); i++) {
			User alArr = al.get(i);
			System.out.println("[ID] " + alArr.getId());
			System.out.println("[PW] " + alArr.getPwd());
		}
		*/
		
	}

}
