package main;

import java.util.LinkedList;
import java.util.Queue;

public class Main5 {

	public static void main(String[] args) {

		// 여러개의 객체를 관리할 컬렙션
		Queue q = new LinkedList();
		
		User q1 = new User("user01", "1111");
		User q2 = new User("user02", "1111");
		User q3 = new User("user03", "1111");
		// 유저 객체 여러개 만들고, 위에서 만든 컬렉션에 담기
		q.add(q1);
		q.add(q2);
		q.add(q3);
			
		// 여러개의 객체 전부 다 출력 (모든 필드 값)
		System.out.println(q);
	}

}
